// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.models.DataFlowSink;
import com.azure.resourcemanager.datafactory.models.DataFlowSource;
import com.azure.resourcemanager.datafactory.models.Transformation;
import java.io.IOException;
import java.util.List;

/**
 * Mapping data flow type properties.
 */
@Fluent
public final class MappingDataFlowTypeProperties implements JsonSerializable<MappingDataFlowTypeProperties> {
    /*
     * List of sources in data flow.
     */
    private List<DataFlowSource> sources;

    /*
     * List of sinks in data flow.
     */
    private List<DataFlowSink> sinks;

    /*
     * List of transformations in data flow.
     */
    private List<Transformation> transformations;

    /*
     * DataFlow script.
     */
    private String script;

    /*
     * Data flow script lines.
     */
    private List<String> scriptLines;

    /**
     * Creates an instance of MappingDataFlowTypeProperties class.
     */
    public MappingDataFlowTypeProperties() {
    }

    /**
     * Get the sources property: List of sources in data flow.
     * 
     * @return the sources value.
     */
    public List<DataFlowSource> sources() {
        return this.sources;
    }

    /**
     * Set the sources property: List of sources in data flow.
     * 
     * @param sources the sources value to set.
     * @return the MappingDataFlowTypeProperties object itself.
     */
    public MappingDataFlowTypeProperties withSources(List<DataFlowSource> sources) {
        this.sources = sources;
        return this;
    }

    /**
     * Get the sinks property: List of sinks in data flow.
     * 
     * @return the sinks value.
     */
    public List<DataFlowSink> sinks() {
        return this.sinks;
    }

    /**
     * Set the sinks property: List of sinks in data flow.
     * 
     * @param sinks the sinks value to set.
     * @return the MappingDataFlowTypeProperties object itself.
     */
    public MappingDataFlowTypeProperties withSinks(List<DataFlowSink> sinks) {
        this.sinks = sinks;
        return this;
    }

    /**
     * Get the transformations property: List of transformations in data flow.
     * 
     * @return the transformations value.
     */
    public List<Transformation> transformations() {
        return this.transformations;
    }

    /**
     * Set the transformations property: List of transformations in data flow.
     * 
     * @param transformations the transformations value to set.
     * @return the MappingDataFlowTypeProperties object itself.
     */
    public MappingDataFlowTypeProperties withTransformations(List<Transformation> transformations) {
        this.transformations = transformations;
        return this;
    }

    /**
     * Get the script property: DataFlow script.
     * 
     * @return the script value.
     */
    public String script() {
        return this.script;
    }

    /**
     * Set the script property: DataFlow script.
     * 
     * @param script the script value to set.
     * @return the MappingDataFlowTypeProperties object itself.
     */
    public MappingDataFlowTypeProperties withScript(String script) {
        this.script = script;
        return this;
    }

    /**
     * Get the scriptLines property: Data flow script lines.
     * 
     * @return the scriptLines value.
     */
    public List<String> scriptLines() {
        return this.scriptLines;
    }

    /**
     * Set the scriptLines property: Data flow script lines.
     * 
     * @param scriptLines the scriptLines value to set.
     * @return the MappingDataFlowTypeProperties object itself.
     */
    public MappingDataFlowTypeProperties withScriptLines(List<String> scriptLines) {
        this.scriptLines = scriptLines;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sources() != null) {
            sources().forEach(e -> e.validate());
        }
        if (sinks() != null) {
            sinks().forEach(e -> e.validate());
        }
        if (transformations() != null) {
            transformations().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("sources", this.sources, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("sinks", this.sinks, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("transformations", this.transformations,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("script", this.script);
        jsonWriter.writeArrayField("scriptLines", this.scriptLines, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MappingDataFlowTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MappingDataFlowTypeProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MappingDataFlowTypeProperties.
     */
    public static MappingDataFlowTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MappingDataFlowTypeProperties deserializedMappingDataFlowTypeProperties
                = new MappingDataFlowTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("sources".equals(fieldName)) {
                    List<DataFlowSource> sources = reader.readArray(reader1 -> DataFlowSource.fromJson(reader1));
                    deserializedMappingDataFlowTypeProperties.sources = sources;
                } else if ("sinks".equals(fieldName)) {
                    List<DataFlowSink> sinks = reader.readArray(reader1 -> DataFlowSink.fromJson(reader1));
                    deserializedMappingDataFlowTypeProperties.sinks = sinks;
                } else if ("transformations".equals(fieldName)) {
                    List<Transformation> transformations
                        = reader.readArray(reader1 -> Transformation.fromJson(reader1));
                    deserializedMappingDataFlowTypeProperties.transformations = transformations;
                } else if ("script".equals(fieldName)) {
                    deserializedMappingDataFlowTypeProperties.script = reader.getString();
                } else if ("scriptLines".equals(fieldName)) {
                    List<String> scriptLines = reader.readArray(reader1 -> reader1.getString());
                    deserializedMappingDataFlowTypeProperties.scriptLines = scriptLines;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMappingDataFlowTypeProperties;
        });
    }
}
