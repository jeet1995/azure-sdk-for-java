// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.devcenter.fluent.models.HealthCheckStatusDetailsProperties;

public final class HealthCheckStatusDetailsPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HealthCheckStatusDetailsProperties model = BinaryData.fromString(
            "{\"startDateTime\":\"2021-07-04T23:53:04Z\",\"endDateTime\":\"2021-05-04T05:51:41Z\",\"healthChecks\":[{\"status\":\"Unknown\",\"displayName\":\"vkjlmxhom\",\"startDateTime\":\"2021-10-09T04:46:26Z\",\"endDateTime\":\"2021-11-30T18:11:35Z\",\"errorType\":\"digumbnr\",\"recommendedAction\":\"uzzptjazysdz\",\"additionalDetails\":\"zwwva\"}]}")
            .toObject(HealthCheckStatusDetailsProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HealthCheckStatusDetailsProperties model = new HealthCheckStatusDetailsProperties();
        model = BinaryData.fromObject(model).toObject(HealthCheckStatusDetailsProperties.class);
    }
}
