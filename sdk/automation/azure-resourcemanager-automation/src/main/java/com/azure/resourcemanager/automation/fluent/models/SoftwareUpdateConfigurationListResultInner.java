// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.automation.models.SoftwareUpdateConfigurationCollectionItem;
import java.io.IOException;
import java.util.List;

/**
 * result of listing all software update configuration.
 */
@Fluent
public final class SoftwareUpdateConfigurationListResultInner
    implements JsonSerializable<SoftwareUpdateConfigurationListResultInner> {
    /*
     * outer object returned when listing all software update configurations
     */
    private List<SoftwareUpdateConfigurationCollectionItem> value;

    /**
     * Creates an instance of SoftwareUpdateConfigurationListResultInner class.
     */
    public SoftwareUpdateConfigurationListResultInner() {
    }

    /**
     * Get the value property: outer object returned when listing all software update configurations.
     * 
     * @return the value value.
     */
    public List<SoftwareUpdateConfigurationCollectionItem> value() {
        return this.value;
    }

    /**
     * Set the value property: outer object returned when listing all software update configurations.
     * 
     * @param value the value value to set.
     * @return the SoftwareUpdateConfigurationListResultInner object itself.
     */
    public SoftwareUpdateConfigurationListResultInner withValue(List<SoftwareUpdateConfigurationCollectionItem> value) {
        this.value = value;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SoftwareUpdateConfigurationListResultInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SoftwareUpdateConfigurationListResultInner if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SoftwareUpdateConfigurationListResultInner.
     */
    public static SoftwareUpdateConfigurationListResultInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SoftwareUpdateConfigurationListResultInner deserializedSoftwareUpdateConfigurationListResultInner
                = new SoftwareUpdateConfigurationListResultInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<SoftwareUpdateConfigurationCollectionItem> value
                        = reader.readArray(reader1 -> SoftwareUpdateConfigurationCollectionItem.fromJson(reader1));
                    deserializedSoftwareUpdateConfigurationListResultInner.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSoftwareUpdateConfigurationListResultInner;
        });
    }
}
