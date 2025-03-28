// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.openai.responses.models;

/**
 * Defines values for ResponsesReasoningConfigurationGenerateSummary.
 */
public enum ResponsesReasoningConfigurationGenerateSummary {
    /**
     * Enum value concise.
     */
    CONCISE("concise"),

    /**
     * Enum value detailed.
     */
    DETAILED("detailed");

    /**
     * The actual serialized value for a ResponsesReasoningConfigurationGenerateSummary instance.
     */
    private final String value;

    ResponsesReasoningConfigurationGenerateSummary(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ResponsesReasoningConfigurationGenerateSummary instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed ResponsesReasoningConfigurationGenerateSummary object, or null if unable to parse.
     */
    public static ResponsesReasoningConfigurationGenerateSummary fromString(String value) {
        if (value == null) {
            return null;
        }
        ResponsesReasoningConfigurationGenerateSummary[] items
            = ResponsesReasoningConfigurationGenerateSummary.values();
        for (ResponsesReasoningConfigurationGenerateSummary item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.value;
    }
}
