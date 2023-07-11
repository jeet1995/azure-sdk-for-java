// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Response for the LTR pre-backup API call. */
@Fluent
public final class LtrPreBackupResponseInner {
    /*
     * Additional Properties for the pre backup response
     */
    @JsonProperty(value = "properties", required = true)
    private LtrPreBackupResponseProperties innerProperties = new LtrPreBackupResponseProperties();

    /** Creates an instance of LtrPreBackupResponseInner class. */
    public LtrPreBackupResponseInner() {
    }

    /**
     * Get the innerProperties property: Additional Properties for the pre backup response.
     *
     * @return the innerProperties value.
     */
    private LtrPreBackupResponseProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the numberOfContainers property: Number of storage containers the plugin will use during backup. More than
     * one containers may be used for size limitations, parallelism, or redundancy etc.
     *
     * @return the numberOfContainers value.
     */
    public int numberOfContainers() {
        return this.innerProperties() == null ? 0 : this.innerProperties().numberOfContainers();
    }

    /**
     * Set the numberOfContainers property: Number of storage containers the plugin will use during backup. More than
     * one containers may be used for size limitations, parallelism, or redundancy etc.
     *
     * @param numberOfContainers the numberOfContainers value to set.
     * @return the LtrPreBackupResponseInner object itself.
     */
    public LtrPreBackupResponseInner withNumberOfContainers(int numberOfContainers) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LtrPreBackupResponseProperties();
        }
        this.innerProperties().withNumberOfContainers(numberOfContainers);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property innerProperties in model LtrPreBackupResponseInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(LtrPreBackupResponseInner.class);
}