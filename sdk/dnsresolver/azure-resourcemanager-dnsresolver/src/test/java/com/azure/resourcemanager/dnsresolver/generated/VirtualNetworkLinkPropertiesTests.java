// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dnsresolver.generated;

import com.azure.core.management.SubResource;
import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dnsresolver.fluent.models.VirtualNetworkLinkProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class VirtualNetworkLinkPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VirtualNetworkLinkProperties model = BinaryData.fromString(
            "{\"virtualNetwork\":{\"id\":\"lsicohoqqnwv\"},\"metadata\":{\"qhgyxzkonocukok\":\"avwhheunm\"},\"provisioningState\":\"Creating\"}")
            .toObject(VirtualNetworkLinkProperties.class);
        Assertions.assertEquals("lsicohoqqnwv", model.virtualNetwork().id());
        Assertions.assertEquals("avwhheunm", model.metadata().get("qhgyxzkonocukok"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VirtualNetworkLinkProperties model
            = new VirtualNetworkLinkProperties().withVirtualNetwork(new SubResource().withId("lsicohoqqnwv"))
                .withMetadata(mapOf("qhgyxzkonocukok", "avwhheunm"));
        model = BinaryData.fromObject(model).toObject(VirtualNetworkLinkProperties.class);
        Assertions.assertEquals("lsicohoqqnwv", model.virtualNetwork().id());
        Assertions.assertEquals("avwhheunm", model.metadata().get("qhgyxzkonocukok"));
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
