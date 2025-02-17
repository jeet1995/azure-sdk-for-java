// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Properties that define an Log Analytics QueryPack-Query search properties.
 */
@Fluent
public final class LogAnalyticsQueryPackQuerySearchProperties
    implements JsonSerializable<LogAnalyticsQueryPackQuerySearchProperties> {
    /*
     * The related metadata items for the function.
     */
    private LogAnalyticsQueryPackQuerySearchPropertiesRelated related;

    /*
     * Tags associated with the query.
     */
    private Map<String, List<String>> tags;

    /**
     * Creates an instance of LogAnalyticsQueryPackQuerySearchProperties class.
     */
    public LogAnalyticsQueryPackQuerySearchProperties() {
    }

    /**
     * Get the related property: The related metadata items for the function.
     * 
     * @return the related value.
     */
    public LogAnalyticsQueryPackQuerySearchPropertiesRelated related() {
        return this.related;
    }

    /**
     * Set the related property: The related metadata items for the function.
     * 
     * @param related the related value to set.
     * @return the LogAnalyticsQueryPackQuerySearchProperties object itself.
     */
    public LogAnalyticsQueryPackQuerySearchProperties
        withRelated(LogAnalyticsQueryPackQuerySearchPropertiesRelated related) {
        this.related = related;
        return this;
    }

    /**
     * Get the tags property: Tags associated with the query.
     * 
     * @return the tags value.
     */
    public Map<String, List<String>> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Tags associated with the query.
     * 
     * @param tags the tags value to set.
     * @return the LogAnalyticsQueryPackQuerySearchProperties object itself.
     */
    public LogAnalyticsQueryPackQuerySearchProperties withTags(Map<String, List<String>> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (related() != null) {
            related().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("related", this.related);
        jsonWriter.writeMapField("tags", this.tags,
            (writer, element) -> writer.writeArray(element, (writer1, element1) -> writer1.writeString(element1)));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LogAnalyticsQueryPackQuerySearchProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LogAnalyticsQueryPackQuerySearchProperties if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the LogAnalyticsQueryPackQuerySearchProperties.
     */
    public static LogAnalyticsQueryPackQuerySearchProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LogAnalyticsQueryPackQuerySearchProperties deserializedLogAnalyticsQueryPackQuerySearchProperties
                = new LogAnalyticsQueryPackQuerySearchProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("related".equals(fieldName)) {
                    deserializedLogAnalyticsQueryPackQuerySearchProperties.related
                        = LogAnalyticsQueryPackQuerySearchPropertiesRelated.fromJson(reader);
                } else if ("tags".equals(fieldName)) {
                    Map<String, List<String>> tags
                        = reader.readMap(reader1 -> reader1.readArray(reader2 -> reader2.getString()));
                    deserializedLogAnalyticsQueryPackQuerySearchProperties.tags = tags;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLogAnalyticsQueryPackQuerySearchProperties;
        });
    }
}
