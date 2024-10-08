// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.batch.fluent.models.ApplicationPackageInner;
import java.io.IOException;
import java.util.List;

/**
 * The result of performing list application packages.
 */
@Fluent
public final class ListApplicationPackagesResult implements JsonSerializable<ListApplicationPackagesResult> {
    /*
     * The list of application packages.
     */
    private List<ApplicationPackageInner> value;

    /*
     * The URL to get the next set of results.
     */
    private String nextLink;

    /**
     * Creates an instance of ListApplicationPackagesResult class.
     */
    public ListApplicationPackagesResult() {
    }

    /**
     * Get the value property: The list of application packages.
     * 
     * @return the value value.
     */
    public List<ApplicationPackageInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of application packages.
     * 
     * @param value the value value to set.
     * @return the ListApplicationPackagesResult object itself.
     */
    public ListApplicationPackagesResult withValue(List<ApplicationPackageInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URL to get the next set of results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URL to get the next set of results.
     * 
     * @param nextLink the nextLink value to set.
     * @return the ListApplicationPackagesResult object itself.
     */
    public ListApplicationPackagesResult withNextLink(String nextLink) {
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
     * Reads an instance of ListApplicationPackagesResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ListApplicationPackagesResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ListApplicationPackagesResult.
     */
    public static ListApplicationPackagesResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ListApplicationPackagesResult deserializedListApplicationPackagesResult
                = new ListApplicationPackagesResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ApplicationPackageInner> value
                        = reader.readArray(reader1 -> ApplicationPackageInner.fromJson(reader1));
                    deserializedListApplicationPackagesResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedListApplicationPackagesResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedListApplicationPackagesResult;
        });
    }
}
