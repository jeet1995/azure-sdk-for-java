// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.synapse.fluent.models.RecommendedSensitivityLabelUpdateProperties;
import java.io.IOException;

/**
 * A recommended sensitivity label update operation.
 */
@Fluent
public final class RecommendedSensitivityLabelUpdate extends ProxyResource {
    /*
     * Resource properties.
     */
    private RecommendedSensitivityLabelUpdateProperties innerProperties;

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
     * Creates an instance of RecommendedSensitivityLabelUpdate class.
     */
    public RecommendedSensitivityLabelUpdate() {
    }

    /**
     * Get the innerProperties property: Resource properties.
     * 
     * @return the innerProperties value.
     */
    private RecommendedSensitivityLabelUpdateProperties innerProperties() {
        return this.innerProperties;
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
     * Get the op property: The op property.
     * 
     * @return the op value.
     */
    public RecommendedSensitivityLabelUpdateKind op() {
        return this.innerProperties() == null ? null : this.innerProperties().op();
    }

    /**
     * Set the op property: The op property.
     * 
     * @param op the op value to set.
     * @return the RecommendedSensitivityLabelUpdate object itself.
     */
    public RecommendedSensitivityLabelUpdate withOp(RecommendedSensitivityLabelUpdateKind op) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RecommendedSensitivityLabelUpdateProperties();
        }
        this.innerProperties().withOp(op);
        return this;
    }

    /**
     * Get the schema property: Schema name of the column to update.
     * 
     * @return the schema value.
     */
    public String schema() {
        return this.innerProperties() == null ? null : this.innerProperties().schema();
    }

    /**
     * Set the schema property: Schema name of the column to update.
     * 
     * @param schema the schema value to set.
     * @return the RecommendedSensitivityLabelUpdate object itself.
     */
    public RecommendedSensitivityLabelUpdate withSchema(String schema) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RecommendedSensitivityLabelUpdateProperties();
        }
        this.innerProperties().withSchema(schema);
        return this;
    }

    /**
     * Get the table property: Table name of the column to update.
     * 
     * @return the table value.
     */
    public String table() {
        return this.innerProperties() == null ? null : this.innerProperties().table();
    }

    /**
     * Set the table property: Table name of the column to update.
     * 
     * @param table the table value to set.
     * @return the RecommendedSensitivityLabelUpdate object itself.
     */
    public RecommendedSensitivityLabelUpdate withTable(String table) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RecommendedSensitivityLabelUpdateProperties();
        }
        this.innerProperties().withTable(table);
        return this;
    }

    /**
     * Get the column property: Column name to update.
     * 
     * @return the column value.
     */
    public String column() {
        return this.innerProperties() == null ? null : this.innerProperties().column();
    }

    /**
     * Set the column property: Column name to update.
     * 
     * @param column the column value to set.
     * @return the RecommendedSensitivityLabelUpdate object itself.
     */
    public RecommendedSensitivityLabelUpdate withColumn(String column) {
        if (this.innerProperties() == null) {
            this.innerProperties = new RecommendedSensitivityLabelUpdateProperties();
        }
        this.innerProperties().withColumn(column);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecommendedSensitivityLabelUpdate from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecommendedSensitivityLabelUpdate if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RecommendedSensitivityLabelUpdate.
     */
    public static RecommendedSensitivityLabelUpdate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RecommendedSensitivityLabelUpdate deserializedRecommendedSensitivityLabelUpdate
                = new RecommendedSensitivityLabelUpdate();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedRecommendedSensitivityLabelUpdate.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedRecommendedSensitivityLabelUpdate.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedRecommendedSensitivityLabelUpdate.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedRecommendedSensitivityLabelUpdate.innerProperties
                        = RecommendedSensitivityLabelUpdateProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecommendedSensitivityLabelUpdate;
        });
    }
}
