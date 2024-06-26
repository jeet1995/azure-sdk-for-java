// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.managednetworkfabric.models.AdministrativeState;
import com.azure.resourcemanager.managednetworkfabric.models.AnnotationResource;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationState;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkDeviceRole;
import com.azure.resourcemanager.managednetworkfabric.models.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Network Device Properties defines the properties of the resource. */
@Fluent
public final class NetworkDeviceProperties extends AnnotationResource {
    /*
     * Current version of the device as defined in SKU.
     */
    @JsonProperty(value = "version", access = JsonProperty.Access.WRITE_ONLY)
    private String version;

    /*
     * Network Device SKU name.
     */
    @JsonProperty(value = "networkDeviceSku")
    private String networkDeviceSku;

    /*
     * NetworkDeviceRole is the device role: Example: CE | ToR.
     */
    @JsonProperty(value = "networkDeviceRole", access = JsonProperty.Access.WRITE_ONLY)
    private NetworkDeviceRole networkDeviceRole;

    /*
     * Reference to network rack resource id.
     */
    @JsonProperty(value = "networkRackId", access = JsonProperty.Access.WRITE_ONLY)
    private String networkRackId;

    /*
     * Management IPv4 Address.
     */
    @JsonProperty(value = "managementIpv4Address", access = JsonProperty.Access.WRITE_ONLY)
    private String managementIpv4Address;

    /*
     * Management IPv6 Address.
     */
    @JsonProperty(value = "managementIpv6Address", access = JsonProperty.Access.WRITE_ONLY)
    private String managementIpv6Address;

    /*
     * Configuration state of the resource.
     */
    @JsonProperty(value = "configurationState", access = JsonProperty.Access.WRITE_ONLY)
    private ConfigurationState configurationState;

    /*
     * Provisioning state of the resource.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * Administrative state of the resource.
     */
    @JsonProperty(value = "administrativeState", access = JsonProperty.Access.WRITE_ONLY)
    private AdministrativeState administrativeState;

    /*
     * The host name of the device.
     */
    @JsonProperty(value = "hostName")
    private String hostname;

    /*
     * Serial number of the device. Format of serial Number - Make;Model;HardwareRevisionId;SerialNumber.
     */
    @JsonProperty(value = "serialNumber")
    private String serialNumber;

    /** Creates an instance of NetworkDeviceProperties class. */
    public NetworkDeviceProperties() {
    }

    /**
     * Get the version property: Current version of the device as defined in SKU.
     *
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Get the networkDeviceSku property: Network Device SKU name.
     *
     * @return the networkDeviceSku value.
     */
    public String networkDeviceSku() {
        return this.networkDeviceSku;
    }

    /**
     * Set the networkDeviceSku property: Network Device SKU name.
     *
     * @param networkDeviceSku the networkDeviceSku value to set.
     * @return the NetworkDeviceProperties object itself.
     */
    public NetworkDeviceProperties withNetworkDeviceSku(String networkDeviceSku) {
        this.networkDeviceSku = networkDeviceSku;
        return this;
    }

    /**
     * Get the networkDeviceRole property: NetworkDeviceRole is the device role: Example: CE | ToR.
     *
     * @return the networkDeviceRole value.
     */
    public NetworkDeviceRole networkDeviceRole() {
        return this.networkDeviceRole;
    }

    /**
     * Get the networkRackId property: Reference to network rack resource id.
     *
     * @return the networkRackId value.
     */
    public String networkRackId() {
        return this.networkRackId;
    }

    /**
     * Get the managementIpv4Address property: Management IPv4 Address.
     *
     * @return the managementIpv4Address value.
     */
    public String managementIpv4Address() {
        return this.managementIpv4Address;
    }

    /**
     * Get the managementIpv6Address property: Management IPv6 Address.
     *
     * @return the managementIpv6Address value.
     */
    public String managementIpv6Address() {
        return this.managementIpv6Address;
    }

    /**
     * Get the configurationState property: Configuration state of the resource.
     *
     * @return the configurationState value.
     */
    public ConfigurationState configurationState() {
        return this.configurationState;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the administrativeState property: Administrative state of the resource.
     *
     * @return the administrativeState value.
     */
    public AdministrativeState administrativeState() {
        return this.administrativeState;
    }

    /**
     * Get the hostname property: The host name of the device.
     *
     * @return the hostname value.
     */
    public String hostname() {
        return this.hostname;
    }

    /**
     * Set the hostname property: The host name of the device.
     *
     * @param hostname the hostname value to set.
     * @return the NetworkDeviceProperties object itself.
     */
    public NetworkDeviceProperties withHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    /**
     * Get the serialNumber property: Serial number of the device. Format of serial Number -
     * Make;Model;HardwareRevisionId;SerialNumber.
     *
     * @return the serialNumber value.
     */
    public String serialNumber() {
        return this.serialNumber;
    }

    /**
     * Set the serialNumber property: Serial number of the device. Format of serial Number -
     * Make;Model;HardwareRevisionId;SerialNumber.
     *
     * @param serialNumber the serialNumber value to set.
     * @return the NetworkDeviceProperties object itself.
     */
    public NetworkDeviceProperties withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public NetworkDeviceProperties withAnnotation(String annotation) {
        super.withAnnotation(annotation);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
