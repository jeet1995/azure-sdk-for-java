// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * DataflowProfile Resource properties.
 */
@Fluent
public final class DataflowProfileProperties implements JsonSerializable<DataflowProfileProperties> {
    /*
     * Spec defines the desired identities of NBC diagnostics settings.
     */
    private ProfileDiagnostics diagnostics;

    /*
     * To manually scale the dataflow profile, specify the maximum number of instances you want to run.
     */
    private Integer instanceCount;

    /*
     * The status of the last operation.
     */
    private ProvisioningState provisioningState;

    /**
     * Creates an instance of DataflowProfileProperties class.
     */
    public DataflowProfileProperties() {
    }

    /**
     * Get the diagnostics property: Spec defines the desired identities of NBC diagnostics settings.
     * 
     * @return the diagnostics value.
     */
    public ProfileDiagnostics diagnostics() {
        return this.diagnostics;
    }

    /**
     * Set the diagnostics property: Spec defines the desired identities of NBC diagnostics settings.
     * 
     * @param diagnostics the diagnostics value to set.
     * @return the DataflowProfileProperties object itself.
     */
    public DataflowProfileProperties withDiagnostics(ProfileDiagnostics diagnostics) {
        this.diagnostics = diagnostics;
        return this;
    }

    /**
     * Get the instanceCount property: To manually scale the dataflow profile, specify the maximum number of instances
     * you want to run.
     * 
     * @return the instanceCount value.
     */
    public Integer instanceCount() {
        return this.instanceCount;
    }

    /**
     * Set the instanceCount property: To manually scale the dataflow profile, specify the maximum number of instances
     * you want to run.
     * 
     * @param instanceCount the instanceCount value to set.
     * @return the DataflowProfileProperties object itself.
     */
    public DataflowProfileProperties withInstanceCount(Integer instanceCount) {
        this.instanceCount = instanceCount;
        return this;
    }

    /**
     * Get the provisioningState property: The status of the last operation.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (diagnostics() != null) {
            diagnostics().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("diagnostics", this.diagnostics);
        jsonWriter.writeNumberField("instanceCount", this.instanceCount);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DataflowProfileProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DataflowProfileProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DataflowProfileProperties.
     */
    public static DataflowProfileProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DataflowProfileProperties deserializedDataflowProfileProperties = new DataflowProfileProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("diagnostics".equals(fieldName)) {
                    deserializedDataflowProfileProperties.diagnostics = ProfileDiagnostics.fromJson(reader);
                } else if ("instanceCount".equals(fieldName)) {
                    deserializedDataflowProfileProperties.instanceCount = reader.getNullable(JsonReader::getInt);
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedDataflowProfileProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDataflowProfileProperties;
        });
    }
}
