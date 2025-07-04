// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.networkcloud.fluent.models.BareMetalMachineInner;
import com.azure.resourcemanager.networkcloud.models.AdministrativeCredentials;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachine;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineCordonParameters;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineCordonStatus;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineDetailedStatus;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachinePatchParameters;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachinePowerOffParameters;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachinePowerState;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineProvisioningState;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineReadyState;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineReplaceParameters;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineRunCommandParameters;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineRunDataExtractsParameters;
import com.azure.resourcemanager.networkcloud.models.BareMetalMachineRunReadCommandsParameters;
import com.azure.resourcemanager.networkcloud.models.ExtendedLocation;
import com.azure.resourcemanager.networkcloud.models.HardwareInventory;
import com.azure.resourcemanager.networkcloud.models.HardwareValidationStatus;
import com.azure.resourcemanager.networkcloud.models.OperationStatusResult;
import com.azure.resourcemanager.networkcloud.models.RuntimeProtectionStatus;
import com.azure.resourcemanager.networkcloud.models.SecretRotationStatus;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class BareMetalMachineImpl
    implements BareMetalMachine, BareMetalMachine.Definition, BareMetalMachine.Update {
    private BareMetalMachineInner innerObject;

    private final com.azure.resourcemanager.networkcloud.NetworkCloudManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public String etag() {
        return this.innerModel().etag();
    }

    public ExtendedLocation extendedLocation() {
        return this.innerModel().extendedLocation();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public List<String> associatedResourceIds() {
        List<String> inner = this.innerModel().associatedResourceIds();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String bmcConnectionString() {
        return this.innerModel().bmcConnectionString();
    }

    public AdministrativeCredentials bmcCredentials() {
        return this.innerModel().bmcCredentials();
    }

    public String bmcMacAddress() {
        return this.innerModel().bmcMacAddress();
    }

    public String bootMacAddress() {
        return this.innerModel().bootMacAddress();
    }

    public String clusterId() {
        return this.innerModel().clusterId();
    }

    public BareMetalMachineCordonStatus cordonStatus() {
        return this.innerModel().cordonStatus();
    }

    public BareMetalMachineDetailedStatus detailedStatus() {
        return this.innerModel().detailedStatus();
    }

    public String detailedStatusMessage() {
        return this.innerModel().detailedStatusMessage();
    }

    public HardwareInventory hardwareInventory() {
        return this.innerModel().hardwareInventory();
    }

    public HardwareValidationStatus hardwareValidationStatus() {
        return this.innerModel().hardwareValidationStatus();
    }

    public List<String> hybridAksClustersAssociatedIds() {
        List<String> inner = this.innerModel().hybridAksClustersAssociatedIds();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String kubernetesNodeName() {
        return this.innerModel().kubernetesNodeName();
    }

    public String kubernetesVersion() {
        return this.innerModel().kubernetesVersion();
    }

    public String machineClusterVersion() {
        return this.innerModel().machineClusterVersion();
    }

    public String machineDetails() {
        return this.innerModel().machineDetails();
    }

    public String machineName() {
        return this.innerModel().machineName();
    }

    public List<String> machineRoles() {
        List<String> inner = this.innerModel().machineRoles();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String machineSkuId() {
        return this.innerModel().machineSkuId();
    }

    public String oamIpv4Address() {
        return this.innerModel().oamIpv4Address();
    }

    public String oamIpv6Address() {
        return this.innerModel().oamIpv6Address();
    }

    public String osImage() {
        return this.innerModel().osImage();
    }

    public BareMetalMachinePowerState powerState() {
        return this.innerModel().powerState();
    }

    public BareMetalMachineProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public String rackId() {
        return this.innerModel().rackId();
    }

    public long rackSlot() {
        return this.innerModel().rackSlot();
    }

    public BareMetalMachineReadyState readyState() {
        return this.innerModel().readyState();
    }

    public RuntimeProtectionStatus runtimeProtectionStatus() {
        return this.innerModel().runtimeProtectionStatus();
    }

    public List<SecretRotationStatus> secretRotationStatus() {
        List<SecretRotationStatus> inner = this.innerModel().secretRotationStatus();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String serialNumber() {
        return this.innerModel().serialNumber();
    }

    public String serviceTag() {
        return this.innerModel().serviceTag();
    }

    public List<String> virtualMachinesAssociatedIds() {
        List<String> inner = this.innerModel().virtualMachinesAssociatedIds();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public BareMetalMachineInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.networkcloud.NetworkCloudManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String bareMetalMachineName;

    private String createIfMatch;

    private String createIfNoneMatch;

    private String updateIfMatch;

    private String updateIfNoneMatch;

    private BareMetalMachinePatchParameters updateBareMetalMachineUpdateParameters;

    public BareMetalMachineImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public BareMetalMachine create() {
        this.innerObject = serviceManager.serviceClient()
            .getBareMetalMachines()
            .createOrUpdate(resourceGroupName, bareMetalMachineName, this.innerModel(), createIfMatch,
                createIfNoneMatch, Context.NONE);
        return this;
    }

    public BareMetalMachine create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getBareMetalMachines()
            .createOrUpdate(resourceGroupName, bareMetalMachineName, this.innerModel(), createIfMatch,
                createIfNoneMatch, context);
        return this;
    }

    BareMetalMachineImpl(String name, com.azure.resourcemanager.networkcloud.NetworkCloudManager serviceManager) {
        this.innerObject = new BareMetalMachineInner();
        this.serviceManager = serviceManager;
        this.bareMetalMachineName = name;
        this.createIfMatch = null;
        this.createIfNoneMatch = null;
    }

    public BareMetalMachineImpl update() {
        this.updateIfMatch = null;
        this.updateIfNoneMatch = null;
        this.updateBareMetalMachineUpdateParameters = new BareMetalMachinePatchParameters();
        return this;
    }

    public BareMetalMachine apply() {
        this.innerObject = serviceManager.serviceClient()
            .getBareMetalMachines()
            .update(resourceGroupName, bareMetalMachineName, updateIfMatch, updateIfNoneMatch,
                updateBareMetalMachineUpdateParameters, Context.NONE);
        return this;
    }

    public BareMetalMachine apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getBareMetalMachines()
            .update(resourceGroupName, bareMetalMachineName, updateIfMatch, updateIfNoneMatch,
                updateBareMetalMachineUpdateParameters, context);
        return this;
    }

    BareMetalMachineImpl(BareMetalMachineInner innerObject,
        com.azure.resourcemanager.networkcloud.NetworkCloudManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.bareMetalMachineName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "bareMetalMachines");
    }

    public BareMetalMachine refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getBareMetalMachines()
            .getByResourceGroupWithResponse(resourceGroupName, bareMetalMachineName, Context.NONE)
            .getValue();
        return this;
    }

    public BareMetalMachine refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getBareMetalMachines()
            .getByResourceGroupWithResponse(resourceGroupName, bareMetalMachineName, context)
            .getValue();
        return this;
    }

    public OperationStatusResult cordon() {
        return serviceManager.bareMetalMachines().cordon(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult cordon(BareMetalMachineCordonParameters bareMetalMachineCordonParameters,
        Context context) {
        return serviceManager.bareMetalMachines()
            .cordon(resourceGroupName, bareMetalMachineName, bareMetalMachineCordonParameters, context);
    }

    public OperationStatusResult powerOff() {
        return serviceManager.bareMetalMachines().powerOff(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult powerOff(BareMetalMachinePowerOffParameters bareMetalMachinePowerOffParameters,
        Context context) {
        return serviceManager.bareMetalMachines()
            .powerOff(resourceGroupName, bareMetalMachineName, bareMetalMachinePowerOffParameters, context);
    }

    public OperationStatusResult reimage() {
        return serviceManager.bareMetalMachines().reimage(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult reimage(Context context) {
        return serviceManager.bareMetalMachines().reimage(resourceGroupName, bareMetalMachineName, context);
    }

    public OperationStatusResult replace() {
        return serviceManager.bareMetalMachines().replace(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult replace(BareMetalMachineReplaceParameters bareMetalMachineReplaceParameters,
        Context context) {
        return serviceManager.bareMetalMachines()
            .replace(resourceGroupName, bareMetalMachineName, bareMetalMachineReplaceParameters, context);
    }

    public OperationStatusResult restart() {
        return serviceManager.bareMetalMachines().restart(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult restart(Context context) {
        return serviceManager.bareMetalMachines().restart(resourceGroupName, bareMetalMachineName, context);
    }

    public OperationStatusResult runCommand(BareMetalMachineRunCommandParameters bareMetalMachineRunCommandParameters) {
        return serviceManager.bareMetalMachines()
            .runCommand(resourceGroupName, bareMetalMachineName, bareMetalMachineRunCommandParameters);
    }

    public OperationStatusResult runCommand(BareMetalMachineRunCommandParameters bareMetalMachineRunCommandParameters,
        Context context) {
        return serviceManager.bareMetalMachines()
            .runCommand(resourceGroupName, bareMetalMachineName, bareMetalMachineRunCommandParameters, context);
    }

    public OperationStatusResult
        runDataExtracts(BareMetalMachineRunDataExtractsParameters bareMetalMachineRunDataExtractsParameters) {
        return serviceManager.bareMetalMachines()
            .runDataExtracts(resourceGroupName, bareMetalMachineName, bareMetalMachineRunDataExtractsParameters);
    }

    public OperationStatusResult runDataExtracts(
        BareMetalMachineRunDataExtractsParameters bareMetalMachineRunDataExtractsParameters, Context context) {
        return serviceManager.bareMetalMachines()
            .runDataExtracts(resourceGroupName, bareMetalMachineName, bareMetalMachineRunDataExtractsParameters,
                context);
    }

    public OperationStatusResult
        runReadCommands(BareMetalMachineRunReadCommandsParameters bareMetalMachineRunReadCommandsParameters) {
        return serviceManager.bareMetalMachines()
            .runReadCommands(resourceGroupName, bareMetalMachineName, bareMetalMachineRunReadCommandsParameters);
    }

    public OperationStatusResult runReadCommands(
        BareMetalMachineRunReadCommandsParameters bareMetalMachineRunReadCommandsParameters, Context context) {
        return serviceManager.bareMetalMachines()
            .runReadCommands(resourceGroupName, bareMetalMachineName, bareMetalMachineRunReadCommandsParameters,
                context);
    }

    public OperationStatusResult start() {
        return serviceManager.bareMetalMachines().start(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult start(Context context) {
        return serviceManager.bareMetalMachines().start(resourceGroupName, bareMetalMachineName, context);
    }

    public OperationStatusResult uncordon() {
        return serviceManager.bareMetalMachines().uncordon(resourceGroupName, bareMetalMachineName);
    }

    public OperationStatusResult uncordon(Context context) {
        return serviceManager.bareMetalMachines().uncordon(resourceGroupName, bareMetalMachineName, context);
    }

    public BareMetalMachineImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public BareMetalMachineImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public BareMetalMachineImpl withExtendedLocation(ExtendedLocation extendedLocation) {
        this.innerModel().withExtendedLocation(extendedLocation);
        return this;
    }

    public BareMetalMachineImpl withBmcConnectionString(String bmcConnectionString) {
        this.innerModel().withBmcConnectionString(bmcConnectionString);
        return this;
    }

    public BareMetalMachineImpl withBmcCredentials(AdministrativeCredentials bmcCredentials) {
        this.innerModel().withBmcCredentials(bmcCredentials);
        return this;
    }

    public BareMetalMachineImpl withBmcMacAddress(String bmcMacAddress) {
        this.innerModel().withBmcMacAddress(bmcMacAddress);
        return this;
    }

    public BareMetalMachineImpl withBootMacAddress(String bootMacAddress) {
        this.innerModel().withBootMacAddress(bootMacAddress);
        return this;
    }

    public BareMetalMachineImpl withMachineDetails(String machineDetails) {
        if (isInCreateMode()) {
            this.innerModel().withMachineDetails(machineDetails);
            return this;
        } else {
            this.updateBareMetalMachineUpdateParameters.withMachineDetails(machineDetails);
            return this;
        }
    }

    public BareMetalMachineImpl withMachineName(String machineName) {
        this.innerModel().withMachineName(machineName);
        return this;
    }

    public BareMetalMachineImpl withMachineSkuId(String machineSkuId) {
        this.innerModel().withMachineSkuId(machineSkuId);
        return this;
    }

    public BareMetalMachineImpl withRackId(String rackId) {
        this.innerModel().withRackId(rackId);
        return this;
    }

    public BareMetalMachineImpl withRackSlot(long rackSlot) {
        this.innerModel().withRackSlot(rackSlot);
        return this;
    }

    public BareMetalMachineImpl withSerialNumber(String serialNumber) {
        this.innerModel().withSerialNumber(serialNumber);
        return this;
    }

    public BareMetalMachineImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBareMetalMachineUpdateParameters.withTags(tags);
            return this;
        }
    }

    public BareMetalMachineImpl withMachineClusterVersion(String machineClusterVersion) {
        this.innerModel().withMachineClusterVersion(machineClusterVersion);
        return this;
    }

    public BareMetalMachineImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.createIfMatch = ifMatch;
            return this;
        } else {
            this.updateIfMatch = ifMatch;
            return this;
        }
    }

    public BareMetalMachineImpl withIfNoneMatch(String ifNoneMatch) {
        if (isInCreateMode()) {
            this.createIfNoneMatch = ifNoneMatch;
            return this;
        } else {
            this.updateIfNoneMatch = ifNoneMatch;
            return this;
        }
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
