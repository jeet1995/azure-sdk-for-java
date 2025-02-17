// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.models.RaiBlocklistProperties;
import org.junit.jupiter.api.Assertions;

public final class RaiBlocklistPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RaiBlocklistProperties model
            = BinaryData.fromString("{\"description\":\"r\"}").toObject(RaiBlocklistProperties.class);
        Assertions.assertEquals("r", model.description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RaiBlocklistProperties model = new RaiBlocklistProperties().withDescription("r");
        model = BinaryData.fromObject(model).toObject(RaiBlocklistProperties.class);
        Assertions.assertEquals("r", model.description());
    }
}
