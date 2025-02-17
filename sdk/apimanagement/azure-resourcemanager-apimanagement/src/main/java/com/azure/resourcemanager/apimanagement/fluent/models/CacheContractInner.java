// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Cache details.
 */
@Fluent
public final class CacheContractInner extends ProxyResource {
    /*
     * Cache properties details.
     */
    private CacheContractProperties innerProperties;

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
     * Creates an instance of CacheContractInner class.
     */
    public CacheContractInner() {
    }

    /**
     * Get the innerProperties property: Cache properties details.
     * 
     * @return the innerProperties value.
     */
    private CacheContractProperties innerProperties() {
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
     * Get the description property: Cache description.
     * 
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: Cache description.
     * 
     * @param description the description value to set.
     * @return the CacheContractInner object itself.
     */
    public CacheContractInner withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CacheContractProperties();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the connectionString property: Runtime connection string to cache.
     * 
     * @return the connectionString value.
     */
    public String connectionString() {
        return this.innerProperties() == null ? null : this.innerProperties().connectionString();
    }

    /**
     * Set the connectionString property: Runtime connection string to cache.
     * 
     * @param connectionString the connectionString value to set.
     * @return the CacheContractInner object itself.
     */
    public CacheContractInner withConnectionString(String connectionString) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CacheContractProperties();
        }
        this.innerProperties().withConnectionString(connectionString);
        return this;
    }

    /**
     * Get the useFromLocation property: Location identifier to use cache from (should be either 'default' or valid
     * Azure region identifier).
     * 
     * @return the useFromLocation value.
     */
    public String useFromLocation() {
        return this.innerProperties() == null ? null : this.innerProperties().useFromLocation();
    }

    /**
     * Set the useFromLocation property: Location identifier to use cache from (should be either 'default' or valid
     * Azure region identifier).
     * 
     * @param useFromLocation the useFromLocation value to set.
     * @return the CacheContractInner object itself.
     */
    public CacheContractInner withUseFromLocation(String useFromLocation) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CacheContractProperties();
        }
        this.innerProperties().withUseFromLocation(useFromLocation);
        return this;
    }

    /**
     * Get the resourceId property: Original uri of entity in external system cache points to.
     * 
     * @return the resourceId value.
     */
    public String resourceId() {
        return this.innerProperties() == null ? null : this.innerProperties().resourceId();
    }

    /**
     * Set the resourceId property: Original uri of entity in external system cache points to.
     * 
     * @param resourceId the resourceId value to set.
     * @return the CacheContractInner object itself.
     */
    public CacheContractInner withResourceId(String resourceId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CacheContractProperties();
        }
        this.innerProperties().withResourceId(resourceId);
        return this;
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
     * Reads an instance of CacheContractInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CacheContractInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CacheContractInner.
     */
    public static CacheContractInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CacheContractInner deserializedCacheContractInner = new CacheContractInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedCacheContractInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedCacheContractInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedCacheContractInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedCacheContractInner.innerProperties = CacheContractProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCacheContractInner;
        });
    }
}
