// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.apimanagement.fluent.GlobalSchemasClient;
import com.azure.resourcemanager.apimanagement.fluent.models.GlobalSchemaContractInner;
import com.azure.resourcemanager.apimanagement.models.GlobalSchemaContract;
import com.azure.resourcemanager.apimanagement.models.GlobalSchemas;
import com.azure.resourcemanager.apimanagement.models.GlobalSchemasGetEntityTagResponse;
import com.azure.resourcemanager.apimanagement.models.GlobalSchemasGetResponse;

public final class GlobalSchemasImpl implements GlobalSchemas {
    private static final ClientLogger LOGGER = new ClientLogger(GlobalSchemasImpl.class);

    private final GlobalSchemasClient innerClient;

    private final com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager;

    public GlobalSchemasImpl(GlobalSchemasClient innerClient,
        com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<GlobalSchemaContract> listByService(String resourceGroupName, String serviceName) {
        PagedIterable<GlobalSchemaContractInner> inner
            = this.serviceClient().listByService(resourceGroupName, serviceName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GlobalSchemaContractImpl(inner1, this.manager()));
    }

    public PagedIterable<GlobalSchemaContract> listByService(String resourceGroupName, String serviceName,
        String filter, Integer top, Integer skip, Context context) {
        PagedIterable<GlobalSchemaContractInner> inner
            = this.serviceClient().listByService(resourceGroupName, serviceName, filter, top, skip, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GlobalSchemaContractImpl(inner1, this.manager()));
    }

    public GlobalSchemasGetEntityTagResponse getEntityTagWithResponse(String resourceGroupName, String serviceName,
        String schemaId, Context context) {
        return this.serviceClient().getEntityTagWithResponse(resourceGroupName, serviceName, schemaId, context);
    }

    public void getEntityTag(String resourceGroupName, String serviceName, String schemaId) {
        this.serviceClient().getEntityTag(resourceGroupName, serviceName, schemaId);
    }

    public Response<GlobalSchemaContract> getWithResponse(String resourceGroupName, String serviceName, String schemaId,
        Context context) {
        GlobalSchemasGetResponse inner
            = this.serviceClient().getWithResponse(resourceGroupName, serviceName, schemaId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new GlobalSchemaContractImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public GlobalSchemaContract get(String resourceGroupName, String serviceName, String schemaId) {
        GlobalSchemaContractInner inner = this.serviceClient().get(resourceGroupName, serviceName, schemaId);
        if (inner != null) {
            return new GlobalSchemaContractImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteWithResponse(String resourceGroupName, String serviceName, String schemaId,
        String ifMatch, Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, serviceName, schemaId, ifMatch, context);
    }

    public void delete(String resourceGroupName, String serviceName, String schemaId, String ifMatch) {
        this.serviceClient().delete(resourceGroupName, serviceName, schemaId, ifMatch);
    }

    public GlobalSchemaContract getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String serviceName = ResourceManagerUtils.getValueFromIdByName(id, "service");
        if (serviceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'service'.", id)));
        }
        String schemaId = ResourceManagerUtils.getValueFromIdByName(id, "schemas");
        if (schemaId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'schemas'.", id)));
        }
        return this.getWithResponse(resourceGroupName, serviceName, schemaId, Context.NONE).getValue();
    }

    public Response<GlobalSchemaContract> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String serviceName = ResourceManagerUtils.getValueFromIdByName(id, "service");
        if (serviceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'service'.", id)));
        }
        String schemaId = ResourceManagerUtils.getValueFromIdByName(id, "schemas");
        if (schemaId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'schemas'.", id)));
        }
        return this.getWithResponse(resourceGroupName, serviceName, schemaId, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String serviceName = ResourceManagerUtils.getValueFromIdByName(id, "service");
        if (serviceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'service'.", id)));
        }
        String schemaId = ResourceManagerUtils.getValueFromIdByName(id, "schemas");
        if (schemaId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'schemas'.", id)));
        }
        String localIfMatch = null;
        this.deleteWithResponse(resourceGroupName, serviceName, schemaId, localIfMatch, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, String ifMatch, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String serviceName = ResourceManagerUtils.getValueFromIdByName(id, "service");
        if (serviceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'service'.", id)));
        }
        String schemaId = ResourceManagerUtils.getValueFromIdByName(id, "schemas");
        if (schemaId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'schemas'.", id)));
        }
        return this.deleteWithResponse(resourceGroupName, serviceName, schemaId, ifMatch, context);
    }

    private GlobalSchemasClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.apimanagement.ApiManagementManager manager() {
        return this.serviceManager;
    }

    public GlobalSchemaContractImpl define(String name) {
        return new GlobalSchemaContractImpl(name, this.manager());
    }
}
