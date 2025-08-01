// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The state of snapshot which determines the access availability of the snapshot.
 */
public final class SnapshotAccessState extends ExpandableStringEnum<SnapshotAccessState> {
    /**
     * Static value Unknown for SnapshotAccessState.
     */
    public static final SnapshotAccessState UNKNOWN = fromString("Unknown");

    /**
     * Static value Pending for SnapshotAccessState.
     */
    public static final SnapshotAccessState PENDING = fromString("Pending");

    /**
     * Static value Available for SnapshotAccessState.
     */
    public static final SnapshotAccessState AVAILABLE = fromString("Available");

    /**
     * Static value InstantAccess for SnapshotAccessState.
     */
    public static final SnapshotAccessState INSTANT_ACCESS = fromString("InstantAccess");

    /**
     * Static value AvailableWithInstantAccess for SnapshotAccessState.
     */
    public static final SnapshotAccessState AVAILABLE_WITH_INSTANT_ACCESS = fromString("AvailableWithInstantAccess");

    /**
     * Creates a new instance of SnapshotAccessState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SnapshotAccessState() {
    }

    /**
     * Creates or finds a SnapshotAccessState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SnapshotAccessState.
     */
    public static SnapshotAccessState fromString(String name) {
        return fromString(name, SnapshotAccessState.class);
    }

    /**
     * Gets known SnapshotAccessState values.
     * 
     * @return known SnapshotAccessState values.
     */
    public static Collection<SnapshotAccessState> values() {
        return values(SnapshotAccessState.class);
    }
}
