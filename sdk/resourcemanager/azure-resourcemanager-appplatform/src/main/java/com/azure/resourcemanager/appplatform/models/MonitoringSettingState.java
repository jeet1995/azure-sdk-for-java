// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * State of the Monitoring Setting.
 */
public final class MonitoringSettingState extends ExpandableStringEnum<MonitoringSettingState> {
    /**
     * Static value NotAvailable for MonitoringSettingState.
     */
    public static final MonitoringSettingState NOT_AVAILABLE = fromString("NotAvailable");

    /**
     * Static value Failed for MonitoringSettingState.
     */
    public static final MonitoringSettingState FAILED = fromString("Failed");

    /**
     * Static value Succeeded for MonitoringSettingState.
     */
    public static final MonitoringSettingState SUCCEEDED = fromString("Succeeded");

    /**
     * Static value Updating for MonitoringSettingState.
     */
    public static final MonitoringSettingState UPDATING = fromString("Updating");

    /**
     * Creates a new instance of MonitoringSettingState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MonitoringSettingState() {
    }

    /**
     * Creates or finds a MonitoringSettingState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MonitoringSettingState.
     */
    public static MonitoringSettingState fromString(String name) {
        return fromString(name, MonitoringSettingState.class);
    }

    /**
     * Gets known MonitoringSettingState values.
     * 
     * @return known MonitoringSettingState values.
     */
    public static Collection<MonitoringSettingState> values() {
        return values(MonitoringSettingState.class);
    }
}
