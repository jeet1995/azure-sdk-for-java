// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.azurestackhci.models.PhysicalNodes;
import org.junit.jupiter.api.Assertions;

public final class PhysicalNodesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PhysicalNodes model
            = BinaryData.fromString("{\"name\":\"eqx\",\"ipv4Address\":\"z\"}").toObject(PhysicalNodes.class);
        Assertions.assertEquals("eqx", model.name());
        Assertions.assertEquals("z", model.ipv4Address());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PhysicalNodes model = new PhysicalNodes().withName("eqx").withIpv4Address("z");
        model = BinaryData.fromObject(model).toObject(PhysicalNodes.class);
        Assertions.assertEquals("eqx", model.name());
        Assertions.assertEquals("z", model.ipv4Address());
    }
}
