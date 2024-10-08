// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Target lags rolling window determined automatically.
 */
@Immutable
public final class AutoTargetRollingWindowSize extends TargetRollingWindowSize {
    /*
     * [Required] TargetRollingWindowSiz detection mode.
     */
    private TargetRollingWindowSizeMode mode = TargetRollingWindowSizeMode.AUTO;

    /**
     * Creates an instance of AutoTargetRollingWindowSize class.
     */
    public AutoTargetRollingWindowSize() {
    }

    /**
     * Get the mode property: [Required] TargetRollingWindowSiz detection mode.
     * 
     * @return the mode value.
     */
    @Override
    public TargetRollingWindowSizeMode mode() {
        return this.mode;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("mode", this.mode == null ? null : this.mode.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutoTargetRollingWindowSize from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutoTargetRollingWindowSize if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AutoTargetRollingWindowSize.
     */
    public static AutoTargetRollingWindowSize fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutoTargetRollingWindowSize deserializedAutoTargetRollingWindowSize = new AutoTargetRollingWindowSize();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("mode".equals(fieldName)) {
                    deserializedAutoTargetRollingWindowSize.mode
                        = TargetRollingWindowSizeMode.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutoTargetRollingWindowSize;
        });
    }
}
