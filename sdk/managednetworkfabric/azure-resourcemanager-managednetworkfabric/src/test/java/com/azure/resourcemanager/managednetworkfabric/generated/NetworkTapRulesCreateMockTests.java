// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.managednetworkfabric.ManagedNetworkFabricManager;
import com.azure.resourcemanager.managednetworkfabric.models.CommonDynamicMatchConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationType;
import com.azure.resourcemanager.managednetworkfabric.models.IpAddressType;
import com.azure.resourcemanager.managednetworkfabric.models.IpGroupProperties;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRule;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRuleAction;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRuleMatchCondition;
import com.azure.resourcemanager.managednetworkfabric.models.NetworkTapRuleMatchConfiguration;
import com.azure.resourcemanager.managednetworkfabric.models.PollingIntervalInSeconds;
import com.azure.resourcemanager.managednetworkfabric.models.PortGroupProperties;
import com.azure.resourcemanager.managednetworkfabric.models.VlanGroupProperties;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class NetworkTapRulesCreateMockTests {
    @Test
    public void testCreate() throws Exception {
        String responseStr
            = "{\"properties\":{\"networkTapId\":\"pyzxcp\",\"pollingIntervalInSeconds\":60,\"lastSyncedTime\":\"2021-03-28T19:43:37Z\",\"configurationState\":\"PendingCommit\",\"provisioningState\":\"Succeeded\",\"administrativeState\":\"MAT\",\"configurationType\":\"Inline\",\"tapRulesUrl\":\"yvaxwzbwxx\",\"matchConfigurations\":[{\"matchConfigurationName\":\"xsrrhr\",\"sequenceNumber\":431353177903491287,\"ipAddressType\":\"IPv4\",\"matchConditions\":[{},{},{},{}],\"actions\":[{},{},{},{}]},{\"matchConfigurationName\":\"zuimpiybmybtihcg\",\"sequenceNumber\":8092509622305080555,\"ipAddressType\":\"IPv4\",\"matchConditions\":[{},{}],\"actions\":[{}]}],\"dynamicMatchConfigurations\":[{\"ipGroups\":[{}],\"vlanGroups\":[{},{},{},{}],\"portGroups\":[{}]},{\"ipGroups\":[{}],\"vlanGroups\":[{},{}],\"portGroups\":[{},{},{},{}]},{\"ipGroups\":[{},{},{},{}],\"vlanGroups\":[{},{},{},{}],\"portGroups\":[{},{}]}],\"annotation\":\"hxqnlmjvpm\"},\"location\":\"fibwvhwouhysr\",\"tags\":{\"yxpdzvgyujkxjge\":\"zjsnxzljxa\"},\"id\":\"zdbigitra\",\"name\":\"udyrsir\",\"type\":\"bpi\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ManagedNetworkFabricManager manager = ManagedNetworkFabricManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        NetworkTapRule response = manager.networkTapRules()
            .define("mkuquvcgvn")
            .withRegion("edijdhzkwvuewe")
            .withExistingResourceGroup("hoqpbfjfcbweabpt")
            .withTags(mapOf("lxdknxctglz", "jels", "fsgwi", "cx", "wjudx", "yiw", "zcffchn", "fvn"))
            .withPollingIntervalInSeconds(PollingIntervalInSeconds.SIX_ZERO)
            .withConfigurationType(ConfigurationType.INLINE)
            .withTapRulesUrl("s")
            .withMatchConfigurations(Arrays.asList(
                new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("wfrgdmbgbht")
                    .withSequenceNumber(6435381219829762785L)
                    .withIpAddressType(IpAddressType.IPV6)
                    .withMatchConditions(Arrays.asList(new NetworkTapRuleMatchCondition(),
                        new NetworkTapRuleMatchCondition(), new NetworkTapRuleMatchCondition()))
                    .withActions(Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction(),
                        new NetworkTapRuleAction())),
                new NetworkTapRuleMatchConfiguration().withMatchConfigurationName("abhlgrrskvtz")
                    .withSequenceNumber(2401975033262174312L)
                    .withIpAddressType(IpAddressType.IPV4)
                    .withMatchConditions(
                        Arrays.asList(new NetworkTapRuleMatchCondition(), new NetworkTapRuleMatchCondition()))
                    .withActions(Arrays.asList(new NetworkTapRuleAction(), new NetworkTapRuleAction(),
                        new NetworkTapRuleAction()))))
            .withDynamicMatchConfigurations(
                Arrays
                    .asList(
                        new CommonDynamicMatchConfiguration()
                            .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties(),
                                new IpGroupProperties()))
                            .withVlanGroups(Arrays.asList(new VlanGroupProperties()))
                            .withPortGroups(Arrays.asList(new PortGroupProperties())),
                        new CommonDynamicMatchConfiguration().withIpGroups(Arrays.asList(new IpGroupProperties()))
                            .withVlanGroups(Arrays.asList(new VlanGroupProperties()))
                            .withPortGroups(Arrays.asList(new PortGroupProperties(), new PortGroupProperties())),
                        new CommonDynamicMatchConfiguration()
                            .withIpGroups(Arrays.asList(new IpGroupProperties(), new IpGroupProperties()))
                            .withVlanGroups(Arrays.asList(new VlanGroupProperties(), new VlanGroupProperties(),
                                new VlanGroupProperties()))
                            .withPortGroups(Arrays.asList(new PortGroupProperties(), new PortGroupProperties()))))
            .withAnnotation("thqnztuki")
            .create();

        Assertions.assertEquals("fibwvhwouhysr", response.location());
        Assertions.assertEquals("zjsnxzljxa", response.tags().get("yxpdzvgyujkxjge"));
        Assertions.assertEquals(PollingIntervalInSeconds.SIX_ZERO, response.pollingIntervalInSeconds());
        Assertions.assertEquals(ConfigurationType.INLINE, response.configurationType());
        Assertions.assertEquals("yvaxwzbwxx", response.tapRulesUrl());
        Assertions.assertEquals("xsrrhr", response.matchConfigurations().get(0).matchConfigurationName());
        Assertions.assertEquals(431353177903491287L, response.matchConfigurations().get(0).sequenceNumber());
        Assertions.assertEquals(IpAddressType.IPV4, response.matchConfigurations().get(0).ipAddressType());
        Assertions.assertEquals("hxqnlmjvpm", response.annotation());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
