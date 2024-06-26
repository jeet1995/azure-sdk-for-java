// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservices.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Soft delete Settings of vault.
 */
@Fluent
public final class SoftDeleteSettings {
    /*
     * The softDeleteState property.
     */
    @JsonProperty(value = "softDeleteState")
    private SoftDeleteState softDeleteState;

    /*
     * Soft delete retention period in days
     */
    @JsonProperty(value = "softDeleteRetentionPeriodInDays")
    private Integer softDeleteRetentionPeriodInDays;

    /*
     * The enhancedSecurityState property.
     */
    @JsonProperty(value = "enhancedSecurityState")
    private EnhancedSecurityState enhancedSecurityState;

    /**
     * Creates an instance of SoftDeleteSettings class.
     */
    public SoftDeleteSettings() {
    }

    /**
     * Get the softDeleteState property: The softDeleteState property.
     * 
     * @return the softDeleteState value.
     */
    public SoftDeleteState softDeleteState() {
        return this.softDeleteState;
    }

    /**
     * Set the softDeleteState property: The softDeleteState property.
     * 
     * @param softDeleteState the softDeleteState value to set.
     * @return the SoftDeleteSettings object itself.
     */
    public SoftDeleteSettings withSoftDeleteState(SoftDeleteState softDeleteState) {
        this.softDeleteState = softDeleteState;
        return this;
    }

    /**
     * Get the softDeleteRetentionPeriodInDays property: Soft delete retention period in days.
     * 
     * @return the softDeleteRetentionPeriodInDays value.
     */
    public Integer softDeleteRetentionPeriodInDays() {
        return this.softDeleteRetentionPeriodInDays;
    }

    /**
     * Set the softDeleteRetentionPeriodInDays property: Soft delete retention period in days.
     * 
     * @param softDeleteRetentionPeriodInDays the softDeleteRetentionPeriodInDays value to set.
     * @return the SoftDeleteSettings object itself.
     */
    public SoftDeleteSettings withSoftDeleteRetentionPeriodInDays(Integer softDeleteRetentionPeriodInDays) {
        this.softDeleteRetentionPeriodInDays = softDeleteRetentionPeriodInDays;
        return this;
    }

    /**
     * Get the enhancedSecurityState property: The enhancedSecurityState property.
     * 
     * @return the enhancedSecurityState value.
     */
    public EnhancedSecurityState enhancedSecurityState() {
        return this.enhancedSecurityState;
    }

    /**
     * Set the enhancedSecurityState property: The enhancedSecurityState property.
     * 
     * @param enhancedSecurityState the enhancedSecurityState value to set.
     * @return the SoftDeleteSettings object itself.
     */
    public SoftDeleteSettings withEnhancedSecurityState(EnhancedSecurityState enhancedSecurityState) {
        this.enhancedSecurityState = enhancedSecurityState;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
