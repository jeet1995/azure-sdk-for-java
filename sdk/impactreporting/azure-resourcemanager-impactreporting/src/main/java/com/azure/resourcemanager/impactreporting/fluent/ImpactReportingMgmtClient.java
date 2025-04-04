// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.impactreporting.fluent;

import com.azure.core.http.HttpPipeline;
import java.time.Duration;

/**
 * The interface for ImpactReportingMgmtClient class.
 */
public interface ImpactReportingMgmtClient {
    /**
     * Gets Service host.
     * 
     * @return the endpoint value.
     */
    String getEndpoint();

    /**
     * Gets Version parameter.
     * 
     * @return the apiVersion value.
     */
    String getApiVersion();

    /**
     * Gets The ID of the target subscription. The value must be an UUID.
     * 
     * @return the subscriptionId value.
     */
    String getSubscriptionId();

    /**
     * Gets The HTTP pipeline to send requests through.
     * 
     * @return the httpPipeline value.
     */
    HttpPipeline getHttpPipeline();

    /**
     * Gets The default poll interval for long-running operation.
     * 
     * @return the defaultPollInterval value.
     */
    Duration getDefaultPollInterval();

    /**
     * Gets the OperationsClient object to access its operations.
     * 
     * @return the OperationsClient object.
     */
    OperationsClient getOperations();

    /**
     * Gets the WorkloadImpactsClient object to access its operations.
     * 
     * @return the WorkloadImpactsClient object.
     */
    WorkloadImpactsClient getWorkloadImpacts();

    /**
     * Gets the ImpactCategoriesClient object to access its operations.
     * 
     * @return the ImpactCategoriesClient object.
     */
    ImpactCategoriesClient getImpactCategories();

    /**
     * Gets the InsightsClient object to access its operations.
     * 
     * @return the InsightsClient object.
     */
    InsightsClient getInsights();

    /**
     * Gets the ConnectorsClient object to access its operations.
     * 
     * @return the ConnectorsClient object.
     */
    ConnectorsClient getConnectors();
}
