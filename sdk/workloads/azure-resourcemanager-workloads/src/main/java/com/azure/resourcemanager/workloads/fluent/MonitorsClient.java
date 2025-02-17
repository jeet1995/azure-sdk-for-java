// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.workloads.fluent.models.MonitorInner;
import com.azure.resourcemanager.workloads.fluent.models.OperationStatusResultInner;
import com.azure.resourcemanager.workloads.models.UpdateMonitorRequest;

/**
 * An instance of this class provides access to all the operations defined in MonitorsClient.
 */
public interface MonitorsClient {
    /**
     * Gets a list of SAP monitors in the specified subscription.
     * 
     * Gets a list of SAP monitors in the specified subscription. The operations returns various properties of each SAP
     * monitor.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of SAP monitors in the specified subscription as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitorInner> list();

    /**
     * Gets a list of SAP monitors in the specified subscription.
     * 
     * Gets a list of SAP monitors in the specified subscription. The operations returns various properties of each SAP
     * monitor.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of SAP monitors in the specified subscription as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitorInner> list(Context context);

    /**
     * Gets a list of SAP monitors
     * 
     * Gets a list of SAP monitors in the specified resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of SAP monitors in the specified resource group as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitorInner> listByResourceGroup(String resourceGroupName);

    /**
     * Gets a list of SAP monitors
     * 
     * Gets a list of SAP monitors in the specified resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of SAP monitors in the specified resource group as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<MonitorInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Gets properties of a SAP monitor.
     * 
     * Gets properties of a SAP monitor for the specified subscription, resource group, and resource name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of a SAP monitor for the specified subscription, resource group, and resource name along with
     * {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MonitorInner> getByResourceGroupWithResponse(String resourceGroupName, String monitorName,
        Context context);

    /**
     * Gets properties of a SAP monitor.
     * 
     * Gets properties of a SAP monitor for the specified subscription, resource group, and resource name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of a SAP monitor for the specified subscription, resource group, and resource name.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MonitorInner getByResourceGroup(String resourceGroupName, String monitorName);

    /**
     * Creates a SAP monitor.
     * 
     * Creates a SAP monitor for the specified subscription, resource group, and resource name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param monitorParameter Request body representing a SAP monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of sAP monitor info on Azure (ARM properties and SAP monitor
     * properties).
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<MonitorInner>, MonitorInner> beginCreate(String resourceGroupName, String monitorName,
        MonitorInner monitorParameter);

    /**
     * Creates a SAP monitor.
     * 
     * Creates a SAP monitor for the specified subscription, resource group, and resource name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param monitorParameter Request body representing a SAP monitor.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of sAP monitor info on Azure (ARM properties and SAP monitor
     * properties).
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<MonitorInner>, MonitorInner> beginCreate(String resourceGroupName, String monitorName,
        MonitorInner monitorParameter, Context context);

    /**
     * Creates a SAP monitor.
     * 
     * Creates a SAP monitor for the specified subscription, resource group, and resource name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param monitorParameter Request body representing a SAP monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP monitor info on Azure (ARM properties and SAP monitor properties).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MonitorInner create(String resourceGroupName, String monitorName, MonitorInner monitorParameter);

    /**
     * Creates a SAP monitor.
     * 
     * Creates a SAP monitor for the specified subscription, resource group, and resource name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param monitorParameter Request body representing a SAP monitor.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP monitor info on Azure (ARM properties and SAP monitor properties).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MonitorInner create(String resourceGroupName, String monitorName, MonitorInner monitorParameter, Context context);

    /**
     * Deletes a SAP monitor.
     * 
     * Deletes a SAP monitor with the specified subscription, resource group, and SAP monitor name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String monitorName);

    /**
     * Deletes a SAP monitor.
     * 
     * Deletes a SAP monitor with the specified subscription, resource group, and SAP monitor name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String monitorName, Context context);

    /**
     * Deletes a SAP monitor.
     * 
     * Deletes a SAP monitor with the specified subscription, resource group, and SAP monitor name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String monitorName);

    /**
     * Deletes a SAP monitor.
     * 
     * Deletes a SAP monitor with the specified subscription, resource group, and SAP monitor name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String monitorName, Context context);

    /**
     * Patches the Tags field of a SAP monitor.
     * 
     * Patches the Tags field of a SAP monitor for the specified subscription, resource group, and SAP monitor name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param body The Update SAP workload monitor request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP monitor info on Azure (ARM properties and SAP monitor properties) along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<MonitorInner> updateWithResponse(String resourceGroupName, String monitorName, UpdateMonitorRequest body,
        Context context);

    /**
     * Patches the Tags field of a SAP monitor.
     * 
     * Patches the Tags field of a SAP monitor for the specified subscription, resource group, and SAP monitor name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param monitorName Name of the SAP monitor resource.
     * @param body The Update SAP workload monitor request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return sAP monitor info on Azure (ARM properties and SAP monitor properties).
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    MonitorInner update(String resourceGroupName, String monitorName, UpdateMonitorRequest body);
}
