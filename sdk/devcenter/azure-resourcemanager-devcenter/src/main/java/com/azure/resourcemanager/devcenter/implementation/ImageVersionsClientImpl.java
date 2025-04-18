// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.resourcemanager.devcenter.fluent.ImageVersionsClient;
import com.azure.resourcemanager.devcenter.fluent.models.ImageVersionInner;
import com.azure.resourcemanager.devcenter.models.ImageVersionListResult;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in ImageVersionsClient.
 */
public final class ImageVersionsClientImpl implements ImageVersionsClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ImageVersionsService service;

    /**
     * The service client containing this operation class.
     */
    private final DevCenterManagementClientImpl client;

    /**
     * Initializes an instance of ImageVersionsClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ImageVersionsClientImpl(DevCenterManagementClientImpl client) {
        this.service
            = RestProxy.create(ImageVersionsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for DevCenterManagementClientImageVersions to be used by the proxy
     * service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "DevCenterManagementC")
    public interface ImageVersionsService {
        @Headers({ "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DevCenter/devcenters/{devCenterName}/galleries/{galleryName}/images/{imageName}/versions")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ImageVersionListResult>> listByImage(@HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName, @PathParam("devCenterName") String devCenterName,
            @PathParam("galleryName") String galleryName, @PathParam("imageName") String imageName,
            @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DevCenter/devcenters/{devCenterName}/galleries/{galleryName}/images/{imageName}/versions/{versionName}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ImageVersionInner>> get(@HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName, @PathParam("devCenterName") String devCenterName,
            @PathParam("galleryName") String galleryName, @PathParam("imageName") String imageName,
            @PathParam("versionName") String versionName, @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("{nextLink}")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ImageVersionListResult>> listByImageNext(
            @PathParam(value = "nextLink", encoded = true) String nextLink, @HostParam("$host") String endpoint,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Lists versions for an image.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<ImageVersionInner>> listByImageSinglePageAsync(String resourceGroupName,
        String devCenterName, String galleryName, String imageName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (devCenterName == null) {
            return Mono.error(new IllegalArgumentException("Parameter devCenterName is required and cannot be null."));
        }
        if (galleryName == null) {
            return Mono.error(new IllegalArgumentException("Parameter galleryName is required and cannot be null."));
        }
        if (imageName == null) {
            return Mono.error(new IllegalArgumentException("Parameter imageName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.listByImage(this.client.getEndpoint(), this.client.getApiVersion(),
                this.client.getSubscriptionId(), resourceGroupName, devCenterName, galleryName, imageName, accept,
                context))
            .<PagedResponse<ImageVersionInner>>map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(),
                res.getHeaders(), res.getValue().value(), res.getValue().nextLink(), null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Lists versions for an image.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<ImageVersionInner>> listByImageSinglePageAsync(String resourceGroupName,
        String devCenterName, String galleryName, String imageName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (devCenterName == null) {
            return Mono.error(new IllegalArgumentException("Parameter devCenterName is required and cannot be null."));
        }
        if (galleryName == null) {
            return Mono.error(new IllegalArgumentException("Parameter galleryName is required and cannot be null."));
        }
        if (imageName == null) {
            return Mono.error(new IllegalArgumentException("Parameter imageName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .listByImage(this.client.getEndpoint(), this.client.getApiVersion(), this.client.getSubscriptionId(),
                resourceGroupName, devCenterName, galleryName, imageName, accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().value(), res.getValue().nextLink(), null));
    }

    /**
     * Lists versions for an image.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<ImageVersionInner> listByImageAsync(String resourceGroupName, String devCenterName,
        String galleryName, String imageName) {
        return new PagedFlux<>(
            () -> listByImageSinglePageAsync(resourceGroupName, devCenterName, galleryName, imageName),
            nextLink -> listByImageNextSinglePageAsync(nextLink));
    }

    /**
     * Lists versions for an image.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation as paginated response with {@link PagedFlux}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<ImageVersionInner> listByImageAsync(String resourceGroupName, String devCenterName,
        String galleryName, String imageName, Context context) {
        return new PagedFlux<>(
            () -> listByImageSinglePageAsync(resourceGroupName, devCenterName, galleryName, imageName, context),
            nextLink -> listByImageNextSinglePageAsync(nextLink, context));
    }

    /**
     * Lists versions for an image.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<ImageVersionInner> listByImage(String resourceGroupName, String devCenterName,
        String galleryName, String imageName) {
        return new PagedIterable<>(listByImageAsync(resourceGroupName, devCenterName, galleryName, imageName));
    }

    /**
     * Lists versions for an image.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<ImageVersionInner> listByImage(String resourceGroupName, String devCenterName,
        String galleryName, String imageName, Context context) {
        return new PagedIterable<>(listByImageAsync(resourceGroupName, devCenterName, galleryName, imageName, context));
    }

    /**
     * Gets an image version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param versionName The version of the image.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an image version along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ImageVersionInner>> getWithResponseAsync(String resourceGroupName, String devCenterName,
        String galleryName, String imageName, String versionName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (devCenterName == null) {
            return Mono.error(new IllegalArgumentException("Parameter devCenterName is required and cannot be null."));
        }
        if (galleryName == null) {
            return Mono.error(new IllegalArgumentException("Parameter galleryName is required and cannot be null."));
        }
        if (imageName == null) {
            return Mono.error(new IllegalArgumentException("Parameter imageName is required and cannot be null."));
        }
        if (versionName == null) {
            return Mono.error(new IllegalArgumentException("Parameter versionName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.get(this.client.getEndpoint(), this.client.getApiVersion(),
                this.client.getSubscriptionId(), resourceGroupName, devCenterName, galleryName, imageName, versionName,
                accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Gets an image version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param versionName The version of the image.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an image version along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ImageVersionInner>> getWithResponseAsync(String resourceGroupName, String devCenterName,
        String galleryName, String imageName, String versionName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (devCenterName == null) {
            return Mono.error(new IllegalArgumentException("Parameter devCenterName is required and cannot be null."));
        }
        if (galleryName == null) {
            return Mono.error(new IllegalArgumentException("Parameter galleryName is required and cannot be null."));
        }
        if (imageName == null) {
            return Mono.error(new IllegalArgumentException("Parameter imageName is required and cannot be null."));
        }
        if (versionName == null) {
            return Mono.error(new IllegalArgumentException("Parameter versionName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.get(this.client.getEndpoint(), this.client.getApiVersion(), this.client.getSubscriptionId(),
            resourceGroupName, devCenterName, galleryName, imageName, versionName, accept, context);
    }

    /**
     * Gets an image version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param versionName The version of the image.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an image version on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ImageVersionInner> getAsync(String resourceGroupName, String devCenterName, String galleryName,
        String imageName, String versionName) {
        return getWithResponseAsync(resourceGroupName, devCenterName, galleryName, imageName, versionName)
            .flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Gets an image version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param versionName The version of the image.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an image version along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ImageVersionInner> getWithResponse(String resourceGroupName, String devCenterName,
        String galleryName, String imageName, String versionName, Context context) {
        return getWithResponseAsync(resourceGroupName, devCenterName, galleryName, imageName, versionName, context)
            .block();
    }

    /**
     * Gets an image version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param devCenterName The name of the devcenter.
     * @param galleryName The name of the gallery.
     * @param imageName The name of the image.
     * @param versionName The version of the image.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an image version.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ImageVersionInner get(String resourceGroupName, String devCenterName, String galleryName, String imageName,
        String versionName) {
        return getWithResponse(resourceGroupName, devCenterName, galleryName, imageName, versionName, Context.NONE)
            .getValue();
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<ImageVersionInner>> listByImageNextSinglePageAsync(String nextLink) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.listByImageNext(nextLink, this.client.getEndpoint(), accept, context))
            .<PagedResponse<ImageVersionInner>>map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(),
                res.getHeaders(), res.getValue().value(), res.getValue().nextLink(), null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Get the next page of items.
     * 
     * @param nextLink The URL to get the next list of items.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return results of the image version list operation along with {@link PagedResponse} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<ImageVersionInner>> listByImageNextSinglePageAsync(String nextLink, Context context) {
        if (nextLink == null) {
            return Mono.error(new IllegalArgumentException("Parameter nextLink is required and cannot be null."));
        }
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.listByImageNext(nextLink, this.client.getEndpoint(), accept, context)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                res.getValue().value(), res.getValue().nextLink(), null));
    }
}
