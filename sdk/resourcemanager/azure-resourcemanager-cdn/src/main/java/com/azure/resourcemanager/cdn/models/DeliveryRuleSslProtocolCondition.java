// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Defines the SslProtocol condition for the delivery rule.
 */
@Fluent
public final class DeliveryRuleSslProtocolCondition extends DeliveryRuleCondition {
    /*
     * The name of the condition for the delivery rule.
     */
    private MatchVariable name = MatchVariable.SSL_PROTOCOL;

    /*
     * Defines the parameters for the condition.
     */
    private SslProtocolMatchConditionParameters parameters;

    /**
     * Creates an instance of DeliveryRuleSslProtocolCondition class.
     */
    public DeliveryRuleSslProtocolCondition() {
    }

    /**
     * Get the name property: The name of the condition for the delivery rule.
     * 
     * @return the name value.
     */
    @Override
    public MatchVariable name() {
        return this.name;
    }

    /**
     * Get the parameters property: Defines the parameters for the condition.
     * 
     * @return the parameters value.
     */
    public SslProtocolMatchConditionParameters parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Defines the parameters for the condition.
     * 
     * @param parameters the parameters value to set.
     * @return the DeliveryRuleSslProtocolCondition object itself.
     */
    public DeliveryRuleSslProtocolCondition withParameters(SslProtocolMatchConditionParameters parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (parameters() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property parameters in model DeliveryRuleSslProtocolCondition"));
        } else {
            parameters().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(DeliveryRuleSslProtocolCondition.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("parameters", this.parameters);
        jsonWriter.writeStringField("name", this.name == null ? null : this.name.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DeliveryRuleSslProtocolCondition from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeliveryRuleSslProtocolCondition if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DeliveryRuleSslProtocolCondition.
     */
    public static DeliveryRuleSslProtocolCondition fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DeliveryRuleSslProtocolCondition deserializedDeliveryRuleSslProtocolCondition
                = new DeliveryRuleSslProtocolCondition();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("parameters".equals(fieldName)) {
                    deserializedDeliveryRuleSslProtocolCondition.parameters
                        = SslProtocolMatchConditionParameters.fromJson(reader);
                } else if ("name".equals(fieldName)) {
                    deserializedDeliveryRuleSslProtocolCondition.name = MatchVariable.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDeliveryRuleSslProtocolCondition;
        });
    }
}
