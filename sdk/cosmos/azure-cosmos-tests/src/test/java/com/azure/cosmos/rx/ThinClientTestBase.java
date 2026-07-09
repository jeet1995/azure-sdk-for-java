// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.rx;

import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosDiagnostics;
import com.azure.cosmos.CosmosDiagnosticsContext;
import com.azure.cosmos.CosmosDiagnosticsRequestInfo;
import com.azure.cosmos.CosmosClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Base class for thin client E2E tests. Provides shared setup/teardown,
 * constants, and helper methods common to all thin client test classes.
 */
public abstract class ThinClientTestBase extends TestSuiteBase {

    protected static final String ID_FIELD = "id";
    protected static final String PARTITION_KEY_FIELD = "mypk";
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String THINCLIENT_ENABLED_PROPERTY = "COSMOS.THINCLIENT_ENABLED";

    protected CosmosAsyncClient client;
    protected CosmosAsyncContainer container;

    // Captures the ambient COSMOS.THINCLIENT_ENABLED value (typically supplied by the thin-client CI
    // lane via -DCOSMOS.THINCLIENT_ENABLED=true) so teardown can restore it rather than unconditionally
    // clearing it. Because the property is read lazily per client build and these classes share a JVM
    // with property-dependent tests inherited from main (e.g. ThinClientQueryE2ETest, CosmosMultiHashTest),
    // an unconditional clear here would disable thin client for later-running classes and route their
    // requests to :443, breaking the thin-client endpoint assertions.
    private String previousThinClientEnabled;

    protected ThinClientTestBase(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @BeforeClass(groups = {"thinclient"}, timeOut = SETUP_TIMEOUT)
    public void before_ThinClientTest() {
        assertThat(this.client).isNull();
        enableThinClientForTest();
        this.client = getClientBuilder().buildAsyncClient();
        this.container = getSharedMultiPartitionCosmosContainer(this.client);

        // Clean up shared container to prevent cross-test-class pollution.
        cleanUpContainer(this.container);
    }

    @AfterClass(groups = {"thinclient"}, timeOut = SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        clearThinClientForTest();
        if (this.client != null) {
            this.client.close();
        }
    }

    protected void enableThinClientForTest() {
        this.previousThinClientEnabled = System.getProperty(THINCLIENT_ENABLED_PROPERTY);
        System.setProperty(THINCLIENT_ENABLED_PROPERTY, "true");
    }

    protected void clearThinClientForTest() {
        // Restore the ambient value instead of clearing, so the -D-supplied flag survives for
        // subsequent test classes running in the same JVM that rely on it.
        if (this.previousThinClientEnabled == null) {
            System.clearProperty(THINCLIENT_ENABLED_PROPERTY);
        } else {
            System.setProperty(THINCLIENT_ENABLED_PROPERTY, this.previousThinClientEnabled);
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
     */
    public static void assertThinClientEndpointUsed(CosmosDiagnostics diagnostics) {
        // Delegate to the shared TestSuiteBase implementation so the thin-client routing invariant
        // (every request via the thin-client endpoint -- including QueryPlan, which is routed to
        // Gateway V2 when thin client + HTTP/2 are opted in) and null-endpoint handling are applied
        // consistently across all thin-client tests.
        TestSuiteBase.assertThinClientEndpointUsed(diagnostics);
    }

    /**
     * Asserts that NO requests in the diagnostics were routed through the thin client endpoint,
     * confirming the gateway client used the standard :443 path.
     */
    public static void assertGatewayEndpointUsed(CosmosDiagnostics diagnostics) {
        assertThat(diagnostics).isNotNull();
        CosmosDiagnosticsContext ctx = diagnostics.getDiagnosticsContext();
        assertThat(ctx).isNotNull();
        Collection<CosmosDiagnosticsRequestInfo> requests = ctx.getRequestInfo();
        assertThat(requests).isNotNull();
        assertThat(requests.size()).isPositive();
        for (CosmosDiagnosticsRequestInfo requestInfo : requests) {
            assertThat(requestInfo.getEndpoint())
                .as("Gateway client must not route through thin client endpoint, but found: " + requestInfo.getEndpoint())
                .doesNotContain(THIN_CLIENT_ENDPOINT_INDICATOR);
        }
    }
}
