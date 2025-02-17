// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.security.keyvault.certificates.implementation.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * A list of certificates that have been deleted in this vault.
 */
@Immutable
public final class DeletedCertificateListResult implements JsonSerializable<DeletedCertificateListResult> {
    /*
     * A response message containing a list of deleted certificates in the vault along with a link to the next page of
     * deleted certificates
     */
    private List<DeletedCertificateItem> value;

    /*
     * The URL to get the next set of deleted certificates.
     */
    private String nextLink;

    /**
     * Creates an instance of DeletedCertificateListResult class.
     */
    public DeletedCertificateListResult() {
    }

    /**
     * Get the value property: A response message containing a list of deleted certificates in the vault along with a
     * link to the next page of deleted certificates.
     * 
     * @return the value value.
     */
    public List<DeletedCertificateItem> getValue() {
        return this.value;
    }

    /**
     * Get the nextLink property: The URL to get the next set of deleted certificates.
     * 
     * @return the nextLink value.
     */
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DeletedCertificateListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeletedCertificateListResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DeletedCertificateListResult.
     */
    public static DeletedCertificateListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DeletedCertificateListResult deserializedDeletedCertificateListResult = new DeletedCertificateListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<DeletedCertificateItem> value
                        = reader.readArray(reader1 -> DeletedCertificateItem.fromJson(reader1));
                    deserializedDeletedCertificateListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedDeletedCertificateListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDeletedCertificateListResult;
        });
    }
}
