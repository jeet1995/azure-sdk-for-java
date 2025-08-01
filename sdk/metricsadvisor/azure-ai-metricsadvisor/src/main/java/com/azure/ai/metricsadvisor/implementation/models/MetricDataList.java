// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The MetricDataList model.
 */
@Immutable
public final class MetricDataList implements JsonSerializable<MetricDataList> {
    /*
     * The value property.
     */
    @Generated
    private List<MetricSeriesData> value;

    /**
     * Creates an instance of MetricDataList class.
     */
    @Generated
    public MetricDataList() {
    }

    /**
     * Get the value property: The value property.
     * 
     * @return the value value.
     */
    @Generated
    public List<MetricSeriesData> getValue() {
        return this.value;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricDataList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricDataList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetricDataList.
     */
    @Generated
    public static MetricDataList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MetricDataList deserializedMetricDataList = new MetricDataList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<MetricSeriesData> value = reader.readArray(reader1 -> MetricSeriesData.fromJson(reader1));
                    deserializedMetricDataList.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMetricDataList;
        });
    }
}
