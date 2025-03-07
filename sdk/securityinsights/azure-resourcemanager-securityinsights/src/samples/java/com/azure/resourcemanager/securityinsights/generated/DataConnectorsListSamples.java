// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

/**
 * Samples for DataConnectors List.
 */
public final class DataConnectorsListSamples {
    /*
     * x-ms-original-file:
     * specification/securityinsights/resource-manager/Microsoft.SecurityInsights/stable/2022-11-01/examples/
     * dataConnectors/GetDataConnectors.json
     */
    /**
     * Sample code: Get all data connectors.
     * 
     * @param manager Entry point to SecurityInsightsManager.
     */
    public static void
        getAllDataConnectors(com.azure.resourcemanager.securityinsights.SecurityInsightsManager manager) {
        manager.dataConnectors().list("myRg", "myWorkspace", com.azure.core.util.Context.NONE);
    }
}
