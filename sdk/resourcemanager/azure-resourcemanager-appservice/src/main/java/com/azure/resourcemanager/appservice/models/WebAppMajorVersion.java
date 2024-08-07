// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Web App stack major version.
 */
@Immutable
public final class WebAppMajorVersion implements JsonSerializable<WebAppMajorVersion> {
    /*
     * Web App stack major version (display only).
     */
    private String displayText;

    /*
     * Web App stack major version name.
     */
    private String value;

    /*
     * Minor versions associated with the major version.
     */
    private List<WebAppMinorVersion> minorVersions;

    /**
     * Creates an instance of WebAppMajorVersion class.
     */
    public WebAppMajorVersion() {
    }

    /**
     * Get the displayText property: Web App stack major version (display only).
     * 
     * @return the displayText value.
     */
    public String displayText() {
        return this.displayText;
    }

    /**
     * Get the value property: Web App stack major version name.
     * 
     * @return the value value.
     */
    public String value() {
        return this.value;
    }

    /**
     * Get the minorVersions property: Minor versions associated with the major version.
     * 
     * @return the minorVersions value.
     */
    public List<WebAppMinorVersion> minorVersions() {
        return this.minorVersions;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (minorVersions() != null) {
            minorVersions().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WebAppMajorVersion from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WebAppMajorVersion if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the WebAppMajorVersion.
     */
    public static WebAppMajorVersion fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WebAppMajorVersion deserializedWebAppMajorVersion = new WebAppMajorVersion();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("displayText".equals(fieldName)) {
                    deserializedWebAppMajorVersion.displayText = reader.getString();
                } else if ("value".equals(fieldName)) {
                    deserializedWebAppMajorVersion.value = reader.getString();
                } else if ("minorVersions".equals(fieldName)) {
                    List<WebAppMinorVersion> minorVersions
                        = reader.readArray(reader1 -> WebAppMinorVersion.fromJson(reader1));
                    deserializedWebAppMajorVersion.minorVersions = minorVersions;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWebAppMajorVersion;
        });
    }
}
