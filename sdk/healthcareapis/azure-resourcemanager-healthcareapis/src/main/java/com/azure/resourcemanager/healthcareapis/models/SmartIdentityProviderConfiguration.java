// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.healthcareapis.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * An object to configure an identity provider for use with SMART on FHIR authentication.
 */
@Fluent
public final class SmartIdentityProviderConfiguration implements JsonSerializable<SmartIdentityProviderConfiguration> {
    /*
     * The identity provider token authority also known as the token issuing authority.
     */
    private String authority;

    /*
     * The array of identity provider applications for SMART on FHIR authentication.
     */
    private List<SmartIdentityProviderApplication> applications;

    /**
     * Creates an instance of SmartIdentityProviderConfiguration class.
     */
    public SmartIdentityProviderConfiguration() {
    }

    /**
     * Get the authority property: The identity provider token authority also known as the token issuing authority.
     * 
     * @return the authority value.
     */
    public String authority() {
        return this.authority;
    }

    /**
     * Set the authority property: The identity provider token authority also known as the token issuing authority.
     * 
     * @param authority the authority value to set.
     * @return the SmartIdentityProviderConfiguration object itself.
     */
    public SmartIdentityProviderConfiguration withAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    /**
     * Get the applications property: The array of identity provider applications for SMART on FHIR authentication.
     * 
     * @return the applications value.
     */
    public List<SmartIdentityProviderApplication> applications() {
        return this.applications;
    }

    /**
     * Set the applications property: The array of identity provider applications for SMART on FHIR authentication.
     * 
     * @param applications the applications value to set.
     * @return the SmartIdentityProviderConfiguration object itself.
     */
    public SmartIdentityProviderConfiguration withApplications(List<SmartIdentityProviderApplication> applications) {
        this.applications = applications;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (applications() != null) {
            applications().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("authority", this.authority);
        jsonWriter.writeArrayField("applications", this.applications, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SmartIdentityProviderConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SmartIdentityProviderConfiguration if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SmartIdentityProviderConfiguration.
     */
    public static SmartIdentityProviderConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SmartIdentityProviderConfiguration deserializedSmartIdentityProviderConfiguration
                = new SmartIdentityProviderConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("authority".equals(fieldName)) {
                    deserializedSmartIdentityProviderConfiguration.authority = reader.getString();
                } else if ("applications".equals(fieldName)) {
                    List<SmartIdentityProviderApplication> applications
                        = reader.readArray(reader1 -> SmartIdentityProviderApplication.fromJson(reader1));
                    deserializedSmartIdentityProviderConfiguration.applications = applications;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSmartIdentityProviderConfiguration;
        });
    }
}
