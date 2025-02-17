// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.customerinsights.fluent.models.AuthorizationPolicyInner;
import com.azure.resourcemanager.customerinsights.fluent.models.AuthorizationPolicyResourceFormatInner;

/**
 * An instance of this class provides access to all the operations defined in AuthorizationPoliciesClient.
 */
public interface AuthorizationPoliciesClient {
    /**
     * Creates an authorization policy or updates an existing authorization policy.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @param parameters Parameters supplied to the CreateOrUpdate authorization policy operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authorization policy resource format along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AuthorizationPolicyResourceFormatInner> createOrUpdateWithResponse(String resourceGroupName,
        String hubName, String authorizationPolicyName, AuthorizationPolicyResourceFormatInner parameters,
        Context context);

    /**
     * Creates an authorization policy or updates an existing authorization policy.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @param parameters Parameters supplied to the CreateOrUpdate authorization policy operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authorization policy resource format.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationPolicyResourceFormatInner createOrUpdate(String resourceGroupName, String hubName,
        String authorizationPolicyName, AuthorizationPolicyResourceFormatInner parameters);

    /**
     * Gets an authorization policy in the hub.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an authorization policy in the hub along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AuthorizationPolicyResourceFormatInner> getWithResponse(String resourceGroupName, String hubName,
        String authorizationPolicyName, Context context);

    /**
     * Gets an authorization policy in the hub.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an authorization policy in the hub.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationPolicyResourceFormatInner get(String resourceGroupName, String hubName,
        String authorizationPolicyName);

    /**
     * Gets all the authorization policies in a specified hub.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all the authorization policies in a specified hub as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AuthorizationPolicyResourceFormatInner> listByHub(String resourceGroupName, String hubName);

    /**
     * Gets all the authorization policies in a specified hub.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all the authorization policies in a specified hub as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AuthorizationPolicyResourceFormatInner> listByHub(String resourceGroupName, String hubName,
        Context context);

    /**
     * Regenerates the primary policy key of the specified authorization policy.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authorization policy along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AuthorizationPolicyInner> regeneratePrimaryKeyWithResponse(String resourceGroupName, String hubName,
        String authorizationPolicyName, Context context);

    /**
     * Regenerates the primary policy key of the specified authorization policy.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authorization policy.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationPolicyInner regeneratePrimaryKey(String resourceGroupName, String hubName,
        String authorizationPolicyName);

    /**
     * Regenerates the secondary policy key of the specified authorization policy.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authorization policy along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AuthorizationPolicyInner> regenerateSecondaryKeyWithResponse(String resourceGroupName, String hubName,
        String authorizationPolicyName, Context context);

    /**
     * Regenerates the secondary policy key of the specified authorization policy.
     * 
     * @param resourceGroupName The name of the resource group.
     * @param hubName The name of the hub.
     * @param authorizationPolicyName The name of the policy.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the authorization policy.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationPolicyInner regenerateSecondaryKey(String resourceGroupName, String hubName,
        String authorizationPolicyName);
}
