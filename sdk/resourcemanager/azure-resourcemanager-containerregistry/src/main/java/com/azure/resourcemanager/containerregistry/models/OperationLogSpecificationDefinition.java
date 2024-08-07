// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerregistry.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The definition of Azure Monitoring log.
 */
@Fluent
public final class OperationLogSpecificationDefinition
    implements JsonSerializable<OperationLogSpecificationDefinition> {
    /*
     * Log name.
     */
    private String name;

    /*
     * Log display name.
     */
    private String displayName;

    /*
     * Log blob duration.
     */
    private String blobDuration;

    /**
     * Creates an instance of OperationLogSpecificationDefinition class.
     */
    public OperationLogSpecificationDefinition() {
    }

    /**
     * Get the name property: Log name.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Log name.
     * 
     * @param name the name value to set.
     * @return the OperationLogSpecificationDefinition object itself.
     */
    public OperationLogSpecificationDefinition withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the displayName property: Log display name.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Log display name.
     * 
     * @param displayName the displayName value to set.
     * @return the OperationLogSpecificationDefinition object itself.
     */
    public OperationLogSpecificationDefinition withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the blobDuration property: Log blob duration.
     * 
     * @return the blobDuration value.
     */
    public String blobDuration() {
        return this.blobDuration;
    }

    /**
     * Set the blobDuration property: Log blob duration.
     * 
     * @param blobDuration the blobDuration value to set.
     * @return the OperationLogSpecificationDefinition object itself.
     */
    public OperationLogSpecificationDefinition withBlobDuration(String blobDuration) {
        this.blobDuration = blobDuration;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("blobDuration", this.blobDuration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OperationLogSpecificationDefinition from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OperationLogSpecificationDefinition if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the OperationLogSpecificationDefinition.
     */
    public static OperationLogSpecificationDefinition fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OperationLogSpecificationDefinition deserializedOperationLogSpecificationDefinition
                = new OperationLogSpecificationDefinition();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedOperationLogSpecificationDefinition.name = reader.getString();
                } else if ("displayName".equals(fieldName)) {
                    deserializedOperationLogSpecificationDefinition.displayName = reader.getString();
                } else if ("blobDuration".equals(fieldName)) {
                    deserializedOperationLogSpecificationDefinition.blobDuration = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOperationLogSpecificationDefinition;
        });
    }
}
