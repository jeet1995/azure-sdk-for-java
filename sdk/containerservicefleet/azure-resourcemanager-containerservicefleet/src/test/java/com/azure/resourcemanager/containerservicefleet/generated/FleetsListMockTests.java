// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager;
import com.azure.resourcemanager.containerservicefleet.models.Fleet;
import com.azure.resourcemanager.containerservicefleet.models.ManagedServiceIdentityType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class FleetsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Canceled\",\"hubProfile\":{\"dnsPrefix\":\"cxerf\",\"apiServerAccessProfile\":{\"enablePrivateCluster\":true,\"enableVnetIntegration\":true,\"subnetId\":\"fvjrbirphxepcy\"},\"agentProfile\":{\"subnetId\":\"fnljky\",\"vmSize\":\"j\"},\"fqdn\":\"ujqgidok\",\"kubernetesVersion\":\"ljyoxgvcltb\",\"portalFqdn\":\"ncghkje\"}},\"eTag\":\"zhbijhtxfv\",\"identity\":{\"principalId\":\"cae6bae7-50d1-48b1-8592-ee23d4b8b31f\",\"tenantId\":\"c944707c-41d9-4ebd-abb8-3160ee711cee\",\"type\":\"None\",\"userAssignedIdentities\":{\"hmpvecx\":{\"principalId\":\"c33c162a-79f0-47c0-aeaa-d2b41358ae3d\",\"clientId\":\"1534acd6-d57b-4c58-92f9-7af4a2a3a8d4\"},\"ebfqkkrbm\":{\"principalId\":\"e4085f7c-65aa-4e56-a157-821655ac6da9\",\"clientId\":\"2d5a268e-942d-46a1-8758-c3f06fe4c7a8\"},\"gr\":{\"principalId\":\"7e49b65d-097d-42d9-aac6-9b069a5a8247\",\"clientId\":\"c6848af8-7a32-449b-bed0-8f8500318659\"}}},\"location\":\"flz\",\"tags\":{\"qzahmgkbrp\":\"xzpuzycisp\",\"hibnuqqkpika\":\"y\",\"buynhijggm\":\"rgvtqag\"},\"id\":\"bfs\",\"name\":\"arbu\",\"type\":\"rcvpnazzmhjrunmp\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerServiceFleetManager manager = ContainerServiceFleetManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Fleet> response = manager.fleets().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("flz", response.iterator().next().location());
        Assertions.assertEquals("xzpuzycisp", response.iterator().next().tags().get("qzahmgkbrp"));
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, response.iterator().next().identity().type());
        Assertions.assertEquals("cxerf", response.iterator().next().hubProfile().dnsPrefix());
        Assertions.assertEquals(true,
            response.iterator().next().hubProfile().apiServerAccessProfile().enablePrivateCluster());
        Assertions.assertEquals(true,
            response.iterator().next().hubProfile().apiServerAccessProfile().enableVnetIntegration());
        Assertions.assertEquals("fvjrbirphxepcy",
            response.iterator().next().hubProfile().apiServerAccessProfile().subnetId());
        Assertions.assertEquals("fnljky", response.iterator().next().hubProfile().agentProfile().subnetId());
        Assertions.assertEquals("j", response.iterator().next().hubProfile().agentProfile().vmSize());
    }
}
