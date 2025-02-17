// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.mobilenetwork.models.UeInfoPropertiesFormat;
import java.io.IOException;

/**
 * Basic UE Information.
 */
@Fluent
public final class UeInfoInner extends ProxyResource {
    /*
     * Basic UE Information Properties.
     */
    private UeInfoPropertiesFormat properties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
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
     * Creates an instance of UeInfoInner class.
     */
    public UeInfoInner() {
    }

    /**
     * Get the properties property: Basic UE Information Properties.
     * 
     * @return the properties value.
     */
    public UeInfoPropertiesFormat properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Basic UE Information Properties.
     * 
     * @param properties the properties value to set.
     * @return the UeInfoInner object itself.
     */
    public UeInfoInner withProperties(UeInfoPropertiesFormat properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
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
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property properties in model UeInfoInner"));
        } else {
            properties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(UeInfoInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UeInfoInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UeInfoInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the UeInfoInner.
     */
    public static UeInfoInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UeInfoInner deserializedUeInfoInner = new UeInfoInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedUeInfoInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedUeInfoInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedUeInfoInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedUeInfoInner.properties = UeInfoPropertiesFormat.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedUeInfoInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUeInfoInner;
        });
    }
}
