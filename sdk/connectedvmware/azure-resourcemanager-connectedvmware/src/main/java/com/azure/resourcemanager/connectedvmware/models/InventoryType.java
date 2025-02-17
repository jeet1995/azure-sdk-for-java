// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The inventory type.
 */
public final class InventoryType extends ExpandableStringEnum<InventoryType> {
    /**
     * Static value ResourcePool for InventoryType.
     */
    public static final InventoryType RESOURCE_POOL = fromString("ResourcePool");

    /**
     * Static value VirtualMachine for InventoryType.
     */
    public static final InventoryType VIRTUAL_MACHINE = fromString("VirtualMachine");

    /**
     * Static value VirtualMachineTemplate for InventoryType.
     */
    public static final InventoryType VIRTUAL_MACHINE_TEMPLATE = fromString("VirtualMachineTemplate");

    /**
     * Static value VirtualNetwork for InventoryType.
     */
    public static final InventoryType VIRTUAL_NETWORK = fromString("VirtualNetwork");

    /**
     * Static value Cluster for InventoryType.
     */
    public static final InventoryType CLUSTER = fromString("Cluster");

    /**
     * Static value Datastore for InventoryType.
     */
    public static final InventoryType DATASTORE = fromString("Datastore");

    /**
     * Static value Host for InventoryType.
     */
    public static final InventoryType HOST = fromString("Host");

    /**
     * Creates a new instance of InventoryType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public InventoryType() {
    }

    /**
     * Creates or finds a InventoryType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding InventoryType.
     */
    public static InventoryType fromString(String name) {
        return fromString(name, InventoryType.class);
    }

    /**
     * Gets known InventoryType values.
     * 
     * @return known InventoryType values.
     */
    public static Collection<InventoryType> values() {
        return values(InventoryType.class);
    }
}
