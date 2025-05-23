// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.springappdiscovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.springappdiscovery.models.ProvisioningState;
import com.azure.resourcemanager.springappdiscovery.models.SpringbootsitesPatch;
import com.azure.resourcemanager.springappdiscovery.models.SpringbootsitesProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class SpringbootsitesPatchTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SpringbootsitesPatch model = BinaryData.fromString(
            "{\"properties\":{\"masterSiteId\":\"jpsq\",\"migrateProjectId\":\"mpoyfd\",\"provisioningState\":\"Succeeded\"},\"location\":\"knygjofjddeq\",\"tags\":{\"flusarhmof\":\"eupewnwreitjz\",\"he\":\"qhsmyurkdtml\",\"rcryuanzwuxzdxta\":\"uksjtxukcdmp\"},\"id\":\"rlhm\",\"name\":\"hfpmrqobmtukknr\",\"type\":\"rtihfxtijbpz\"}")
            .toObject(SpringbootsitesPatch.class);
        Assertions.assertEquals("knygjofjddeq", model.location());
        Assertions.assertEquals("eupewnwreitjz", model.tags().get("flusarhmof"));
        Assertions.assertEquals("jpsq", model.properties().masterSiteId());
        Assertions.assertEquals("mpoyfd", model.properties().migrateProjectId());
        Assertions.assertEquals(ProvisioningState.SUCCEEDED, model.properties().provisioningState());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SpringbootsitesPatch model = new SpringbootsitesPatch().withLocation("knygjofjddeq")
            .withTags(mapOf("flusarhmof", "eupewnwreitjz", "he", "qhsmyurkdtml", "rcryuanzwuxzdxta", "uksjtxukcdmp"))
            .withProperties(new SpringbootsitesProperties().withMasterSiteId("jpsq")
                .withMigrateProjectId("mpoyfd")
                .withProvisioningState(ProvisioningState.SUCCEEDED));
        model = BinaryData.fromObject(model).toObject(SpringbootsitesPatch.class);
        Assertions.assertEquals("knygjofjddeq", model.location());
        Assertions.assertEquals("eupewnwreitjz", model.tags().get("flusarhmof"));
        Assertions.assertEquals("jpsq", model.properties().masterSiteId());
        Assertions.assertEquals("mpoyfd", model.properties().migrateProjectId());
        Assertions.assertEquals(ProvisioningState.SUCCEEDED, model.properties().provisioningState());
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
