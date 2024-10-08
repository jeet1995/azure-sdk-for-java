// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Details about an operation related to logs.
 */
@Fluent
public final class OperationLogSpecification implements JsonSerializable<OperationLogSpecification> {
    /*
     * The name of the log category.
     */
    private String name;

    /*
     * Localized display name.
     */
    private String displayName;

    /*
     * Blobs created in the customer storage account, per hour.
     */
    private String blobDuration;

    /**
     * Creates an instance of OperationLogSpecification class.
     */
    public OperationLogSpecification() {
    }

    /**
     * Get the name property: The name of the log category.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the log category.
     * 
     * @param name the name value to set.
     * @return the OperationLogSpecification object itself.
     */
    public OperationLogSpecification withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the displayName property: Localized display name.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Localized display name.
     * 
     * @param displayName the displayName value to set.
     * @return the OperationLogSpecification object itself.
     */
    public OperationLogSpecification withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the blobDuration property: Blobs created in the customer storage account, per hour.
     * 
     * @return the blobDuration value.
     */
    public String blobDuration() {
        return this.blobDuration;
    }

    /**
     * Set the blobDuration property: Blobs created in the customer storage account, per hour.
     * 
     * @param blobDuration the blobDuration value to set.
     * @return the OperationLogSpecification object itself.
     */
    public OperationLogSpecification withBlobDuration(String blobDuration) {
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
     * Reads an instance of OperationLogSpecification from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OperationLogSpecification if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the OperationLogSpecification.
     */
    public static OperationLogSpecification fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OperationLogSpecification deserializedOperationLogSpecification = new OperationLogSpecification();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedOperationLogSpecification.name = reader.getString();
                } else if ("displayName".equals(fieldName)) {
                    deserializedOperationLogSpecification.displayName = reader.getString();
                } else if ("blobDuration".equals(fieldName)) {
                    deserializedOperationLogSpecification.blobDuration = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOperationLogSpecification;
        });
    }
}
