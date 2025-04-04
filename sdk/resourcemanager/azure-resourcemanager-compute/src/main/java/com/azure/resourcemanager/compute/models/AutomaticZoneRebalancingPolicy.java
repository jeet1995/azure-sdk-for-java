// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The configuration parameters used while performing automatic AZ balancing.
 */
@Fluent
public final class AutomaticZoneRebalancingPolicy implements JsonSerializable<AutomaticZoneRebalancingPolicy> {
    /*
     * Specifies whether Automatic AZ Balancing should be enabled on the virtual machine scale set. The default value is
     * false.
     */
    private Boolean enabled;

    /*
     * Type of rebalance strategy that will be used for rebalancing virtual machines in the scale set across
     * availability zones. Default and only supported value for now is Recreate.
     */
    private RebalanceStrategy rebalanceStrategy;

    /*
     * Type of rebalance behavior that will be used for recreating virtual machines in the scale set across availability
     * zones. Default and only supported value for now is CreateBeforeDelete.
     */
    private RebalanceBehavior rebalanceBehavior;

    /**
     * Creates an instance of AutomaticZoneRebalancingPolicy class.
     */
    public AutomaticZoneRebalancingPolicy() {
    }

    /**
     * Get the enabled property: Specifies whether Automatic AZ Balancing should be enabled on the virtual machine scale
     * set. The default value is false.
     * 
     * @return the enabled value.
     */
    public Boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Specifies whether Automatic AZ Balancing should be enabled on the virtual machine scale
     * set. The default value is false.
     * 
     * @param enabled the enabled value to set.
     * @return the AutomaticZoneRebalancingPolicy object itself.
     */
    public AutomaticZoneRebalancingPolicy withEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the rebalanceStrategy property: Type of rebalance strategy that will be used for rebalancing virtual machines
     * in the scale set across availability zones. Default and only supported value for now is Recreate.
     * 
     * @return the rebalanceStrategy value.
     */
    public RebalanceStrategy rebalanceStrategy() {
        return this.rebalanceStrategy;
    }

    /**
     * Set the rebalanceStrategy property: Type of rebalance strategy that will be used for rebalancing virtual machines
     * in the scale set across availability zones. Default and only supported value for now is Recreate.
     * 
     * @param rebalanceStrategy the rebalanceStrategy value to set.
     * @return the AutomaticZoneRebalancingPolicy object itself.
     */
    public AutomaticZoneRebalancingPolicy withRebalanceStrategy(RebalanceStrategy rebalanceStrategy) {
        this.rebalanceStrategy = rebalanceStrategy;
        return this;
    }

    /**
     * Get the rebalanceBehavior property: Type of rebalance behavior that will be used for recreating virtual machines
     * in the scale set across availability zones. Default and only supported value for now is CreateBeforeDelete.
     * 
     * @return the rebalanceBehavior value.
     */
    public RebalanceBehavior rebalanceBehavior() {
        return this.rebalanceBehavior;
    }

    /**
     * Set the rebalanceBehavior property: Type of rebalance behavior that will be used for recreating virtual machines
     * in the scale set across availability zones. Default and only supported value for now is CreateBeforeDelete.
     * 
     * @param rebalanceBehavior the rebalanceBehavior value to set.
     * @return the AutomaticZoneRebalancingPolicy object itself.
     */
    public AutomaticZoneRebalancingPolicy withRebalanceBehavior(RebalanceBehavior rebalanceBehavior) {
        this.rebalanceBehavior = rebalanceBehavior;
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
        jsonWriter.writeBooleanField("enabled", this.enabled);
        jsonWriter.writeStringField("rebalanceStrategy",
            this.rebalanceStrategy == null ? null : this.rebalanceStrategy.toString());
        jsonWriter.writeStringField("rebalanceBehavior",
            this.rebalanceBehavior == null ? null : this.rebalanceBehavior.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutomaticZoneRebalancingPolicy from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutomaticZoneRebalancingPolicy if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AutomaticZoneRebalancingPolicy.
     */
    public static AutomaticZoneRebalancingPolicy fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutomaticZoneRebalancingPolicy deserializedAutomaticZoneRebalancingPolicy
                = new AutomaticZoneRebalancingPolicy();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("enabled".equals(fieldName)) {
                    deserializedAutomaticZoneRebalancingPolicy.enabled = reader.getNullable(JsonReader::getBoolean);
                } else if ("rebalanceStrategy".equals(fieldName)) {
                    deserializedAutomaticZoneRebalancingPolicy.rebalanceStrategy
                        = RebalanceStrategy.fromString(reader.getString());
                } else if ("rebalanceBehavior".equals(fieldName)) {
                    deserializedAutomaticZoneRebalancingPolicy.rebalanceBehavior
                        = RebalanceBehavior.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutomaticZoneRebalancingPolicy;
        });
    }
}
