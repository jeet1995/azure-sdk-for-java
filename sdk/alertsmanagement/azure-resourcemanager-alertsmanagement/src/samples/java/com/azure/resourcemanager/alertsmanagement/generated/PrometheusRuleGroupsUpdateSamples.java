// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.alertsmanagement.generated;

import com.azure.resourcemanager.alertsmanagement.models.PrometheusRuleGroupResource;
import com.azure.resourcemanager.alertsmanagement.models.PrometheusRuleGroupResourcePatchProperties;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for PrometheusRuleGroups Update.
 */
public final class PrometheusRuleGroupsUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/alertsmanagement/resource-manager/Microsoft.AlertsManagement/preview/2021-07-22-preview/examples/
     * patchPrometheusRuleGroup.json
     */
    /**
     * Sample code: PatchPrometheusRuleGroup.
     * 
     * @param manager Entry point to AlertsManagementManager.
     */
    public static void
        patchPrometheusRuleGroup(com.azure.resourcemanager.alertsmanagement.AlertsManagementManager manager) {
        PrometheusRuleGroupResource resource = manager.prometheusRuleGroups()
            .getByResourceGroupWithResponse("promResourceGroup", "myPrometheusRuleGroup",
                com.azure.core.util.Context.NONE)
            .getValue();
        resource.update()
            .withTags(mapOf("tag1", "value1"))
            .withProperties(new PrometheusRuleGroupResourcePatchProperties().withEnabled(false))
            .apply();
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
