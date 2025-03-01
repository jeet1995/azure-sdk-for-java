// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.synapse.fluent.models.IntegrationRuntimeOutboundNetworkDependenciesEndpointsResponseInner;
import com.azure.resourcemanager.synapse.fluent.models.IntegrationRuntimeResourceInner;
import com.azure.resourcemanager.synapse.fluent.models.IntegrationRuntimeStatusResponseInner;
import com.azure.resourcemanager.synapse.models.UpdateIntegrationRuntimeRequest;

/**
 * An instance of this class provides access to all the operations defined in IntegrationRuntimesClient.
 */
public interface IntegrationRuntimesClient {
    /**
     * Update integration runtime
     * 
     * Update an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param updateIntegrationRuntimeRequest The parameters for updating an integration runtime.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return integration runtime resource type along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<IntegrationRuntimeResourceInner> updateWithResponse(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, UpdateIntegrationRuntimeRequest updateIntegrationRuntimeRequest,
        Context context);

    /**
     * Update integration runtime
     * 
     * Update an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param updateIntegrationRuntimeRequest The parameters for updating an integration runtime.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return integration runtime resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeResourceInner update(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, UpdateIntegrationRuntimeRequest updateIntegrationRuntimeRequest);

    /**
     * Get integration runtime
     * 
     * Get an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param ifNoneMatch ETag of the integration runtime entity. Should only be specified for get. If the ETag matches
     * the existing entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an integration runtime along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<IntegrationRuntimeResourceInner> getWithResponse(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, String ifNoneMatch, Context context);

    /**
     * Get integration runtime
     * 
     * Get an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an integration runtime.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeResourceInner get(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Create integration runtime
     * 
     * Create an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param integrationRuntime Integration runtime resource definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of integration runtime resource type.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<IntegrationRuntimeResourceInner>, IntegrationRuntimeResourceInner> beginCreate(
        String resourceGroupName, String workspaceName, String integrationRuntimeName,
        IntegrationRuntimeResourceInner integrationRuntime);

    /**
     * Create integration runtime
     * 
     * Create an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param integrationRuntime Integration runtime resource definition.
     * @param ifMatch ETag of the integration runtime entity. Should only be specified for update, for which it should
     * match existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of integration runtime resource type.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<IntegrationRuntimeResourceInner>, IntegrationRuntimeResourceInner> beginCreate(
        String resourceGroupName, String workspaceName, String integrationRuntimeName,
        IntegrationRuntimeResourceInner integrationRuntime, String ifMatch, Context context);

    /**
     * Create integration runtime
     * 
     * Create an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param integrationRuntime Integration runtime resource definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return integration runtime resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeResourceInner create(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, IntegrationRuntimeResourceInner integrationRuntime);

    /**
     * Create integration runtime
     * 
     * Create an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param integrationRuntime Integration runtime resource definition.
     * @param ifMatch ETag of the integration runtime entity. Should only be specified for update, for which it should
     * match existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return integration runtime resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeResourceInner create(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, IntegrationRuntimeResourceInner integrationRuntime, String ifMatch,
        Context context);

    /**
     * Delete integration runtime
     * 
     * Delete an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String workspaceName,
        String integrationRuntimeName);

    /**
     * Delete integration runtime
     * 
     * Delete an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, Context context);

    /**
     * Delete integration runtime
     * 
     * Delete an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Delete integration runtime
     * 
     * Delete an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String workspaceName, String integrationRuntimeName, Context context);

    /**
     * Upgrade integration runtime
     * 
     * Upgrade an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> upgradeWithResponse(String resourceGroupName, String workspaceName, String integrationRuntimeName,
        Context context);

    /**
     * Upgrade integration runtime
     * 
     * Upgrade an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void upgrade(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * List integration runtimes
     * 
     * List all integration runtimes.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of integration runtime resources as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<IntegrationRuntimeResourceInner> listByWorkspace(String resourceGroupName, String workspaceName);

    /**
     * List integration runtimes
     * 
     * List all integration runtimes.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of integration runtime resources as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<IntegrationRuntimeResourceInner> listByWorkspace(String resourceGroupName, String workspaceName,
        Context context);

    /**
     * Start integration runtime
     * 
     * Start an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of integration runtime status response.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<IntegrationRuntimeStatusResponseInner>, IntegrationRuntimeStatusResponseInner>
        beginStart(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Start integration runtime
     * 
     * Start an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of integration runtime status response.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<IntegrationRuntimeStatusResponseInner>, IntegrationRuntimeStatusResponseInner>
        beginStart(String resourceGroupName, String workspaceName, String integrationRuntimeName, Context context);

    /**
     * Start integration runtime
     * 
     * Start an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return integration runtime status response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeStatusResponseInner start(String resourceGroupName, String workspaceName,
        String integrationRuntimeName);

    /**
     * Start integration runtime
     * 
     * Start an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return integration runtime status response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeStatusResponseInner start(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, Context context);

    /**
     * Stop integration runtime
     * 
     * Stop an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginStop(String resourceGroupName, String workspaceName,
        String integrationRuntimeName);

    /**
     * Stop integration runtime
     * 
     * Stop an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginStop(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, Context context);

    /**
     * Stop integration runtime
     * 
     * Stop an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void stop(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Stop integration runtime
     * 
     * Stop an integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void stop(String resourceGroupName, String workspaceName, String integrationRuntimeName, Context context);

    /**
     * Gets list of outbound network dependencies for a given Azure-SSIS integration runtime.
     * 
     * Gets the list of outbound network dependencies for a given Azure-SSIS integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of outbound network dependencies for a given Azure-SSIS integration runtime along with
     * {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<IntegrationRuntimeOutboundNetworkDependenciesEndpointsResponseInner>
        listOutboundNetworkDependenciesEndpointsWithResponse(String resourceGroupName, String workspaceName,
            String integrationRuntimeName, Context context);

    /**
     * Gets list of outbound network dependencies for a given Azure-SSIS integration runtime.
     * 
     * Gets the list of outbound network dependencies for a given Azure-SSIS integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of outbound network dependencies for a given Azure-SSIS integration runtime.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    IntegrationRuntimeOutboundNetworkDependenciesEndpointsResponseInner listOutboundNetworkDependenciesEndpoints(
        String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Enable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginEnableInteractiveQuery(String resourceGroupName, String workspaceName,
        String integrationRuntimeName);

    /**
     * Enable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginEnableInteractiveQuery(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, Context context);

    /**
     * Enable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void enableInteractiveQuery(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Enable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void enableInteractiveQuery(String resourceGroupName, String workspaceName, String integrationRuntimeName,
        Context context);

    /**
     * Disable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDisableInteractiveQuery(String resourceGroupName, String workspaceName,
        String integrationRuntimeName);

    /**
     * Disable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDisableInteractiveQuery(String resourceGroupName, String workspaceName,
        String integrationRuntimeName, Context context);

    /**
     * Disable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void disableInteractiveQuery(String resourceGroupName, String workspaceName, String integrationRuntimeName);

    /**
     * Disable interactive query in integration runtime.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param workspaceName The name of the workspace.
     * @param integrationRuntimeName Integration runtime name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void disableInteractiveQuery(String resourceGroupName, String workspaceName, String integrationRuntimeName,
        Context context);
}
