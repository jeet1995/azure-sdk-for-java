// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.webpubsub.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.webpubsub.fluent.WebPubSubCustomCertificatesClient;
import com.azure.resourcemanager.webpubsub.fluent.models.CustomCertificateInner;
import com.azure.resourcemanager.webpubsub.models.CustomCertificate;
import com.azure.resourcemanager.webpubsub.models.WebPubSubCustomCertificates;

public final class WebPubSubCustomCertificatesImpl implements WebPubSubCustomCertificates {
    private static final ClientLogger LOGGER = new ClientLogger(WebPubSubCustomCertificatesImpl.class);

    private final WebPubSubCustomCertificatesClient innerClient;

    private final com.azure.resourcemanager.webpubsub.WebPubSubManager serviceManager;

    public WebPubSubCustomCertificatesImpl(WebPubSubCustomCertificatesClient innerClient,
        com.azure.resourcemanager.webpubsub.WebPubSubManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<CustomCertificate> list(String resourceGroupName, String resourceName) {
        PagedIterable<CustomCertificateInner> inner = this.serviceClient().list(resourceGroupName, resourceName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new CustomCertificateImpl(inner1, this.manager()));
    }

    public PagedIterable<CustomCertificate> list(String resourceGroupName, String resourceName, Context context) {
        PagedIterable<CustomCertificateInner> inner
            = this.serviceClient().list(resourceGroupName, resourceName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new CustomCertificateImpl(inner1, this.manager()));
    }

    public Response<CustomCertificate> getWithResponse(String resourceGroupName, String resourceName,
        String certificateName, Context context) {
        Response<CustomCertificateInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, resourceName, certificateName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new CustomCertificateImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public CustomCertificate get(String resourceGroupName, String resourceName, String certificateName) {
        CustomCertificateInner inner = this.serviceClient().get(resourceGroupName, resourceName, certificateName);
        if (inner != null) {
            return new CustomCertificateImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteWithResponse(String resourceGroupName, String resourceName, String certificateName,
        Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, resourceName, certificateName, context);
    }

    public void delete(String resourceGroupName, String resourceName, String certificateName) {
        this.serviceClient().delete(resourceGroupName, resourceName, certificateName);
    }

    public CustomCertificate getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "webPubSub");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'webPubSub'.", id)));
        }
        String certificateName = ResourceManagerUtils.getValueFromIdByName(id, "customCertificates");
        if (certificateName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'customCertificates'.", id)));
        }
        return this.getWithResponse(resourceGroupName, resourceName, certificateName, Context.NONE).getValue();
    }

    public Response<CustomCertificate> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "webPubSub");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'webPubSub'.", id)));
        }
        String certificateName = ResourceManagerUtils.getValueFromIdByName(id, "customCertificates");
        if (certificateName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'customCertificates'.", id)));
        }
        return this.getWithResponse(resourceGroupName, resourceName, certificateName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "webPubSub");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'webPubSub'.", id)));
        }
        String certificateName = ResourceManagerUtils.getValueFromIdByName(id, "customCertificates");
        if (certificateName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'customCertificates'.", id)));
        }
        this.deleteWithResponse(resourceGroupName, resourceName, certificateName, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "webPubSub");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'webPubSub'.", id)));
        }
        String certificateName = ResourceManagerUtils.getValueFromIdByName(id, "customCertificates");
        if (certificateName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'customCertificates'.", id)));
        }
        return this.deleteWithResponse(resourceGroupName, resourceName, certificateName, context);
    }

    private WebPubSubCustomCertificatesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.webpubsub.WebPubSubManager manager() {
        return this.serviceManager;
    }

    public CustomCertificateImpl define(String name) {
        return new CustomCertificateImpl(name, this.manager());
    }
}
