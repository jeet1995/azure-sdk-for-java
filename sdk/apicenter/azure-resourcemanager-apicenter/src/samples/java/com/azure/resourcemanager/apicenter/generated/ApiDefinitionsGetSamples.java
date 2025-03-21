// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apicenter.generated;

/**
 * Samples for ApiDefinitions Get.
 */
public final class ApiDefinitionsGetSamples {
    /*
     * x-ms-original-file:
     * specification/apicenter/resource-manager/Microsoft.ApiCenter/stable/2024-03-01/examples/ApiDefinitions_Get.json
     */
    /**
     * Sample code: ApiDefinitions_Get.
     * 
     * @param manager Entry point to ApiCenterManager.
     */
    public static void apiDefinitionsGet(com.azure.resourcemanager.apicenter.ApiCenterManager manager) {
        manager.apiDefinitions()
            .getWithResponse("contoso-resources", "contoso", "default", "echo-api", "2023-01-01", "openapi",
                com.azure.core.util.Context.NONE);
    }
}
