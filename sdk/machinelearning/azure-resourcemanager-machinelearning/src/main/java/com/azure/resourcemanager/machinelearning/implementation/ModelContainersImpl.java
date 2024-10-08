// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.machinelearning.fluent.ModelContainersClient;
import com.azure.resourcemanager.machinelearning.fluent.models.ModelContainerInner;
import com.azure.resourcemanager.machinelearning.models.ListViewType;
import com.azure.resourcemanager.machinelearning.models.ModelContainer;
import com.azure.resourcemanager.machinelearning.models.ModelContainers;

public final class ModelContainersImpl implements ModelContainers {
    private static final ClientLogger LOGGER = new ClientLogger(ModelContainersImpl.class);

    private final ModelContainersClient innerClient;

    private final com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager;

    public ModelContainersImpl(ModelContainersClient innerClient,
        com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<ModelContainer> list(String resourceGroupName, String workspaceName) {
        PagedIterable<ModelContainerInner> inner = this.serviceClient().list(resourceGroupName, workspaceName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new ModelContainerImpl(inner1, this.manager()));
    }

    public PagedIterable<ModelContainer> list(String resourceGroupName, String workspaceName, String skip,
        Integer count, ListViewType listViewType, Context context) {
        PagedIterable<ModelContainerInner> inner
            = this.serviceClient().list(resourceGroupName, workspaceName, skip, count, listViewType, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new ModelContainerImpl(inner1, this.manager()));
    }

    public Response<Void> deleteWithResponse(String resourceGroupName, String workspaceName, String name,
        Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, workspaceName, name, context);
    }

    public void delete(String resourceGroupName, String workspaceName, String name) {
        this.serviceClient().delete(resourceGroupName, workspaceName, name);
    }

    public Response<ModelContainer> getWithResponse(String resourceGroupName, String workspaceName, String name,
        Context context) {
        Response<ModelContainerInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, workspaceName, name, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new ModelContainerImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public ModelContainer get(String resourceGroupName, String workspaceName, String name) {
        ModelContainerInner inner = this.serviceClient().get(resourceGroupName, workspaceName, name);
        if (inner != null) {
            return new ModelContainerImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public ModelContainer getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = ResourceManagerUtils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String name = ResourceManagerUtils.getValueFromIdByName(id, "models");
        if (name == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'models'.", id)));
        }
        return this.getWithResponse(resourceGroupName, workspaceName, name, Context.NONE).getValue();
    }

    public Response<ModelContainer> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = ResourceManagerUtils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String name = ResourceManagerUtils.getValueFromIdByName(id, "models");
        if (name == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'models'.", id)));
        }
        return this.getWithResponse(resourceGroupName, workspaceName, name, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = ResourceManagerUtils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String name = ResourceManagerUtils.getValueFromIdByName(id, "models");
        if (name == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'models'.", id)));
        }
        this.deleteWithResponse(resourceGroupName, workspaceName, name, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String workspaceName = ResourceManagerUtils.getValueFromIdByName(id, "workspaces");
        if (workspaceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'workspaces'.", id)));
        }
        String name = ResourceManagerUtils.getValueFromIdByName(id, "models");
        if (name == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'models'.", id)));
        }
        return this.deleteWithResponse(resourceGroupName, workspaceName, name, context);
    }

    private ModelContainersClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.machinelearning.MachineLearningManager manager() {
        return this.serviceManager;
    }

    public ModelContainerImpl define(String name) {
        return new ModelContainerImpl(name, this.manager());
    }
}
