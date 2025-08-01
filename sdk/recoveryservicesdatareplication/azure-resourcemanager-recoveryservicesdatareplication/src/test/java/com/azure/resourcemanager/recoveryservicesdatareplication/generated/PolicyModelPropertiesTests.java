// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.PolicyModelCustomProperties;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.PolicyModelProperties;

public final class PolicyModelPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PolicyModelProperties model = BinaryData.fromString(
            "{\"provisioningState\":\"Updating\",\"customProperties\":{\"instanceType\":\"PolicyModelCustomProperties\"}}")
            .toObject(PolicyModelProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PolicyModelProperties model
            = new PolicyModelProperties().withCustomProperties(new PolicyModelCustomProperties());
        model = BinaryData.fromObject(model).toObject(PolicyModelProperties.class);
    }
}
