// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iothub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Input values.
 */
@Fluent
public final class OperationInputs implements JsonSerializable<OperationInputs> {
    /*
     * The name of the IoT hub to check.
     */
    private String name;

    /**
     * Creates an instance of OperationInputs class.
     */
    public OperationInputs() {
    }

    /**
     * Get the name property: The name of the IoT hub to check.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the IoT hub to check.
     * 
     * @param name the name value to set.
     * @return the OperationInputs object itself.
     */
    public OperationInputs withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model OperationInputs"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(OperationInputs.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OperationInputs from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OperationInputs if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the OperationInputs.
     */
    public static OperationInputs fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OperationInputs deserializedOperationInputs = new OperationInputs();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedOperationInputs.name = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOperationInputs;
        });
    }
}
