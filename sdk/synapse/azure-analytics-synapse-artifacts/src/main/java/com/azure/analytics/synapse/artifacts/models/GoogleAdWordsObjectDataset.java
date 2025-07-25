// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Google AdWords service dataset.
 */
@Fluent
public class GoogleAdWordsObjectDataset extends Dataset {
    /*
     * Type of dataset.
     */
    @Generated
    private String type = "GoogleAdWordsObject";

    /*
     * The table name. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object tableName;

    /**
     * Creates an instance of GoogleAdWordsObjectDataset class.
     */
    @Generated
    public GoogleAdWordsObjectDataset() {
    }

    /**
     * Get the type property: Type of dataset.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the tableName property: The table name. Type: string (or Expression with resultType string).
     * 
     * @return the tableName value.
     */
    @Generated
    public Object getTableName() {
        return this.tableName;
    }

    /**
     * Set the tableName property: The table name. Type: string (or Expression with resultType string).
     * 
     * @param tableName the tableName value to set.
     * @return the GoogleAdWordsObjectDataset object itself.
     */
    @Generated
    public GoogleAdWordsObjectDataset setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setStructure(Object structure) {
        super.setStructure(structure);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setSchema(Object schema) {
        super.setSchema(schema);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setLinkedServiceName(LinkedServiceReference linkedServiceName) {
        super.setLinkedServiceName(linkedServiceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setAnnotations(List<Object> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public GoogleAdWordsObjectDataset setFolder(DatasetFolder folder) {
        super.setFolder(folder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("linkedServiceName", getLinkedServiceName());
        jsonWriter.writeStringField("description", getDescription());
        if (getStructure() != null) {
            jsonWriter.writeUntypedField("structure", getStructure());
        }
        if (getSchema() != null) {
            jsonWriter.writeUntypedField("schema", getSchema());
        }
        jsonWriter.writeMapField("parameters", getParameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", getAnnotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("folder", getFolder());
        jsonWriter.writeStringField("type", this.type);
        if (tableName != null) {
            jsonWriter.writeStartObject("typeProperties");
            if (this.tableName != null) {
                jsonWriter.writeUntypedField("tableName", this.tableName);
            }
            jsonWriter.writeEndObject();
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GoogleAdWordsObjectDataset from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GoogleAdWordsObjectDataset if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GoogleAdWordsObjectDataset.
     */
    @Generated
    public static GoogleAdWordsObjectDataset fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GoogleAdWordsObjectDataset deserializedGoogleAdWordsObjectDataset = new GoogleAdWordsObjectDataset();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("linkedServiceName".equals(fieldName)) {
                    deserializedGoogleAdWordsObjectDataset
                        .setLinkedServiceName(LinkedServiceReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedGoogleAdWordsObjectDataset.setDescription(reader.getString());
                } else if ("structure".equals(fieldName)) {
                    deserializedGoogleAdWordsObjectDataset.setStructure(reader.readUntyped());
                } else if ("schema".equals(fieldName)) {
                    deserializedGoogleAdWordsObjectDataset.setSchema(reader.readUntyped());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedGoogleAdWordsObjectDataset.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedGoogleAdWordsObjectDataset.setAnnotations(annotations);
                } else if ("folder".equals(fieldName)) {
                    deserializedGoogleAdWordsObjectDataset.setFolder(DatasetFolder.fromJson(reader));
                } else if ("type".equals(fieldName)) {
                    deserializedGoogleAdWordsObjectDataset.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("tableName".equals(fieldName)) {
                            deserializedGoogleAdWordsObjectDataset.tableName = reader.readUntyped();
                        } else {
                            reader.skipChildren();
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedGoogleAdWordsObjectDataset.setAdditionalProperties(additionalProperties);

            return deserializedGoogleAdWordsObjectDataset;
        });
    }
}
