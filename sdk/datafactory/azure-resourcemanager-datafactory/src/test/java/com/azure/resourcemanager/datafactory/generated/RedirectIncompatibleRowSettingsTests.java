// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.RedirectIncompatibleRowSettings;
import java.util.HashMap;
import java.util.Map;

public final class RedirectIncompatibleRowSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RedirectIncompatibleRowSettings model = BinaryData.fromString(
            "{\"linkedServiceName\":\"databsspexejhwpnjc\",\"path\":\"datacj\",\"\":{\"jsrdecbowkhma\":\"datavuvmdzdqtirgu\",\"sujx\":\"datafllpdn\",\"aeykueat\":\"dataueqljzkhn\"}}")
            .toObject(RedirectIncompatibleRowSettings.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RedirectIncompatibleRowSettings model
            = new RedirectIncompatibleRowSettings().withLinkedServiceName("databsspexejhwpnjc")
                .withPath("datacj")
                .withAdditionalProperties(mapOf());
        model = BinaryData.fromObject(model).toObject(RedirectIncompatibleRowSettings.class);
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
