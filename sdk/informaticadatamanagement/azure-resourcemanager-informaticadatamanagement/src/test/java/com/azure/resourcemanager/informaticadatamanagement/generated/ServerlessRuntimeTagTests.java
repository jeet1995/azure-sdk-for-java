// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.informaticadatamanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.informaticadatamanagement.models.ServerlessRuntimeTag;
import org.junit.jupiter.api.Assertions;

public final class ServerlessRuntimeTagTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ServerlessRuntimeTag model
            = BinaryData.fromString("{\"name\":\"a\",\"value\":\"xwczelpcire\"}").toObject(ServerlessRuntimeTag.class);
        Assertions.assertEquals("a", model.name());
        Assertions.assertEquals("xwczelpcire", model.value());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ServerlessRuntimeTag model = new ServerlessRuntimeTag().withName("a").withValue("xwczelpcire");
        model = BinaryData.fromObject(model).toObject(ServerlessRuntimeTag.class);
        Assertions.assertEquals("a", model.name());
        Assertions.assertEquals("xwczelpcire", model.value());
    }
}
