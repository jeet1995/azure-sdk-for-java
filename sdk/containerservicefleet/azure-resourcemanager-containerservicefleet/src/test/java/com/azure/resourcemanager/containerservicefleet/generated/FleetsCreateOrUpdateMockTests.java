// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager;
import com.azure.resourcemanager.containerservicefleet.models.AgentProfile;
import com.azure.resourcemanager.containerservicefleet.models.ApiServerAccessProfile;
import com.azure.resourcemanager.containerservicefleet.models.Fleet;
import com.azure.resourcemanager.containerservicefleet.models.FleetHubProfile;
import com.azure.resourcemanager.containerservicefleet.models.ManagedServiceIdentity;
import com.azure.resourcemanager.containerservicefleet.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.containerservicefleet.models.UserAssignedIdentity;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class FleetsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Succeeded\",\"hubProfile\":{\"dnsPrefix\":\"ao\",\"apiServerAccessProfile\":{\"enablePrivateCluster\":false},\"agentProfile\":{\"subnetId\":\"qxolzdahzx\",\"vmSize\":\"obgbkdmoizp\"},\"fqdn\":\"tmgrcfbun\",\"kubernetesVersion\":\"fqjhhkxbpvjymj\",\"portalFqdn\":\"xjyngudivk\"}},\"eTag\":\"swbxqz\",\"identity\":{\"principalId\":\"41a20a01-732d-4f37-841c-39db9ff058ab\",\"tenantId\":\"3e0ee808-71d2-45ec-8369-92d14c51ce8f\",\"type\":\"UserAssigned\",\"userAssignedIdentities\":{\"fdxxivetvtcqaqtd\":{\"principalId\":\"c7d6a9c7-48b0-4f13-b971-25cb6d972878\",\"clientId\":\"f47d9ea3-1a88-4b8a-97ed-66ee21afbfd5\"},\"cbxvwvxyslqbh\":{\"principalId\":\"549fa4b8-4d59-4e96-92af-c7d085aee006\",\"clientId\":\"6a6cd03b-0578-40ed-96f1-52b79a6db8f4\"},\"obl\":{\"principalId\":\"3b38db3d-1856-4f0d-848d-226c8e32e45f\",\"clientId\":\"58edabf8-854e-4262-8397-49c6bd0bc7f8\"}}},\"location\":\"k\",\"tags\":{\"wwfbkrvrnsvshq\":\"pe\"},\"id\":\"ohxcrsbfova\",\"name\":\"rruvwbhsq\",\"type\":\"sub\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerServiceFleetManager manager = ContainerServiceFleetManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        Fleet response = manager.fleets()
            .define("qzcjrvxdj")
            .withRegion("jixisxyawjoyaqcs")
            .withExistingResourceGroup("pjyzhpv")
            .withTags(mapOf("zyexzn", "pkii", "bnxknalaulppg", "lixhnrztfol", "gvpgy", "dtpnapnyiropuhp", "n",
                "gqgitxmedjvcsl"))
            .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.USER_ASSIGNED)
                .withUserAssignedIdentities(
                    mapOf("ekqvkeln", new UserAssignedIdentity(), "bxwyjsflhhcaa", new UserAssignedIdentity())))
            .withHubProfile(new FleetHubProfile().withDnsPrefix("kvugfhzovawjvzun")
                .withApiServerAccessProfile(new ApiServerAccessProfile().withEnablePrivateCluster(false))
                .withAgentProfile(new AgentProfile().withSubnetId("prnxipeil").withVmSize("zuaejxd")))
            .withIfMatch("oellwp")
            .withIfNoneMatch("fdygpfqbuaceopz")
            .create();

        Assertions.assertEquals("k", response.location());
        Assertions.assertEquals("pe", response.tags().get("wwfbkrvrnsvshq"));
        Assertions.assertEquals(ManagedServiceIdentityType.USER_ASSIGNED, response.identity().type());
        Assertions.assertEquals("ao", response.hubProfile().dnsPrefix());
        Assertions.assertEquals(false, response.hubProfile().apiServerAccessProfile().enablePrivateCluster());
        Assertions.assertEquals("qxolzdahzx", response.hubProfile().agentProfile().subnetId());
        Assertions.assertEquals("obgbkdmoizp", response.hubProfile().agentProfile().vmSize());
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
