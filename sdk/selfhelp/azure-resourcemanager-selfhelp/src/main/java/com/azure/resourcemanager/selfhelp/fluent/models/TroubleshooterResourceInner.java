// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.selfhelp.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.selfhelp.models.Step;
import com.azure.resourcemanager.selfhelp.models.TroubleshooterProvisioningState;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Troubleshooter response.
 */
@Fluent
public final class TroubleshooterResourceInner extends ProxyResource {
    /*
     * Troubleshooter Instance properties.
     */
    private TroubleshooterInstanceProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * The type of the resource.
     */
    private String type;

    /**
     * Creates an instance of TroubleshooterResourceInner class.
     */
    public TroubleshooterResourceInner() {
    }

    /**
     * Get the innerProperties property: Troubleshooter Instance properties.
     * 
     * @return the innerProperties value.
     */
    private TroubleshooterInstanceProperties innerProperties() {
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
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
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
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the solutionId property: Solution Id to identify single troubleshooter.
     * 
     * @return the solutionId value.
     */
    public String solutionId() {
        return this.innerProperties() == null ? null : this.innerProperties().solutionId();
    }

    /**
     * Set the solutionId property: Solution Id to identify single troubleshooter.
     * 
     * @param solutionId the solutionId value to set.
     * @return the TroubleshooterResourceInner object itself.
     */
    public TroubleshooterResourceInner withSolutionId(String solutionId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TroubleshooterInstanceProperties();
        }
        this.innerProperties().withSolutionId(solutionId);
        return this;
    }

    /**
     * Get the parameters property: Client input parameters to run Troubleshooter Resource.
     * 
     * @return the parameters value.
     */
    public Map<String, String> parameters() {
        return this.innerProperties() == null ? null : this.innerProperties().parameters();
    }

    /**
     * Set the parameters property: Client input parameters to run Troubleshooter Resource.
     * 
     * @param parameters the parameters value to set.
     * @return the TroubleshooterResourceInner object itself.
     */
    public TroubleshooterResourceInner withParameters(Map<String, String> parameters) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TroubleshooterInstanceProperties();
        }
        this.innerProperties().withParameters(parameters);
        return this;
    }

    /**
     * Get the provisioningState property: Status of troubleshooter provisioning.
     * 
     * @return the provisioningState value.
     */
    public TroubleshooterProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the steps property: List of step object.
     * 
     * @return the steps value.
     */
    public List<Step> steps() {
        return this.innerProperties() == null ? null : this.innerProperties().steps();
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
     * Reads an instance of TroubleshooterResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TroubleshooterResourceInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TroubleshooterResourceInner.
     */
    public static TroubleshooterResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TroubleshooterResourceInner deserializedTroubleshooterResourceInner = new TroubleshooterResourceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedTroubleshooterResourceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedTroubleshooterResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedTroubleshooterResourceInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedTroubleshooterResourceInner.innerProperties
                        = TroubleshooterInstanceProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedTroubleshooterResourceInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTroubleshooterResourceInner;
        });
    }
}
