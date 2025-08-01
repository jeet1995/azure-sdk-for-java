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
import java.util.List;

/**
 * The object that defines the structure of an Azure Synapse error response.
 */
@Fluent
public class CloudError implements JsonSerializable<CloudError> {
    /*
     * Error code.
     */
    @Generated
    private String code;

    /*
     * Error message.
     */
    @Generated
    private String message;

    /*
     * Property name/path in request associated with error.
     */
    @Generated
    private String target;

    /*
     * Array with additional error details.
     */
    @Generated
    private List<CloudError> details;

    /**
     * Creates an instance of CloudError class.
     */
    @Generated
    public CloudError() {
    }

    /**
     * Get the code property: Error code.
     * 
     * @return the code value.
     */
    @Generated
    public String getCode() {
        return this.code;
    }

    /**
     * Set the code property: Error code.
     * 
     * @param code the code value to set.
     * @return the CloudError object itself.
     */
    @Generated
    public CloudError setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message property: Error message.
     * 
     * @return the message value.
     */
    @Generated
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message property: Error message.
     * 
     * @param message the message value to set.
     * @return the CloudError object itself.
     */
    @Generated
    public CloudError setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the target property: Property name/path in request associated with error.
     * 
     * @return the target value.
     */
    @Generated
    public String getTarget() {
        return this.target;
    }

    /**
     * Set the target property: Property name/path in request associated with error.
     * 
     * @param target the target value to set.
     * @return the CloudError object itself.
     */
    @Generated
    public CloudError setTarget(String target) {
        this.target = target;
        return this;
    }

    /**
     * Get the details property: Array with additional error details.
     * 
     * @return the details value.
     */
    @Generated
    public List<CloudError> getDetails() {
        return this.details;
    }

    /**
     * Set the details property: Array with additional error details.
     * 
     * @param details the details value to set.
     * @return the CloudError object itself.
     */
    @Generated
    public CloudError setDetails(List<CloudError> details) {
        this.details = details;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (code != null || message != null || target != null || details != null) {
            jsonWriter.writeStartObject("error");
            jsonWriter.writeStringField("code", this.code);
            jsonWriter.writeStringField("message", this.message);
            jsonWriter.writeStringField("target", this.target);
            jsonWriter.writeArrayField("details", this.details, (writer, element) -> writer.writeJson(element));
            jsonWriter.writeEndObject();
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CloudError from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CloudError if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CloudError.
     */
    @Generated
    public static CloudError fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CloudError deserializedCloudError = new CloudError();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("error".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("code".equals(fieldName)) {
                            deserializedCloudError.code = reader.getString();
                        } else if ("message".equals(fieldName)) {
                            deserializedCloudError.message = reader.getString();
                        } else if ("target".equals(fieldName)) {
                            deserializedCloudError.target = reader.getString();
                        } else if ("details".equals(fieldName)) {
                            List<CloudError> details = reader.readArray(reader1 -> CloudError.fromJson(reader1));
                            deserializedCloudError.details = details;
                        } else {
                            reader.skipChildren();
                        }
                    }
                }
                reader.skipChildren();
            }

            return deserializedCloudError;
        });
    }
}
