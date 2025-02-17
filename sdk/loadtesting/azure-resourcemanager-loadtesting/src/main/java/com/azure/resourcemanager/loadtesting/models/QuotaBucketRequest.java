// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loadtesting.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.loadtesting.fluent.models.QuotaBucketRequestProperties;
import java.io.IOException;

/**
 * Request object of new quota for a quota bucket.
 */
@Fluent
public final class QuotaBucketRequest implements JsonSerializable<QuotaBucketRequest> {
    /*
     * Request object of new quota for a quota bucket.
     */
    private QuotaBucketRequestProperties innerProperties;

    /**
     * Creates an instance of QuotaBucketRequest class.
     */
    public QuotaBucketRequest() {
    }

    /**
     * Get the innerProperties property: Request object of new quota for a quota bucket.
     * 
     * @return the innerProperties value.
     */
    private QuotaBucketRequestProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the currentUsage property: Current quota usage of the quota bucket.
     * 
     * @return the currentUsage value.
     */
    public Integer currentUsage() {
        return this.innerProperties() == null ? null : this.innerProperties().currentUsage();
    }

    /**
     * Set the currentUsage property: Current quota usage of the quota bucket.
     * 
     * @param currentUsage the currentUsage value to set.
     * @return the QuotaBucketRequest object itself.
     */
    public QuotaBucketRequest withCurrentUsage(Integer currentUsage) {
        if (this.innerProperties() == null) {
            this.innerProperties = new QuotaBucketRequestProperties();
        }
        this.innerProperties().withCurrentUsage(currentUsage);
        return this;
    }

    /**
     * Get the currentQuota property: Current quota limit of the quota bucket.
     * 
     * @return the currentQuota value.
     */
    public Integer currentQuota() {
        return this.innerProperties() == null ? null : this.innerProperties().currentQuota();
    }

    /**
     * Set the currentQuota property: Current quota limit of the quota bucket.
     * 
     * @param currentQuota the currentQuota value to set.
     * @return the QuotaBucketRequest object itself.
     */
    public QuotaBucketRequest withCurrentQuota(Integer currentQuota) {
        if (this.innerProperties() == null) {
            this.innerProperties = new QuotaBucketRequestProperties();
        }
        this.innerProperties().withCurrentQuota(currentQuota);
        return this;
    }

    /**
     * Get the newQuota property: New quota limit of the quota bucket.
     * 
     * @return the newQuota value.
     */
    public Integer newQuota() {
        return this.innerProperties() == null ? null : this.innerProperties().newQuota();
    }

    /**
     * Set the newQuota property: New quota limit of the quota bucket.
     * 
     * @param newQuota the newQuota value to set.
     * @return the QuotaBucketRequest object itself.
     */
    public QuotaBucketRequest withNewQuota(Integer newQuota) {
        if (this.innerProperties() == null) {
            this.innerProperties = new QuotaBucketRequestProperties();
        }
        this.innerProperties().withNewQuota(newQuota);
        return this;
    }

    /**
     * Get the dimensions property: Dimensions for new quota request.
     * 
     * @return the dimensions value.
     */
    public QuotaBucketRequestPropertiesDimensions dimensions() {
        return this.innerProperties() == null ? null : this.innerProperties().dimensions();
    }

    /**
     * Set the dimensions property: Dimensions for new quota request.
     * 
     * @param dimensions the dimensions value to set.
     * @return the QuotaBucketRequest object itself.
     */
    public QuotaBucketRequest withDimensions(QuotaBucketRequestPropertiesDimensions dimensions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new QuotaBucketRequestProperties();
        }
        this.innerProperties().withDimensions(dimensions);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of QuotaBucketRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of QuotaBucketRequest if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the QuotaBucketRequest.
     */
    public static QuotaBucketRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            QuotaBucketRequest deserializedQuotaBucketRequest = new QuotaBucketRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedQuotaBucketRequest.innerProperties = QuotaBucketRequestProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedQuotaBucketRequest;
        });
    }
}
