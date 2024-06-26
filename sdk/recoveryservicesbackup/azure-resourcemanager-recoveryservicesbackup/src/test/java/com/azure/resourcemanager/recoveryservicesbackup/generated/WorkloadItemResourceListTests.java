// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.WorkloadItemResourceInner;
import com.azure.resourcemanager.recoveryservicesbackup.models.ProtectionStatus;
import com.azure.resourcemanager.recoveryservicesbackup.models.WorkloadItem;
import com.azure.resourcemanager.recoveryservicesbackup.models.WorkloadItemResourceList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class WorkloadItemResourceListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkloadItemResourceList model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"workloadItemType\":\"WorkloadItem\",\"backupManagementType\":\"qugjhkycube\",\"workloadType\":\"gssofwq\",\"friendlyName\":\"qal\",\"protectionState\":\"ProtectionFailed\"},\"eTag\":\"jijpxac\",\"location\":\"qudf\",\"tags\":{\"yffimrzrtuzqogs\":\"xbaaabjyv\",\"mewzsyyc\":\"xnevfdnwn\",\"judpfrxt\":\"uzsoi\",\"paxh\":\"thzvaytdwkqbrqu\"},\"id\":\"xiilivpdtiirqt\",\"name\":\"qoaxoruzfgs\",\"type\":\"uyfxrxxleptramxj\"}],\"nextLink\":\"wlwnwxuqlcv\"}")
            .toObject(WorkloadItemResourceList.class);
        Assertions.assertEquals("wlwnwxuqlcv", model.nextLink());
        Assertions.assertEquals("qudf", model.value().get(0).location());
        Assertions.assertEquals("xbaaabjyv", model.value().get(0).tags().get("yffimrzrtuzqogs"));
        Assertions.assertEquals("qugjhkycube", model.value().get(0).properties().backupManagementType());
        Assertions.assertEquals("gssofwq", model.value().get(0).properties().workloadType());
        Assertions.assertEquals("qal", model.value().get(0).properties().friendlyName());
        Assertions.assertEquals(ProtectionStatus.PROTECTION_FAILED,
            model.value().get(0).properties().protectionState());
        Assertions.assertEquals("jijpxac", model.value().get(0).etag());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkloadItemResourceList model = new WorkloadItemResourceList().withNextLink("wlwnwxuqlcv")
            .withValue(Arrays.asList(new WorkloadItemResourceInner().withLocation("qudf")
                .withTags(mapOf("yffimrzrtuzqogs", "xbaaabjyv", "mewzsyyc", "xnevfdnwn", "judpfrxt", "uzsoi", "paxh",
                    "thzvaytdwkqbrqu"))
                .withProperties(new WorkloadItem().withBackupManagementType("qugjhkycube")
                    .withWorkloadType("gssofwq")
                    .withFriendlyName("qal")
                    .withProtectionState(ProtectionStatus.PROTECTION_FAILED))
                .withEtag("jijpxac")));
        model = BinaryData.fromObject(model).toObject(WorkloadItemResourceList.class);
        Assertions.assertEquals("wlwnwxuqlcv", model.nextLink());
        Assertions.assertEquals("qudf", model.value().get(0).location());
        Assertions.assertEquals("xbaaabjyv", model.value().get(0).tags().get("yffimrzrtuzqogs"));
        Assertions.assertEquals("qugjhkycube", model.value().get(0).properties().backupManagementType());
        Assertions.assertEquals("gssofwq", model.value().get(0).properties().workloadType());
        Assertions.assertEquals("qal", model.value().get(0).properties().friendlyName());
        Assertions.assertEquals(ProtectionStatus.PROTECTION_FAILED,
            model.value().get(0).properties().protectionState());
        Assertions.assertEquals("jijpxac", model.value().get(0).etag());
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
