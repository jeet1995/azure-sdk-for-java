// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.models.ScheduleActionBase;

public final class ScheduleActionBaseTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ScheduleActionBase model
            = BinaryData.fromString("{\"actionType\":\"ScheduleActionBase\"}").toObject(ScheduleActionBase.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ScheduleActionBase model = new ScheduleActionBase();
        model = BinaryData.fromObject(model).toObject(ScheduleActionBase.class);
    }
}
