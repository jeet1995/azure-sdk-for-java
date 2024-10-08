// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Allows to disable rules within a rule group or an entire rule group.
 */
@Fluent
public final class ApplicationGatewayFirewallDisabledRuleGroup
    implements JsonSerializable<ApplicationGatewayFirewallDisabledRuleGroup> {
    /*
     * The name of the rule group that will be disabled.
     */
    private String ruleGroupName;

    /*
     * The list of rules that will be disabled. If null, all rules of the rule group will be disabled.
     */
    private List<Integer> rules;

    /**
     * Creates an instance of ApplicationGatewayFirewallDisabledRuleGroup class.
     */
    public ApplicationGatewayFirewallDisabledRuleGroup() {
    }

    /**
     * Get the ruleGroupName property: The name of the rule group that will be disabled.
     * 
     * @return the ruleGroupName value.
     */
    public String ruleGroupName() {
        return this.ruleGroupName;
    }

    /**
     * Set the ruleGroupName property: The name of the rule group that will be disabled.
     * 
     * @param ruleGroupName the ruleGroupName value to set.
     * @return the ApplicationGatewayFirewallDisabledRuleGroup object itself.
     */
    public ApplicationGatewayFirewallDisabledRuleGroup withRuleGroupName(String ruleGroupName) {
        this.ruleGroupName = ruleGroupName;
        return this;
    }

    /**
     * Get the rules property: The list of rules that will be disabled. If null, all rules of the rule group will be
     * disabled.
     * 
     * @return the rules value.
     */
    public List<Integer> rules() {
        return this.rules;
    }

    /**
     * Set the rules property: The list of rules that will be disabled. If null, all rules of the rule group will be
     * disabled.
     * 
     * @param rules the rules value to set.
     * @return the ApplicationGatewayFirewallDisabledRuleGroup object itself.
     */
    public ApplicationGatewayFirewallDisabledRuleGroup withRules(List<Integer> rules) {
        this.rules = rules;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (ruleGroupName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property ruleGroupName in model ApplicationGatewayFirewallDisabledRuleGroup"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ApplicationGatewayFirewallDisabledRuleGroup.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("ruleGroupName", this.ruleGroupName);
        jsonWriter.writeArrayField("rules", this.rules, (writer, element) -> writer.writeInt(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApplicationGatewayFirewallDisabledRuleGroup from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApplicationGatewayFirewallDisabledRuleGroup if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ApplicationGatewayFirewallDisabledRuleGroup.
     */
    public static ApplicationGatewayFirewallDisabledRuleGroup fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ApplicationGatewayFirewallDisabledRuleGroup deserializedApplicationGatewayFirewallDisabledRuleGroup
                = new ApplicationGatewayFirewallDisabledRuleGroup();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ruleGroupName".equals(fieldName)) {
                    deserializedApplicationGatewayFirewallDisabledRuleGroup.ruleGroupName = reader.getString();
                } else if ("rules".equals(fieldName)) {
                    List<Integer> rules = reader.readArray(reader1 -> reader1.getInt());
                    deserializedApplicationGatewayFirewallDisabledRuleGroup.rules = rules;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedApplicationGatewayFirewallDisabledRuleGroup;
        });
    }
}
