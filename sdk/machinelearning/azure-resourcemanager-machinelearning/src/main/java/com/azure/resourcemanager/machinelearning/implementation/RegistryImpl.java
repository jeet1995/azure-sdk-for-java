// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.machinelearning.fluent.models.RegistryInner;
import com.azure.resourcemanager.machinelearning.models.ArmResourceId;
import com.azure.resourcemanager.machinelearning.models.ManagedServiceIdentity;
import com.azure.resourcemanager.machinelearning.models.PartialRegistryPartialTrackedResource;
import com.azure.resourcemanager.machinelearning.models.PartialSku;
import com.azure.resourcemanager.machinelearning.models.Registry;
import com.azure.resourcemanager.machinelearning.models.RegistryPartialManagedServiceIdentity;
import com.azure.resourcemanager.machinelearning.models.RegistryPrivateEndpointConnection;
import com.azure.resourcemanager.machinelearning.models.RegistryRegionArmDetails;
import com.azure.resourcemanager.machinelearning.models.Sku;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class RegistryImpl implements Registry, Registry.Definition, Registry.Update {
    private RegistryInner innerObject;

    private final com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager;

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

    public ManagedServiceIdentity identity() {
        return this.innerModel().identity();
    }

    public String kind() {
        return this.innerModel().kind();
    }

    public Sku sku() {
        return this.innerModel().sku();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public String discoveryUrl() {
        return this.innerModel().discoveryUrl();
    }

    public String intellectualPropertyPublisher() {
        return this.innerModel().intellectualPropertyPublisher();
    }

    public ArmResourceId managedResourceGroup() {
        return this.innerModel().managedResourceGroup();
    }

    public String mlFlowRegistryUri() {
        return this.innerModel().mlFlowRegistryUri();
    }

    public List<RegistryPrivateEndpointConnection> registryPrivateEndpointConnections() {
        List<RegistryPrivateEndpointConnection> inner = this.innerModel().registryPrivateEndpointConnections();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String publicNetworkAccess() {
        return this.innerModel().publicNetworkAccess();
    }

    public List<RegistryRegionArmDetails> regionDetails() {
        List<RegistryRegionArmDetails> inner = this.innerModel().regionDetails();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public RegistryInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.machinelearning.MachineLearningManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String registryName;

    private PartialRegistryPartialTrackedResource updateBody;

    public RegistryImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public Registry create() {
        this.innerObject = serviceManager.serviceClient()
            .getRegistries()
            .createOrUpdate(resourceGroupName, registryName, this.innerModel(), Context.NONE);
        return this;
    }

    public Registry create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getRegistries()
            .createOrUpdate(resourceGroupName, registryName, this.innerModel(), context);
        return this;
    }

    RegistryImpl(String name, com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerObject = new RegistryInner();
        this.serviceManager = serviceManager;
        this.registryName = name;
    }

    public RegistryImpl update() {
        this.updateBody = new PartialRegistryPartialTrackedResource();
        return this;
    }

    public Registry apply() {
        this.innerObject = serviceManager.serviceClient()
            .getRegistries()
            .updateWithResponse(resourceGroupName, registryName, updateBody, Context.NONE)
            .getValue();
        return this;
    }

    public Registry apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getRegistries()
            .updateWithResponse(resourceGroupName, registryName, updateBody, context)
            .getValue();
        return this;
    }

    RegistryImpl(RegistryInner innerObject,
        com.azure.resourcemanager.machinelearning.MachineLearningManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.registryName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "registries");
    }

    public Registry refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getRegistries()
            .getByResourceGroupWithResponse(resourceGroupName, registryName, Context.NONE)
            .getValue();
        return this;
    }

    public Registry refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getRegistries()
            .getByResourceGroupWithResponse(resourceGroupName, registryName, context)
            .getValue();
        return this;
    }

    public Registry removeRegions(RegistryInner body) {
        return serviceManager.registries().removeRegions(resourceGroupName, registryName, body);
    }

    public Registry removeRegions(RegistryInner body, Context context) {
        return serviceManager.registries().removeRegions(resourceGroupName, registryName, body, context);
    }

    public RegistryImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public RegistryImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public RegistryImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBody.withTags(tags);
            return this;
        }
    }

    public RegistryImpl withIdentity(ManagedServiceIdentity identity) {
        this.innerModel().withIdentity(identity);
        return this;
    }

    public RegistryImpl withKind(String kind) {
        this.innerModel().withKind(kind);
        return this;
    }

    public RegistryImpl withSku(Sku sku) {
        this.innerModel().withSku(sku);
        return this;
    }

    public RegistryImpl withDiscoveryUrl(String discoveryUrl) {
        this.innerModel().withDiscoveryUrl(discoveryUrl);
        return this;
    }

    public RegistryImpl withIntellectualPropertyPublisher(String intellectualPropertyPublisher) {
        this.innerModel().withIntellectualPropertyPublisher(intellectualPropertyPublisher);
        return this;
    }

    public RegistryImpl withManagedResourceGroup(ArmResourceId managedResourceGroup) {
        this.innerModel().withManagedResourceGroup(managedResourceGroup);
        return this;
    }

    public RegistryImpl withMlFlowRegistryUri(String mlFlowRegistryUri) {
        this.innerModel().withMlFlowRegistryUri(mlFlowRegistryUri);
        return this;
    }

    public RegistryImpl withRegistryPrivateEndpointConnections(
        List<RegistryPrivateEndpointConnection> registryPrivateEndpointConnections) {
        this.innerModel().withRegistryPrivateEndpointConnections(registryPrivateEndpointConnections);
        return this;
    }

    public RegistryImpl withPublicNetworkAccess(String publicNetworkAccess) {
        this.innerModel().withPublicNetworkAccess(publicNetworkAccess);
        return this;
    }

    public RegistryImpl withRegionDetails(List<RegistryRegionArmDetails> regionDetails) {
        this.innerModel().withRegionDetails(regionDetails);
        return this;
    }

    public RegistryImpl withIdentity(RegistryPartialManagedServiceIdentity identity) {
        this.updateBody.withIdentity(identity);
        return this;
    }

    public RegistryImpl withSku(PartialSku sku) {
        this.updateBody.withSku(sku);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
