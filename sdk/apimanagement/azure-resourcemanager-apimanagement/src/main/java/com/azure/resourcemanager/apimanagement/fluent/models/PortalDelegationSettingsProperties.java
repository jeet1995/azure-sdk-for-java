// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.apimanagement.models.RegistrationDelegationSettingsProperties;
import com.azure.resourcemanager.apimanagement.models.SubscriptionsDelegationSettingsProperties;
import java.io.IOException;

/**
 * Delegation settings contract properties.
 */
@Fluent
public final class PortalDelegationSettingsProperties implements JsonSerializable<PortalDelegationSettingsProperties> {
    /*
     * A delegation Url.
     */
    private String url;

    /*
     * A base64-encoded validation key to validate, that a request is coming from Azure API Management.
     */
    private String validationKey;

    /*
     * Subscriptions delegation settings.
     */
    private SubscriptionsDelegationSettingsProperties subscriptions;

    /*
     * User registration delegation settings.
     */
    private RegistrationDelegationSettingsProperties userRegistration;

    /**
     * Creates an instance of PortalDelegationSettingsProperties class.
     */
    public PortalDelegationSettingsProperties() {
    }

    /**
     * Get the url property: A delegation Url.
     * 
     * @return the url value.
     */
    public String url() {
        return this.url;
    }

    /**
     * Set the url property: A delegation Url.
     * 
     * @param url the url value to set.
     * @return the PortalDelegationSettingsProperties object itself.
     */
    public PortalDelegationSettingsProperties withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get the validationKey property: A base64-encoded validation key to validate, that a request is coming from Azure
     * API Management.
     * 
     * @return the validationKey value.
     */
    public String validationKey() {
        return this.validationKey;
    }

    /**
     * Set the validationKey property: A base64-encoded validation key to validate, that a request is coming from Azure
     * API Management.
     * 
     * @param validationKey the validationKey value to set.
     * @return the PortalDelegationSettingsProperties object itself.
     */
    public PortalDelegationSettingsProperties withValidationKey(String validationKey) {
        this.validationKey = validationKey;
        return this;
    }

    /**
     * Get the subscriptions property: Subscriptions delegation settings.
     * 
     * @return the subscriptions value.
     */
    public SubscriptionsDelegationSettingsProperties subscriptions() {
        return this.subscriptions;
    }

    /**
     * Set the subscriptions property: Subscriptions delegation settings.
     * 
     * @param subscriptions the subscriptions value to set.
     * @return the PortalDelegationSettingsProperties object itself.
     */
    public PortalDelegationSettingsProperties
        withSubscriptions(SubscriptionsDelegationSettingsProperties subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }

    /**
     * Get the userRegistration property: User registration delegation settings.
     * 
     * @return the userRegistration value.
     */
    public RegistrationDelegationSettingsProperties userRegistration() {
        return this.userRegistration;
    }

    /**
     * Set the userRegistration property: User registration delegation settings.
     * 
     * @param userRegistration the userRegistration value to set.
     * @return the PortalDelegationSettingsProperties object itself.
     */
    public PortalDelegationSettingsProperties
        withUserRegistration(RegistrationDelegationSettingsProperties userRegistration) {
        this.userRegistration = userRegistration;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (subscriptions() != null) {
            subscriptions().validate();
        }
        if (userRegistration() != null) {
            userRegistration().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("url", this.url);
        jsonWriter.writeStringField("validationKey", this.validationKey);
        jsonWriter.writeJsonField("subscriptions", this.subscriptions);
        jsonWriter.writeJsonField("userRegistration", this.userRegistration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PortalDelegationSettingsProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PortalDelegationSettingsProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the PortalDelegationSettingsProperties.
     */
    public static PortalDelegationSettingsProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PortalDelegationSettingsProperties deserializedPortalDelegationSettingsProperties
                = new PortalDelegationSettingsProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("url".equals(fieldName)) {
                    deserializedPortalDelegationSettingsProperties.url = reader.getString();
                } else if ("validationKey".equals(fieldName)) {
                    deserializedPortalDelegationSettingsProperties.validationKey = reader.getString();
                } else if ("subscriptions".equals(fieldName)) {
                    deserializedPortalDelegationSettingsProperties.subscriptions
                        = SubscriptionsDelegationSettingsProperties.fromJson(reader);
                } else if ("userRegistration".equals(fieldName)) {
                    deserializedPortalDelegationSettingsProperties.userRegistration
                        = RegistrationDelegationSettingsProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPortalDelegationSettingsProperties;
        });
    }
}
