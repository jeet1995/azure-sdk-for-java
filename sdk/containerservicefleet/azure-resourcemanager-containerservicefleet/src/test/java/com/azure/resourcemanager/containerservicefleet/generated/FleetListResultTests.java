// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.containerservicefleet.fluent.models.FleetInner;
import com.azure.resourcemanager.containerservicefleet.models.FleetListResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class FleetListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FleetListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"provisioningState\":\"Succeeded\"},\"eTag\":\"xqhabi\",\"location\":\"ikxwc\",\"tags\":{\"n\":\"scnpqxuhivy\",\"rkxvdum\":\"wby\"},\"id\":\"grtfwvu\",\"name\":\"xgaudccs\",\"type\":\"h\"}],\"nextLink\":\"cnyejhkryhtnapcz\"}")
                .toObject(FleetListResult.class);
        Assertions.assertEquals("ikxwc", model.value().get(0).location());
        Assertions.assertEquals("scnpqxuhivy", model.value().get(0).tags().get("n"));
        Assertions.assertEquals("cnyejhkryhtnapcz", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FleetListResult model =
            new FleetListResult()
                .withValue(
                    Arrays
                        .asList(
                            new FleetInner()
                                .withLocation("ikxwc")
                                .withTags(mapOf("n", "scnpqxuhivy", "rkxvdum", "wby"))))
                .withNextLink("cnyejhkryhtnapcz");
        model = BinaryData.fromObject(model).toObject(FleetListResult.class);
        Assertions.assertEquals("ikxwc", model.value().get(0).location());
        Assertions.assertEquals("scnpqxuhivy", model.value().get(0).tags().get("n"));
        Assertions.assertEquals("cnyejhkryhtnapcz", model.nextLink());
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