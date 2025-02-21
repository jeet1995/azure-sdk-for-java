// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.servicefabric.models.ServiceResourceProperties;
import java.io.IOException;
import java.util.Map;

/**
 * The service resource.
 */
@Fluent
public final class ServiceResourceInner extends ProxyResource {
    /*
     * The service resource properties.
     */
    private ServiceResourceProperties properties;

    /*
     * It will be deprecated in New API, resource location depends on the parent resource.
     */
    private String location;

    /*
     * Azure resource tags.
     */
    private Map<String, String> tags;

    /*
     * Azure resource etag.
     */
    private String etag;

    /*
     * Metadata pertaining to creation and last modification of the resource.
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
     * Creates an instance of ServiceResourceInner class.
     */
    public ServiceResourceInner() {
    }

    /**
     * Get the properties property: The service resource properties.
     * 
     * @return the properties value.
     */
    public ServiceResourceProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The service resource properties.
     * 
     * @param properties the properties value to set.
     * @return the ServiceResourceInner object itself.
     */
    public ServiceResourceInner withProperties(ServiceResourceProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the location property: It will be deprecated in New API, resource location depends on the parent resource.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location property: It will be deprecated in New API, resource location depends on the parent resource.
     * 
     * @param location the location value to set.
     * @return the ServiceResourceInner object itself.
     */
    public ServiceResourceInner withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the tags property: Azure resource tags.
     * 
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Azure resource tags.
     * 
     * @param tags the tags value to set.
     * @return the ServiceResourceInner object itself.
     */
    public ServiceResourceInner withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the etag property: Azure resource etag.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the systemData property: Metadata pertaining to creation and last modification of the resource.
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
        if (properties() != null) {
            properties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.properties);
        jsonWriter.writeStringField("location", this.location);
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ServiceResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServiceResourceInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ServiceResourceInner.
     */
    public static ServiceResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServiceResourceInner deserializedServiceResourceInner = new ServiceResourceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedServiceResourceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedServiceResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedServiceResourceInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedServiceResourceInner.properties = ServiceResourceProperties.fromJson(reader);
                } else if ("location".equals(fieldName)) {
                    deserializedServiceResourceInner.location = reader.getString();
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedServiceResourceInner.tags = tags;
                } else if ("etag".equals(fieldName)) {
                    deserializedServiceResourceInner.etag = reader.getString();
                } else if ("systemData".equals(fieldName)) {
                    deserializedServiceResourceInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServiceResourceInner;
        });
    }
}
