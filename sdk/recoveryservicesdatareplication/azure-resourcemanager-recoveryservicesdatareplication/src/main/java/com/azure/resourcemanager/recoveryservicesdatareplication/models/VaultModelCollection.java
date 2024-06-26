// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.recoveryservicesdatareplication.fluent.models.VaultModelInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Vault model collection. */
@Fluent
public final class VaultModelCollection {
    /*
     * Gets or sets the list of vaults.
     */
    @JsonProperty(value = "value")
    private List<VaultModelInner> value;

    /*
     * Gets or sets the value of next link.
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /** Creates an instance of VaultModelCollection class. */
    public VaultModelCollection() {
    }

    /**
     * Get the value property: Gets or sets the list of vaults.
     *
     * @return the value value.
     */
    public List<VaultModelInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Gets or sets the list of vaults.
     *
     * @param value the value value to set.
     * @return the VaultModelCollection object itself.
     */
    public VaultModelCollection withValue(List<VaultModelInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Gets or sets the value of next link.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Gets or sets the value of next link.
     *
     * @param nextLink the nextLink value to set.
     * @return the VaultModelCollection object itself.
     */
    public VaultModelCollection withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
