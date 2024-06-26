// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.analytics.purview.datamap.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The contact in the search and suggest result.
 */
@Immutable
public final class ContactSearchResultValue implements JsonSerializable<ContactSearchResultValue> {
    /*
     * The GUID of the contact.
     */
    @Generated
    private String id;

    /*
     * The description of the contact.
     */
    @Generated
    private String info;

    /*
     * The type of the contact. It can be Expert or Owner for an entity. It can be
     * Expert or Steward for a glossary term.
     */
    @Generated
    private String contactType;

    /**
     * Creates an instance of ContactSearchResultValue class.
     */
    @Generated
    private ContactSearchResultValue() {
    }

    /**
     * Get the id property: The GUID of the contact.
     * 
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Get the info property: The description of the contact.
     * 
     * @return the info value.
     */
    @Generated
    public String getInfo() {
        return this.info;
    }

    /**
     * Get the contactType property: The type of the contact. It can be Expert or Owner for an entity. It can be
     * Expert or Steward for a glossary term.
     * 
     * @return the contactType value.
     */
    @Generated
    public String getContactType() {
        return this.contactType;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("info", this.info);
        jsonWriter.writeStringField("contactType", this.contactType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ContactSearchResultValue from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ContactSearchResultValue if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ContactSearchResultValue.
     */
    @Generated
    public static ContactSearchResultValue fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ContactSearchResultValue deserializedContactSearchResultValue = new ContactSearchResultValue();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedContactSearchResultValue.id = reader.getString();
                } else if ("info".equals(fieldName)) {
                    deserializedContactSearchResultValue.info = reader.getString();
                } else if ("contactType".equals(fieldName)) {
                    deserializedContactSearchResultValue.contactType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedContactSearchResultValue;
        });
    }
}
