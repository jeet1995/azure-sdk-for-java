// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.models;

import com.azure.core.management.SystemData;
import com.azure.resourcemanager.connectedvmware.fluent.models.VirtualMachineInstanceInner;
import java.util.List;

/**
 * An immutable client-side representation of VirtualMachineInstance.
 */
public interface VirtualMachineInstance {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the extendedLocation property: Gets or sets the extended location.
     * 
     * @return the extendedLocation value.
     */
    ExtendedLocation extendedLocation();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the placementProfile property: Placement properties.
     * 
     * @return the placementProfile value.
     */
    PlacementProfile placementProfile();

    /**
     * Gets the osProfile property: OS properties.
     * 
     * @return the osProfile value.
     */
    OsProfileForVMInstance osProfile();

    /**
     * Gets the hardwareProfile property: Hardware properties.
     * 
     * @return the hardwareProfile value.
     */
    HardwareProfile hardwareProfile();

    /**
     * Gets the networkProfile property: Network properties.
     * 
     * @return the networkProfile value.
     */
    NetworkProfile networkProfile();

    /**
     * Gets the storageProfile property: Storage properties.
     * 
     * @return the storageProfile value.
     */
    StorageProfile storageProfile();

    /**
     * Gets the securityProfile property: Gets the security profile.
     * 
     * @return the securityProfile value.
     */
    SecurityProfile securityProfile();

    /**
     * Gets the infrastructureProfile property: Gets the infrastructure profile.
     * 
     * @return the infrastructureProfile value.
     */
    InfrastructureProfile infrastructureProfile();

    /**
     * Gets the powerState property: Gets the power state of the virtual machine.
     * 
     * @return the powerState value.
     */
    String powerState();

    /**
     * Gets the statuses property: The resource status information.
     * 
     * @return the statuses value.
     */
    List<ResourceStatus> statuses();

    /**
     * Gets the provisioningState property: Gets the provisioning state.
     * 
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * Gets the resourceUid property: Gets or sets a unique identifier for the vm resource.
     * 
     * @return the resourceUid value.
     */
    String resourceUid();

    /**
     * Gets the inner com.azure.resourcemanager.connectedvmware.fluent.models.VirtualMachineInstanceInner object.
     * 
     * @return the inner object.
     */
    VirtualMachineInstanceInner innerModel();
}
