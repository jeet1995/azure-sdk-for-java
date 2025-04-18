// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.workloadssapvirtualinstance.generated;

/**
 * Samples for SapCentralServerInstances List.
 */
public final class SapCentralServerInstancesListSamples {
    /*
     * x-ms-original-file: 2024-09-01/SapCentralServerInstances_ListBySapVirtualInstance.json
     */
    /**
     * Sample code: SAPCentralInstances List by SAP virtual instance.
     * 
     * @param manager Entry point to WorkloadsSapVirtualInstanceManager.
     */
    public static void sAPCentralInstancesListBySAPVirtualInstance(
        com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager manager) {
        manager.sapCentralServerInstances().list("test-rg", "X00", com.azure.core.util.Context.NONE);
    }
}
