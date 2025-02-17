// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.hybridnetwork.HybridNetworkManager;
import com.azure.resourcemanager.hybridnetwork.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.hybridnetwork.models.Publisher;
import com.azure.resourcemanager.hybridnetwork.models.PublisherScope;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PublishersGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Failed\",\"scope\":\"Private\"},\"identity\":{\"principalId\":\"0727d9c0-7265-4702-8fd6-4eee0e7c89b9\",\"tenantId\":\"c9ca0b2d-4621-4cef-a9bc-68fa32b3b81c\",\"type\":\"UserAssigned\",\"userAssignedIdentities\":{\"cwkdtaaw\":{\"principalId\":\"f3d41499-8ad0-4a9d-a860-51198e301f09\",\"clientId\":\"38bfc3e6-fde1-4087-86d2-d355659b88ee\"},\"ekaum\":{\"principalId\":\"70738224-a5ae-4e3d-b5a8-73916b4136a4\",\"clientId\":\"bf987db2-91a4-4ae1-af47-624c0cdd0130\"},\"mbzmqk\":{\"principalId\":\"8c50dcc1-a0f8-4ccf-8a44-5ddc42df6747\",\"clientId\":\"c2649685-62d9-4903-9ec3-9479f200fe22\"},\"bnxwbjsidbirkf\":{\"principalId\":\"b15b50f2-756a-4125-ad19-69db541e75c9\",\"clientId\":\"df77a768-16ae-4eca-870b-922438f5ca59\"}}},\"location\":\"sokdgoge\",\"tags\":{\"hbguzo\":\"ym\",\"mffjkutycyarn\":\"kyewnfnzhhhqo\"},\"id\":\"oohguabzoghkt\",\"name\":\"pyc\",\"type\":\"hcoeocnhzq\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HybridNetworkManager manager = HybridNetworkManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        Publisher response = manager.publishers()
            .getByResourceGroupWithResponse("vpinbmhwbj", "jkgqxnhmbkez", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("sokdgoge", response.location());
        Assertions.assertEquals("ym", response.tags().get("hbguzo"));
        Assertions.assertEquals(PublisherScope.PRIVATE, response.properties().scope());
        Assertions.assertEquals(ManagedServiceIdentityType.USER_ASSIGNED, response.identity().type());
    }
}
