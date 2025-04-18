// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Identity provider input.
 */
@Fluent
public final class IdentityProviderInput implements JsonSerializable<IdentityProviderInput> {
    /*
     * The tenant Id for the service principal with which the on-premise management/data plane components would
     * communicate with our Azure services.
     */
    private String tenantId;

    /*
     * The application/client Id for the service principal with which the on-premise management/data plane components
     * would communicate with our Azure services.
     */
    private String applicationId;

    /*
     * The object Id of the service principal with which the on-premise management/data plane components would
     * communicate with our Azure services.
     */
    private String objectId;

    /*
     * The intended Audience of the service principal with which the on-premise management/data plane components would
     * communicate with our Azure services.
     */
    private String audience;

    /*
     * The base authority for Azure Active Directory authentication.
     */
    private String aadAuthority;

    /**
     * Creates an instance of IdentityProviderInput class.
     */
    public IdentityProviderInput() {
    }

    /**
     * Get the tenantId property: The tenant Id for the service principal with which the on-premise management/data
     * plane components would communicate with our Azure services.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Set the tenantId property: The tenant Id for the service principal with which the on-premise management/data
     * plane components would communicate with our Azure services.
     * 
     * @param tenantId the tenantId value to set.
     * @return the IdentityProviderInput object itself.
     */
    public IdentityProviderInput withTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    /**
     * Get the applicationId property: The application/client Id for the service principal with which the on-premise
     * management/data plane components would communicate with our Azure services.
     * 
     * @return the applicationId value.
     */
    public String applicationId() {
        return this.applicationId;
    }

    /**
     * Set the applicationId property: The application/client Id for the service principal with which the on-premise
     * management/data plane components would communicate with our Azure services.
     * 
     * @param applicationId the applicationId value to set.
     * @return the IdentityProviderInput object itself.
     */
    public IdentityProviderInput withApplicationId(String applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    /**
     * Get the objectId property: The object Id of the service principal with which the on-premise management/data plane
     * components would communicate with our Azure services.
     * 
     * @return the objectId value.
     */
    public String objectId() {
        return this.objectId;
    }

    /**
     * Set the objectId property: The object Id of the service principal with which the on-premise management/data plane
     * components would communicate with our Azure services.
     * 
     * @param objectId the objectId value to set.
     * @return the IdentityProviderInput object itself.
     */
    public IdentityProviderInput withObjectId(String objectId) {
        this.objectId = objectId;
        return this;
    }

    /**
     * Get the audience property: The intended Audience of the service principal with which the on-premise
     * management/data plane components would communicate with our Azure services.
     * 
     * @return the audience value.
     */
    public String audience() {
        return this.audience;
    }

    /**
     * Set the audience property: The intended Audience of the service principal with which the on-premise
     * management/data plane components would communicate with our Azure services.
     * 
     * @param audience the audience value to set.
     * @return the IdentityProviderInput object itself.
     */
    public IdentityProviderInput withAudience(String audience) {
        this.audience = audience;
        return this;
    }

    /**
     * Get the aadAuthority property: The base authority for Azure Active Directory authentication.
     * 
     * @return the aadAuthority value.
     */
    public String aadAuthority() {
        return this.aadAuthority;
    }

    /**
     * Set the aadAuthority property: The base authority for Azure Active Directory authentication.
     * 
     * @param aadAuthority the aadAuthority value to set.
     * @return the IdentityProviderInput object itself.
     */
    public IdentityProviderInput withAadAuthority(String aadAuthority) {
        this.aadAuthority = aadAuthority;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (tenantId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property tenantId in model IdentityProviderInput"));
        }
        if (applicationId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property applicationId in model IdentityProviderInput"));
        }
        if (objectId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property objectId in model IdentityProviderInput"));
        }
        if (audience() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property audience in model IdentityProviderInput"));
        }
        if (aadAuthority() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property aadAuthority in model IdentityProviderInput"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IdentityProviderInput.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("tenantId", this.tenantId);
        jsonWriter.writeStringField("applicationId", this.applicationId);
        jsonWriter.writeStringField("objectId", this.objectId);
        jsonWriter.writeStringField("audience", this.audience);
        jsonWriter.writeStringField("aadAuthority", this.aadAuthority);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IdentityProviderInput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IdentityProviderInput if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IdentityProviderInput.
     */
    public static IdentityProviderInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IdentityProviderInput deserializedIdentityProviderInput = new IdentityProviderInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("tenantId".equals(fieldName)) {
                    deserializedIdentityProviderInput.tenantId = reader.getString();
                } else if ("applicationId".equals(fieldName)) {
                    deserializedIdentityProviderInput.applicationId = reader.getString();
                } else if ("objectId".equals(fieldName)) {
                    deserializedIdentityProviderInput.objectId = reader.getString();
                } else if ("audience".equals(fieldName)) {
                    deserializedIdentityProviderInput.audience = reader.getString();
                } else if ("aadAuthority".equals(fieldName)) {
                    deserializedIdentityProviderInput.aadAuthority = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIdentityProviderInput;
        });
    }
}
