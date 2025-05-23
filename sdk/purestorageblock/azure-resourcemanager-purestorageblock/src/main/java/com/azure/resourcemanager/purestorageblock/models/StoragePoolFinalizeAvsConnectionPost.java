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
 * FinalizeAvsConnection payload information, either encoded or explicit.
 */
@Fluent
public final class StoragePoolFinalizeAvsConnectionPost
    implements JsonSerializable<StoragePoolFinalizeAvsConnectionPost> {
    /*
     * Encoded AVS connection information
     */
    private String serviceInitializationDataEnc;

    /*
     * Explicit AVS connection information
     */
    private ServiceInitializationInfo serviceInitializationData;

    /**
     * Creates an instance of StoragePoolFinalizeAvsConnectionPost class.
     */
    public StoragePoolFinalizeAvsConnectionPost() {
    }

    /**
     * Get the serviceInitializationDataEnc property: Encoded AVS connection information.
     * 
     * @return the serviceInitializationDataEnc value.
     */
    public String serviceInitializationDataEnc() {
        return this.serviceInitializationDataEnc;
    }

    /**
     * Set the serviceInitializationDataEnc property: Encoded AVS connection information.
     * 
     * @param serviceInitializationDataEnc the serviceInitializationDataEnc value to set.
     * @return the StoragePoolFinalizeAvsConnectionPost object itself.
     */
    public StoragePoolFinalizeAvsConnectionPost withServiceInitializationDataEnc(String serviceInitializationDataEnc) {
        this.serviceInitializationDataEnc = serviceInitializationDataEnc;
        return this;
    }

    /**
     * Get the serviceInitializationData property: Explicit AVS connection information.
     * 
     * @return the serviceInitializationData value.
     */
    public ServiceInitializationInfo serviceInitializationData() {
        return this.serviceInitializationData;
    }

    /**
     * Set the serviceInitializationData property: Explicit AVS connection information.
     * 
     * @param serviceInitializationData the serviceInitializationData value to set.
     * @return the StoragePoolFinalizeAvsConnectionPost object itself.
     */
    public StoragePoolFinalizeAvsConnectionPost
        withServiceInitializationData(ServiceInitializationInfo serviceInitializationData) {
        this.serviceInitializationData = serviceInitializationData;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (serviceInitializationData() != null) {
            serviceInitializationData().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("serviceInitializationDataEnc", this.serviceInitializationDataEnc);
        jsonWriter.writeJsonField("serviceInitializationData", this.serviceInitializationData);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StoragePoolFinalizeAvsConnectionPost from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StoragePoolFinalizeAvsConnectionPost if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the StoragePoolFinalizeAvsConnectionPost.
     */
    public static StoragePoolFinalizeAvsConnectionPost fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StoragePoolFinalizeAvsConnectionPost deserializedStoragePoolFinalizeAvsConnectionPost
                = new StoragePoolFinalizeAvsConnectionPost();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("serviceInitializationDataEnc".equals(fieldName)) {
                    deserializedStoragePoolFinalizeAvsConnectionPost.serviceInitializationDataEnc = reader.getString();
                } else if ("serviceInitializationData".equals(fieldName)) {
                    deserializedStoragePoolFinalizeAvsConnectionPost.serviceInitializationData
                        = ServiceInitializationInfo.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStoragePoolFinalizeAvsConnectionPost;
        });
    }
}
