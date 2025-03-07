// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Peering option list.
 */
public final class PeeringOption extends ExpandableStringEnum<PeeringOption> {
    /**
     * Static value OptionA for PeeringOption.
     */
    public static final PeeringOption OPTIONA = fromString("OptionA");

    /**
     * Static value OptionB for PeeringOption.
     */
    public static final PeeringOption OPTIONB = fromString("OptionB");

    /**
     * Creates a new instance of PeeringOption value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PeeringOption() {
    }

    /**
     * Creates or finds a PeeringOption from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding PeeringOption.
     */
    public static PeeringOption fromString(String name) {
        return fromString(name, PeeringOption.class);
    }

    /**
     * Gets known PeeringOption values.
     * 
     * @return known PeeringOption values.
     */
    public static Collection<PeeringOption> values() {
        return values(PeeringOption.class);
    }
}
