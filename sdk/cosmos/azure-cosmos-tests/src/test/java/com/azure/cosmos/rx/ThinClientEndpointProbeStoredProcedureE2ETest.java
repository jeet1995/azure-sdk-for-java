// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.rx;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosStoredProcedureProperties;
import com.azure.cosmos.models.CosmosStoredProcedureRequestOptions;
import com.azure.cosmos.models.CosmosStoredProcedureResponse;
import com.azure.cosmos.models.PartitionKey;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Thin client E2E tests for stored procedure execution exercised through the connectivity-probe
 * (implicit) enablement path.
 *
 * <p>These mirror {@link ThinClientStoredProcedureE2ETest} but extend
 * {@link ThinClientEndpointProbeTestBase}, which leaves {@code COSMOS.THINCLIENT_ENABLED} unset so
 * routing is decided by the endpoint connectivity probe rather than an explicit opt-in. The
 * {@code assertThinClientEndpointUsed} assertions therefore double as a probe-success signal: they
 * only hold if the probe succeeded and selected Gateway V2 (thin client). A failing probe would fall
 * back to Gateway V1 and these assertions would fail.</p>
 *
 * <p>Container is truncated in {@code @BeforeClass} -- no per-test cleanup needed.</p>
 */
public class ThinClientEndpointProbeStoredProcedureE2ETest extends ThinClientEndpointProbeTestBase {

    @Factory(dataProvider = "clientBuildersWithGatewayAndHttp2")
    public ThinClientEndpointProbeStoredProcedureE2ETest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientStoredProcedure() {
        String sprocId = "probeCreateDocSproc_" + UUID.randomUUID();
        String pkValue = UUID.randomUUID().toString();
        String docId = UUID.randomUUID().toString();

        CosmosStoredProcedureProperties storedProcedureDef = new CosmosStoredProcedureProperties(
            sprocId,
            "function createDocument(docToCreate) {"
                + "var context = getContext();"
                + "var container = context.getCollection();"
                + "var response = context.getResponse();"
                + "var accepted = container.createDocument("
                + "    container.getSelfLink(),"
                + "    docToCreate,"
                + "    function(err, docCreated) {"
                + "        if (err) throw new Error('Error creating document: ' + err.message);"
                + "        response.setBody(docCreated);"
                + "    });"
                + "if (!accepted) throw new Error('Document creation was not accepted');"
                + "}"
        );

        CosmosStoredProcedureResponse createResponse = container.getScripts()
            .createStoredProcedure(storedProcedureDef).block();
        assertThat(createResponse).isNotNull();
        assertThat(createResponse.getStatusCode()).isEqualTo(201);

        CosmosStoredProcedureRequestOptions options = new CosmosStoredProcedureRequestOptions();
        options.setPartitionKey(new PartitionKey(pkValue));

        ObjectNode docToCreate = createTestDocument(docId, pkValue);

        CosmosStoredProcedureResponse executeResponse = container.getScripts()
            .getStoredProcedure(sprocId)
            .execute(Arrays.asList(docToCreate), options).block();

        assertThat(executeResponse).isNotNull();
        assertThat(executeResponse.getStatusCode()).isEqualTo(200);
        assertThat(executeResponse.getRequestCharge()).isGreaterThan(0.0);
        assertThinClientEndpointUsed(executeResponse.getDiagnostics());

        CosmosItemResponse<ObjectNode> readResponse = container.readItem(docId, new PartitionKey(pkValue), ObjectNode.class).block();
        assertThat(readResponse).isNotNull();
        assertThat(readResponse.getItem().get(ID_FIELD).asText()).isEqualTo(docId);
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientStoredProcedureWithPartitionKeyNone() {
        String sprocId = "probePkNoneSproc_" + UUID.randomUUID();

        CosmosStoredProcedureProperties storedProcedureDef = new CosmosStoredProcedureProperties(
            sprocId, "function() { getContext().getResponse().setBody('Hello from PK.NONE'); }");

        container.getScripts().createStoredProcedure(storedProcedureDef).block();

        CosmosStoredProcedureRequestOptions options = new CosmosStoredProcedureRequestOptions();
        options.setPartitionKey(PartitionKey.NONE);

        CosmosStoredProcedureResponse executeResponse = container.getScripts()
            .getStoredProcedure(sprocId).execute(null, options).block();

        assertThat(executeResponse).isNotNull();
        assertThat(executeResponse.getStatusCode()).isEqualTo(200);
        assertThat(executeResponse.getRequestCharge()).isGreaterThan(0.0);
        assertThinClientEndpointUsed(executeResponse.getDiagnostics());
    }
}
