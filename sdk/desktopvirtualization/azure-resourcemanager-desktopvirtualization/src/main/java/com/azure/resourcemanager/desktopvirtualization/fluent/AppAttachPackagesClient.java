// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.desktopvirtualization.fluent.models.AppAttachPackageInner;
import com.azure.resourcemanager.desktopvirtualization.models.AppAttachPackagePatch;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in AppAttachPackagesClient.
 */
public interface AppAttachPackagesClient {
    /**
     * Get an app attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an app attach package along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<AppAttachPackageInner>> getByResourceGroupWithResponseAsync(String resourceGroupName,
        String appAttachPackageName);

    /**
     * Get an app attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an app attach package on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AppAttachPackageInner> getByResourceGroupAsync(String resourceGroupName, String appAttachPackageName);

    /**
     * Get an app attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an app attach package along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AppAttachPackageInner> getByResourceGroupWithResponse(String resourceGroupName,
        String appAttachPackageName, Context context);

    /**
     * Get an app attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an app attach package.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AppAttachPackageInner getByResourceGroup(String resourceGroupName, String appAttachPackageName);

    /**
     * Create or update an App Attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param appAttachPackage Object containing App Attach Package definitions.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<AppAttachPackageInner>> createOrUpdateWithResponseAsync(String resourceGroupName,
        String appAttachPackageName, AppAttachPackageInner appAttachPackage);

    /**
     * Create or update an App Attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param appAttachPackage Object containing App Attach Package definitions.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AppAttachPackageInner> createOrUpdateAsync(String resourceGroupName, String appAttachPackageName,
        AppAttachPackageInner appAttachPackage);

    /**
     * Create or update an App Attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param appAttachPackage Object containing App Attach Package definitions.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AppAttachPackageInner> createOrUpdateWithResponse(String resourceGroupName, String appAttachPackageName,
        AppAttachPackageInner appAttachPackage, Context context);

    /**
     * Create or update an App Attach package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param appAttachPackage Object containing App Attach Package definitions.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AppAttachPackageInner createOrUpdate(String resourceGroupName, String appAttachPackageName,
        AppAttachPackageInner appAttachPackage);

    /**
     * Remove an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<Void>> deleteWithResponseAsync(String resourceGroupName, String appAttachPackageName);

    /**
     * Remove an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Void> deleteAsync(String resourceGroupName, String appAttachPackageName);

    /**
     * Remove an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String appAttachPackageName, Context context);

    /**
     * Remove an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String appAttachPackageName);

    /**
     * Update an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param appAttachPackagePatch Object containing App Attach Package definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<AppAttachPackageInner>> updateWithResponseAsync(String resourceGroupName, String appAttachPackageName,
        AppAttachPackagePatch appAttachPackagePatch);

    /**
     * Update an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AppAttachPackageInner> updateAsync(String resourceGroupName, String appAttachPackageName);

    /**
     * Update an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @param appAttachPackagePatch Object containing App Attach Package definition.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<AppAttachPackageInner> updateWithResponse(String resourceGroupName, String appAttachPackageName,
        AppAttachPackagePatch appAttachPackagePatch, Context context);

    /**
     * Update an App Attach Package.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param appAttachPackageName The name of the App Attach package.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return schema for App Attach Package properties.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AppAttachPackageInner update(String resourceGroupName, String appAttachPackageName);

    /**
     * List App Attach packages in resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param filter OData filter expression. Valid properties for filtering are package name and host pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<AppAttachPackageInner> listByResourceGroupAsync(String resourceGroupName, String filter);

    /**
     * List App Attach packages in resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<AppAttachPackageInner> listByResourceGroupAsync(String resourceGroupName);

    /**
     * List App Attach packages in resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AppAttachPackageInner> listByResourceGroup(String resourceGroupName);

    /**
     * List App Attach packages in resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param filter OData filter expression. Valid properties for filtering are package name and host pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AppAttachPackageInner> listByResourceGroup(String resourceGroupName, String filter, Context context);

    /**
     * List App Attach packages in subscription.
     * 
     * @param filter OData filter expression. Valid properties for filtering are package name, host pool, and resource
     * group.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<AppAttachPackageInner> listAsync(String filter);

    /**
     * List App Attach packages in subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedFlux<AppAttachPackageInner> listAsync();

    /**
     * List App Attach packages in subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AppAttachPackageInner> list();

    /**
     * List App Attach packages in subscription.
     * 
     * @param filter OData filter expression. Valid properties for filtering are package name, host pool, and resource
     * group.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return appAttachPackageList as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AppAttachPackageInner> list(String filter, Context context);
}
