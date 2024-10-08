/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The configuration parameters used for performing automatic OS upgrade.
 */
public class AutomaticOSUpgradePolicy {
    /**
     * Whether OS image rollback feature should be disabled.
     */
    @JsonProperty(value = "disableAutomaticRollback")
    private Boolean disableAutomaticRollback;

    /**
     * Indicates whether OS upgrades should automatically be applied to scale
     * set instances in a rolling fashion when a newer version of the OS image
     * becomes available. &lt;br /&gt;&lt;br /&gt; If this is set to true for
     * Windows based pools,
     * [WindowsConfiguration.enableAutomaticUpdates](https://learn.microsoft.com/rest/api/batchservice/pool/add?tabs=HTTP#windowsconfiguration)
     * cannot be set to true.
     */
    @JsonProperty(value = "enableAutomaticOSUpgrade")
    private Boolean enableAutomaticOSUpgrade;

    /**
     * Indicates whether rolling upgrade policy should be used during Auto OS
     * Upgrade. Auto OS Upgrade will fallback to the default policy if no
     * policy is defined on the VMSS.
     */
    @JsonProperty(value = "useRollingUpgradePolicy")
    private Boolean useRollingUpgradePolicy;

    /**
     * Defer OS upgrades on the TVMs if they are running tasks.
     */
    @JsonProperty(value = "osRollingUpgradeDeferral")
    private Boolean osRollingUpgradeDeferral;

    /**
     * Get whether OS image rollback feature should be disabled.
     *
     * @return the disableAutomaticRollback value
     */
    public Boolean disableAutomaticRollback() {
        return this.disableAutomaticRollback;
    }

    /**
     * Set whether OS image rollback feature should be disabled.
     *
     * @param disableAutomaticRollback the disableAutomaticRollback value to set
     * @return the AutomaticOSUpgradePolicy object itself.
     */
    public AutomaticOSUpgradePolicy withDisableAutomaticRollback(Boolean disableAutomaticRollback) {
        this.disableAutomaticRollback = disableAutomaticRollback;
        return this;
    }

    /**
     * Get indicates whether OS upgrades should automatically be applied to scale set instances in a rolling fashion when a newer version of the OS image becomes available. &lt;br /&gt;&lt;br /&gt; If this is set to true for Windows based pools, [WindowsConfiguration.enableAutomaticUpdates](https://learn.microsoft.com/rest/api/batchservice/pool/add?tabs=HTTP#windowsconfiguration) cannot be set to true.
     *
     * @return the enableAutomaticOSUpgrade value
     */
    public Boolean enableAutomaticOSUpgrade() {
        return this.enableAutomaticOSUpgrade;
    }

    /**
     * Set indicates whether OS upgrades should automatically be applied to scale set instances in a rolling fashion when a newer version of the OS image becomes available. &lt;br /&gt;&lt;br /&gt; If this is set to true for Windows based pools, [WindowsConfiguration.enableAutomaticUpdates](https://learn.microsoft.com/rest/api/batchservice/pool/add?tabs=HTTP#windowsconfiguration) cannot be set to true.
     *
     * @param enableAutomaticOSUpgrade the enableAutomaticOSUpgrade value to set
     * @return the AutomaticOSUpgradePolicy object itself.
     */
    public AutomaticOSUpgradePolicy withEnableAutomaticOSUpgrade(Boolean enableAutomaticOSUpgrade) {
        this.enableAutomaticOSUpgrade = enableAutomaticOSUpgrade;
        return this;
    }

    /**
     * Get indicates whether rolling upgrade policy should be used during Auto OS Upgrade. Auto OS Upgrade will fallback to the default policy if no policy is defined on the VMSS.
     *
     * @return the useRollingUpgradePolicy value
     */
    public Boolean useRollingUpgradePolicy() {
        return this.useRollingUpgradePolicy;
    }

    /**
     * Set indicates whether rolling upgrade policy should be used during Auto OS Upgrade. Auto OS Upgrade will fallback to the default policy if no policy is defined on the VMSS.
     *
     * @param useRollingUpgradePolicy the useRollingUpgradePolicy value to set
     * @return the AutomaticOSUpgradePolicy object itself.
     */
    public AutomaticOSUpgradePolicy withUseRollingUpgradePolicy(Boolean useRollingUpgradePolicy) {
        this.useRollingUpgradePolicy = useRollingUpgradePolicy;
        return this;
    }

    /**
     * Get defer OS upgrades on the TVMs if they are running tasks.
     *
     * @return the osRollingUpgradeDeferral value
     */
    public Boolean osRollingUpgradeDeferral() {
        return this.osRollingUpgradeDeferral;
    }

    /**
     * Set defer OS upgrades on the TVMs if they are running tasks.
     *
     * @param osRollingUpgradeDeferral the osRollingUpgradeDeferral value to set
     * @return the AutomaticOSUpgradePolicy object itself.
     */
    public AutomaticOSUpgradePolicy withOsRollingUpgradeDeferral(Boolean osRollingUpgradeDeferral) {
        this.osRollingUpgradeDeferral = osRollingUpgradeDeferral;
        return this;
    }

}
