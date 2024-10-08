// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * DataReferenceCredential base class.
 */
@Immutable
public class DataReferenceCredential implements JsonSerializable<DataReferenceCredential> {
    /*
     * [Required] Credential type used to authentication with storage.
     */
    private DataReferenceCredentialType credentialType
        = DataReferenceCredentialType.fromString("DataReferenceCredential");

    /**
     * Creates an instance of DataReferenceCredential class.
     */
    public DataReferenceCredential() {
    }

    /**
     * Get the credentialType property: [Required] Credential type used to authentication with storage.
     * 
     * @return the credentialType value.
     */
    public DataReferenceCredentialType credentialType() {
        return this.credentialType;
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
        jsonWriter.writeStringField("credentialType",
            this.credentialType == null ? null : this.credentialType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DataReferenceCredential from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DataReferenceCredential if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DataReferenceCredential.
     */
    public static DataReferenceCredential fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("credentialType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("NoCredentials".equals(discriminatorValue)) {
                    return AnonymousAccessCredential.fromJson(readerToUse.reset());
                } else if ("DockerCredentials".equals(discriminatorValue)) {
                    return DockerCredential.fromJson(readerToUse.reset());
                } else if ("ManagedIdentity".equals(discriminatorValue)) {
                    return ManagedIdentityCredential.fromJson(readerToUse.reset());
                } else if ("SAS".equals(discriminatorValue)) {
                    return SasCredential.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static DataReferenceCredential fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DataReferenceCredential deserializedDataReferenceCredential = new DataReferenceCredential();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("credentialType".equals(fieldName)) {
                    deserializedDataReferenceCredential.credentialType
                        = DataReferenceCredentialType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDataReferenceCredential;
        });
    }
}
