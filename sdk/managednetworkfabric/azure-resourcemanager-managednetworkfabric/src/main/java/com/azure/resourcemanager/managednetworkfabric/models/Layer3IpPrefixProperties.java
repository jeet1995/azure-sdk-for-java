// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Layer 3 primary and secondary IP Address prefixes.
 */
@Fluent
public class Layer3IpPrefixProperties implements JsonSerializable<Layer3IpPrefixProperties> {
    /*
     * IPv4 Address Prefix.
     */
    private String primaryIpv4Prefix;

    /*
     * IPv6 Address Prefix.
     */
    private String primaryIpv6Prefix;

    /*
     * Secondary IPv4 Address Prefix.
     */
    private String secondaryIpv4Prefix;

    /*
     * Secondary IPv6 Address Prefix.
     */
    private String secondaryIpv6Prefix;

    /**
     * Creates an instance of Layer3IpPrefixProperties class.
     */
    public Layer3IpPrefixProperties() {
    }

    /**
     * Get the primaryIpv4Prefix property: IPv4 Address Prefix.
     * 
     * @return the primaryIpv4Prefix value.
     */
    public String primaryIpv4Prefix() {
        return this.primaryIpv4Prefix;
    }

    /**
     * Set the primaryIpv4Prefix property: IPv4 Address Prefix.
     * 
     * @param primaryIpv4Prefix the primaryIpv4Prefix value to set.
     * @return the Layer3IpPrefixProperties object itself.
     */
    public Layer3IpPrefixProperties withPrimaryIpv4Prefix(String primaryIpv4Prefix) {
        this.primaryIpv4Prefix = primaryIpv4Prefix;
        return this;
    }

    /**
     * Get the primaryIpv6Prefix property: IPv6 Address Prefix.
     * 
     * @return the primaryIpv6Prefix value.
     */
    public String primaryIpv6Prefix() {
        return this.primaryIpv6Prefix;
    }

    /**
     * Set the primaryIpv6Prefix property: IPv6 Address Prefix.
     * 
     * @param primaryIpv6Prefix the primaryIpv6Prefix value to set.
     * @return the Layer3IpPrefixProperties object itself.
     */
    public Layer3IpPrefixProperties withPrimaryIpv6Prefix(String primaryIpv6Prefix) {
        this.primaryIpv6Prefix = primaryIpv6Prefix;
        return this;
    }

    /**
     * Get the secondaryIpv4Prefix property: Secondary IPv4 Address Prefix.
     * 
     * @return the secondaryIpv4Prefix value.
     */
    public String secondaryIpv4Prefix() {
        return this.secondaryIpv4Prefix;
    }

    /**
     * Set the secondaryIpv4Prefix property: Secondary IPv4 Address Prefix.
     * 
     * @param secondaryIpv4Prefix the secondaryIpv4Prefix value to set.
     * @return the Layer3IpPrefixProperties object itself.
     */
    public Layer3IpPrefixProperties withSecondaryIpv4Prefix(String secondaryIpv4Prefix) {
        this.secondaryIpv4Prefix = secondaryIpv4Prefix;
        return this;
    }

    /**
     * Get the secondaryIpv6Prefix property: Secondary IPv6 Address Prefix.
     * 
     * @return the secondaryIpv6Prefix value.
     */
    public String secondaryIpv6Prefix() {
        return this.secondaryIpv6Prefix;
    }

    /**
     * Set the secondaryIpv6Prefix property: Secondary IPv6 Address Prefix.
     * 
     * @param secondaryIpv6Prefix the secondaryIpv6Prefix value to set.
     * @return the Layer3IpPrefixProperties object itself.
     */
    public Layer3IpPrefixProperties withSecondaryIpv6Prefix(String secondaryIpv6Prefix) {
        this.secondaryIpv6Prefix = secondaryIpv6Prefix;
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
        jsonWriter.writeStringField("primaryIpv4Prefix", this.primaryIpv4Prefix);
        jsonWriter.writeStringField("primaryIpv6Prefix", this.primaryIpv6Prefix);
        jsonWriter.writeStringField("secondaryIpv4Prefix", this.secondaryIpv4Prefix);
        jsonWriter.writeStringField("secondaryIpv6Prefix", this.secondaryIpv6Prefix);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Layer3IpPrefixProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Layer3IpPrefixProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the Layer3IpPrefixProperties.
     */
    public static Layer3IpPrefixProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Layer3IpPrefixProperties deserializedLayer3IpPrefixProperties = new Layer3IpPrefixProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("primaryIpv4Prefix".equals(fieldName)) {
                    deserializedLayer3IpPrefixProperties.primaryIpv4Prefix = reader.getString();
                } else if ("primaryIpv6Prefix".equals(fieldName)) {
                    deserializedLayer3IpPrefixProperties.primaryIpv6Prefix = reader.getString();
                } else if ("secondaryIpv4Prefix".equals(fieldName)) {
                    deserializedLayer3IpPrefixProperties.secondaryIpv4Prefix = reader.getString();
                } else if ("secondaryIpv6Prefix".equals(fieldName)) {
                    deserializedLayer3IpPrefixProperties.secondaryIpv6Prefix = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLayer3IpPrefixProperties;
        });
    }
}
