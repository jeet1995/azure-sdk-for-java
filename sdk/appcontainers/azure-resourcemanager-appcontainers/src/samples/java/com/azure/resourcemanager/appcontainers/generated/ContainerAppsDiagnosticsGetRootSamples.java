// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

/**
 * Samples for ContainerAppsDiagnostics GetRoot.
 */
public final class ContainerAppsDiagnosticsGetRootSamples {
    /*
     * x-ms-original-file:
     * specification/app/resource-manager/Microsoft.App/stable/2025-01-01/examples/ContainerApps_Get.json
     */
    /**
     * Sample code: Get Container App.
     * 
     * @param manager Entry point to ContainerAppsApiManager.
     */
    public static void getContainerApp(com.azure.resourcemanager.appcontainers.ContainerAppsApiManager manager) {
        manager.containerAppsDiagnostics()
            .getRootWithResponse("rg", "testcontainerapp0", com.azure.core.util.Context.NONE);
    }
}
