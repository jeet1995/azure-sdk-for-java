// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.resourcemanager.security.fluent.models.JitNetworkAccessRequestInner;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * An immutable client-side representation of JitNetworkAccessRequest.
 */
public interface JitNetworkAccessRequest {
    /**
     * Gets the virtualMachines property: The virtualMachines property.
     * 
     * @return the virtualMachines value.
     */
    List<JitNetworkAccessRequestVirtualMachine> virtualMachines();

    /**
     * Gets the startTimeUtc property: The start time of the request in UTC.
     * 
     * @return the startTimeUtc value.
     */
    OffsetDateTime startTimeUtc();

    /**
     * Gets the requestor property: The identity of the person who made the request.
     * 
     * @return the requestor value.
     */
    String requestor();

    /**
     * Gets the justification property: The justification for making the initiate request.
     * 
     * @return the justification value.
     */
    String justification();

    /**
     * Gets the inner com.azure.resourcemanager.security.fluent.models.JitNetworkAccessRequestInner object.
     * 
     * @return the inner object.
     */
    JitNetworkAccessRequestInner innerModel();
}
