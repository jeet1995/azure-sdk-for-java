// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.alertsmanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for Severity.
 */
public final class Severity extends ExpandableStringEnum<Severity> {
    /**
     * Static value Sev0 for Severity.
     */
    public static final Severity SEV0 = fromString("Sev0");

    /**
     * Static value Sev1 for Severity.
     */
    public static final Severity SEV1 = fromString("Sev1");

    /**
     * Static value Sev2 for Severity.
     */
    public static final Severity SEV2 = fromString("Sev2");

    /**
     * Static value Sev3 for Severity.
     */
    public static final Severity SEV3 = fromString("Sev3");

    /**
     * Static value Sev4 for Severity.
     */
    public static final Severity SEV4 = fromString("Sev4");

    /**
     * Creates a new instance of Severity value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public Severity() {
    }

    /**
     * Creates or finds a Severity from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding Severity.
     */
    public static Severity fromString(String name) {
        return fromString(name, Severity.class);
    }

    /**
     * Gets known Severity values.
     * 
     * @return known Severity values.
     */
    public static Collection<Severity> values() {
        return values(Severity.class);
    }
}
