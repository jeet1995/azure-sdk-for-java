// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
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

public final class BackupPoliciesGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"etag\":\"syrq\",\"properties\":{\"backupPolicyId\":\"jqhden\",\"provisioningState\":\"ulkpakd\",\"dailyBackupsToKeep\":466096532,\"weeklyBackupsToKeep\":2145222324,\"monthlyBackupsToKeep\":211340974,\"volumesAssigned\":641557673,\"enabled\":true,\"volumeBackups\":[{\"volumeName\":\"xuckpggqoweyir\",\"volumeResourceId\":\"lisn\",\"backupsCount\":351115849,\"policyEnabled\":true},{\"volumeName\":\"mpizru\",\"volumeResourceId\":\"pqxpx\",\"backupsCount\":1760888733,\"policyEnabled\":false},{\"volumeName\":\"jsa\",\"volumeResourceId\":\"iixtmkzj\",\"backupsCount\":671429821,\"policyEnabled\":true},{\"volumeName\":\"hgfgrwsd\",\"volumeResourceId\":\"ra\",\"backupsCount\":202714227,\"policyEnabled\":true}]},\"location\":\"lbyvictctbrxkjzw\",\"tags\":{\"hkwfbkgozxwop\":\"ffm\"},\"id\":\"bydpizqaclnapxb\",\"name\":\"yg\",\"type\":\"ugjknf\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetAppFilesManager manager = NetAppFilesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        BackupPolicy response = manager.backupPolicies()
            .getWithResponse("qtobaxkjeyt", "nlb", "jkwrusnkq", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("lbyvictctbrxkjzw", response.location());
        Assertions.assertEquals("ffm", response.tags().get("hkwfbkgozxwop"));
        Assertions.assertEquals(466096532, response.dailyBackupsToKeep());
        Assertions.assertEquals(2145222324, response.weeklyBackupsToKeep());
        Assertions.assertEquals(211340974, response.monthlyBackupsToKeep());
        Assertions.assertEquals(true, response.enabled());
    }
}
