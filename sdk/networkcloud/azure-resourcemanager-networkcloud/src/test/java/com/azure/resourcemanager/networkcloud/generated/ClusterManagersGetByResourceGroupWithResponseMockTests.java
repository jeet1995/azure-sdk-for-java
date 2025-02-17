// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.networkcloud.NetworkCloudManager;
import com.azure.resourcemanager.networkcloud.models.ClusterManager;
import com.azure.resourcemanager.networkcloud.models.ManagedServiceIdentityType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ClusterManagersGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"identity\":{\"principalId\":\"453b87f5-f3fe-4e4e-8723-1c80d857bbe7\",\"tenantId\":\"2ea81332-bd17-44c5-95b5-afd76520ffd2\",\"type\":\"UserAssigned\",\"userAssignedIdentities\":{\"qnzmnhiil\":{\"principalId\":\"6133586e-eb63-4217-b204-04a52b432c07\",\"clientId\":\"f65aef5d-bd78-43f3-b682-bb8f78469262\"},\"w\":{\"principalId\":\"858b76c1-c8c5-4eb2-a0c8-dc169dba1383\",\"clientId\":\"d80e91b8-cc09-4844-9681-6a1a8f47e937\"},\"ckbbcc\":{\"principalId\":\"c630ecaa-d778-402c-a023-7d29f1394d0d\",\"clientId\":\"993e74e3-e74b-47b8-912e-ea8c1741f39c\"}}},\"properties\":{\"analyticsWorkspaceId\":\"zpraoxn\",\"availabilityZones\":[\"fa\",\"sgftipwc\",\"byubhiqdxyurnpn\"],\"clusterVersions\":[{\"supportExpiryDate\":\"fccnuhiigb\",\"targetClusterVersion\":\"bui\"},{\"supportExpiryDate\":\"xvatvcr\",\"targetClusterVersion\":\"lbnb\"},{\"supportExpiryDate\":\"vhcs\",\"targetClusterVersion\":\"zlwxaeaovur\"}],\"detailedStatus\":\"ProvisioningFailed\",\"detailedStatusMessage\":\"d\",\"fabricControllerId\":\"bdweade\",\"managedResourceGroupConfiguration\":{\"location\":\"wntopag\",\"name\":\"mvmmagoaqylkjz\"},\"managerExtendedLocation\":{\"name\":\"iua\",\"type\":\"jcg\"},\"provisioningState\":\"Updating\",\"vmSize\":\"pfinzcpdltkrlg\"},\"location\":\"tbdrvcqgue\",\"tags\":{\"lyujlfyoump\":\"ompheqdur\",\"brzmqxucycijoclx\":\"kyeclcdigpta\",\"zjd\":\"utgjcyz\",\"jb\":\"r\"},\"id\":\"xjeaoqaqbzgyh\",\"name\":\"w\",\"type\":\"v\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetworkCloudManager manager = NetworkCloudManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        ClusterManager response = manager.clusterManagers()
            .getByResourceGroupWithResponse("iuxegth", "rtudawlpjfel", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("tbdrvcqgue", response.location());
        Assertions.assertEquals("ompheqdur", response.tags().get("lyujlfyoump"));
        Assertions.assertEquals(ManagedServiceIdentityType.USER_ASSIGNED, response.identity().type());
        Assertions.assertEquals("zpraoxn", response.analyticsWorkspaceId());
        Assertions.assertEquals("fa", response.availabilityZones().get(0));
        Assertions.assertEquals("bdweade", response.fabricControllerId());
        Assertions.assertEquals("wntopag", response.managedResourceGroupConfiguration().location());
        Assertions.assertEquals("mvmmagoaqylkjz", response.managedResourceGroupConfiguration().name());
        Assertions.assertEquals("pfinzcpdltkrlg", response.vmSize());
    }
}
