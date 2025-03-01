// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.iotoperations.fluent.models.DataflowResourceInner;

/**
 * An instance of this class provides access to all the operations defined in DataflowsClient.
 */
public interface DataflowsClient {
    /**
     * Get a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DataflowResource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<DataflowResourceInner> getWithResponse(String resourceGroupName, String instanceName,
        String dataflowProfileName, String dataflowName, Context context);

    /**
     * Get a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DataflowResource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    DataflowResourceInner get(String resourceGroupName, String instanceName, String dataflowProfileName,
        String dataflowName);

    /**
     * Create a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of instance dataflowProfile dataflow resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<DataflowResourceInner>, DataflowResourceInner> beginCreateOrUpdate(String resourceGroupName,
        String instanceName, String dataflowProfileName, String dataflowName, DataflowResourceInner resource);

    /**
     * Create a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of instance dataflowProfile dataflow resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<DataflowResourceInner>, DataflowResourceInner> beginCreateOrUpdate(String resourceGroupName,
        String instanceName, String dataflowProfileName, String dataflowName, DataflowResourceInner resource,
        Context context);

    /**
     * Create a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return instance dataflowProfile dataflow resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    DataflowResourceInner createOrUpdate(String resourceGroupName, String instanceName, String dataflowProfileName,
        String dataflowName, DataflowResourceInner resource);

    /**
     * Create a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return instance dataflowProfile dataflow resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    DataflowResourceInner createOrUpdate(String resourceGroupName, String instanceName, String dataflowProfileName,
        String dataflowName, DataflowResourceInner resource, Context context);

    /**
     * Delete a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String instanceName,
        String dataflowProfileName, String dataflowName);

    /**
     * Delete a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String instanceName,
        String dataflowProfileName, String dataflowName, Context context);

    /**
     * Delete a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String instanceName, String dataflowProfileName, String dataflowName);

    /**
     * Delete a DataflowResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param dataflowName Name of Instance dataflowProfile dataflow resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String instanceName, String dataflowProfileName, String dataflowName,
        Context context);

    /**
     * List DataflowResource resources by DataflowProfileResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a DataflowResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DataflowResourceInner> listByResourceGroup(String resourceGroupName, String instanceName,
        String dataflowProfileName);

    /**
     * List DataflowResource resources by DataflowProfileResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param instanceName Name of instance.
     * @param dataflowProfileName Name of Instance dataflowProfile resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a DataflowResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<DataflowResourceInner> listByResourceGroup(String resourceGroupName, String instanceName,
        String dataflowProfileName, Context context);
}
