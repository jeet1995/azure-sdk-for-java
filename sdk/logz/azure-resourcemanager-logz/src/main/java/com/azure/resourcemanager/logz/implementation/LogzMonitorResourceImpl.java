// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logz.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.logz.fluent.models.LogzMonitorResourceInner;
import com.azure.resourcemanager.logz.models.IdentityProperties;
import com.azure.resourcemanager.logz.models.LogzMonitorResource;
import com.azure.resourcemanager.logz.models.LogzMonitorResourceUpdateParameters;
import com.azure.resourcemanager.logz.models.MonitorProperties;
import com.azure.resourcemanager.logz.models.MonitorUpdateProperties;
import com.azure.resourcemanager.logz.models.MonitoredResource;
import com.azure.resourcemanager.logz.models.UserRoleRequest;
import com.azure.resourcemanager.logz.models.UserRoleResponse;
import java.util.Collections;
import java.util.Map;

public final class LogzMonitorResourceImpl
    implements LogzMonitorResource, LogzMonitorResource.Definition, LogzMonitorResource.Update {
    private LogzMonitorResourceInner innerObject;

    private final com.azure.resourcemanager.logz.LogzManager serviceManager;

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

    public MonitorProperties properties() {
        return this.innerModel().properties();
    }

    public IdentityProperties identity() {
        return this.innerModel().identity();
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

    public LogzMonitorResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.logz.LogzManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String monitorName;

    private LogzMonitorResourceUpdateParameters updateBody;

    public LogzMonitorResourceImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public LogzMonitorResource create() {
        this.innerObject = serviceManager.serviceClient()
            .getMonitors()
            .create(resourceGroupName, monitorName, this.innerModel(), Context.NONE);
        return this;
    }

    public LogzMonitorResource create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getMonitors()
            .create(resourceGroupName, monitorName, this.innerModel(), context);
        return this;
    }

    LogzMonitorResourceImpl(String name, com.azure.resourcemanager.logz.LogzManager serviceManager) {
        this.innerObject = new LogzMonitorResourceInner();
        this.serviceManager = serviceManager;
        this.monitorName = name;
    }

    public LogzMonitorResourceImpl update() {
        this.updateBody = new LogzMonitorResourceUpdateParameters();
        return this;
    }

    public LogzMonitorResource apply() {
        this.innerObject = serviceManager.serviceClient()
            .getMonitors()
            .updateWithResponse(resourceGroupName, monitorName, updateBody, Context.NONE)
            .getValue();
        return this;
    }

    public LogzMonitorResource apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getMonitors()
            .updateWithResponse(resourceGroupName, monitorName, updateBody, context)
            .getValue();
        return this;
    }

    LogzMonitorResourceImpl(LogzMonitorResourceInner innerObject,
        com.azure.resourcemanager.logz.LogzManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.monitorName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "monitors");
    }

    public LogzMonitorResource refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getMonitors()
            .getByResourceGroupWithResponse(resourceGroupName, monitorName, Context.NONE)
            .getValue();
        return this;
    }

    public LogzMonitorResource refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getMonitors()
            .getByResourceGroupWithResponse(resourceGroupName, monitorName, context)
            .getValue();
        return this;
    }

    public PagedIterable<MonitoredResource> listMonitoredResources() {
        return serviceManager.monitors().listMonitoredResources(resourceGroupName, monitorName);
    }

    public PagedIterable<MonitoredResource> listMonitoredResources(Context context) {
        return serviceManager.monitors().listMonitoredResources(resourceGroupName, monitorName, context);
    }

    public PagedIterable<UserRoleResponse> listUserRoles() {
        return serviceManager.monitors().listUserRoles(resourceGroupName, monitorName);
    }

    public PagedIterable<UserRoleResponse> listUserRoles(UserRoleRequest body, Context context) {
        return serviceManager.monitors().listUserRoles(resourceGroupName, monitorName, body, context);
    }

    public LogzMonitorResourceImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public LogzMonitorResourceImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public LogzMonitorResourceImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBody.withTags(tags);
            return this;
        }
    }

    public LogzMonitorResourceImpl withProperties(MonitorProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public LogzMonitorResourceImpl withIdentity(IdentityProperties identity) {
        this.innerModel().withIdentity(identity);
        return this;
    }

    public LogzMonitorResourceImpl withProperties(MonitorUpdateProperties properties) {
        this.updateBody.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
