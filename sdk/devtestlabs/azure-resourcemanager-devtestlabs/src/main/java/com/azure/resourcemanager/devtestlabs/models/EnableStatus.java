// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Indicates if the artifact source is enabled (values: Enabled, Disabled).
 */
public final class EnableStatus extends ExpandableStringEnum<EnableStatus> {
    /**
     * Static value Enabled for EnableStatus.
     */
    public static final EnableStatus ENABLED = fromString("Enabled");

    /**
     * Static value Disabled for EnableStatus.
     */
    public static final EnableStatus DISABLED = fromString("Disabled");

    /**
     * Creates a new instance of EnableStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public EnableStatus() {
    }

    /**
     * Creates or finds a EnableStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding EnableStatus.
     */
    public static EnableStatus fromString(String name) {
        return fromString(name, EnableStatus.class);
    }

    /**
     * Gets known EnableStatus values.
     * 
     * @return known EnableStatus values.
     */
    public static Collection<EnableStatus> values() {
        return values(EnableStatus.class);
    }
}
