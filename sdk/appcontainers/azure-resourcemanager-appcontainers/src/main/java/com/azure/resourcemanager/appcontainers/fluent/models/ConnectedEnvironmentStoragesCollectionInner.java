// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Collection of Storage for Environments.
 */
@Fluent
public final class ConnectedEnvironmentStoragesCollectionInner
    implements JsonSerializable<ConnectedEnvironmentStoragesCollectionInner> {
    /*
     * Collection of storage resources.
     */
    private List<ConnectedEnvironmentStorageInner> value;

    /**
     * Creates an instance of ConnectedEnvironmentStoragesCollectionInner class.
     */
    public ConnectedEnvironmentStoragesCollectionInner() {
    }

    /**
     * Get the value property: Collection of storage resources.
     * 
     * @return the value value.
     */
    public List<ConnectedEnvironmentStorageInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Collection of storage resources.
     * 
     * @param value the value value to set.
     * @return the ConnectedEnvironmentStoragesCollectionInner object itself.
     */
    public ConnectedEnvironmentStoragesCollectionInner withValue(List<ConnectedEnvironmentStorageInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property value in model ConnectedEnvironmentStoragesCollectionInner"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ConnectedEnvironmentStoragesCollectionInner.class);

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
     * Reads an instance of ConnectedEnvironmentStoragesCollectionInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ConnectedEnvironmentStoragesCollectionInner if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ConnectedEnvironmentStoragesCollectionInner.
     */
    public static ConnectedEnvironmentStoragesCollectionInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ConnectedEnvironmentStoragesCollectionInner deserializedConnectedEnvironmentStoragesCollectionInner
                = new ConnectedEnvironmentStoragesCollectionInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ConnectedEnvironmentStorageInner> value
                        = reader.readArray(reader1 -> ConnectedEnvironmentStorageInner.fromJson(reader1));
                    deserializedConnectedEnvironmentStoragesCollectionInner.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedConnectedEnvironmentStoragesCollectionInner;
        });
    }
}
