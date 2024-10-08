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
import com.azure.resourcemanager.datafactory.models.DatasetCompression;
import com.azure.resourcemanager.datafactory.models.DatasetLocation;
import java.io.IOException;

/**
 * Binary dataset properties.
 */
@Fluent
public final class BinaryDatasetTypeProperties implements JsonSerializable<BinaryDatasetTypeProperties> {
    /*
     * The location of the Binary storage.
     */
    private DatasetLocation location;

    /*
     * The data compression method used for the binary dataset.
     */
    private DatasetCompression compression;

    /**
     * Creates an instance of BinaryDatasetTypeProperties class.
     */
    public BinaryDatasetTypeProperties() {
    }

    /**
     * Get the location property: The location of the Binary storage.
     * 
     * @return the location value.
     */
    public DatasetLocation location() {
        return this.location;
    }

    /**
     * Set the location property: The location of the Binary storage.
     * 
     * @param location the location value to set.
     * @return the BinaryDatasetTypeProperties object itself.
     */
    public BinaryDatasetTypeProperties withLocation(DatasetLocation location) {
        this.location = location;
        return this;
    }

    /**
     * Get the compression property: The data compression method used for the binary dataset.
     * 
     * @return the compression value.
     */
    public DatasetCompression compression() {
        return this.compression;
    }

    /**
     * Set the compression property: The data compression method used for the binary dataset.
     * 
     * @param compression the compression value to set.
     * @return the BinaryDatasetTypeProperties object itself.
     */
    public BinaryDatasetTypeProperties withCompression(DatasetCompression compression) {
        this.compression = compression;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (location() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property location in model BinaryDatasetTypeProperties"));
        } else {
            location().validate();
        }
        if (compression() != null) {
            compression().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(BinaryDatasetTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("location", this.location);
        jsonWriter.writeJsonField("compression", this.compression);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BinaryDatasetTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BinaryDatasetTypeProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the BinaryDatasetTypeProperties.
     */
    public static BinaryDatasetTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BinaryDatasetTypeProperties deserializedBinaryDatasetTypeProperties = new BinaryDatasetTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("location".equals(fieldName)) {
                    deserializedBinaryDatasetTypeProperties.location = DatasetLocation.fromJson(reader);
                } else if ("compression".equals(fieldName)) {
                    deserializedBinaryDatasetTypeProperties.compression = DatasetCompression.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBinaryDatasetTypeProperties;
        });
    }
}
