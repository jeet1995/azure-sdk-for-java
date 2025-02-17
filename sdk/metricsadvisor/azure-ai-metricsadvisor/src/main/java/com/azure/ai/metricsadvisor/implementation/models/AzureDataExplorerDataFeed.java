// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * The AzureDataExplorerDataFeed model.
 */
@Fluent
public final class AzureDataExplorerDataFeed extends DataFeedDetail {
    /*
     * data source type
     */
    private DataSourceType dataSourceType = DataSourceType.AZURE_DATA_EXPLORER;

    /*
     * The dataSourceParameter property.
     */
    private SqlSourceParameter dataSourceParameter;

    /*
     * data feed created time
     */
    private OffsetDateTime createdTime;

    /*
     * data feed status
     */
    private EntityStatus status;

    /*
     * data feed creator
     */
    private String creator;

    /*
     * the query user is one of data feed administrator or not
     */
    private Boolean isAdmin;

    /*
     * data feed unique id
     */
    private UUID dataFeedId;

    /**
     * Creates an instance of AzureDataExplorerDataFeed class.
     */
    public AzureDataExplorerDataFeed() {
    }

    /**
     * Get the dataSourceType property: data source type.
     * 
     * @return the dataSourceType value.
     */
    @Override
    public DataSourceType getDataSourceType() {
        return this.dataSourceType;
    }

    /**
     * Get the dataSourceParameter property: The dataSourceParameter property.
     * 
     * @return the dataSourceParameter value.
     */
    public SqlSourceParameter getDataSourceParameter() {
        return this.dataSourceParameter;
    }

    /**
     * Set the dataSourceParameter property: The dataSourceParameter property.
     * 
     * @param dataSourceParameter the dataSourceParameter value to set.
     * @return the AzureDataExplorerDataFeed object itself.
     */
    public AzureDataExplorerDataFeed setDataSourceParameter(SqlSourceParameter dataSourceParameter) {
        this.dataSourceParameter = dataSourceParameter;
        return this;
    }

    /**
     * Get the createdTime property: data feed created time.
     * 
     * @return the createdTime value.
     */
    @Override
    public OffsetDateTime getCreatedTime() {
        return this.createdTime;
    }

    /**
     * Get the status property: data feed status.
     * 
     * @return the status value.
     */
    @Override
    public EntityStatus getStatus() {
        return this.status;
    }

    /**
     * Get the creator property: data feed creator.
     * 
     * @return the creator value.
     */
    @Override
    public String getCreator() {
        return this.creator;
    }

    /**
     * Get the isAdmin property: the query user is one of data feed administrator or not.
     * 
     * @return the isAdmin value.
     */
    @Override
    public Boolean isAdmin() {
        return this.isAdmin;
    }

    /**
     * Get the dataFeedId property: data feed unique id.
     * 
     * @return the dataFeedId value.
     */
    @Override
    public UUID getDataFeedId() {
        return this.dataFeedId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setDataFeedName(String dataFeedName) {
        super.setDataFeedName(dataFeedName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setDataFeedDescription(String dataFeedDescription) {
        super.setDataFeedDescription(dataFeedDescription);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setGranularityName(Granularity granularityName) {
        super.setGranularityName(granularityName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setGranularityAmount(Integer granularityAmount) {
        super.setGranularityAmount(granularityAmount);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setMetrics(List<DataFeedMetric> metrics) {
        super.setMetrics(metrics);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setDimension(List<DataFeedDimension> dimension) {
        super.setDimension(dimension);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setTimestampColumn(String timestampColumn) {
        super.setTimestampColumn(timestampColumn);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setDataStartFrom(OffsetDateTime dataStartFrom) {
        super.setDataStartFrom(dataStartFrom);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setStartOffsetInSeconds(Long startOffsetInSeconds) {
        super.setStartOffsetInSeconds(startOffsetInSeconds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setMaxConcurrency(Integer maxConcurrency) {
        super.setMaxConcurrency(maxConcurrency);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setMinRetryIntervalInSeconds(Long minRetryIntervalInSeconds) {
        super.setMinRetryIntervalInSeconds(minRetryIntervalInSeconds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setStopRetryAfterInSeconds(Long stopRetryAfterInSeconds) {
        super.setStopRetryAfterInSeconds(stopRetryAfterInSeconds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setNeedRollup(NeedRollupEnum needRollup) {
        super.setNeedRollup(needRollup);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setRollUpMethod(RollUpMethod rollUpMethod) {
        super.setRollUpMethod(rollUpMethod);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setRollUpColumns(List<String> rollUpColumns) {
        super.setRollUpColumns(rollUpColumns);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setAllUpIdentification(String allUpIdentification) {
        super.setAllUpIdentification(allUpIdentification);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setFillMissingPointType(FillMissingPointType fillMissingPointType) {
        super.setFillMissingPointType(fillMissingPointType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setFillMissingPointValue(Double fillMissingPointValue) {
        super.setFillMissingPointValue(fillMissingPointValue);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setViewMode(ViewMode viewMode) {
        super.setViewMode(viewMode);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setAdmins(List<String> admins) {
        super.setAdmins(admins);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setViewers(List<String> viewers) {
        super.setViewers(viewers);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setActionLinkTemplate(String actionLinkTemplate) {
        super.setActionLinkTemplate(actionLinkTemplate);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setAuthenticationType(AuthenticationTypeEnum authenticationType) {
        super.setAuthenticationType(authenticationType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AzureDataExplorerDataFeed setCredentialId(String credentialId) {
        super.setCredentialId(credentialId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("dataFeedName", getDataFeedName());
        jsonWriter.writeStringField("granularityName",
            getGranularityName() == null ? null : getGranularityName().toString());
        jsonWriter.writeArrayField("metrics", getMetrics(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("dataStartFrom",
            getDataStartFrom() == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(getDataStartFrom()));
        jsonWriter.writeStringField("dataFeedDescription", getDataFeedDescription());
        jsonWriter.writeNumberField("granularityAmount", getGranularityAmount());
        jsonWriter.writeArrayField("dimension", getDimension(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("timestampColumn", getTimestampColumn());
        jsonWriter.writeNumberField("startOffsetInSeconds", getStartOffsetInSeconds());
        jsonWriter.writeNumberField("maxConcurrency", getMaxConcurrency());
        jsonWriter.writeNumberField("minRetryIntervalInSeconds", getMinRetryIntervalInSeconds());
        jsonWriter.writeNumberField("stopRetryAfterInSeconds", getStopRetryAfterInSeconds());
        jsonWriter.writeStringField("needRollup", getNeedRollup() == null ? null : getNeedRollup().toString());
        jsonWriter.writeStringField("rollUpMethod", getRollUpMethod() == null ? null : getRollUpMethod().toString());
        jsonWriter.writeArrayField("rollUpColumns", getRollUpColumns(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("allUpIdentification", getAllUpIdentification());
        jsonWriter.writeStringField("fillMissingPointType",
            getFillMissingPointType() == null ? null : getFillMissingPointType().toString());
        jsonWriter.writeNumberField("fillMissingPointValue", getFillMissingPointValue());
        jsonWriter.writeStringField("viewMode", getViewMode() == null ? null : getViewMode().toString());
        jsonWriter.writeArrayField("admins", getAdmins(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("viewers", getViewers(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("actionLinkTemplate", getActionLinkTemplate());
        jsonWriter.writeStringField("authenticationType",
            getAuthenticationType() == null ? null : getAuthenticationType().toString());
        jsonWriter.writeStringField("credentialId", getCredentialId());
        jsonWriter.writeJsonField("dataSourceParameter", this.dataSourceParameter);
        jsonWriter.writeStringField("dataSourceType",
            this.dataSourceType == null ? null : this.dataSourceType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AzureDataExplorerDataFeed from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AzureDataExplorerDataFeed if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AzureDataExplorerDataFeed.
     */
    public static AzureDataExplorerDataFeed fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AzureDataExplorerDataFeed deserializedAzureDataExplorerDataFeed = new AzureDataExplorerDataFeed();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("dataFeedName".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setDataFeedName(reader.getString());
                } else if ("granularityName".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setGranularityName(Granularity.fromString(reader.getString()));
                } else if ("metrics".equals(fieldName)) {
                    List<DataFeedMetric> metrics = reader.readArray(reader1 -> DataFeedMetric.fromJson(reader1));
                    deserializedAzureDataExplorerDataFeed.setMetrics(metrics);
                } else if ("dataStartFrom".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setDataStartFrom(reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                } else if ("dataFeedId".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.dataFeedId
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else if ("dataFeedDescription".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setDataFeedDescription(reader.getString());
                } else if ("granularityAmount".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setGranularityAmount(reader.getNullable(JsonReader::getInt));
                } else if ("dimension".equals(fieldName)) {
                    List<DataFeedDimension> dimension
                        = reader.readArray(reader1 -> DataFeedDimension.fromJson(reader1));
                    deserializedAzureDataExplorerDataFeed.setDimension(dimension);
                } else if ("timestampColumn".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setTimestampColumn(reader.getString());
                } else if ("startOffsetInSeconds".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setStartOffsetInSeconds(reader.getNullable(JsonReader::getLong));
                } else if ("maxConcurrency".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setMaxConcurrency(reader.getNullable(JsonReader::getInt));
                } else if ("minRetryIntervalInSeconds".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setMinRetryIntervalInSeconds(reader.getNullable(JsonReader::getLong));
                } else if ("stopRetryAfterInSeconds".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setStopRetryAfterInSeconds(reader.getNullable(JsonReader::getLong));
                } else if ("needRollup".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setNeedRollup(NeedRollupEnum.fromString(reader.getString()));
                } else if ("rollUpMethod".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setRollUpMethod(RollUpMethod.fromString(reader.getString()));
                } else if ("rollUpColumns".equals(fieldName)) {
                    List<String> rollUpColumns = reader.readArray(reader1 -> reader1.getString());
                    deserializedAzureDataExplorerDataFeed.setRollUpColumns(rollUpColumns);
                } else if ("allUpIdentification".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setAllUpIdentification(reader.getString());
                } else if ("fillMissingPointType".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setFillMissingPointType(FillMissingPointType.fromString(reader.getString()));
                } else if ("fillMissingPointValue".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setFillMissingPointValue(reader.getNullable(JsonReader::getDouble));
                } else if ("viewMode".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setViewMode(ViewMode.fromString(reader.getString()));
                } else if ("admins".equals(fieldName)) {
                    List<String> admins = reader.readArray(reader1 -> reader1.getString());
                    deserializedAzureDataExplorerDataFeed.setAdmins(admins);
                } else if ("viewers".equals(fieldName)) {
                    List<String> viewers = reader.readArray(reader1 -> reader1.getString());
                    deserializedAzureDataExplorerDataFeed.setViewers(viewers);
                } else if ("isAdmin".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.isAdmin = reader.getNullable(JsonReader::getBoolean);
                } else if ("creator".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.creator = reader.getString();
                } else if ("status".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.status = EntityStatus.fromString(reader.getString());
                } else if ("createdTime".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.createdTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("actionLinkTemplate".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setActionLinkTemplate(reader.getString());
                } else if ("authenticationType".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed
                        .setAuthenticationType(AuthenticationTypeEnum.fromString(reader.getString()));
                } else if ("credentialId".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.setCredentialId(reader.getString());
                } else if ("dataSourceParameter".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.dataSourceParameter = SqlSourceParameter.fromJson(reader);
                } else if ("dataSourceType".equals(fieldName)) {
                    deserializedAzureDataExplorerDataFeed.dataSourceType
                        = DataSourceType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAzureDataExplorerDataFeed;
        });
    }
}
