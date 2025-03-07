// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A copy activity source for OData source.
 */
@Fluent
public final class ODataSource extends CopySource {
    /*
     * Copy source type.
     */
    private String type = "ODataSource";

    /*
     * OData query. For example, "$top=1". Type: string (or Expression with resultType string).
     */
    private Object query;

    /*
     * The timeout (TimeSpan) to get an HTTP response. It is the timeout to get a response, not the timeout to read
     * response data. Default value: 00:05:00. Type: string (or Expression with resultType string), pattern:
     * ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])).
     */
    private Object httpRequestTimeout;

    /*
     * Specifies the additional columns to be added to source data. Type: array of objects(AdditionalColumns) (or
     * Expression with resultType array of objects).
     */
    private Object additionalColumns;

    /**
     * Creates an instance of ODataSource class.
     */
    public ODataSource() {
    }

    /**
     * Get the type property: Copy source type.
     * 
     * @return the type value.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the query property: OData query. For example, "$top=1". Type: string (or Expression with resultType string).
     * 
     * @return the query value.
     */
    public Object getQuery() {
        return this.query;
    }

    /**
     * Set the query property: OData query. For example, "$top=1". Type: string (or Expression with resultType string).
     * 
     * @param query the query value to set.
     * @return the ODataSource object itself.
     */
    public ODataSource setQuery(Object query) {
        this.query = query;
        return this;
    }

    /**
     * Get the httpRequestTimeout property: The timeout (TimeSpan) to get an HTTP response. It is the timeout to get a
     * response, not the timeout to read response data. Default value: 00:05:00. Type: string (or Expression with
     * resultType string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])).
     * 
     * @return the httpRequestTimeout value.
     */
    public Object getHttpRequestTimeout() {
        return this.httpRequestTimeout;
    }

    /**
     * Set the httpRequestTimeout property: The timeout (TimeSpan) to get an HTTP response. It is the timeout to get a
     * response, not the timeout to read response data. Default value: 00:05:00. Type: string (or Expression with
     * resultType string), pattern: ((\d+)\.)?(\d\d):(60|([0-5][0-9])):(60|([0-5][0-9])).
     * 
     * @param httpRequestTimeout the httpRequestTimeout value to set.
     * @return the ODataSource object itself.
     */
    public ODataSource setHttpRequestTimeout(Object httpRequestTimeout) {
        this.httpRequestTimeout = httpRequestTimeout;
        return this;
    }

    /**
     * Get the additionalColumns property: Specifies the additional columns to be added to source data. Type: array of
     * objects(AdditionalColumns) (or Expression with resultType array of objects).
     * 
     * @return the additionalColumns value.
     */
    public Object getAdditionalColumns() {
        return this.additionalColumns;
    }

    /**
     * Set the additionalColumns property: Specifies the additional columns to be added to source data. Type: array of
     * objects(AdditionalColumns) (or Expression with resultType array of objects).
     * 
     * @param additionalColumns the additionalColumns value to set.
     * @return the ODataSource object itself.
     */
    public ODataSource setAdditionalColumns(Object additionalColumns) {
        this.additionalColumns = additionalColumns;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ODataSource setSourceRetryCount(Object sourceRetryCount) {
        super.setSourceRetryCount(sourceRetryCount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ODataSource setSourceRetryWait(Object sourceRetryWait) {
        super.setSourceRetryWait(sourceRetryWait);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ODataSource setMaxConcurrentConnections(Object maxConcurrentConnections) {
        super.setMaxConcurrentConnections(maxConcurrentConnections);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("sourceRetryCount", getSourceRetryCount());
        jsonWriter.writeUntypedField("sourceRetryWait", getSourceRetryWait());
        jsonWriter.writeUntypedField("maxConcurrentConnections", getMaxConcurrentConnections());
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeUntypedField("query", this.query);
        jsonWriter.writeUntypedField("httpRequestTimeout", this.httpRequestTimeout);
        jsonWriter.writeUntypedField("additionalColumns", this.additionalColumns);
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ODataSource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ODataSource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ODataSource.
     */
    public static ODataSource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ODataSource deserializedODataSource = new ODataSource();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("sourceRetryCount".equals(fieldName)) {
                    deserializedODataSource.setSourceRetryCount(reader.readUntyped());
                } else if ("sourceRetryWait".equals(fieldName)) {
                    deserializedODataSource.setSourceRetryWait(reader.readUntyped());
                } else if ("maxConcurrentConnections".equals(fieldName)) {
                    deserializedODataSource.setMaxConcurrentConnections(reader.readUntyped());
                } else if ("type".equals(fieldName)) {
                    deserializedODataSource.type = reader.getString();
                } else if ("query".equals(fieldName)) {
                    deserializedODataSource.query = reader.readUntyped();
                } else if ("httpRequestTimeout".equals(fieldName)) {
                    deserializedODataSource.httpRequestTimeout = reader.readUntyped();
                } else if ("additionalColumns".equals(fieldName)) {
                    deserializedODataSource.additionalColumns = reader.readUntyped();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedODataSource.setAdditionalProperties(additionalProperties);

            return deserializedODataSource;
        });
    }
}
