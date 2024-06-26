// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.compute.batch.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * An HTTP header name-value pair.
 */
@Fluent
public final class HttpHeader implements JsonSerializable<HttpHeader> {

    /*
     * The case-insensitive name of the header to be used while uploading output files.
     */
    @Generated
    private final String name;

    /*
     * The value of the header to be used while uploading output files.
     */
    @Generated
    private String value;

    /**
     * Creates an instance of HttpHeader class.
     *
     * @param name the name value to set.
     */
    @Generated
    public HttpHeader(String name) {
        this.name = name;
    }

    /**
     * Get the name property: The case-insensitive name of the header to be used while uploading output files.
     *
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Get the value property: The value of the header to be used while uploading output files.
     *
     * @return the value value.
     */
    @Generated
    public String getValue() {
        return this.value;
    }

    /**
     * Set the value property: The value of the header to be used while uploading output files.
     *
     * @param value the value value to set.
     * @return the HttpHeader object itself.
     */
    @Generated
    public HttpHeader setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("value", this.value);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HttpHeader from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of HttpHeader if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the HttpHeader.
     */
    @Generated
    public static HttpHeader fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String name = null;
            String value = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("name".equals(fieldName)) {
                    name = reader.getString();
                } else if ("value".equals(fieldName)) {
                    value = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            HttpHeader deserializedHttpHeader = new HttpHeader(name);
            deserializedHttpHeader.value = value;
            return deserializedHttpHeader;
        });
    }
}
