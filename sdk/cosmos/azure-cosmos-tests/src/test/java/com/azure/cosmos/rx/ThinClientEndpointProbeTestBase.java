// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.rx;

import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosDiagnostics;
import com.azure.cosmos.CosmosClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Base class for thin-client E2E tests that exercise the connectivity-probe (implicit) enablement path.
 *
 * <p>Unlike {@link ThinClientTestBase}, this base deliberately does <b>not</b> set
 * {@code COSMOS.THINCLIENT_ENABLED=true}. Leaving it unset keeps
 * {@code Configs.isThinClientEnabledExplicitly()} null (not hard-disabled) while
 * {@code Configs.hasUserExplicitlyEnabledThinClient()}
 * stays false, so {@code ThinClientConnectivityConfig.canThinClientBeImplicitlyEnabled()} is true and the
 * endpoint-probe HttpClient is wired. Routing is then gated on the probe verdict (with fallback to
 * Gateway V1) rather than a hard opt-in. HTTP/2 must still be effectively enabled (supplied by the
 * {@code clientBuildersWithGatewayAndHttp2} data provider and the {@code thinclient-endpoint-probe}
 * Maven profile) because {@code canThinClientBeUsed()} requires it.</p>
 *
 * <p>The property is defensively cleared in {@code @BeforeClass}/{@code @AfterClass} so a leaked
 * explicit-enablement flag from another thin-client test class cannot silently turn this into the
 * explicit opt-in path and bypass the probe.</p>
 */
public abstract class ThinClientEndpointProbeTestBase extends TestSuiteBase {

    protected static final String ID_FIELD = "id";
    protected static final String PARTITION_KEY_FIELD = "mypk";
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected CosmosAsyncClient client;
    protected CosmosAsyncContainer container;

    protected ThinClientEndpointProbeTestBase(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @BeforeClass(groups = {"thinclientEndpointProbe"}, timeOut = SETUP_TIMEOUT)
    public void before_ThinClientEndpointProbeTest() {
        assertThat(this.client).isNull();
        // Do NOT enable thin client explicitly -- the connectivity probe must drive routing.
        // Defensively clear any leaked explicit-enablement flag so the implicit path is guaranteed.
        System.clearProperty("COSMOS.THINCLIENT_ENABLED");
        this.client = getClientBuilder().buildAsyncClient();
        this.container = getSharedMultiPartitionCosmosContainer(this.client);

        // Clean up shared container to prevent cross-test-class pollution.
        cleanUpContainer(this.container);
    }

    @AfterClass(groups = {"thinclientEndpointProbe"}, timeOut = SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        System.clearProperty("COSMOS.THINCLIENT_ENABLED");
        if (this.client != null) {
            this.client.close();
        }
    }

    /**
     * Creates a test document with id and mypk fields (matching shared container partition key).
     */
    protected ObjectNode createTestDocument(String id, String mypk) {
        ObjectNode doc = OBJECT_MAPPER.createObjectNode();
        doc.put(ID_FIELD, id);
        doc.put(PARTITION_KEY_FIELD, mypk);
        return doc;
    }

    /**
     * Asserts that all data requests in the diagnostics were routed through the thin client endpoint.
     * Under the implicit path this only holds when the connectivity probe succeeded and selected
     * Gateway V2 (thin client); a failing probe would fall back to Gateway V1 and this assertion
     * would fail -- making it a direct signal that the probe routed correctly.
     */
    public static void assertThinClientEndpointUsed(CosmosDiagnostics diagnostics) {
        TestSuiteBase.assertThinClientEndpointUsed(diagnostics);
    }
}
