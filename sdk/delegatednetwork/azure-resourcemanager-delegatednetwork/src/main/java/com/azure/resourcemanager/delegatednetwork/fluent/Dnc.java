// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.delegatednetwork.fluent;

import com.azure.core.http.HttpPipeline;
import java.time.Duration;

/**
 * The interface for Dnc class.
 */
public interface Dnc {
    /**
     * Gets The ID of the target subscription.
     * 
     * @return the subscriptionId value.
     */
    String getSubscriptionId();

    /**
     * Gets server parameter.
     * 
     * @return the endpoint value.
     */
    String getEndpoint();

    /**
     * Gets Api Version.
     * 
     * @return the apiVersion value.
     */
    String getApiVersion();

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
     * Gets the ControllersClient object to access its operations.
     * 
     * @return the ControllersClient object.
     */
    ControllersClient getControllers();

    /**
     * Gets the DelegatedNetworksClient object to access its operations.
     * 
     * @return the DelegatedNetworksClient object.
     */
    DelegatedNetworksClient getDelegatedNetworks();

    /**
     * Gets the OrchestratorInstanceServicesClient object to access its operations.
     * 
     * @return the OrchestratorInstanceServicesClient object.
     */
    OrchestratorInstanceServicesClient getOrchestratorInstanceServices();

    /**
     * Gets the DelegatedSubnetServicesClient object to access its operations.
     * 
     * @return the DelegatedSubnetServicesClient object.
     */
    DelegatedSubnetServicesClient getDelegatedSubnetServices();

    /**
     * Gets the OperationsClient object to access its operations.
     * 
     * @return the OperationsClient object.
     */
    OperationsClient getOperations();
}
