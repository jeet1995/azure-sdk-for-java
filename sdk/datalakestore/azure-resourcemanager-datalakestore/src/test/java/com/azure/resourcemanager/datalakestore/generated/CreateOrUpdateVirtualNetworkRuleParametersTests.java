// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakestore.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datalakestore.models.CreateOrUpdateVirtualNetworkRuleParameters;
import org.junit.jupiter.api.Assertions;

public final class CreateOrUpdateVirtualNetworkRuleParametersTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CreateOrUpdateVirtualNetworkRuleParameters model
            = BinaryData.fromString("{\"properties\":{\"subnetId\":\"osfqpteehzzv\"}}")
                .toObject(CreateOrUpdateVirtualNetworkRuleParameters.class);
        Assertions.assertEquals("osfqpteehzzv", model.subnetId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CreateOrUpdateVirtualNetworkRuleParameters model
            = new CreateOrUpdateVirtualNetworkRuleParameters().withSubnetId("osfqpteehzzv");
        model = BinaryData.fromObject(model).toObject(CreateOrUpdateVirtualNetworkRuleParameters.class);
        Assertions.assertEquals("osfqpteehzzv", model.subnetId());
    }
}
