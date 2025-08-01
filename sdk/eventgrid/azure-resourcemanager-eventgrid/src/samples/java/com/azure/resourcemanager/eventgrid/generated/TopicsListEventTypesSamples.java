// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

/**
 * Samples for Topics ListEventTypes.
 */
public final class TopicsListEventTypesSamples {
    /*
     * x-ms-original-file:
     * specification/eventgrid/resource-manager/Microsoft.EventGrid/preview/2025-04-01-preview/examples/
     * Topics_ListEventTypes.json
     */
    /**
     * Sample code: Topics_ListEventTypes.
     * 
     * @param manager Entry point to EventGridManager.
     */
    public static void topicsListEventTypes(com.azure.resourcemanager.eventgrid.EventGridManager manager) {
        manager.topics()
            .listEventTypes("examplerg", "Microsoft.Storage", "storageAccounts", "ExampleStorageAccount",
                com.azure.core.util.Context.NONE);
    }
}
