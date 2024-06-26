// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridkubernetes.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The ListClusterUserCredentialProperties model. */
@Fluent
public final class ListClusterUserCredentialProperties {
    /*
     * The mode of client authentication.
     */
    @JsonProperty(value = "authenticationMethod", required = true)
    private AuthenticationMethod authenticationMethod;

    /*
     * Boolean value to indicate whether the request is for client side proxy or not
     */
    @JsonProperty(value = "clientProxy", required = true)
    private boolean clientProxy;

    /** Creates an instance of ListClusterUserCredentialProperties class. */
    public ListClusterUserCredentialProperties() {
    }

    /**
     * Get the authenticationMethod property: The mode of client authentication.
     *
     * @return the authenticationMethod value.
     */
    public AuthenticationMethod authenticationMethod() {
        return this.authenticationMethod;
    }

    /**
     * Set the authenticationMethod property: The mode of client authentication.
     *
     * @param authenticationMethod the authenticationMethod value to set.
     * @return the ListClusterUserCredentialProperties object itself.
     */
    public ListClusterUserCredentialProperties withAuthenticationMethod(AuthenticationMethod authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
        return this;
    }

    /**
     * Get the clientProxy property: Boolean value to indicate whether the request is for client side proxy or not.
     *
     * @return the clientProxy value.
     */
    public boolean clientProxy() {
        return this.clientProxy;
    }

    /**
     * Set the clientProxy property: Boolean value to indicate whether the request is for client side proxy or not.
     *
     * @param clientProxy the clientProxy value to set.
     * @return the ListClusterUserCredentialProperties object itself.
     */
    public ListClusterUserCredentialProperties withClientProxy(boolean clientProxy) {
        this.clientProxy = clientProxy;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (authenticationMethod() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property authenticationMethod in model ListClusterUserCredentialProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ListClusterUserCredentialProperties.class);
}
