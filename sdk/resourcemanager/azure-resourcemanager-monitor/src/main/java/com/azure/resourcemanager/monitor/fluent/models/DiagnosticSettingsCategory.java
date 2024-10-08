// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.monitor.models.CategoryType;
import java.io.IOException;
import java.util.List;

/**
 * The diagnostic settings Category.
 */
@Fluent
public final class DiagnosticSettingsCategory implements JsonSerializable<DiagnosticSettingsCategory> {
    /*
     * The type of the diagnostic settings category.
     */
    private CategoryType categoryType;

    /*
     * the collection of what category groups are supported.
     */
    private List<String> categoryGroups;

    /**
     * Creates an instance of DiagnosticSettingsCategory class.
     */
    public DiagnosticSettingsCategory() {
    }

    /**
     * Get the categoryType property: The type of the diagnostic settings category.
     * 
     * @return the categoryType value.
     */
    public CategoryType categoryType() {
        return this.categoryType;
    }

    /**
     * Set the categoryType property: The type of the diagnostic settings category.
     * 
     * @param categoryType the categoryType value to set.
     * @return the DiagnosticSettingsCategory object itself.
     */
    public DiagnosticSettingsCategory withCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
        return this;
    }

    /**
     * Get the categoryGroups property: the collection of what category groups are supported.
     * 
     * @return the categoryGroups value.
     */
    public List<String> categoryGroups() {
        return this.categoryGroups;
    }

    /**
     * Set the categoryGroups property: the collection of what category groups are supported.
     * 
     * @param categoryGroups the categoryGroups value to set.
     * @return the DiagnosticSettingsCategory object itself.
     */
    public DiagnosticSettingsCategory withCategoryGroups(List<String> categoryGroups) {
        this.categoryGroups = categoryGroups;
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
        jsonWriter.writeStringField("categoryType", this.categoryType == null ? null : this.categoryType.toString());
        jsonWriter.writeArrayField("categoryGroups", this.categoryGroups,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DiagnosticSettingsCategory from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DiagnosticSettingsCategory if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DiagnosticSettingsCategory.
     */
    public static DiagnosticSettingsCategory fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DiagnosticSettingsCategory deserializedDiagnosticSettingsCategory = new DiagnosticSettingsCategory();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("categoryType".equals(fieldName)) {
                    deserializedDiagnosticSettingsCategory.categoryType = CategoryType.fromString(reader.getString());
                } else if ("categoryGroups".equals(fieldName)) {
                    List<String> categoryGroups = reader.readArray(reader1 -> reader1.getString());
                    deserializedDiagnosticSettingsCategory.categoryGroups = categoryGroups;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDiagnosticSettingsCategory;
        });
    }
}
