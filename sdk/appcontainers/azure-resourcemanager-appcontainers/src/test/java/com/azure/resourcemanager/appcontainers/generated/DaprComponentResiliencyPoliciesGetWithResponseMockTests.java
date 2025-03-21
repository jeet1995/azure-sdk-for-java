// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.appcontainers.ContainerAppsApiManager;
import com.azure.resourcemanager.appcontainers.models.DaprComponentResiliencyPolicy;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DaprComponentResiliencyPoliciesGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"inboundPolicy\":{\"httpRetryPolicy\":{\"maxRetries\":1038883334,\"retryBackOff\":{\"initialDelayInMilliseconds\":1700371151,\"maxIntervalInMilliseconds\":1374921710}},\"timeoutPolicy\":{\"responseTimeoutInSeconds\":1935350563},\"circuitBreakerPolicy\":{\"consecutiveErrors\":154512919,\"timeoutInSeconds\":1158815759,\"intervalInSeconds\":703367024}},\"outboundPolicy\":{\"httpRetryPolicy\":{\"maxRetries\":725496177,\"retryBackOff\":{\"initialDelayInMilliseconds\":1579451655,\"maxIntervalInMilliseconds\":1723350346}},\"timeoutPolicy\":{\"responseTimeoutInSeconds\":171361564},\"circuitBreakerPolicy\":{\"consecutiveErrors\":896726160,\"timeoutInSeconds\":816302370,\"intervalInSeconds\":1468148143}}},\"id\":\"nrra\",\"name\":\"ovrwwx\",\"type\":\"wpjhspboxhifppsk\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerAppsApiManager manager = ContainerAppsApiManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        DaprComponentResiliencyPolicy response = manager.daprComponentResiliencyPolicies()
            .getWithResponse("hxzubfjzabbw", "gvzua", "xcdckixspsa", "gavkmv", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals(1038883334, response.inboundPolicy().httpRetryPolicy().maxRetries());
        Assertions.assertEquals(1700371151,
            response.inboundPolicy().httpRetryPolicy().retryBackOff().initialDelayInMilliseconds());
        Assertions.assertEquals(1374921710,
            response.inboundPolicy().httpRetryPolicy().retryBackOff().maxIntervalInMilliseconds());
        Assertions.assertEquals(1935350563, response.inboundPolicy().timeoutPolicy().responseTimeoutInSeconds());
        Assertions.assertEquals(154512919, response.inboundPolicy().circuitBreakerPolicy().consecutiveErrors());
        Assertions.assertEquals(1158815759, response.inboundPolicy().circuitBreakerPolicy().timeoutInSeconds());
        Assertions.assertEquals(703367024, response.inboundPolicy().circuitBreakerPolicy().intervalInSeconds());
        Assertions.assertEquals(725496177, response.outboundPolicy().httpRetryPolicy().maxRetries());
        Assertions.assertEquals(1579451655,
            response.outboundPolicy().httpRetryPolicy().retryBackOff().initialDelayInMilliseconds());
        Assertions.assertEquals(1723350346,
            response.outboundPolicy().httpRetryPolicy().retryBackOff().maxIntervalInMilliseconds());
        Assertions.assertEquals(171361564, response.outboundPolicy().timeoutPolicy().responseTimeoutInSeconds());
        Assertions.assertEquals(896726160, response.outboundPolicy().circuitBreakerPolicy().consecutiveErrors());
        Assertions.assertEquals(816302370, response.outboundPolicy().circuitBreakerPolicy().timeoutInSeconds());
        Assertions.assertEquals(1468148143, response.outboundPolicy().circuitBreakerPolicy().intervalInSeconds());
    }
}
