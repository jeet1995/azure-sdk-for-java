// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The ListQueue model.
 */
@Fluent
public final class ListQueueInner extends ProxyResource {
    /*
     * List Queue resource properties.
     */
    private ListQueueProperties innerQueueProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of ListQueueInner class.
     */
    public ListQueueInner() {
    }

    /**
     * Get the innerQueueProperties property: List Queue resource properties.
     * 
     * @return the innerQueueProperties value.
     */
    private ListQueueProperties innerQueueProperties() {
        return this.innerQueueProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the metadata property: A name-value pair that represents queue metadata.
     * 
     * @return the metadata value.
     */
    public Map<String, String> metadata() {
        return this.innerQueueProperties() == null ? null : this.innerQueueProperties().metadata();
    }

    /**
     * Set the metadata property: A name-value pair that represents queue metadata.
     * 
     * @param metadata the metadata value to set.
     * @return the ListQueueInner object itself.
     */
    public ListQueueInner withMetadata(Map<String, String> metadata) {
        if (this.innerQueueProperties() == null) {
            this.innerQueueProperties = new ListQueueProperties();
        }
        this.innerQueueProperties().withMetadata(metadata);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerQueueProperties() != null) {
            innerQueueProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerQueueProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ListQueueInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ListQueueInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ListQueueInner.
     */
    public static ListQueueInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ListQueueInner deserializedListQueueInner = new ListQueueInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedListQueueInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedListQueueInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedListQueueInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedListQueueInner.innerQueueProperties = ListQueueProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedListQueueInner;
        });
    }
}
