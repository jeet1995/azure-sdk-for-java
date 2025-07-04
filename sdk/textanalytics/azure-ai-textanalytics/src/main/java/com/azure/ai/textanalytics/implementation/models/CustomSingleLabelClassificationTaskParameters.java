// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Supported parameters for a Custom Single Classification task.
 */
@Fluent
public final class CustomSingleLabelClassificationTaskParameters extends CustomTaskParameters {
    /**
     * Creates an instance of CustomSingleLabelClassificationTaskParameters class.
     */
    @Generated
    public CustomSingleLabelClassificationTaskParameters() {
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CustomSingleLabelClassificationTaskParameters setProjectName(String projectName) {
        super.setProjectName(projectName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CustomSingleLabelClassificationTaskParameters setDeploymentName(String deploymentName) {
        super.setDeploymentName(deploymentName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public CustomSingleLabelClassificationTaskParameters setLoggingOptOut(Boolean loggingOptOut) {
        super.setLoggingOptOut(loggingOptOut);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("projectName", getProjectName());
        jsonWriter.writeStringField("deploymentName", getDeploymentName());
        jsonWriter.writeBooleanField("loggingOptOut", isLoggingOptOut());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CustomSingleLabelClassificationTaskParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CustomSingleLabelClassificationTaskParameters if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CustomSingleLabelClassificationTaskParameters.
     */
    @Generated
    public static CustomSingleLabelClassificationTaskParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CustomSingleLabelClassificationTaskParameters deserializedCustomSingleLabelClassificationTaskParameters
                = new CustomSingleLabelClassificationTaskParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("projectName".equals(fieldName)) {
                    deserializedCustomSingleLabelClassificationTaskParameters.setProjectName(reader.getString());
                } else if ("deploymentName".equals(fieldName)) {
                    deserializedCustomSingleLabelClassificationTaskParameters.setDeploymentName(reader.getString());
                } else if ("loggingOptOut".equals(fieldName)) {
                    deserializedCustomSingleLabelClassificationTaskParameters
                        .setLoggingOptOut(reader.getNullable(JsonReader::getBoolean));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCustomSingleLabelClassificationTaskParameters;
        });
    }
}
