// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.storagediscovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Storage Discovery Workspace Properties.
 */
@Fluent
public final class StorageDiscoveryWorkspaceProperties
    implements JsonSerializable<StorageDiscoveryWorkspaceProperties> {
    /*
     * The storage discovery sku
     */
    private StorageDiscoverySku sku;

    /*
     * The description of the storage discovery workspace
     */
    private String description;

    /*
     * The view level storage discovery data estate
     */
    private List<String> workspaceRoots;

    /*
     * The scopes of the storage discovery workspace.
     */
    private List<StorageDiscoveryScope> scopes;

    /*
     * The status of the last operation.
     */
    private ResourceProvisioningState provisioningState;

    /**
     * Creates an instance of StorageDiscoveryWorkspaceProperties class.
     */
    public StorageDiscoveryWorkspaceProperties() {
    }

    /**
     * Get the sku property: The storage discovery sku.
     * 
     * @return the sku value.
     */
    public StorageDiscoverySku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The storage discovery sku.
     * 
     * @param sku the sku value to set.
     * @return the StorageDiscoveryWorkspaceProperties object itself.
     */
    public StorageDiscoveryWorkspaceProperties withSku(StorageDiscoverySku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the description property: The description of the storage discovery workspace.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The description of the storage discovery workspace.
     * 
     * @param description the description value to set.
     * @return the StorageDiscoveryWorkspaceProperties object itself.
     */
    public StorageDiscoveryWorkspaceProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the workspaceRoots property: The view level storage discovery data estate.
     * 
     * @return the workspaceRoots value.
     */
    public List<String> workspaceRoots() {
        return this.workspaceRoots;
    }

    /**
     * Set the workspaceRoots property: The view level storage discovery data estate.
     * 
     * @param workspaceRoots the workspaceRoots value to set.
     * @return the StorageDiscoveryWorkspaceProperties object itself.
     */
    public StorageDiscoveryWorkspaceProperties withWorkspaceRoots(List<String> workspaceRoots) {
        this.workspaceRoots = workspaceRoots;
        return this;
    }

    /**
     * Get the scopes property: The scopes of the storage discovery workspace.
     * 
     * @return the scopes value.
     */
    public List<StorageDiscoveryScope> scopes() {
        return this.scopes;
    }

    /**
     * Set the scopes property: The scopes of the storage discovery workspace.
     * 
     * @param scopes the scopes value to set.
     * @return the StorageDiscoveryWorkspaceProperties object itself.
     */
    public StorageDiscoveryWorkspaceProperties withScopes(List<StorageDiscoveryScope> scopes) {
        this.scopes = scopes;
        return this;
    }

    /**
     * Get the provisioningState property: The status of the last operation.
     * 
     * @return the provisioningState value.
     */
    public ResourceProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (workspaceRoots() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property workspaceRoots in model StorageDiscoveryWorkspaceProperties"));
        }
        if (scopes() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property scopes in model StorageDiscoveryWorkspaceProperties"));
        } else {
            scopes().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(StorageDiscoveryWorkspaceProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("workspaceRoots", this.workspaceRoots,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("scopes", this.scopes, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("sku", this.sku == null ? null : this.sku.toString());
        jsonWriter.writeStringField("description", this.description);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StorageDiscoveryWorkspaceProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StorageDiscoveryWorkspaceProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the StorageDiscoveryWorkspaceProperties.
     */
    public static StorageDiscoveryWorkspaceProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StorageDiscoveryWorkspaceProperties deserializedStorageDiscoveryWorkspaceProperties
                = new StorageDiscoveryWorkspaceProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("workspaceRoots".equals(fieldName)) {
                    List<String> workspaceRoots = reader.readArray(reader1 -> reader1.getString());
                    deserializedStorageDiscoveryWorkspaceProperties.workspaceRoots = workspaceRoots;
                } else if ("scopes".equals(fieldName)) {
                    List<StorageDiscoveryScope> scopes
                        = reader.readArray(reader1 -> StorageDiscoveryScope.fromJson(reader1));
                    deserializedStorageDiscoveryWorkspaceProperties.scopes = scopes;
                } else if ("sku".equals(fieldName)) {
                    deserializedStorageDiscoveryWorkspaceProperties.sku
                        = StorageDiscoverySku.fromString(reader.getString());
                } else if ("description".equals(fieldName)) {
                    deserializedStorageDiscoveryWorkspaceProperties.description = reader.getString();
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedStorageDiscoveryWorkspaceProperties.provisioningState
                        = ResourceProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStorageDiscoveryWorkspaceProperties;
        });
    }
}
