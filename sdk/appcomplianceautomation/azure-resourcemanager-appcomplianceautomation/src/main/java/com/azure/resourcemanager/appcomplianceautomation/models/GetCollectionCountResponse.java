// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.models;

import com.azure.resourcemanager.appcomplianceautomation.fluent.models.GetCollectionCountResponseInner;

/**
 * An immutable client-side representation of GetCollectionCountResponse.
 */
public interface GetCollectionCountResponse {
    /**
     * Gets the count property: The count of the specified resource.
     * 
     * @return the count value.
     */
    Integer count();

    /**
     * Gets the inner com.azure.resourcemanager.appcomplianceautomation.fluent.models.GetCollectionCountResponseInner
     * object.
     * 
     * @return the inner object.
     */
    GetCollectionCountResponseInner innerModel();
}
