// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.resourcemanager.machinelearning.fluent.models.UpdateWorkspaceQuotasResultInner;
import java.util.List;

/**
 * An immutable client-side representation of UpdateWorkspaceQuotasResult.
 */
public interface UpdateWorkspaceQuotasResult {
    /**
     * Gets the value property: The list of workspace quota update result.
     * 
     * @return the value value.
     */
    List<UpdateWorkspaceQuotas> value();

    /**
     * Gets the nextLink property: The URI to fetch the next page of workspace quota update result. Call ListNext() with
     * this to fetch the next page of Workspace Quota update result.
     * 
     * @return the nextLink value.
     */
    String nextLink();

    /**
     * Gets the inner com.azure.resourcemanager.machinelearning.fluent.models.UpdateWorkspaceQuotasResultInner object.
     * 
     * @return the inner object.
     */
    UpdateWorkspaceQuotasResultInner innerModel();
}
