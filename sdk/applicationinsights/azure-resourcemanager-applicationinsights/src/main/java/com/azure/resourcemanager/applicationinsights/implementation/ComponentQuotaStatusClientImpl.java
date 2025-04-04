// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.applicationinsights.implementation;

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
import com.azure.resourcemanager.applicationinsights.fluent.ComponentQuotaStatusClient;
import com.azure.resourcemanager.applicationinsights.fluent.models.ApplicationInsightsComponentQuotaStatusInner;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in ComponentQuotaStatusClient.
 */
public final class ComponentQuotaStatusClientImpl implements ComponentQuotaStatusClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ComponentQuotaStatusService service;

    /**
     * The service client containing this operation class.
     */
    private final ApplicationInsightsManagementClientImpl client;

    /**
     * Initializes an instance of ComponentQuotaStatusClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ComponentQuotaStatusClientImpl(ApplicationInsightsManagementClientImpl client) {
        this.service = RestProxy.create(ComponentQuotaStatusService.class, client.getHttpPipeline(),
            client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for ApplicationInsightsManagementClientComponentQuotaStatus to be used by
     * the proxy service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "ApplicationInsightsM")
    public interface ComponentQuotaStatusService {
        @Headers({ "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Insights/components/{resourceName}/quotastatus")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ApplicationInsightsComponentQuotaStatusInner>> get(@HostParam("$host") String endpoint,
            @PathParam("resourceGroupName") String resourceGroupName, @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceName") String resourceName,
            @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Returns daily data volume cap (quota) status for an Application Insights component.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceName The name of the Application Insights component resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Application Insights component daily data volume cap status along with {@link Response} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ApplicationInsightsComponentQuotaStatusInner>> getWithResponseAsync(String resourceGroupName,
        String resourceName) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceName == null) {
            return Mono.error(new IllegalArgumentException("Parameter resourceName is required and cannot be null."));
        }
        final String apiVersion = "2015-05-01";
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.get(this.client.getEndpoint(), resourceGroupName, apiVersion,
                this.client.getSubscriptionId(), resourceName, accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Returns daily data volume cap (quota) status for an Application Insights component.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceName The name of the Application Insights component resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Application Insights component daily data volume cap status along with {@link Response} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ApplicationInsightsComponentQuotaStatusInner>> getWithResponseAsync(String resourceGroupName,
        String resourceName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono.error(new IllegalArgumentException(
                "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceName == null) {
            return Mono.error(new IllegalArgumentException("Parameter resourceName is required and cannot be null."));
        }
        final String apiVersion = "2015-05-01";
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.get(this.client.getEndpoint(), resourceGroupName, apiVersion, this.client.getSubscriptionId(),
            resourceName, accept, context);
    }

    /**
     * Returns daily data volume cap (quota) status for an Application Insights component.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceName The name of the Application Insights component resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Application Insights component daily data volume cap status on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ApplicationInsightsComponentQuotaStatusInner> getAsync(String resourceGroupName, String resourceName) {
        return getWithResponseAsync(resourceGroupName, resourceName).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Returns daily data volume cap (quota) status for an Application Insights component.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceName The name of the Application Insights component resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Application Insights component daily data volume cap status along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ApplicationInsightsComponentQuotaStatusInner> getWithResponse(String resourceGroupName,
        String resourceName, Context context) {
        return getWithResponseAsync(resourceGroupName, resourceName, context).block();
    }

    /**
     * Returns daily data volume cap (quota) status for an Application Insights component.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param resourceName The name of the Application Insights component resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an Application Insights component daily data volume cap status.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ApplicationInsightsComponentQuotaStatusInner get(String resourceGroupName, String resourceName) {
        return getWithResponse(resourceGroupName, resourceName, Context.NONE).getValue();
    }
}
