// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.newrelicobservability.models.LogRules;
import java.io.IOException;

/**
 * The type used for update operations of the TagRule.
 */
@Fluent
public final class TagRuleUpdateInner implements JsonSerializable<TagRuleUpdateInner> {
    /*
     * The updatable properties of the TagRule.
     */
    private TagRuleUpdatePropertiesInner innerProperties;

    /**
     * Creates an instance of TagRuleUpdateInner class.
     */
    public TagRuleUpdateInner() {
    }

    /**
     * Get the innerProperties property: The updatable properties of the TagRule.
     * 
     * @return the innerProperties value.
     */
    private TagRuleUpdatePropertiesInner innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the logRules property: Set of rules for sending logs for the Monitor resource.
     * 
     * @return the logRules value.
     */
    public LogRules logRules() {
        return this.innerProperties() == null ? null : this.innerProperties().logRules();
    }

    /**
     * Set the logRules property: Set of rules for sending logs for the Monitor resource.
     * 
     * @param logRules the logRules value to set.
     * @return the TagRuleUpdateInner object itself.
     */
    public TagRuleUpdateInner withLogRules(LogRules logRules) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TagRuleUpdatePropertiesInner();
        }
        this.innerProperties().withLogRules(logRules);
        return this;
    }

    /**
     * Get the metricRules property: Set of rules for sending metrics for the Monitor resource.
     * 
     * @return the metricRules value.
     */
    public MetricRulesInner metricRules() {
        return this.innerProperties() == null ? null : this.innerProperties().metricRules();
    }

    /**
     * Set the metricRules property: Set of rules for sending metrics for the Monitor resource.
     * 
     * @param metricRules the metricRules value to set.
     * @return the TagRuleUpdateInner object itself.
     */
    public TagRuleUpdateInner withMetricRules(MetricRulesInner metricRules) {
        if (this.innerProperties() == null) {
            this.innerProperties = new TagRuleUpdatePropertiesInner();
        }
        this.innerProperties().withMetricRules(metricRules);
        return this;
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
     * Reads an instance of TagRuleUpdateInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TagRuleUpdateInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the TagRuleUpdateInner.
     */
    public static TagRuleUpdateInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TagRuleUpdateInner deserializedTagRuleUpdateInner = new TagRuleUpdateInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedTagRuleUpdateInner.innerProperties = TagRuleUpdatePropertiesInner.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTagRuleUpdateInner;
        });
    }
}
