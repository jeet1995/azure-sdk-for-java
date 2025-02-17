// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.FqdnListGlobalRulestacksClient;
import com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.models.FqdnListGlobalRulestackResourceInner;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.FqdnListGlobalRulestackResource;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.FqdnListGlobalRulestacks;

public final class FqdnListGlobalRulestacksImpl implements FqdnListGlobalRulestacks {
    private static final ClientLogger LOGGER = new ClientLogger(FqdnListGlobalRulestacksImpl.class);

    private final FqdnListGlobalRulestacksClient innerClient;

    private final com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager serviceManager;

    public FqdnListGlobalRulestacksImpl(FqdnListGlobalRulestacksClient innerClient,
        com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<FqdnListGlobalRulestackResource> list(String globalRulestackName) {
        PagedIterable<FqdnListGlobalRulestackResourceInner> inner = this.serviceClient().list(globalRulestackName);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new FqdnListGlobalRulestackResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<FqdnListGlobalRulestackResource> list(String globalRulestackName, Context context) {
        PagedIterable<FqdnListGlobalRulestackResourceInner> inner
            = this.serviceClient().list(globalRulestackName, context);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new FqdnListGlobalRulestackResourceImpl(inner1, this.manager()));
    }

    public Response<FqdnListGlobalRulestackResource> getWithResponse(String globalRulestackName, String name,
        Context context) {
        Response<FqdnListGlobalRulestackResourceInner> inner
            = this.serviceClient().getWithResponse(globalRulestackName, name, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new FqdnListGlobalRulestackResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public FqdnListGlobalRulestackResource get(String globalRulestackName, String name) {
        FqdnListGlobalRulestackResourceInner inner = this.serviceClient().get(globalRulestackName, name);
        if (inner != null) {
            return new FqdnListGlobalRulestackResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public FqdnListGlobalRulestackResource createOrUpdate(String globalRulestackName, String name,
        FqdnListGlobalRulestackResourceInner resource) {
        FqdnListGlobalRulestackResourceInner inner
            = this.serviceClient().createOrUpdate(globalRulestackName, name, resource);
        if (inner != null) {
            return new FqdnListGlobalRulestackResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public FqdnListGlobalRulestackResource createOrUpdate(String globalRulestackName, String name,
        FqdnListGlobalRulestackResourceInner resource, Context context) {
        FqdnListGlobalRulestackResourceInner inner
            = this.serviceClient().createOrUpdate(globalRulestackName, name, resource, context);
        if (inner != null) {
            return new FqdnListGlobalRulestackResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void deleteByResourceGroup(String globalRulestackName, String name) {
        this.serviceClient().delete(globalRulestackName, name);
    }

    public void delete(String globalRulestackName, String name, Context context) {
        this.serviceClient().delete(globalRulestackName, name, context);
    }

    private FqdnListGlobalRulestacksClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager manager() {
        return this.serviceManager;
    }
}
