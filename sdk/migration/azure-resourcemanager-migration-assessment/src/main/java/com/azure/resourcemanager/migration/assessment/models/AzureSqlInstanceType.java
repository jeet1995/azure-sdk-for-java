// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for AzureSqlInstanceType.
 */
public final class AzureSqlInstanceType extends ExpandableStringEnum<AzureSqlInstanceType> {
    /**
     * Static value Unknown for AzureSqlInstanceType.
     */
    public static final AzureSqlInstanceType UNKNOWN = fromString("Unknown");

    /**
     * Static value Automatic for AzureSqlInstanceType.
     */
    public static final AzureSqlInstanceType AUTOMATIC = fromString("Automatic");

    /**
     * Static value SingleInstance for AzureSqlInstanceType.
     */
    public static final AzureSqlInstanceType SINGLE_INSTANCE = fromString("SingleInstance");

    /**
     * Static value InstancePools for AzureSqlInstanceType.
     */
    public static final AzureSqlInstanceType INSTANCE_POOLS = fromString("InstancePools");

    /**
     * Creates a new instance of AzureSqlInstanceType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AzureSqlInstanceType() {
    }

    /**
     * Creates or finds a AzureSqlInstanceType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AzureSqlInstanceType.
     */
    public static AzureSqlInstanceType fromString(String name) {
        return fromString(name, AzureSqlInstanceType.class);
    }

    /**
     * Gets known AzureSqlInstanceType values.
     * 
     * @return known AzureSqlInstanceType values.
     */
    public static Collection<AzureSqlInstanceType> values() {
        return values(AzureSqlInstanceType.class);
    }
}
