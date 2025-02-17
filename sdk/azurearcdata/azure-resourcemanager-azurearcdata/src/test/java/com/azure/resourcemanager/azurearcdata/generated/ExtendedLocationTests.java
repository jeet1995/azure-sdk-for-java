// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurearcdata.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.azurearcdata.models.ExtendedLocation;
import com.azure.resourcemanager.azurearcdata.models.ExtendedLocationTypes;
import org.junit.jupiter.api.Assertions;

public final class ExtendedLocationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ExtendedLocation model = BinaryData.fromString("{\"name\":\"zoqftiyqzrnkcqvy\",\"type\":\"CustomLocation\"}")
            .toObject(ExtendedLocation.class);
        Assertions.assertEquals("zoqftiyqzrnkcqvy", model.name());
        Assertions.assertEquals(ExtendedLocationTypes.CUSTOM_LOCATION, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ExtendedLocation model
            = new ExtendedLocation().withName("zoqftiyqzrnkcqvy").withType(ExtendedLocationTypes.CUSTOM_LOCATION);
        model = BinaryData.fromObject(model).toObject(ExtendedLocation.class);
        Assertions.assertEquals("zoqftiyqzrnkcqvy", model.name());
        Assertions.assertEquals(ExtendedLocationTypes.CUSTOM_LOCATION, model.type());
    }
}
