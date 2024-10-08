// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.fluent.models.PrivateLinkResourceListResultInner;
import com.azure.resourcemanager.machinelearning.models.ManagedServiceIdentity;
import com.azure.resourcemanager.machinelearning.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.machinelearning.models.PrivateLinkResource;
import com.azure.resourcemanager.machinelearning.models.Sku;
import com.azure.resourcemanager.machinelearning.models.SkuTier;
import com.azure.resourcemanager.machinelearning.models.UserAssignedIdentity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class PrivateLinkResourceListResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateLinkResourceListResultInner model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"groupId\":\"kxbpvj\",\"requiredMembers\":[\"hx\",\"j\"],\"requiredZoneNames\":[\"u\",\"ivkrtsw\",\"xqzvszjfa\",\"vjfdx\"]},\"identity\":{\"principalId\":\"cde7106e-f687-457b-953d-160358a98cb8\",\"tenantId\":\"b2a0392a-e179-4547-bb44-cbac7877dc8e\",\"type\":\"None\",\"userAssignedIdentities\":{\"aqtdoqmcbx\":{\"principalId\":\"9389f316-753e-4d08-a143-e831c8706855\",\"clientId\":\"71473aad-896e-43bb-905c-9f8590405541\"}}},\"location\":\"vxysl\",\"tags\":{\"tkblmpewww\":\"sfxobl\",\"hxcr\":\"bkrvrnsvshqj\",\"sub\":\"bfovasrruvwbhsq\"},\"sku\":{\"name\":\"jbi\",\"tier\":\"Standard\",\"size\":\"ybsrfbjfdtwss\",\"family\":\"ftpvjzbexil\",\"capacity\":1948356330},\"id\":\"qqnvwpmq\",\"name\":\"aruoujmkcjhwqyt\",\"type\":\"r\"},{\"properties\":{\"groupId\":\"wj\",\"requiredMembers\":[\"drjervnaenqpehin\",\"oygmift\",\"nzdndslgna\",\"qig\"],\"requiredZoneNames\":[\"uhavhql\",\"thuma\",\"olbgycduiertgccy\"]},\"identity\":{\"principalId\":\"8910f182-37ab-4413-a0c8-0ba60bcbc8e4\",\"tenantId\":\"7b8f494f-ab18-4c0a-b288-eec3e51f7ffd\",\"type\":\"None\",\"userAssignedIdentities\":{\"qlfmmdnbb\":{\"principalId\":\"c00154c9-b7bd-4a3e-8175-9d4a4d3a953e\",\"clientId\":\"52ebf4da-e9ed-4098-9312-15cbc1e98be0\"}}},\"location\":\"zpswiydmc\",\"tags\":{\"dbzm\":\"zdxss\",\"cblylpstdbhhxsr\":\"vdfznudaodvxzb\",\"erscdntne\":\"dzu\"},\"sku\":{\"name\":\"iwjmygtdssls\",\"tier\":\"Standard\",\"size\":\"eriofzpyqs\",\"family\":\"wab\",\"capacity\":334511461},\"id\":\"hhszh\",\"name\":\"d\",\"type\":\"lvwiwubmwmbesl\"}]}")
            .toObject(PrivateLinkResourceListResultInner.class);
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.value().get(0).identity().type());
        Assertions.assertEquals("vxysl", model.value().get(0).location());
        Assertions.assertEquals("sfxobl", model.value().get(0).tags().get("tkblmpewww"));
        Assertions.assertEquals("jbi", model.value().get(0).sku().name());
        Assertions.assertEquals(SkuTier.STANDARD, model.value().get(0).sku().tier());
        Assertions.assertEquals("ybsrfbjfdtwss", model.value().get(0).sku().size());
        Assertions.assertEquals("ftpvjzbexil", model.value().get(0).sku().family());
        Assertions.assertEquals(1948356330, model.value().get(0).sku().capacity());
        Assertions.assertEquals("u", model.value().get(0).requiredZoneNames().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateLinkResourceListResultInner model = new PrivateLinkResourceListResultInner().withValue(Arrays.asList(
            new PrivateLinkResource()
                .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.NONE)
                    .withUserAssignedIdentities(mapOf("aqtdoqmcbx", new UserAssignedIdentity())))
                .withLocation("vxysl")
                .withTags(mapOf("tkblmpewww", "sfxobl", "hxcr", "bkrvrnsvshqj", "sub", "bfovasrruvwbhsq"))
                .withSku(new Sku().withName("jbi")
                    .withTier(SkuTier.STANDARD)
                    .withSize("ybsrfbjfdtwss")
                    .withFamily("ftpvjzbexil")
                    .withCapacity(1948356330))
                .withRequiredZoneNames(Arrays.asList("u", "ivkrtsw", "xqzvszjfa", "vjfdx")),
            new PrivateLinkResource()
                .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.NONE)
                    .withUserAssignedIdentities(mapOf("qlfmmdnbb", new UserAssignedIdentity())))
                .withLocation("zpswiydmc")
                .withTags(mapOf("dbzm", "zdxss", "cblylpstdbhhxsr", "vdfznudaodvxzb", "erscdntne", "dzu"))
                .withSku(new Sku().withName("iwjmygtdssls")
                    .withTier(SkuTier.STANDARD)
                    .withSize("eriofzpyqs")
                    .withFamily("wab")
                    .withCapacity(334511461))
                .withRequiredZoneNames(Arrays.asList("uhavhql", "thuma", "olbgycduiertgccy"))));
        model = BinaryData.fromObject(model).toObject(PrivateLinkResourceListResultInner.class);
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.value().get(0).identity().type());
        Assertions.assertEquals("vxysl", model.value().get(0).location());
        Assertions.assertEquals("sfxobl", model.value().get(0).tags().get("tkblmpewww"));
        Assertions.assertEquals("jbi", model.value().get(0).sku().name());
        Assertions.assertEquals(SkuTier.STANDARD, model.value().get(0).sku().tier());
        Assertions.assertEquals("ybsrfbjfdtwss", model.value().get(0).sku().size());
        Assertions.assertEquals("ftpvjzbexil", model.value().get(0).sku().family());
        Assertions.assertEquals(1948356330, model.value().get(0).sku().capacity());
        Assertions.assertEquals("u", model.value().get(0).requiredZoneNames().get(0));
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
