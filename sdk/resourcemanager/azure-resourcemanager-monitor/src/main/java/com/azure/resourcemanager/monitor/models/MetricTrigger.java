// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.monitor.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * The trigger that results in a scaling action.
 */
@Fluent
public final class MetricTrigger implements JsonSerializable<MetricTrigger> {
    /*
     * the name of the metric that defines what the rule monitors.
     */
    private String metricName;

    /*
     * the namespace of the metric that defines what the rule monitors.
     */
    private String metricNamespace;

    /*
     * the resource identifier of the resource the rule monitors.
     */
    private String metricResourceUri;

    /*
     * the location of the resource the rule monitors.
     */
    private String metricResourceLocation;

    /*
     * the granularity of metrics the rule monitors. Must be one of the predefined values returned from metric
     * definitions for the metric. Must be between 12 hours and 1 minute.
     */
    private Duration timeGrain;

    /*
     * the metric statistic type. How the metrics from multiple instances are combined.
     */
    private MetricStatisticType statistic;

    /*
     * the range of time in which instance data is collected. This value must be greater than the delay in metric
     * collection, which can vary from resource-to-resource. Must be between 12 hours and 5 minutes.
     */
    private Duration timeWindow;

    /*
     * time aggregation type. How the data that is collected should be combined over time. The default value is Average.
     */
    private TimeAggregationType timeAggregation;

    /*
     * the operator that is used to compare the metric data and the threshold.
     */
    private ComparisonOperationType operator;

    /*
     * the threshold of the metric that triggers the scale action.
     */
    private double threshold;

    /*
     * List of dimension conditions. For example:
     * [{"DimensionName":"AppName","Operator":"Equals","Values":["App1"]},{"DimensionName":"Deployment","Operator":
     * "Equals","Values":["default"]}].
     */
    private List<ScaleRuleMetricDimension> dimensions;

    /*
     * a value indicating whether metric should divide per instance.
     */
    private Boolean dividePerInstance;

    /**
     * Creates an instance of MetricTrigger class.
     */
    public MetricTrigger() {
    }

    /**
     * Get the metricName property: the name of the metric that defines what the rule monitors.
     * 
     * @return the metricName value.
     */
    public String metricName() {
        return this.metricName;
    }

    /**
     * Set the metricName property: the name of the metric that defines what the rule monitors.
     * 
     * @param metricName the metricName value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withMetricName(String metricName) {
        this.metricName = metricName;
        return this;
    }

    /**
     * Get the metricNamespace property: the namespace of the metric that defines what the rule monitors.
     * 
     * @return the metricNamespace value.
     */
    public String metricNamespace() {
        return this.metricNamespace;
    }

    /**
     * Set the metricNamespace property: the namespace of the metric that defines what the rule monitors.
     * 
     * @param metricNamespace the metricNamespace value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withMetricNamespace(String metricNamespace) {
        this.metricNamespace = metricNamespace;
        return this;
    }

    /**
     * Get the metricResourceUri property: the resource identifier of the resource the rule monitors.
     * 
     * @return the metricResourceUri value.
     */
    public String metricResourceUri() {
        return this.metricResourceUri;
    }

    /**
     * Set the metricResourceUri property: the resource identifier of the resource the rule monitors.
     * 
     * @param metricResourceUri the metricResourceUri value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withMetricResourceUri(String metricResourceUri) {
        this.metricResourceUri = metricResourceUri;
        return this;
    }

    /**
     * Get the metricResourceLocation property: the location of the resource the rule monitors.
     * 
     * @return the metricResourceLocation value.
     */
    public String metricResourceLocation() {
        return this.metricResourceLocation;
    }

    /**
     * Set the metricResourceLocation property: the location of the resource the rule monitors.
     * 
     * @param metricResourceLocation the metricResourceLocation value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withMetricResourceLocation(String metricResourceLocation) {
        this.metricResourceLocation = metricResourceLocation;
        return this;
    }

    /**
     * Get the timeGrain property: the granularity of metrics the rule monitors. Must be one of the predefined values
     * returned from metric definitions for the metric. Must be between 12 hours and 1 minute.
     * 
     * @return the timeGrain value.
     */
    public Duration timeGrain() {
        return this.timeGrain;
    }

    /**
     * Set the timeGrain property: the granularity of metrics the rule monitors. Must be one of the predefined values
     * returned from metric definitions for the metric. Must be between 12 hours and 1 minute.
     * 
     * @param timeGrain the timeGrain value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withTimeGrain(Duration timeGrain) {
        this.timeGrain = timeGrain;
        return this;
    }

    /**
     * Get the statistic property: the metric statistic type. How the metrics from multiple instances are combined.
     * 
     * @return the statistic value.
     */
    public MetricStatisticType statistic() {
        return this.statistic;
    }

    /**
     * Set the statistic property: the metric statistic type. How the metrics from multiple instances are combined.
     * 
     * @param statistic the statistic value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withStatistic(MetricStatisticType statistic) {
        this.statistic = statistic;
        return this;
    }

    /**
     * Get the timeWindow property: the range of time in which instance data is collected. This value must be greater
     * than the delay in metric collection, which can vary from resource-to-resource. Must be between 12 hours and 5
     * minutes.
     * 
     * @return the timeWindow value.
     */
    public Duration timeWindow() {
        return this.timeWindow;
    }

    /**
     * Set the timeWindow property: the range of time in which instance data is collected. This value must be greater
     * than the delay in metric collection, which can vary from resource-to-resource. Must be between 12 hours and 5
     * minutes.
     * 
     * @param timeWindow the timeWindow value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withTimeWindow(Duration timeWindow) {
        this.timeWindow = timeWindow;
        return this;
    }

    /**
     * Get the timeAggregation property: time aggregation type. How the data that is collected should be combined over
     * time. The default value is Average.
     * 
     * @return the timeAggregation value.
     */
    public TimeAggregationType timeAggregation() {
        return this.timeAggregation;
    }

    /**
     * Set the timeAggregation property: time aggregation type. How the data that is collected should be combined over
     * time. The default value is Average.
     * 
     * @param timeAggregation the timeAggregation value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withTimeAggregation(TimeAggregationType timeAggregation) {
        this.timeAggregation = timeAggregation;
        return this;
    }

    /**
     * Get the operator property: the operator that is used to compare the metric data and the threshold.
     * 
     * @return the operator value.
     */
    public ComparisonOperationType operator() {
        return this.operator;
    }

    /**
     * Set the operator property: the operator that is used to compare the metric data and the threshold.
     * 
     * @param operator the operator value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withOperator(ComparisonOperationType operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Get the threshold property: the threshold of the metric that triggers the scale action.
     * 
     * @return the threshold value.
     */
    public double threshold() {
        return this.threshold;
    }

    /**
     * Set the threshold property: the threshold of the metric that triggers the scale action.
     * 
     * @param threshold the threshold value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withThreshold(double threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * Get the dimensions property: List of dimension conditions. For example:
     * [{"DimensionName":"AppName","Operator":"Equals","Values":["App1"]},{"DimensionName":"Deployment","Operator":"Equals","Values":["default"]}].
     * 
     * @return the dimensions value.
     */
    public List<ScaleRuleMetricDimension> dimensions() {
        return this.dimensions;
    }

    /**
     * Set the dimensions property: List of dimension conditions. For example:
     * [{"DimensionName":"AppName","Operator":"Equals","Values":["App1"]},{"DimensionName":"Deployment","Operator":"Equals","Values":["default"]}].
     * 
     * @param dimensions the dimensions value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withDimensions(List<ScaleRuleMetricDimension> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    /**
     * Get the dividePerInstance property: a value indicating whether metric should divide per instance.
     * 
     * @return the dividePerInstance value.
     */
    public Boolean dividePerInstance() {
        return this.dividePerInstance;
    }

    /**
     * Set the dividePerInstance property: a value indicating whether metric should divide per instance.
     * 
     * @param dividePerInstance the dividePerInstance value to set.
     * @return the MetricTrigger object itself.
     */
    public MetricTrigger withDividePerInstance(Boolean dividePerInstance) {
        this.dividePerInstance = dividePerInstance;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (metricName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property metricName in model MetricTrigger"));
        }
        if (metricResourceUri() == null) {
            throw LOGGER.atError()
                .log(
                    new IllegalArgumentException("Missing required property metricResourceUri in model MetricTrigger"));
        }
        if (timeGrain() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property timeGrain in model MetricTrigger"));
        }
        if (statistic() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property statistic in model MetricTrigger"));
        }
        if (timeWindow() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property timeWindow in model MetricTrigger"));
        }
        if (timeAggregation() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property timeAggregation in model MetricTrigger"));
        }
        if (operator() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property operator in model MetricTrigger"));
        }
        if (dimensions() != null) {
            dimensions().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(MetricTrigger.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("metricName", this.metricName);
        jsonWriter.writeStringField("metricResourceUri", this.metricResourceUri);
        jsonWriter.writeStringField("timeGrain", CoreUtils.durationToStringWithDays(this.timeGrain));
        jsonWriter.writeStringField("statistic", this.statistic == null ? null : this.statistic.toString());
        jsonWriter.writeStringField("timeWindow", CoreUtils.durationToStringWithDays(this.timeWindow));
        jsonWriter.writeStringField("timeAggregation",
            this.timeAggregation == null ? null : this.timeAggregation.toString());
        jsonWriter.writeStringField("operator", this.operator == null ? null : this.operator.toString());
        jsonWriter.writeDoubleField("threshold", this.threshold);
        jsonWriter.writeStringField("metricNamespace", this.metricNamespace);
        jsonWriter.writeStringField("metricResourceLocation", this.metricResourceLocation);
        jsonWriter.writeArrayField("dimensions", this.dimensions, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeBooleanField("dividePerInstance", this.dividePerInstance);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricTrigger from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricTrigger if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the MetricTrigger.
     */
    public static MetricTrigger fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MetricTrigger deserializedMetricTrigger = new MetricTrigger();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("metricName".equals(fieldName)) {
                    deserializedMetricTrigger.metricName = reader.getString();
                } else if ("metricResourceUri".equals(fieldName)) {
                    deserializedMetricTrigger.metricResourceUri = reader.getString();
                } else if ("timeGrain".equals(fieldName)) {
                    deserializedMetricTrigger.timeGrain
                        = reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString()));
                } else if ("statistic".equals(fieldName)) {
                    deserializedMetricTrigger.statistic = MetricStatisticType.fromString(reader.getString());
                } else if ("timeWindow".equals(fieldName)) {
                    deserializedMetricTrigger.timeWindow
                        = reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString()));
                } else if ("timeAggregation".equals(fieldName)) {
                    deserializedMetricTrigger.timeAggregation = TimeAggregationType.fromString(reader.getString());
                } else if ("operator".equals(fieldName)) {
                    deserializedMetricTrigger.operator = ComparisonOperationType.fromString(reader.getString());
                } else if ("threshold".equals(fieldName)) {
                    deserializedMetricTrigger.threshold = reader.getDouble();
                } else if ("metricNamespace".equals(fieldName)) {
                    deserializedMetricTrigger.metricNamespace = reader.getString();
                } else if ("metricResourceLocation".equals(fieldName)) {
                    deserializedMetricTrigger.metricResourceLocation = reader.getString();
                } else if ("dimensions".equals(fieldName)) {
                    List<ScaleRuleMetricDimension> dimensions
                        = reader.readArray(reader1 -> ScaleRuleMetricDimension.fromJson(reader1));
                    deserializedMetricTrigger.dimensions = dimensions;
                } else if ("dividePerInstance".equals(fieldName)) {
                    deserializedMetricTrigger.dividePerInstance = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMetricTrigger;
        });
    }
}
