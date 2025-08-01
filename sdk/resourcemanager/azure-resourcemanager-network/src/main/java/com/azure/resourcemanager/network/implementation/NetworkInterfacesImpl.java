// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.network.implementation;

import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.network.NetworkManager;
import com.azure.resourcemanager.network.fluent.NetworkInterfacesClient;
import com.azure.resourcemanager.network.fluent.models.NetworkInterfaceInner;
import com.azure.resourcemanager.network.fluent.models.NetworkInterfaceIpConfigurationInner;
import com.azure.resourcemanager.network.models.NetworkInterface;
import com.azure.resourcemanager.network.models.NetworkInterfaceDnsSettings;
import com.azure.resourcemanager.network.models.NetworkInterfaces;
import com.azure.resourcemanager.network.models.VirtualMachineScaleSetNetworkInterface;
import com.azure.resourcemanager.resources.fluentcore.arm.ResourceUtils;
import com.azure.resourcemanager.resources.fluentcore.arm.collection.implementation.TopLevelModifiableResourcesImpl;
import com.azure.resourcemanager.resources.fluentcore.model.Accepted;
import com.azure.resourcemanager.resources.fluentcore.model.implementation.AcceptedImpl;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.function.Function;

/** Implementation for {@link NetworkInterfaces}. */
public class NetworkInterfacesImpl extends
    TopLevelModifiableResourcesImpl<NetworkInterface, NetworkInterfaceImpl, NetworkInterfaceInner, NetworkInterfacesClient, NetworkManager>
    implements NetworkInterfaces {

    private final ClientLogger logger = new ClientLogger(this.getClass());

    public NetworkInterfacesImpl(final NetworkManager networkManager) {
        super(networkManager.serviceClient().getNetworkInterfaces(), networkManager);
    }

    @Override
    public VirtualMachineScaleSetNetworkInterface getByVirtualMachineScaleSetInstanceId(String resourceGroupName,
        String scaleSetName, String instanceId, String name) {
        VirtualMachineScaleSetNetworkInterfacesImpl scaleSetNetworkInterfaces
            = new VirtualMachineScaleSetNetworkInterfacesImpl(resourceGroupName, scaleSetName, this.manager());
        return scaleSetNetworkInterfaces.getByVirtualMachineInstanceId(instanceId, name);
    }

    @Override
    public Mono<VirtualMachineScaleSetNetworkInterface> getByVirtualMachineScaleSetInstanceIdAsync(
        String resourceGroupName, String scaleSetName, String instanceId, String name) {
        VirtualMachineScaleSetNetworkInterfacesImpl scaleSetNetworkInterfaces
            = new VirtualMachineScaleSetNetworkInterfacesImpl(resourceGroupName, scaleSetName, this.manager());
        return scaleSetNetworkInterfaces.getByVirtualMachineInstanceIdAsync(instanceId, name);
    }

    @Override
    public PagedIterable<VirtualMachineScaleSetNetworkInterface> listByVirtualMachineScaleSet(String resourceGroupName,
        String scaleSetName) {
        VirtualMachineScaleSetNetworkInterfacesImpl scaleSetNetworkInterfaces
            = new VirtualMachineScaleSetNetworkInterfacesImpl(resourceGroupName, scaleSetName, this.manager());
        return scaleSetNetworkInterfaces.list();
    }

    @Override
    public PagedIterable<VirtualMachineScaleSetNetworkInterface> listByVirtualMachineScaleSetId(String id) {
        return this.listByVirtualMachineScaleSet(ResourceUtils.groupFromResourceId(id),
            ResourceUtils.nameFromResourceId(id));
    }

    @Override
    public PagedIterable<VirtualMachineScaleSetNetworkInterface>
        listByVirtualMachineScaleSetInstanceId(String resourceGroupName, String scaleSetName, String instanceId) {
        VirtualMachineScaleSetNetworkInterfacesImpl scaleSetNetworkInterfaces
            = new VirtualMachineScaleSetNetworkInterfacesImpl(resourceGroupName, scaleSetName, this.manager());
        return scaleSetNetworkInterfaces.listByVirtualMachineInstanceId(instanceId);
    }

    @Override
    public PagedFlux<VirtualMachineScaleSetNetworkInterface>
        listByVirtualMachineScaleSetInstanceIdAsync(String resourceGroupName, String scaleSetName, String instanceId) {
        VirtualMachineScaleSetNetworkInterfacesImpl scaleSetNetworkInterfaces
            = new VirtualMachineScaleSetNetworkInterfacesImpl(resourceGroupName, scaleSetName, this.manager());
        return scaleSetNetworkInterfaces.listByVirtualMachineInstanceIdAsync(instanceId);
    }

    @Override
    public NetworkInterfaceImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    protected NetworkInterfaceImpl wrapModel(String name) {
        NetworkInterfaceInner inner = new NetworkInterfaceInner();
        inner.withIpConfigurations(new ArrayList<NetworkInterfaceIpConfigurationInner>());
        inner.withDnsSettings(new NetworkInterfaceDnsSettings());
        return new NetworkInterfaceImpl(name, inner, super.manager());
    }

    @Override
    protected NetworkInterfaceImpl wrapModel(NetworkInterfaceInner inner) {
        if (inner == null) {
            return null;
        }
        return new NetworkInterfaceImpl(inner.name(), inner, this.manager());
    }

    @Override
    public Accepted<Void> beginDeleteById(String id) {
        return beginDeleteById(id, Context.NONE);
    }

    @Override
    public Accepted<Void> beginDeleteById(String id, Context context) {
        return beginDeleteByResourceGroup(ResourceUtils.groupFromResourceId(id), ResourceUtils.nameFromResourceId(id),
            context);
    }

    @Override
    public Accepted<Void> beginDeleteByResourceGroup(String resourceGroupName, String name) {
        return beginDeleteByResourceGroup(resourceGroupName, name, Context.NONE);
    }

    @Override
    public Accepted<Void> beginDeleteByResourceGroup(String resourceGroupName, String name, Context context) {
        return AcceptedImpl.newAccepted(logger, this.manager().serviceClient().getHttpPipeline(),
            this.manager().serviceClient().getDefaultPollInterval(),
            () -> this.inner()
                .deleteWithResponseAsync(resourceGroupName, name)
                .contextWrite(c -> c.putAll(FluxUtil.toReactorContext(context).readOnly()))
                .block(),
            Function.identity(), Void.class, null, context);
    }

    @Override
    public PagedIterable<NetworkInterface> listByResourceGroup(String resourceGroupName, Context context) {
        return this.inner()
            .listByResourceGroup(resourceGroupName, context)
            .mapPage(networkInterfaceInner -> new NetworkInterfaceImpl(networkInterfaceInner.name(),
                networkInterfaceInner, NetworkInterfacesImpl.this.manager()));
    }
}
