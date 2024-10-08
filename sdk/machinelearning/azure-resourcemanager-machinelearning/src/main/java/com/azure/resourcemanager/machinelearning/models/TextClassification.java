// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Text Classification task in AutoML NLP vertical.
 * NLP - Natural Language Processing.
 */
@Fluent
public final class TextClassification extends AutoMLVertical {
    /*
     * [Required] Task type for AutoMLJob.
     */
    private TaskType taskType = TaskType.TEXT_CLASSIFICATION;

    /*
     * Primary metric for Text-Classification task.
     */
    private ClassificationPrimaryMetrics primaryMetric;

    /*
     * Execution constraints for AutoMLJob.
     */
    private NlpVerticalLimitSettings limitSettings;

    /*
     * Featurization inputs needed for AutoML job.
     */
    private NlpVerticalFeaturizationSettings featurizationSettings;

    /*
     * Validation data inputs.
     */
    private MLTableJobInput validationData;

    /**
     * Creates an instance of TextClassification class.
     */
    public TextClassification() {
    }

    /**
     * Get the taskType property: [Required] Task type for AutoMLJob.
     * 
     * @return the taskType value.
     */
    @Override
    public TaskType taskType() {
        return this.taskType;
    }

    /**
     * Get the primaryMetric property: Primary metric for Text-Classification task.
     * 
     * @return the primaryMetric value.
     */
    public ClassificationPrimaryMetrics primaryMetric() {
        return this.primaryMetric;
    }

    /**
     * Set the primaryMetric property: Primary metric for Text-Classification task.
     * 
     * @param primaryMetric the primaryMetric value to set.
     * @return the TextClassification object itself.
     */
    public TextClassification withPrimaryMetric(ClassificationPrimaryMetrics primaryMetric) {
        this.primaryMetric = primaryMetric;
        return this;
    }

    /**
     * Get the limitSettings property: Execution constraints for AutoMLJob.
     * 
     * @return the limitSettings value.
     */
    public NlpVerticalLimitSettings limitSettings() {
        return this.limitSettings;
    }

    /**
     * Set the limitSettings property: Execution constraints for AutoMLJob.
     * 
     * @param limitSettings the limitSettings value to set.
     * @return the TextClassification object itself.
     */
    public TextClassification withLimitSettings(NlpVerticalLimitSettings limitSettings) {
        this.limitSettings = limitSettings;
        return this;
    }

    /**
     * Get the featurizationSettings property: Featurization inputs needed for AutoML job.
     * 
     * @return the featurizationSettings value.
     */
    public NlpVerticalFeaturizationSettings featurizationSettings() {
        return this.featurizationSettings;
    }

    /**
     * Set the featurizationSettings property: Featurization inputs needed for AutoML job.
     * 
     * @param featurizationSettings the featurizationSettings value to set.
     * @return the TextClassification object itself.
     */
    public TextClassification withFeaturizationSettings(NlpVerticalFeaturizationSettings featurizationSettings) {
        this.featurizationSettings = featurizationSettings;
        return this;
    }

    /**
     * Get the validationData property: Validation data inputs.
     * 
     * @return the validationData value.
     */
    public MLTableJobInput validationData() {
        return this.validationData;
    }

    /**
     * Set the validationData property: Validation data inputs.
     * 
     * @param validationData the validationData value to set.
     * @return the TextClassification object itself.
     */
    public TextClassification withValidationData(MLTableJobInput validationData) {
        this.validationData = validationData;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextClassification withLogVerbosity(LogVerbosity logVerbosity) {
        super.withLogVerbosity(logVerbosity);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextClassification withTrainingData(MLTableJobInput trainingData) {
        super.withTrainingData(trainingData);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TextClassification withTargetColumnName(String targetColumnName) {
        super.withTargetColumnName(targetColumnName);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (limitSettings() != null) {
            limitSettings().validate();
        }
        if (featurizationSettings() != null) {
            featurizationSettings().validate();
        }
        if (validationData() != null) {
            validationData().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("trainingData", trainingData());
        jsonWriter.writeStringField("logVerbosity", logVerbosity() == null ? null : logVerbosity().toString());
        jsonWriter.writeStringField("targetColumnName", targetColumnName());
        jsonWriter.writeStringField("taskType", this.taskType == null ? null : this.taskType.toString());
        jsonWriter.writeStringField("primaryMetric", this.primaryMetric == null ? null : this.primaryMetric.toString());
        jsonWriter.writeJsonField("limitSettings", this.limitSettings);
        jsonWriter.writeJsonField("featurizationSettings", this.featurizationSettings);
        jsonWriter.writeJsonField("validationData", this.validationData);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TextClassification from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TextClassification if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TextClassification.
     */
    public static TextClassification fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TextClassification deserializedTextClassification = new TextClassification();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("trainingData".equals(fieldName)) {
                    deserializedTextClassification.withTrainingData(MLTableJobInput.fromJson(reader));
                } else if ("logVerbosity".equals(fieldName)) {
                    deserializedTextClassification.withLogVerbosity(LogVerbosity.fromString(reader.getString()));
                } else if ("targetColumnName".equals(fieldName)) {
                    deserializedTextClassification.withTargetColumnName(reader.getString());
                } else if ("taskType".equals(fieldName)) {
                    deserializedTextClassification.taskType = TaskType.fromString(reader.getString());
                } else if ("primaryMetric".equals(fieldName)) {
                    deserializedTextClassification.primaryMetric
                        = ClassificationPrimaryMetrics.fromString(reader.getString());
                } else if ("limitSettings".equals(fieldName)) {
                    deserializedTextClassification.limitSettings = NlpVerticalLimitSettings.fromJson(reader);
                } else if ("featurizationSettings".equals(fieldName)) {
                    deserializedTextClassification.featurizationSettings
                        = NlpVerticalFeaturizationSettings.fromJson(reader);
                } else if ("validationData".equals(fieldName)) {
                    deserializedTextClassification.validationData = MLTableJobInput.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTextClassification;
        });
    }
}
