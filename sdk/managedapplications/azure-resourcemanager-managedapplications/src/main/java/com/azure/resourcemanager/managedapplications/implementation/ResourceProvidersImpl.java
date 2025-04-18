// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managedapplications.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.managedapplications.fluent.ResourceProvidersClient;
import com.azure.resourcemanager.managedapplications.fluent.models.OperationInner;
import com.azure.resourcemanager.managedapplications.models.Operation;
import com.azure.resourcemanager.managedapplications.models.ResourceProviders;

public final class ResourceProvidersImpl implements ResourceProviders {
    private static final ClientLogger LOGGER = new ClientLogger(ResourceProvidersImpl.class);

    private final ResourceProvidersClient innerClient;

    private final com.azure.resourcemanager.managedapplications.ApplicationManager serviceManager;

    public ResourceProvidersImpl(ResourceProvidersClient innerClient,
        com.azure.resourcemanager.managedapplications.ApplicationManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<Operation> listOperations() {
        PagedIterable<OperationInner> inner = this.serviceClient().listOperations();
        return ResourceManagerUtils.mapPage(inner, inner1 -> new OperationImpl(inner1, this.manager()));
    }

    public PagedIterable<Operation> listOperations(Context context) {
        PagedIterable<OperationInner> inner = this.serviceClient().listOperations(context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new OperationImpl(inner1, this.manager()));
    }

    private ResourceProvidersClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.managedapplications.ApplicationManager manager() {
        return this.serviceManager;
    }
}
