// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The version lifecycle indicator.
 */
public final class AvailabilityLifecycle extends ExpandableStringEnum<AvailabilityLifecycle> {
    /**
     * Static value Preview for AvailabilityLifecycle.
     */
    public static final AvailabilityLifecycle PREVIEW = fromString("Preview");

    /**
     * Static value GenerallyAvailable for AvailabilityLifecycle.
     */
    public static final AvailabilityLifecycle GENERALLY_AVAILABLE = fromString("GenerallyAvailable");

    /**
     * Creates a new instance of AvailabilityLifecycle value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AvailabilityLifecycle() {
    }

    /**
     * Creates or finds a AvailabilityLifecycle from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AvailabilityLifecycle.
     */
    public static AvailabilityLifecycle fromString(String name) {
        return fromString(name, AvailabilityLifecycle.class);
    }

    /**
     * Gets known AvailabilityLifecycle values.
     * 
     * @return known AvailabilityLifecycle values.
     */
    public static Collection<AvailabilityLifecycle> values() {
        return values(AvailabilityLifecycle.class);
    }
}
