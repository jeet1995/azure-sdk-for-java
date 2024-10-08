// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * A list pipeline runs.
 */
@Fluent
public final class PipelineRunsQueryResponseInner implements JsonSerializable<PipelineRunsQueryResponseInner> {
    /*
     * List of pipeline runs.
     */
    private List<PipelineRunInner> value;

    /*
     * The continuation token for getting the next page of results, if any remaining results exist, null otherwise.
     */
    private String continuationToken;

    /**
     * Creates an instance of PipelineRunsQueryResponseInner class.
     */
    public PipelineRunsQueryResponseInner() {
    }

    /**
     * Get the value property: List of pipeline runs.
     * 
     * @return the value value.
     */
    public List<PipelineRunInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of pipeline runs.
     * 
     * @param value the value value to set.
     * @return the PipelineRunsQueryResponseInner object itself.
     */
    public PipelineRunsQueryResponseInner withValue(List<PipelineRunInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the continuationToken property: The continuation token for getting the next page of results, if any remaining
     * results exist, null otherwise.
     * 
     * @return the continuationToken value.
     */
    public String continuationToken() {
        return this.continuationToken;
    }

    /**
     * Set the continuationToken property: The continuation token for getting the next page of results, if any remaining
     * results exist, null otherwise.
     * 
     * @param continuationToken the continuationToken value to set.
     * @return the PipelineRunsQueryResponseInner object itself.
     */
    public PipelineRunsQueryResponseInner withContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property value in model PipelineRunsQueryResponseInner"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PipelineRunsQueryResponseInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("continuationToken", this.continuationToken);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PipelineRunsQueryResponseInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PipelineRunsQueryResponseInner if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PipelineRunsQueryResponseInner.
     */
    public static PipelineRunsQueryResponseInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PipelineRunsQueryResponseInner deserializedPipelineRunsQueryResponseInner
                = new PipelineRunsQueryResponseInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<PipelineRunInner> value = reader.readArray(reader1 -> PipelineRunInner.fromJson(reader1));
                    deserializedPipelineRunsQueryResponseInner.value = value;
                } else if ("continuationToken".equals(fieldName)) {
                    deserializedPipelineRunsQueryResponseInner.continuationToken = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPipelineRunsQueryResponseInner;
        });
    }
}
