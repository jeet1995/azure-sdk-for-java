// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.agrifood.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.agrifood.fluent.models.FarmBeatsInner;
import com.azure.resourcemanager.agrifood.models.FarmBeatsUpdateRequestModel;

/**
 * An instance of this class provides access to all the operations defined in FarmBeatsModelsClient.
 */
public interface FarmBeatsModelsClient {
    /**
     * Get FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return farmBeats resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<FarmBeatsInner> getByResourceGroupWithResponse(String resourceGroupName, String farmBeatsResourceName,
        Context context);

    /**
     * Get FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return farmBeats resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    FarmBeatsInner getByResourceGroup(String resourceGroupName, String farmBeatsResourceName);

    /**
     * Create or update FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param body FarmBeats resource create or update request object.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return farmBeats ARM Resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<FarmBeatsInner> createOrUpdateWithResponse(String resourceGroupName, String farmBeatsResourceName,
        FarmBeatsInner body, Context context);

    /**
     * Create or update FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param body FarmBeats resource create or update request object.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return farmBeats ARM Resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    FarmBeatsInner createOrUpdate(String resourceGroupName, String farmBeatsResourceName, FarmBeatsInner body);

    /**
     * Update a FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param body Request object.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of farmBeats ARM Resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<FarmBeatsInner>, FarmBeatsInner> beginUpdate(String resourceGroupName,
        String farmBeatsResourceName, FarmBeatsUpdateRequestModel body);

    /**
     * Update a FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param body Request object.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of farmBeats ARM Resource.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<FarmBeatsInner>, FarmBeatsInner> beginUpdate(String resourceGroupName,
        String farmBeatsResourceName, FarmBeatsUpdateRequestModel body, Context context);

    /**
     * Update a FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param body Request object.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return farmBeats ARM Resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    FarmBeatsInner update(String resourceGroupName, String farmBeatsResourceName, FarmBeatsUpdateRequestModel body);

    /**
     * Update a FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param body Request object.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return farmBeats ARM Resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    FarmBeatsInner update(String resourceGroupName, String farmBeatsResourceName, FarmBeatsUpdateRequestModel body,
        Context context);

    /**
     * Delete a FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String farmBeatsResourceName, Context context);

    /**
     * Delete a FarmBeats resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param farmBeatsResourceName FarmBeats resource name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String farmBeatsResourceName);

    /**
     * Lists the FarmBeats instances for a subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged response contains list of requested objects and a URL link to get the next set of results as
     * paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<FarmBeatsInner> list();

    /**
     * Lists the FarmBeats instances for a subscription.
     * 
     * @param maxPageSize Maximum number of items needed (inclusive).
     * Minimum = 10, Maximum = 1000, Default value = 50.
     * @param skipToken Skip token for getting next set of results.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged response contains list of requested objects and a URL link to get the next set of results as
     * paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<FarmBeatsInner> list(Integer maxPageSize, String skipToken, Context context);

    /**
     * Lists the FarmBeats instances for a resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged response contains list of requested objects and a URL link to get the next set of results as
     * paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<FarmBeatsInner> listByResourceGroup(String resourceGroupName);

    /**
     * Lists the FarmBeats instances for a resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param maxPageSize Maximum number of items needed (inclusive).
     * Minimum = 10, Maximum = 1000, Default value = 50.
     * @param skipToken Continuation token for getting next set of results.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged response contains list of requested objects and a URL link to get the next set of results as
     * paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<FarmBeatsInner> listByResourceGroup(String resourceGroupName, Integer maxPageSize, String skipToken,
        Context context);
}
