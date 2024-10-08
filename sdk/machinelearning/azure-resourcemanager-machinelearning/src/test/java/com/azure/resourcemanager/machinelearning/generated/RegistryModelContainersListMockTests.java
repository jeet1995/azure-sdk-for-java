// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.machinelearning.MachineLearningManager;
import com.azure.resourcemanager.machinelearning.models.ListViewType;
import com.azure.resourcemanager.machinelearning.models.ModelContainer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class RegistryModelContainersListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Succeeded\",\"isArchived\":false,\"latestVersion\":\"rolhsfddk\",\"nextVersion\":\"vevwxmnbw\",\"description\":\"a\",\"tags\":{\"na\":\"npyhtuhalpqil\",\"zbtgtzpcat\":\"kexznpnytkqjarl\",\"ujfgtg\":\"mz\"},\"properties\":{\"naidvssv\":\"pczeg\",\"bqgzkuobclo\":\"yoggkztzttjnkn\"}},\"id\":\"aqeizp\",\"name\":\"iqlyugp\",\"type\":\"nhzjmkffeonmnv\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MachineLearningManager manager = MachineLearningManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<ModelContainer> response = manager.registryModelContainers()
            .list("xyksznfstmp", "vgrandzktwo", "lpczlq", ListViewType.ALL, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("a", response.iterator().next().properties().description());
        Assertions.assertEquals("npyhtuhalpqil", response.iterator().next().properties().tags().get("na"));
        Assertions.assertEquals("pczeg", response.iterator().next().properties().properties().get("naidvssv"));
        Assertions.assertEquals(false, response.iterator().next().properties().isArchived());
    }
}
