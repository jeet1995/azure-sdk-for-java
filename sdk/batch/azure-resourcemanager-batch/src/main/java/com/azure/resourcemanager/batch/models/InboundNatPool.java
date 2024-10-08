// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * A inbound NAT pool that can be used to address specific ports on compute nodes in a Batch pool externally.
 */
@Fluent
public final class InboundNatPool implements JsonSerializable<InboundNatPool> {
    /*
     * The name must be unique within a Batch pool, can contain letters, numbers, underscores, periods, and hyphens.
     * Names must start with a letter or number, must end with a letter, number, or underscore, and cannot exceed 77
     * characters. If any invalid values are provided the request fails with HTTP status code 400.
     */
    private String name;

    /*
     * The protocol of the endpoint.
     */
    private InboundEndpointProtocol protocol;

    /*
     * This must be unique within a Batch pool. Acceptable values are between 1 and 65535 except for 22, 3389, 29876 and
     * 29877 as these are reserved. If any reserved values are provided the request fails with HTTP status code 400.
     */
    private int backendPort;

    /*
     * Acceptable values range between 1 and 65534 except ports from 50000 to 55000 which are reserved. All ranges
     * within a pool must be distinct and cannot overlap. If any reserved or overlapping values are provided the request
     * fails with HTTP status code 400.
     */
    private int frontendPortRangeStart;

    /*
     * Acceptable values range between 1 and 65534 except ports from 50000 to 55000 which are reserved by the Batch
     * service. All ranges within a pool must be distinct and cannot overlap. If any reserved or overlapping values are
     * provided the request fails with HTTP status code 400.
     */
    private int frontendPortRangeEnd;

    /*
     * The maximum number of rules that can be specified across all the endpoints on a Batch pool is 25. If no network
     * security group rules are specified, a default rule will be created to allow inbound access to the specified
     * backendPort. If the maximum number of network security group rules is exceeded the request fails with HTTP status
     * code 400.
     */
    private List<NetworkSecurityGroupRule> networkSecurityGroupRules;

    /**
     * Creates an instance of InboundNatPool class.
     */
    public InboundNatPool() {
    }

    /**
     * Get the name property: The name must be unique within a Batch pool, can contain letters, numbers, underscores,
     * periods, and hyphens. Names must start with a letter or number, must end with a letter, number, or underscore,
     * and cannot exceed 77 characters. If any invalid values are provided the request fails with HTTP status code 400.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name must be unique within a Batch pool, can contain letters, numbers, underscores,
     * periods, and hyphens. Names must start with a letter or number, must end with a letter, number, or underscore,
     * and cannot exceed 77 characters. If any invalid values are provided the request fails with HTTP status code 400.
     * 
     * @param name the name value to set.
     * @return the InboundNatPool object itself.
     */
    public InboundNatPool withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the protocol property: The protocol of the endpoint.
     * 
     * @return the protocol value.
     */
    public InboundEndpointProtocol protocol() {
        return this.protocol;
    }

    /**
     * Set the protocol property: The protocol of the endpoint.
     * 
     * @param protocol the protocol value to set.
     * @return the InboundNatPool object itself.
     */
    public InboundNatPool withProtocol(InboundEndpointProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get the backendPort property: This must be unique within a Batch pool. Acceptable values are between 1 and 65535
     * except for 22, 3389, 29876 and 29877 as these are reserved. If any reserved values are provided the request fails
     * with HTTP status code 400.
     * 
     * @return the backendPort value.
     */
    public int backendPort() {
        return this.backendPort;
    }

    /**
     * Set the backendPort property: This must be unique within a Batch pool. Acceptable values are between 1 and 65535
     * except for 22, 3389, 29876 and 29877 as these are reserved. If any reserved values are provided the request fails
     * with HTTP status code 400.
     * 
     * @param backendPort the backendPort value to set.
     * @return the InboundNatPool object itself.
     */
    public InboundNatPool withBackendPort(int backendPort) {
        this.backendPort = backendPort;
        return this;
    }

    /**
     * Get the frontendPortRangeStart property: Acceptable values range between 1 and 65534 except ports from 50000 to
     * 55000 which are reserved. All ranges within a pool must be distinct and cannot overlap. If any reserved or
     * overlapping values are provided the request fails with HTTP status code 400.
     * 
     * @return the frontendPortRangeStart value.
     */
    public int frontendPortRangeStart() {
        return this.frontendPortRangeStart;
    }

    /**
     * Set the frontendPortRangeStart property: Acceptable values range between 1 and 65534 except ports from 50000 to
     * 55000 which are reserved. All ranges within a pool must be distinct and cannot overlap. If any reserved or
     * overlapping values are provided the request fails with HTTP status code 400.
     * 
     * @param frontendPortRangeStart the frontendPortRangeStart value to set.
     * @return the InboundNatPool object itself.
     */
    public InboundNatPool withFrontendPortRangeStart(int frontendPortRangeStart) {
        this.frontendPortRangeStart = frontendPortRangeStart;
        return this;
    }

    /**
     * Get the frontendPortRangeEnd property: Acceptable values range between 1 and 65534 except ports from 50000 to
     * 55000 which are reserved by the Batch service. All ranges within a pool must be distinct and cannot overlap. If
     * any reserved or overlapping values are provided the request fails with HTTP status code 400.
     * 
     * @return the frontendPortRangeEnd value.
     */
    public int frontendPortRangeEnd() {
        return this.frontendPortRangeEnd;
    }

    /**
     * Set the frontendPortRangeEnd property: Acceptable values range between 1 and 65534 except ports from 50000 to
     * 55000 which are reserved by the Batch service. All ranges within a pool must be distinct and cannot overlap. If
     * any reserved or overlapping values are provided the request fails with HTTP status code 400.
     * 
     * @param frontendPortRangeEnd the frontendPortRangeEnd value to set.
     * @return the InboundNatPool object itself.
     */
    public InboundNatPool withFrontendPortRangeEnd(int frontendPortRangeEnd) {
        this.frontendPortRangeEnd = frontendPortRangeEnd;
        return this;
    }

    /**
     * Get the networkSecurityGroupRules property: The maximum number of rules that can be specified across all the
     * endpoints on a Batch pool is 25. If no network security group rules are specified, a default rule will be created
     * to allow inbound access to the specified backendPort. If the maximum number of network security group rules is
     * exceeded the request fails with HTTP status code 400.
     * 
     * @return the networkSecurityGroupRules value.
     */
    public List<NetworkSecurityGroupRule> networkSecurityGroupRules() {
        return this.networkSecurityGroupRules;
    }

    /**
     * Set the networkSecurityGroupRules property: The maximum number of rules that can be specified across all the
     * endpoints on a Batch pool is 25. If no network security group rules are specified, a default rule will be created
     * to allow inbound access to the specified backendPort. If the maximum number of network security group rules is
     * exceeded the request fails with HTTP status code 400.
     * 
     * @param networkSecurityGroupRules the networkSecurityGroupRules value to set.
     * @return the InboundNatPool object itself.
     */
    public InboundNatPool withNetworkSecurityGroupRules(List<NetworkSecurityGroupRule> networkSecurityGroupRules) {
        this.networkSecurityGroupRules = networkSecurityGroupRules;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model InboundNatPool"));
        }
        if (protocol() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property protocol in model InboundNatPool"));
        }
        if (networkSecurityGroupRules() != null) {
            networkSecurityGroupRules().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(InboundNatPool.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("protocol", this.protocol == null ? null : this.protocol.toString());
        jsonWriter.writeIntField("backendPort", this.backendPort);
        jsonWriter.writeIntField("frontendPortRangeStart", this.frontendPortRangeStart);
        jsonWriter.writeIntField("frontendPortRangeEnd", this.frontendPortRangeEnd);
        jsonWriter.writeArrayField("networkSecurityGroupRules", this.networkSecurityGroupRules,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of InboundNatPool from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of InboundNatPool if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the InboundNatPool.
     */
    public static InboundNatPool fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            InboundNatPool deserializedInboundNatPool = new InboundNatPool();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedInboundNatPool.name = reader.getString();
                } else if ("protocol".equals(fieldName)) {
                    deserializedInboundNatPool.protocol = InboundEndpointProtocol.fromString(reader.getString());
                } else if ("backendPort".equals(fieldName)) {
                    deserializedInboundNatPool.backendPort = reader.getInt();
                } else if ("frontendPortRangeStart".equals(fieldName)) {
                    deserializedInboundNatPool.frontendPortRangeStart = reader.getInt();
                } else if ("frontendPortRangeEnd".equals(fieldName)) {
                    deserializedInboundNatPool.frontendPortRangeEnd = reader.getInt();
                } else if ("networkSecurityGroupRules".equals(fieldName)) {
                    List<NetworkSecurityGroupRule> networkSecurityGroupRules
                        = reader.readArray(reader1 -> NetworkSecurityGroupRule.fromJson(reader1));
                    deserializedInboundNatPool.networkSecurityGroupRules = networkSecurityGroupRules;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedInboundNatPool;
        });
    }
}
