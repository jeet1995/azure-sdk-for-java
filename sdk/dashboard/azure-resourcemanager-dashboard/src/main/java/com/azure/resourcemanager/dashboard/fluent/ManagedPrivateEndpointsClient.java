// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.dashboard.fluent.models.ManagedPrivateEndpointModelInner;
import com.azure.resourcemanager.dashboard.models.ManagedPrivateEndpointUpdateParameters;

/**
 * An instance of this class provides access to all the operations defined in ManagedPrivateEndpointsClient.
 */
public interface ManagedPrivateEndpointsClient {
    /**
     * Refresh and sync managed private endpoints of a grafana resource to latest state.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginRefresh(String resourceGroupName, String workspaceName);

    /**
     * Refresh and sync managed private endpoints of a grafana resource to latest state.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginRefresh(String resourceGroupName, String workspaceName, Context context);

    /**
     * Refresh and sync managed private endpoints of a grafana resource to latest state.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void refresh(String resourceGroupName, String workspaceName);

    /**
     * Refresh and sync managed private endpoints of a grafana resource to latest state.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void refresh(String resourceGroupName, String workspaceName, Context context);

    /**
     * Get a specific managed private endpoint of a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific managed private endpoint of a grafana resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ManagedPrivateEndpointModelInner> getWithResponse(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName, Context context);

    /**
     * Get a specific managed private endpoint of a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific managed private endpoint of a grafana resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ManagedPrivateEndpointModelInner get(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName);

    /**
     * Create or update a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters The managed private endpoint to be created or updated.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ManagedPrivateEndpointModelInner>, ManagedPrivateEndpointModelInner> beginCreate(
        String resourceGroupName, String workspaceName, String managedPrivateEndpointName,
        ManagedPrivateEndpointModelInner requestBodyParameters);

    /**
     * Create or update a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters The managed private endpoint to be created or updated.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ManagedPrivateEndpointModelInner>, ManagedPrivateEndpointModelInner> beginCreate(
        String resourceGroupName, String workspaceName, String managedPrivateEndpointName,
        ManagedPrivateEndpointModelInner requestBodyParameters, Context context);

    /**
     * Create or update a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters The managed private endpoint to be created or updated.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ManagedPrivateEndpointModelInner create(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName, ManagedPrivateEndpointModelInner requestBodyParameters);

    /**
     * Create or update a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters The managed private endpoint to be created or updated.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ManagedPrivateEndpointModelInner create(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName, ManagedPrivateEndpointModelInner requestBodyParameters, Context context);

    /**
     * Update a managed private endpoint for an existing grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters Properties that can be updated to an existing managed private endpoint.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ManagedPrivateEndpointModelInner>, ManagedPrivateEndpointModelInner> beginUpdate(
        String resourceGroupName, String workspaceName, String managedPrivateEndpointName,
        ManagedPrivateEndpointUpdateParameters requestBodyParameters);

    /**
     * Update a managed private endpoint for an existing grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters Properties that can be updated to an existing managed private endpoint.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ManagedPrivateEndpointModelInner>, ManagedPrivateEndpointModelInner> beginUpdate(
        String resourceGroupName, String workspaceName, String managedPrivateEndpointName,
        ManagedPrivateEndpointUpdateParameters requestBodyParameters, Context context);

    /**
     * Update a managed private endpoint for an existing grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters Properties that can be updated to an existing managed private endpoint.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ManagedPrivateEndpointModelInner update(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName, ManagedPrivateEndpointUpdateParameters requestBodyParameters);

    /**
     * Update a managed private endpoint for an existing grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param requestBodyParameters Properties that can be updated to an existing managed private endpoint.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the managed private endpoint resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ManagedPrivateEndpointModelInner update(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName, ManagedPrivateEndpointUpdateParameters requestBodyParameters,
        Context context);

    /**
     * Delete a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName);

    /**
     * Delete a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String workspaceName,
        String managedPrivateEndpointName, Context context);

    /**
     * Delete a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String workspaceName, String managedPrivateEndpointName);

    /**
     * Delete a managed private endpoint for a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param managedPrivateEndpointName The managed private endpoint name of Azure Managed Grafana.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String workspaceName, String managedPrivateEndpointName, Context context);

    /**
     * List all managed private endpoints of a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of managed private endpoints of a grafana resource as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ManagedPrivateEndpointModelInner> list(String resourceGroupName, String workspaceName);

    /**
     * List all managed private endpoints of a grafana resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The workspace name of Azure Managed Grafana.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of managed private endpoints of a grafana resource as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ManagedPrivateEndpointModelInner> list(String resourceGroupName, String workspaceName,
        Context context);
}
