// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The policy used for monitoring the application upgrade.
 */
@Fluent
public final class RollingUpgradeMonitoringPolicy implements JsonSerializable<RollingUpgradeMonitoringPolicy> {
    /*
     * The compensating action to perform when a Monitored upgrade encounters monitoring policy or health policy
     * violations. Invalid indicates the failure action is invalid. Rollback specifies that the upgrade will start
     * rolling back automatically. Manual indicates that the upgrade will switch to UnmonitoredManual upgrade mode.
     */
    private FailureAction failureAction;

    /*
     * The amount of time to wait after completing an upgrade domain before applying health policies. It is interpreted
     * as a string representing an ISO 8601 duration with following format "hh:mm:ss.fff".
     */
    private String healthCheckWaitDuration;

    /*
     * The amount of time that the application or cluster must remain healthy before the upgrade proceeds to the next
     * upgrade domain. It is interpreted as a string representing an ISO 8601 duration with following format
     * "hh:mm:ss.fff".
     */
    private String healthCheckStableDuration;

    /*
     * The amount of time to retry health evaluation when the application or cluster is unhealthy before FailureAction
     * is executed. It is interpreted as a string representing an ISO 8601 duration with following format
     * "hh:mm:ss.fff".
     */
    private String healthCheckRetryTimeout;

    /*
     * The amount of time the overall upgrade has to complete before FailureAction is executed. Cannot be larger than 12
     * hours. It is interpreted as a string representing an ISO 8601 duration with following format "hh:mm:ss.fff".
     */
    private String upgradeTimeout;

    /*
     * The amount of time each upgrade domain has to complete before FailureAction is executed. Cannot be larger than 12
     * hours. It is interpreted as a string representing an ISO 8601 duration with following format "hh:mm:ss.fff".
     */
    private String upgradeDomainTimeout;

    /**
     * Creates an instance of RollingUpgradeMonitoringPolicy class.
     */
    public RollingUpgradeMonitoringPolicy() {
    }

    /**
     * Get the failureAction property: The compensating action to perform when a Monitored upgrade encounters monitoring
     * policy or health policy violations. Invalid indicates the failure action is invalid. Rollback specifies that the
     * upgrade will start rolling back automatically. Manual indicates that the upgrade will switch to UnmonitoredManual
     * upgrade mode.
     * 
     * @return the failureAction value.
     */
    public FailureAction failureAction() {
        return this.failureAction;
    }

    /**
     * Set the failureAction property: The compensating action to perform when a Monitored upgrade encounters monitoring
     * policy or health policy violations. Invalid indicates the failure action is invalid. Rollback specifies that the
     * upgrade will start rolling back automatically. Manual indicates that the upgrade will switch to UnmonitoredManual
     * upgrade mode.
     * 
     * @param failureAction the failureAction value to set.
     * @return the RollingUpgradeMonitoringPolicy object itself.
     */
    public RollingUpgradeMonitoringPolicy withFailureAction(FailureAction failureAction) {
        this.failureAction = failureAction;
        return this;
    }

    /**
     * Get the healthCheckWaitDuration property: The amount of time to wait after completing an upgrade domain before
     * applying health policies. It is interpreted as a string representing an ISO 8601 duration with following format
     * "hh:mm:ss.fff".
     * 
     * @return the healthCheckWaitDuration value.
     */
    public String healthCheckWaitDuration() {
        return this.healthCheckWaitDuration;
    }

    /**
     * Set the healthCheckWaitDuration property: The amount of time to wait after completing an upgrade domain before
     * applying health policies. It is interpreted as a string representing an ISO 8601 duration with following format
     * "hh:mm:ss.fff".
     * 
     * @param healthCheckWaitDuration the healthCheckWaitDuration value to set.
     * @return the RollingUpgradeMonitoringPolicy object itself.
     */
    public RollingUpgradeMonitoringPolicy withHealthCheckWaitDuration(String healthCheckWaitDuration) {
        this.healthCheckWaitDuration = healthCheckWaitDuration;
        return this;
    }

    /**
     * Get the healthCheckStableDuration property: The amount of time that the application or cluster must remain
     * healthy before the upgrade proceeds to the next upgrade domain. It is interpreted as a string representing an ISO
     * 8601 duration with following format "hh:mm:ss.fff".
     * 
     * @return the healthCheckStableDuration value.
     */
    public String healthCheckStableDuration() {
        return this.healthCheckStableDuration;
    }

    /**
     * Set the healthCheckStableDuration property: The amount of time that the application or cluster must remain
     * healthy before the upgrade proceeds to the next upgrade domain. It is interpreted as a string representing an ISO
     * 8601 duration with following format "hh:mm:ss.fff".
     * 
     * @param healthCheckStableDuration the healthCheckStableDuration value to set.
     * @return the RollingUpgradeMonitoringPolicy object itself.
     */
    public RollingUpgradeMonitoringPolicy withHealthCheckStableDuration(String healthCheckStableDuration) {
        this.healthCheckStableDuration = healthCheckStableDuration;
        return this;
    }

    /**
     * Get the healthCheckRetryTimeout property: The amount of time to retry health evaluation when the application or
     * cluster is unhealthy before FailureAction is executed. It is interpreted as a string representing an ISO 8601
     * duration with following format "hh:mm:ss.fff".
     * 
     * @return the healthCheckRetryTimeout value.
     */
    public String healthCheckRetryTimeout() {
        return this.healthCheckRetryTimeout;
    }

    /**
     * Set the healthCheckRetryTimeout property: The amount of time to retry health evaluation when the application or
     * cluster is unhealthy before FailureAction is executed. It is interpreted as a string representing an ISO 8601
     * duration with following format "hh:mm:ss.fff".
     * 
     * @param healthCheckRetryTimeout the healthCheckRetryTimeout value to set.
     * @return the RollingUpgradeMonitoringPolicy object itself.
     */
    public RollingUpgradeMonitoringPolicy withHealthCheckRetryTimeout(String healthCheckRetryTimeout) {
        this.healthCheckRetryTimeout = healthCheckRetryTimeout;
        return this;
    }

    /**
     * Get the upgradeTimeout property: The amount of time the overall upgrade has to complete before FailureAction is
     * executed. Cannot be larger than 12 hours. It is interpreted as a string representing an ISO 8601 duration with
     * following format "hh:mm:ss.fff".
     * 
     * @return the upgradeTimeout value.
     */
    public String upgradeTimeout() {
        return this.upgradeTimeout;
    }

    /**
     * Set the upgradeTimeout property: The amount of time the overall upgrade has to complete before FailureAction is
     * executed. Cannot be larger than 12 hours. It is interpreted as a string representing an ISO 8601 duration with
     * following format "hh:mm:ss.fff".
     * 
     * @param upgradeTimeout the upgradeTimeout value to set.
     * @return the RollingUpgradeMonitoringPolicy object itself.
     */
    public RollingUpgradeMonitoringPolicy withUpgradeTimeout(String upgradeTimeout) {
        this.upgradeTimeout = upgradeTimeout;
        return this;
    }

    /**
     * Get the upgradeDomainTimeout property: The amount of time each upgrade domain has to complete before
     * FailureAction is executed. Cannot be larger than 12 hours. It is interpreted as a string representing an ISO 8601
     * duration with following format "hh:mm:ss.fff".
     * 
     * @return the upgradeDomainTimeout value.
     */
    public String upgradeDomainTimeout() {
        return this.upgradeDomainTimeout;
    }

    /**
     * Set the upgradeDomainTimeout property: The amount of time each upgrade domain has to complete before
     * FailureAction is executed. Cannot be larger than 12 hours. It is interpreted as a string representing an ISO 8601
     * duration with following format "hh:mm:ss.fff".
     * 
     * @param upgradeDomainTimeout the upgradeDomainTimeout value to set.
     * @return the RollingUpgradeMonitoringPolicy object itself.
     */
    public RollingUpgradeMonitoringPolicy withUpgradeDomainTimeout(String upgradeDomainTimeout) {
        this.upgradeDomainTimeout = upgradeDomainTimeout;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (failureAction() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property failureAction in model RollingUpgradeMonitoringPolicy"));
        }
        if (healthCheckWaitDuration() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property healthCheckWaitDuration in model RollingUpgradeMonitoringPolicy"));
        }
        if (healthCheckStableDuration() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property healthCheckStableDuration in model RollingUpgradeMonitoringPolicy"));
        }
        if (healthCheckRetryTimeout() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property healthCheckRetryTimeout in model RollingUpgradeMonitoringPolicy"));
        }
        if (upgradeTimeout() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property upgradeTimeout in model RollingUpgradeMonitoringPolicy"));
        }
        if (upgradeDomainTimeout() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property upgradeDomainTimeout in model RollingUpgradeMonitoringPolicy"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RollingUpgradeMonitoringPolicy.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("failureAction", this.failureAction == null ? null : this.failureAction.toString());
        jsonWriter.writeStringField("healthCheckWaitDuration", this.healthCheckWaitDuration);
        jsonWriter.writeStringField("healthCheckStableDuration", this.healthCheckStableDuration);
        jsonWriter.writeStringField("healthCheckRetryTimeout", this.healthCheckRetryTimeout);
        jsonWriter.writeStringField("upgradeTimeout", this.upgradeTimeout);
        jsonWriter.writeStringField("upgradeDomainTimeout", this.upgradeDomainTimeout);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RollingUpgradeMonitoringPolicy from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RollingUpgradeMonitoringPolicy if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RollingUpgradeMonitoringPolicy.
     */
    public static RollingUpgradeMonitoringPolicy fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RollingUpgradeMonitoringPolicy deserializedRollingUpgradeMonitoringPolicy
                = new RollingUpgradeMonitoringPolicy();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("failureAction".equals(fieldName)) {
                    deserializedRollingUpgradeMonitoringPolicy.failureAction
                        = FailureAction.fromString(reader.getString());
                } else if ("healthCheckWaitDuration".equals(fieldName)) {
                    deserializedRollingUpgradeMonitoringPolicy.healthCheckWaitDuration = reader.getString();
                } else if ("healthCheckStableDuration".equals(fieldName)) {
                    deserializedRollingUpgradeMonitoringPolicy.healthCheckStableDuration = reader.getString();
                } else if ("healthCheckRetryTimeout".equals(fieldName)) {
                    deserializedRollingUpgradeMonitoringPolicy.healthCheckRetryTimeout = reader.getString();
                } else if ("upgradeTimeout".equals(fieldName)) {
                    deserializedRollingUpgradeMonitoringPolicy.upgradeTimeout = reader.getString();
                } else if ("upgradeDomainTimeout".equals(fieldName)) {
                    deserializedRollingUpgradeMonitoringPolicy.upgradeDomainTimeout = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRollingUpgradeMonitoringPolicy;
        });
    }
}
