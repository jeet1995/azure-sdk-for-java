// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for IaasvmPolicyType.
 */
public final class IaasvmPolicyType extends ExpandableStringEnum<IaasvmPolicyType> {
    /**
     * Static value Invalid for IaasvmPolicyType.
     */
    public static final IaasvmPolicyType INVALID = fromString("Invalid");

    /**
     * Static value V1 for IaasvmPolicyType.
     */
    public static final IaasvmPolicyType V1 = fromString("V1");

    /**
     * Static value V2 for IaasvmPolicyType.
     */
    public static final IaasvmPolicyType V2 = fromString("V2");

    /**
     * Creates a new instance of IaasvmPolicyType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public IaasvmPolicyType() {
    }

    /**
     * Creates or finds a IaasvmPolicyType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding IaasvmPolicyType.
     */
    public static IaasvmPolicyType fromString(String name) {
        return fromString(name, IaasvmPolicyType.class);
    }

    /**
     * Gets known IaasvmPolicyType values.
     * 
     * @return known IaasvmPolicyType values.
     */
    public static Collection<IaasvmPolicyType> values() {
        return values(IaasvmPolicyType.class);
    }
}
