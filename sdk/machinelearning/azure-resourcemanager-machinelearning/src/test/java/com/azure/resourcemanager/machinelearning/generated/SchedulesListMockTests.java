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
import com.azure.resourcemanager.machinelearning.models.Schedule;
import com.azure.resourcemanager.machinelearning.models.ScheduleListViewType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SchedulesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"displayName\":\"oujtcp\",\"isEnabled\":true,\"trigger\":{\"triggerType\":\"TriggerBase\",\"endTime\":\"lyogzbasjckakik\",\"startTime\":\"ajmnvb\",\"timeZone\":\"mnkrqdyc\"},\"action\":{\"actionType\":\"ScheduleActionBase\"},\"provisioningState\":\"Deleting\",\"description\":\"kxx\",\"tags\":{\"bcgsa\":\"qr\",\"qedft\":\"daypx\",\"kt\":\"igmj\"},\"properties\":{\"brtzfliqntnoeg\":\"yvzixmusiidiv\",\"daiex\":\"oqpuclidyt\",\"fgivfiypf\":\"sapygiioukaffz\",\"u\":\"wyzjsixorvigrxmp\"}},\"id\":\"ekbpqghxdpg\",\"name\":\"hfimlyxd\",\"type\":\"ixjudbiac\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        MachineLearningManager manager = MachineLearningManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<Schedule> response = manager.schedules()
            .list("nhhvp", "ukourqviyf", "segwez", ScheduleListViewType.ALL, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("kxx", response.iterator().next().properties().description());
        Assertions.assertEquals("qr", response.iterator().next().properties().tags().get("bcgsa"));
        Assertions.assertEquals("yvzixmusiidiv",
            response.iterator().next().properties().properties().get("brtzfliqntnoeg"));
        Assertions.assertEquals("oujtcp", response.iterator().next().properties().displayName());
        Assertions.assertEquals(true, response.iterator().next().properties().isEnabled());
        Assertions.assertEquals("lyogzbasjckakik", response.iterator().next().properties().trigger().endTime());
        Assertions.assertEquals("ajmnvb", response.iterator().next().properties().trigger().startTime());
        Assertions.assertEquals("mnkrqdyc", response.iterator().next().properties().trigger().timeZone());
    }
}
