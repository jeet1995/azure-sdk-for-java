// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

/**
 * Samples for WebApps GetAppSettingKeyVaultReferenceSlot.
 */
public final class WebAppsGetAppSettingKeyVaultReferenceSlotSamples {
    /*
     * x-ms-original-file: specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/
     * GetKeyVaultReferencesForAppSettingSlot.json
     */
    /**
     * Sample code: Get Azure Key Vault slot app setting reference.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getAzureKeyVaultSlotAppSettingReference(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getWebApps()
            .getAppSettingKeyVaultReferenceSlotWithResponse("testrg123", "testc6282", "setting", "stage",
                com.azure.core.util.Context.NONE);
    }
}
