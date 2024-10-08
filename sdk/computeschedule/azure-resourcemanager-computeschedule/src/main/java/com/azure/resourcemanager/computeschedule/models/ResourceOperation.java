// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * High level response from an operation on a resource.
 */
@Immutable
public final class ResourceOperation implements JsonSerializable<ResourceOperation> {
    /*
     * Unique identifier for the resource involved in the operation, eg ArmId
     */
    private String resourceId;

    /*
     * Resource level error code if it exists
     */
    private String errorCode;

    /*
     * Resource level error details if they exist
     */
    private String errorDetails;

    /*
     * Details of the operation performed on a resource
     */
    private ResourceOperationDetails operation;

    /**
     * Creates an instance of ResourceOperation class.
     */
    private ResourceOperation() {
    }

    /**
     * Get the resourceId property: Unique identifier for the resource involved in the operation, eg ArmId.
     * 
     * @return the resourceId value.
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Get the errorCode property: Resource level error code if it exists.
     * 
     * @return the errorCode value.
     */
    public String errorCode() {
        return this.errorCode;
    }

    /**
     * Get the errorDetails property: Resource level error details if they exist.
     * 
     * @return the errorDetails value.
     */
    public String errorDetails() {
        return this.errorDetails;
    }

    /**
     * Get the operation property: Details of the operation performed on a resource.
     * 
     * @return the operation value.
     */
    public ResourceOperationDetails operation() {
        return this.operation;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (operation() != null) {
            operation().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resourceId", this.resourceId);
        jsonWriter.writeStringField("errorCode", this.errorCode);
        jsonWriter.writeStringField("errorDetails", this.errorDetails);
        jsonWriter.writeJsonField("operation", this.operation);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceOperation from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceOperation if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ResourceOperation.
     */
    public static ResourceOperation fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceOperation deserializedResourceOperation = new ResourceOperation();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resourceId".equals(fieldName)) {
                    deserializedResourceOperation.resourceId = reader.getString();
                } else if ("errorCode".equals(fieldName)) {
                    deserializedResourceOperation.errorCode = reader.getString();
                } else if ("errorDetails".equals(fieldName)) {
                    deserializedResourceOperation.errorDetails = reader.getString();
                } else if ("operation".equals(fieldName)) {
                    deserializedResourceOperation.operation = ResourceOperationDetails.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceOperation;
        });
    }
}
