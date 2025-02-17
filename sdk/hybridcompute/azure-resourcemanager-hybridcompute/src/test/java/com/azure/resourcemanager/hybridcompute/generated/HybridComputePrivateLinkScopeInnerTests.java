// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridcompute.fluent.models.HybridComputePrivateLinkScopeInner;
import com.azure.resourcemanager.hybridcompute.models.HybridComputePrivateLinkScopeProperties;
import com.azure.resourcemanager.hybridcompute.models.PublicNetworkAccessType;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class HybridComputePrivateLinkScopeInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HybridComputePrivateLinkScopeInner model = BinaryData.fromString(
            "{\"properties\":{\"publicNetworkAccess\":\"SecuredByPerimeter\",\"provisioningState\":\"reafxtsgumhjg\",\"privateLinkScopeId\":\"kkxwslol\",\"privateEndpointConnections\":[{\"id\":\"uzlm\",\"name\":\"elfk\",\"type\":\"plcrpwjxeznoig\",\"properties\":{\"privateEndpoint\":{\"id\":\"w\"},\"privateLinkServiceConnectionState\":{\"status\":\"kpnb\",\"description\":\"azej\",\"actionsRequired\":\"qkagfhsxt\"},\"provisioningState\":\"ugzxnf\",\"groupIds\":[\"pxdtnkdmkq\",\"jlwuenvrkp\"]}},{\"id\":\"uaibrebqaaysj\",\"name\":\"xqtnq\",\"type\":\"ezl\",\"properties\":{\"privateEndpoint\":{\"id\":\"iakp\"},\"privateLinkServiceConnectionState\":{\"status\":\"qqmtedltmmji\",\"description\":\"yeozphvwauyqncy\",\"actionsRequired\":\"p\"},\"provisioningState\":\"ipmdscwx\",\"groupIds\":[\"evzhfsto\",\"xhojuj\"]}}]},\"location\":\"pelmcuvhixbjxyf\",\"tags\":{\"kkbnu\":\"lrcoolsttpki\"},\"id\":\"rywvtylbfpn\",\"name\":\"urdoi\",\"type\":\"iithtywu\"}")
            .toObject(HybridComputePrivateLinkScopeInner.class);
        Assertions.assertEquals("pelmcuvhixbjxyf", model.location());
        Assertions.assertEquals("lrcoolsttpki", model.tags().get("kkbnu"));
        Assertions.assertEquals(PublicNetworkAccessType.SECURED_BY_PERIMETER, model.properties().publicNetworkAccess());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HybridComputePrivateLinkScopeInner model
            = new HybridComputePrivateLinkScopeInner().withLocation("pelmcuvhixbjxyf")
                .withTags(mapOf("kkbnu", "lrcoolsttpki"))
                .withProperties(new HybridComputePrivateLinkScopeProperties()
                    .withPublicNetworkAccess(PublicNetworkAccessType.SECURED_BY_PERIMETER));
        model = BinaryData.fromObject(model).toObject(HybridComputePrivateLinkScopeInner.class);
        Assertions.assertEquals("pelmcuvhixbjxyf", model.location());
        Assertions.assertEquals("lrcoolsttpki", model.tags().get("kkbnu"));
        Assertions.assertEquals(PublicNetworkAccessType.SECURED_BY_PERIMETER, model.properties().publicNetworkAccess());
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
