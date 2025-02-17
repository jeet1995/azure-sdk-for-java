// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.models.OptionBLayer3Configuration;
import org.junit.jupiter.api.Assertions;

public final class OptionBLayer3ConfigurationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OptionBLayer3Configuration model = BinaryData.fromString(
            "{\"peerASN\":4947142165522560944,\"vlanId\":1587213878,\"fabricASN\":7583012268187491181,\"primaryIpv4Prefix\":\"obguqisqsqk\",\"primaryIpv6Prefix\":\"mioyjpn\",\"secondaryIpv4Prefix\":\"viqcpszp\",\"secondaryIpv6Prefix\":\"vqdvrdmvxyrxdhg\"}")
            .toObject(OptionBLayer3Configuration.class);
        Assertions.assertEquals("obguqisqsqk", model.primaryIpv4Prefix());
        Assertions.assertEquals("mioyjpn", model.primaryIpv6Prefix());
        Assertions.assertEquals("viqcpszp", model.secondaryIpv4Prefix());
        Assertions.assertEquals("vqdvrdmvxyrxdhg", model.secondaryIpv6Prefix());
        Assertions.assertEquals(4947142165522560944L, model.peerAsn());
        Assertions.assertEquals(1587213878, model.vlanId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OptionBLayer3Configuration model = new OptionBLayer3Configuration().withPrimaryIpv4Prefix("obguqisqsqk")
            .withPrimaryIpv6Prefix("mioyjpn")
            .withSecondaryIpv4Prefix("viqcpszp")
            .withSecondaryIpv6Prefix("vqdvrdmvxyrxdhg")
            .withPeerAsn(4947142165522560944L)
            .withVlanId(1587213878);
        model = BinaryData.fromObject(model).toObject(OptionBLayer3Configuration.class);
        Assertions.assertEquals("obguqisqsqk", model.primaryIpv4Prefix());
        Assertions.assertEquals("mioyjpn", model.primaryIpv6Prefix());
        Assertions.assertEquals("viqcpszp", model.secondaryIpv4Prefix());
        Assertions.assertEquals("vqdvrdmvxyrxdhg", model.secondaryIpv6Prefix());
        Assertions.assertEquals(4947142165522560944L, model.peerAsn());
        Assertions.assertEquals(1587213878, model.vlanId());
    }
}
