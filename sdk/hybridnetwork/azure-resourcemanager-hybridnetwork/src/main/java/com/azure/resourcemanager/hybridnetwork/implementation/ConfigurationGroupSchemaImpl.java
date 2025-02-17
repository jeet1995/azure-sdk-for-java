// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.hybridnetwork.fluent.models.ConfigurationGroupSchemaInner;
import com.azure.resourcemanager.hybridnetwork.fluent.models.ConfigurationGroupSchemaVersionUpdateStateInner;
import com.azure.resourcemanager.hybridnetwork.models.ConfigurationGroupSchema;
import com.azure.resourcemanager.hybridnetwork.models.ConfigurationGroupSchemaPropertiesFormat;
import com.azure.resourcemanager.hybridnetwork.models.ConfigurationGroupSchemaVersionUpdateState;
import com.azure.resourcemanager.hybridnetwork.models.TagsObject;
import java.util.Collections;
import java.util.Map;

public final class ConfigurationGroupSchemaImpl
    implements ConfigurationGroupSchema, ConfigurationGroupSchema.Definition, ConfigurationGroupSchema.Update {
    private ConfigurationGroupSchemaInner innerObject;

    private final com.azure.resourcemanager.hybridnetwork.HybridNetworkManager serviceManager;

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

    public ConfigurationGroupSchemaPropertiesFormat properties() {
        return this.innerModel().properties();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
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

    public ConfigurationGroupSchemaInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.hybridnetwork.HybridNetworkManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String publisherName;

    private String configurationGroupSchemaName;

    private TagsObject updateParameters;

    public ConfigurationGroupSchemaImpl withExistingPublisher(String resourceGroupName, String publisherName) {
        this.resourceGroupName = resourceGroupName;
        this.publisherName = publisherName;
        return this;
    }

    public ConfigurationGroupSchema create() {
        this.innerObject = serviceManager.serviceClient()
            .getConfigurationGroupSchemas()
            .createOrUpdate(resourceGroupName, publisherName, configurationGroupSchemaName, this.innerModel(),
                Context.NONE);
        return this;
    }

    public ConfigurationGroupSchema create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getConfigurationGroupSchemas()
            .createOrUpdate(resourceGroupName, publisherName, configurationGroupSchemaName, this.innerModel(), context);
        return this;
    }

    ConfigurationGroupSchemaImpl(String name,
        com.azure.resourcemanager.hybridnetwork.HybridNetworkManager serviceManager) {
        this.innerObject = new ConfigurationGroupSchemaInner();
        this.serviceManager = serviceManager;
        this.configurationGroupSchemaName = name;
    }

    public ConfigurationGroupSchemaImpl update() {
        this.updateParameters = new TagsObject();
        return this;
    }

    public ConfigurationGroupSchema apply() {
        this.innerObject = serviceManager.serviceClient()
            .getConfigurationGroupSchemas()
            .updateWithResponse(resourceGroupName, publisherName, configurationGroupSchemaName, updateParameters,
                Context.NONE)
            .getValue();
        return this;
    }

    public ConfigurationGroupSchema apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getConfigurationGroupSchemas()
            .updateWithResponse(resourceGroupName, publisherName, configurationGroupSchemaName, updateParameters,
                context)
            .getValue();
        return this;
    }

    ConfigurationGroupSchemaImpl(ConfigurationGroupSchemaInner innerObject,
        com.azure.resourcemanager.hybridnetwork.HybridNetworkManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.publisherName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "publishers");
        this.configurationGroupSchemaName
            = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "configurationGroupSchemas");
    }

    public ConfigurationGroupSchema refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getConfigurationGroupSchemas()
            .getWithResponse(resourceGroupName, publisherName, configurationGroupSchemaName, Context.NONE)
            .getValue();
        return this;
    }

    public ConfigurationGroupSchema refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getConfigurationGroupSchemas()
            .getWithResponse(resourceGroupName, publisherName, configurationGroupSchemaName, context)
            .getValue();
        return this;
    }

    public ConfigurationGroupSchemaVersionUpdateState
        updateState(ConfigurationGroupSchemaVersionUpdateStateInner parameters) {
        return serviceManager.configurationGroupSchemas()
            .updateState(resourceGroupName, publisherName, configurationGroupSchemaName, parameters);
    }

    public ConfigurationGroupSchemaVersionUpdateState
        updateState(ConfigurationGroupSchemaVersionUpdateStateInner parameters, Context context) {
        return serviceManager.configurationGroupSchemas()
            .updateState(resourceGroupName, publisherName, configurationGroupSchemaName, parameters, context);
    }

    public ConfigurationGroupSchemaImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public ConfigurationGroupSchemaImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public ConfigurationGroupSchemaImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateParameters.withTags(tags);
            return this;
        }
    }

    public ConfigurationGroupSchemaImpl withProperties(ConfigurationGroupSchemaPropertiesFormat properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
