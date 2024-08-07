// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.containerservice.fluent.models.ManagedClusterInner;
import java.io.IOException;
import java.util.List;

/**
 * The response from the List Managed Clusters operation.
 */
@Fluent
public final class ManagedClusterListResult implements JsonSerializable<ManagedClusterListResult> {
    /*
     * The list of managed clusters.
     */
    private List<ManagedClusterInner> value;

    /*
     * The URL to get the next set of managed cluster results.
     */
    private String nextLink;

    /**
     * Creates an instance of ManagedClusterListResult class.
     */
    public ManagedClusterListResult() {
    }

    /**
     * Get the value property: The list of managed clusters.
     * 
     * @return the value value.
     */
    public List<ManagedClusterInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of managed clusters.
     * 
     * @param value the value value to set.
     * @return the ManagedClusterListResult object itself.
     */
    public ManagedClusterListResult withValue(List<ManagedClusterInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to get the next set of managed cluster results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagedClusterListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagedClusterListResult if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ManagedClusterListResult.
     */
    public static ManagedClusterListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagedClusterListResult deserializedManagedClusterListResult = new ManagedClusterListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ManagedClusterInner> value
                        = reader.readArray(reader1 -> ManagedClusterInner.fromJson(reader1));
                    deserializedManagedClusterListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedManagedClusterListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagedClusterListResult;
        });
    }
}
