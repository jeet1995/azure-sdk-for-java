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
 * Properties of in-place upgrading cluster.
 */
@Fluent
public class ClusterInPlaceUpgradeProperties extends ClusterUpgradeProperties {
    /*
     * Type of upgrade.
     */
    private ClusterUpgradeType upgradeType = ClusterUpgradeType.fromString("ClusterInPlaceUpgradeProperties");

    /*
     * Target OSS version of component to be upgraded.
     */
    private String targetOssVersion;

    /*
     * Target cluster version of component to be upgraded.
     */
    private String targetClusterVersion;

    /*
     * Target build number of component to be upgraded.
     */
    private String targetBuildNumber;

    /*
     * Name of component to be upgraded.
     */
    private String componentName;

    /**
     * Creates an instance of ClusterInPlaceUpgradeProperties class.
     */
    public ClusterInPlaceUpgradeProperties() {
    }

    /**
     * Get the upgradeType property: Type of upgrade.
     * 
     * @return the upgradeType value.
     */
    @Override
    public ClusterUpgradeType upgradeType() {
        return this.upgradeType;
    }

    /**
     * Get the targetOssVersion property: Target OSS version of component to be upgraded.
     * 
     * @return the targetOssVersion value.
     */
    public String targetOssVersion() {
        return this.targetOssVersion;
    }

    /**
     * Set the targetOssVersion property: Target OSS version of component to be upgraded.
     * 
     * @param targetOssVersion the targetOssVersion value to set.
     * @return the ClusterInPlaceUpgradeProperties object itself.
     */
    public ClusterInPlaceUpgradeProperties withTargetOssVersion(String targetOssVersion) {
        this.targetOssVersion = targetOssVersion;
        return this;
    }

    /**
     * Get the targetClusterVersion property: Target cluster version of component to be upgraded.
     * 
     * @return the targetClusterVersion value.
     */
    public String targetClusterVersion() {
        return this.targetClusterVersion;
    }

    /**
     * Set the targetClusterVersion property: Target cluster version of component to be upgraded.
     * 
     * @param targetClusterVersion the targetClusterVersion value to set.
     * @return the ClusterInPlaceUpgradeProperties object itself.
     */
    public ClusterInPlaceUpgradeProperties withTargetClusterVersion(String targetClusterVersion) {
        this.targetClusterVersion = targetClusterVersion;
        return this;
    }

    /**
     * Get the targetBuildNumber property: Target build number of component to be upgraded.
     * 
     * @return the targetBuildNumber value.
     */
    public String targetBuildNumber() {
        return this.targetBuildNumber;
    }

    /**
     * Set the targetBuildNumber property: Target build number of component to be upgraded.
     * 
     * @param targetBuildNumber the targetBuildNumber value to set.
     * @return the ClusterInPlaceUpgradeProperties object itself.
     */
    public ClusterInPlaceUpgradeProperties withTargetBuildNumber(String targetBuildNumber) {
        this.targetBuildNumber = targetBuildNumber;
        return this;
    }

    /**
     * Get the componentName property: Name of component to be upgraded.
     * 
     * @return the componentName value.
     */
    public String componentName() {
        return this.componentName;
    }

    /**
     * Set the componentName property: Name of component to be upgraded.
     * 
     * @param componentName the componentName value to set.
     * @return the ClusterInPlaceUpgradeProperties object itself.
     */
    public ClusterInPlaceUpgradeProperties withComponentName(String componentName) {
        this.componentName = componentName;
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
        jsonWriter.writeStringField("targetOssVersion", this.targetOssVersion);
        jsonWriter.writeStringField("targetClusterVersion", this.targetClusterVersion);
        jsonWriter.writeStringField("targetBuildNumber", this.targetBuildNumber);
        jsonWriter.writeStringField("componentName", this.componentName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ClusterInPlaceUpgradeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ClusterInPlaceUpgradeProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ClusterInPlaceUpgradeProperties.
     */
    public static ClusterInPlaceUpgradeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("upgradeType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("HotfixUpgrade".equals(discriminatorValue)) {
                    return ClusterHotfixUpgradeProperties.fromJson(readerToUse.reset());
                } else if ("PatchVersionUpgrade".equals(discriminatorValue)) {
                    return ClusterPatchVersionUpgradeProperties.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static ClusterInPlaceUpgradeProperties fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ClusterInPlaceUpgradeProperties deserializedClusterInPlaceUpgradeProperties
                = new ClusterInPlaceUpgradeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("upgradeType".equals(fieldName)) {
                    deserializedClusterInPlaceUpgradeProperties.upgradeType
                        = ClusterUpgradeType.fromString(reader.getString());
                } else if ("targetOssVersion".equals(fieldName)) {
                    deserializedClusterInPlaceUpgradeProperties.targetOssVersion = reader.getString();
                } else if ("targetClusterVersion".equals(fieldName)) {
                    deserializedClusterInPlaceUpgradeProperties.targetClusterVersion = reader.getString();
                } else if ("targetBuildNumber".equals(fieldName)) {
                    deserializedClusterInPlaceUpgradeProperties.targetBuildNumber = reader.getString();
                } else if ("componentName".equals(fieldName)) {
                    deserializedClusterInPlaceUpgradeProperties.componentName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedClusterInPlaceUpgradeProperties;
        });
    }
}
