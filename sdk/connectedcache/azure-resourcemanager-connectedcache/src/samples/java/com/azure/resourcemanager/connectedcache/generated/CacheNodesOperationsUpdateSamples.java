// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.connectedcache.generated;

import com.azure.resourcemanager.connectedcache.models.CacheNodePreviewResource;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for CacheNodesOperations Update.
 */
public final class CacheNodesOperationsUpdateSamples {
    /*
     * x-ms-original-file: 2023-05-01-preview/CacheNodesOperations_Update_MaximumSet_Gen.json
     */
    /**
     * Sample code: CacheNodes Private Preview(Legacy) Update Operation - generated by [MaximumSet] rule.
     * 
     * @param manager Entry point to ConnectedCacheManager.
     */
    public static void cacheNodesPrivatePreviewLegacyUpdateOperationGeneratedByMaximumSetRule(
        com.azure.resourcemanager.connectedcache.ConnectedCacheManager manager) {
        CacheNodePreviewResource resource = manager.cacheNodesOperations()
            .getByResourceGroupWithResponse("rgConnectedCache", "wlrwpdbcv", com.azure.core.util.Context.NONE)
            .getValue();
        resource.update().withTags(mapOf("key5032", "fakeTokenPlaceholder")).apply();
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
