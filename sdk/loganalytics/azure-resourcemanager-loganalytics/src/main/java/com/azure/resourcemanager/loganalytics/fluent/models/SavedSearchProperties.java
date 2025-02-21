// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.loganalytics.models.Tag;
import java.io.IOException;
import java.util.List;

/**
 * Value object for saved search results.
 */
@Fluent
public final class SavedSearchProperties implements JsonSerializable<SavedSearchProperties> {
    /*
     * The category of the saved search. This helps the user to find a saved search faster.
     */
    private String category;

    /*
     * Saved search display name.
     */
    private String displayName;

    /*
     * The query expression for the saved search.
     */
    private String query;

    /*
     * The function alias if query serves as a function.
     */
    private String functionAlias;

    /*
     * The optional function parameters if query serves as a function. Value should be in the following format:
     * 'param-name1:type1 = default_value1, param-name2:type2 = default_value2'. For more examples and proper syntax
     * please refer to https://docs.microsoft.com/en-us/azure/kusto/query/functions/user-defined-functions.
     */
    private String functionParameters;

    /*
     * The version number of the query language. The current version is 2 and is the default.
     */
    private Long version;

    /*
     * The tags attached to the saved search.
     */
    private List<Tag> tags;

    /**
     * Creates an instance of SavedSearchProperties class.
     */
    public SavedSearchProperties() {
    }

    /**
     * Get the category property: The category of the saved search. This helps the user to find a saved search faster.
     * 
     * @return the category value.
     */
    public String category() {
        return this.category;
    }

    /**
     * Set the category property: The category of the saved search. This helps the user to find a saved search faster.
     * 
     * @param category the category value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get the displayName property: Saved search display name.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: Saved search display name.
     * 
     * @param displayName the displayName value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the query property: The query expression for the saved search.
     * 
     * @return the query value.
     */
    public String query() {
        return this.query;
    }

    /**
     * Set the query property: The query expression for the saved search.
     * 
     * @param query the query value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withQuery(String query) {
        this.query = query;
        return this;
    }

    /**
     * Get the functionAlias property: The function alias if query serves as a function.
     * 
     * @return the functionAlias value.
     */
    public String functionAlias() {
        return this.functionAlias;
    }

    /**
     * Set the functionAlias property: The function alias if query serves as a function.
     * 
     * @param functionAlias the functionAlias value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withFunctionAlias(String functionAlias) {
        this.functionAlias = functionAlias;
        return this;
    }

    /**
     * Get the functionParameters property: The optional function parameters if query serves as a function. Value should
     * be in the following format: 'param-name1:type1 = default_value1, param-name2:type2 = default_value2'. For more
     * examples and proper syntax please refer to
     * https://docs.microsoft.com/en-us/azure/kusto/query/functions/user-defined-functions.
     * 
     * @return the functionParameters value.
     */
    public String functionParameters() {
        return this.functionParameters;
    }

    /**
     * Set the functionParameters property: The optional function parameters if query serves as a function. Value should
     * be in the following format: 'param-name1:type1 = default_value1, param-name2:type2 = default_value2'. For more
     * examples and proper syntax please refer to
     * https://docs.microsoft.com/en-us/azure/kusto/query/functions/user-defined-functions.
     * 
     * @param functionParameters the functionParameters value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withFunctionParameters(String functionParameters) {
        this.functionParameters = functionParameters;
        return this;
    }

    /**
     * Get the version property: The version number of the query language. The current version is 2 and is the default.
     * 
     * @return the version value.
     */
    public Long version() {
        return this.version;
    }

    /**
     * Set the version property: The version number of the query language. The current version is 2 and is the default.
     * 
     * @param version the version value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withVersion(Long version) {
        this.version = version;
        return this;
    }

    /**
     * Get the tags property: The tags attached to the saved search.
     * 
     * @return the tags value.
     */
    public List<Tag> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: The tags attached to the saved search.
     * 
     * @param tags the tags value to set.
     * @return the SavedSearchProperties object itself.
     */
    public SavedSearchProperties withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (category() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property category in model SavedSearchProperties"));
        }
        if (displayName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property displayName in model SavedSearchProperties"));
        }
        if (query() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property query in model SavedSearchProperties"));
        }
        if (tags() != null) {
            tags().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SavedSearchProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("category", this.category);
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("query", this.query);
        jsonWriter.writeStringField("functionAlias", this.functionAlias);
        jsonWriter.writeStringField("functionParameters", this.functionParameters);
        jsonWriter.writeNumberField("version", this.version);
        jsonWriter.writeArrayField("tags", this.tags, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SavedSearchProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SavedSearchProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SavedSearchProperties.
     */
    public static SavedSearchProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SavedSearchProperties deserializedSavedSearchProperties = new SavedSearchProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("category".equals(fieldName)) {
                    deserializedSavedSearchProperties.category = reader.getString();
                } else if ("displayName".equals(fieldName)) {
                    deserializedSavedSearchProperties.displayName = reader.getString();
                } else if ("query".equals(fieldName)) {
                    deserializedSavedSearchProperties.query = reader.getString();
                } else if ("functionAlias".equals(fieldName)) {
                    deserializedSavedSearchProperties.functionAlias = reader.getString();
                } else if ("functionParameters".equals(fieldName)) {
                    deserializedSavedSearchProperties.functionParameters = reader.getString();
                } else if ("version".equals(fieldName)) {
                    deserializedSavedSearchProperties.version = reader.getNullable(JsonReader::getLong);
                } else if ("tags".equals(fieldName)) {
                    List<Tag> tags = reader.readArray(reader1 -> Tag.fromJson(reader1));
                    deserializedSavedSearchProperties.tags = tags;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSavedSearchProperties;
        });
    }
}
