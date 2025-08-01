// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.eventgrid.fluent.models.PartnerRegistrationInner;
import com.azure.resourcemanager.eventgrid.models.PartnerRegistration;
import com.azure.resourcemanager.eventgrid.models.PartnerRegistrationProvisioningState;
import com.azure.resourcemanager.eventgrid.models.PartnerRegistrationUpdateParameters;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public final class PartnerRegistrationImpl
    implements PartnerRegistration, PartnerRegistration.Definition, PartnerRegistration.Update {
    private PartnerRegistrationInner innerObject;

    private final com.azure.resourcemanager.eventgrid.EventGridManager serviceManager;

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

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public PartnerRegistrationProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public UUID partnerRegistrationImmutableId() {
        return this.innerModel().partnerRegistrationImmutableId();
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

    public PartnerRegistrationInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.eventgrid.EventGridManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String partnerRegistrationName;

    private PartnerRegistrationUpdateParameters updatePartnerRegistrationUpdateParameters;

    public PartnerRegistrationImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public PartnerRegistration create() {
        this.innerObject = serviceManager.serviceClient()
            .getPartnerRegistrations()
            .createOrUpdate(resourceGroupName, partnerRegistrationName, this.innerModel(), Context.NONE);
        return this;
    }

    public PartnerRegistration create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getPartnerRegistrations()
            .createOrUpdate(resourceGroupName, partnerRegistrationName, this.innerModel(), context);
        return this;
    }

    PartnerRegistrationImpl(String name, com.azure.resourcemanager.eventgrid.EventGridManager serviceManager) {
        this.innerObject = new PartnerRegistrationInner();
        this.serviceManager = serviceManager;
        this.partnerRegistrationName = name;
    }

    public PartnerRegistrationImpl update() {
        this.updatePartnerRegistrationUpdateParameters = new PartnerRegistrationUpdateParameters();
        return this;
    }

    public PartnerRegistration apply() {
        this.innerObject = serviceManager.serviceClient()
            .getPartnerRegistrations()
            .update(resourceGroupName, partnerRegistrationName, updatePartnerRegistrationUpdateParameters,
                Context.NONE);
        return this;
    }

    public PartnerRegistration apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getPartnerRegistrations()
            .update(resourceGroupName, partnerRegistrationName, updatePartnerRegistrationUpdateParameters, context);
        return this;
    }

    PartnerRegistrationImpl(PartnerRegistrationInner innerObject,
        com.azure.resourcemanager.eventgrid.EventGridManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.partnerRegistrationName
            = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "partnerRegistrations");
    }

    public PartnerRegistration refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getPartnerRegistrations()
            .getByResourceGroupWithResponse(resourceGroupName, partnerRegistrationName, Context.NONE)
            .getValue();
        return this;
    }

    public PartnerRegistration refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getPartnerRegistrations()
            .getByResourceGroupWithResponse(resourceGroupName, partnerRegistrationName, context)
            .getValue();
        return this;
    }

    public PartnerRegistrationImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public PartnerRegistrationImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public PartnerRegistrationImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updatePartnerRegistrationUpdateParameters.withTags(tags);
            return this;
        }
    }

    public PartnerRegistrationImpl withPartnerRegistrationImmutableId(UUID partnerRegistrationImmutableId) {
        this.innerModel().withPartnerRegistrationImmutableId(partnerRegistrationImmutableId);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
