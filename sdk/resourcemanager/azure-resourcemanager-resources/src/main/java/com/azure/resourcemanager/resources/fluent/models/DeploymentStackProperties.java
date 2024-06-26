// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.exception.ManagementError;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.resources.models.ActionOnUnmanage;
import com.azure.resourcemanager.resources.models.DenySettings;
import com.azure.resourcemanager.resources.models.DeploymentParameter;
import com.azure.resourcemanager.resources.models.DeploymentStackProvisioningState;
import com.azure.resourcemanager.resources.models.DeploymentStacksDebugSetting;
import com.azure.resourcemanager.resources.models.DeploymentStacksParametersLink;
import com.azure.resourcemanager.resources.models.DeploymentStacksTemplateLink;
import com.azure.resourcemanager.resources.models.ManagedResourceReference;
import com.azure.resourcemanager.resources.models.ResourceReference;
import com.azure.resourcemanager.resources.models.ResourceReferenceExtended;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * Deployment stack properties.
 */
@Fluent
public final class DeploymentStackProperties {
    /*
     * The template content. You use this element when you want to pass the template syntax directly in the request rather than link to an existing template. It can be a JObject or well-formed JSON string. Use either the templateLink property or the template property, but not both.
     */
    @JsonProperty(value = "template")
    private Object template;

    /*
     * The URI of the template. Use either the templateLink property or the template property, but not both.
     */
    @JsonProperty(value = "templateLink")
    private DeploymentStacksTemplateLink templateLink;

    /*
     * Name and value pairs that define the deployment parameters for the template. Use this element when providing the parameter values directly in the request, rather than linking to an existing parameter file. Use either the parametersLink property or the parameters property, but not both.
     */
    @JsonProperty(value = "parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, DeploymentParameter> parameters;

    /*
     * The URI of parameters file. Use this element to link to an existing parameters file. Use either the parametersLink property or the parameters property, but not both.
     */
    @JsonProperty(value = "parametersLink")
    private DeploymentStacksParametersLink parametersLink;

    /*
     * Defines the behavior of resources that are no longer managed after the Deployment stack is updated or deleted.
     */
    @JsonProperty(value = "actionOnUnmanage", required = true)
    private ActionOnUnmanage actionOnUnmanage;

    /*
     * The debug setting of the deployment.
     */
    @JsonProperty(value = "debugSetting")
    private DeploymentStacksDebugSetting debugSetting;

    /*
     * Flag to bypass service errors that indicate the stack resource list is not correctly synchronized.
     */
    @JsonProperty(value = "bypassStackOutOfSyncError")
    private Boolean bypassStackOutOfSyncError;

    /*
     * The scope at which the initial deployment should be created. If a scope is not specified, it will default to the scope of the deployment stack. Valid scopes are: management group (format: '/providers/Microsoft.Management/managementGroups/{managementGroupId}'), subscription (format: '/subscriptions/{subscriptionId}'), resource group (format: '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}').
     */
    @JsonProperty(value = "deploymentScope")
    private String deploymentScope;

    /*
     * Deployment stack description. Max length of 4096 characters.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * Defines how resources deployed by the stack are locked.
     */
    @JsonProperty(value = "denySettings", required = true)
    private DenySettings denySettings;

    /*
     * State of the deployment stack.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private DeploymentStackProvisioningState provisioningState;

    /*
     * The correlation id of the last Deployment stack upsert or delete operation. It is in GUID format and is used for tracing.
     */
    @JsonProperty(value = "correlationId", access = JsonProperty.Access.WRITE_ONLY)
    private String correlationId;

    /*
     * An array of resources that were detached during the most recent Deployment stack update. Detached means that the resource was removed from the template, but no relevant deletion operations were specified. So, the resource still exists while no longer being associated with the stack.
     */
    @JsonProperty(value = "detachedResources", access = JsonProperty.Access.WRITE_ONLY)
    private List<ResourceReference> detachedResources;

    /*
     * An array of resources that were deleted during the most recent Deployment stack update. Deleted means that the resource was removed from the template and relevant deletion operations were specified.
     */
    @JsonProperty(value = "deletedResources", access = JsonProperty.Access.WRITE_ONLY)
    private List<ResourceReference> deletedResources;

    /*
     * An array of resources that failed to reach goal state during the most recent update. Each resourceId is accompanied by an error message.
     */
    @JsonProperty(value = "failedResources", access = JsonProperty.Access.WRITE_ONLY)
    private List<ResourceReferenceExtended> failedResources;

    /*
     * An array of resources currently managed by the deployment stack.
     */
    @JsonProperty(value = "resources", access = JsonProperty.Access.WRITE_ONLY)
    private List<ManagedResourceReference> resources;

    /*
     * The resourceId of the deployment resource created by the deployment stack.
     */
    @JsonProperty(value = "deploymentId", access = JsonProperty.Access.WRITE_ONLY)
    private String deploymentId;

    /*
     * The outputs of the deployment resource created by the deployment stack.
     */
    @JsonProperty(value = "outputs", access = JsonProperty.Access.WRITE_ONLY)
    private Object outputs;

    /*
     * The duration of the last successful Deployment stack update.
     */
    @JsonProperty(value = "duration", access = JsonProperty.Access.WRITE_ONLY)
    private String duration;

    /*
     * The error detail.
     */
    @JsonProperty(value = "error")
    private ManagementError error;

    /**
     * Creates an instance of DeploymentStackProperties class.
     */
    public DeploymentStackProperties() {
    }

    /**
     * Get the template property: The template content. You use this element when you want to pass the template syntax
     * directly in the request rather than link to an existing template. It can be a JObject or well-formed JSON string.
     * Use either the templateLink property or the template property, but not both.
     * 
     * @return the template value.
     */
    public Object template() {
        return this.template;
    }

    /**
     * Set the template property: The template content. You use this element when you want to pass the template syntax
     * directly in the request rather than link to an existing template. It can be a JObject or well-formed JSON string.
     * Use either the templateLink property or the template property, but not both.
     * 
     * @param template the template value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withTemplate(Object template) {
        this.template = template;
        return this;
    }

    /**
     * Get the templateLink property: The URI of the template. Use either the templateLink property or the template
     * property, but not both.
     * 
     * @return the templateLink value.
     */
    public DeploymentStacksTemplateLink templateLink() {
        return this.templateLink;
    }

    /**
     * Set the templateLink property: The URI of the template. Use either the templateLink property or the template
     * property, but not both.
     * 
     * @param templateLink the templateLink value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withTemplateLink(DeploymentStacksTemplateLink templateLink) {
        this.templateLink = templateLink;
        return this;
    }

    /**
     * Get the parameters property: Name and value pairs that define the deployment parameters for the template. Use
     * this element when providing the parameter values directly in the request, rather than linking to an existing
     * parameter file. Use either the parametersLink property or the parameters property, but not both.
     * 
     * @return the parameters value.
     */
    public Map<String, DeploymentParameter> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Name and value pairs that define the deployment parameters for the template. Use
     * this element when providing the parameter values directly in the request, rather than linking to an existing
     * parameter file. Use either the parametersLink property or the parameters property, but not both.
     * 
     * @param parameters the parameters value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withParameters(Map<String, DeploymentParameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the parametersLink property: The URI of parameters file. Use this element to link to an existing parameters
     * file. Use either the parametersLink property or the parameters property, but not both.
     * 
     * @return the parametersLink value.
     */
    public DeploymentStacksParametersLink parametersLink() {
        return this.parametersLink;
    }

    /**
     * Set the parametersLink property: The URI of parameters file. Use this element to link to an existing parameters
     * file. Use either the parametersLink property or the parameters property, but not both.
     * 
     * @param parametersLink the parametersLink value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withParametersLink(DeploymentStacksParametersLink parametersLink) {
        this.parametersLink = parametersLink;
        return this;
    }

    /**
     * Get the actionOnUnmanage property: Defines the behavior of resources that are no longer managed after the
     * Deployment stack is updated or deleted.
     * 
     * @return the actionOnUnmanage value.
     */
    public ActionOnUnmanage actionOnUnmanage() {
        return this.actionOnUnmanage;
    }

    /**
     * Set the actionOnUnmanage property: Defines the behavior of resources that are no longer managed after the
     * Deployment stack is updated or deleted.
     * 
     * @param actionOnUnmanage the actionOnUnmanage value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withActionOnUnmanage(ActionOnUnmanage actionOnUnmanage) {
        this.actionOnUnmanage = actionOnUnmanage;
        return this;
    }

    /**
     * Get the debugSetting property: The debug setting of the deployment.
     * 
     * @return the debugSetting value.
     */
    public DeploymentStacksDebugSetting debugSetting() {
        return this.debugSetting;
    }

    /**
     * Set the debugSetting property: The debug setting of the deployment.
     * 
     * @param debugSetting the debugSetting value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withDebugSetting(DeploymentStacksDebugSetting debugSetting) {
        this.debugSetting = debugSetting;
        return this;
    }

    /**
     * Get the bypassStackOutOfSyncError property: Flag to bypass service errors that indicate the stack resource list
     * is not correctly synchronized.
     * 
     * @return the bypassStackOutOfSyncError value.
     */
    public Boolean bypassStackOutOfSyncError() {
        return this.bypassStackOutOfSyncError;
    }

    /**
     * Set the bypassStackOutOfSyncError property: Flag to bypass service errors that indicate the stack resource list
     * is not correctly synchronized.
     * 
     * @param bypassStackOutOfSyncError the bypassStackOutOfSyncError value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withBypassStackOutOfSyncError(Boolean bypassStackOutOfSyncError) {
        this.bypassStackOutOfSyncError = bypassStackOutOfSyncError;
        return this;
    }

    /**
     * Get the deploymentScope property: The scope at which the initial deployment should be created. If a scope is not
     * specified, it will default to the scope of the deployment stack. Valid scopes are: management group (format:
     * '/providers/Microsoft.Management/managementGroups/{managementGroupId}'), subscription (format:
     * '/subscriptions/{subscriptionId}'), resource group (format:
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}').
     * 
     * @return the deploymentScope value.
     */
    public String deploymentScope() {
        return this.deploymentScope;
    }

    /**
     * Set the deploymentScope property: The scope at which the initial deployment should be created. If a scope is not
     * specified, it will default to the scope of the deployment stack. Valid scopes are: management group (format:
     * '/providers/Microsoft.Management/managementGroups/{managementGroupId}'), subscription (format:
     * '/subscriptions/{subscriptionId}'), resource group (format:
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}').
     * 
     * @param deploymentScope the deploymentScope value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withDeploymentScope(String deploymentScope) {
        this.deploymentScope = deploymentScope;
        return this;
    }

    /**
     * Get the description property: Deployment stack description. Max length of 4096 characters.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Deployment stack description. Max length of 4096 characters.
     * 
     * @param description the description value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the denySettings property: Defines how resources deployed by the stack are locked.
     * 
     * @return the denySettings value.
     */
    public DenySettings denySettings() {
        return this.denySettings;
    }

    /**
     * Set the denySettings property: Defines how resources deployed by the stack are locked.
     * 
     * @param denySettings the denySettings value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withDenySettings(DenySettings denySettings) {
        this.denySettings = denySettings;
        return this;
    }

    /**
     * Get the provisioningState property: State of the deployment stack.
     * 
     * @return the provisioningState value.
     */
    public DeploymentStackProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the correlationId property: The correlation id of the last Deployment stack upsert or delete operation. It is
     * in GUID format and is used for tracing.
     * 
     * @return the correlationId value.
     */
    public String correlationId() {
        return this.correlationId;
    }

    /**
     * Get the detachedResources property: An array of resources that were detached during the most recent Deployment
     * stack update. Detached means that the resource was removed from the template, but no relevant deletion operations
     * were specified. So, the resource still exists while no longer being associated with the stack.
     * 
     * @return the detachedResources value.
     */
    public List<ResourceReference> detachedResources() {
        return this.detachedResources;
    }

    /**
     * Get the deletedResources property: An array of resources that were deleted during the most recent Deployment
     * stack update. Deleted means that the resource was removed from the template and relevant deletion operations were
     * specified.
     * 
     * @return the deletedResources value.
     */
    public List<ResourceReference> deletedResources() {
        return this.deletedResources;
    }

    /**
     * Get the failedResources property: An array of resources that failed to reach goal state during the most recent
     * update. Each resourceId is accompanied by an error message.
     * 
     * @return the failedResources value.
     */
    public List<ResourceReferenceExtended> failedResources() {
        return this.failedResources;
    }

    /**
     * Get the resources property: An array of resources currently managed by the deployment stack.
     * 
     * @return the resources value.
     */
    public List<ManagedResourceReference> resources() {
        return this.resources;
    }

    /**
     * Get the deploymentId property: The resourceId of the deployment resource created by the deployment stack.
     * 
     * @return the deploymentId value.
     */
    public String deploymentId() {
        return this.deploymentId;
    }

    /**
     * Get the outputs property: The outputs of the deployment resource created by the deployment stack.
     * 
     * @return the outputs value.
     */
    public Object outputs() {
        return this.outputs;
    }

    /**
     * Get the duration property: The duration of the last successful Deployment stack update.
     * 
     * @return the duration value.
     */
    public String duration() {
        return this.duration;
    }

    /**
     * Get the error property: The error detail.
     * 
     * @return the error value.
     */
    public ManagementError error() {
        return this.error;
    }

    /**
     * Set the error property: The error detail.
     * 
     * @param error the error value to set.
     * @return the DeploymentStackProperties object itself.
     */
    public DeploymentStackProperties withError(ManagementError error) {
        this.error = error;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (templateLink() != null) {
            templateLink().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
        if (parametersLink() != null) {
            parametersLink().validate();
        }
        if (actionOnUnmanage() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property actionOnUnmanage in model DeploymentStackProperties"));
        } else {
            actionOnUnmanage().validate();
        }
        if (debugSetting() != null) {
            debugSetting().validate();
        }
        if (denySettings() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property denySettings in model DeploymentStackProperties"));
        } else {
            denySettings().validate();
        }
        if (detachedResources() != null) {
            detachedResources().forEach(e -> e.validate());
        }
        if (deletedResources() != null) {
            deletedResources().forEach(e -> e.validate());
        }
        if (failedResources() != null) {
            failedResources().forEach(e -> e.validate());
        }
        if (resources() != null) {
            resources().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(DeploymentStackProperties.class);
}
