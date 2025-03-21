// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.support.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Details about an Azure service available for support ticket creation.
 */
@Fluent
public final class ServiceProperties implements JsonSerializable<ServiceProperties> {
    /*
     * Localized name of the Azure service.
     */
    private String displayName;

    /*
     * ARM Resource types.
     */
    private List<String> resourceTypes;

    /**
     * Creates an instance of ServiceProperties class.
     */
    public ServiceProperties() {
    }

    /**
     * Get the displayName property: Localized name of the Azure service.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Localized name of the Azure service.
     * 
     * @param displayName the displayName value to set.
     * @return the ServiceProperties object itself.
     */
    public ServiceProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the resourceTypes property: ARM Resource types.
     * 
     * @return the resourceTypes value.
     */
    public List<String> resourceTypes() {
        return this.resourceTypes;
    }

    /**
     * Set the resourceTypes property: ARM Resource types.
     * 
     * @param resourceTypes the resourceTypes value to set.
     * @return the ServiceProperties object itself.
     */
    public ServiceProperties withResourceTypes(List<String> resourceTypes) {
        this.resourceTypes = resourceTypes;
        return this;
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
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeArrayField("resourceTypes", this.resourceTypes,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ServiceProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServiceProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ServiceProperties.
     */
    public static ServiceProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServiceProperties deserializedServiceProperties = new ServiceProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayName".equals(fieldName)) {
                    deserializedServiceProperties.displayName = reader.getString();
                } else if ("resourceTypes".equals(fieldName)) {
                    List<String> resourceTypes = reader.readArray(reader1 -> reader1.getString());
                    deserializedServiceProperties.resourceTypes = resourceTypes;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServiceProperties;
        });
    }
}
