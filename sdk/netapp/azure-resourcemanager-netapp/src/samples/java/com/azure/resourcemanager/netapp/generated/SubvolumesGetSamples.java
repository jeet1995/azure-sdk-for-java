// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

/**
 * Samples for Subvolumes Get.
 */
public final class SubvolumesGetSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/Subvolumes_Get.json
     */
    /**
     * Sample code: Subvolumes_Get.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void subvolumesGet(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.subvolumes()
            .getWithResponse("myRG", "account1", "pool1", "volume1", "subvolume1", com.azure.core.util.Context.NONE);
    }
}
