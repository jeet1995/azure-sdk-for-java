// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of NetworkPacketBrokers.
 */
public interface NetworkPacketBrokers {
    /**
     * Gets a Network Packet Broker.
     * 
     * Retrieves details of this Network Packet Broker.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkPacketBrokerName Name of the Network Packet Broker.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the NetworkPacketBroker resource definition along with {@link Response}.
     */
    Response<NetworkPacketBroker> getByResourceGroupWithResponse(String resourceGroupName,
        String networkPacketBrokerName, Context context);

    /**
     * Gets a Network Packet Broker.
     * 
     * Retrieves details of this Network Packet Broker.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkPacketBrokerName Name of the Network Packet Broker.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the NetworkPacketBroker resource definition.
     */
    NetworkPacketBroker getByResourceGroup(String resourceGroupName, String networkPacketBrokerName);

    /**
     * Deletes a Network Packet Broker.
     * 
     * Deletes Network Packet Broker.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkPacketBrokerName Name of the Network Packet Broker.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByResourceGroup(String resourceGroupName, String networkPacketBrokerName);

    /**
     * Deletes a Network Packet Broker.
     * 
     * Deletes Network Packet Broker.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkPacketBrokerName Name of the Network Packet Broker.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String networkPacketBrokerName, Context context);

    /**
     * List all Network Packet Brokers under resource group.
     * 
     * Displays NetworkPacketBrokers list by resource group GET method.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of NetworkPacketBrokers as paginated response with {@link PagedIterable}.
     */
    PagedIterable<NetworkPacketBroker> listByResourceGroup(String resourceGroupName);

    /**
     * List all Network Packet Brokers under resource group.
     * 
     * Displays NetworkPacketBrokers list by resource group GET method.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of NetworkPacketBrokers as paginated response with {@link PagedIterable}.
     */
    PagedIterable<NetworkPacketBroker> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * List Network Packet Brokers by subscription.
     * 
     * Displays Network Packet Brokers list by subscription GET method.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of NetworkPacketBrokers as paginated response with {@link PagedIterable}.
     */
    PagedIterable<NetworkPacketBroker> list();

    /**
     * List Network Packet Brokers by subscription.
     * 
     * Displays Network Packet Brokers list by subscription GET method.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return list of NetworkPacketBrokers as paginated response with {@link PagedIterable}.
     */
    PagedIterable<NetworkPacketBroker> list(Context context);

    /**
     * Gets a Network Packet Broker.
     * 
     * Retrieves details of this Network Packet Broker.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the NetworkPacketBroker resource definition along with {@link Response}.
     */
    NetworkPacketBroker getById(String id);

    /**
     * Gets a Network Packet Broker.
     * 
     * Retrieves details of this Network Packet Broker.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the NetworkPacketBroker resource definition along with {@link Response}.
     */
    Response<NetworkPacketBroker> getByIdWithResponse(String id, Context context);

    /**
     * Deletes a Network Packet Broker.
     * 
     * Deletes Network Packet Broker.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Deletes a Network Packet Broker.
     * 
     * Deletes Network Packet Broker.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new NetworkPacketBroker resource.
     * 
     * @param name resource name.
     * @return the first stage of the new NetworkPacketBroker definition.
     */
    NetworkPacketBroker.DefinitionStages.Blank define(String name);
}
