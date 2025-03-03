// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.FirewallStatusResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class FirewallStatusGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"isPanoramaManaged\":\"TRUE\",\"healthStatus\":\"INITIALIZING\",\"healthReason\":\"zji\",\"panoramaStatus\":{\"panoramaServerStatus\":\"UP\",\"panoramaServer2Status\":\"UP\"},\"provisioningState\":\"Failed\"},\"id\":\"absol\",\"name\":\"onqqlmgn\",\"type\":\"qxsjxte\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PaloAltoNetworksNgfwManager manager = PaloAltoNetworksNgfwManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        FirewallStatusResource response = manager.firewallStatus()
            .getWithResponse("svkskmqoz", "kivy", com.azure.core.util.Context.NONE)
            .getValue();

    }
}
