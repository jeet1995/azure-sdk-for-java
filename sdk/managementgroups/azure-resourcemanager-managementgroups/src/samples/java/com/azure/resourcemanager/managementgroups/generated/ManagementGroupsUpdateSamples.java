// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managementgroups.generated;

import com.azure.resourcemanager.managementgroups.models.PatchManagementGroupRequest;

/**
 * Samples for ManagementGroups Update.
 */
public final class ManagementGroupsUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/managementgroups/resource-manager/Microsoft.Management/stable/2021-04-01/examples/
     * PatchManagementGroup.json
     */
    /**
     * Sample code: PatchManagementGroup.
     * 
     * @param manager Entry point to ManagementGroupsManager.
     */
    public static void
        patchManagementGroup(com.azure.resourcemanager.managementgroups.ManagementGroupsManager manager) {
        manager.managementGroups()
            .updateWithResponse("ChildGroup",
                new PatchManagementGroupRequest().withDisplayName("AlternateDisplayName")
                    .withParentGroupId("/providers/Microsoft.Management/managementGroups/AlternateRootGroup"),
                "no-cache", com.azure.core.util.Context.NONE);
    }
}
