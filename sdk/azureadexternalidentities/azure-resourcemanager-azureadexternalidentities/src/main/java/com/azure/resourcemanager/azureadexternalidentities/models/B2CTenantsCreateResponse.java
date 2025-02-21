// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azureadexternalidentities.models;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.ResponseBase;
import com.azure.resourcemanager.azureadexternalidentities.fluent.models.B2CTenantResourceInner;

/** Contains all response data for the create operation. */
public final class B2CTenantsCreateResponse extends ResponseBase<B2CTenantsCreateHeaders, B2CTenantResourceInner> {
    /**
     * Creates an instance of B2CTenantsCreateResponse.
     *
     * @param request the request which resulted in this B2CTenantsCreateResponse.
     * @param statusCode the status code of the HTTP response.
     * @param rawHeaders the raw headers of the HTTP response.
     * @param value the deserialized value of the HTTP response.
     * @param headers the deserialized headers of the HTTP response.
     */
    public B2CTenantsCreateResponse(HttpRequest request, int statusCode, HttpHeaders rawHeaders,
        B2CTenantResourceInner value, B2CTenantsCreateHeaders headers) {
        super(request, statusCode, rawHeaders, value, headers);
    }

    /** @return the deserialized response body. */
    @Override
    public B2CTenantResourceInner getValue() {
        return super.getValue();
    }
}
