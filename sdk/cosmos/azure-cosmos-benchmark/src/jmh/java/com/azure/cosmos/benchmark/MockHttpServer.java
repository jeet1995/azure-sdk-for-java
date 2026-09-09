// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http2.Http2StreamChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.AttributeKey;
import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.DisposableServer;
import reactor.netty.http.Http2SslContextSpec;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.server.HttpServer;
import reactor.netty.resources.LoopResources;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-process TLS HTTP server for stressing the Cosmos HTTP client without service or internet latency.
 */
final class MockHttpServer implements AutoCloseable {
    private static final AttributeKey<Boolean> COUNTED_PARENT =
        AttributeKey.valueOf("cosmosJmhCountedParent");
    private static final AttributeKey<AtomicLong> PARENT_REQUEST_COUNT =
        AttributeKey.valueOf("cosmosJmhParentRequestCount");

    private final HttpProtocol protocol;
    private final byte[] responseBody;
    private final int workerCount;
    private final long maxConcurrentStreams;
    private final Duration responseDelay;
    private final int port;
    private final AtomicLong totalRequests = new AtomicLong();
    private final AtomicLong openedParentConnections = new AtomicLong();
    private final AtomicLong closedParentConnections = new AtomicLong();
    private final AtomicLong maxRequestsPerParent = new AtomicLong();
    private final AtomicInteger activeParentConnections = new AtomicInteger();
    private final AtomicInteger peakActiveParentConnections = new AtomicInteger();
    private final AtomicInteger activeRequests = new AtomicInteger();
    private final AtomicInteger peakActiveRequests = new AtomicInteger();

    private SelfSignedCertificate certificate;
    private LoopResources loopResources;
    private DisposableServer server;

    MockHttpServer(
        HttpProtocol protocol,
        int responseBodySize,
        int workerCount,
        long maxConcurrentStreams,
        long responseDelayMicros) {

        this(protocol, responseBodySize, workerCount, maxConcurrentStreams, responseDelayMicros, 0);
    }

    MockHttpServer(
        HttpProtocol protocol,
        int responseBodySize,
        int workerCount,
        long maxConcurrentStreams,
        long responseDelayMicros,
        int port) {

        this.protocol = protocol;
        this.responseBody = new byte[responseBodySize];
        this.workerCount = workerCount;
        this.maxConcurrentStreams = maxConcurrentStreams;
        this.responseDelay = Duration.ofNanos(responseDelayMicros * 1000);
        this.port = port;
    }

    void start() throws Exception {
        certificate = new SelfSignedCertificate("localhost");
        SslContext serverSslContext = protocol == HttpProtocol.H2
            ? Http2SslContextSpec.forServer(certificate.certificate(), certificate.privateKey()).sslContext()
            : SslContextBuilder.forServer(certificate.certificate(), certificate.privateKey()).build();

        loopResources = LoopResources.create("cosmos-jmh-server", workerCount, true);

        HttpServer httpServer = HttpServer.create()
            .runOn(loopResources)
            .host("127.0.0.1")
            .port(port)
            .protocol(protocol)
            .secure(ssl -> ssl.sslContext(serverSslContext))
            .doOnConnection(this::registerParentConnection)
            .handle((request, response) -> {
                request.withConnection(this::recordRequest);
                activeRequests.incrementAndGet();
                updatePeak(peakActiveRequests, activeRequests.get());

                Mono<Void> responseMono = responseBody.length == 0
                    ? response.status(HttpResponseStatus.NO_CONTENT).send().then()
                    : response.status(HttpResponseStatus.OK).sendByteArray(Mono.just(responseBody)).then();

                Mono<Void> delayedResponse = responseDelay.isZero()
                    ? responseMono
                    : Mono.delay(responseDelay).then(responseMono);
                return delayedResponse.doFinally(ignored -> activeRequests.decrementAndGet());
            });

        if (protocol == HttpProtocol.H2) {
            httpServer = httpServer.http2Settings(settings -> settings.maxConcurrentStreams(maxConcurrentStreams));
        }

        server = httpServer.bindNow();
    }

    URI endpoint() {
        return URI.create("https://127.0.0.1:" + server.port() + "/benchmark");
    }

    Snapshot snapshot() {
        return new Snapshot(
            totalRequests.get(),
            openedParentConnections.get(),
            closedParentConnections.get(),
            activeParentConnections.get(),
            peakActiveParentConnections.get(),
            activeRequests.get(),
            peakActiveRequests.get(),
            maxRequestsPerParent.get());
    }

    void awaitShutdown() {
        server.onDispose().block();
    }

    @Override
    public void close() {
        if (server != null) {
            server.disposeNow();
        }
        if (loopResources != null) {
            loopResources.disposeLater().block();
        }
        if (certificate != null) {
            certificate.delete();
        }
    }

    private void registerParentConnection(Connection connection) {
        Channel channel = parentChannel(connection.channel());
        if (channel.attr(COUNTED_PARENT).setIfAbsent(Boolean.TRUE) != null) {
            return;
        }

        channel.attr(PARENT_REQUEST_COUNT).set(new AtomicLong());
        openedParentConnections.incrementAndGet();
        int current = activeParentConnections.incrementAndGet();
        updatePeak(peakActiveParentConnections, current);

        channel.closeFuture().addListener(ignored -> {
            closedParentConnections.incrementAndGet();
            activeParentConnections.decrementAndGet();
        });
    }

    private void recordRequest(Connection connection) {
        Channel parent = parentChannel(connection.channel());
        registerParentConnection(Connection.from(parent));
        totalRequests.incrementAndGet();
        AtomicLong requestCount = parent.attr(PARENT_REQUEST_COUNT).get();
        if (requestCount != null) {
            updatePeak(maxRequestsPerParent, requestCount.incrementAndGet());
        }
    }

    private static Channel parentChannel(Channel channel) {
        return channel instanceof Http2StreamChannel && channel.parent() != null
            ? channel.parent()
            : channel;
    }

    private static void updatePeak(AtomicInteger peak, int candidate) {
        int current;
        do {
            current = peak.get();
            if (candidate <= current) {
                return;
            }
        } while (!peak.compareAndSet(current, candidate));
    }

    private static void updatePeak(AtomicLong peak, long candidate) {
        long current;
        do {
            current = peak.get();
            if (candidate <= current) {
                return;
            }
        } while (!peak.compareAndSet(current, candidate));
    }

    static final class Snapshot {
        final long totalRequests;
        final long openedParentConnections;
        final long closedParentConnections;
        final int activeParentConnections;
        final int peakActiveParentConnections;
        final int activeRequests;
        final int peakActiveRequests;
        final long maxRequestsPerParent;

        Snapshot(
            long totalRequests,
            long openedParentConnections,
            long closedParentConnections,
            int activeParentConnections,
            int peakActiveParentConnections,
            int activeRequests,
            int peakActiveRequests,
            long maxRequestsPerParent) {

            this.totalRequests = totalRequests;
            this.openedParentConnections = openedParentConnections;
            this.closedParentConnections = closedParentConnections;
            this.activeParentConnections = activeParentConnections;
            this.peakActiveParentConnections = peakActiveParentConnections;
            this.activeRequests = activeRequests;
            this.peakActiveRequests = peakActiveRequests;
            this.maxRequestsPerParent = maxRequestsPerParent;
        }

        @Override
        public String toString() {
            return "Snapshot{"
                + "totalRequests=" + totalRequests
                + ", openedParentConnections=" + openedParentConnections
                + ", closedParentConnections=" + closedParentConnections
                + ", activeParentConnections=" + activeParentConnections
                + ", peakActiveParentConnections=" + peakActiveParentConnections
                + ", activeRequests=" + activeRequests
                + ", peakActiveRequests=" + peakActiveRequests
                + ", maxRequestsPerParent=" + maxRequestsPerParent
                + '}';
        }
    }
}
