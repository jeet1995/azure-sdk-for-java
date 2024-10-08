// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.TopNFeaturesByAttribution;
import org.junit.jupiter.api.Assertions;

public final class TopNFeaturesByAttributionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TopNFeaturesByAttribution model
            = BinaryData.fromString("{\"filterType\":\"TopNByAttribution\",\"top\":868397774}")
                .toObject(TopNFeaturesByAttribution.class);
        Assertions.assertEquals(868397774, model.top());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TopNFeaturesByAttribution model = new TopNFeaturesByAttribution().withTop(868397774);
        model = BinaryData.fromObject(model).toObject(TopNFeaturesByAttribution.class);
        Assertions.assertEquals(868397774, model.top());
    }
}
