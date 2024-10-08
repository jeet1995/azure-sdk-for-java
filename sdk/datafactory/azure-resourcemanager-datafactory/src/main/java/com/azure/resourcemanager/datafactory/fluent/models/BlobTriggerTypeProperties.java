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
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import java.io.IOException;

/**
 * Blob Trigger properties.
 */
@Fluent
public final class BlobTriggerTypeProperties implements JsonSerializable<BlobTriggerTypeProperties> {
    /*
     * The path of the container/folder that will trigger the pipeline.
     */
    private String folderPath;

    /*
     * The max number of parallel files to handle when it is triggered.
     */
    private int maxConcurrency;

    /*
     * The Azure Storage linked service reference.
     */
    private LinkedServiceReference linkedService;

    /**
     * Creates an instance of BlobTriggerTypeProperties class.
     */
    public BlobTriggerTypeProperties() {
    }

    /**
     * Get the folderPath property: The path of the container/folder that will trigger the pipeline.
     * 
     * @return the folderPath value.
     */
    public String folderPath() {
        return this.folderPath;
    }

    /**
     * Set the folderPath property: The path of the container/folder that will trigger the pipeline.
     * 
     * @param folderPath the folderPath value to set.
     * @return the BlobTriggerTypeProperties object itself.
     */
    public BlobTriggerTypeProperties withFolderPath(String folderPath) {
        this.folderPath = folderPath;
        return this;
    }

    /**
     * Get the maxConcurrency property: The max number of parallel files to handle when it is triggered.
     * 
     * @return the maxConcurrency value.
     */
    public int maxConcurrency() {
        return this.maxConcurrency;
    }

    /**
     * Set the maxConcurrency property: The max number of parallel files to handle when it is triggered.
     * 
     * @param maxConcurrency the maxConcurrency value to set.
     * @return the BlobTriggerTypeProperties object itself.
     */
    public BlobTriggerTypeProperties withMaxConcurrency(int maxConcurrency) {
        this.maxConcurrency = maxConcurrency;
        return this;
    }

    /**
     * Get the linkedService property: The Azure Storage linked service reference.
     * 
     * @return the linkedService value.
     */
    public LinkedServiceReference linkedService() {
        return this.linkedService;
    }

    /**
     * Set the linkedService property: The Azure Storage linked service reference.
     * 
     * @param linkedService the linkedService value to set.
     * @return the BlobTriggerTypeProperties object itself.
     */
    public BlobTriggerTypeProperties withLinkedService(LinkedServiceReference linkedService) {
        this.linkedService = linkedService;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (folderPath() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property folderPath in model BlobTriggerTypeProperties"));
        }
        if (linkedService() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property linkedService in model BlobTriggerTypeProperties"));
        } else {
            linkedService().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(BlobTriggerTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("folderPath", this.folderPath);
        jsonWriter.writeIntField("maxConcurrency", this.maxConcurrency);
        jsonWriter.writeJsonField("linkedService", this.linkedService);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BlobTriggerTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BlobTriggerTypeProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the BlobTriggerTypeProperties.
     */
    public static BlobTriggerTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BlobTriggerTypeProperties deserializedBlobTriggerTypeProperties = new BlobTriggerTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("folderPath".equals(fieldName)) {
                    deserializedBlobTriggerTypeProperties.folderPath = reader.getString();
                } else if ("maxConcurrency".equals(fieldName)) {
                    deserializedBlobTriggerTypeProperties.maxConcurrency = reader.getInt();
                } else if ("linkedService".equals(fieldName)) {
                    deserializedBlobTriggerTypeProperties.linkedService = LinkedServiceReference.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBlobTriggerTypeProperties;
        });
    }
}
