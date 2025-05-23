// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.purestorageblock.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The updatable properties of the AvsVm.
 */
@Fluent
public final class AvsVmUpdateProperties implements JsonSerializable<AvsVmUpdateProperties> {
    /*
     * AVS VM's soft-deletion state
     */
    private SoftDeletion softDeletion;

    /**
     * Creates an instance of AvsVmUpdateProperties class.
     */
    public AvsVmUpdateProperties() {
    }

    /**
     * Get the softDeletion property: AVS VM's soft-deletion state.
     * 
     * @return the softDeletion value.
     */
    public SoftDeletion softDeletion() {
        return this.softDeletion;
    }

    /**
     * Set the softDeletion property: AVS VM's soft-deletion state.
     * 
     * @param softDeletion the softDeletion value to set.
     * @return the AvsVmUpdateProperties object itself.
     */
    public AvsVmUpdateProperties withSoftDeletion(SoftDeletion softDeletion) {
        this.softDeletion = softDeletion;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (softDeletion() != null) {
            softDeletion().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("softDeletion", this.softDeletion);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AvsVmUpdateProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AvsVmUpdateProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AvsVmUpdateProperties.
     */
    public static AvsVmUpdateProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AvsVmUpdateProperties deserializedAvsVmUpdateProperties = new AvsVmUpdateProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("softDeletion".equals(fieldName)) {
                    deserializedAvsVmUpdateProperties.softDeletion = SoftDeletion.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAvsVmUpdateProperties;
        });
    }
}
