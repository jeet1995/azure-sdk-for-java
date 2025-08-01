// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.cloudhealth.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cloudhealth.models.IconDefinition;
import org.junit.jupiter.api.Assertions;

public final class IconDefinitionTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IconDefinition model
            = BinaryData.fromString("{\"iconName\":\"ag\",\"customData\":\"t\"}").toObject(IconDefinition.class);
        Assertions.assertEquals("ag", model.iconName());
        Assertions.assertEquals("t", model.customData());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IconDefinition model = new IconDefinition().withIconName("ag").withCustomData("t");
        model = BinaryData.fromObject(model).toObject(IconDefinition.class);
        Assertions.assertEquals("ag", model.iconName());
        Assertions.assertEquals("t", model.customData());
    }
}
