// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A management event rule condition.
 */
@Fluent
public final class ManagementEventRuleCondition extends RuleCondition {
    /*
     * specifies the type of condition. This can be one of three types: ManagementEventRuleCondition (occurrences of
     * management events), LocationThresholdRuleCondition (based on the number of failures of a web test), and
     * ThresholdRuleCondition (based on the threshold of a metric).
     */
    private String odataType = "Microsoft.Azure.Management.Insights.Models.ManagementEventRuleCondition";

    /*
     * How the data that is collected should be combined over time and when the alert is activated. Note that for
     * management event alerts aggregation is optional – if it is not provided then any event will cause the alert to
     * activate.
     */
    private ManagementEventAggregationCondition aggregation;

    /**
     * Creates an instance of ManagementEventRuleCondition class.
     */
    public ManagementEventRuleCondition() {
    }

    /**
     * Get the odataType property: specifies the type of condition. This can be one of three types:
     * ManagementEventRuleCondition (occurrences of management events), LocationThresholdRuleCondition (based on the
     * number of failures of a web test), and ThresholdRuleCondition (based on the threshold of a metric).
     * 
     * @return the odataType value.
     */
    @Override
    public String odataType() {
        return this.odataType;
    }

    /**
     * Get the aggregation property: How the data that is collected should be combined over time and when the alert is
     * activated. Note that for management event alerts aggregation is optional – if it is not provided then any event
     * will cause the alert to activate.
     * 
     * @return the aggregation value.
     */
    public ManagementEventAggregationCondition aggregation() {
        return this.aggregation;
    }

    /**
     * Set the aggregation property: How the data that is collected should be combined over time and when the alert is
     * activated. Note that for management event alerts aggregation is optional – if it is not provided then any event
     * will cause the alert to activate.
     * 
     * @param aggregation the aggregation value to set.
     * @return the ManagementEventRuleCondition object itself.
     */
    public ManagementEventRuleCondition withAggregation(ManagementEventAggregationCondition aggregation) {
        this.aggregation = aggregation;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ManagementEventRuleCondition withDataSource(RuleDataSource dataSource) {
        super.withDataSource(dataSource);
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
        if (aggregation() != null) {
            aggregation().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("dataSource", dataSource());
        jsonWriter.writeStringField("odata.type", this.odataType);
        jsonWriter.writeJsonField("aggregation", this.aggregation);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ManagementEventRuleCondition from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ManagementEventRuleCondition if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ManagementEventRuleCondition.
     */
    public static ManagementEventRuleCondition fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ManagementEventRuleCondition deserializedManagementEventRuleCondition = new ManagementEventRuleCondition();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("dataSource".equals(fieldName)) {
                    deserializedManagementEventRuleCondition.withDataSource(RuleDataSource.fromJson(reader));
                } else if ("odata.type".equals(fieldName)) {
                    deserializedManagementEventRuleCondition.odataType = reader.getString();
                } else if ("aggregation".equals(fieldName)) {
                    deserializedManagementEventRuleCondition.aggregation
                        = ManagementEventAggregationCondition.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedManagementEventRuleCondition;
        });
    }
}
