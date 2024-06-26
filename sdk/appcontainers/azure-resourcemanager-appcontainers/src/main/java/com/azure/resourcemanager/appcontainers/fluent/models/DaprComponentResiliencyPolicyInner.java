// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.resourcemanager.appcontainers.models.DaprComponentResiliencyPolicyConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dapr Component Resiliency Policy.
 */
@Fluent
public final class DaprComponentResiliencyPolicyInner extends ProxyResource {
    /*
     * Dapr Component Resiliency Policy resource specific properties
     */
    @JsonProperty(value = "properties")
    private DaprComponentResiliencyPolicyProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    @JsonProperty(value = "systemData", access = JsonProperty.Access.WRITE_ONLY)
    private SystemData systemData;

    /**
     * Creates an instance of DaprComponentResiliencyPolicyInner class.
     */
    public DaprComponentResiliencyPolicyInner() {
    }

    /**
     * Get the innerProperties property: Dapr Component Resiliency Policy resource specific properties.
     * 
     * @return the innerProperties value.
     */
    private DaprComponentResiliencyPolicyProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the inboundPolicy property: The optional inbound component resiliency policy configuration.
     * 
     * @return the inboundPolicy value.
     */
    public DaprComponentResiliencyPolicyConfiguration inboundPolicy() {
        return this.innerProperties() == null ? null : this.innerProperties().inboundPolicy();
    }

    /**
     * Set the inboundPolicy property: The optional inbound component resiliency policy configuration.
     * 
     * @param inboundPolicy the inboundPolicy value to set.
     * @return the DaprComponentResiliencyPolicyInner object itself.
     */
    public DaprComponentResiliencyPolicyInner
        withInboundPolicy(DaprComponentResiliencyPolicyConfiguration inboundPolicy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DaprComponentResiliencyPolicyProperties();
        }
        this.innerProperties().withInboundPolicy(inboundPolicy);
        return this;
    }

    /**
     * Get the outboundPolicy property: The optional outbound component resiliency policy configuration.
     * 
     * @return the outboundPolicy value.
     */
    public DaprComponentResiliencyPolicyConfiguration outboundPolicy() {
        return this.innerProperties() == null ? null : this.innerProperties().outboundPolicy();
    }

    /**
     * Set the outboundPolicy property: The optional outbound component resiliency policy configuration.
     * 
     * @param outboundPolicy the outboundPolicy value to set.
     * @return the DaprComponentResiliencyPolicyInner object itself.
     */
    public DaprComponentResiliencyPolicyInner
        withOutboundPolicy(DaprComponentResiliencyPolicyConfiguration outboundPolicy) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DaprComponentResiliencyPolicyProperties();
        }
        this.innerProperties().withOutboundPolicy(outboundPolicy);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
