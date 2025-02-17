// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.implementation;

import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.logic.fluent.models.IntegrationServiceEnvironmentManagedApiInner;
import com.azure.resourcemanager.logic.models.ApiResourceBackendService;
import com.azure.resourcemanager.logic.models.ApiResourceDefinitions;
import com.azure.resourcemanager.logic.models.ApiResourceGeneralInformation;
import com.azure.resourcemanager.logic.models.ApiResourceMetadata;
import com.azure.resourcemanager.logic.models.ApiResourcePolicies;
import com.azure.resourcemanager.logic.models.ApiTier;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentManagedApi;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentManagedApiDeploymentParameters;
import com.azure.resourcemanager.logic.models.ResourceReference;
import com.azure.resourcemanager.logic.models.WorkflowProvisioningState;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class IntegrationServiceEnvironmentManagedApiImpl implements IntegrationServiceEnvironmentManagedApi,
    IntegrationServiceEnvironmentManagedApi.Definition, IntegrationServiceEnvironmentManagedApi.Update {
    private IntegrationServiceEnvironmentManagedApiInner innerObject;

    private final com.azure.resourcemanager.logic.LogicManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public IntegrationServiceEnvironmentManagedApiDeploymentParameters deploymentParameters() {
        return this.innerModel().deploymentParameters();
    }

    public String namePropertiesName() {
        return this.innerModel().namePropertiesName();
    }

    public Map<String, Object> connectionParameters() {
        Map<String, Object> inner = this.innerModel().connectionParameters();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public ApiResourceMetadata metadata() {
        return this.innerModel().metadata();
    }

    public List<String> runtimeUrls() {
        List<String> inner = this.innerModel().runtimeUrls();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public ApiResourceGeneralInformation generalInformation() {
        return this.innerModel().generalInformation();
    }

    public List<String> capabilities() {
        List<String> inner = this.innerModel().capabilities();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public ApiResourceBackendService backendService() {
        return this.innerModel().backendService();
    }

    public ApiResourcePolicies policies() {
        return this.innerModel().policies();
    }

    public String apiDefinitionUrl() {
        return this.innerModel().apiDefinitionUrl();
    }

    public ApiResourceDefinitions apiDefinitions() {
        return this.innerModel().apiDefinitions();
    }

    public ResourceReference integrationServiceEnvironment() {
        return this.innerModel().integrationServiceEnvironment();
    }

    public WorkflowProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public ApiTier category() {
        return this.innerModel().category();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroup;
    }

    public IntegrationServiceEnvironmentManagedApiInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.logic.LogicManager manager() {
        return this.serviceManager;
    }

    private String resourceGroup;

    private String integrationServiceEnvironmentName;

    private String apiName;

    public IntegrationServiceEnvironmentManagedApiImpl withExistingIntegrationServiceEnvironment(String resourceGroup,
        String integrationServiceEnvironmentName) {
        this.resourceGroup = resourceGroup;
        this.integrationServiceEnvironmentName = integrationServiceEnvironmentName;
        return this;
    }

    public IntegrationServiceEnvironmentManagedApi create() {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironmentManagedApis()
            .put(resourceGroup, integrationServiceEnvironmentName, apiName, this.innerModel(), Context.NONE);
        return this;
    }

    public IntegrationServiceEnvironmentManagedApi create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironmentManagedApis()
            .put(resourceGroup, integrationServiceEnvironmentName, apiName, this.innerModel(), context);
        return this;
    }

    IntegrationServiceEnvironmentManagedApiImpl(String name,
        com.azure.resourcemanager.logic.LogicManager serviceManager) {
        this.innerObject = new IntegrationServiceEnvironmentManagedApiInner();
        this.serviceManager = serviceManager;
        this.apiName = name;
    }

    public IntegrationServiceEnvironmentManagedApiImpl update() {
        return this;
    }

    public IntegrationServiceEnvironmentManagedApi apply() {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironmentManagedApis()
            .put(resourceGroup, integrationServiceEnvironmentName, apiName, this.innerModel(), Context.NONE);
        return this;
    }

    public IntegrationServiceEnvironmentManagedApi apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironmentManagedApis()
            .put(resourceGroup, integrationServiceEnvironmentName, apiName, this.innerModel(), context);
        return this;
    }

    IntegrationServiceEnvironmentManagedApiImpl(IntegrationServiceEnvironmentManagedApiInner innerObject,
        com.azure.resourcemanager.logic.LogicManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroup = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.integrationServiceEnvironmentName
            = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "integrationServiceEnvironments");
        this.apiName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "managedApis");
    }

    public IntegrationServiceEnvironmentManagedApi refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironmentManagedApis()
            .getWithResponse(resourceGroup, integrationServiceEnvironmentName, apiName, Context.NONE)
            .getValue();
        return this;
    }

    public IntegrationServiceEnvironmentManagedApi refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getIntegrationServiceEnvironmentManagedApis()
            .getWithResponse(resourceGroup, integrationServiceEnvironmentName, apiName, context)
            .getValue();
        return this;
    }

    public IntegrationServiceEnvironmentManagedApiImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public IntegrationServiceEnvironmentManagedApiImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public IntegrationServiceEnvironmentManagedApiImpl withTags(Map<String, String> tags) {
        this.innerModel().withTags(tags);
        return this;
    }

    public IntegrationServiceEnvironmentManagedApiImpl
        withDeploymentParameters(IntegrationServiceEnvironmentManagedApiDeploymentParameters deploymentParameters) {
        this.innerModel().withDeploymentParameters(deploymentParameters);
        return this;
    }

    public IntegrationServiceEnvironmentManagedApiImpl
        withIntegrationServiceEnvironment(ResourceReference integrationServiceEnvironment) {
        this.innerModel().withIntegrationServiceEnvironment(integrationServiceEnvironment);
        return this;
    }
}
