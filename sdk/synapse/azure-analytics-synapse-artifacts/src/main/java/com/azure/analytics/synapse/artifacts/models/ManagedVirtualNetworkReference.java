// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Managed Virtual Network reference type.
 */
@Fluent
public final class ManagedVirtualNetworkReference implements JsonSerializable<ManagedVirtualNetworkReference> {
    /*
     * Managed Virtual Network reference type.
     */
    @Generated
    private final String type = "ManagedVirtualNetworkReference";

    /*
     * Reference ManagedVirtualNetwork name.
     */
    @Generated
    private String referenceName;

    /**
     * Creates an instance of ManagedVirtualNetworkReference class.
     */
    @Generated
    public ManagedVirtualNetworkReference() {
    }

    /**
     * Get the type property: Managed Virtual Network reference type.
     * 
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    /**
     * Get the referenceName property: Reference ManagedVirtualNetwork name.
     * 
     * @return the referenceName value.
     */
    @Generated
    public String getReferenceName() {
        return this.referenceName;
    }

    /**
     * Set the referenceName property: Reference ManagedVirtualNetwork name.
     * 
     * @param referenceName the referenceName value to set.
     * @return the ManagedVirtualNetworkReference object itself.
     */
    @Generated
    public ManagedVirtualNetworkReference setReferenceName(String referenceName) {
        this.referenceName = referenceName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeStringField("referenceName", this.referenceName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagedVirtualNetworkReference from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagedVirtualNetworkReference if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ManagedVirtualNetworkReference.
     */
    @Generated
    public static ManagedVirtualNetworkReference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagedVirtualNetworkReference deserializedManagedVirtualNetworkReference
                = new ManagedVirtualNetworkReference();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("referenceName".equals(fieldName)) {
                    deserializedManagedVirtualNetworkReference.referenceName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagedVirtualNetworkReference;
        });
    }
}
