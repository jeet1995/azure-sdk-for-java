// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Switch configuration entries require a description to discern between configuration groups.
 */
@Fluent
public class AnnotationResource implements JsonSerializable<AnnotationResource> {
    /*
     * Switch configuration description.
     */
    private String annotation;

    /**
     * Creates an instance of AnnotationResource class.
     */
    public AnnotationResource() {
    }

    /**
     * Get the annotation property: Switch configuration description.
     * 
     * @return the annotation value.
     */
    public String annotation() {
        return this.annotation;
    }

    /**
     * Set the annotation property: Switch configuration description.
     * 
     * @param annotation the annotation value to set.
     * @return the AnnotationResource object itself.
     */
    public AnnotationResource withAnnotation(String annotation) {
        this.annotation = annotation;
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
        jsonWriter.writeStringField("annotation", this.annotation);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AnnotationResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AnnotationResource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AnnotationResource.
     */
    public static AnnotationResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AnnotationResource deserializedAnnotationResource = new AnnotationResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("annotation".equals(fieldName)) {
                    deserializedAnnotationResource.annotation = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAnnotationResource;
        });
    }
}
