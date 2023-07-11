// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.models.FabricBfdConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.OptionAProperties;
import com.azure.resourcemanager.managednetworkfabric.models.OptionBPropertiesAutoGenerated;
import com.azure.resourcemanager.managednetworkfabric.models.PeeringOption;
import com.azure.resourcemanager.managednetworkfabric.models.VpnConfigurationProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VpnConfigurationPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VpnConfigurationProperties model =
            BinaryData
                .fromString(
                    "{\"administrativeState\":\"Disabled\",\"networkToNetworkInterconnectId\":\"hwwn\",\"peeringOption\":\"OptionB\",\"optionBProperties\":{\"importRouteTargets\":[\"fz\"],\"exportRouteTargets\":[\"pchwa\",\"fb\"]},\"optionAProperties\":{\"mtu\":1497864768,\"vlanId\":1344438119,\"peerASN\":1338045494,\"bfdConfiguration\":{\"interval\":1716129101,\"multiplier\":982242464},\"primaryIpv4Prefix\":\"l\",\"primaryIpv6Prefix\":\"gncxykxhdj\",\"secondaryIpv4Prefix\":\"immbcx\",\"secondaryIpv6Prefix\":\"bcporxvxcjzhqizx\"}}")
                .toObject(VpnConfigurationProperties.class);
        Assertions.assertEquals(PeeringOption.OPTIONB, model.peeringOption());
        Assertions.assertEquals("fz", model.optionBProperties().importRouteTargets().get(0));
        Assertions.assertEquals("pchwa", model.optionBProperties().exportRouteTargets().get(0));
        Assertions.assertEquals("l", model.optionAProperties().primaryIpv4Prefix());
        Assertions.assertEquals("gncxykxhdj", model.optionAProperties().primaryIpv6Prefix());
        Assertions.assertEquals("immbcx", model.optionAProperties().secondaryIpv4Prefix());
        Assertions.assertEquals("bcporxvxcjzhqizx", model.optionAProperties().secondaryIpv6Prefix());
        Assertions.assertEquals(1497864768, model.optionAProperties().mtu());
        Assertions.assertEquals(1344438119, model.optionAProperties().vlanId());
        Assertions.assertEquals(1338045494, model.optionAProperties().peerAsn());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VpnConfigurationProperties model =
            new VpnConfigurationProperties()
                .withPeeringOption(PeeringOption.OPTIONB)
                .withOptionBProperties(
                    new OptionBPropertiesAutoGenerated()
                        .withImportRouteTargets(Arrays.asList("fz"))
                        .withExportRouteTargets(Arrays.asList("pchwa", "fb")))
                .withOptionAProperties(
                    new OptionAProperties()
                        .withPrimaryIpv4Prefix("l")
                        .withPrimaryIpv6Prefix("gncxykxhdj")
                        .withSecondaryIpv4Prefix("immbcx")
                        .withSecondaryIpv6Prefix("bcporxvxcjzhqizx")
                        .withMtu(1497864768)
                        .withVlanId(1344438119)
                        .withPeerAsn(1338045494)
                        .withBfdConfiguration(new FabricBfdConfiguration()));
        model = BinaryData.fromObject(model).toObject(VpnConfigurationProperties.class);
        Assertions.assertEquals(PeeringOption.OPTIONB, model.peeringOption());
        Assertions.assertEquals("fz", model.optionBProperties().importRouteTargets().get(0));
        Assertions.assertEquals("pchwa", model.optionBProperties().exportRouteTargets().get(0));
        Assertions.assertEquals("l", model.optionAProperties().primaryIpv4Prefix());
        Assertions.assertEquals("gncxykxhdj", model.optionAProperties().primaryIpv6Prefix());
        Assertions.assertEquals("immbcx", model.optionAProperties().secondaryIpv4Prefix());
        Assertions.assertEquals("bcporxvxcjzhqizx", model.optionAProperties().secondaryIpv6Prefix());
        Assertions.assertEquals(1497864768, model.optionAProperties().mtu());
        Assertions.assertEquals(1344438119, model.optionAProperties().vlanId());
        Assertions.assertEquals(1338045494, model.optionAProperties().peerAsn());
    }
}