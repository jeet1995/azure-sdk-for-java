// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.timeseriesinsights.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/** Properties of the environment. */
@Immutable
public class EnvironmentResourceProperties extends ResourceProperties {
    /*
     * An id used to access the environment data, e.g. to query the environment's events or upload reference data for
     * the environment.
     */
    @JsonProperty(value = "dataAccessId", access = JsonProperty.Access.WRITE_ONLY)
    private UUID dataAccessId;

    /*
     * The fully qualified domain name used to access the environment data, e.g. to query the environment's events or
     * upload reference data for the environment.
     */
    @JsonProperty(value = "dataAccessFqdn", access = JsonProperty.Access.WRITE_ONLY)
    private String dataAccessFqdn;

    /*
     * An object that represents the status of the environment, and its internal state in the Time Series Insights
     * service.
     */
    @JsonProperty(value = "status", access = JsonProperty.Access.WRITE_ONLY)
    private EnvironmentStatus status;

    /** Creates an instance of EnvironmentResourceProperties class. */
    public EnvironmentResourceProperties() {
    }

    /**
     * Get the dataAccessId property: An id used to access the environment data, e.g. to query the environment's events
     * or upload reference data for the environment.
     *
     * @return the dataAccessId value.
     */
    public UUID dataAccessId() {
        return this.dataAccessId;
    }

    /**
     * Get the dataAccessFqdn property: The fully qualified domain name used to access the environment data, e.g. to
     * query the environment's events or upload reference data for the environment.
     *
     * @return the dataAccessFqdn value.
     */
    public String dataAccessFqdn() {
        return this.dataAccessFqdn;
    }

    /**
     * Get the status property: An object that represents the status of the environment, and its internal state in the
     * Time Series Insights service.
     *
     * @return the status value.
     */
    public EnvironmentStatus status() {
        return this.status;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (status() != null) {
            status().validate();
        }
    }
}
