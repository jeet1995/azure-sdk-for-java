// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.security.keyvault.keys.implementation.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The key list result.
 */
@Immutable
public final class KeyListResult implements JsonSerializable<KeyListResult> {
    /*
     * A response message containing a list of keys in the key vault along with a link to the next page of keys.
     */
    private List<KeyItem> value;

    /*
     * The URL to get the next set of keys.
     */
    private String nextLink;

    /**
     * Creates an instance of KeyListResult class.
     */
    public KeyListResult() {
    }

    /**
     * Get the value property: A response message containing a list of keys in the key vault along with a link to the
     * next page of keys.
     * 
     * @return the value value.
     */
    public List<KeyItem> getValue() {
        return this.value;
    }

    /**
     * Get the nextLink property: The URL to get the next set of keys.
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
     * Reads an instance of KeyListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of KeyListResult if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the KeyListResult.
     */
    public static KeyListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            KeyListResult deserializedKeyListResult = new KeyListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<KeyItem> value = reader.readArray(reader1 -> KeyItem.fromJson(reader1));
                    deserializedKeyListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedKeyListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedKeyListResult;
        });
    }
}
