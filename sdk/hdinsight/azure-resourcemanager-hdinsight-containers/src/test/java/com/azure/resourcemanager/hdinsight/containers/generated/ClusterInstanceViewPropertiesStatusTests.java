// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.containers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hdinsight.containers.models.ClusterInstanceViewPropertiesStatus;
import org.junit.jupiter.api.Assertions;

public final class ClusterInstanceViewPropertiesStatusTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ClusterInstanceViewPropertiesStatus model
            = BinaryData.fromString("{\"ready\":\"rmaequ\",\"reason\":\"hxicslfaoqz\",\"message\":\"yylhalnswhccsp\"}")
                .toObject(ClusterInstanceViewPropertiesStatus.class);
        Assertions.assertEquals("rmaequ", model.ready());
        Assertions.assertEquals("hxicslfaoqz", model.reason());
        Assertions.assertEquals("yylhalnswhccsp", model.message());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ClusterInstanceViewPropertiesStatus model = new ClusterInstanceViewPropertiesStatus().withReady("rmaequ")
            .withReason("hxicslfaoqz").withMessage("yylhalnswhccsp");
        model = BinaryData.fromObject(model).toObject(ClusterInstanceViewPropertiesStatus.class);
        Assertions.assertEquals("rmaequ", model.ready());
        Assertions.assertEquals("hxicslfaoqz", model.reason());
        Assertions.assertEquals("yylhalnswhccsp", model.message());
    }
}
