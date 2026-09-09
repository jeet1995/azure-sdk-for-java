// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.azure.cosmos.Http2ConnectionConfig;
import com.azure.cosmos.implementation.Configs;
import com.azure.cosmos.implementation.http.HttpClient;
import com.azure.cosmos.implementation.http.HttpClientConfig;
import com.azure.cosmos.implementation.http.HttpHeaders;
import com.azure.cosmos.implementation.http.HttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.ReferenceCountUtil;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import reactor.core.publisher.Mono;
import reactor.netty.http.HttpProtocol;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Measures a warm request through the Cosmos Reactor Netty transport against an in-process TLS server.
 *
 * <p>The server and client are created once per trial and one request is issued during setup, so benchmark
 * measurements exclude TCP, TLS, and ALPN connection establishment. The HTTP/2 variant retains the production
 * HTTP/2 configuration, including the PING handler, while isolating service and internet latency.</p>
 */
@Fork(2)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class HttpProtocolLoopbackBenchmark {
    private static final String EXTERNAL_SERVER_ENDPOINT_PROPERTY = "cosmos.jmh.serverEndpoint";

    @Param({ "H1_NATIVE", "H2_NATIVE", "H1_FALLBACK" })
    public String scenario;

    @Param({ "0", "1024" })
    public int responseBodySize;

    @Param({ "1", "4" })
    public int clientMaxConnections;

    @Param({ "4" })
    public int serverWorkerCount;

    @Param({ "100" })
    public int serverMaxConcurrentStreams;

    @Param({ "0" })
    public long serverResponseDelayMicros;

    @Param({ "DEFAULT" })
    public String pendingAcquireMaxCount;

    private MockHttpServer server;
    private HttpClient client;
    private URI requestUri;
    private String previousPendingAcquireMaxCount;

    @Setup(Level.Trial)
    public void setup() throws Exception {
        HttpProtocol serverProtocol = scenario.equals("H2_NATIVE") ? HttpProtocol.H2 : HttpProtocol.HTTP11;
        boolean http2ClientEnabled = !scenario.equals("H1_NATIVE");

        previousPendingAcquireMaxCount = System.getProperty(Configs.HTTP_PENDING_ACQUIRE_MAX_COUNT);
        if ("DEFAULT".equalsIgnoreCase(pendingAcquireMaxCount)) {
            System.clearProperty(Configs.HTTP_PENDING_ACQUIRE_MAX_COUNT);
        } else {
            System.setProperty(Configs.HTTP_PENDING_ACQUIRE_MAX_COUNT, pendingAcquireMaxCount);
        }

        String externalServerEndpoint = System.getProperty(EXTERNAL_SERVER_ENDPOINT_PROPERTY);
        if (externalServerEndpoint == null || externalServerEndpoint.isEmpty()) {
            server = new MockHttpServer(
                serverProtocol,
                responseBodySize,
                serverWorkerCount,
                serverMaxConcurrentStreams,
                serverResponseDelayMicros);
            server.start();
            requestUri = server.endpoint();
        } else {
            requestUri = URI.create(externalServerEndpoint);
        }

        Http2ConnectionConfig http2Config = new Http2ConnectionConfig()
            .setEnabled(http2ClientEnabled)
            .setMinConnectionPoolSize(1)
            .setMaxConnectionPoolSize(clientMaxConnections)
            .setMaxConcurrentStreams(serverMaxConcurrentStreams);

        HttpClientConfig clientConfig = new HttpClientConfig(new Configs())
            .withConnectionPoolName("cosmos-jmh-" + scenario + "-" + requestUri.getPort())
            .withPoolSize(clientMaxConnections)
            .withConnectionAcquireTimeout(Duration.ofSeconds(30))
            .withNetworkRequestTimeout(Duration.ofSeconds(30))
            .withServerCertValidationDisabled(true)
            .withHttp2ConnectionConfig(http2Config);
        client = HttpClient.createFixed(clientConfig);

        executeRequest();
    }

    @TearDown(Level.Trial)
    public void teardown() {
        if (client != null) {
            client.shutdown();
        }
        if (server != null) {
            MockHttpServer.Snapshot snapshot = server.snapshot();
            server.close();
            System.out.println("MOCK_SERVER_STATS scenario=" + scenario
                + ", clientMaxConnections=" + clientMaxConnections
                + ", stats=" + snapshot);
        }
        if (previousPendingAcquireMaxCount == null) {
            System.clearProperty(Configs.HTTP_PENDING_ACQUIRE_MAX_COUNT);
        } else {
            System.setProperty(Configs.HTTP_PENDING_ACQUIRE_MAX_COUNT, previousPendingAcquireMaxCount);
        }
    }

    @Benchmark
    public int warmRequest() {
        return executeRequest();
    }

    private int executeRequest() {
        HttpRequest request = new HttpRequest(
            HttpMethod.GET,
            requestUri,
            requestUri.getPort(),
            new HttpHeaders().set("accept", "application/json"));

        Integer statusCode = client.send(request)
            .flatMap(response -> response.body()
                .doOnNext(ReferenceCountUtil::safeRelease)
                .thenReturn(response.statusCode()))
            .block();

        if (statusCode == null) {
            throw new IllegalStateException("Loopback request completed without a status code.");
        }
        boolean expectedHttp2 = scenario.equals("H2_NATIVE");
        boolean actualHttp2 = request.reactorNettyRequestRecord().isHttp2();
        if (expectedHttp2 != actualHttp2) {
            throw new IllegalStateException(
                "Unexpected negotiated protocol for " + scenario + ": isHttp2=" + actualHttp2);
        }

        return statusCode;
    }
}
