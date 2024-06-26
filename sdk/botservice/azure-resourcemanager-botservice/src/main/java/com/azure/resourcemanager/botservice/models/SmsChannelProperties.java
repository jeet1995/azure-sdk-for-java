// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.botservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The parameters to provide for the Sms channel. */
@Fluent
public final class SmsChannelProperties {
    /*
     * The Sms phone
     */
    @JsonProperty(value = "phone", required = true)
    private String phone;

    /*
     * The Sms account SID. Value only returned through POST to the action
     * Channel List API, otherwise empty.
     */
    @JsonProperty(value = "accountSID", required = true)
    private String accountSid;

    /*
     * The Sms auth token. Value only returned through POST to the action
     * Channel List API, otherwise empty.
     */
    @JsonProperty(value = "authToken")
    private String authToken;

    /*
     * Whether this channel is validated for the bot
     */
    @JsonProperty(value = "isValidated")
    private Boolean isValidated;

    /*
     * Whether this channel is enabled for the bot
     */
    @JsonProperty(value = "isEnabled", required = true)
    private boolean isEnabled;

    /**
     * Get the phone property: The Sms phone.
     *
     * @return the phone value.
     */
    public String phone() {
        return this.phone;
    }

    /**
     * Set the phone property: The Sms phone.
     *
     * @param phone the phone value to set.
     * @return the SmsChannelProperties object itself.
     */
    public SmsChannelProperties withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get the accountSid property: The Sms account SID. Value only returned through POST to the action Channel List
     * API, otherwise empty.
     *
     * @return the accountSid value.
     */
    public String accountSid() {
        return this.accountSid;
    }

    /**
     * Set the accountSid property: The Sms account SID. Value only returned through POST to the action Channel List
     * API, otherwise empty.
     *
     * @param accountSid the accountSid value to set.
     * @return the SmsChannelProperties object itself.
     */
    public SmsChannelProperties withAccountSid(String accountSid) {
        this.accountSid = accountSid;
        return this;
    }

    /**
     * Get the authToken property: The Sms auth token. Value only returned through POST to the action Channel List API,
     * otherwise empty.
     *
     * @return the authToken value.
     */
    public String authToken() {
        return this.authToken;
    }

    /**
     * Set the authToken property: The Sms auth token. Value only returned through POST to the action Channel List API,
     * otherwise empty.
     *
     * @param authToken the authToken value to set.
     * @return the SmsChannelProperties object itself.
     */
    public SmsChannelProperties withAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    /**
     * Get the isValidated property: Whether this channel is validated for the bot.
     *
     * @return the isValidated value.
     */
    public Boolean isValidated() {
        return this.isValidated;
    }

    /**
     * Set the isValidated property: Whether this channel is validated for the bot.
     *
     * @param isValidated the isValidated value to set.
     * @return the SmsChannelProperties object itself.
     */
    public SmsChannelProperties withIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
        return this;
    }

    /**
     * Get the isEnabled property: Whether this channel is enabled for the bot.
     *
     * @return the isEnabled value.
     */
    public boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Set the isEnabled property: Whether this channel is enabled for the bot.
     *
     * @param isEnabled the isEnabled value to set.
     * @return the SmsChannelProperties object itself.
     */
    public SmsChannelProperties withIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (phone() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property phone in model SmsChannelProperties"));
        }
        if (accountSid() == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property accountSid in model SmsChannelProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(SmsChannelProperties.class);
}
