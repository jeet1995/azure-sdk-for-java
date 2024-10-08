// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for HealthState.
 */
public final class HealthState extends ExpandableStringEnum<HealthState> {
    /**
     * Static value Unknown for HealthState.
     */
    public static final HealthState UNKNOWN = fromString("Unknown");

    /**
     * Static value Success for HealthState.
     */
    public static final HealthState SUCCESS = fromString("Success");

    /**
     * Static value Failure for HealthState.
     */
    public static final HealthState FAILURE = fromString("Failure");

    /**
     * Static value Warning for HealthState.
     */
    public static final HealthState WARNING = fromString("Warning");

    /**
     * Static value Error for HealthState.
     */
    public static final HealthState ERROR = fromString("Error");

    /**
     * Static value InProgress for HealthState.
     */
    public static final HealthState IN_PROGRESS = fromString("InProgress");

    /**
     * Creates a new instance of HealthState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public HealthState() {
    }

    /**
     * Creates or finds a HealthState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding HealthState.
     */
    public static HealthState fromString(String name) {
        return fromString(name, HealthState.class);
    }

    /**
     * Gets known HealthState values.
     * 
     * @return known HealthState values.
     */
    public static Collection<HealthState> values() {
        return values(HealthState.class);
    }
}
