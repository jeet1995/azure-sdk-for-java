// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

/**
 * Samples for Accounts GetByResourceGroup.
 */
public final class AccountsGetByResourceGroupSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/Accounts_Get.json
     */
    /**
     * Sample code: Accounts_Get.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void accountsGet(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.accounts().getByResourceGroupWithResponse("myRG", "account1", com.azure.core.util.Context.NONE);
    }
}
