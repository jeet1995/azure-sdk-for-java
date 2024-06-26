// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * whether webhookKey is enabled.
 */
public final class WebhookKeyEnabled extends ExpandableStringEnum<WebhookKeyEnabled> {
    /**
     * Static value true for WebhookKeyEnabled.
     */
    public static final WebhookKeyEnabled TRUE = fromString("true");

    /**
     * Static value false for WebhookKeyEnabled.
     */
    public static final WebhookKeyEnabled FALSE = fromString("false");

    /**
     * Creates a new instance of WebhookKeyEnabled value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public WebhookKeyEnabled() {
    }

    /**
     * Creates or finds a WebhookKeyEnabled from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding WebhookKeyEnabled.
     */
    public static WebhookKeyEnabled fromString(String name) {
        return fromString(name, WebhookKeyEnabled.class);
    }

    /**
     * Gets known WebhookKeyEnabled values.
     * 
     * @return known WebhookKeyEnabled values.
     */
    public static Collection<WebhookKeyEnabled> values() {
        return values(WebhookKeyEnabled.class);
    }
}
