// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Describes a node type sku.
 */
@Fluent
public final class NodeTypeSku implements JsonSerializable<NodeTypeSku> {
    /*
     * The sku name. Name is internally generated and is used in auto-scale scenarios. Property does not allow to be
     * changed to other values than generated. To avoid deployment errors please omit the property.
     */
    private String name;

    /*
     * Specifies the tier of the node type. Possible Values: **Standard**
     */
    private String tier;

    /*
     * The number of nodes in the node type. If present in request it will override properties.vmInstanceCount.
     */
    private int capacity;

    /**
     * Creates an instance of NodeTypeSku class.
     */
    public NodeTypeSku() {
    }

    /**
     * Get the name property: The sku name. Name is internally generated and is used in auto-scale scenarios. Property
     * does not allow to be changed to other values than generated. To avoid deployment errors please omit the property.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The sku name. Name is internally generated and is used in auto-scale scenarios. Property
     * does not allow to be changed to other values than generated. To avoid deployment errors please omit the property.
     * 
     * @param name the name value to set.
     * @return the NodeTypeSku object itself.
     */
    public NodeTypeSku withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the tier property: Specifies the tier of the node type. Possible Values: **Standard**.
     * 
     * @return the tier value.
     */
    public String tier() {
        return this.tier;
    }

    /**
     * Set the tier property: Specifies the tier of the node type. Possible Values: **Standard**.
     * 
     * @param tier the tier value to set.
     * @return the NodeTypeSku object itself.
     */
    public NodeTypeSku withTier(String tier) {
        this.tier = tier;
        return this;
    }

    /**
     * Get the capacity property: The number of nodes in the node type. If present in request it will override
     * properties.vmInstanceCount.
     * 
     * @return the capacity value.
     */
    public int capacity() {
        return this.capacity;
    }

    /**
     * Set the capacity property: The number of nodes in the node type. If present in request it will override
     * properties.vmInstanceCount.
     * 
     * @param capacity the capacity value to set.
     * @return the NodeTypeSku object itself.
     */
    public NodeTypeSku withCapacity(int capacity) {
        this.capacity = capacity;
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
        jsonWriter.writeIntField("capacity", this.capacity);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("tier", this.tier);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NodeTypeSku from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NodeTypeSku if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the NodeTypeSku.
     */
    public static NodeTypeSku fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NodeTypeSku deserializedNodeTypeSku = new NodeTypeSku();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("capacity".equals(fieldName)) {
                    deserializedNodeTypeSku.capacity = reader.getInt();
                } else if ("name".equals(fieldName)) {
                    deserializedNodeTypeSku.name = reader.getString();
                } else if ("tier".equals(fieldName)) {
                    deserializedNodeTypeSku.tier = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNodeTypeSku;
        });
    }
}
