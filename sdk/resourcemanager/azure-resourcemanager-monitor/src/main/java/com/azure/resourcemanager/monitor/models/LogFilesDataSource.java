// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Definition of which custom log files will be collected by this data collection rule.
 */
@Fluent
public final class LogFilesDataSource implements JsonSerializable<LogFilesDataSource> {
    /*
     * List of streams that this data source will be sent to.
     * A stream indicates what schema will be used for this data source
     */
    private List<String> streams;

    /*
     * File Patterns where the log files are located
     */
    private List<String> filePatterns;

    /*
     * The data format of the log files
     */
    private KnownLogFilesDataSourceFormat format;

    /*
     * The log files specific settings.
     */
    private LogFilesDataSourceSettings settings;

    /*
     * A friendly name for the data source.
     * This name should be unique across all data sources (regardless of type) within the data collection rule.
     */
    private String name;

    /**
     * Creates an instance of LogFilesDataSource class.
     */
    public LogFilesDataSource() {
    }

    /**
     * Get the streams property: List of streams that this data source will be sent to.
     * A stream indicates what schema will be used for this data source.
     * 
     * @return the streams value.
     */
    public List<String> streams() {
        return this.streams;
    }

    /**
     * Set the streams property: List of streams that this data source will be sent to.
     * A stream indicates what schema will be used for this data source.
     * 
     * @param streams the streams value to set.
     * @return the LogFilesDataSource object itself.
     */
    public LogFilesDataSource withStreams(List<String> streams) {
        this.streams = streams;
        return this;
    }

    /**
     * Get the filePatterns property: File Patterns where the log files are located.
     * 
     * @return the filePatterns value.
     */
    public List<String> filePatterns() {
        return this.filePatterns;
    }

    /**
     * Set the filePatterns property: File Patterns where the log files are located.
     * 
     * @param filePatterns the filePatterns value to set.
     * @return the LogFilesDataSource object itself.
     */
    public LogFilesDataSource withFilePatterns(List<String> filePatterns) {
        this.filePatterns = filePatterns;
        return this;
    }

    /**
     * Get the format property: The data format of the log files.
     * 
     * @return the format value.
     */
    public KnownLogFilesDataSourceFormat format() {
        return this.format;
    }

    /**
     * Set the format property: The data format of the log files.
     * 
     * @param format the format value to set.
     * @return the LogFilesDataSource object itself.
     */
    public LogFilesDataSource withFormat(KnownLogFilesDataSourceFormat format) {
        this.format = format;
        return this;
    }

    /**
     * Get the settings property: The log files specific settings.
     * 
     * @return the settings value.
     */
    public LogFilesDataSourceSettings settings() {
        return this.settings;
    }

    /**
     * Set the settings property: The log files specific settings.
     * 
     * @param settings the settings value to set.
     * @return the LogFilesDataSource object itself.
     */
    public LogFilesDataSource withSettings(LogFilesDataSourceSettings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get the name property: A friendly name for the data source.
     * This name should be unique across all data sources (regardless of type) within the data collection rule.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: A friendly name for the data source.
     * This name should be unique across all data sources (regardless of type) within the data collection rule.
     * 
     * @param name the name value to set.
     * @return the LogFilesDataSource object itself.
     */
    public LogFilesDataSource withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (streams() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property streams in model LogFilesDataSource"));
        }
        if (filePatterns() == null) {
            throw LOGGER.atError()
                .log(
                    new IllegalArgumentException("Missing required property filePatterns in model LogFilesDataSource"));
        }
        if (format() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property format in model LogFilesDataSource"));
        }
        if (settings() != null) {
            settings().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(LogFilesDataSource.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("streams", this.streams, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("filePatterns", this.filePatterns, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("format", this.format == null ? null : this.format.toString());
        jsonWriter.writeJsonField("settings", this.settings);
        jsonWriter.writeStringField("name", this.name);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LogFilesDataSource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LogFilesDataSource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LogFilesDataSource.
     */
    public static LogFilesDataSource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LogFilesDataSource deserializedLogFilesDataSource = new LogFilesDataSource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("streams".equals(fieldName)) {
                    List<String> streams = reader.readArray(reader1 -> reader1.getString());
                    deserializedLogFilesDataSource.streams = streams;
                } else if ("filePatterns".equals(fieldName)) {
                    List<String> filePatterns = reader.readArray(reader1 -> reader1.getString());
                    deserializedLogFilesDataSource.filePatterns = filePatterns;
                } else if ("format".equals(fieldName)) {
                    deserializedLogFilesDataSource.format
                        = KnownLogFilesDataSourceFormat.fromString(reader.getString());
                } else if ("settings".equals(fieldName)) {
                    deserializedLogFilesDataSource.settings = LogFilesDataSourceSettings.fromJson(reader);
                } else if ("name".equals(fieldName)) {
                    deserializedLogFilesDataSource.name = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLogFilesDataSource;
        });
    }
}
