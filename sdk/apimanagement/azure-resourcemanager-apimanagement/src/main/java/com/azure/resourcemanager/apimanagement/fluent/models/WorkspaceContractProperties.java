// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Workspace entity properties.
 */
@Fluent
public final class WorkspaceContractProperties implements JsonSerializable<WorkspaceContractProperties> {
    /*
     * Name of the workspace.
     */
    private String displayName;

    /*
     * Description of the workspace.
     */
    private String description;

    /**
     * Creates an instance of WorkspaceContractProperties class.
     */
    public WorkspaceContractProperties() {
    }

    /**
     * Get the displayName property: Name of the workspace.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Name of the workspace.
     * 
     * @param displayName the displayName value to set.
     * @return the WorkspaceContractProperties object itself.
     */
    public WorkspaceContractProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the description property: Description of the workspace.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Description of the workspace.
     * 
     * @param description the description value to set.
     * @return the WorkspaceContractProperties object itself.
     */
    public WorkspaceContractProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (displayName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property displayName in model WorkspaceContractProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(WorkspaceContractProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("description", this.description);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WorkspaceContractProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WorkspaceContractProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the WorkspaceContractProperties.
     */
    public static WorkspaceContractProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WorkspaceContractProperties deserializedWorkspaceContractProperties = new WorkspaceContractProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayName".equals(fieldName)) {
                    deserializedWorkspaceContractProperties.displayName = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedWorkspaceContractProperties.description = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWorkspaceContractProperties;
        });
    }
}
