// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.netapp.NetAppFilesManager;
import com.azure.resourcemanager.netapp.models.BackupPolicy;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class BackupPoliciesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"etag\":\"qpswokmvkhlggdhb\",\"properties\":{\"backupPolicyId\":\"zqkzszuwi\",\"provisioningState\":\"glxxhljfpgpic\",\"dailyBackupsToKeep\":1974760632,\"weeklyBackupsToKeep\":285978627,\"monthlyBackupsToKeep\":1409620818,\"volumesAssigned\":1972611629,\"enabled\":false,\"volumeBackups\":[{\"volumeName\":\"pqcbfrmbodthsq\",\"volumeResourceId\":\"vriibakclacjfr\",\"backupsCount\":1419015231,\"policyEnabled\":true}]},\"location\":\"au\",\"tags\":{\"wohqfzizvu\":\"vsg\",\"vmribiat\":\"mmkjsvthnwpztek\",\"zcugswvxwlmzqw\":\"gplucfotangcfhny\",\"cvclxynpdk\":\"vtxnjmxmcuqud\"},\"id\":\"gfabuiyjibuzphdu\",\"name\":\"neiknpg\",\"type\":\"xgjiuqh\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetAppFilesManager manager = NetAppFilesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<BackupPolicy> response
            = manager.backupPolicies().list("zvuporqzdfuydz", "kfvxcnq", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("au", response.iterator().next().location());
        Assertions.assertEquals("vsg", response.iterator().next().tags().get("wohqfzizvu"));
        Assertions.assertEquals(1974760632, response.iterator().next().dailyBackupsToKeep());
        Assertions.assertEquals(285978627, response.iterator().next().weeklyBackupsToKeep());
        Assertions.assertEquals(1409620818, response.iterator().next().monthlyBackupsToKeep());
        Assertions.assertEquals(false, response.iterator().next().enabled());
    }
}
