// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Contains error information for an Azure SQL Database, Server or Elastic Pool Recommended Action.
 */
@Immutable
public final class RecommendedActionErrorInfo implements JsonSerializable<RecommendedActionErrorInfo> {
    /*
     * Gets the reason why the recommended action was put to error state. e.g., DatabaseHasQdsOff, IndexAlreadyExists
     */
    private String errorCode;

    /*
     * Gets whether the error could be ignored and recommended action could be retried. Possible values are: Yes/No
     */
    private IsRetryable isRetryable;

    /**
     * Creates an instance of RecommendedActionErrorInfo class.
     */
    public RecommendedActionErrorInfo() {
    }

    /**
     * Get the errorCode property: Gets the reason why the recommended action was put to error state. e.g.,
     * DatabaseHasQdsOff, IndexAlreadyExists.
     * 
     * @return the errorCode value.
     */
    public String errorCode() {
        return this.errorCode;
    }

    /**
     * Get the isRetryable property: Gets whether the error could be ignored and recommended action could be retried.
     * Possible values are: Yes/No.
     * 
     * @return the isRetryable value.
     */
    public IsRetryable isRetryable() {
        return this.isRetryable;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecommendedActionErrorInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecommendedActionErrorInfo if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RecommendedActionErrorInfo.
     */
    public static RecommendedActionErrorInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RecommendedActionErrorInfo deserializedRecommendedActionErrorInfo = new RecommendedActionErrorInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("errorCode".equals(fieldName)) {
                    deserializedRecommendedActionErrorInfo.errorCode = reader.getString();
                } else if ("isRetryable".equals(fieldName)) {
                    deserializedRecommendedActionErrorInfo.isRetryable = IsRetryable.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecommendedActionErrorInfo;
        });
    }
}
