// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotfirmwaredefense.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.iotfirmwaredefense.models.BinaryHardeningFeatures;
import com.azure.resourcemanager.iotfirmwaredefense.models.ExecutableClass;
import com.azure.resourcemanager.iotfirmwaredefense.models.ProvisioningState;
import java.io.IOException;

/**
 * The object representing a firmware analysis binary hardening result resource.
 */
@Immutable
public final class BinaryHardeningResourceInner extends ProxyResource {
    /*
     * The resource-specific properties for this resource.
     */
    private BinaryHardeningResult innerProperties;

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
     * Creates an instance of BinaryHardeningResourceInner class.
     */
    private BinaryHardeningResourceInner() {
    }

    /**
     * Get the innerProperties property: The resource-specific properties for this resource.
     * 
     * @return the innerProperties value.
     */
    private BinaryHardeningResult innerProperties() {
        return this.innerProperties;
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
     * Get the binaryHardeningId property: ID for the binary hardening result.
     * 
     * @return the binaryHardeningId value.
     */
    public String binaryHardeningId() {
        return this.innerProperties() == null ? null : this.innerProperties().binaryHardeningId();
    }

    /**
     * Get the securityHardeningFeatures property: The security hardening features of the binary.
     * 
     * @return the securityHardeningFeatures value.
     */
    public BinaryHardeningFeatures securityHardeningFeatures() {
        return this.innerProperties() == null ? null : this.innerProperties().securityHardeningFeatures();
    }

    /**
     * Get the executableArchitecture property: The architecture of the binary being reported on.
     * 
     * @return the executableArchitecture value.
     */
    public String executableArchitecture() {
        return this.innerProperties() == null ? null : this.innerProperties().executableArchitecture();
    }

    /**
     * Get the filePath property: The path to the binary in the firmware.
     * 
     * @return the filePath value.
     */
    public String filePath() {
        return this.innerProperties() == null ? null : this.innerProperties().filePath();
    }

    /**
     * Get the executableClass property: The executable class to indicate 32 or 64 bit.
     * 
     * @return the executableClass value.
     */
    public ExecutableClass executableClass() {
        return this.innerProperties() == null ? null : this.innerProperties().executableClass();
    }

    /**
     * Get the runpath property: The runpath property of the uploaded binary, which is a method of specifying additional
     * paths to load objects at runtime.
     * 
     * @return the runpath value.
     */
    public String runpath() {
        return this.innerProperties() == null ? null : this.innerProperties().runpath();
    }

    /**
     * Get the rpath property: The rpath property of the uploaded binary, which is a deprecated method of specifying
     * additional paths to load objects at runtime.
     * 
     * @return the rpath value.
     */
    public String rpath() {
        return this.innerProperties() == null ? null : this.innerProperties().rpath();
    }

    /**
     * Get the provisioningState property: The status of the last operation.
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
     * Reads an instance of BinaryHardeningResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BinaryHardeningResourceInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the BinaryHardeningResourceInner.
     */
    public static BinaryHardeningResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BinaryHardeningResourceInner deserializedBinaryHardeningResourceInner = new BinaryHardeningResourceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedBinaryHardeningResourceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedBinaryHardeningResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedBinaryHardeningResourceInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedBinaryHardeningResourceInner.innerProperties = BinaryHardeningResult.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedBinaryHardeningResourceInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBinaryHardeningResourceInner;
        });
    }
}
