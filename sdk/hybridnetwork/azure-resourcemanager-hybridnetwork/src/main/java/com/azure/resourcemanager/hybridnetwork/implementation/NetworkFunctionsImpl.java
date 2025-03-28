// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.hybridnetwork.fluent.NetworkFunctionsClient;
import com.azure.resourcemanager.hybridnetwork.fluent.models.NetworkFunctionInner;
import com.azure.resourcemanager.hybridnetwork.models.ExecuteRequestParameters;
import com.azure.resourcemanager.hybridnetwork.models.NetworkFunction;
import com.azure.resourcemanager.hybridnetwork.models.NetworkFunctions;

public final class NetworkFunctionsImpl implements NetworkFunctions {
    private static final ClientLogger LOGGER = new ClientLogger(NetworkFunctionsImpl.class);

    private final NetworkFunctionsClient innerClient;

    private final com.azure.resourcemanager.hybridnetwork.HybridNetworkManager serviceManager;

    public NetworkFunctionsImpl(NetworkFunctionsClient innerClient,
        com.azure.resourcemanager.hybridnetwork.HybridNetworkManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public void deleteByResourceGroup(String resourceGroupName, String networkFunctionName) {
        this.serviceClient().delete(resourceGroupName, networkFunctionName);
    }

    public void delete(String resourceGroupName, String networkFunctionName, Context context) {
        this.serviceClient().delete(resourceGroupName, networkFunctionName, context);
    }

    public Response<NetworkFunction> getByResourceGroupWithResponse(String resourceGroupName,
        String networkFunctionName, Context context) {
        Response<NetworkFunctionInner> inner
            = this.serviceClient().getByResourceGroupWithResponse(resourceGroupName, networkFunctionName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new NetworkFunctionImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public NetworkFunction getByResourceGroup(String resourceGroupName, String networkFunctionName) {
        NetworkFunctionInner inner = this.serviceClient().getByResourceGroup(resourceGroupName, networkFunctionName);
        if (inner != null) {
            return new NetworkFunctionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<NetworkFunction> list() {
        PagedIterable<NetworkFunctionInner> inner = this.serviceClient().list();
        return ResourceManagerUtils.mapPage(inner, inner1 -> new NetworkFunctionImpl(inner1, this.manager()));
    }

    public PagedIterable<NetworkFunction> list(Context context) {
        PagedIterable<NetworkFunctionInner> inner = this.serviceClient().list(context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new NetworkFunctionImpl(inner1, this.manager()));
    }

    public PagedIterable<NetworkFunction> listByResourceGroup(String resourceGroupName) {
        PagedIterable<NetworkFunctionInner> inner = this.serviceClient().listByResourceGroup(resourceGroupName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new NetworkFunctionImpl(inner1, this.manager()));
    }

    public PagedIterable<NetworkFunction> listByResourceGroup(String resourceGroupName, Context context) {
        PagedIterable<NetworkFunctionInner> inner
            = this.serviceClient().listByResourceGroup(resourceGroupName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new NetworkFunctionImpl(inner1, this.manager()));
    }

    public void executeRequest(String resourceGroupName, String networkFunctionName,
        ExecuteRequestParameters parameters) {
        this.serviceClient().executeRequest(resourceGroupName, networkFunctionName, parameters);
    }

    public void executeRequest(String resourceGroupName, String networkFunctionName,
        ExecuteRequestParameters parameters, Context context) {
        this.serviceClient().executeRequest(resourceGroupName, networkFunctionName, parameters, context);
    }

    public NetworkFunction getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String networkFunctionName = ResourceManagerUtils.getValueFromIdByName(id, "networkFunctions");
        if (networkFunctionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'networkFunctions'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, networkFunctionName, Context.NONE).getValue();
    }

    public Response<NetworkFunction> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String networkFunctionName = ResourceManagerUtils.getValueFromIdByName(id, "networkFunctions");
        if (networkFunctionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'networkFunctions'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, networkFunctionName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String networkFunctionName = ResourceManagerUtils.getValueFromIdByName(id, "networkFunctions");
        if (networkFunctionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'networkFunctions'.", id)));
        }
        this.delete(resourceGroupName, networkFunctionName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String networkFunctionName = ResourceManagerUtils.getValueFromIdByName(id, "networkFunctions");
        if (networkFunctionName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'networkFunctions'.", id)));
        }
        this.delete(resourceGroupName, networkFunctionName, context);
    }

    private NetworkFunctionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.hybridnetwork.HybridNetworkManager manager() {
        return this.serviceManager;
    }

    public NetworkFunctionImpl define(String name) {
        return new NetworkFunctionImpl(name, this.manager());
    }
}
