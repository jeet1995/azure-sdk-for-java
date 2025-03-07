// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.automation.fluent.models.DscNodeReportInner;
import java.io.IOException;
import java.util.List;

/**
 * The response model for the list dsc nodes operation.
 */
@Fluent
public final class DscNodeReportListResult implements JsonSerializable<DscNodeReportListResult> {
    /*
     * Gets or sets a list of dsc node reports.
     */
    private List<DscNodeReportInner> value;

    /*
     * Gets or sets the next link.
     */
    private String nextLink;

    /**
     * Creates an instance of DscNodeReportListResult class.
     */
    public DscNodeReportListResult() {
    }

    /**
     * Get the value property: Gets or sets a list of dsc node reports.
     * 
     * @return the value value.
     */
    public List<DscNodeReportInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Gets or sets a list of dsc node reports.
     * 
     * @param value the value value to set.
     * @return the DscNodeReportListResult object itself.
     */
    public DscNodeReportListResult withValue(List<DscNodeReportInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Gets or sets the next link.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Gets or sets the next link.
     * 
     * @param nextLink the nextLink value to set.
     * @return the DscNodeReportListResult object itself.
     */
    public DscNodeReportListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DscNodeReportListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DscNodeReportListResult if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DscNodeReportListResult.
     */
    public static DscNodeReportListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DscNodeReportListResult deserializedDscNodeReportListResult = new DscNodeReportListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<DscNodeReportInner> value = reader.readArray(reader1 -> DscNodeReportInner.fromJson(reader1));
                    deserializedDscNodeReportListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedDscNodeReportListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDscNodeReportListResult;
        });
    }
}
