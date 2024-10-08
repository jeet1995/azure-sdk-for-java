// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.standbypool.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.standbypool.models.StandbyVirtualMachineResourceProperties;
import org.junit.jupiter.api.Assertions;

public final class StandbyVirtualMachineResourcePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StandbyVirtualMachineResourceProperties model = BinaryData
            .fromString("{\"virtualMachineResourceId\":\"xqeofjaeqjhqjba\",\"provisioningState\":\"Deleting\"}")
            .toObject(StandbyVirtualMachineResourceProperties.class);
        Assertions.assertEquals("xqeofjaeqjhqjba", model.virtualMachineResourceId());
    }
}
