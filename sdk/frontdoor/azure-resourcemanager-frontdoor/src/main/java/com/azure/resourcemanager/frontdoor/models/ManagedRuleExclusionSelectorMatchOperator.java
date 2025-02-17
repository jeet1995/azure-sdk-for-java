// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.frontdoor.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Comparison operator to apply to the selector when specifying which elements in the collection this exclusion applies
 * to.
 */
public final class ManagedRuleExclusionSelectorMatchOperator
    extends ExpandableStringEnum<ManagedRuleExclusionSelectorMatchOperator> {
    /**
     * Static value Equals for ManagedRuleExclusionSelectorMatchOperator.
     */
    public static final ManagedRuleExclusionSelectorMatchOperator EQUALS = fromString("Equals");

    /**
     * Static value Contains for ManagedRuleExclusionSelectorMatchOperator.
     */
    public static final ManagedRuleExclusionSelectorMatchOperator CONTAINS = fromString("Contains");

    /**
     * Static value StartsWith for ManagedRuleExclusionSelectorMatchOperator.
     */
    public static final ManagedRuleExclusionSelectorMatchOperator STARTS_WITH = fromString("StartsWith");

    /**
     * Static value EndsWith for ManagedRuleExclusionSelectorMatchOperator.
     */
    public static final ManagedRuleExclusionSelectorMatchOperator ENDS_WITH = fromString("EndsWith");

    /**
     * Static value EqualsAny for ManagedRuleExclusionSelectorMatchOperator.
     */
    public static final ManagedRuleExclusionSelectorMatchOperator EQUALS_ANY = fromString("EqualsAny");

    /**
     * Creates a new instance of ManagedRuleExclusionSelectorMatchOperator value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ManagedRuleExclusionSelectorMatchOperator() {
    }

    /**
     * Creates or finds a ManagedRuleExclusionSelectorMatchOperator from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ManagedRuleExclusionSelectorMatchOperator.
     */
    public static ManagedRuleExclusionSelectorMatchOperator fromString(String name) {
        return fromString(name, ManagedRuleExclusionSelectorMatchOperator.class);
    }

    /**
     * Gets known ManagedRuleExclusionSelectorMatchOperator values.
     * 
     * @return known ManagedRuleExclusionSelectorMatchOperator values.
     */
    public static Collection<ManagedRuleExclusionSelectorMatchOperator> values() {
        return values(ManagedRuleExclusionSelectorMatchOperator.class);
    }
}
