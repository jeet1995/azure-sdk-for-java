// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.digitaltwins.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.digitaltwins.fluent.models.DigitalTwinsDescriptionInner;
import com.azure.resourcemanager.digitaltwins.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsDescription;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsIdentity;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsPatchDescription;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsPatchProperties;
import com.azure.resourcemanager.digitaltwins.models.PrivateEndpointConnection;
import com.azure.resourcemanager.digitaltwins.models.ProvisioningState;
import com.azure.resourcemanager.digitaltwins.models.PublicNetworkAccess;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class DigitalTwinsDescriptionImpl
    implements DigitalTwinsDescription, DigitalTwinsDescription.Definition, DigitalTwinsDescription.Update {
    private DigitalTwinsDescriptionInner innerObject;

    private final com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager serviceManager;

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

    public DigitalTwinsIdentity identity() {
        return this.innerModel().identity();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public OffsetDateTime createdTime() {
        return this.innerModel().createdTime();
    }

    public OffsetDateTime lastUpdatedTime() {
        return this.innerModel().lastUpdatedTime();
    }

    public ProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String hostname() {
        return this.innerModel().hostname();
    }

    public List<PrivateEndpointConnection> privateEndpointConnections() {
        List<PrivateEndpointConnectionInner> inner = this.innerModel().privateEndpointConnections();
        if (inner != null) {
            return Collections.unmodifiableList(inner.stream()
                .map(inner1 -> new PrivateEndpointConnectionImpl(inner1, this.manager()))
                .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public PublicNetworkAccess publicNetworkAccess() {
        return this.innerModel().publicNetworkAccess();
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

    public DigitalTwinsDescriptionInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String resourceName;

    private DigitalTwinsPatchDescription updateDigitalTwinsPatchDescription;

    public DigitalTwinsDescriptionImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public DigitalTwinsDescription create() {
        this.innerObject = serviceManager.serviceClient()
            .getDigitalTwins()
            .createOrUpdate(resourceGroupName, resourceName, this.innerModel(), Context.NONE);
        return this;
    }

    public DigitalTwinsDescription create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDigitalTwins()
            .createOrUpdate(resourceGroupName, resourceName, this.innerModel(), context);
        return this;
    }

    DigitalTwinsDescriptionImpl(String name,
        com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager serviceManager) {
        this.innerObject = new DigitalTwinsDescriptionInner();
        this.serviceManager = serviceManager;
        this.resourceName = name;
    }

    public DigitalTwinsDescriptionImpl update() {
        this.updateDigitalTwinsPatchDescription = new DigitalTwinsPatchDescription();
        return this;
    }

    public DigitalTwinsDescription apply() {
        this.innerObject = serviceManager.serviceClient()
            .getDigitalTwins()
            .update(resourceGroupName, resourceName, updateDigitalTwinsPatchDescription, Context.NONE);
        return this;
    }

    public DigitalTwinsDescription apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDigitalTwins()
            .update(resourceGroupName, resourceName, updateDigitalTwinsPatchDescription, context);
        return this;
    }

    DigitalTwinsDescriptionImpl(DigitalTwinsDescriptionInner innerObject,
        com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.resourceName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "digitalTwinsInstances");
    }

    public DigitalTwinsDescription refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getDigitalTwins()
            .getByResourceGroupWithResponse(resourceGroupName, resourceName, Context.NONE)
            .getValue();
        return this;
    }

    public DigitalTwinsDescription refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDigitalTwins()
            .getByResourceGroupWithResponse(resourceGroupName, resourceName, context)
            .getValue();
        return this;
    }

    public DigitalTwinsDescriptionImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public DigitalTwinsDescriptionImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public DigitalTwinsDescriptionImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateDigitalTwinsPatchDescription.withTags(tags);
            return this;
        }
    }

    public DigitalTwinsDescriptionImpl withIdentity(DigitalTwinsIdentity identity) {
        if (isInCreateMode()) {
            this.innerModel().withIdentity(identity);
            return this;
        } else {
            this.updateDigitalTwinsPatchDescription.withIdentity(identity);
            return this;
        }
    }

    public DigitalTwinsDescriptionImpl
        withPrivateEndpointConnections(List<PrivateEndpointConnectionInner> privateEndpointConnections) {
        this.innerModel().withPrivateEndpointConnections(privateEndpointConnections);
        return this;
    }

    public DigitalTwinsDescriptionImpl withPublicNetworkAccess(PublicNetworkAccess publicNetworkAccess) {
        this.innerModel().withPublicNetworkAccess(publicNetworkAccess);
        return this;
    }

    public DigitalTwinsDescriptionImpl withProperties(DigitalTwinsPatchProperties properties) {
        this.updateDigitalTwinsPatchDescription.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
