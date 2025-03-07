// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.workloadssapvirtualinstance.implementation;

import com.azure.resourcemanager.workloadssapvirtualinstance.fluent.models.SapSizingRecommendationResultInner;
import com.azure.resourcemanager.workloadssapvirtualinstance.models.SapDeploymentType;
import com.azure.resourcemanager.workloadssapvirtualinstance.models.SapSizingRecommendationResult;

public final class SapSizingRecommendationResultImpl implements SapSizingRecommendationResult {
    private SapSizingRecommendationResultInner innerObject;

    private final com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager serviceManager;

    SapSizingRecommendationResultImpl(SapSizingRecommendationResultInner innerObject,
        com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public SapDeploymentType deploymentType() {
        return this.innerModel().deploymentType();
    }

    public SapSizingRecommendationResultInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager manager() {
        return this.serviceManager;
    }
}
