// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.botservice.models;

import com.azure.resourcemanager.botservice.fluent.models.HostSettingsResponseInner;

/**
 * An immutable client-side representation of HostSettingsResponse.
 */
public interface HostSettingsResponse {
    /**
     * Gets the oAuthUrl property: For in-conversation bot user authentication.
     * 
     * @return the oAuthUrl value.
     */
    String oAuthUrl();

    /**
     * Gets the toBotFromChannelOpenIdMetadataUrl property: For verifying incoming tokens from the channels.
     * 
     * @return the toBotFromChannelOpenIdMetadataUrl value.
     */
    String toBotFromChannelOpenIdMetadataUrl();

    /**
     * Gets the toBotFromChannelTokenIssuer property: For verifying incoming tokens from the channels.
     * 
     * @return the toBotFromChannelTokenIssuer value.
     */
    String toBotFromChannelTokenIssuer();

    /**
     * Gets the toBotFromEmulatorOpenIdMetadataUrl property: For verifying incoming tokens from bot emulator.
     * 
     * @return the toBotFromEmulatorOpenIdMetadataUrl value.
     */
    String toBotFromEmulatorOpenIdMetadataUrl();

    /**
     * Gets the toChannelFromBotLoginUrl property: For getting access token to channels from bot host.
     * 
     * @return the toChannelFromBotLoginUrl value.
     */
    String toChannelFromBotLoginUrl();

    /**
     * Gets the toChannelFromBotOAuthScope property: For getting access token to channels from bot host.
     * 
     * @return the toChannelFromBotOAuthScope value.
     */
    String toChannelFromBotOAuthScope();

    /**
     * Gets the validateAuthority property: Per cloud OAuth setting on whether authority is validated.
     * 
     * @return the validateAuthority value.
     */
    Boolean validateAuthority();

    /**
     * Gets the botOpenIdMetadata property: Same as ToBotFromChannelOpenIdMetadataUrl, used by SDK &lt; v4.12.
     * 
     * @return the botOpenIdMetadata value.
     */
    String botOpenIdMetadata();

    /**
     * Gets the inner com.azure.resourcemanager.botservice.fluent.models.HostSettingsResponseInner object.
     * 
     * @return the inner object.
     */
    HostSettingsResponseInner innerModel();
}
