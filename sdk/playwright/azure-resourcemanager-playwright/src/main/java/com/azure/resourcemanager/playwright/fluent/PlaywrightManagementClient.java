// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.playwright.fluent;

import com.azure.core.http.HttpPipeline;
import java.time.Duration;

/**
 * The interface for PlaywrightManagementClient class.
 */
public interface PlaywrightManagementClient {
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
     * Gets the PlaywrightWorkspacesClient object to access its operations.
     * 
     * @return the PlaywrightWorkspacesClient object.
     */
    PlaywrightWorkspacesClient getPlaywrightWorkspaces();

    /**
     * Gets the PlaywrightQuotasClient object to access its operations.
     * 
     * @return the PlaywrightQuotasClient object.
     */
    PlaywrightQuotasClient getPlaywrightQuotas();

    /**
     * Gets the PlaywrightWorkspaceQuotasClient object to access its operations.
     * 
     * @return the PlaywrightWorkspaceQuotasClient object.
     */
    PlaywrightWorkspaceQuotasClient getPlaywrightWorkspaceQuotas();
}
