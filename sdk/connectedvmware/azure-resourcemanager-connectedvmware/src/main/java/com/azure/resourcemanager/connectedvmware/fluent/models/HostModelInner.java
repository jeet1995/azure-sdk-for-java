// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.management.SystemData;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.connectedvmware.models.ExtendedLocation;
import com.azure.resourcemanager.connectedvmware.models.ProvisioningState;
import com.azure.resourcemanager.connectedvmware.models.ResourceStatus;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Define the host.
 */
@Fluent
public final class HostModelInner extends Resource {
    /*
     * Resource properties.
     */
    private HostProperties innerProperties = new HostProperties();

    /*
     * Gets or sets the extended location.
     */
    private ExtendedLocation extendedLocation;

    /*
     * The system data.
     */
    private SystemData systemData;

    /*
     * Metadata used by portal/tooling/etc to render different UX experiences for resources of the same type; e.g.
     * ApiApps are a kind of Microsoft.Web/sites type. If supported, the resource provider must validate and persist
     * this value.
     */
    private String kind;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of HostModelInner class.
     */
    public HostModelInner() {
    }

    /**
     * Get the innerProperties property: Resource properties.
     * 
     * @return the innerProperties value.
     */
    private HostProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the extendedLocation property: Gets or sets the extended location.
     * 
     * @return the extendedLocation value.
     */
    public ExtendedLocation extendedLocation() {
        return this.extendedLocation;
    }

    /**
     * Set the extendedLocation property: Gets or sets the extended location.
     * 
     * @param extendedLocation the extendedLocation value to set.
     * @return the HostModelInner object itself.
     */
    public HostModelInner withExtendedLocation(ExtendedLocation extendedLocation) {
        this.extendedLocation = extendedLocation;
        return this;
    }

    /**
     * Get the systemData property: The system data.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the kind property: Metadata used by portal/tooling/etc to render different UX experiences for resources of
     * the same type; e.g. ApiApps are a kind of Microsoft.Web/sites type. If supported, the resource provider must
     * validate and persist this value.
     * 
     * @return the kind value.
     */
    public String kind() {
        return this.kind;
    }

    /**
     * Set the kind property: Metadata used by portal/tooling/etc to render different UX experiences for resources of
     * the same type; e.g. ApiApps are a kind of Microsoft.Web/sites type. If supported, the resource provider must
     * validate and persist this value.
     * 
     * @param kind the kind value to set.
     * @return the HostModelInner object itself.
     */
    public HostModelInner withKind(String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostModelInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HostModelInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the uuid property: Gets or sets a unique identifier for this resource.
     * 
     * @return the uuid value.
     */
    public String uuid() {
        return this.innerProperties() == null ? null : this.innerProperties().uuid();
    }

    /**
     * Get the vCenterId property: Gets or sets the ARM Id of the vCenter resource in which this host resides.
     * 
     * @return the vCenterId value.
     */
    public String vCenterId() {
        return this.innerProperties() == null ? null : this.innerProperties().vCenterId();
    }

    /**
     * Set the vCenterId property: Gets or sets the ARM Id of the vCenter resource in which this host resides.
     * 
     * @param vCenterId the vCenterId value to set.
     * @return the HostModelInner object itself.
     */
    public HostModelInner withVCenterId(String vCenterId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new HostProperties();
        }
        this.innerProperties().withVCenterId(vCenterId);
        return this;
    }

    /**
     * Get the moRefId property: Gets or sets the vCenter MoRef (Managed Object Reference) ID for the host.
     * 
     * @return the moRefId value.
     */
    public String moRefId() {
        return this.innerProperties() == null ? null : this.innerProperties().moRefId();
    }

    /**
     * Set the moRefId property: Gets or sets the vCenter MoRef (Managed Object Reference) ID for the host.
     * 
     * @param moRefId the moRefId value to set.
     * @return the HostModelInner object itself.
     */
    public HostModelInner withMoRefId(String moRefId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new HostProperties();
        }
        this.innerProperties().withMoRefId(moRefId);
        return this;
    }

    /**
     * Get the inventoryItemId property: Gets or sets the inventory Item ID for the host.
     * 
     * @return the inventoryItemId value.
     */
    public String inventoryItemId() {
        return this.innerProperties() == null ? null : this.innerProperties().inventoryItemId();
    }

    /**
     * Set the inventoryItemId property: Gets or sets the inventory Item ID for the host.
     * 
     * @param inventoryItemId the inventoryItemId value to set.
     * @return the HostModelInner object itself.
     */
    public HostModelInner withInventoryItemId(String inventoryItemId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new HostProperties();
        }
        this.innerProperties().withInventoryItemId(inventoryItemId);
        return this;
    }

    /**
     * Get the moName property: Gets or sets the vCenter Managed Object name for the host.
     * 
     * @return the moName value.
     */
    public String moName() {
        return this.innerProperties() == null ? null : this.innerProperties().moName();
    }

    /**
     * Get the statuses property: The resource status information.
     * 
     * @return the statuses value.
     */
    public List<ResourceStatus> statuses() {
        return this.innerProperties() == null ? null : this.innerProperties().statuses();
    }

    /**
     * Get the customResourceName property: Gets the name of the corresponding resource in Kubernetes.
     * 
     * @return the customResourceName value.
     */
    public String customResourceName() {
        return this.innerProperties() == null ? null : this.innerProperties().customResourceName();
    }

    /**
     * Get the overallMemoryUsageGB property: Gets the used physical memory on the host in GB.
     * 
     * @return the overallMemoryUsageGB value.
     */
    public Long overallMemoryUsageGB() {
        return this.innerProperties() == null ? null : this.innerProperties().overallMemoryUsageGB();
    }

    /**
     * Get the memorySizeGB property: Gets the total amount of physical memory on the host in GB.
     * 
     * @return the memorySizeGB value.
     */
    public Long memorySizeGB() {
        return this.innerProperties() == null ? null : this.innerProperties().memorySizeGB();
    }

    /**
     * Get the overallCpuUsageMHz property: Gets the used CPU usage across all cores in MHz.
     * 
     * @return the overallCpuUsageMHz value.
     */
    public Long overallCpuUsageMHz() {
        return this.innerProperties() == null ? null : this.innerProperties().overallCpuUsageMHz();
    }

    /**
     * Get the cpuMhz property: Gets the max CPU usage across all cores in MHz.
     * 
     * @return the cpuMhz value.
     */
    public Long cpuMhz() {
        return this.innerProperties() == null ? null : this.innerProperties().cpuMhz();
    }

    /**
     * Get the datastoreIds property: Gets the datastore ARM ids.
     * 
     * @return the datastoreIds value.
     */
    public List<String> datastoreIds() {
        return this.innerProperties() == null ? null : this.innerProperties().datastoreIds();
    }

    /**
     * Get the networkIds property: Gets the network ARM ids.
     * 
     * @return the networkIds value.
     */
    public List<String> networkIds() {
        return this.innerProperties() == null ? null : this.innerProperties().networkIds();
    }

    /**
     * Get the provisioningState property: Gets the provisioning state.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property innerProperties in model HostModelInner"));
        } else {
            innerProperties().validate();
        }
        if (extendedLocation() != null) {
            extendedLocation().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(HostModelInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        jsonWriter.writeJsonField("extendedLocation", this.extendedLocation);
        jsonWriter.writeStringField("kind", this.kind);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HostModelInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of HostModelInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the HostModelInner.
     */
    public static HostModelInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            HostModelInner deserializedHostModelInner = new HostModelInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedHostModelInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedHostModelInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedHostModelInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedHostModelInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedHostModelInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedHostModelInner.innerProperties = HostProperties.fromJson(reader);
                } else if ("extendedLocation".equals(fieldName)) {
                    deserializedHostModelInner.extendedLocation = ExtendedLocation.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedHostModelInner.systemData = SystemData.fromJson(reader);
                } else if ("kind".equals(fieldName)) {
                    deserializedHostModelInner.kind = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedHostModelInner;
        });
    }
}
