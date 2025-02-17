// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcemover.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.resourcemover.models.LoadBalancerBackendAddressPoolReference;
import com.azure.resourcemanager.resourcemover.models.LoadBalancerNatRuleReference;
import com.azure.resourcemanager.resourcemover.models.NicIpConfigurationResourceSettings;
import com.azure.resourcemanager.resourcemover.models.PublicIpReference;
import com.azure.resourcemanager.resourcemover.models.SubnetReference;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class NicIpConfigurationResourceSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NicIpConfigurationResourceSettings model = BinaryData.fromString(
            "{\"name\":\"svlxotogtwrup\",\"privateIpAddress\":\"xvnmicykvceov\",\"privateIpAllocationMethod\":\"lo\",\"subnet\":{\"name\":\"tyfjfcnjbkcnxdhb\",\"sourceArmResourceId\":\"tkphywpnvjtoqn\"},\"primary\":true,\"loadBalancerBackendAddressPools\":[{\"name\":\"plpho\",\"sourceArmResourceId\":\"uscrpabgyepsb\"},{\"name\":\"azqugxywpmueefj\",\"sourceArmResourceId\":\"wfqkquj\"}],\"loadBalancerNatRules\":[{\"name\":\"yonobgl\",\"sourceArmResourceId\":\"ocqxtccmg\"},{\"name\":\"dxyt\",\"sourceArmResourceId\":\"moyrxvwfudwpz\"},{\"name\":\"xhdzhlrqjbhckf\",\"sourceArmResourceId\":\"lhrxsbkyvpyc\"},{\"name\":\"uzbpzkafku\",\"sourceArmResourceId\":\"b\"}],\"publicIp\":{\"sourceArmResourceId\":\"nwbmeh\"}}")
            .toObject(NicIpConfigurationResourceSettings.class);
        Assertions.assertEquals("svlxotogtwrup", model.name());
        Assertions.assertEquals("xvnmicykvceov", model.privateIpAddress());
        Assertions.assertEquals("lo", model.privateIpAllocationMethod());
        Assertions.assertEquals("tkphywpnvjtoqn", model.subnet().sourceArmResourceId());
        Assertions.assertEquals("tyfjfcnjbkcnxdhb", model.subnet().name());
        Assertions.assertEquals(true, model.primary());
        Assertions.assertEquals("uscrpabgyepsb", model.loadBalancerBackendAddressPools().get(0).sourceArmResourceId());
        Assertions.assertEquals("plpho", model.loadBalancerBackendAddressPools().get(0).name());
        Assertions.assertEquals("ocqxtccmg", model.loadBalancerNatRules().get(0).sourceArmResourceId());
        Assertions.assertEquals("yonobgl", model.loadBalancerNatRules().get(0).name());
        Assertions.assertEquals("nwbmeh", model.publicIp().sourceArmResourceId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NicIpConfigurationResourceSettings model = new NicIpConfigurationResourceSettings().withName("svlxotogtwrup")
            .withPrivateIpAddress("xvnmicykvceov")
            .withPrivateIpAllocationMethod("lo")
            .withSubnet(new SubnetReference().withSourceArmResourceId("tkphywpnvjtoqn").withName("tyfjfcnjbkcnxdhb"))
            .withPrimary(true)
            .withLoadBalancerBackendAddressPools(Arrays.asList(
                new LoadBalancerBackendAddressPoolReference().withSourceArmResourceId("uscrpabgyepsb")
                    .withName("plpho"),
                new LoadBalancerBackendAddressPoolReference().withSourceArmResourceId("wfqkquj")
                    .withName("azqugxywpmueefj")))
            .withLoadBalancerNatRules(Arrays.asList(
                new LoadBalancerNatRuleReference().withSourceArmResourceId("ocqxtccmg").withName("yonobgl"),
                new LoadBalancerNatRuleReference().withSourceArmResourceId("moyrxvwfudwpz").withName("dxyt"),
                new LoadBalancerNatRuleReference().withSourceArmResourceId("lhrxsbkyvpyc").withName("xhdzhlrqjbhckf"),
                new LoadBalancerNatRuleReference().withSourceArmResourceId("b").withName("uzbpzkafku")))
            .withPublicIp(new PublicIpReference().withSourceArmResourceId("nwbmeh"));
        model = BinaryData.fromObject(model).toObject(NicIpConfigurationResourceSettings.class);
        Assertions.assertEquals("svlxotogtwrup", model.name());
        Assertions.assertEquals("xvnmicykvceov", model.privateIpAddress());
        Assertions.assertEquals("lo", model.privateIpAllocationMethod());
        Assertions.assertEquals("tkphywpnvjtoqn", model.subnet().sourceArmResourceId());
        Assertions.assertEquals("tyfjfcnjbkcnxdhb", model.subnet().name());
        Assertions.assertEquals(true, model.primary());
        Assertions.assertEquals("uscrpabgyepsb", model.loadBalancerBackendAddressPools().get(0).sourceArmResourceId());
        Assertions.assertEquals("plpho", model.loadBalancerBackendAddressPools().get(0).name());
        Assertions.assertEquals("ocqxtccmg", model.loadBalancerNatRules().get(0).sourceArmResourceId());
        Assertions.assertEquals("yonobgl", model.loadBalancerNatRules().get(0).name());
        Assertions.assertEquals("nwbmeh", model.publicIp().sourceArmResourceId());
    }
}
