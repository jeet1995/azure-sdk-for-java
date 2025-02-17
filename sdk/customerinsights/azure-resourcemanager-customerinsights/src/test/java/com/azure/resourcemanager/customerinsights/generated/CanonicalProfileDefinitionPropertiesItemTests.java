// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.customerinsights.models.CanonicalProfileDefinitionPropertiesItem;
import com.azure.resourcemanager.customerinsights.models.CanonicalPropertyValueType;
import org.junit.jupiter.api.Assertions;

public final class CanonicalProfileDefinitionPropertiesItemTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CanonicalProfileDefinitionPropertiesItem model = BinaryData.fromString(
            "{\"profileName\":\"oowsbe\",\"profilePropertyName\":\"nrexkxbhxv\",\"rank\":597932404,\"type\":\"DerivedCategorical\",\"value\":\"mnhjevdyzn\"}")
            .toObject(CanonicalProfileDefinitionPropertiesItem.class);
        Assertions.assertEquals("oowsbe", model.profileName());
        Assertions.assertEquals("nrexkxbhxv", model.profilePropertyName());
        Assertions.assertEquals(597932404, model.rank());
        Assertions.assertEquals(CanonicalPropertyValueType.DERIVED_CATEGORICAL, model.type());
        Assertions.assertEquals("mnhjevdyzn", model.value());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CanonicalProfileDefinitionPropertiesItem model
            = new CanonicalProfileDefinitionPropertiesItem().withProfileName("oowsbe")
                .withProfilePropertyName("nrexkxbhxv")
                .withRank(597932404)
                .withType(CanonicalPropertyValueType.DERIVED_CATEGORICAL)
                .withValue("mnhjevdyzn");
        model = BinaryData.fromObject(model).toObject(CanonicalProfileDefinitionPropertiesItem.class);
        Assertions.assertEquals("oowsbe", model.profileName());
        Assertions.assertEquals("nrexkxbhxv", model.profilePropertyName());
        Assertions.assertEquals(597932404, model.rank());
        Assertions.assertEquals(CanonicalPropertyValueType.DERIVED_CATEGORICAL, model.type());
        Assertions.assertEquals("mnhjevdyzn", model.value());
    }
}
