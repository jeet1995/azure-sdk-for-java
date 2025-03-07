// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.resourcemanager.sql.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.resources.fluentcore.model.HasInnerModel;
import com.azure.resourcemanager.sql.fluent.models.CheckNameAvailabilityResponseInner;

/** The result of checking for the SQL server name availability. */
@Fluent
public interface CheckNameAvailabilityResult extends HasInnerModel<CheckNameAvailabilityResponseInner> {
    /**
     * Checks whether the specified name is valid and available for use.
     *
     * @return true if the specified name is valid and available for use, otherwise false
     */
    boolean isAvailable();

    /**
     * Gets the reason why the user-provided name for the SQL server could not be used.
     *
     * @return the reason why the user-provided name for the SQL server could not be used
     */
    String unavailabilityReason();

    /**
     * Gets the error message that provides more detail for the reason why the name is not available.
     *
     * @return the error message that provides more detail for the reason why the name is not available
     */
    String unavailabilityMessage();
}
