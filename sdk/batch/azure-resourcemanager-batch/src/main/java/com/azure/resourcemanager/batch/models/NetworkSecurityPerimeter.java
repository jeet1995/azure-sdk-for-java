// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Information about a network security perimeter (NSP).
 */
@Fluent
public final class NetworkSecurityPerimeter implements JsonSerializable<NetworkSecurityPerimeter> {
    /*
     * Fully qualified Azure resource ID of the NSP resource
     */
    private String id;

    /*
     * Universal unique ID (UUID) of the network security perimeter
     */
    private UUID perimeterGuid;

    /*
     * Location of the network security perimeter
     */
    private String location;

    /**
     * Creates an instance of NetworkSecurityPerimeter class.
     */
    public NetworkSecurityPerimeter() {
    }

    /**
     * Get the id property: Fully qualified Azure resource ID of the NSP resource.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Fully qualified Azure resource ID of the NSP resource.
     * 
     * @param id the id value to set.
     * @return the NetworkSecurityPerimeter object itself.
     */
    public NetworkSecurityPerimeter withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the perimeterGuid property: Universal unique ID (UUID) of the network security perimeter.
     * 
     * @return the perimeterGuid value.
     */
    public UUID perimeterGuid() {
        return this.perimeterGuid;
    }

    /**
     * Set the perimeterGuid property: Universal unique ID (UUID) of the network security perimeter.
     * 
     * @param perimeterGuid the perimeterGuid value to set.
     * @return the NetworkSecurityPerimeter object itself.
     */
    public NetworkSecurityPerimeter withPerimeterGuid(UUID perimeterGuid) {
        this.perimeterGuid = perimeterGuid;
        return this;
    }

    /**
     * Get the location property: Location of the network security perimeter.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location property: Location of the network security perimeter.
     * 
     * @param location the location value to set.
     * @return the NetworkSecurityPerimeter object itself.
     */
    public NetworkSecurityPerimeter withLocation(String location) {
        this.location = location;
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
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("perimeterGuid", Objects.toString(this.perimeterGuid, null));
        jsonWriter.writeStringField("location", this.location);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NetworkSecurityPerimeter from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NetworkSecurityPerimeter if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the NetworkSecurityPerimeter.
     */
    public static NetworkSecurityPerimeter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NetworkSecurityPerimeter deserializedNetworkSecurityPerimeter = new NetworkSecurityPerimeter();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedNetworkSecurityPerimeter.id = reader.getString();
                } else if ("perimeterGuid".equals(fieldName)) {
                    deserializedNetworkSecurityPerimeter.perimeterGuid
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else if ("location".equals(fieldName)) {
                    deserializedNetworkSecurityPerimeter.location = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNetworkSecurityPerimeter;
        });
    }
}
