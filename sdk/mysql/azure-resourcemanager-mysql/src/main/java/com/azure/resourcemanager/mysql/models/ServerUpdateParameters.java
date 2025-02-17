// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.mysql.fluent.models.ServerUpdateParametersProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/** Parameters allowed to update for a server. */
@Fluent
public final class ServerUpdateParameters {
    @JsonIgnore
    private final ClientLogger logger = new ClientLogger(ServerUpdateParameters.class);

    /*
     * The Azure Active Directory identity of the server.
     */
    @JsonProperty(value = "identity")
    private ResourceIdentity identity;

    /*
     * The SKU (pricing tier) of the server.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /*
     * The properties that can be updated for a server.
     */
    @JsonProperty(value = "properties")
    private ServerUpdateParametersProperties innerProperties;

    /*
     * Application-specific metadata in the form of key-value pairs.
     */
    @JsonProperty(value = "tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL, content = JsonInclude.Include.ALWAYS)
    private Map<String, String> tags;

    /**
     * Get the identity property: The Azure Active Directory identity of the server.
     *
     * @return the identity value.
     */
    public ResourceIdentity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: The Azure Active Directory identity of the server.
     *
     * @param identity the identity value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withIdentity(ResourceIdentity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the sku property: The SKU (pricing tier) of the server.
     *
     * @return the sku value.
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku property: The SKU (pricing tier) of the server.
     *
     * @param sku the sku value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the innerProperties property: The properties that can be updated for a server.
     *
     * @return the innerProperties value.
     */
    private ServerUpdateParametersProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the tags property: Application-specific metadata in the form of key-value pairs.
     *
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Application-specific metadata in the form of key-value pairs.
     *
     * @param tags the tags value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the storageProfile property: Storage profile of a server.
     *
     * @return the storageProfile value.
     */
    public StorageProfile storageProfile() {
        return this.innerProperties() == null ? null : this.innerProperties().storageProfile();
    }

    /**
     * Set the storageProfile property: Storage profile of a server.
     *
     * @param storageProfile the storageProfile value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withStorageProfile(StorageProfile storageProfile) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withStorageProfile(storageProfile);
        return this;
    }

    /**
     * Get the administratorLoginPassword property: The password of the administrator login.
     *
     * @return the administratorLoginPassword value.
     */
    public String administratorLoginPassword() {
        return this.innerProperties() == null ? null : this.innerProperties().administratorLoginPassword();
    }

    /**
     * Set the administratorLoginPassword property: The password of the administrator login.
     *
     * @param administratorLoginPassword the administratorLoginPassword value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withAdministratorLoginPassword(String administratorLoginPassword) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withAdministratorLoginPassword(administratorLoginPassword);
        return this;
    }

    /**
     * Get the version property: The version of a server.
     *
     * @return the version value.
     */
    public ServerVersion version() {
        return this.innerProperties() == null ? null : this.innerProperties().version();
    }

    /**
     * Set the version property: The version of a server.
     *
     * @param version the version value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withVersion(ServerVersion version) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withVersion(version);
        return this;
    }

    /**
     * Get the sslEnforcement property: Enable ssl enforcement or not when connect to server.
     *
     * @return the sslEnforcement value.
     */
    public SslEnforcementEnum sslEnforcement() {
        return this.innerProperties() == null ? null : this.innerProperties().sslEnforcement();
    }

    /**
     * Set the sslEnforcement property: Enable ssl enforcement or not when connect to server.
     *
     * @param sslEnforcement the sslEnforcement value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withSslEnforcement(SslEnforcementEnum sslEnforcement) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withSslEnforcement(sslEnforcement);
        return this;
    }

    /**
     * Get the minimalTlsVersion property: Enforce a minimal Tls version for the server.
     *
     * @return the minimalTlsVersion value.
     */
    public MinimalTlsVersionEnum minimalTlsVersion() {
        return this.innerProperties() == null ? null : this.innerProperties().minimalTlsVersion();
    }

    /**
     * Set the minimalTlsVersion property: Enforce a minimal Tls version for the server.
     *
     * @param minimalTlsVersion the minimalTlsVersion value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withMinimalTlsVersion(MinimalTlsVersionEnum minimalTlsVersion) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withMinimalTlsVersion(minimalTlsVersion);
        return this;
    }

    /**
     * Get the publicNetworkAccess property: Whether or not public network access is allowed for this server. Value is
     * optional but if passed in, must be 'Enabled' or 'Disabled'.
     *
     * @return the publicNetworkAccess value.
     */
    public PublicNetworkAccessEnum publicNetworkAccess() {
        return this.innerProperties() == null ? null : this.innerProperties().publicNetworkAccess();
    }

    /**
     * Set the publicNetworkAccess property: Whether or not public network access is allowed for this server. Value is
     * optional but if passed in, must be 'Enabled' or 'Disabled'.
     *
     * @param publicNetworkAccess the publicNetworkAccess value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withPublicNetworkAccess(PublicNetworkAccessEnum publicNetworkAccess) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withPublicNetworkAccess(publicNetworkAccess);
        return this;
    }

    /**
     * Get the replicationRole property: The replication role of the server.
     *
     * @return the replicationRole value.
     */
    public String replicationRole() {
        return this.innerProperties() == null ? null : this.innerProperties().replicationRole();
    }

    /**
     * Set the replicationRole property: The replication role of the server.
     *
     * @param replicationRole the replicationRole value to set.
     * @return the ServerUpdateParameters object itself.
     */
    public ServerUpdateParameters withReplicationRole(String replicationRole) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerUpdateParametersProperties();
        }
        this.innerProperties().withReplicationRole(replicationRole);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (identity() != null) {
            identity().validate();
        }
        if (sku() != null) {
            sku().validate();
        }
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
