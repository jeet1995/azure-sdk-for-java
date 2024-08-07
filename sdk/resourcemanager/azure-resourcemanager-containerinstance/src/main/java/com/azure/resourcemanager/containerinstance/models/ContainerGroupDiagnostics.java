// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerinstance.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Container group diagnostic information.
 */
@Fluent
public final class ContainerGroupDiagnostics implements JsonSerializable<ContainerGroupDiagnostics> {
    /*
     * Container group log analytics information.
     */
    private LogAnalytics logAnalytics;

    /**
     * Creates an instance of ContainerGroupDiagnostics class.
     */
    public ContainerGroupDiagnostics() {
    }

    /**
     * Get the logAnalytics property: Container group log analytics information.
     * 
     * @return the logAnalytics value.
     */
    public LogAnalytics logAnalytics() {
        return this.logAnalytics;
    }

    /**
     * Set the logAnalytics property: Container group log analytics information.
     * 
     * @param logAnalytics the logAnalytics value to set.
     * @return the ContainerGroupDiagnostics object itself.
     */
    public ContainerGroupDiagnostics withLogAnalytics(LogAnalytics logAnalytics) {
        this.logAnalytics = logAnalytics;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (logAnalytics() != null) {
            logAnalytics().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("logAnalytics", this.logAnalytics);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ContainerGroupDiagnostics from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ContainerGroupDiagnostics if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ContainerGroupDiagnostics.
     */
    public static ContainerGroupDiagnostics fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ContainerGroupDiagnostics deserializedContainerGroupDiagnostics = new ContainerGroupDiagnostics();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("logAnalytics".equals(fieldName)) {
                    deserializedContainerGroupDiagnostics.logAnalytics = LogAnalytics.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedContainerGroupDiagnostics;
        });
    }
}
