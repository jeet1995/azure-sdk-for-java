// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.machinelearning.MachineLearningManager;
import com.azure.resourcemanager.machinelearning.models.FeaturestoreEntityContainer;
import com.azure.resourcemanager.machinelearning.models.FeaturestoreEntityContainerProperties;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class FeaturestoreEntityContainersCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Succeeded\",\"isArchived\":false,\"latestVersion\":\"wxrqiwxeppu\",\"nextVersion\":\"izoak\",\"description\":\"jyv\",\"tags\":{\"s\":\"vfbmxzobpg\",\"ybyilhdbb\":\"lkpajio\",\"t\":\"meuyxhcwu\",\"choji\":\"go\"},\"properties\":{\"frgiplxrifbsbk\":\"q\",\"dbbpoijsxvrutji\":\"fk\",\"ktpj\":\"uufknarscx\"}},\"id\":\"zos\",\"name\":\"rsm\",\"type\":\"nn\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MachineLearningManager manager = MachineLearningManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        FeaturestoreEntityContainer response = manager.featurestoreEntityContainers()
            .define("jckyocyb")
            .withExistingWorkspace("cyulwzjorvsgmkk", "les")
            .withProperties(new FeaturestoreEntityContainerProperties().withDescription("uywfhltwlz")
                .withTags(mapOf("ybmkmxusm", "iprlcgqewmnwyhq", "uniu", "papepwpbnjckow", "zypmmyr", "ysvnddllbwnmvh"))
                .withProperties(mapOf("tltlmczcxouane", "douzohihqlwyqsxe", "pvdmtfcstucmi", "epgqztakovslv", "qitiut",
                    "sdsnuqqg", "xjkclz", "ka"))
                .withIsArchived(true))
            .create();

        Assertions.assertEquals("jyv", response.properties().description());
        Assertions.assertEquals("vfbmxzobpg", response.properties().tags().get("s"));
        Assertions.assertEquals("q", response.properties().properties().get("frgiplxrifbsbk"));
        Assertions.assertEquals(false, response.properties().isArchived());
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
