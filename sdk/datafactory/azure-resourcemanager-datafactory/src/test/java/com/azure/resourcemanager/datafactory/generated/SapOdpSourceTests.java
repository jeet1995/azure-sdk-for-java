// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.SapOdpSource;

public final class SapOdpSourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SapOdpSource model = BinaryData.fromString(
            "{\"type\":\"SapOdpSource\",\"extractionMode\":\"dataiumuzt\",\"subscriberProcess\":\"datajtfmcnrgwgcstozr\",\"selection\":\"dataehmvrveurpzrysef\",\"projection\":\"datachkkwah\",\"queryTimeout\":\"datayrdlvbomhfqsjz\",\"additionalColumns\":\"dataktk\",\"sourceRetryCount\":\"dataxtee\",\"sourceRetryWait\":\"datahxgnlpjytle\",\"maxConcurrentConnections\":\"datamijhnjk\",\"disableMetricsCollection\":\"dataohhuw\",\"\":{\"b\":\"datakzbdeyhwebh\",\"lynd\":\"dataocfvajmmdmb\",\"fzxs\":\"dataqu\"}}")
            .toObject(SapOdpSource.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SapOdpSource model = new SapOdpSource().withSourceRetryCount("dataxtee")
            .withSourceRetryWait("datahxgnlpjytle")
            .withMaxConcurrentConnections("datamijhnjk")
            .withDisableMetricsCollection("dataohhuw")
            .withQueryTimeout("datayrdlvbomhfqsjz")
            .withAdditionalColumns("dataktk")
            .withExtractionMode("dataiumuzt")
            .withSubscriberProcess("datajtfmcnrgwgcstozr")
            .withSelection("dataehmvrveurpzrysef")
            .withProjection("datachkkwah");
        model = BinaryData.fromObject(model).toObject(SapOdpSource.class);
    }
}
