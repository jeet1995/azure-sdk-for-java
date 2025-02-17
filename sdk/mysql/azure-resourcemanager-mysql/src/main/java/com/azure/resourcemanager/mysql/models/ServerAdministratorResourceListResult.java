// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.mysql.fluent.models.ServerAdministratorResourceInner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The response to a list Active Directory Administrators request. */
@Fluent
public final class ServerAdministratorResourceListResult {
    @JsonIgnore
    private final ClientLogger logger = new ClientLogger(ServerAdministratorResourceListResult.class);

    /*
     * The list of server Active Directory Administrators for the server.
     */
    @JsonProperty(value = "value")
    private List<ServerAdministratorResourceInner> value;

    /**
     * Get the value property: The list of server Active Directory Administrators for the server.
     *
     * @return the value value.
     */
    public List<ServerAdministratorResourceInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of server Active Directory Administrators for the server.
     *
     * @param value the value value to set.
     * @return the ServerAdministratorResourceListResult object itself.
     */
    public ServerAdministratorResourceListResult withValue(List<ServerAdministratorResourceInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
