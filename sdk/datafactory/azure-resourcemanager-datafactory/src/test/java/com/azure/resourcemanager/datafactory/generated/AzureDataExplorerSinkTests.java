// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.AzureDataExplorerSink;

public final class AzureDataExplorerSinkTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureDataExplorerSink model = BinaryData.fromString(
            "{\"type\":\"AzureDataExplorerSink\",\"ingestionMappingName\":\"dataktlzngidgwsco\",\"ingestionMappingAsJson\":\"datahgzapcgdk\",\"flushImmediately\":\"dataa\",\"writeBatchSize\":\"datacpohlfvsb\",\"writeBatchTimeout\":\"datadgzbjb\",\"sinkRetryCount\":\"dataoudc\",\"sinkRetryWait\":\"datalkucxtyufsouhkmc\",\"maxConcurrentConnections\":\"datauomdlspsbg\",\"disableMetricsCollection\":\"datanygroqia\",\"\":{\"yjox\":\"dataoxwndf\",\"ambzprhpwwarz\":\"dataalcyflzuztdwxr\",\"vj\":\"datazbbwtagxhrir\"}}")
            .toObject(AzureDataExplorerSink.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureDataExplorerSink model = new AzureDataExplorerSink().withWriteBatchSize("datacpohlfvsb")
            .withWriteBatchTimeout("datadgzbjb")
            .withSinkRetryCount("dataoudc")
            .withSinkRetryWait("datalkucxtyufsouhkmc")
            .withMaxConcurrentConnections("datauomdlspsbg")
            .withDisableMetricsCollection("datanygroqia")
            .withIngestionMappingName("dataktlzngidgwsco")
            .withIngestionMappingAsJson("datahgzapcgdk")
            .withFlushImmediately("dataa");
        model = BinaryData.fromObject(model).toObject(AzureDataExplorerSink.class);
    }
}
