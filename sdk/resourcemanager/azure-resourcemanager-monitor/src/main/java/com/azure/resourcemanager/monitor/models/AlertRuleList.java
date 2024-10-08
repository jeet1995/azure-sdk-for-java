// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.monitor.fluent.models.ActivityLogAlertResourceInner;
import java.io.IOException;
import java.util.List;

/**
 * A list of Activity Log Alert rules.
 */
@Fluent
public final class AlertRuleList implements JsonSerializable<AlertRuleList> {
    /*
     * The list of Activity Log Alert rules.
     */
    private List<ActivityLogAlertResourceInner> value;

    /*
     * Provides the link to retrieve the next set of elements.
     */
    private String nextLink;

    /**
     * Creates an instance of AlertRuleList class.
     */
    public AlertRuleList() {
    }

    /**
     * Get the value property: The list of Activity Log Alert rules.
     * 
     * @return the value value.
     */
    public List<ActivityLogAlertResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of Activity Log Alert rules.
     * 
     * @param value the value value to set.
     * @return the AlertRuleList object itself.
     */
    public AlertRuleList withValue(List<ActivityLogAlertResourceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Provides the link to retrieve the next set of elements.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Provides the link to retrieve the next set of elements.
     * 
     * @param nextLink the nextLink value to set.
     * @return the AlertRuleList object itself.
     */
    public AlertRuleList withNextLink(String nextLink) {
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
     * Reads an instance of AlertRuleList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AlertRuleList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AlertRuleList.
     */
    public static AlertRuleList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AlertRuleList deserializedAlertRuleList = new AlertRuleList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ActivityLogAlertResourceInner> value
                        = reader.readArray(reader1 -> ActivityLogAlertResourceInner.fromJson(reader1));
                    deserializedAlertRuleList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedAlertRuleList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAlertRuleList;
        });
    }
}
