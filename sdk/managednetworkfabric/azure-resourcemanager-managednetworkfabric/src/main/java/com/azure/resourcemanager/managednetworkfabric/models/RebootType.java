// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of reboot to be performed. Example: GracefulRebootWithZTP.
 */
public final class RebootType extends ExpandableStringEnum<RebootType> {
    /**
     * Static value GracefulRebootWithZTP for RebootType.
     */
    public static final RebootType GRACEFUL_REBOOT_WITH_ZTP = fromString("GracefulRebootWithZTP");

    /**
     * Static value GracefulRebootWithoutZTP for RebootType.
     */
    public static final RebootType GRACEFUL_REBOOT_WITHOUT_ZTP = fromString("GracefulRebootWithoutZTP");

    /**
     * Static value UngracefulRebootWithZTP for RebootType.
     */
    public static final RebootType UNGRACEFUL_REBOOT_WITH_ZTP = fromString("UngracefulRebootWithZTP");

    /**
     * Static value UngracefulRebootWithoutZTP for RebootType.
     */
    public static final RebootType UNGRACEFUL_REBOOT_WITHOUT_ZTP = fromString("UngracefulRebootWithoutZTP");

    /**
     * Creates a new instance of RebootType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public RebootType() {
    }

    /**
     * Creates or finds a RebootType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding RebootType.
     */
    public static RebootType fromString(String name) {
        return fromString(name, RebootType.class);
    }

    /**
     * Gets known RebootType values.
     * 
     * @return known RebootType values.
     */
    public static Collection<RebootType> values() {
        return values(RebootType.class);
    }
}
