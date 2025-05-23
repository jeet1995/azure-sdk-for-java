// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.keyvault.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.keyvault.fluent.models.MhsmPrivateLinkResourceProperties;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * A private link resource.
 */
@Fluent
public final class MhsmPrivateLinkResource extends ManagedHsmResource {
    /*
     * Resource properties.
     */
    private MhsmPrivateLinkResourceProperties innerProperties;

    /*
     * Metadata pertaining to creation and last modification of the key vault resource.
     */
    private SystemData systemData;

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
     * Creates an instance of MhsmPrivateLinkResource class.
     */
    public MhsmPrivateLinkResource() {
    }

    /**
     * Get the innerProperties property: Resource properties.
     * 
     * @return the innerProperties value.
     */
    private MhsmPrivateLinkResourceProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Metadata pertaining to creation and last modification of the key vault resource.
     * 
     * @return the systemData value.
     */
    @Override
    public SystemData systemData() {
        return this.systemData;
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
     * {@inheritDoc}
     */
    @Override
    public MhsmPrivateLinkResource withSku(ManagedHsmSku sku) {
        super.withSku(sku);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MhsmPrivateLinkResource withIdentity(ManagedServiceIdentity identity) {
        super.withIdentity(identity);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MhsmPrivateLinkResource withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MhsmPrivateLinkResource withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the groupId property: Group identifier of private link resource.
     * 
     * @return the groupId value.
     */
    public String groupId() {
        return this.innerProperties() == null ? null : this.innerProperties().groupId();
    }

    /**
     * Get the requiredMembers property: Required member names of private link resource.
     * 
     * @return the requiredMembers value.
     */
    public List<String> requiredMembers() {
        return this.innerProperties() == null ? null : this.innerProperties().requiredMembers();
    }

    /**
     * Get the requiredZoneNames property: Required DNS zone names of the the private link resource.
     * 
     * @return the requiredZoneNames value.
     */
    public List<String> requiredZoneNames() {
        return this.innerProperties() == null ? null : this.innerProperties().requiredZoneNames();
    }

    /**
     * Set the requiredZoneNames property: Required DNS zone names of the the private link resource.
     * 
     * @param requiredZoneNames the requiredZoneNames value to set.
     * @return the MhsmPrivateLinkResource object itself.
     */
    public MhsmPrivateLinkResource withRequiredZoneNames(List<String> requiredZoneNames) {
        if (this.innerProperties() == null) {
            this.innerProperties = new MhsmPrivateLinkResourceProperties();
        }
        this.innerProperties().withRequiredZoneNames(requiredZoneNames);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
        if (sku() != null) {
            sku().validate();
        }
        if (identity() != null) {
            identity().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("sku", sku());
        jsonWriter.writeJsonField("identity", identity());
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MhsmPrivateLinkResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MhsmPrivateLinkResource if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MhsmPrivateLinkResource.
     */
    public static MhsmPrivateLinkResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MhsmPrivateLinkResource deserializedMhsmPrivateLinkResource = new MhsmPrivateLinkResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedMhsmPrivateLinkResource.withTags(tags);
                } else if ("sku".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.withSku(ManagedHsmSku.fromJson(reader));
                } else if ("systemData".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.systemData = SystemData.fromJson(reader);
                } else if ("identity".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.withIdentity(ManagedServiceIdentity.fromJson(reader));
                } else if ("properties".equals(fieldName)) {
                    deserializedMhsmPrivateLinkResource.innerProperties
                        = MhsmPrivateLinkResourceProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMhsmPrivateLinkResource;
        });
    }
}
