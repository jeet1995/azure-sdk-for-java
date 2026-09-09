// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import java.util.Locale;

/**
 * Controls whether a benchmark leaves an SDK feature at its default or explicitly enables or disables it.
 */
public enum FeatureMode {
    /**
     * Do not override the SDK configuration.
     */
    DEFAULT,

    /**
     * Explicitly enable the feature.
     */
    ENABLED,

    /**
     * Explicitly disable the feature.
     */
    DISABLED;

    static FeatureMode fromConfig(String value, String propertyName) {
        if (value == null || value.isEmpty()) {
            return DEFAULT;
        }

        try {
            return FeatureMode.valueOf(value.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                propertyName + " must be one of DEFAULT, ENABLED, or DISABLED. Got: " + value,
                e);
        }
    }

    Boolean toNullableBoolean() {
        if (this == DEFAULT) {
            return null;
        }
        return this == ENABLED;
    }
}
