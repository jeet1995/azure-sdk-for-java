// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Outstanding conditions that will need to be resolved.
 */
@Immutable
public final class Condition implements JsonSerializable<Condition> {
    /*
     * The time when the condition was raised.
     */
    private OffsetDateTime timestamp;

    /*
     * The issue requiring attention.
     */
    private String message;

    /**
     * Creates an instance of Condition class.
     */
    public Condition() {
    }

    /**
     * Get the timestamp property: The time when the condition was raised.
     * 
     * @return the timestamp value.
     */
    public OffsetDateTime timestamp() {
        return this.timestamp;
    }

    /**
     * Get the message property: The issue requiring attention.
     * 
     * @return the message value.
     */
    public String message() {
        return this.message;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Condition from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Condition if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the Condition.
     */
    public static Condition fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Condition deserializedCondition = new Condition();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("timestamp".equals(fieldName)) {
                    deserializedCondition.timestamp = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("message".equals(fieldName)) {
                    deserializedCondition.message = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCondition;
        });
    }
}
