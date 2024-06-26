// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicebus.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.servicebus.fluent.models.RuleInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The response of the List rule operation. */
@Fluent
public final class RuleListResult {
    /*
     * Result of the List Rules operation.
     */
    @JsonProperty(value = "value")
    private List<RuleInner> value;

    /*
     * Link to the next set of results. Not empty if Value contains incomplete list of rules
     */
    @JsonProperty(value = "nextLink")
    private String nextLink;

    /**
     * Get the value property: Result of the List Rules operation.
     *
     * @return the value value.
     */
    public List<RuleInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Result of the List Rules operation.
     *
     * @param value the value value to set.
     * @return the RuleListResult object itself.
     */
    public RuleListResult withValue(List<RuleInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link to the next set of results. Not empty if Value contains incomplete list of rules.
     *
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link to the next set of results. Not empty if Value contains incomplete list of rules.
     *
     * @param nextLink the nextLink value to set.
     * @return the RuleListResult object itself.
     */
    public RuleListResult withNextLink(String nextLink) {
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
