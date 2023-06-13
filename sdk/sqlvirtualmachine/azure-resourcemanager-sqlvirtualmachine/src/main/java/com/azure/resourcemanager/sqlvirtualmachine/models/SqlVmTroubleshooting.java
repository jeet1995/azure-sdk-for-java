// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sqlvirtualmachine.models;

import com.azure.resourcemanager.sqlvirtualmachine.fluent.models.SqlVmTroubleshootingInner;
import java.time.OffsetDateTime;

/** An immutable client-side representation of SqlVmTroubleshooting. */
public interface SqlVmTroubleshooting {
    /**
     * Gets the startTimeUtc property: Start time in UTC timezone.
     *
     * @return the startTimeUtc value.
     */
    OffsetDateTime startTimeUtc();

    /**
     * Gets the endTimeUtc property: End time in UTC timezone.
     *
     * @return the endTimeUtc value.
     */
    OffsetDateTime endTimeUtc();

    /**
     * Gets the troubleshootingScenario property: SQL VM troubleshooting scenario.
     *
     * @return the troubleshootingScenario value.
     */
    TroubleshootingScenario troubleshootingScenario();

    /**
     * Gets the properties property: Troubleshooting properties.
     *
     * @return the properties value.
     */
    TroubleshootingAdditionalProperties properties();

    /**
     * Gets the virtualMachineResourceId property: Virtual machine resource id for response.
     *
     * @return the virtualMachineResourceId value.
     */
    String virtualMachineResourceId();

    /**
     * Gets the inner com.azure.resourcemanager.sqlvirtualmachine.fluent.models.SqlVmTroubleshootingInner object.
     *
     * @return the inner object.
     */
    SqlVmTroubleshootingInner innerModel();
}