// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.networkcloud.models.ValidationThreshold;
import com.azure.resourcemanager.networkcloud.models.ValidationThresholdGrouping;
import com.azure.resourcemanager.networkcloud.models.ValidationThresholdType;
import org.junit.jupiter.api.Assertions;

public final class ValidationThresholdTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ValidationThreshold model = BinaryData
            .fromString("{\"grouping\":\"PerRack\",\"type\":\"PercentSuccess\",\"value\":1125965714665499028}")
            .toObject(ValidationThreshold.class);
        Assertions.assertEquals(ValidationThresholdGrouping.PER_RACK, model.grouping());
        Assertions.assertEquals(ValidationThresholdType.PERCENT_SUCCESS, model.type());
        Assertions.assertEquals(1125965714665499028L, model.value());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ValidationThreshold model = new ValidationThreshold().withGrouping(ValidationThresholdGrouping.PER_RACK)
            .withType(ValidationThresholdType.PERCENT_SUCCESS)
            .withValue(1125965714665499028L);
        model = BinaryData.fromObject(model).toObject(ValidationThreshold.class);
        Assertions.assertEquals(ValidationThresholdGrouping.PER_RACK, model.grouping());
        Assertions.assertEquals(ValidationThresholdType.PERCENT_SUCCESS, model.type());
        Assertions.assertEquals(1125965714665499028L, model.value());
    }
}
