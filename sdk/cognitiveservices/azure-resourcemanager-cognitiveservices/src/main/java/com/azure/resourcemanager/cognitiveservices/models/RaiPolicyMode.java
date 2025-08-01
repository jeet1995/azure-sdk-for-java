// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Rai policy mode. The enum value mapping is as below: Default = 0, Deferred=1, Blocking=2, Asynchronous_filter =3.
 * Please use 'Asynchronous_filter' after 2025-06-01. It is the same as 'Deferred' in previous version.
 */
public final class RaiPolicyMode extends ExpandableStringEnum<RaiPolicyMode> {
    /**
     * Static value Default for RaiPolicyMode.
     */
    public static final RaiPolicyMode DEFAULT = fromString("Default");

    /**
     * Static value Deferred for RaiPolicyMode.
     */
    public static final RaiPolicyMode DEFERRED = fromString("Deferred");

    /**
     * Static value Blocking for RaiPolicyMode.
     */
    public static final RaiPolicyMode BLOCKING = fromString("Blocking");

    /**
     * Static value Asynchronous_filter for RaiPolicyMode.
     */
    public static final RaiPolicyMode ASYNCHRONOUS_FILTER = fromString("Asynchronous_filter");

    /**
     * Creates a new instance of RaiPolicyMode value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public RaiPolicyMode() {
    }

    /**
     * Creates or finds a RaiPolicyMode from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding RaiPolicyMode.
     */
    public static RaiPolicyMode fromString(String name) {
        return fromString(name, RaiPolicyMode.class);
    }

    /**
     * Gets known RaiPolicyMode values.
     * 
     * @return known RaiPolicyMode values.
     */
    public static Collection<RaiPolicyMode> values() {
        return values(RaiPolicyMode.class);
    }
}
