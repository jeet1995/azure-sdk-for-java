// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databoxedge.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.databoxedge.fluent.models.NodeProperties;

public final class NodePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NodeProperties model = BinaryData.fromString(
            "{\"nodeStatus\":\"Down\",\"nodeChassisSerialNumber\":\"ellwptfdy\",\"nodeSerialNumber\":\"fqbuaceopzf\",\"nodeDisplayName\":\"hhuao\",\"nodeFriendlySoftwareVersion\":\"pcqeqx\",\"nodeHcsVersion\":\"z\",\"nodeInstanceId\":\"hzxct\"}")
            .toObject(NodeProperties.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NodeProperties model = new NodeProperties();
        model = BinaryData.fromObject(model).toObject(NodeProperties.class);
    }
}
