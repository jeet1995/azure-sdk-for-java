// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerorchestratorruntime.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The model for updating a storageClass.
 */
@Fluent
public final class StorageClassResourceUpdate implements JsonSerializable<StorageClassResourceUpdate> {
    /*
     * The properties of StorageClass
     */
    private StorageClassPropertiesUpdate properties;

    /**
     * Creates an instance of StorageClassResourceUpdate class.
     */
    public StorageClassResourceUpdate() {
    }

    /**
     * Get the properties property: The properties of StorageClass.
     * 
     * @return the properties value.
     */
    public StorageClassPropertiesUpdate properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The properties of StorageClass.
     * 
     * @param properties the properties value to set.
     * @return the StorageClassResourceUpdate object itself.
     */
    public StorageClassResourceUpdate withProperties(StorageClassPropertiesUpdate properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StorageClassResourceUpdate from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StorageClassResourceUpdate if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the StorageClassResourceUpdate.
     */
    public static StorageClassResourceUpdate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StorageClassResourceUpdate deserializedStorageClassResourceUpdate = new StorageClassResourceUpdate();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedStorageClassResourceUpdate.properties = StorageClassPropertiesUpdate.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStorageClassResourceUpdate;
        });
    }
}
