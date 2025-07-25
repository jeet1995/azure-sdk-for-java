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
import com.azure.resourcemanager.eventgrid.models.PartnerDestination;
import com.azure.resourcemanager.eventgrid.models.PartnerDestinationActivationState;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PartnerDestinationsActivateWithResponseMockTests {
    @Test
    public void testActivateWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"partnerRegistrationImmutableId\":\"d4e3f370-e76d-414b-b5a6-9ab548aadc05\",\"endpointServiceContext\":\"mkgxqwqueuuylzt\",\"expirationTimeIfNotActivatedUtc\":\"2021-06-29T18:49:55Z\",\"provisioningState\":\"Canceled\",\"activationState\":\"Activated\",\"endpointBaseUrl\":\"ykofvez\",\"messageForActivation\":\"k\"},\"location\":\"qt\",\"tags\":{\"zkca\":\"epj\",\"rtwzvaqkifmxa\":\"fwzcntogffjwaj\",\"kmjqncfvdsc\":\"ostfzknh\"},\"id\":\"hemvwfnqqwypvnd\",\"name\":\"wbgodtggrssg\",\"type\":\"jfkainj\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EventGridManager manager = EventGridManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PartnerDestination response = manager.partnerDestinations()
            .activateWithResponse("xrid", "tb", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("qt", response.location());
        Assertions.assertEquals("epj", response.tags().get("zkca"));
        Assertions.assertEquals(UUID.fromString("d4e3f370-e76d-414b-b5a6-9ab548aadc05"),
            response.partnerRegistrationImmutableId());
        Assertions.assertEquals("mkgxqwqueuuylzt", response.endpointServiceContext());
        Assertions.assertEquals(OffsetDateTime.parse("2021-06-29T18:49:55Z"),
            response.expirationTimeIfNotActivatedUtc());
        Assertions.assertEquals(PartnerDestinationActivationState.ACTIVATED, response.activationState());
        Assertions.assertEquals("ykofvez", response.endpointBaseUrl());
        Assertions.assertEquals("k", response.messageForActivation());
    }
}
