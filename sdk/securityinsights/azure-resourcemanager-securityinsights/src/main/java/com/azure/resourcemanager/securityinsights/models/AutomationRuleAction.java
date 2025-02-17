// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Describes an automation rule action.
 */
@Fluent
public class AutomationRuleAction implements JsonSerializable<AutomationRuleAction> {
    /*
     * The type of the automation rule action.
     */
    private ActionType actionType = ActionType.fromString("AutomationRuleAction");

    /*
     * The order property.
     */
    private int order;

    /**
     * Creates an instance of AutomationRuleAction class.
     */
    public AutomationRuleAction() {
    }

    /**
     * Get the actionType property: The type of the automation rule action.
     * 
     * @return the actionType value.
     */
    public ActionType actionType() {
        return this.actionType;
    }

    /**
     * Get the order property: The order property.
     * 
     * @return the order value.
     */
    public int order() {
        return this.order;
    }

    /**
     * Set the order property: The order property.
     * 
     * @param order the order value to set.
     * @return the AutomationRuleAction object itself.
     */
    public AutomationRuleAction withOrder(int order) {
        this.order = order;
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
        jsonWriter.writeIntField("order", this.order);
        jsonWriter.writeStringField("actionType", this.actionType == null ? null : this.actionType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutomationRuleAction from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutomationRuleAction if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AutomationRuleAction.
     */
    public static AutomationRuleAction fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("actionType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("ModifyProperties".equals(discriminatorValue)) {
                    return AutomationRuleModifyPropertiesAction.fromJson(readerToUse.reset());
                } else if ("RunPlaybook".equals(discriminatorValue)) {
                    return AutomationRuleRunPlaybookAction.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static AutomationRuleAction fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutomationRuleAction deserializedAutomationRuleAction = new AutomationRuleAction();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("order".equals(fieldName)) {
                    deserializedAutomationRuleAction.order = reader.getInt();
                } else if ("actionType".equals(fieldName)) {
                    deserializedAutomationRuleAction.actionType = ActionType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutomationRuleAction;
        });
    }
}
