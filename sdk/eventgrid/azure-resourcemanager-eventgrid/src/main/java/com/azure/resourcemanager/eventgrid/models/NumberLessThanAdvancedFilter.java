// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * NumberLessThan Advanced Filter.
 */
@Fluent
public final class NumberLessThanAdvancedFilter extends AdvancedFilter {
    /*
     * The operator type used for filtering, e.g., NumberIn, StringContains, BoolEquals and others.
     */
    private AdvancedFilterOperatorType operatorType = AdvancedFilterOperatorType.NUMBER_LESS_THAN;

    /*
     * The filter value.
     */
    private Double value;

    /**
     * Creates an instance of NumberLessThanAdvancedFilter class.
     */
    public NumberLessThanAdvancedFilter() {
    }

    /**
     * Get the operatorType property: The operator type used for filtering, e.g., NumberIn, StringContains, BoolEquals
     * and others.
     * 
     * @return the operatorType value.
     */
    @Override
    public AdvancedFilterOperatorType operatorType() {
        return this.operatorType;
    }

    /**
     * Get the value property: The filter value.
     * 
     * @return the value value.
     */
    public Double value() {
        return this.value;
    }

    /**
     * Set the value property: The filter value.
     * 
     * @param value the value value to set.
     * @return the NumberLessThanAdvancedFilter object itself.
     */
    public NumberLessThanAdvancedFilter withValue(Double value) {
        this.value = value;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberLessThanAdvancedFilter withKey(String key) {
        super.withKey(key);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("key", key());
        jsonWriter.writeStringField("operatorType", this.operatorType == null ? null : this.operatorType.toString());
        jsonWriter.writeNumberField("value", this.value);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NumberLessThanAdvancedFilter from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NumberLessThanAdvancedFilter if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the NumberLessThanAdvancedFilter.
     */
    public static NumberLessThanAdvancedFilter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NumberLessThanAdvancedFilter deserializedNumberLessThanAdvancedFilter = new NumberLessThanAdvancedFilter();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("key".equals(fieldName)) {
                    deserializedNumberLessThanAdvancedFilter.withKey(reader.getString());
                } else if ("operatorType".equals(fieldName)) {
                    deserializedNumberLessThanAdvancedFilter.operatorType
                        = AdvancedFilterOperatorType.fromString(reader.getString());
                } else if ("value".equals(fieldName)) {
                    deserializedNumberLessThanAdvancedFilter.value = reader.getNullable(JsonReader::getDouble);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNumberLessThanAdvancedFilter;
        });
    }
}
