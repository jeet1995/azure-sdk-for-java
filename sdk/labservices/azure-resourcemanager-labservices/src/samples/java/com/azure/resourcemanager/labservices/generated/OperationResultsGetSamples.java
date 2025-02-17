// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.labservices.generated;

/**
 * Samples for OperationResults Get.
 */
public final class OperationResultsGetSamples {
    /*
     * x-ms-original-file:
     * specification/labservices/resource-manager/Microsoft.LabServices/stable/2022-08-01/examples/OperationResults/
     * getOperationResult.json
     */
    /**
     * Sample code: getOperationResult.
     * 
     * @param manager Entry point to LabServicesManager.
     */
    public static void getOperationResult(com.azure.resourcemanager.labservices.LabServicesManager manager) {
        manager.operationResults()
            .getWithResponse("a64149d8-84cb-4566-ab8e-b4ee1a074174", com.azure.core.util.Context.NONE);
    }
}
