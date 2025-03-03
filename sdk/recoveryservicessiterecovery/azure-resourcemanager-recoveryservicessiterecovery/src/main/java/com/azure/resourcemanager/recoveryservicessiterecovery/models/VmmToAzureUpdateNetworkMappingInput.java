// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Update network mappings input properties/behavior specific to vmm to azure.
 */
@Immutable
public final class VmmToAzureUpdateNetworkMappingInput extends FabricSpecificUpdateNetworkMappingInput {
    /*
     * The instance type.
     */
    private String instanceType = "VmmToAzure";

    /**
     * Creates an instance of VmmToAzureUpdateNetworkMappingInput class.
     */
    public VmmToAzureUpdateNetworkMappingInput() {
    }

    /**
     * Get the instanceType property: The instance type.
     * 
     * @return the instanceType value.
     */
    @Override
    public String instanceType() {
        return this.instanceType;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("instanceType", this.instanceType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of VmmToAzureUpdateNetworkMappingInput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VmmToAzureUpdateNetworkMappingInput if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the VmmToAzureUpdateNetworkMappingInput.
     */
    public static VmmToAzureUpdateNetworkMappingInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            VmmToAzureUpdateNetworkMappingInput deserializedVmmToAzureUpdateNetworkMappingInput
                = new VmmToAzureUpdateNetworkMappingInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("instanceType".equals(fieldName)) {
                    deserializedVmmToAzureUpdateNetworkMappingInput.instanceType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedVmmToAzureUpdateNetworkMappingInput;
        });
    }
}
