// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.SubvolumePatchRequest;
import org.junit.jupiter.api.Assertions;

public final class SubvolumePatchRequestTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SubvolumePatchRequest model
            = BinaryData.fromString("{\"properties\":{\"size\":5324799638709264406,\"path\":\"x\"}}")
                .toObject(SubvolumePatchRequest.class);
        Assertions.assertEquals(5324799638709264406L, model.size());
        Assertions.assertEquals("x", model.path());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SubvolumePatchRequest model = new SubvolumePatchRequest().withSize(5324799638709264406L).withPath("x");
        model = BinaryData.fromObject(model).toObject(SubvolumePatchRequest.class);
        Assertions.assertEquals(5324799638709264406L, model.size());
        Assertions.assertEquals("x", model.path());
    }
}
