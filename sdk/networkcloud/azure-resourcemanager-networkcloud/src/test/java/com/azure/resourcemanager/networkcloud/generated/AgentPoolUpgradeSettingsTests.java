// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.networkcloud.models.AgentPoolUpgradeSettings;
import org.junit.jupiter.api.Assertions;

public final class AgentPoolUpgradeSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AgentPoolUpgradeSettings model =
            BinaryData.fromString("{\"maxSurge\":\"bpodxunkbebxm\"}").toObject(AgentPoolUpgradeSettings.class);
        Assertions.assertEquals("bpodxunkbebxm", model.maxSurge());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AgentPoolUpgradeSettings model = new AgentPoolUpgradeSettings().withMaxSurge("bpodxunkbebxm");
        model = BinaryData.fromObject(model).toObject(AgentPoolUpgradeSettings.class);
        Assertions.assertEquals("bpodxunkbebxm", model.maxSurge());
    }
}