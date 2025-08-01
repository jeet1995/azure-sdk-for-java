// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.monitor.query.logs.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The Analytics query. Learn more about the [Analytics query
 * syntax](https://azure.microsoft.com/documentation/articles/app-insights-analytics-reference/).
 */
@Fluent
public final class QueryBody implements JsonSerializable<QueryBody> {

    /*
     * The query to execute.
     */
    @Generated
    private final String query;

    /*
     * Optional. The timespan over which to query data. This is an ISO8601 time period
     * value. This timespan is applied in addition to any that are specified in the
     * query expression.
     */
    @Generated
    private String timespan;

    /*
     * A list of workspaces to query in addition to the primary workspace.
     */
    @Generated
    private List<String> workspaces;

    /**
     * Creates an instance of QueryBody class.
     *
     * @param query the query value to set.
     */
    @Generated
    public QueryBody(String query) {
        this.query = query;
    }

    /**
     * Get the query property: The query to execute.
     *
     * @return the query value.
     */
    @Generated
    public String getQuery() {
        return this.query;
    }

    /**
     * Get the timespan property: Optional. The timespan over which to query data. This is an ISO8601 time period
     * value. This timespan is applied in addition to any that are specified in the
     * query expression.
     *
     * @return the timespan value.
     */
    @Generated
    public String getTimespan() {
        return this.timespan;
    }

    /**
     * Set the timespan property: Optional. The timespan over which to query data. This is an ISO8601 time period
     * value. This timespan is applied in addition to any that are specified in the
     * query expression.
     *
     * @param timespan the timespan value to set.
     * @return the QueryBody object itself.
     */
    @Generated
    public QueryBody setTimespan(String timespan) {
        this.timespan = timespan;
        return this;
    }

    /**
     * Get the workspaces property: A list of workspaces to query in addition to the primary workspace.
     *
     * @return the workspaces value.
     */
    @Generated
    public List<String> getWorkspaces() {
        return this.workspaces;
    }

    /**
     * Set the workspaces property: A list of workspaces to query in addition to the primary workspace.
     *
     * @param workspaces the workspaces value to set.
     * @return the QueryBody object itself.
     */
    @Generated
    public QueryBody setWorkspaces(List<String> workspaces) {
        this.workspaces = workspaces;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("query", this.query);
        jsonWriter.writeStringField("timespan", this.timespan);
        jsonWriter.writeArrayField("workspaces", this.workspaces, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of QueryBody from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of QueryBody if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the QueryBody.
     */
    @Generated
    public static QueryBody fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String query = null;
            String timespan = null;
            List<String> workspaces = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("query".equals(fieldName)) {
                    query = reader.getString();
                } else if ("timespan".equals(fieldName)) {
                    timespan = reader.getString();
                } else if ("workspaces".equals(fieldName)) {
                    workspaces = reader.readArray(reader1 -> reader1.getString());
                } else {
                    reader.skipChildren();
                }
            }
            QueryBody deserializedQueryBody = new QueryBody(query);
            deserializedQueryBody.timespan = timespan;
            deserializedQueryBody.workspaces = workspaces;
            return deserializedQueryBody;
        });
    }
}
