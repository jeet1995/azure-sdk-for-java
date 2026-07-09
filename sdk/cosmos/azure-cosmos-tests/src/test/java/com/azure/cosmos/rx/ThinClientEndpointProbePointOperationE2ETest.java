// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.rx;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.models.CosmosBatch;
import com.azure.cosmos.models.CosmosBatchResponse;
import com.azure.cosmos.models.CosmosBulkItemResponse;
import com.azure.cosmos.models.CosmosBulkOperationResponse;
import com.azure.cosmos.models.CosmosBulkOperations;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosPatchOperations;
import com.azure.cosmos.models.PartitionKey;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Thin client E2E tests for point operations exercised through the connectivity-probe (implicit)
 * enablement path: Create, Read, Replace, Upsert, Patch, Delete, Bulk, Batch.
 *
 * <p>These mirror {@link ThinClientPointOperationE2ETest} but extend
 * {@link ThinClientEndpointProbeTestBase}, which leaves {@code COSMOS.THINCLIENT_ENABLED} unset so
 * routing is decided by the endpoint connectivity probe rather than an explicit opt-in. The
 * {@code assertThinClientEndpointUsed} assertions therefore double as a probe-success signal: they
 * only hold if the probe succeeded and selected Gateway V2 (thin client). A failing probe would fall
 * back to Gateway V1 and these assertions would fail.</p>
 *
 * <p>Container is truncated in {@code @BeforeClass} -- no per-test cleanup needed.</p>
 */
public class ThinClientEndpointProbePointOperationE2ETest extends ThinClientEndpointProbeTestBase {

    @Factory(dataProvider = "clientBuildersWithGatewayAndHttp2")
    public ThinClientEndpointProbePointOperationE2ETest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientDocumentPointOperations() {
        String idValue = UUID.randomUUID().toString();
        ObjectNode doc = createTestDocument(idValue, idValue);

        // create
        CosmosItemResponse<ObjectNode> createResponse = container.createItem(doc).block();
        assertThat(createResponse.getStatusCode()).isEqualTo(201);
        assertThat(createResponse.getRequestCharge()).isGreaterThan(0.0);
        assertThinClientEndpointUsed(createResponse.getDiagnostics());

        // read
        CosmosItemResponse<ObjectNode> readResponse = container.readItem(idValue, new PartitionKey(idValue), ObjectNode.class).block();
        assertThat(readResponse.getStatusCode()).isEqualTo(200);
        assertThinClientEndpointUsed(readResponse.getDiagnostics());

        String idValue2 = UUID.randomUUID().toString();
        ObjectNode doc2 = createTestDocument(idValue2, idValue);

        // replace
        CosmosItemResponse<ObjectNode> replaceResponse = container.replaceItem(doc2, idValue, new PartitionKey(idValue)).block();
        assertThat(replaceResponse.getStatusCode()).isEqualTo(200);
        assertThinClientEndpointUsed(replaceResponse.getDiagnostics());

        // upsert
        ObjectNode doc3 = createTestDocument(idValue2, idValue);
        doc3.put("newField", "newValue");
        CosmosItemResponse<ObjectNode> upsertResponse = container.upsertItem(doc3, new PartitionKey(idValue), new CosmosItemRequestOptions()).block();
        assertThat(upsertResponse.getStatusCode()).isEqualTo(200);
        assertThinClientEndpointUsed(upsertResponse.getDiagnostics());

        CosmosItemResponse<ObjectNode> readAfterUpsertResponse = container.readItem(idValue2, new PartitionKey(idValue), ObjectNode.class).block();
        assertThat(readAfterUpsertResponse.getItem().get("newField").asText()).isEqualTo("newValue");

        // patch
        CosmosPatchOperations patchOperations = CosmosPatchOperations.create();
        patchOperations.add("/anotherNewField", "anotherNewValue");
        patchOperations.replace("/newField", "patchedNewField");
        CosmosItemResponse<ObjectNode> patchResponse = container.patchItem(idValue2, new PartitionKey(idValue), patchOperations, ObjectNode.class).block();
        assertThat(patchResponse.getStatusCode()).isEqualTo(200);
        assertThinClientEndpointUsed(patchResponse.getDiagnostics());

        CosmosItemResponse<ObjectNode> readAfterPatchResponse = container.readItem(idValue2, new PartitionKey(idValue), ObjectNode.class).block();
        assertThat(readAfterPatchResponse.getItem().get("newField").asText()).isEqualTo("patchedNewField");
        assertThat(readAfterPatchResponse.getItem().get("anotherNewField").asText()).isEqualTo("anotherNewValue");

        // delete
        CosmosItemResponse<Object> deleteResponse = container.deleteItem(idValue2, new PartitionKey(idValue)).block();
        assertThat(deleteResponse.getStatusCode()).isEqualTo(204);
        assertThinClientEndpointUsed(deleteResponse.getDiagnostics());
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientBulk() {
        String idValue = UUID.randomUUID().toString();
        ObjectNode doc = createTestDocument(idValue, idValue);

        Flux<CosmosBulkOperationResponse<Object>> responsesFlux = container.executeBulkOperations(Flux.just(
            CosmosBulkOperations.getCreateItemOperation(doc, new PartitionKey(idValue))
        ));

        List<CosmosBulkOperationResponse<Object>> responses = responsesFlux.collectList().block();
        assertThat(responses.size()).isEqualTo(1);
        CosmosBulkItemResponse bulkResponse = responses.get(0).getResponse();
        assertThat(bulkResponse.isSuccessStatusCode()).isEqualTo(true);
        assertThinClientEndpointUsed(bulkResponse.getCosmosDiagnostics());
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientBatch() {
        String pkValue = UUID.randomUUID().toString();
        String idValue1 = UUID.randomUUID().toString();
        String idValue2 = UUID.randomUUID().toString();
        ObjectNode doc1 = createTestDocument(idValue1, pkValue);
        ObjectNode doc2 = createTestDocument(idValue2, pkValue);

        CosmosBatch batch = CosmosBatch.createCosmosBatch(new PartitionKey(pkValue));
        batch.createItemOperation(doc1);
        batch.createItemOperation(doc2);

        CosmosBatchResponse response = container.executeCosmosBatch(batch).block();
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThinClientEndpointUsed(response.getDiagnostics());
    }
}
