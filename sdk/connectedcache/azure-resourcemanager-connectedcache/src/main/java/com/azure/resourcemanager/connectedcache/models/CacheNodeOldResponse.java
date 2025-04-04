// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.connectedcache.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.exception.ManagementError;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Model representing Cache Node for ConnectedCache resource.
 */
@Fluent
public final class CacheNodeOldResponse implements JsonSerializable<CacheNodeOldResponse> {
    /*
     * The provisioned state of the resource
     */
    private ProvisioningState provisioningState;

    /*
     * statusCode used to get code details of Mcc response object
     */
    private String statusCode;

    /*
     * statusText used to get status details in string format of Mcc response object
     */
    private String statusText;

    /*
     * statusDetails used to get inner details of Mcc response object
     */
    private String statusDetails;

    /*
     * status of the HTTP error code
     */
    private String status;

    /*
     * The error details
     */
    private ManagementError error;

    /**
     * Creates an instance of CacheNodeOldResponse class.
     */
    public CacheNodeOldResponse() {
    }

    /**
     * Get the provisioningState property: The provisioned state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the statusCode property: statusCode used to get code details of Mcc response object.
     * 
     * @return the statusCode value.
     */
    public String statusCode() {
        return this.statusCode;
    }

    /**
     * Set the statusCode property: statusCode used to get code details of Mcc response object.
     * 
     * @param statusCode the statusCode value to set.
     * @return the CacheNodeOldResponse object itself.
     */
    public CacheNodeOldResponse withStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Get the statusText property: statusText used to get status details in string format of Mcc response object.
     * 
     * @return the statusText value.
     */
    public String statusText() {
        return this.statusText;
    }

    /**
     * Set the statusText property: statusText used to get status details in string format of Mcc response object.
     * 
     * @param statusText the statusText value to set.
     * @return the CacheNodeOldResponse object itself.
     */
    public CacheNodeOldResponse withStatusText(String statusText) {
        this.statusText = statusText;
        return this;
    }

    /**
     * Get the statusDetails property: statusDetails used to get inner details of Mcc response object.
     * 
     * @return the statusDetails value.
     */
    public String statusDetails() {
        return this.statusDetails;
    }

    /**
     * Set the statusDetails property: statusDetails used to get inner details of Mcc response object.
     * 
     * @param statusDetails the statusDetails value to set.
     * @return the CacheNodeOldResponse object itself.
     */
    public CacheNodeOldResponse withStatusDetails(String statusDetails) {
        this.statusDetails = statusDetails;
        return this;
    }

    /**
     * Get the status property: status of the HTTP error code.
     * 
     * @return the status value.
     */
    public String status() {
        return this.status;
    }

    /**
     * Get the error property: The error details.
     * 
     * @return the error value.
     */
    public ManagementError error() {
        return this.error;
    }

    /**
     * Set the error property: The error details.
     * 
     * @param error the error value to set.
     * @return the CacheNodeOldResponse object itself.
     */
    public CacheNodeOldResponse withError(ManagementError error) {
        this.error = error;
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
        jsonWriter.writeStringField("statusCode", this.statusCode);
        jsonWriter.writeStringField("statusText", this.statusText);
        jsonWriter.writeStringField("statusDetails", this.statusDetails);
        jsonWriter.writeJsonField("error", this.error);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CacheNodeOldResponse from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CacheNodeOldResponse if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the CacheNodeOldResponse.
     */
    public static CacheNodeOldResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CacheNodeOldResponse deserializedCacheNodeOldResponse = new CacheNodeOldResponse();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningState".equals(fieldName)) {
                    deserializedCacheNodeOldResponse.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else if ("statusCode".equals(fieldName)) {
                    deserializedCacheNodeOldResponse.statusCode = reader.getString();
                } else if ("statusText".equals(fieldName)) {
                    deserializedCacheNodeOldResponse.statusText = reader.getString();
                } else if ("statusDetails".equals(fieldName)) {
                    deserializedCacheNodeOldResponse.statusDetails = reader.getString();
                } else if ("status".equals(fieldName)) {
                    deserializedCacheNodeOldResponse.status = reader.getString();
                } else if ("error".equals(fieldName)) {
                    deserializedCacheNodeOldResponse.error = ManagementError.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCacheNodeOldResponse;
        });
    }
}
