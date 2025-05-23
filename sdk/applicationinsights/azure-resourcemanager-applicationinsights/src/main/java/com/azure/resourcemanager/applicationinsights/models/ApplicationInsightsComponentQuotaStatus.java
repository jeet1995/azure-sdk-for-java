// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.applicationinsights.models;

import com.azure.resourcemanager.applicationinsights.fluent.models.ApplicationInsightsComponentQuotaStatusInner;

/**
 * An immutable client-side representation of ApplicationInsightsComponentQuotaStatus.
 */
public interface ApplicationInsightsComponentQuotaStatus {
    /**
     * Gets the appId property: The Application ID for the Application Insights component.
     * 
     * @return the appId value.
     */
    String appId();

    /**
     * Gets the shouldBeThrottled property: The daily data volume cap is met, and data ingestion will be stopped.
     * 
     * @return the shouldBeThrottled value.
     */
    Boolean shouldBeThrottled();

    /**
     * Gets the expirationTime property: Date and time when the daily data volume cap will be reset, and data ingestion
     * will resume.
     * 
     * @return the expirationTime value.
     */
    String expirationTime();

    /**
     * Gets the inner
     * com.azure.resourcemanager.applicationinsights.fluent.models.ApplicationInsightsComponentQuotaStatusInner object.
     * 
     * @return the inner object.
     */
    ApplicationInsightsComponentQuotaStatusInner innerModel();
}
