// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Specifies whether the IP configuration's private IP is IPv4 or IPv6. Default is IPv4.
 */
public final class PrivateIpAddressVersion extends ExpandableStringEnum<PrivateIpAddressVersion> {
    /**
     * The IP configuration's private IP is IPv4.
     */
    public static final PrivateIpAddressVersion IPV4 = fromString("IPv4");

    /**
     * The IP configuration's private IP is IPv6.
     */
    public static final PrivateIpAddressVersion IPV6 = fromString("IPv6");

    /**
     * Creates a new instance of PrivateIpAddressVersion value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PrivateIpAddressVersion() {
    }

    /**
     * Creates or finds a PrivateIpAddressVersion from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding PrivateIpAddressVersion.
     */
    public static PrivateIpAddressVersion fromString(String name) {
        return fromString(name, PrivateIpAddressVersion.class);
    }

    /**
     * Gets known PrivateIpAddressVersion values.
     * 
     * @return known PrivateIpAddressVersion values.
     */
    public static Collection<PrivateIpAddressVersion> values() {
        return values(PrivateIpAddressVersion.class);
    }
}
