// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SubResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.network.models.ApplicationGatewayConnectionDraining;
import com.azure.resourcemanager.network.models.ApplicationGatewayCookieBasedAffinity;
import com.azure.resourcemanager.network.models.ApplicationGatewayProtocol;
import com.azure.resourcemanager.network.models.ProvisioningState;
import java.io.IOException;
import java.util.List;

/**
 * Properties of Backend address pool settings of an application gateway.
 */
@Fluent
public final class ApplicationGatewayBackendHttpSettingsPropertiesFormat
    implements JsonSerializable<ApplicationGatewayBackendHttpSettingsPropertiesFormat> {
    /*
     * The destination port on the backend.
     */
    private Integer port;

    /*
     * The protocol used to communicate with the backend.
     */
    private ApplicationGatewayProtocol protocol;

    /*
     * Cookie based affinity.
     */
    private ApplicationGatewayCookieBasedAffinity cookieBasedAffinity;

    /*
     * Request timeout in seconds. Application Gateway will fail the request if response is not received within
     * RequestTimeout. Acceptable values are from 1 second to 86400 seconds.
     */
    private Integer requestTimeout;

    /*
     * Probe resource of an application gateway.
     */
    private SubResource probe;

    /*
     * Array of references to application gateway authentication certificates.
     */
    private List<SubResource> authenticationCertificates;

    /*
     * Array of references to application gateway trusted root certificates.
     */
    private List<SubResource> trustedRootCertificates;

    /*
     * Connection draining of the backend http settings resource.
     */
    private ApplicationGatewayConnectionDraining connectionDraining;

    /*
     * Host header to be sent to the backend servers.
     */
    private String hostname;

    /*
     * Whether to pick host header should be picked from the host name of the backend server. Default value is false.
     */
    private Boolean pickHostnameFromBackendAddress;

    /*
     * Cookie name to use for the affinity cookie.
     */
    private String affinityCookieName;

    /*
     * Whether the probe is enabled. Default value is false.
     */
    private Boolean probeEnabled;

    /*
     * Path which should be used as a prefix for all HTTP requests. Null means no path will be prefixed. Default value
     * is null.
     */
    private String path;

    /*
     * The provisioning state of the backend HTTP settings resource.
     */
    private ProvisioningState provisioningState;

    /**
     * Creates an instance of ApplicationGatewayBackendHttpSettingsPropertiesFormat class.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat() {
    }

    /**
     * Get the port property: The destination port on the backend.
     * 
     * @return the port value.
     */
    public Integer port() {
        return this.port;
    }

    /**
     * Set the port property: The destination port on the backend.
     * 
     * @param port the port value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withPort(Integer port) {
        this.port = port;
        return this;
    }

    /**
     * Get the protocol property: The protocol used to communicate with the backend.
     * 
     * @return the protocol value.
     */
    public ApplicationGatewayProtocol protocol() {
        return this.protocol;
    }

    /**
     * Set the protocol property: The protocol used to communicate with the backend.
     * 
     * @param protocol the protocol value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withProtocol(ApplicationGatewayProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get the cookieBasedAffinity property: Cookie based affinity.
     * 
     * @return the cookieBasedAffinity value.
     */
    public ApplicationGatewayCookieBasedAffinity cookieBasedAffinity() {
        return this.cookieBasedAffinity;
    }

    /**
     * Set the cookieBasedAffinity property: Cookie based affinity.
     * 
     * @param cookieBasedAffinity the cookieBasedAffinity value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat
        withCookieBasedAffinity(ApplicationGatewayCookieBasedAffinity cookieBasedAffinity) {
        this.cookieBasedAffinity = cookieBasedAffinity;
        return this;
    }

    /**
     * Get the requestTimeout property: Request timeout in seconds. Application Gateway will fail the request if
     * response is not received within RequestTimeout. Acceptable values are from 1 second to 86400 seconds.
     * 
     * @return the requestTimeout value.
     */
    public Integer requestTimeout() {
        return this.requestTimeout;
    }

    /**
     * Set the requestTimeout property: Request timeout in seconds. Application Gateway will fail the request if
     * response is not received within RequestTimeout. Acceptable values are from 1 second to 86400 seconds.
     * 
     * @param requestTimeout the requestTimeout value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withRequestTimeout(Integer requestTimeout) {
        this.requestTimeout = requestTimeout;
        return this;
    }

    /**
     * Get the probe property: Probe resource of an application gateway.
     * 
     * @return the probe value.
     */
    public SubResource probe() {
        return this.probe;
    }

    /**
     * Set the probe property: Probe resource of an application gateway.
     * 
     * @param probe the probe value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withProbe(SubResource probe) {
        this.probe = probe;
        return this;
    }

    /**
     * Get the authenticationCertificates property: Array of references to application gateway authentication
     * certificates.
     * 
     * @return the authenticationCertificates value.
     */
    public List<SubResource> authenticationCertificates() {
        return this.authenticationCertificates;
    }

    /**
     * Set the authenticationCertificates property: Array of references to application gateway authentication
     * certificates.
     * 
     * @param authenticationCertificates the authenticationCertificates value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat
        withAuthenticationCertificates(List<SubResource> authenticationCertificates) {
        this.authenticationCertificates = authenticationCertificates;
        return this;
    }

    /**
     * Get the trustedRootCertificates property: Array of references to application gateway trusted root certificates.
     * 
     * @return the trustedRootCertificates value.
     */
    public List<SubResource> trustedRootCertificates() {
        return this.trustedRootCertificates;
    }

    /**
     * Set the trustedRootCertificates property: Array of references to application gateway trusted root certificates.
     * 
     * @param trustedRootCertificates the trustedRootCertificates value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat
        withTrustedRootCertificates(List<SubResource> trustedRootCertificates) {
        this.trustedRootCertificates = trustedRootCertificates;
        return this;
    }

    /**
     * Get the connectionDraining property: Connection draining of the backend http settings resource.
     * 
     * @return the connectionDraining value.
     */
    public ApplicationGatewayConnectionDraining connectionDraining() {
        return this.connectionDraining;
    }

    /**
     * Set the connectionDraining property: Connection draining of the backend http settings resource.
     * 
     * @param connectionDraining the connectionDraining value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat
        withConnectionDraining(ApplicationGatewayConnectionDraining connectionDraining) {
        this.connectionDraining = connectionDraining;
        return this;
    }

    /**
     * Get the hostname property: Host header to be sent to the backend servers.
     * 
     * @return the hostname value.
     */
    public String hostname() {
        return this.hostname;
    }

    /**
     * Set the hostname property: Host header to be sent to the backend servers.
     * 
     * @param hostname the hostname value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    /**
     * Get the pickHostnameFromBackendAddress property: Whether to pick host header should be picked from the host name
     * of the backend server. Default value is false.
     * 
     * @return the pickHostnameFromBackendAddress value.
     */
    public Boolean pickHostnameFromBackendAddress() {
        return this.pickHostnameFromBackendAddress;
    }

    /**
     * Set the pickHostnameFromBackendAddress property: Whether to pick host header should be picked from the host name
     * of the backend server. Default value is false.
     * 
     * @param pickHostnameFromBackendAddress the pickHostnameFromBackendAddress value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat
        withPickHostnameFromBackendAddress(Boolean pickHostnameFromBackendAddress) {
        this.pickHostnameFromBackendAddress = pickHostnameFromBackendAddress;
        return this;
    }

    /**
     * Get the affinityCookieName property: Cookie name to use for the affinity cookie.
     * 
     * @return the affinityCookieName value.
     */
    public String affinityCookieName() {
        return this.affinityCookieName;
    }

    /**
     * Set the affinityCookieName property: Cookie name to use for the affinity cookie.
     * 
     * @param affinityCookieName the affinityCookieName value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withAffinityCookieName(String affinityCookieName) {
        this.affinityCookieName = affinityCookieName;
        return this;
    }

    /**
     * Get the probeEnabled property: Whether the probe is enabled. Default value is false.
     * 
     * @return the probeEnabled value.
     */
    public Boolean probeEnabled() {
        return this.probeEnabled;
    }

    /**
     * Set the probeEnabled property: Whether the probe is enabled. Default value is false.
     * 
     * @param probeEnabled the probeEnabled value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withProbeEnabled(Boolean probeEnabled) {
        this.probeEnabled = probeEnabled;
        return this;
    }

    /**
     * Get the path property: Path which should be used as a prefix for all HTTP requests. Null means no path will be
     * prefixed. Default value is null.
     * 
     * @return the path value.
     */
    public String path() {
        return this.path;
    }

    /**
     * Set the path property: Path which should be used as a prefix for all HTTP requests. Null means no path will be
     * prefixed. Default value is null.
     * 
     * @param path the path value to set.
     * @return the ApplicationGatewayBackendHttpSettingsPropertiesFormat object itself.
     */
    public ApplicationGatewayBackendHttpSettingsPropertiesFormat withPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state of the backend HTTP settings resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (connectionDraining() != null) {
            connectionDraining().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeNumberField("port", this.port);
        jsonWriter.writeStringField("protocol", this.protocol == null ? null : this.protocol.toString());
        jsonWriter.writeStringField("cookieBasedAffinity",
            this.cookieBasedAffinity == null ? null : this.cookieBasedAffinity.toString());
        jsonWriter.writeNumberField("requestTimeout", this.requestTimeout);
        jsonWriter.writeJsonField("probe", this.probe);
        jsonWriter.writeArrayField("authenticationCertificates", this.authenticationCertificates,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("trustedRootCertificates", this.trustedRootCertificates,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("connectionDraining", this.connectionDraining);
        jsonWriter.writeStringField("hostName", this.hostname);
        jsonWriter.writeBooleanField("pickHostNameFromBackendAddress", this.pickHostnameFromBackendAddress);
        jsonWriter.writeStringField("affinityCookieName", this.affinityCookieName);
        jsonWriter.writeBooleanField("probeEnabled", this.probeEnabled);
        jsonWriter.writeStringField("path", this.path);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApplicationGatewayBackendHttpSettingsPropertiesFormat from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApplicationGatewayBackendHttpSettingsPropertiesFormat if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ApplicationGatewayBackendHttpSettingsPropertiesFormat.
     */
    public static ApplicationGatewayBackendHttpSettingsPropertiesFormat fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            ApplicationGatewayBackendHttpSettingsPropertiesFormat deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat
                = new ApplicationGatewayBackendHttpSettingsPropertiesFormat();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("port".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.port
                        = reader.getNullable(JsonReader::getInt);
                } else if ("protocol".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.protocol
                        = ApplicationGatewayProtocol.fromString(reader.getString());
                } else if ("cookieBasedAffinity".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.cookieBasedAffinity
                        = ApplicationGatewayCookieBasedAffinity.fromString(reader.getString());
                } else if ("requestTimeout".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.requestTimeout
                        = reader.getNullable(JsonReader::getInt);
                } else if ("probe".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.probe
                        = SubResource.fromJson(reader);
                } else if ("authenticationCertificates".equals(fieldName)) {
                    List<SubResource> authenticationCertificates
                        = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.authenticationCertificates
                        = authenticationCertificates;
                } else if ("trustedRootCertificates".equals(fieldName)) {
                    List<SubResource> trustedRootCertificates
                        = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.trustedRootCertificates
                        = trustedRootCertificates;
                } else if ("connectionDraining".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.connectionDraining
                        = ApplicationGatewayConnectionDraining.fromJson(reader);
                } else if ("hostName".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.hostname = reader.getString();
                } else if ("pickHostNameFromBackendAddress".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.pickHostnameFromBackendAddress
                        = reader.getNullable(JsonReader::getBoolean);
                } else if ("affinityCookieName".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.affinityCookieName
                        = reader.getString();
                } else if ("probeEnabled".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.probeEnabled
                        = reader.getNullable(JsonReader::getBoolean);
                } else if ("path".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.path = reader.getString();
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedApplicationGatewayBackendHttpSettingsPropertiesFormat;
        });
    }
}
