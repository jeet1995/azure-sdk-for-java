// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.eventgrid.EventGridManager;
import com.azure.resourcemanager.eventgrid.models.PartnerRegistration;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PartnerRegistrationsGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Failed\",\"partnerRegistrationImmutableId\":\"b0df1bff-fd49-4454-8c10-96b8e84f438d\"},\"location\":\"ifleimixlmd\",\"tags\":{\"rjuqbpxtokl\":\"cehfgsm\",\"rcltungbsoljckm\":\"mtznpaxwfqtyyqi\",\"zbkuckgkdsksw\":\"i\",\"woykdnonaaxwm\":\"iiqqcqikclsmalns\"},\"id\":\"zrujlqcwnyn\",\"name\":\"lei\",\"type\":\"bcbgv\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EventGridManager manager = EventGridManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PartnerRegistration response = manager.partnerRegistrations()
            .getByResourceGroupWithResponse("dtullygtavczcxdf", "eapyfmlxrlj", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("ifleimixlmd", response.location());
        Assertions.assertEquals("cehfgsm", response.tags().get("rjuqbpxtokl"));
        Assertions.assertEquals(UUID.fromString("b0df1bff-fd49-4454-8c10-96b8e84f438d"),
            response.partnerRegistrationImmutableId());
    }
}
