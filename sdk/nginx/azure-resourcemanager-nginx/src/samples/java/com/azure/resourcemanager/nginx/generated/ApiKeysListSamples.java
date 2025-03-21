// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.nginx.generated;

/**
 * Samples for ApiKeys List.
 */
public final class ApiKeysListSamples {
    /*
     * x-ms-original-file:
     * specification/nginx/resource-manager/NGINX.NGINXPLUS/preview/2024-11-01-preview/examples/ApiKeys_List.json
     */
    /**
     * Sample code: ApiKeys_List.
     * 
     * @param manager Entry point to NginxManager.
     */
    public static void apiKeysList(com.azure.resourcemanager.nginx.NginxManager manager) {
        manager.apiKeys().list("myResourceGroup", "myDeployment", com.azure.core.util.Context.NONE);
    }
}
