// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mixedreality.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.mixedreality.MixedRealityManager;
import com.azure.resourcemanager.mixedreality.models.Identity;
import com.azure.resourcemanager.mixedreality.models.ResourceIdentityType;
import com.azure.resourcemanager.mixedreality.models.Sku;
import com.azure.resourcemanager.mixedreality.models.SkuTier;
import com.azure.resourcemanager.mixedreality.models.SpatialAnchorsAccount;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SpatialAnchorsAccountsCreateWithResponseMockTests {
    @Test
    public void testCreateWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"storageAccountName\":\"lkthu\",\"accountId\":\"qolbgyc\",\"accountDomain\":\"iertgccymvaolp\"},\"identity\":{\"principalId\":\"qlfmmdnbb\",\"tenantId\":\"zpswiydmc\",\"type\":\"SystemAssigned\"},\"plan\":{\"principalId\":\"xssadbzmnvdf\",\"tenantId\":\"ud\",\"type\":\"SystemAssigned\"},\"sku\":{\"name\":\"xzb\",\"tier\":\"Standard\",\"size\":\"ylpstdbhhxsrzdz\",\"family\":\"erscdntne\",\"capacity\":1072156994},\"kind\":{\"name\":\"jmygtdsslswtmwer\",\"tier\":\"Free\",\"size\":\"pyqs\",\"family\":\"wab\",\"capacity\":334511461},\"location\":\"hhszh\",\"tags\":{\"nkww\":\"lvwiwubmwmbesl\",\"flcxoga\":\"pp\",\"mkqzeqqkdltfzxmh\":\"konzmnsik\",\"gureodkwobdag\":\"v\"},\"id\":\"tibqdxbxwakb\",\"name\":\"gqxndlkzgxhuripl\",\"type\":\"podxunkb\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MixedRealityManager manager = MixedRealityManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        SpatialAnchorsAccount response = manager.spatialAnchorsAccounts()
            .define("mjh")
            .withRegion("ssotftpv")
            .withExistingResourceGroup("rmfqjhhkxbpvj")
            .withTags(
                mapOf("aruoujmkcjhwqyt", "exilzznfqqnvwpmq", "bnw", "r", "enq", "ewgdrjervn", "ndoygmifthnzdnd", "eh"))
            .withIdentity(new Identity().withType(ResourceIdentityType.SYSTEM_ASSIGNED))
            .withPlan(new Identity().withType(ResourceIdentityType.SYSTEM_ASSIGNED))
            .withSku(new Sku().withName("blytk")
                .withTier(SkuTier.FREE)
                .withSize("ewwwfbkrvrnsv")
                .withFamily("q")
                .withCapacity(925506689))
            .withKind(new Sku().withName("crsbfovasr")
                .withTier(SkuTier.FREE)
                .withSize("bhsqfsubcgjbirxb")
                .withFamily("bsrfbj")
                .withCapacity(837542479))
            .withStorageAccountName("yngudivk")
            .create();

        Assertions.assertEquals("hhszh", response.location());
        Assertions.assertEquals("lvwiwubmwmbesl", response.tags().get("nkww"));
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, response.identity().type());
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, response.plan().type());
        Assertions.assertEquals("xzb", response.sku().name());
        Assertions.assertEquals(SkuTier.STANDARD, response.sku().tier());
        Assertions.assertEquals("ylpstdbhhxsrzdz", response.sku().size());
        Assertions.assertEquals("erscdntne", response.sku().family());
        Assertions.assertEquals(1072156994, response.sku().capacity());
        Assertions.assertEquals("jmygtdsslswtmwer", response.kind().name());
        Assertions.assertEquals(SkuTier.FREE, response.kind().tier());
        Assertions.assertEquals("pyqs", response.kind().size());
        Assertions.assertEquals("wab", response.kind().family());
        Assertions.assertEquals(334511461, response.kind().capacity());
        Assertions.assertEquals("lkthu", response.storageAccountName());
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
