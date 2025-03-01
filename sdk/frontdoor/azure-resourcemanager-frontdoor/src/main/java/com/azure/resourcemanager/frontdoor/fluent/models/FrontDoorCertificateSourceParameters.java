// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.frontdoor.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.frontdoor.models.FrontDoorCertificateType;
import java.io.IOException;

/**
 * Parameters required for enabling SSL with Front Door-managed certificates.
 */
@Fluent
public final class FrontDoorCertificateSourceParameters
    implements JsonSerializable<FrontDoorCertificateSourceParameters> {
    /*
     * Defines the type of the certificate used for secure connections to a frontendEndpoint
     */
    private FrontDoorCertificateType certificateType;

    /**
     * Creates an instance of FrontDoorCertificateSourceParameters class.
     */
    public FrontDoorCertificateSourceParameters() {
    }

    /**
     * Get the certificateType property: Defines the type of the certificate used for secure connections to a
     * frontendEndpoint.
     * 
     * @return the certificateType value.
     */
    public FrontDoorCertificateType certificateType() {
        return this.certificateType;
    }

    /**
     * Set the certificateType property: Defines the type of the certificate used for secure connections to a
     * frontendEndpoint.
     * 
     * @param certificateType the certificateType value to set.
     * @return the FrontDoorCertificateSourceParameters object itself.
     */
    public FrontDoorCertificateSourceParameters withCertificateType(FrontDoorCertificateType certificateType) {
        this.certificateType = certificateType;
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
        jsonWriter.writeStringField("certificateType",
            this.certificateType == null ? null : this.certificateType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FrontDoorCertificateSourceParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FrontDoorCertificateSourceParameters if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the FrontDoorCertificateSourceParameters.
     */
    public static FrontDoorCertificateSourceParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FrontDoorCertificateSourceParameters deserializedFrontDoorCertificateSourceParameters
                = new FrontDoorCertificateSourceParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("certificateType".equals(fieldName)) {
                    deserializedFrontDoorCertificateSourceParameters.certificateType
                        = FrontDoorCertificateType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFrontDoorCertificateSourceParameters;
        });
    }
}
