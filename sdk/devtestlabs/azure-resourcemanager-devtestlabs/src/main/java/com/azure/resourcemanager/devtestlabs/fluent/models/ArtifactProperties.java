// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.fluent.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Properties of an artifact. */
@Immutable
public final class ArtifactProperties {
    /*
     * The artifact's title.
     */
    @JsonProperty(value = "title", access = JsonProperty.Access.WRITE_ONLY)
    private String title;

    /*
     * The artifact's description.
     */
    @JsonProperty(value = "description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /*
     * The artifact's publisher.
     */
    @JsonProperty(value = "publisher", access = JsonProperty.Access.WRITE_ONLY)
    private String publisher;

    /*
     * The file path to the artifact.
     */
    @JsonProperty(value = "filePath", access = JsonProperty.Access.WRITE_ONLY)
    private String filePath;

    /*
     * The URI to the artifact icon.
     */
    @JsonProperty(value = "icon", access = JsonProperty.Access.WRITE_ONLY)
    private String icon;

    /*
     * The artifact's target OS.
     */
    @JsonProperty(value = "targetOsType", access = JsonProperty.Access.WRITE_ONLY)
    private String targetOsType;

    /*
     * The artifact's parameters.
     */
    @JsonProperty(value = "parameters", access = JsonProperty.Access.WRITE_ONLY)
    private Object parameters;

    /*
     * The artifact's creation date.
     */
    @JsonProperty(value = "createdDate", access = JsonProperty.Access.WRITE_ONLY)
    private OffsetDateTime createdDate;

    /** Creates an instance of ArtifactProperties class. */
    public ArtifactProperties() {
    }

    /**
     * Get the title property: The artifact's title.
     *
     * @return the title value.
     */
    public String title() {
        return this.title;
    }

    /**
     * Get the description property: The artifact's description.
     *
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Get the publisher property: The artifact's publisher.
     *
     * @return the publisher value.
     */
    public String publisher() {
        return this.publisher;
    }

    /**
     * Get the filePath property: The file path to the artifact.
     *
     * @return the filePath value.
     */
    public String filePath() {
        return this.filePath;
    }

    /**
     * Get the icon property: The URI to the artifact icon.
     *
     * @return the icon value.
     */
    public String icon() {
        return this.icon;
    }

    /**
     * Get the targetOsType property: The artifact's target OS.
     *
     * @return the targetOsType value.
     */
    public String targetOsType() {
        return this.targetOsType;
    }

    /**
     * Get the parameters property: The artifact's parameters.
     *
     * @return the parameters value.
     */
    public Object parameters() {
        return this.parameters;
    }

    /**
     * Get the createdDate property: The artifact's creation date.
     *
     * @return the createdDate value.
     */
    public OffsetDateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
