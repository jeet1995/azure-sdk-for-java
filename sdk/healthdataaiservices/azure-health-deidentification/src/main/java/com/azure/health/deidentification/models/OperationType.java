// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.health.deidentification.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Enum of supported Operation Types.
 */
public final class OperationType extends ExpandableStringEnum<OperationType> {
    /**
     * Redact Operation will remove all entities of PHI and replace them with a placeholder value.
     */
    @Generated
    public static final OperationType REDACT = fromString("Redact");

    /**
     * Surrogation Operation will replace all entities of PHI with a surrogate value.
     */
    @Generated
    public static final OperationType SURROGATE = fromString("Surrogate");

    /**
     * Tag Operation will detect all entities of PHI, their type, and return their locations in the document.
     */
    @Generated
    public static final OperationType TAG = fromString("Tag");

    /**
     * Creates a new instance of OperationType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public OperationType() {
    }

    /**
     * Creates or finds a OperationType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding OperationType.
     */
    @Generated
    public static OperationType fromString(String name) {
        return fromString(name, OperationType.class);
    }

    /**
     * Gets known OperationType values.
     * 
     * @return known OperationType values.
     */
    @Generated
    public static Collection<OperationType> values() {
        return values(OperationType.class);
    }
}
