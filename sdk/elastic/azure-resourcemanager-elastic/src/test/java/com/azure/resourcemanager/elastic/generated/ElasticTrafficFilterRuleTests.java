// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elastic.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elastic.models.ElasticTrafficFilterRule;
import org.junit.jupiter.api.Assertions;

public final class ElasticTrafficFilterRuleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ElasticTrafficFilterRule model = BinaryData.fromString(
            "{\"source\":\"eojnabc\",\"description\":\"smtxpsieb\",\"azureEndpointGuid\":\"hvpesapskrdqm\",\"azureEndpointName\":\"jdhtldwkyzxu\",\"id\":\"kn\"}")
            .toObject(ElasticTrafficFilterRule.class);
        Assertions.assertEquals("eojnabc", model.source());
        Assertions.assertEquals("smtxpsieb", model.description());
        Assertions.assertEquals("hvpesapskrdqm", model.azureEndpointGuid());
        Assertions.assertEquals("jdhtldwkyzxu", model.azureEndpointName());
        Assertions.assertEquals("kn", model.id());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ElasticTrafficFilterRule model = new ElasticTrafficFilterRule().withSource("eojnabc")
            .withDescription("smtxpsieb")
            .withAzureEndpointGuid("hvpesapskrdqm")
            .withAzureEndpointName("jdhtldwkyzxu")
            .withId("kn");
        model = BinaryData.fromObject(model).toObject(ElasticTrafficFilterRule.class);
        Assertions.assertEquals("eojnabc", model.source());
        Assertions.assertEquals("smtxpsieb", model.description());
        Assertions.assertEquals("hvpesapskrdqm", model.azureEndpointGuid());
        Assertions.assertEquals("jdhtldwkyzxu", model.azureEndpointName());
        Assertions.assertEquals("kn", model.id());
    }
}
