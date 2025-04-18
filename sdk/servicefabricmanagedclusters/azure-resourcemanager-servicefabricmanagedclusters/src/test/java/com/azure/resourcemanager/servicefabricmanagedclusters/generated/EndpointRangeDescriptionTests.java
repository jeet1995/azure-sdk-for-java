// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.EndpointRangeDescription;
import org.junit.jupiter.api.Assertions;

public final class EndpointRangeDescriptionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        EndpointRangeDescription model = BinaryData.fromString("{\"startPort\":948234782,\"endPort\":1583288095}")
            .toObject(EndpointRangeDescription.class);
        Assertions.assertEquals(948234782, model.startPort());
        Assertions.assertEquals(1583288095, model.endPort());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        EndpointRangeDescription model
            = new EndpointRangeDescription().withStartPort(948234782).withEndPort(1583288095);
        model = BinaryData.fromObject(model).toObject(EndpointRangeDescription.class);
        Assertions.assertEquals(948234782, model.startPort());
        Assertions.assertEquals(1583288095, model.endPort());
    }
}
