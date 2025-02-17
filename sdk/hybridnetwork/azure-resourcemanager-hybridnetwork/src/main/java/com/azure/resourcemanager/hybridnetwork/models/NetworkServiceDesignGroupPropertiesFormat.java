// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * network service design group properties.
 */
@Fluent
public final class NetworkServiceDesignGroupPropertiesFormat
    implements JsonSerializable<NetworkServiceDesignGroupPropertiesFormat> {
    /*
     * The provisioning state of the network service design groups resource.
     */
    private ProvisioningState provisioningState;

    /*
     * The network service design group description.
     */
    private String description;

    /**
     * Creates an instance of NetworkServiceDesignGroupPropertiesFormat class.
     */
    public NetworkServiceDesignGroupPropertiesFormat() {
    }

    /**
     * Get the provisioningState property: The provisioning state of the network service design groups resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the description property: The network service design group description.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The network service design group description.
     * 
     * @param description the description value to set.
     * @return the NetworkServiceDesignGroupPropertiesFormat object itself.
     */
    public NetworkServiceDesignGroupPropertiesFormat withDescription(String description) {
        this.description = description;
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
        jsonWriter.writeStringField("description", this.description);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NetworkServiceDesignGroupPropertiesFormat from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NetworkServiceDesignGroupPropertiesFormat if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the NetworkServiceDesignGroupPropertiesFormat.
     */
    public static NetworkServiceDesignGroupPropertiesFormat fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NetworkServiceDesignGroupPropertiesFormat deserializedNetworkServiceDesignGroupPropertiesFormat
                = new NetworkServiceDesignGroupPropertiesFormat();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningState".equals(fieldName)) {
                    deserializedNetworkServiceDesignGroupPropertiesFormat.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else if ("description".equals(fieldName)) {
                    deserializedNetworkServiceDesignGroupPropertiesFormat.description = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNetworkServiceDesignGroupPropertiesFormat;
        });
    }
}
