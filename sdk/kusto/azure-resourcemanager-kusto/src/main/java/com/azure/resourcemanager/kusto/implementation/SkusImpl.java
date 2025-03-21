// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.kusto.fluent.SkusClient;
import com.azure.resourcemanager.kusto.fluent.models.SkuDescriptionInner;
import com.azure.resourcemanager.kusto.models.SkuDescription;
import com.azure.resourcemanager.kusto.models.Skus;

public final class SkusImpl implements Skus {
    private static final ClientLogger LOGGER = new ClientLogger(SkusImpl.class);

    private final SkusClient innerClient;

    private final com.azure.resourcemanager.kusto.KustoManager serviceManager;

    public SkusImpl(SkusClient innerClient, com.azure.resourcemanager.kusto.KustoManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<SkuDescription> list(String location) {
        PagedIterable<SkuDescriptionInner> inner = this.serviceClient().list(location);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new SkuDescriptionImpl(inner1, this.manager()));
    }

    public PagedIterable<SkuDescription> list(String location, Context context) {
        PagedIterable<SkuDescriptionInner> inner = this.serviceClient().list(location, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new SkuDescriptionImpl(inner1, this.manager()));
    }

    private SkusClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.kusto.KustoManager manager() {
        return this.serviceManager;
    }
}
