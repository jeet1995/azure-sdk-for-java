// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.ImportSettings;
import java.util.HashMap;
import java.util.Map;

public final class ImportSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ImportSettings model = BinaryData.fromString(
            "{\"type\":\"ImportSettings\",\"\":{\"awoyzgaevr\":\"datai\",\"hoplqtzgtpsbym\":\"datagggccpz\",\"arolczahbynl\":\"datafctorqzbqyygfqq\",\"fbyfjslehgee\":\"datawcnnfpfgstd\"}}")
            .toObject(ImportSettings.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ImportSettings model = new ImportSettings().withAdditionalProperties(mapOf("type", "ImportSettings"));
        model = BinaryData.fromObject(model).toObject(ImportSettings.class);
    }

    // Use "Map.of" if available
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
