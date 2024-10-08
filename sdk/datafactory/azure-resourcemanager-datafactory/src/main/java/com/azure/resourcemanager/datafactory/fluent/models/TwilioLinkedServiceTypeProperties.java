// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.models.SecretBase;
import java.io.IOException;

/**
 * Twilio linked service type properties.
 */
@Fluent
public final class TwilioLinkedServiceTypeProperties implements JsonSerializable<TwilioLinkedServiceTypeProperties> {
    /*
     * The Account SID of Twilio service. Type: string (or Expression with resultType string).
     */
    private Object username;

    /*
     * The auth token of Twilio service.
     */
    private SecretBase password;

    /**
     * Creates an instance of TwilioLinkedServiceTypeProperties class.
     */
    public TwilioLinkedServiceTypeProperties() {
    }

    /**
     * Get the username property: The Account SID of Twilio service. Type: string (or Expression with resultType
     * string).
     * 
     * @return the username value.
     */
    public Object username() {
        return this.username;
    }

    /**
     * Set the username property: The Account SID of Twilio service. Type: string (or Expression with resultType
     * string).
     * 
     * @param username the username value to set.
     * @return the TwilioLinkedServiceTypeProperties object itself.
     */
    public TwilioLinkedServiceTypeProperties withUsername(Object username) {
        this.username = username;
        return this;
    }

    /**
     * Get the password property: The auth token of Twilio service.
     * 
     * @return the password value.
     */
    public SecretBase password() {
        return this.password;
    }

    /**
     * Set the password property: The auth token of Twilio service.
     * 
     * @param password the password value to set.
     * @return the TwilioLinkedServiceTypeProperties object itself.
     */
    public TwilioLinkedServiceTypeProperties withPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (username() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property username in model TwilioLinkedServiceTypeProperties"));
        }
        if (password() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property password in model TwilioLinkedServiceTypeProperties"));
        } else {
            password().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(TwilioLinkedServiceTypeProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("userName", this.username);
        jsonWriter.writeJsonField("password", this.password);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TwilioLinkedServiceTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TwilioLinkedServiceTypeProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TwilioLinkedServiceTypeProperties.
     */
    public static TwilioLinkedServiceTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TwilioLinkedServiceTypeProperties deserializedTwilioLinkedServiceTypeProperties
                = new TwilioLinkedServiceTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("userName".equals(fieldName)) {
                    deserializedTwilioLinkedServiceTypeProperties.username = reader.readUntyped();
                } else if ("password".equals(fieldName)) {
                    deserializedTwilioLinkedServiceTypeProperties.password = SecretBase.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTwilioLinkedServiceTypeProperties;
        });
    }
}
