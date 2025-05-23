// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.labservices.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.labservices.fluent.LabsClient;
import com.azure.resourcemanager.labservices.fluent.models.LabInner;
import com.azure.resourcemanager.labservices.models.Lab;
import com.azure.resourcemanager.labservices.models.Labs;

public final class LabsImpl implements Labs {
    private static final ClientLogger LOGGER = new ClientLogger(LabsImpl.class);

    private final LabsClient innerClient;

    private final com.azure.resourcemanager.labservices.LabServicesManager serviceManager;

    public LabsImpl(LabsClient innerClient, com.azure.resourcemanager.labservices.LabServicesManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<Lab> list() {
        PagedIterable<LabInner> inner = this.serviceClient().list();
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LabImpl(inner1, this.manager()));
    }

    public PagedIterable<Lab> list(String filter, Context context) {
        PagedIterable<LabInner> inner = this.serviceClient().list(filter, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LabImpl(inner1, this.manager()));
    }

    public PagedIterable<Lab> listByResourceGroup(String resourceGroupName) {
        PagedIterable<LabInner> inner = this.serviceClient().listByResourceGroup(resourceGroupName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LabImpl(inner1, this.manager()));
    }

    public PagedIterable<Lab> listByResourceGroup(String resourceGroupName, Context context) {
        PagedIterable<LabInner> inner = this.serviceClient().listByResourceGroup(resourceGroupName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new LabImpl(inner1, this.manager()));
    }

    public Response<Lab> getByResourceGroupWithResponse(String resourceGroupName, String labName, Context context) {
        Response<LabInner> inner
            = this.serviceClient().getByResourceGroupWithResponse(resourceGroupName, labName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new LabImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public Lab getByResourceGroup(String resourceGroupName, String labName) {
        LabInner inner = this.serviceClient().getByResourceGroup(resourceGroupName, labName);
        if (inner != null) {
            return new LabImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void deleteByResourceGroup(String resourceGroupName, String labName) {
        this.serviceClient().delete(resourceGroupName, labName);
    }

    public void delete(String resourceGroupName, String labName, Context context) {
        this.serviceClient().delete(resourceGroupName, labName, context);
    }

    public void publish(String resourceGroupName, String labName) {
        this.serviceClient().publish(resourceGroupName, labName);
    }

    public void publish(String resourceGroupName, String labName, Context context) {
        this.serviceClient().publish(resourceGroupName, labName, context);
    }

    public void syncGroup(String resourceGroupName, String labName) {
        this.serviceClient().syncGroup(resourceGroupName, labName);
    }

    public void syncGroup(String resourceGroupName, String labName, Context context) {
        this.serviceClient().syncGroup(resourceGroupName, labName, context);
    }

    public Lab getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String labName = ResourceManagerUtils.getValueFromIdByName(id, "labs");
        if (labName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'labs'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, labName, Context.NONE).getValue();
    }

    public Response<Lab> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String labName = ResourceManagerUtils.getValueFromIdByName(id, "labs");
        if (labName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'labs'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, labName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String labName = ResourceManagerUtils.getValueFromIdByName(id, "labs");
        if (labName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'labs'.", id)));
        }
        this.delete(resourceGroupName, labName, Context.NONE);
    }

    public void deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String labName = ResourceManagerUtils.getValueFromIdByName(id, "labs");
        if (labName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'labs'.", id)));
        }
        this.delete(resourceGroupName, labName, context);
    }

    private LabsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.labservices.LabServicesManager manager() {
        return this.serviceManager;
    }

    public LabImpl define(String name) {
        return new LabImpl(name, this.manager());
    }
}
