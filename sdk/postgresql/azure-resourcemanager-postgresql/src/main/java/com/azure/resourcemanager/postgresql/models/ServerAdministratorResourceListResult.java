// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresql.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.postgresql.fluent.models.ServerAdministratorResourceInner;
import java.io.IOException;
import java.util.List;

/**
 * The response to a list Active Directory Administrators request.
 */
@Fluent
public final class ServerAdministratorResourceListResult
    implements JsonSerializable<ServerAdministratorResourceListResult> {
    /*
     * The list of server Active Directory Administrators for the server.
     */
    private List<ServerAdministratorResourceInner> value;

    /**
     * Creates an instance of ServerAdministratorResourceListResult class.
     */
    public ServerAdministratorResourceListResult() {
    }

    /**
     * Get the value property: The list of server Active Directory Administrators for the server.
     * 
     * @return the value value.
     */
    public List<ServerAdministratorResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of server Active Directory Administrators for the server.
     * 
     * @param value the value value to set.
     * @return the ServerAdministratorResourceListResult object itself.
     */
    public ServerAdministratorResourceListResult withValue(List<ServerAdministratorResourceInner> value) {
        this.value = value;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ServerAdministratorResourceListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServerAdministratorResourceListResult if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ServerAdministratorResourceListResult.
     */
    public static ServerAdministratorResourceListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServerAdministratorResourceListResult deserializedServerAdministratorResourceListResult
                = new ServerAdministratorResourceListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ServerAdministratorResourceInner> value
                        = reader.readArray(reader1 -> ServerAdministratorResourceInner.fromJson(reader1));
                    deserializedServerAdministratorResourceListResult.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServerAdministratorResourceListResult;
        });
    }
}
