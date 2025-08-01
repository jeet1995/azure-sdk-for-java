// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.implementation;

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
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.eventgrid.fluent.ExtensionTopicsClient;
import com.azure.resourcemanager.eventgrid.fluent.models.ExtensionTopicInner;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in ExtensionTopicsClient.
 */
public final class ExtensionTopicsClientImpl implements ExtensionTopicsClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ExtensionTopicsService service;

    /**
     * The service client containing this operation class.
     */
    private final EventGridManagementClientImpl client;

    /**
     * Initializes an instance of ExtensionTopicsClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ExtensionTopicsClientImpl(EventGridManagementClientImpl client) {
        this.service
            = RestProxy.create(ExtensionTopicsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for EventGridManagementClientExtensionTopics to be used by the proxy
     * service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "EventGridManagementClientExtensionTopics")
    public interface ExtensionTopicsService {
        @Headers({ "Content-Type: application/json" })
        @Get("/{scope}/providers/Microsoft.EventGrid/extensionTopics/default")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ExtensionTopicInner>> get(@HostParam("$host") String endpoint, @PathParam("scope") String scope,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);

        @Headers({ "Content-Type: application/json" })
        @Get("/{scope}/providers/Microsoft.EventGrid/extensionTopics/default")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Response<ExtensionTopicInner> getSync(@HostParam("$host") String endpoint, @PathParam("scope") String scope,
            @QueryParam("api-version") String apiVersion, @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Get properties of an extension topic.
     * 
     * Get the properties of an extension topic.
     * 
     * @param scope The identifier of the resource to which extension topic is queried. The scope can be a subscription,
     * or a resource group, or a top level resource belonging to a resource provider namespace. For example, use
     * '/subscriptions/{subscriptionId}/' for a subscription,
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for a resource group, and
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{resourceType}/{resourceName}'
     * for Azure resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of an extension topic along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ExtensionTopicInner>> getWithResponseAsync(String scope) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (scope == null) {
            return Mono.error(new IllegalArgumentException("Parameter scope is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context -> service.get(this.client.getEndpoint(), scope, this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Get properties of an extension topic.
     * 
     * Get the properties of an extension topic.
     * 
     * @param scope The identifier of the resource to which extension topic is queried. The scope can be a subscription,
     * or a resource group, or a top level resource belonging to a resource provider namespace. For example, use
     * '/subscriptions/{subscriptionId}/' for a subscription,
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for a resource group, and
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{resourceType}/{resourceName}'
     * for Azure resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of an extension topic on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ExtensionTopicInner> getAsync(String scope) {
        return getWithResponseAsync(scope).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get properties of an extension topic.
     * 
     * Get the properties of an extension topic.
     * 
     * @param scope The identifier of the resource to which extension topic is queried. The scope can be a subscription,
     * or a resource group, or a top level resource belonging to a resource provider namespace. For example, use
     * '/subscriptions/{subscriptionId}/' for a subscription,
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for a resource group, and
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{resourceType}/{resourceName}'
     * for Azure resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of an extension topic along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ExtensionTopicInner> getWithResponse(String scope, Context context) {
        if (this.client.getEndpoint() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (scope == null) {
            throw LOGGER.atError().log(new IllegalArgumentException("Parameter scope is required and cannot be null."));
        }
        final String accept = "application/json";
        return service.getSync(this.client.getEndpoint(), scope, this.client.getApiVersion(), accept, context);
    }

    /**
     * Get properties of an extension topic.
     * 
     * Get the properties of an extension topic.
     * 
     * @param scope The identifier of the resource to which extension topic is queried. The scope can be a subscription,
     * or a resource group, or a top level resource belonging to a resource provider namespace. For example, use
     * '/subscriptions/{subscriptionId}/' for a subscription,
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for a resource group, and
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{resourceType}/{resourceName}'
     * for Azure resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the properties of an extension topic.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ExtensionTopicInner get(String scope) {
        return getWithResponse(scope, Context.NONE).getValue();
    }

    private static final ClientLogger LOGGER = new ClientLogger(ExtensionTopicsClientImpl.class);
}
