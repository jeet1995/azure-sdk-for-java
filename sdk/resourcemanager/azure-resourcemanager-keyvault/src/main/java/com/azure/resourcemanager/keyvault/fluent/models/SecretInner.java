// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.keyvault.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.keyvault.models.SecretProperties;
import java.io.IOException;
import java.util.Map;

/**
 * Resource information with extended details.
 */
@Fluent
public final class SecretInner extends Resource {
    /*
     * Properties of the secret
     */
    private SecretProperties properties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of SecretInner class.
     */
    public SecretInner() {
    }

    /**
     * Get the properties property: Properties of the secret.
     * 
     * @return the properties value.
     */
    public SecretProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Properties of the secret.
     * 
     * @param properties the properties value to set.
     * @return the SecretInner object itself.
     */
    public SecretInner withProperties(SecretProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecretInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SecretInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property properties in model SecretInner"));
        } else {
            properties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SecretInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecretInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecretInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SecretInner.
     */
    public static SecretInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecretInner deserializedSecretInner = new SecretInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedSecretInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedSecretInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedSecretInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedSecretInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedSecretInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedSecretInner.properties = SecretProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecretInner;
        });
    }
}
