// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation;

import com.azure.cosmos.implementation.http.HttpClient;
import com.azure.cosmos.implementation.http.HttpHeaders;
import com.azure.cosmos.implementation.http.HttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Drives the thin-client HTTP/2 connectivity probe lifecycle using a per-region,
 * one-shot probe-and-cache model.
 *
 * <p>For every thin-client regional endpoint discovered via {@code GlobalEndpointManager}
 * topology refresh, this client issues a {@code POST /connectivity-probe} over the thin-client
 * HTTP/2 {@link HttpClient}. The probe contract is strict:
 * <ul>
 *   <li><b>HTTP 200</b> &rarr; region succeeded.</li>
 *   <li>Any other status (notably 503 when {@code enableConnectivityProbe} is OFF, 400
 *       for wrong path, anything else) &rarr; region failed.</li>
 *   <li>Connection error / TLS failure / HTTP/2 negotiation failure / timeout &rarr; failed.</li>
 * </ul>
 *
 * <p><b>Add-only proven cache (delta probing).</b> A successful probe records its region in an
 * <em>add-only</em> proven set that only ever grows: once a region returns HTTP 200 it is
 * considered proven for the lifetime of the client and is never re-probed &mdash; even if it later
 * vanishes from the topology and subsequently re-appears (matching the .NET permanent-cache
 * semantics). Each cycle only probes the <em>delta</em> &mdash; the currently-known endpoints not
 * yet in the proven set. A failed region is simply left out of the proven set and is naturally
 * re-probed on the next topology refresh; this across-refresh re-probing is the only retry
 * mechanism (there is no in-cycle retry &mdash; each region is attempted exactly once per cycle).
 *
 * <p><b>Routing gate.</b> {@link #isThinClientRoutable()} returns {@code true} only when every
 * endpoint in the most recently observed topology snapshot is present in the add-only proven set.
 * Because the gate is evaluated against the current topology snapshot (not the proven set), a
 * region that vanishes stops gating even though its proven entry is retained. The startup default is
 * <em>conservative</em>: until at least one non-empty topology has been observed and all of
 * its regions have succeeded, the gate is {@code false} and the SDK routes data-plane traffic
 * to Gateway V1. Whether a probe client exists at all is governed solely by the wiring decision
 * (see {@link ThinClientConnectivityConfig#canThinClientBeImplicitlyEnabled()}): it is wired only
 * when thin-client is enabled by default — neither explicitly opted into nor out of — and GATEWAY
 * mode plus HTTP/2 hold. An explicit opt-in/opt-out skips the probe entirely.
 *
 * <p>Routing decisions are made strictly at refresh boundaries; this class does not implement
 * any per-request circuit-breaker. The data-plane routing site
 * ({@link ThinClientConnectivityConfig#shouldUseThinClientStoreModel(boolean, boolean, Boolean, Boolean, RxDocumentServiceRequest)})
 * ANDs the thin-client capability, topology availability, and request eligibility with this gate
 * (surfaced via {@code GlobalEndpointManager.getProxyProbeDecision()} → {@link #isThinClientRoutable()}).
 *
 * <p>This class is internal; it is not part of the published public API.
 */
public class EndpointProbeClient implements Closeable {

    private static final Logger logger = LoggerFactory.getLogger(EndpointProbeClient.class);

    // Fixed proxy-contract path (CosmosDB PR 2107592); not configurable.
    private static final String PROBE_PATH = "/connectivity-probe";

    private final HttpClient httpClient;
    private final Duration perProbeTimeout;

    // Add-only set of thin-client regional endpoints that have recorded a successful (HTTP 200)
    // probe. This set only ever grows: once a region is proven reachable it stays proven for the
    // client's lifetime and is never removed — even if the region later vanishes from the topology
    // and re-appears (matching .NET's permanent-cache semantics, so a re-added region is NOT
    // re-probed). Backed by a ConcurrentHashMap key-set for lock-free reads/writes.
    private final Set<URI> provenHealthyEndpoints = ConcurrentHashMap.newKeySet();

    // Immutable snapshot of the most recently observed thin-client topology (the endpoints supplied
    // to the last runProbeCycle). The routing gate is evaluated against THIS set, so a vanished
    // region stops gating even though its proven-state entry is retained in provenHealthyEndpoints.
    // Replaced atomically (single volatile assignment) each cycle — no transient over-/under-healthy
    // window. Defaults to empty so the gate is conservatively false until a topology is observed.
    private volatile Set<URI> currentEndpoints = Collections.emptySet();

    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final AtomicBoolean cycleInProgress = new AtomicBoolean(false);

    public EndpointProbeClient(HttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(
            httpClient,
            "EndpointProbeClient requires a non-null thin-client HttpClient (HTTP/2). "
                + "Wire it via GlobalEndpointManager#setThinClientHttpClient before init().");
        this.perProbeTimeout = Duration.ofMillis(Configs.getThinClientConnectionTimeoutInMs());
    }

    /**
     * Runs one probe cycle against the supplied set of thin-client regional endpoints,
     * probing only the regions that have not yet recorded a cached success, and emits the
     * post-cycle value of {@link #isThinClientRoutable()}.
     *
     * <p>When the endpoint collection is {@code null} or empty (no thin-client regions resolved),
     * the current-topology snapshot becomes empty and the gate falls to its conservative {@code false}
     * (route to Gateway V1); the probe Flux then iterates nothing, so no HTTP traffic is issued. Note
     * the add-only proven set is never pruned, so regions proven earlier remain proven if they later
     * re-appear.
     *
     * <p>There are no short-circuit fast paths: every cycle iterates the provided collection and
     * probes only the not-yet-proven endpoints. When all are already proven the filter yields
     * nothing and the cycle is an inexpensive no-op that re-emits the current (healthy) gate.
     *
     * <p>The returned Mono never errors; internal exceptions are absorbed and logged so that
     * probe failures do not propagate out and fail topology refresh.
     */
    public Mono<Boolean> runProbeCycle(Collection<URI> regionalEndpoints) {
        // All preconditions are re-evaluated at subscription time so an upstream
        // cancellation (e.g. GlobalEndpointManager.close() disposing the swap-disposable)
        // is honored before any HTTP I/O is initiated.
        return Mono.defer(() -> {
            // Every no-op fast path below emits this: the current gate value, evaluated lazily.
            final Mono<Boolean> currentGate = Mono.fromSupplier(this::isThinClientRoutable);

            if (this.closed.get()) {
                return currentGate;
            }

            // Normalize a null topology to an empty iteration (reference only — no copy).
            Collection<URI> endpoints = regionalEndpoints == null ? Collections.emptyList() : regionalEndpoints;

            // Publish an immutable, null-free snapshot of the current topology as the gate's
            // reference set. This is a single atomic volatile assignment, so a concurrent gate read
            // never observes a transient over-/under-healthy state: growing the snapshot (a new
            // region) immediately makes the gate stricter until that region is proven, and shrinking
            // it (a vanished region) simply stops that region from gating. The proven set is add-only
            // and is NOT reconciled/pruned here — vanished regions keep their proven entry so a
            // re-added region is never re-probed. When the collection is null/empty the snapshot is
            // empty and the gate is false, so the SDK falls back to Gateway V1.
            Set<URI> snapshot = new HashSet<>();
            for (URI endpoint : endpoints) {
                if (endpoint != null) {
                    snapshot.add(endpoint);
                }
            }
            snapshot = Collections.unmodifiableSet(snapshot);
            this.currentEndpoints = snapshot;
            final Set<URI> currentSnapshot = snapshot;

            // Single-flight: skip if a cycle is already running. The snapshot was published above so
            // the gate already reflects the latest topology regardless of whether we probe this round.
            if (!this.cycleInProgress.compareAndSet(false, true)) {
                logger.debug("Thin-client probe cycle already in progress; skipping overlapping trigger.");
                return currentGate;
            }

            // No fast paths: always iterate the current snapshot and probe only the endpoints not yet
            // in the add-only proven set (the delta of new regions). When everything is already proven
            // (or the snapshot is empty) the filter yields nothing and the cycle is an inexpensive
            // no-op that re-emits the current gate.
            return Flux
                .fromIterable(currentSnapshot)
                .filter(endpoint -> !this.provenHealthyEndpoints.contains(endpoint))
                .flatMap(this::probeEndpointOnce)
                .collectList()
                .map(this::applyCycleResult)
                .onErrorResume(t -> {
                    logger.warn(
                        "Thin-client probe cycle threw an unexpected error; leaving failed regions un-cached.", t);
                    return currentGate;
                })
                .doFinally(s -> this.cycleInProgress.set(false));
        });
    }

    /**
     * @return current routing-gate value. {@code true} means the SDK may route the data plane to the
     * thin-client proxy: {@code true} only when the most recently observed topology snapshot is
     * non-empty and every endpoint in it is present in the add-only proven set.
     */
    public boolean isThinClientRoutable() {
        Set<URI> snapshot = this.currentEndpoints;
        if (snapshot.isEmpty()) {
            // No known thin-client regions (conservative startup, or regions vanished): route to
            // Gateway V1 until a region is proven reachable.
            return false;
        }
        // Every current region must be in the add-only proven set. A proven region that has since
        // vanished is absent from the snapshot, so it neither helps nor blocks this decision.
        return this.provenHealthyEndpoints.containsAll(snapshot);
    }

    /**
     * Marks the probe client as closed. Subsequent {@link #runProbeCycle(Collection)}
     * invocations short-circuit and issue no further HTTP/2 probes. The shared
     * thin-client {@link HttpClient} is owned by {@code RxDocumentClientImpl} and is NOT
     * closed here — its lifetime is bound to the {@code CosmosClient} itself.
     *
     * <p>In-flight probe Monos are not actively cancelled; they will self-terminate via
     * the per-probe timeout. Their results are still applied to internal state but, since
     * the host {@code GlobalEndpointManager} is also closed, no consumer will observe the
     * flip.
     */
    @Override
    public void close() {
        if (this.closed.compareAndSet(false, true)) {
            logger.debug("EndpointProbeClient closed; no further thin-client probes will be issued.");
        }
    }

    private Mono<EndpointProbeResult> probeEndpointOnce(URI regionalEndpoint) {
        URI probeUri;
        try {
            probeUri = buildProbeUri(regionalEndpoint);
        } catch (URISyntaxException e) {
            logger.warn("Failed to build probe URI for {}: {}", regionalEndpoint, e.getMessage());
            return Mono.just(new EndpointProbeResult(regionalEndpoint, false));
        }

        HttpHeaders headers = new HttpHeaders();
        // Mirror thin-client traffic so any proxy-side routing/diagnostics treat this
        // request the same way as a real data-plane request.
        headers.set(HttpConstants.HttpHeaders.THINCLIENT_PROXY_OPERATION_TYPE, "ConnectivityProbe");

        HttpRequest request = new HttpRequest(
            HttpMethod.POST,
            probeUri,
            probeUri.getPort(),
            headers);
        request.withThinClientRequest(true);

        return this.httpClient
            .send(request, this.perProbeTimeout)
            .flatMap(response -> {
                int status = response.statusCode();
                boolean ok = status == 200;
                if (!ok) {
                    logger.debug("Thin-client probe to {} returned status {}", regionalEndpoint, status);
                }
                // Drain the body within the probe Mono lifecycle so reactor-netty releases
                // the underlying buffer and a slow/trickling body cannot leak resources
                // outside `perProbeTimeout`. doFinally + onErrorResume guarantee that
                // status-based success classification still wins regardless of how the
                // drain stream terminates.
                final EndpointProbeResult result = new EndpointProbeResult(regionalEndpoint, ok);
                return response.body()
                    .doOnNext(buf -> {
                        // body() emits a single aggregated ByteBuf that this subscriber owns. The
                        // probe discards the body, so release it exactly once. Mirror reactor-netty's
                        // releaseOnNotSubscribedResponse / RxGatewayStoreModel safe-release idiom:
                        // a refCnt guard + ReferenceCountUtil.safeRelease so a release race cannot
                        // throw IllegalReferenceCountException into the drain stream.
                        if (buf != null && buf.refCnt() > 0) {
                            ReferenceCountUtil.safeRelease(buf);
                        }
                    })
                    .then(Mono.just(result))
                    .timeout(this.perProbeTimeout)
                    .onErrorResume(drainError -> {
                        logger.debug("Thin-client probe body drain to {} failed: {}",
                            regionalEndpoint, drainError.toString());
                        return Mono.just(result);
                    });
            })
            .onErrorResume(t -> {
                logger.debug(
                    "Thin-client probe to {} failed: {}", regionalEndpoint, t.toString());
                return Mono.just(new EndpointProbeResult(regionalEndpoint, false));
            });
    }

    private Boolean applyCycleResult(List<EndpointProbeResult> results) {

        // If the probe client was closed (e.g. CosmosClient.close()) while this cycle was
        // in flight, drop the result so we don't mutate state on a dead client.
        if (this.closed.get()) {
            logger.debug("Thin-client probe cycle completed after close; dropping result.");
            return isThinClientRoutable();
        }

        int successCount = 0;
        for (EndpointProbeResult r : results) {
            if (r.success && r.endpoint != null) {
                // Add-only: record the region as permanently proven. The proven set is never pruned,
                // so this is a no-op if the region was already proven, and a vanished region is left
                // proven (harmless — the gate only checks the current topology snapshot, and a
                // re-added region will be skipped by the delta filter rather than re-probed).
                this.provenHealthyEndpoints.add(r.endpoint);
                successCount++;
            }
        }
        int failureCount = results.size() - successCount;
        boolean healthy = isThinClientRoutable();

        if (failureCount > 0) {
            logger.warn(
                "Thin-client probe cycle complete: {} region(s) proven, {} still failing "
                    + "(will re-probe next refresh); gate healthy={}.",
                successCount, failureCount, healthy);
        } else {
            logger.debug(
                "Thin-client probe cycle complete: {} new region(s) proven; gate healthy={}.",
                successCount, healthy);
        }

        return healthy;
    }

    private static URI buildProbeUri(URI regionalEndpoint) throws URISyntaxException {
        return new URI(
            regionalEndpoint.getScheme(),
            null,
            regionalEndpoint.getHost(),
            regionalEndpoint.getPort(),
            PROBE_PATH,
            null,
            null);
    }
}
