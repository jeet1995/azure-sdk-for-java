// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * IaaS VM workload-specific backup item.
 */
@Fluent
public class IaaSvmProtectableItem extends WorkloadProtectableItem {
    /*
     * Type of the backup item.
     */
    private String protectableItemType = "IaaSVMProtectableItem";

    /*
     * Fully qualified ARM ID of the virtual machine.
     */
    private String virtualMachineId;

    /*
     * Specifies whether the container represents a Classic or an Azure Resource Manager VM.
     */
    private String virtualMachineVersion;

    /*
     * Resource group name of Recovery Services Vault.
     */
    private String resourceGroup;

    /**
     * Creates an instance of IaaSvmProtectableItem class.
     */
    public IaaSvmProtectableItem() {
    }

    /**
     * Get the protectableItemType property: Type of the backup item.
     * 
     * @return the protectableItemType value.
     */
    @Override
    public String protectableItemType() {
        return this.protectableItemType;
    }

    /**
     * Get the virtualMachineId property: Fully qualified ARM ID of the virtual machine.
     * 
     * @return the virtualMachineId value.
     */
    public String virtualMachineId() {
        return this.virtualMachineId;
    }

    /**
     * Set the virtualMachineId property: Fully qualified ARM ID of the virtual machine.
     * 
     * @param virtualMachineId the virtualMachineId value to set.
     * @return the IaaSvmProtectableItem object itself.
     */
    public IaaSvmProtectableItem withVirtualMachineId(String virtualMachineId) {
        this.virtualMachineId = virtualMachineId;
        return this;
    }

    /**
     * Get the virtualMachineVersion property: Specifies whether the container represents a Classic or an Azure Resource
     * Manager VM.
     * 
     * @return the virtualMachineVersion value.
     */
    public String virtualMachineVersion() {
        return this.virtualMachineVersion;
    }

    /**
     * Set the virtualMachineVersion property: Specifies whether the container represents a Classic or an Azure Resource
     * Manager VM.
     * 
     * @param virtualMachineVersion the virtualMachineVersion value to set.
     * @return the IaaSvmProtectableItem object itself.
     */
    public IaaSvmProtectableItem withVirtualMachineVersion(String virtualMachineVersion) {
        this.virtualMachineVersion = virtualMachineVersion;
        return this;
    }

    /**
     * Get the resourceGroup property: Resource group name of Recovery Services Vault.
     * 
     * @return the resourceGroup value.
     */
    public String resourceGroup() {
        return this.resourceGroup;
    }

    /**
     * Set the resourceGroup property: Resource group name of Recovery Services Vault.
     * 
     * @param resourceGroup the resourceGroup value to set.
     * @return the IaaSvmProtectableItem object itself.
     */
    public IaaSvmProtectableItem withResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IaaSvmProtectableItem withBackupManagementType(String backupManagementType) {
        super.withBackupManagementType(backupManagementType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IaaSvmProtectableItem withWorkloadType(String workloadType) {
        super.withWorkloadType(workloadType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IaaSvmProtectableItem withFriendlyName(String friendlyName) {
        super.withFriendlyName(friendlyName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IaaSvmProtectableItem withProtectionState(ProtectionStatus protectionState) {
        super.withProtectionState(protectionState);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("backupManagementType", backupManagementType());
        jsonWriter.writeStringField("workloadType", workloadType());
        jsonWriter.writeStringField("friendlyName", friendlyName());
        jsonWriter.writeStringField("protectionState", protectionState() == null ? null : protectionState().toString());
        jsonWriter.writeStringField("protectableItemType", this.protectableItemType);
        jsonWriter.writeStringField("virtualMachineId", this.virtualMachineId);
        jsonWriter.writeStringField("virtualMachineVersion", this.virtualMachineVersion);
        jsonWriter.writeStringField("resourceGroup", this.resourceGroup);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IaaSvmProtectableItem from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IaaSvmProtectableItem if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the IaaSvmProtectableItem.
     */
    public static IaaSvmProtectableItem fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("protectableItemType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("Microsoft.ClassicCompute/virtualMachines".equals(discriminatorValue)) {
                    return AzureIaaSClassicComputeVMProtectableItem.fromJson(readerToUse.reset());
                } else if ("Microsoft.Compute/virtualMachines".equals(discriminatorValue)) {
                    return AzureIaaSComputeVMProtectableItem.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static IaaSvmProtectableItem fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IaaSvmProtectableItem deserializedIaaSvmProtectableItem = new IaaSvmProtectableItem();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("backupManagementType".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.withBackupManagementType(reader.getString());
                } else if ("workloadType".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.withWorkloadType(reader.getString());
                } else if ("friendlyName".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.withFriendlyName(reader.getString());
                } else if ("protectionState".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem
                        .withProtectionState(ProtectionStatus.fromString(reader.getString()));
                } else if ("protectableItemType".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.protectableItemType = reader.getString();
                } else if ("virtualMachineId".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.virtualMachineId = reader.getString();
                } else if ("virtualMachineVersion".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.virtualMachineVersion = reader.getString();
                } else if ("resourceGroup".equals(fieldName)) {
                    deserializedIaaSvmProtectableItem.resourceGroup = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIaaSvmProtectableItem;
        });
    }
}
