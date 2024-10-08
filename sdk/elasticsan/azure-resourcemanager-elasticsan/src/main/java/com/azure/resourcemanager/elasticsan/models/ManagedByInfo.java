// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Parent resource information.
 */
@Fluent
public final class ManagedByInfo implements JsonSerializable<ManagedByInfo> {
    /*
     * Resource ID of the resource managing the volume, this is a restricted field and can only be set for internal use.
     */
    private String resourceId;

    /**
     * Creates an instance of ManagedByInfo class.
     */
    public ManagedByInfo() {
    }

    /**
     * Get the resourceId property: Resource ID of the resource managing the volume, this is a restricted field and can
     * only be set for internal use.
     * 
     * @return the resourceId value.
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Set the resourceId property: Resource ID of the resource managing the volume, this is a restricted field and can
     * only be set for internal use.
     * 
     * @param resourceId the resourceId value to set.
     * @return the ManagedByInfo object itself.
     */
    public ManagedByInfo withResourceId(String resourceId) {
        this.resourceId = resourceId;
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
        jsonWriter.writeStringField("resourceId", this.resourceId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagedByInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagedByInfo if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ManagedByInfo.
     */
    public static ManagedByInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagedByInfo deserializedManagedByInfo = new ManagedByInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resourceId".equals(fieldName)) {
                    deserializedManagedByInfo.resourceId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagedByInfo;
        });
    }
}
