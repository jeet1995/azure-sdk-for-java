// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.VirtualMachineImage;
import org.junit.jupiter.api.Assertions;

public final class VirtualMachineImageTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VirtualMachineImage model = BinaryData.fromString("{\"id\":\"eqi\"}").toObject(VirtualMachineImage.class);
        Assertions.assertEquals("eqi", model.id());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VirtualMachineImage model = new VirtualMachineImage().withId("eqi");
        model = BinaryData.fromObject(model).toObject(VirtualMachineImage.class);
        Assertions.assertEquals("eqi", model.id());
    }
}
