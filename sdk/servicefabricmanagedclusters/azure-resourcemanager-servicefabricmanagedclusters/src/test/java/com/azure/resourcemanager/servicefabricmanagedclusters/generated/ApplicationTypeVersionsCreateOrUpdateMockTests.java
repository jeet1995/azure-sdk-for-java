// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.servicefabricmanagedclusters.ServiceFabricManagedClustersManager;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ApplicationTypeVersionResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ApplicationTypeVersionsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Succeeded\",\"appPackageUrl\":\"nwy\"},\"location\":\"zdmovzv\",\"tags\":{\"z\":\"awzqadfl\",\"ndtic\":\"riglaec\",\"mldgxobfirc\":\"kpvzmlq\"},\"id\":\"pkc\",\"name\":\"ayzri\",\"type\":\"khyawfvjlboxqv\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ServiceFabricManagedClustersManager manager = ServiceFabricManagedClustersManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        ApplicationTypeVersionResource response = manager.applicationTypeVersions()
            .define("mbtrnegvmnvu")
            .withExistingApplicationType("xfzwi", "vwzjbhyz", "xjrk")
            .withRegion("dmflv")
            .withTags(mapOf("pxlktwkuziycsl", "mjlxrrilozapeewc", "uztcktyhjtqed", "vu"))
            .withAppPackageUrl("tjb")
            .create();

        Assertions.assertEquals("zdmovzv", response.location());
        Assertions.assertEquals("awzqadfl", response.tags().get("z"));
        Assertions.assertEquals("nwy", response.appPackageUrl());
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
