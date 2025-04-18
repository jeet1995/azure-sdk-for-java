// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.SapOpenHubTableDatasetTypeProperties;

public final class SapOpenHubTableDatasetTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SapOpenHubTableDatasetTypeProperties model = BinaryData.fromString(
            "{\"openHubDestinationName\":\"dataf\",\"excludeLastRequest\":\"dataxcebnbeo\",\"baseRequestId\":\"dataemqqerwqx\"}")
            .toObject(SapOpenHubTableDatasetTypeProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SapOpenHubTableDatasetTypeProperties model
            = new SapOpenHubTableDatasetTypeProperties().withOpenHubDestinationName("dataf")
                .withExcludeLastRequest("dataxcebnbeo")
                .withBaseRequestId("dataemqqerwqx");
        model = BinaryData.fromObject(model).toObject(SapOpenHubTableDatasetTypeProperties.class);
    }
}
