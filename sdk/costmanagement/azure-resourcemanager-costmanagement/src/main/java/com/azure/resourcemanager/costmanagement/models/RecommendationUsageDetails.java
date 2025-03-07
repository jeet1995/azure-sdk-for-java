// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * On-demand charges between firstConsumptionDate and lastConsumptionDate that were used for computing benefit
 * recommendations.
 */
@Fluent
public final class RecommendationUsageDetails implements JsonSerializable<RecommendationUsageDetails> {
    /*
     * The grain of the usage. Supported values: 'Hourly'
     */
    private Grain usageGrain;

    /*
     * On-demand charges for each hour between firstConsumptionDate and lastConsumptionDate that were used for computing
     * benefit recommendations.
     */
    private List<BigDecimal> charges;

    /**
     * Creates an instance of RecommendationUsageDetails class.
     */
    public RecommendationUsageDetails() {
    }

    /**
     * Get the usageGrain property: The grain of the usage. Supported values: 'Hourly'.
     * 
     * @return the usageGrain value.
     */
    public Grain usageGrain() {
        return this.usageGrain;
    }

    /**
     * Set the usageGrain property: The grain of the usage. Supported values: 'Hourly'.
     * 
     * @param usageGrain the usageGrain value to set.
     * @return the RecommendationUsageDetails object itself.
     */
    public RecommendationUsageDetails withUsageGrain(Grain usageGrain) {
        this.usageGrain = usageGrain;
        return this;
    }

    /**
     * Get the charges property: On-demand charges for each hour between firstConsumptionDate and lastConsumptionDate
     * that were used for computing benefit recommendations.
     * 
     * @return the charges value.
     */
    public List<BigDecimal> charges() {
        return this.charges;
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
        jsonWriter.writeStringField("usageGrain", this.usageGrain == null ? null : this.usageGrain.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecommendationUsageDetails from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecommendationUsageDetails if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RecommendationUsageDetails.
     */
    public static RecommendationUsageDetails fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RecommendationUsageDetails deserializedRecommendationUsageDetails = new RecommendationUsageDetails();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("usageGrain".equals(fieldName)) {
                    deserializedRecommendationUsageDetails.usageGrain = Grain.fromString(reader.getString());
                } else if ("charges".equals(fieldName)) {
                    List<BigDecimal> charges = reader.readArray(
                        reader1 -> reader1.getNullable(nonNullReader -> new BigDecimal(nonNullReader.getString())));
                    deserializedRecommendationUsageDetails.charges = charges;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecommendationUsageDetails;
        });
    }
}
