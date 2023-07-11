// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managementgroups.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A path element of a management group ancestors. */
@Fluent
public final class ManagementGroupPathElement {
    /*
     * The name of the group.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * The friendly name of the group.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /** Creates an instance of ManagementGroupPathElement class. */
    public ManagementGroupPathElement() {
    }

    /**
     * Get the name property: The name of the group.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the group.
     *
     * @param name the name value to set.
     * @return the ManagementGroupPathElement object itself.
     */
    public ManagementGroupPathElement withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the displayName property: The friendly name of the group.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The friendly name of the group.
     *
     * @param displayName the displayName value to set.
     * @return the ManagementGroupPathElement object itself.
     */
    public ManagementGroupPathElement withDisplayName(String displayName) {
        this.displayName = displayName;
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