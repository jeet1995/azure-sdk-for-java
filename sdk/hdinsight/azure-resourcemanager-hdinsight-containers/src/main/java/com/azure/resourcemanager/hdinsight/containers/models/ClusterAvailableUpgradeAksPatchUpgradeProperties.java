// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hdinsight.containers.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Cluster available AKS patch version upgrade.
 */
@Fluent
public final class ClusterAvailableUpgradeAksPatchUpgradeProperties extends ClusterAvailableUpgradeProperties {
    /*
     * Type of upgrade.
     */
    private ClusterAvailableUpgradeType upgradeType = ClusterAvailableUpgradeType.AKSPATCH_UPGRADE;

    /*
     * Current node pool version.
     */
    private String currentVersion;

    /*
     * Current AKS version's status: whether it is deprecated or supported
     */
    private CurrentClusterAksVersionStatus currentVersionStatus;

    /*
     * Latest available version, which should be equal to AKS control plane version if it's not deprecated.
     */
    private String latestVersion;

    /**
     * Creates an instance of ClusterAvailableUpgradeAksPatchUpgradeProperties class.
     */
    public ClusterAvailableUpgradeAksPatchUpgradeProperties() {
    }

    /**
     * Get the upgradeType property: Type of upgrade.
     * 
     * @return the upgradeType value.
     */
    @Override
    public ClusterAvailableUpgradeType upgradeType() {
        return this.upgradeType;
    }

    /**
     * Get the currentVersion property: Current node pool version.
     * 
     * @return the currentVersion value.
     */
    public String currentVersion() {
        return this.currentVersion;
    }

    /**
     * Set the currentVersion property: Current node pool version.
     * 
     * @param currentVersion the currentVersion value to set.
     * @return the ClusterAvailableUpgradeAksPatchUpgradeProperties object itself.
     */
    public ClusterAvailableUpgradeAksPatchUpgradeProperties withCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
        return this;
    }

    /**
     * Get the currentVersionStatus property: Current AKS version's status: whether it is deprecated or supported.
     * 
     * @return the currentVersionStatus value.
     */
    public CurrentClusterAksVersionStatus currentVersionStatus() {
        return this.currentVersionStatus;
    }

    /**
     * Set the currentVersionStatus property: Current AKS version's status: whether it is deprecated or supported.
     * 
     * @param currentVersionStatus the currentVersionStatus value to set.
     * @return the ClusterAvailableUpgradeAksPatchUpgradeProperties object itself.
     */
    public ClusterAvailableUpgradeAksPatchUpgradeProperties
        withCurrentVersionStatus(CurrentClusterAksVersionStatus currentVersionStatus) {
        this.currentVersionStatus = currentVersionStatus;
        return this;
    }

    /**
     * Get the latestVersion property: Latest available version, which should be equal to AKS control plane version if
     * it's not deprecated.
     * 
     * @return the latestVersion value.
     */
    public String latestVersion() {
        return this.latestVersion;
    }

    /**
     * Set the latestVersion property: Latest available version, which should be equal to AKS control plane version if
     * it's not deprecated.
     * 
     * @param latestVersion the latestVersion value to set.
     * @return the ClusterAvailableUpgradeAksPatchUpgradeProperties object itself.
     */
    public ClusterAvailableUpgradeAksPatchUpgradeProperties withLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("upgradeType", this.upgradeType == null ? null : this.upgradeType.toString());
        jsonWriter.writeStringField("currentVersion", this.currentVersion);
        jsonWriter.writeStringField("currentVersionStatus",
            this.currentVersionStatus == null ? null : this.currentVersionStatus.toString());
        jsonWriter.writeStringField("latestVersion", this.latestVersion);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ClusterAvailableUpgradeAksPatchUpgradeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ClusterAvailableUpgradeAksPatchUpgradeProperties if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ClusterAvailableUpgradeAksPatchUpgradeProperties.
     */
    public static ClusterAvailableUpgradeAksPatchUpgradeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ClusterAvailableUpgradeAksPatchUpgradeProperties deserializedClusterAvailableUpgradeAksPatchUpgradeProperties
                = new ClusterAvailableUpgradeAksPatchUpgradeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("upgradeType".equals(fieldName)) {
                    deserializedClusterAvailableUpgradeAksPatchUpgradeProperties.upgradeType
                        = ClusterAvailableUpgradeType.fromString(reader.getString());
                } else if ("currentVersion".equals(fieldName)) {
                    deserializedClusterAvailableUpgradeAksPatchUpgradeProperties.currentVersion = reader.getString();
                } else if ("currentVersionStatus".equals(fieldName)) {
                    deserializedClusterAvailableUpgradeAksPatchUpgradeProperties.currentVersionStatus
                        = CurrentClusterAksVersionStatus.fromString(reader.getString());
                } else if ("latestVersion".equals(fieldName)) {
                    deserializedClusterAvailableUpgradeAksPatchUpgradeProperties.latestVersion = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedClusterAvailableUpgradeAksPatchUpgradeProperties;
        });
    }
}
