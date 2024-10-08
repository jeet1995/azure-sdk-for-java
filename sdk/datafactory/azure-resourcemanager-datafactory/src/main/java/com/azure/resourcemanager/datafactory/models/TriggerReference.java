// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Trigger reference type.
 */
@Fluent
public final class TriggerReference implements JsonSerializable<TriggerReference> {
    /*
     * Trigger reference type.
     */
    private TriggerReferenceType type;

    /*
     * Reference trigger name.
     */
    private String referenceName;

    /**
     * Creates an instance of TriggerReference class.
     */
    public TriggerReference() {
    }

    /**
     * Get the type property: Trigger reference type.
     * 
     * @return the type value.
     */
    public TriggerReferenceType type() {
        return this.type;
    }

    /**
     * Set the type property: Trigger reference type.
     * 
     * @param type the type value to set.
     * @return the TriggerReference object itself.
     */
    public TriggerReference withType(TriggerReferenceType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the referenceName property: Reference trigger name.
     * 
     * @return the referenceName value.
     */
    public String referenceName() {
        return this.referenceName;
    }

    /**
     * Set the referenceName property: Reference trigger name.
     * 
     * @param referenceName the referenceName value to set.
     * @return the TriggerReference object itself.
     */
    public TriggerReference withReferenceName(String referenceName) {
        this.referenceName = referenceName;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (type() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property type in model TriggerReference"));
        }
        if (referenceName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property referenceName in model TriggerReference"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(TriggerReference.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        jsonWriter.writeStringField("referenceName", this.referenceName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TriggerReference from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TriggerReference if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TriggerReference.
     */
    public static TriggerReference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TriggerReference deserializedTriggerReference = new TriggerReference();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedTriggerReference.type = TriggerReferenceType.fromString(reader.getString());
                } else if ("referenceName".equals(fieldName)) {
                    deserializedTriggerReference.referenceName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTriggerReference;
        });
    }
}
