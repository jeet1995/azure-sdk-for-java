// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.managednetworkfabric.models.EnabledDisabledState;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Interface running status properties. */
@Fluent
public class InterfaceStatusInner {
    /*
     * The interface administrative state.
     */
    @JsonProperty(value = "administrativeState", access = JsonProperty.Access.WRITE_ONLY)
    private EnabledDisabledState administrativeState;

    /*
     * The interface operational status.
     */
    @JsonProperty(value = "operationalStatus")
    private String operationalStatus;

    /*
     * The physical status.
     */
    @JsonProperty(value = "phyStatus")
    private String phyStatus;

    /*
     * The interface transceiver type. Example: up or down
     */
    @JsonProperty(value = "transceiverStatus")
    private String transceiverStatus;

    /*
     * Connected to ARM resource or external interface
     */
    @JsonProperty(value = "connectedTo")
    private String connectedTo;

    /** Creates an instance of InterfaceStatusInner class. */
    public InterfaceStatusInner() {
    }

    /**
     * Get the administrativeState property: The interface administrative state.
     *
     * @return the administrativeState value.
     */
    public EnabledDisabledState administrativeState() {
        return this.administrativeState;
    }

    /**
     * Get the operationalStatus property: The interface operational status.
     *
     * @return the operationalStatus value.
     */
    public String operationalStatus() {
        return this.operationalStatus;
    }

    /**
     * Set the operationalStatus property: The interface operational status.
     *
     * @param operationalStatus the operationalStatus value to set.
     * @return the InterfaceStatusInner object itself.
     */
    public InterfaceStatusInner withOperationalStatus(String operationalStatus) {
        this.operationalStatus = operationalStatus;
        return this;
    }

    /**
     * Get the phyStatus property: The physical status.
     *
     * @return the phyStatus value.
     */
    public String phyStatus() {
        return this.phyStatus;
    }

    /**
     * Set the phyStatus property: The physical status.
     *
     * @param phyStatus the phyStatus value to set.
     * @return the InterfaceStatusInner object itself.
     */
    public InterfaceStatusInner withPhyStatus(String phyStatus) {
        this.phyStatus = phyStatus;
        return this;
    }

    /**
     * Get the transceiverStatus property: The interface transceiver type. Example: up or down.
     *
     * @return the transceiverStatus value.
     */
    public String transceiverStatus() {
        return this.transceiverStatus;
    }

    /**
     * Set the transceiverStatus property: The interface transceiver type. Example: up or down.
     *
     * @param transceiverStatus the transceiverStatus value to set.
     * @return the InterfaceStatusInner object itself.
     */
    public InterfaceStatusInner withTransceiverStatus(String transceiverStatus) {
        this.transceiverStatus = transceiverStatus;
        return this;
    }

    /**
     * Get the connectedTo property: Connected to ARM resource or external interface.
     *
     * @return the connectedTo value.
     */
    public String connectedTo() {
        return this.connectedTo;
    }

    /**
     * Set the connectedTo property: Connected to ARM resource or external interface.
     *
     * @param connectedTo the connectedTo value to set.
     * @return the InterfaceStatusInner object itself.
     */
    public InterfaceStatusInner withConnectedTo(String connectedTo) {
        this.connectedTo = connectedTo;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}