// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.devtestlabs.fluent.models.UserInner;
import java.io.IOException;
import java.util.List;

/**
 * The response of a list operation.
 */
@Fluent
public final class UserList implements JsonSerializable<UserList> {
    /*
     * Results of the list operation.
     */
    private List<UserInner> value;

    /*
     * Link for next set of results.
     */
    private String nextLink;

    /**
     * Creates an instance of UserList class.
     */
    public UserList() {
    }

    /**
     * Get the value property: Results of the list operation.
     * 
     * @return the value value.
     */
    public List<UserInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Results of the list operation.
     * 
     * @param value the value value to set.
     * @return the UserList object itself.
     */
    public UserList withValue(List<UserInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for next set of results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for next set of results.
     * 
     * @param nextLink the nextLink value to set.
     * @return the UserList object itself.
     */
    public UserList withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UserList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UserList if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the UserList.
     */
    public static UserList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UserList deserializedUserList = new UserList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<UserInner> value = reader.readArray(reader1 -> UserInner.fromJson(reader1));
                    deserializedUserList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedUserList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUserList;
        });
    }
}
