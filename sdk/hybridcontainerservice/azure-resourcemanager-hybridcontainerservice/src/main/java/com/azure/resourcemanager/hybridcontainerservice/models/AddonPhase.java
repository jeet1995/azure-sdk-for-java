// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Observed phase of the addon or component on the provisioned cluster. Possible values include: 'pending',
 * 'provisioning', 'provisioning {HelmChartInstalled}', 'provisioning {MSICertificateDownloaded}', 'provisioned',
 * 'deleting', 'failed', 'upgrading'.
 */
public final class AddonPhase extends ExpandableStringEnum<AddonPhase> {
    /**
     * Static value pending for AddonPhase.
     */
    public static final AddonPhase PENDING = fromString("pending");

    /**
     * Static value provisioning for AddonPhase.
     */
    public static final AddonPhase PROVISIONING = fromString("provisioning");

    /**
     * Static value provisioning {HelmChartInstalled} for AddonPhase.
     */
    public static final AddonPhase PROVISIONING_HELM_CHART_INSTALLED = fromString("provisioning {HelmChartInstalled}");

    /**
     * Static value provisioning {MSICertificateDownloaded} for AddonPhase.
     */
    public static final AddonPhase PROVISIONING_MSICERTIFICATE_DOWNLOADED
        = fromString("provisioning {MSICertificateDownloaded}");

    /**
     * Static value provisioned for AddonPhase.
     */
    public static final AddonPhase PROVISIONED = fromString("provisioned");

    /**
     * Static value deleting for AddonPhase.
     */
    public static final AddonPhase DELETING = fromString("deleting");

    /**
     * Static value failed for AddonPhase.
     */
    public static final AddonPhase FAILED = fromString("failed");

    /**
     * Static value upgrading for AddonPhase.
     */
    public static final AddonPhase UPGRADING = fromString("upgrading");

    /**
     * Creates a new instance of AddonPhase value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AddonPhase() {
    }

    /**
     * Creates or finds a AddonPhase from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AddonPhase.
     */
    public static AddonPhase fromString(String name) {
        return fromString(name, AddonPhase.class);
    }

    /**
     * Gets known AddonPhase values.
     * 
     * @return known AddonPhase values.
     */
    public static Collection<AddonPhase> values() {
        return values(AddonPhase.class);
    }
}
