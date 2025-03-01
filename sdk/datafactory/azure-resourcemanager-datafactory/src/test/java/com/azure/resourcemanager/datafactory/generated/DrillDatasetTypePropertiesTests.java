// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.DrillDatasetTypeProperties;

public final class DrillDatasetTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DrillDatasetTypeProperties model = BinaryData
            .fromString("{\"tableName\":\"datanyfowyj\",\"table\":\"dataakkiub\",\"schema\":\"datakittlrgl\"}")
            .toObject(DrillDatasetTypeProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DrillDatasetTypeProperties model = new DrillDatasetTypeProperties().withTableName("datanyfowyj")
            .withTable("dataakkiub")
            .withSchema("datakittlrgl");
        model = BinaryData.fromObject(model).toObject(DrillDatasetTypeProperties.class);
    }
}
