// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * MongoDB linked service properties.
 */
@Fluent
public final class MongoDbV2LinkedServiceTypeProperties
    implements JsonSerializable<MongoDbV2LinkedServiceTypeProperties> {
    /*
     * The MongoDB connection string. Type: string, SecureString or AzureKeyVaultSecretReference. Type: string,
     * SecureString or AzureKeyVaultSecretReference.
     */
    private Object connectionString;

    /*
     * The name of the MongoDB database that you want to access. Type: string (or Expression with resultType string).
     */
    private Object database;

    /**
     * Creates an instance of MongoDbV2LinkedServiceTypeProperties class.
     */
    public MongoDbV2LinkedServiceTypeProperties() {
    }

    /**
     * Get the connectionString property: The MongoDB connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference. Type: string, SecureString or AzureKeyVaultSecretReference.
     * 
     * @return the connectionString value.
     */
    public Object connectionString() {
        return this.connectionString;
    }

    /**
     * Set the connectionString property: The MongoDB connection string. Type: string, SecureString or
     * AzureKeyVaultSecretReference. Type: string, SecureString or AzureKeyVaultSecretReference.
     * 
     * @param connectionString the connectionString value to set.
     * @return the MongoDbV2LinkedServiceTypeProperties object itself.
     */
    public MongoDbV2LinkedServiceTypeProperties withConnectionString(Object connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * Get the database property: The name of the MongoDB database that you want to access. Type: string (or Expression
     * with resultType string).
     * 
     * @return the database value.
     */
    public Object database() {
        return this.database;
    }

    /**
     * Set the database property: The name of the MongoDB database that you want to access. Type: string (or Expression
     * with resultType string).
     * 
     * @param database the database value to set.
     * @return the MongoDbV2LinkedServiceTypeProperties object itself.
     */
    public MongoDbV2LinkedServiceTypeProperties withDatabase(Object database) {
        this.database = database;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (connectionString() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property connectionString in model MongoDbV2LinkedServiceTypeProperties"));
        }
        if (database() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property database in model MongoDbV2LinkedServiceTypeProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(MongoDbV2LinkedServiceTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("connectionString", this.connectionString);
        jsonWriter.writeUntypedField("database", this.database);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MongoDbV2LinkedServiceTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MongoDbV2LinkedServiceTypeProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MongoDbV2LinkedServiceTypeProperties.
     */
    public static MongoDbV2LinkedServiceTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MongoDbV2LinkedServiceTypeProperties deserializedMongoDbV2LinkedServiceTypeProperties
                = new MongoDbV2LinkedServiceTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("connectionString".equals(fieldName)) {
                    deserializedMongoDbV2LinkedServiceTypeProperties.connectionString = reader.readUntyped();
                } else if ("database".equals(fieldName)) {
                    deserializedMongoDbV2LinkedServiceTypeProperties.database = reader.readUntyped();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMongoDbV2LinkedServiceTypeProperties;
        });
    }
}
