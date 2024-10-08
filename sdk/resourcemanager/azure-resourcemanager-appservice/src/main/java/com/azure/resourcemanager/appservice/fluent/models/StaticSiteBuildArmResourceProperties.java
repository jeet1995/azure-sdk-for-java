// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appservice.models.BuildStatus;
import com.azure.resourcemanager.appservice.models.DatabaseConnectionOverview;
import com.azure.resourcemanager.appservice.models.StaticSiteLinkedBackend;
import com.azure.resourcemanager.appservice.models.StaticSiteUserProvidedFunctionApp;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * StaticSiteBuildARMResource resource specific properties.
 */
@Immutable
public final class StaticSiteBuildArmResourceProperties
    implements JsonSerializable<StaticSiteBuildArmResourceProperties> {
    /*
     * An identifier for the static site build.
     */
    private String buildId;

    /*
     * The source branch.
     */
    private String sourceBranch;

    /*
     * The title of a pull request that a static site build is related to.
     */
    private String pullRequestTitle;

    /*
     * The hostname for a static site build.
     */
    private String hostname;

    /*
     * When this build was created.
     */
    private OffsetDateTime createdTimeUtc;

    /*
     * When this build was updated.
     */
    private OffsetDateTime lastUpdatedOn;

    /*
     * The status of the static site build.
     */
    private BuildStatus status;

    /*
     * User provided function apps registered with the static site build
     */
    private List<StaticSiteUserProvidedFunctionApp> userProvidedFunctionApps;

    /*
     * Backends linked to the static side build
     */
    private List<StaticSiteLinkedBackend> linkedBackends;

    /*
     * Database connections for the static site build
     */
    private List<DatabaseConnectionOverview> databaseConnections;

    /**
     * Creates an instance of StaticSiteBuildArmResourceProperties class.
     */
    public StaticSiteBuildArmResourceProperties() {
    }

    /**
     * Get the buildId property: An identifier for the static site build.
     * 
     * @return the buildId value.
     */
    public String buildId() {
        return this.buildId;
    }

    /**
     * Get the sourceBranch property: The source branch.
     * 
     * @return the sourceBranch value.
     */
    public String sourceBranch() {
        return this.sourceBranch;
    }

    /**
     * Get the pullRequestTitle property: The title of a pull request that a static site build is related to.
     * 
     * @return the pullRequestTitle value.
     */
    public String pullRequestTitle() {
        return this.pullRequestTitle;
    }

    /**
     * Get the hostname property: The hostname for a static site build.
     * 
     * @return the hostname value.
     */
    public String hostname() {
        return this.hostname;
    }

    /**
     * Get the createdTimeUtc property: When this build was created.
     * 
     * @return the createdTimeUtc value.
     */
    public OffsetDateTime createdTimeUtc() {
        return this.createdTimeUtc;
    }

    /**
     * Get the lastUpdatedOn property: When this build was updated.
     * 
     * @return the lastUpdatedOn value.
     */
    public OffsetDateTime lastUpdatedOn() {
        return this.lastUpdatedOn;
    }

    /**
     * Get the status property: The status of the static site build.
     * 
     * @return the status value.
     */
    public BuildStatus status() {
        return this.status;
    }

    /**
     * Get the userProvidedFunctionApps property: User provided function apps registered with the static site build.
     * 
     * @return the userProvidedFunctionApps value.
     */
    public List<StaticSiteUserProvidedFunctionApp> userProvidedFunctionApps() {
        return this.userProvidedFunctionApps;
    }

    /**
     * Get the linkedBackends property: Backends linked to the static side build.
     * 
     * @return the linkedBackends value.
     */
    public List<StaticSiteLinkedBackend> linkedBackends() {
        return this.linkedBackends;
    }

    /**
     * Get the databaseConnections property: Database connections for the static site build.
     * 
     * @return the databaseConnections value.
     */
    public List<DatabaseConnectionOverview> databaseConnections() {
        return this.databaseConnections;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (userProvidedFunctionApps() != null) {
            userProvidedFunctionApps().forEach(e -> e.validate());
        }
        if (linkedBackends() != null) {
            linkedBackends().forEach(e -> e.validate());
        }
        if (databaseConnections() != null) {
            databaseConnections().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StaticSiteBuildArmResourceProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StaticSiteBuildArmResourceProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the StaticSiteBuildArmResourceProperties.
     */
    public static StaticSiteBuildArmResourceProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StaticSiteBuildArmResourceProperties deserializedStaticSiteBuildArmResourceProperties
                = new StaticSiteBuildArmResourceProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("buildId".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.buildId = reader.getString();
                } else if ("sourceBranch".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.sourceBranch = reader.getString();
                } else if ("pullRequestTitle".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.pullRequestTitle = reader.getString();
                } else if ("hostname".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.hostname = reader.getString();
                } else if ("createdTimeUtc".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.createdTimeUtc = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("lastUpdatedOn".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.lastUpdatedOn = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("status".equals(fieldName)) {
                    deserializedStaticSiteBuildArmResourceProperties.status
                        = BuildStatus.fromString(reader.getString());
                } else if ("userProvidedFunctionApps".equals(fieldName)) {
                    List<StaticSiteUserProvidedFunctionApp> userProvidedFunctionApps
                        = reader.readArray(reader1 -> StaticSiteUserProvidedFunctionApp.fromJson(reader1));
                    deserializedStaticSiteBuildArmResourceProperties.userProvidedFunctionApps
                        = userProvidedFunctionApps;
                } else if ("linkedBackends".equals(fieldName)) {
                    List<StaticSiteLinkedBackend> linkedBackends
                        = reader.readArray(reader1 -> StaticSiteLinkedBackend.fromJson(reader1));
                    deserializedStaticSiteBuildArmResourceProperties.linkedBackends = linkedBackends;
                } else if ("databaseConnections".equals(fieldName)) {
                    List<DatabaseConnectionOverview> databaseConnections
                        = reader.readArray(reader1 -> DatabaseConnectionOverview.fromJson(reader1));
                    deserializedStaticSiteBuildArmResourceProperties.databaseConnections = databaseConnections;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStaticSiteBuildArmResourceProperties;
        });
    }
}
