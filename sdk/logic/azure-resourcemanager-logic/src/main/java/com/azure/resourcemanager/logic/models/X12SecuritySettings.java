// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The X12 agreement security settings. */
@Fluent
public final class X12SecuritySettings {
    /*
     * The authorization qualifier.
     */
    @JsonProperty(value = "authorizationQualifier", required = true)
    private String authorizationQualifier;

    /*
     * The authorization value.
     */
    @JsonProperty(value = "authorizationValue")
    private String authorizationValue;

    /*
     * The security qualifier.
     */
    @JsonProperty(value = "securityQualifier", required = true)
    private String securityQualifier;

    /*
     * The password value.
     */
    @JsonProperty(value = "passwordValue")
    private String passwordValue;

    /** Creates an instance of X12SecuritySettings class. */
    public X12SecuritySettings() {
    }

    /**
     * Get the authorizationQualifier property: The authorization qualifier.
     *
     * @return the authorizationQualifier value.
     */
    public String authorizationQualifier() {
        return this.authorizationQualifier;
    }

    /**
     * Set the authorizationQualifier property: The authorization qualifier.
     *
     * @param authorizationQualifier the authorizationQualifier value to set.
     * @return the X12SecuritySettings object itself.
     */
    public X12SecuritySettings withAuthorizationQualifier(String authorizationQualifier) {
        this.authorizationQualifier = authorizationQualifier;
        return this;
    }

    /**
     * Get the authorizationValue property: The authorization value.
     *
     * @return the authorizationValue value.
     */
    public String authorizationValue() {
        return this.authorizationValue;
    }

    /**
     * Set the authorizationValue property: The authorization value.
     *
     * @param authorizationValue the authorizationValue value to set.
     * @return the X12SecuritySettings object itself.
     */
    public X12SecuritySettings withAuthorizationValue(String authorizationValue) {
        this.authorizationValue = authorizationValue;
        return this;
    }

    /**
     * Get the securityQualifier property: The security qualifier.
     *
     * @return the securityQualifier value.
     */
    public String securityQualifier() {
        return this.securityQualifier;
    }

    /**
     * Set the securityQualifier property: The security qualifier.
     *
     * @param securityQualifier the securityQualifier value to set.
     * @return the X12SecuritySettings object itself.
     */
    public X12SecuritySettings withSecurityQualifier(String securityQualifier) {
        this.securityQualifier = securityQualifier;
        return this;
    }

    /**
     * Get the passwordValue property: The password value.
     *
     * @return the passwordValue value.
     */
    public String passwordValue() {
        return this.passwordValue;
    }

    /**
     * Set the passwordValue property: The password value.
     *
     * @param passwordValue the passwordValue value to set.
     * @return the X12SecuritySettings object itself.
     */
    public X12SecuritySettings withPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (authorizationQualifier() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property authorizationQualifier in model X12SecuritySettings"));
        }
        if (securityQualifier() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property securityQualifier in model X12SecuritySettings"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(X12SecuritySettings.class);
}
