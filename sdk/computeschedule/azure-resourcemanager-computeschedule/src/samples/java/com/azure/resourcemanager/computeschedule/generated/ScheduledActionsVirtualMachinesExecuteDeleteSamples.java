// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.generated;

import com.azure.resourcemanager.computeschedule.models.ExecuteDeleteRequest;
import com.azure.resourcemanager.computeschedule.models.ExecutionParameters;
import com.azure.resourcemanager.computeschedule.models.Resources;
import com.azure.resourcemanager.computeschedule.models.RetryPolicy;
import java.util.Arrays;

/**
 * Samples for ScheduledActions VirtualMachinesExecuteDelete.
 */
public final class ScheduledActionsVirtualMachinesExecuteDeleteSamples {
    /*
     * x-ms-original-file: 2025-04-15-preview/ScheduledActions_VirtualMachinesExecuteDelete_MinimumSet_Gen.json
     */
    /**
     * Sample code: ScheduledActions_VirtualMachinesExecuteDelete_MinimumSet_Gen - generated by [MinimumSet] rule.
     * 
     * @param manager Entry point to ComputeScheduleManager.
     */
    public static void scheduledActionsVirtualMachinesExecuteDeleteMinimumSetGenGeneratedByMinimumSetRule(
        com.azure.resourcemanager.computeschedule.ComputeScheduleManager manager) {
        manager.scheduledActions()
            .virtualMachinesExecuteDeleteWithResponse("east", new ExecuteDeleteRequest()
                .withExecutionParameters(new ExecutionParameters())
                .withResources(new Resources().withIds(Arrays.asList(
                    "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Compute/virtualMachines/testResource3",
                    "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Compute/virtualMachines/testResource4"))),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: 2025-04-15-preview/ScheduledActions_VirtualMachinesExecuteDelete_MaximumSet_Gen.json
     */
    /**
     * Sample code: ScheduledActions_VirtualMachinesExecuteDelete_MaximumSet_Gen - generated by [MaximumSet] rule.
     * 
     * @param manager Entry point to ComputeScheduleManager.
     */
    public static void scheduledActionsVirtualMachinesExecuteDeleteMaximumSetGenGeneratedByMaximumSetRule(
        com.azure.resourcemanager.computeschedule.ComputeScheduleManager manager) {
        manager.scheduledActions()
            .virtualMachinesExecuteDeleteWithResponse("east", new ExecuteDeleteRequest()
                .withExecutionParameters(new ExecutionParameters()
                    .withRetryPolicy(new RetryPolicy().withRetryCount(2).withRetryWindowInMinutes(4)))
                .withResources(new Resources().withIds(Arrays.asList(
                    "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Compute/virtualMachines/testResource3",
                    "/subscriptions/YourSubscriptionId/resourceGroups/YourResourceGroupName/providers/Microsoft.Compute/virtualMachines/testResource4")))
                .withCorrelationid("dfe927c5-16a6-40b7-a0f7-8524975ed642")
                .withForceDeletion(false), com.azure.core.util.Context.NONE);
    }
}
