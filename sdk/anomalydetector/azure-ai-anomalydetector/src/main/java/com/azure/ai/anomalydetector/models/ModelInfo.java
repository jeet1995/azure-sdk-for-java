// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.anomalydetector.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Training result of a model, including its status, errors, and diagnostics
 * information.
 */
@Fluent
public final class ModelInfo implements JsonSerializable<ModelInfo> {

    /*
     * Source link to the input data to indicate an accessible Azure Storage URI.
     * It either points to an Azure Blob Storage folder or points to a CSV file in
     * Azure Blob Storage, based on your data schema selection.
     */
    @Generated
    private final String dataSource;

    /*
     * Data schema of the input data source. The default
     * is OneTable.
     */
    @Generated
    private DataSchema dataSchema;

    /*
     * Start date/time of training data, which should be
     * in ISO 8601 format.
     */
    @Generated
    private final OffsetDateTime startTime;

    /*
     * End date/time of training data, which should be
     * in ISO 8601 format.
     */
    @Generated
    private final OffsetDateTime endTime;

    /*
     * Display name of the model. Maximum length is 24
     * characters.
     */
    @Generated
    private String displayName;

    /*
     * Number of previous time stamps that will be used to
     * detect whether the time stamp is an anomaly or not.
     */
    @Generated
    private Integer slidingWindow;

    /*
     * Manner of aligning multiple variables.
     */
    @Generated
    private AlignPolicy alignPolicy;

    /*
     * Model status.
     */
    @Generated
    private ModelStatus status;

    /*
     * Error messages after failure to create a model.
     */
    @Generated
    private List<ErrorResponse> errors;

    /*
     * Diagnostics information to help inspect the states of a model or variable.
     */
    @Generated
    private DiagnosticsInfo diagnosticsInfo;

    /**
     * Creates an instance of ModelInfo class.
     *
     * @param dataSource the dataSource value to set.
     * @param startTime the startTime value to set.
     * @param endTime the endTime value to set.
     */
    @Generated
    public ModelInfo(String dataSource, OffsetDateTime startTime, OffsetDateTime endTime) {
        this.dataSource = dataSource;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Get the dataSource property: Source link to the input data to indicate an accessible Azure Storage URI.
     * It either points to an Azure Blob Storage folder or points to a CSV file in
     * Azure Blob Storage, based on your data schema selection.
     *
     * @return the dataSource value.
     */
    @Generated
    public String getDataSource() {
        return this.dataSource;
    }

    /**
     * Get the dataSchema property: Data schema of the input data source. The default
     * is OneTable.
     *
     * @return the dataSchema value.
     */
    @Generated
    public DataSchema getDataSchema() {
        return this.dataSchema;
    }

    /**
     * Set the dataSchema property: Data schema of the input data source. The default
     * is OneTable.
     *
     * @param dataSchema the dataSchema value to set.
     * @return the ModelInfo object itself.
     */
    @Generated
    public ModelInfo setDataSchema(DataSchema dataSchema) {
        this.dataSchema = dataSchema;
        return this;
    }

    /**
     * Get the startTime property: Start date/time of training data, which should be
     * in ISO 8601 format.
     *
     * @return the startTime value.
     */
    @Generated
    public OffsetDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Get the endTime property: End date/time of training data, which should be
     * in ISO 8601 format.
     *
     * @return the endTime value.
     */
    @Generated
    public OffsetDateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Get the displayName property: Display name of the model. Maximum length is 24
     * characters.
     *
     * @return the displayName value.
     */
    @Generated
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Display name of the model. Maximum length is 24
     * characters.
     *
     * @param displayName the displayName value to set.
     * @return the ModelInfo object itself.
     */
    @Generated
    public ModelInfo setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the slidingWindow property: Number of previous time stamps that will be used to
     * detect whether the time stamp is an anomaly or not.
     *
     * @return the slidingWindow value.
     */
    @Generated
    public Integer getSlidingWindow() {
        return this.slidingWindow;
    }

    /**
     * Set the slidingWindow property: Number of previous time stamps that will be used to
     * detect whether the time stamp is an anomaly or not.
     *
     * @param slidingWindow the slidingWindow value to set.
     * @return the ModelInfo object itself.
     */
    @Generated
    public ModelInfo setSlidingWindow(Integer slidingWindow) {
        this.slidingWindow = slidingWindow;
        return this;
    }

    /**
     * Get the alignPolicy property: Manner of aligning multiple variables.
     *
     * @return the alignPolicy value.
     */
    @Generated
    public AlignPolicy getAlignPolicy() {
        return this.alignPolicy;
    }

    /**
     * Set the alignPolicy property: Manner of aligning multiple variables.
     *
     * @param alignPolicy the alignPolicy value to set.
     * @return the ModelInfo object itself.
     */
    @Generated
    public ModelInfo setAlignPolicy(AlignPolicy alignPolicy) {
        this.alignPolicy = alignPolicy;
        return this;
    }

    /**
     * Get the status property: Model status.
     *
     * @return the status value.
     */
    @Generated
    public ModelStatus getStatus() {
        return this.status;
    }

    /**
     * Get the errors property: Error messages after failure to create a model.
     *
     * @return the errors value.
     */
    @Generated
    public List<ErrorResponse> getErrors() {
        return this.errors;
    }

    /**
     * Get the diagnosticsInfo property: Diagnostics information to help inspect the states of a model or variable.
     *
     * @return the diagnosticsInfo value.
     */
    @Generated
    public DiagnosticsInfo getDiagnosticsInfo() {
        return this.diagnosticsInfo;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("dataSource", this.dataSource);
        jsonWriter.writeStringField("startTime",
            this.startTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.startTime));
        jsonWriter.writeStringField("endTime",
            this.endTime == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.endTime));
        jsonWriter.writeStringField("dataSchema", this.dataSchema == null ? null : this.dataSchema.toString());
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeNumberField("slidingWindow", this.slidingWindow);
        jsonWriter.writeJsonField("alignPolicy", this.alignPolicy);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ModelInfo from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ModelInfo if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ModelInfo.
     */
    @Generated
    public static ModelInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String dataSource = null;
            OffsetDateTime startTime = null;
            OffsetDateTime endTime = null;
            DataSchema dataSchema = null;
            String displayName = null;
            Integer slidingWindow = null;
            AlignPolicy alignPolicy = null;
            ModelStatus status = null;
            List<ErrorResponse> errors = null;
            DiagnosticsInfo diagnosticsInfo = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("dataSource".equals(fieldName)) {
                    dataSource = reader.getString();
                } else if ("startTime".equals(fieldName)) {
                    startTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("endTime".equals(fieldName)) {
                    endTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("dataSchema".equals(fieldName)) {
                    dataSchema = DataSchema.fromString(reader.getString());
                } else if ("displayName".equals(fieldName)) {
                    displayName = reader.getString();
                } else if ("slidingWindow".equals(fieldName)) {
                    slidingWindow = reader.getNullable(JsonReader::getInt);
                } else if ("alignPolicy".equals(fieldName)) {
                    alignPolicy = AlignPolicy.fromJson(reader);
                } else if ("status".equals(fieldName)) {
                    status = ModelStatus.fromString(reader.getString());
                } else if ("errors".equals(fieldName)) {
                    errors = reader.readArray(reader1 -> ErrorResponse.fromJson(reader1));
                } else if ("diagnosticsInfo".equals(fieldName)) {
                    diagnosticsInfo = DiagnosticsInfo.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            ModelInfo deserializedModelInfo = new ModelInfo(dataSource, startTime, endTime);
            deserializedModelInfo.dataSchema = dataSchema;
            deserializedModelInfo.displayName = displayName;
            deserializedModelInfo.slidingWindow = slidingWindow;
            deserializedModelInfo.alignPolicy = alignPolicy;
            deserializedModelInfo.status = status;
            deserializedModelInfo.errors = errors;
            deserializedModelInfo.diagnosticsInfo = diagnosticsInfo;
            return deserializedModelInfo;
        });
    }
}
