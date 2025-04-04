// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.RestSource;

public final class RestSourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RestSource model = BinaryData.fromString(
            "{\"type\":\"RestSource\",\"requestMethod\":\"datafeavz\",\"requestBody\":\"datammzisljxphwy\",\"additionalHeaders\":\"datamcpfrakucgjreoac\",\"paginationRules\":\"dataaboozxkdzmtkmn\",\"httpRequestTimeout\":\"datafdemrc\",\"requestInterval\":\"dataxgpkyetm\",\"additionalColumns\":\"datahihixisdvyflkeqg\",\"sourceRetryCount\":\"datajsbtosiwcve\",\"sourceRetryWait\":\"dataehbw\",\"maxConcurrentConnections\":\"dataoc\",\"disableMetricsCollection\":\"datazlfhhwdajfth\",\"\":{\"on\":\"datauomj\",\"qsniobehxxb\":\"datafq\"}}")
            .toObject(RestSource.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RestSource model = new RestSource().withSourceRetryCount("datajsbtosiwcve")
            .withSourceRetryWait("dataehbw")
            .withMaxConcurrentConnections("dataoc")
            .withDisableMetricsCollection("datazlfhhwdajfth")
            .withRequestMethod("datafeavz")
            .withRequestBody("datammzisljxphwy")
            .withAdditionalHeaders("datamcpfrakucgjreoac")
            .withPaginationRules("dataaboozxkdzmtkmn")
            .withHttpRequestTimeout("datafdemrc")
            .withRequestInterval("dataxgpkyetm")
            .withAdditionalColumns("datahihixisdvyflkeqg");
        model = BinaryData.fromObject(model).toObject(RestSource.class);
    }
}
