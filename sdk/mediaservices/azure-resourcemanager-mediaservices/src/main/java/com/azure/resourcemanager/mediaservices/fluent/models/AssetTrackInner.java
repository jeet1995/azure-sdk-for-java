// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.mediaservices.models.ProvisioningState;
import com.azure.resourcemanager.mediaservices.models.TrackBase;
import java.io.IOException;

/**
 * An Asset Track resource.
 */
@Fluent
public final class AssetTrackInner extends ProxyResource {
    /*
     * The resource properties.
     */
    private AssetTrackProperties innerProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of AssetTrackInner class.
     */
    public AssetTrackInner() {
    }

    /**
     * Get the innerProperties property: The resource properties.
     * 
     * @return the innerProperties value.
     */
    private AssetTrackProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the track property: Detailed information about a track in the asset.
     * 
     * @return the track value.
     */
    public TrackBase track() {
        return this.innerProperties() == null ? null : this.innerProperties().track();
    }

    /**
     * Set the track property: Detailed information about a track in the asset.
     * 
     * @param track the track value to set.
     * @return the AssetTrackInner object itself.
     */
    public AssetTrackInner withTrack(TrackBase track) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AssetTrackProperties();
        }
        this.innerProperties().withTrack(track);
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the asset track.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AssetTrackInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AssetTrackInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AssetTrackInner.
     */
    public static AssetTrackInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AssetTrackInner deserializedAssetTrackInner = new AssetTrackInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedAssetTrackInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedAssetTrackInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedAssetTrackInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedAssetTrackInner.innerProperties = AssetTrackProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAssetTrackInner;
        });
    }
}
