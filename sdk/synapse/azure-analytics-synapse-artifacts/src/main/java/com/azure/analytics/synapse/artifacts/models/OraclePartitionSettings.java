// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The settings that will be leveraged for Oracle source partitioning.
 */
@Fluent
public final class OraclePartitionSettings implements JsonSerializable<OraclePartitionSettings> {
    /*
     * Names of the physical partitions of Oracle table.
     */
    @Generated
    private Object partitionNames;

    /*
     * The name of the column in integer type that will be used for proceeding range partitioning. Type: string (or
     * Expression with resultType string).
     */
    @Generated
    private Object partitionColumnName;

    /*
     * The maximum value of column specified in partitionColumnName that will be used for proceeding range partitioning.
     * Type: string (or Expression with resultType string).
     */
    @Generated
    private Object partitionUpperBound;

    /*
     * The minimum value of column specified in partitionColumnName that will be used for proceeding range partitioning.
     * Type: string (or Expression with resultType string).
     */
    @Generated
    private Object partitionLowerBound;

    /**
     * Creates an instance of OraclePartitionSettings class.
     */
    @Generated
    public OraclePartitionSettings() {
    }

    /**
     * Get the partitionNames property: Names of the physical partitions of Oracle table.
     * 
     * @return the partitionNames value.
     */
    @Generated
    public Object getPartitionNames() {
        return this.partitionNames;
    }

    /**
     * Set the partitionNames property: Names of the physical partitions of Oracle table.
     * 
     * @param partitionNames the partitionNames value to set.
     * @return the OraclePartitionSettings object itself.
     */
    @Generated
    public OraclePartitionSettings setPartitionNames(Object partitionNames) {
        this.partitionNames = partitionNames;
        return this;
    }

    /**
     * Get the partitionColumnName property: The name of the column in integer type that will be used for proceeding
     * range partitioning. Type: string (or Expression with resultType string).
     * 
     * @return the partitionColumnName value.
     */
    @Generated
    public Object getPartitionColumnName() {
        return this.partitionColumnName;
    }

    /**
     * Set the partitionColumnName property: The name of the column in integer type that will be used for proceeding
     * range partitioning. Type: string (or Expression with resultType string).
     * 
     * @param partitionColumnName the partitionColumnName value to set.
     * @return the OraclePartitionSettings object itself.
     */
    @Generated
    public OraclePartitionSettings setPartitionColumnName(Object partitionColumnName) {
        this.partitionColumnName = partitionColumnName;
        return this;
    }

    /**
     * Get the partitionUpperBound property: The maximum value of column specified in partitionColumnName that will be
     * used for proceeding range partitioning. Type: string (or Expression with resultType string).
     * 
     * @return the partitionUpperBound value.
     */
    @Generated
    public Object getPartitionUpperBound() {
        return this.partitionUpperBound;
    }

    /**
     * Set the partitionUpperBound property: The maximum value of column specified in partitionColumnName that will be
     * used for proceeding range partitioning. Type: string (or Expression with resultType string).
     * 
     * @param partitionUpperBound the partitionUpperBound value to set.
     * @return the OraclePartitionSettings object itself.
     */
    @Generated
    public OraclePartitionSettings setPartitionUpperBound(Object partitionUpperBound) {
        this.partitionUpperBound = partitionUpperBound;
        return this;
    }

    /**
     * Get the partitionLowerBound property: The minimum value of column specified in partitionColumnName that will be
     * used for proceeding range partitioning. Type: string (or Expression with resultType string).
     * 
     * @return the partitionLowerBound value.
     */
    @Generated
    public Object getPartitionLowerBound() {
        return this.partitionLowerBound;
    }

    /**
     * Set the partitionLowerBound property: The minimum value of column specified in partitionColumnName that will be
     * used for proceeding range partitioning. Type: string (or Expression with resultType string).
     * 
     * @param partitionLowerBound the partitionLowerBound value to set.
     * @return the OraclePartitionSettings object itself.
     */
    @Generated
    public OraclePartitionSettings setPartitionLowerBound(Object partitionLowerBound) {
        this.partitionLowerBound = partitionLowerBound;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (this.partitionNames != null) {
            jsonWriter.writeUntypedField("partitionNames", this.partitionNames);
        }
        if (this.partitionColumnName != null) {
            jsonWriter.writeUntypedField("partitionColumnName", this.partitionColumnName);
        }
        if (this.partitionUpperBound != null) {
            jsonWriter.writeUntypedField("partitionUpperBound", this.partitionUpperBound);
        }
        if (this.partitionLowerBound != null) {
            jsonWriter.writeUntypedField("partitionLowerBound", this.partitionLowerBound);
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OraclePartitionSettings from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OraclePartitionSettings if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the OraclePartitionSettings.
     */
    @Generated
    public static OraclePartitionSettings fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OraclePartitionSettings deserializedOraclePartitionSettings = new OraclePartitionSettings();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("partitionNames".equals(fieldName)) {
                    deserializedOraclePartitionSettings.partitionNames = reader.readUntyped();
                } else if ("partitionColumnName".equals(fieldName)) {
                    deserializedOraclePartitionSettings.partitionColumnName = reader.readUntyped();
                } else if ("partitionUpperBound".equals(fieldName)) {
                    deserializedOraclePartitionSettings.partitionUpperBound = reader.readUntyped();
                } else if ("partitionLowerBound".equals(fieldName)) {
                    deserializedOraclePartitionSettings.partitionLowerBound = reader.readUntyped();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOraclePartitionSettings;
        });
    }
}
