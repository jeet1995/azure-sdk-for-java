// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elastic.implementation;

import com.azure.resourcemanager.elastic.fluent.models.ElasticOrganizationToAzureSubscriptionMappingResponseInner;
import com.azure.resourcemanager.elastic.models.ElasticOrganizationToAzureSubscriptionMappingResponse;
import com.azure.resourcemanager.elastic.models.ElasticOrganizationToAzureSubscriptionMappingResponseProperties;

public final class ElasticOrganizationToAzureSubscriptionMappingResponseImpl
    implements ElasticOrganizationToAzureSubscriptionMappingResponse {
    private ElasticOrganizationToAzureSubscriptionMappingResponseInner innerObject;

    private final com.azure.resourcemanager.elastic.ElasticManager serviceManager;

    ElasticOrganizationToAzureSubscriptionMappingResponseImpl(
        ElasticOrganizationToAzureSubscriptionMappingResponseInner innerObject,
        com.azure.resourcemanager.elastic.ElasticManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public ElasticOrganizationToAzureSubscriptionMappingResponseProperties properties() {
        return this.innerModel().properties();
    }

    public ElasticOrganizationToAzureSubscriptionMappingResponseInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.elastic.ElasticManager manager() {
        return this.serviceManager;
    }
}
