// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.networkcloud.fluent.models.OperationStatusResultInner;
import com.azure.resourcemanager.networkcloud.fluent.models.TrunkedNetworkInner;
import com.azure.resourcemanager.networkcloud.models.TrunkedNetworkPatchParameters;

/**
 * An instance of this class provides access to all the operations defined in TrunkedNetworksClient.
 */
public interface TrunkedNetworksClient {
    /**
     * List trunked networks in the subscription.
     * 
     * Get a list of trunked networks in the provided subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of trunked networks in the provided subscription as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TrunkedNetworkInner> list();

    /**
     * List trunked networks in the subscription.
     * 
     * Get a list of trunked networks in the provided subscription.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of trunked networks in the provided subscription as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TrunkedNetworkInner> list(Context context);

    /**
     * List trunked networks in the resource group.
     * 
     * Get a list of trunked networks in the provided resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of trunked networks in the provided resource group as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TrunkedNetworkInner> listByResourceGroup(String resourceGroupName);

    /**
     * List trunked networks in the resource group.
     * 
     * Get a list of trunked networks in the provided resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of trunked networks in the provided resource group as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<TrunkedNetworkInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Retrieve the trunked network.
     * 
     * Get properties of the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided trunked network along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TrunkedNetworkInner> getByResourceGroupWithResponse(String resourceGroupName, String trunkedNetworkName,
        Context context);

    /**
     * Retrieve the trunked network.
     * 
     * Get properties of the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided trunked network.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TrunkedNetworkInner getByResourceGroup(String resourceGroupName, String trunkedNetworkName);

    /**
     * Create or update the trunked network.
     * 
     * Create a new trunked network or update the properties of the existing trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param trunkedNetworkParameters The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of trunkedNetwork represents a network that utilizes multiple
     * isolation domains and specified VLANs to create a trunked network.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<TrunkedNetworkInner>, TrunkedNetworkInner> beginCreateOrUpdate(String resourceGroupName,
        String trunkedNetworkName, TrunkedNetworkInner trunkedNetworkParameters);

    /**
     * Create or update the trunked network.
     * 
     * Create a new trunked network or update the properties of the existing trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param trunkedNetworkParameters The request body.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of trunkedNetwork represents a network that utilizes multiple
     * isolation domains and specified VLANs to create a trunked network.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<TrunkedNetworkInner>, TrunkedNetworkInner> beginCreateOrUpdate(String resourceGroupName,
        String trunkedNetworkName, TrunkedNetworkInner trunkedNetworkParameters, String ifMatch, String ifNoneMatch,
        Context context);

    /**
     * Create or update the trunked network.
     * 
     * Create a new trunked network or update the properties of the existing trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param trunkedNetworkParameters The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trunkedNetwork represents a network that utilizes multiple isolation domains and specified VLANs to
     * create a trunked network.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TrunkedNetworkInner createOrUpdate(String resourceGroupName, String trunkedNetworkName,
        TrunkedNetworkInner trunkedNetworkParameters);

    /**
     * Create or update the trunked network.
     * 
     * Create a new trunked network or update the properties of the existing trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param trunkedNetworkParameters The request body.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trunkedNetwork represents a network that utilizes multiple isolation domains and specified VLANs to
     * create a trunked network.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TrunkedNetworkInner createOrUpdate(String resourceGroupName, String trunkedNetworkName,
        TrunkedNetworkInner trunkedNetworkParameters, String ifMatch, String ifNoneMatch, Context context);

    /**
     * Delete the trunked network.
     * 
     * Delete the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String trunkedNetworkName);

    /**
     * Delete the trunked network.
     * 
     * Delete the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String trunkedNetworkName, String ifMatch, String ifNoneMatch, Context context);

    /**
     * Delete the trunked network.
     * 
     * Delete the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String trunkedNetworkName);

    /**
     * Delete the trunked network.
     * 
     * Delete the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String trunkedNetworkName, String ifMatch,
        String ifNoneMatch, Context context);

    /**
     * Patch the trunked network.
     * 
     * Update tags associated with the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param trunkedNetworkUpdateParameters The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trunkedNetwork represents a network that utilizes multiple isolation domains and specified VLANs to
     * create a trunked network along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<TrunkedNetworkInner> updateWithResponse(String resourceGroupName, String trunkedNetworkName,
        String ifMatch, String ifNoneMatch, TrunkedNetworkPatchParameters trunkedNetworkUpdateParameters,
        Context context);

    /**
     * Patch the trunked network.
     * 
     * Update tags associated with the provided trunked network.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param trunkedNetworkName The name of the trunked network.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trunkedNetwork represents a network that utilizes multiple isolation domains and specified VLANs to
     * create a trunked network.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    TrunkedNetworkInner update(String resourceGroupName, String trunkedNetworkName);
}
