// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

/**
 * Samples for NetworkConnections List.
 */
public final class NetworkConnectionsListSamples {
    /*
     * x-ms-original-file: specification/devcenter/resource-manager/Microsoft.DevCenter/stable/2024-02-01/examples/
     * NetworkConnections_ListBySubscription.json
     */
    /**
     * Sample code: NetworkConnections_ListBySubscription.
     * 
     * @param manager Entry point to DevCenterManager.
     */
    public static void
        networkConnectionsListBySubscription(com.azure.resourcemanager.devcenter.DevCenterManager manager) {
        manager.networkConnections().list(null, com.azure.core.util.Context.NONE);
    }
}
