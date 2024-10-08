// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Azure Table dataset properties.
 */
@Fluent
public final class AzureTableDatasetTypeProperties implements JsonSerializable<AzureTableDatasetTypeProperties> {
    /*
     * The table name of the Azure Table storage. Type: string (or Expression with resultType string).
     */
    private Object tableName;

    /**
     * Creates an instance of AzureTableDatasetTypeProperties class.
     */
    public AzureTableDatasetTypeProperties() {
    }

    /**
     * Get the tableName property: The table name of the Azure Table storage. Type: string (or Expression with
     * resultType string).
     * 
     * @return the tableName value.
     */
    public Object tableName() {
        return this.tableName;
    }

    /**
     * Set the tableName property: The table name of the Azure Table storage. Type: string (or Expression with
     * resultType string).
     * 
     * @param tableName the tableName value to set.
     * @return the AzureTableDatasetTypeProperties object itself.
     */
    public AzureTableDatasetTypeProperties withTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (tableName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property tableName in model AzureTableDatasetTypeProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(AzureTableDatasetTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("tableName", this.tableName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AzureTableDatasetTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AzureTableDatasetTypeProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AzureTableDatasetTypeProperties.
     */
    public static AzureTableDatasetTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AzureTableDatasetTypeProperties deserializedAzureTableDatasetTypeProperties
                = new AzureTableDatasetTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("tableName".equals(fieldName)) {
                    deserializedAzureTableDatasetTypeProperties.tableName = reader.readUntyped();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAzureTableDatasetTypeProperties;
        });
    }
}
