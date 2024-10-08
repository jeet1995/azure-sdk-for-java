// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.inference.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Controls what happens if extra parameters, undefined by the REST API, are passed in the JSON request payload.
 */
public final class ExtraParameters extends ExpandableStringEnum<ExtraParameters> {

    /**
     * The service will error if it detected extra parameters in the request payload. This is the service default.
     */
    @Generated
    public static final ExtraParameters ERROR = fromString("error");

    /**
     * The service will ignore (drop) extra parameters in the request payload. It will only pass the known parameters to
     * the back-end AI model.
     */
    @Generated
    public static final ExtraParameters DROP = fromString("drop");

    /**
     * The service will pass extra parameters to the back-end AI model.
     */
    @Generated
    public static final ExtraParameters PASS_THROUGH = fromString("pass-through");

    /**
     * Creates a new instance of ExtraParameters value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public ExtraParameters() {
    }

    /**
     * Creates or finds a ExtraParameters from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ExtraParameters.
     */
    @Generated
    public static ExtraParameters fromString(String name) {
        return fromString(name, ExtraParameters.class);
    }

    /**
     * Gets known ExtraParameters values.
     *
     * @return known ExtraParameters values.
     */
    @Generated
    public static Collection<ExtraParameters> values() {
        return values(ExtraParameters.class);
    }
}
