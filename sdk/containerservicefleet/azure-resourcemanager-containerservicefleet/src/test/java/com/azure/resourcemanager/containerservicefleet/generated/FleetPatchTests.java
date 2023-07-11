// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.containerservicefleet.models.FleetPatch;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class FleetPatchTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FleetPatch model = BinaryData.fromString("{\"tags\":{\"f\":\"rgqjbpfzfsinzg\"}}").toObject(FleetPatch.class);
        Assertions.assertEquals("rgqjbpfzfsinzg", model.tags().get("f"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FleetPatch model = new FleetPatch().withTags(mapOf("f", "rgqjbpfzfsinzg"));
        model = BinaryData.fromObject(model).toObject(FleetPatch.class);
        Assertions.assertEquals("rgqjbpfzfsinzg", model.tags().get("f"));
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}