// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.digitaltwins.models;

import com.azure.resourcemanager.digitaltwins.fluent.models.CheckNameResultInner;

/**
 * An immutable client-side representation of CheckNameResult.
 */
public interface CheckNameResult {
    /**
     * Gets the nameAvailable property: Specifies a Boolean value that indicates if the name is available.
     * 
     * @return the nameAvailable value.
     */
    Boolean nameAvailable();

    /**
     * Gets the message property: Message indicating an unavailable name due to a conflict, or a description of the
     * naming rules that are violated.
     * 
     * @return the message value.
     */
    String message();

    /**
     * Gets the reason property: Message providing the reason why the given name is invalid.
     * 
     * @return the reason value.
     */
    Reason reason();

    /**
     * Gets the inner com.azure.resourcemanager.digitaltwins.fluent.models.CheckNameResultInner object.
     * 
     * @return the inner object.
     */
    CheckNameResultInner innerModel();
}
