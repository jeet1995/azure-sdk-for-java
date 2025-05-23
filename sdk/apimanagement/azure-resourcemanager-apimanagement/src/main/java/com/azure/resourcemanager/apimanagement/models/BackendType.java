// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of the backend. A backend can be either Single or Pool.
 */
public final class BackendType extends ExpandableStringEnum<BackendType> {
    /**
     * Static value Single for BackendType.
     */
    public static final BackendType SINGLE = fromString("Single");

    /**
     * Static value Pool for BackendType.
     */
    public static final BackendType POOL = fromString("Pool");

    /**
     * Creates a new instance of BackendType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public BackendType() {
    }

    /**
     * Creates or finds a BackendType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding BackendType.
     */
    public static BackendType fromString(String name) {
        return fromString(name, BackendType.class);
    }

    /**
     * Gets known BackendType values.
     * 
     * @return known BackendType values.
     */
    public static Collection<BackendType> values() {
        return values(BackendType.class);
    }
}
