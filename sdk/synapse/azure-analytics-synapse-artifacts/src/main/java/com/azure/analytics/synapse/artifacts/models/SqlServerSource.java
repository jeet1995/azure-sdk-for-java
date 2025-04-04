// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A copy activity SQL server source.
 */
@Fluent
public final class SqlServerSource extends TabularSource {
    /*
     * Copy source type.
     */
    private String type = "SqlServerSource";

    /*
     * SQL reader query. Type: string (or Expression with resultType string).
     */
    private Object sqlReaderQuery;

    /*
     * Name of the stored procedure for a SQL Database source. This cannot be used at the same time as SqlReaderQuery.
     * Type: string (or Expression with resultType string).
     */
    private Object sqlReaderStoredProcedureName;

    /*
     * Value and type setting for stored procedure parameters. Example: "{Parameter1: {value: "1", type: "int"}}".
     */
    private Object storedProcedureParameters;

    /*
     * Specifies the transaction locking behavior for the SQL source. Allowed values:
     * ReadCommitted/ReadUncommitted/RepeatableRead/Serializable/Snapshot. The default value is ReadCommitted. Type:
     * string (or Expression with resultType string).
     */
    private Object isolationLevel;

    /*
     * Which additional types to produce.
     */
    private Object produceAdditionalTypes;

    /*
     * The partition mechanism that will be used for Sql read in parallel. Possible values include: "None",
     * "PhysicalPartitionsOfTable", "DynamicRange".
     */
    private Object partitionOption;

    /*
     * The settings that will be leveraged for Sql source partitioning.
     */
    private SqlPartitionSettings partitionSettings;

    /**
     * Creates an instance of SqlServerSource class.
     */
    public SqlServerSource() {
    }

    /**
     * Get the type property: Copy source type.
     * 
     * @return the type value.
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the sqlReaderQuery property: SQL reader query. Type: string (or Expression with resultType string).
     * 
     * @return the sqlReaderQuery value.
     */
    public Object getSqlReaderQuery() {
        return this.sqlReaderQuery;
    }

    /**
     * Set the sqlReaderQuery property: SQL reader query. Type: string (or Expression with resultType string).
     * 
     * @param sqlReaderQuery the sqlReaderQuery value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setSqlReaderQuery(Object sqlReaderQuery) {
        this.sqlReaderQuery = sqlReaderQuery;
        return this;
    }

    /**
     * Get the sqlReaderStoredProcedureName property: Name of the stored procedure for a SQL Database source. This
     * cannot be used at the same time as SqlReaderQuery. Type: string (or Expression with resultType string).
     * 
     * @return the sqlReaderStoredProcedureName value.
     */
    public Object getSqlReaderStoredProcedureName() {
        return this.sqlReaderStoredProcedureName;
    }

    /**
     * Set the sqlReaderStoredProcedureName property: Name of the stored procedure for a SQL Database source. This
     * cannot be used at the same time as SqlReaderQuery. Type: string (or Expression with resultType string).
     * 
     * @param sqlReaderStoredProcedureName the sqlReaderStoredProcedureName value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setSqlReaderStoredProcedureName(Object sqlReaderStoredProcedureName) {
        this.sqlReaderStoredProcedureName = sqlReaderStoredProcedureName;
        return this;
    }

    /**
     * Get the storedProcedureParameters property: Value and type setting for stored procedure parameters. Example:
     * "{Parameter1: {value: "1", type: "int"}}".
     * 
     * @return the storedProcedureParameters value.
     */
    public Object getStoredProcedureParameters() {
        return this.storedProcedureParameters;
    }

    /**
     * Set the storedProcedureParameters property: Value and type setting for stored procedure parameters. Example:
     * "{Parameter1: {value: "1", type: "int"}}".
     * 
     * @param storedProcedureParameters the storedProcedureParameters value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setStoredProcedureParameters(Object storedProcedureParameters) {
        this.storedProcedureParameters = storedProcedureParameters;
        return this;
    }

    /**
     * Get the isolationLevel property: Specifies the transaction locking behavior for the SQL source. Allowed values:
     * ReadCommitted/ReadUncommitted/RepeatableRead/Serializable/Snapshot. The default value is ReadCommitted. Type:
     * string (or Expression with resultType string).
     * 
     * @return the isolationLevel value.
     */
    public Object getIsolationLevel() {
        return this.isolationLevel;
    }

    /**
     * Set the isolationLevel property: Specifies the transaction locking behavior for the SQL source. Allowed values:
     * ReadCommitted/ReadUncommitted/RepeatableRead/Serializable/Snapshot. The default value is ReadCommitted. Type:
     * string (or Expression with resultType string).
     * 
     * @param isolationLevel the isolationLevel value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setIsolationLevel(Object isolationLevel) {
        this.isolationLevel = isolationLevel;
        return this;
    }

    /**
     * Get the produceAdditionalTypes property: Which additional types to produce.
     * 
     * @return the produceAdditionalTypes value.
     */
    public Object getProduceAdditionalTypes() {
        return this.produceAdditionalTypes;
    }

    /**
     * Set the produceAdditionalTypes property: Which additional types to produce.
     * 
     * @param produceAdditionalTypes the produceAdditionalTypes value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setProduceAdditionalTypes(Object produceAdditionalTypes) {
        this.produceAdditionalTypes = produceAdditionalTypes;
        return this;
    }

    /**
     * Get the partitionOption property: The partition mechanism that will be used for Sql read in parallel. Possible
     * values include: "None", "PhysicalPartitionsOfTable", "DynamicRange".
     * 
     * @return the partitionOption value.
     */
    public Object getPartitionOption() {
        return this.partitionOption;
    }

    /**
     * Set the partitionOption property: The partition mechanism that will be used for Sql read in parallel. Possible
     * values include: "None", "PhysicalPartitionsOfTable", "DynamicRange".
     * 
     * @param partitionOption the partitionOption value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setPartitionOption(Object partitionOption) {
        this.partitionOption = partitionOption;
        return this;
    }

    /**
     * Get the partitionSettings property: The settings that will be leveraged for Sql source partitioning.
     * 
     * @return the partitionSettings value.
     */
    public SqlPartitionSettings getPartitionSettings() {
        return this.partitionSettings;
    }

    /**
     * Set the partitionSettings property: The settings that will be leveraged for Sql source partitioning.
     * 
     * @param partitionSettings the partitionSettings value to set.
     * @return the SqlServerSource object itself.
     */
    public SqlServerSource setPartitionSettings(SqlPartitionSettings partitionSettings) {
        this.partitionSettings = partitionSettings;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlServerSource setQueryTimeout(Object queryTimeout) {
        super.setQueryTimeout(queryTimeout);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlServerSource setAdditionalColumns(Object additionalColumns) {
        super.setAdditionalColumns(additionalColumns);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlServerSource setSourceRetryCount(Object sourceRetryCount) {
        super.setSourceRetryCount(sourceRetryCount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlServerSource setSourceRetryWait(Object sourceRetryWait) {
        super.setSourceRetryWait(sourceRetryWait);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlServerSource setMaxConcurrentConnections(Object maxConcurrentConnections) {
        super.setMaxConcurrentConnections(maxConcurrentConnections);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("sourceRetryCount", getSourceRetryCount());
        jsonWriter.writeUntypedField("sourceRetryWait", getSourceRetryWait());
        jsonWriter.writeUntypedField("maxConcurrentConnections", getMaxConcurrentConnections());
        jsonWriter.writeUntypedField("queryTimeout", getQueryTimeout());
        jsonWriter.writeUntypedField("additionalColumns", getAdditionalColumns());
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeUntypedField("sqlReaderQuery", this.sqlReaderQuery);
        jsonWriter.writeUntypedField("sqlReaderStoredProcedureName", this.sqlReaderStoredProcedureName);
        jsonWriter.writeUntypedField("storedProcedureParameters", this.storedProcedureParameters);
        jsonWriter.writeUntypedField("isolationLevel", this.isolationLevel);
        jsonWriter.writeUntypedField("produceAdditionalTypes", this.produceAdditionalTypes);
        jsonWriter.writeUntypedField("partitionOption", this.partitionOption);
        jsonWriter.writeJsonField("partitionSettings", this.partitionSettings);
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SqlServerSource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SqlServerSource if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SqlServerSource.
     */
    public static SqlServerSource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SqlServerSource deserializedSqlServerSource = new SqlServerSource();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("sourceRetryCount".equals(fieldName)) {
                    deserializedSqlServerSource.setSourceRetryCount(reader.readUntyped());
                } else if ("sourceRetryWait".equals(fieldName)) {
                    deserializedSqlServerSource.setSourceRetryWait(reader.readUntyped());
                } else if ("maxConcurrentConnections".equals(fieldName)) {
                    deserializedSqlServerSource.setMaxConcurrentConnections(reader.readUntyped());
                } else if ("queryTimeout".equals(fieldName)) {
                    deserializedSqlServerSource.setQueryTimeout(reader.readUntyped());
                } else if ("additionalColumns".equals(fieldName)) {
                    deserializedSqlServerSource.setAdditionalColumns(reader.readUntyped());
                } else if ("type".equals(fieldName)) {
                    deserializedSqlServerSource.type = reader.getString();
                } else if ("sqlReaderQuery".equals(fieldName)) {
                    deserializedSqlServerSource.sqlReaderQuery = reader.readUntyped();
                } else if ("sqlReaderStoredProcedureName".equals(fieldName)) {
                    deserializedSqlServerSource.sqlReaderStoredProcedureName = reader.readUntyped();
                } else if ("storedProcedureParameters".equals(fieldName)) {
                    deserializedSqlServerSource.storedProcedureParameters = reader.readUntyped();
                } else if ("isolationLevel".equals(fieldName)) {
                    deserializedSqlServerSource.isolationLevel = reader.readUntyped();
                } else if ("produceAdditionalTypes".equals(fieldName)) {
                    deserializedSqlServerSource.produceAdditionalTypes = reader.readUntyped();
                } else if ("partitionOption".equals(fieldName)) {
                    deserializedSqlServerSource.partitionOption = reader.readUntyped();
                } else if ("partitionSettings".equals(fieldName)) {
                    deserializedSqlServerSource.partitionSettings = SqlPartitionSettings.fromJson(reader);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedSqlServerSource.setAdditionalProperties(additionalProperties);

            return deserializedSqlServerSource;
        });
    }
}
