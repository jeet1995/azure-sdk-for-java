// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Image reference information.
 */
@Fluent
public final class ImageReference implements JsonSerializable<ImageReference> {
    /*
     * Image ID, or Image version ID. When Image ID is provided, its latest version will be used.
     */
    private String id;

    /*
     * The actual version of the image after use. When id references a gallery image latest version, this will indicate
     * the actual version in use.
     */
    private String exactVersion;

    /**
     * Creates an instance of ImageReference class.
     */
    public ImageReference() {
    }

    /**
     * Get the id property: Image ID, or Image version ID. When Image ID is provided, its latest version will be used.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Image ID, or Image version ID. When Image ID is provided, its latest version will be used.
     * 
     * @param id the id value to set.
     * @return the ImageReference object itself.
     */
    public ImageReference withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the exactVersion property: The actual version of the image after use. When id references a gallery image
     * latest version, this will indicate the actual version in use.
     * 
     * @return the exactVersion value.
     */
    public String exactVersion() {
        return this.exactVersion;
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
        jsonWriter.writeStringField("id", this.id);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ImageReference from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ImageReference if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ImageReference.
     */
    public static ImageReference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ImageReference deserializedImageReference = new ImageReference();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedImageReference.id = reader.getString();
                } else if ("exactVersion".equals(fieldName)) {
                    deserializedImageReference.exactVersion = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedImageReference;
        });
    }
}
