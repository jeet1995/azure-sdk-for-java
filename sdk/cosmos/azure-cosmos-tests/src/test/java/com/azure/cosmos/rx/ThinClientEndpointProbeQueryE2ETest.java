// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.rx;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosDiagnostics;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.FeedResponse;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Thin client E2E tests for query operations exercised through the connectivity-probe (implicit)
 * enablement path: single-partition, cross-partition, and parameterized queries.
 *
 * <p>These mirror the query coverage in {@link ThinClientQueryE2ETest} but extend
 * {@link ThinClientEndpointProbeTestBase}, which leaves {@code COSMOS.THINCLIENT_ENABLED} unset so
 * routing is decided by the endpoint connectivity probe rather than an explicit opt-in. The
 * {@code assertThinClientEndpointUsed} assertions therefore double as a probe-success signal: they
 * only hold if the probe succeeded and selected Gateway V2 (thin client). A failing probe would fall
 * back to Gateway V1 and these assertions would fail.</p>
 *
 * <p>Container is truncated in {@code @BeforeClass} -- no per-test cleanup needed.</p>
 */
public class ThinClientEndpointProbeQueryE2ETest extends ThinClientEndpointProbeTestBase {

    @Factory(dataProvider = "clientBuildersWithGatewayAndHttp2")
    public ThinClientEndpointProbeQueryE2ETest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientSinglePartitionQuery() {
        String pkValue = "probeQuerySp_" + UUID.randomUUID().toString().substring(0, 8);
        String idValue = UUID.randomUUID().toString();
        container.createItem(createTestDocument(idValue, pkValue)).block();

        CosmosQueryRequestOptions options = new CosmosQueryRequestOptions()
            .setPartitionKey(new PartitionKey(pkValue));

        List<ObjectNode> results = new ArrayList<>();
        List<CosmosDiagnostics> allDiag = new ArrayList<>();
        for (FeedResponse<ObjectNode> page : container
                .queryItems("SELECT * FROM c WHERE c." + PARTITION_KEY_FIELD + " = '" + pkValue + "'", options, ObjectNode.class)
                .byPage()
                .toIterable()) {
            results.addAll(page.getResults());
            allDiag.add(page.getCosmosDiagnostics());
        }

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).get(ID_FIELD).asText()).isEqualTo(idValue);
        for (CosmosDiagnostics d : allDiag) {
            assertThinClientEndpointUsed(d);
        }
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientCrossPartitionQuery() {
        // Distinct partition keys so the query genuinely fans out across partitions.
        String tag = "probeQueryXp_" + UUID.randomUUID().toString().substring(0, 8);
        String pk1 = tag + "_1";
        String pk2 = tag + "_2";
        ObjectNode doc1 = createTestDocument(UUID.randomUUID().toString(), pk1);
        doc1.put("tag", tag);
        ObjectNode doc2 = createTestDocument(UUID.randomUUID().toString(), pk2);
        doc2.put("tag", tag);
        container.createItem(doc1).block();
        container.createItem(doc2).block();

        CosmosQueryRequestOptions options = new CosmosQueryRequestOptions();

        List<ObjectNode> results = new ArrayList<>();
        List<CosmosDiagnostics> allDiag = new ArrayList<>();
        for (FeedResponse<ObjectNode> page : container
                .queryItems("SELECT * FROM c WHERE c.tag = '" + tag + "'", options, ObjectNode.class)
                .byPage()
                .toIterable()) {
            results.addAll(page.getResults());
            allDiag.add(page.getCosmosDiagnostics());
        }

        assertThat(results.size()).isEqualTo(2);
        for (CosmosDiagnostics d : allDiag) {
            assertThinClientEndpointUsed(d);
        }
    }

    @Test(groups = {"thinclientEndpointProbe"}, timeOut = TIMEOUT)
    public void testThinClientParameterizedQuery() {
        String pkValue = "probeQueryParam_" + UUID.randomUUID().toString().substring(0, 8);
        String idValue = UUID.randomUUID().toString();
        container.createItem(createTestDocument(idValue, pkValue)).block();

        SqlQuerySpec querySpec = new SqlQuerySpec(
            "SELECT * FROM c WHERE c." + ID_FIELD + " = @id",
            Collections.singletonList(new SqlParameter("@id", idValue)));

        CosmosQueryRequestOptions options = new CosmosQueryRequestOptions()
            .setPartitionKey(new PartitionKey(pkValue));

        List<ObjectNode> results = new ArrayList<>();
        List<CosmosDiagnostics> allDiag = new ArrayList<>();
        for (FeedResponse<ObjectNode> page : container
                .queryItems(querySpec, options, ObjectNode.class)
                .byPage()
                .toIterable()) {
            results.addAll(page.getResults());
            allDiag.add(page.getCosmosDiagnostics());
        }

        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0).get(ID_FIELD).asText()).isEqualTo(idValue);
        for (CosmosDiagnostics d : allDiag) {
            assertThinClientEndpointUsed(d);
        }
    }
}
