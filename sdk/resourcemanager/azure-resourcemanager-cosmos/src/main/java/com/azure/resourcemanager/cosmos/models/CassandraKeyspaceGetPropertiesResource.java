// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The CassandraKeyspaceGetPropertiesResource model.
 */
@Fluent
public final class CassandraKeyspaceGetPropertiesResource extends CassandraKeyspaceResource {
    /*
     * A system generated property. A unique identifier.
     */
    private String rid;

    /*
     * A system generated property that denotes the last updated timestamp of the resource.
     */
    private Float ts;

    /*
     * A system generated property representing the resource etag required for optimistic concurrency control.
     */
    private String etag;

    /**
     * Creates an instance of CassandraKeyspaceGetPropertiesResource class.
     */
    public CassandraKeyspaceGetPropertiesResource() {
    }

    /**
     * Get the rid property: A system generated property. A unique identifier.
     * 
     * @return the rid value.
     */
    public String rid() {
        return this.rid;
    }

    /**
     * Get the ts property: A system generated property that denotes the last updated timestamp of the resource.
     * 
     * @return the ts value.
     */
    public Float ts() {
        return this.ts;
    }

    /**
     * Get the etag property: A system generated property representing the resource etag required for optimistic
     * concurrency control.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CassandraKeyspaceGetPropertiesResource withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (id() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property id in model CassandraKeyspaceGetPropertiesResource"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CassandraKeyspaceGetPropertiesResource.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", id());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CassandraKeyspaceGetPropertiesResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CassandraKeyspaceGetPropertiesResource if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CassandraKeyspaceGetPropertiesResource.
     */
    public static CassandraKeyspaceGetPropertiesResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CassandraKeyspaceGetPropertiesResource deserializedCassandraKeyspaceGetPropertiesResource
                = new CassandraKeyspaceGetPropertiesResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedCassandraKeyspaceGetPropertiesResource.withId(reader.getString());
                } else if ("_rid".equals(fieldName)) {
                    deserializedCassandraKeyspaceGetPropertiesResource.rid = reader.getString();
                } else if ("_ts".equals(fieldName)) {
                    deserializedCassandraKeyspaceGetPropertiesResource.ts = reader.getNullable(JsonReader::getFloat);
                } else if ("_etag".equals(fieldName)) {
                    deserializedCassandraKeyspaceGetPropertiesResource.etag = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCassandraKeyspaceGetPropertiesResource;
        });
    }
}
