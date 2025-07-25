// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.computeschedule.ComputeScheduleManager;
import com.azure.resourcemanager.computeschedule.models.Language;
import com.azure.resourcemanager.computeschedule.models.NotificationType;
import com.azure.resourcemanager.computeschedule.models.ScheduledActionResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ScheduledActionsListResourcesMockTests {
    @Test
    public void testListResources() throws Exception {
        String responseStr
            = "{\"value\":[{\"name\":\"jphuopxodlqi\",\"id\":\"ntorzihleosjswsr\",\"type\":\"lyzrpzbchckqqzqi\",\"resourceId\":\"xiy\",\"notificationSettings\":[{\"destination\":\"i\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":true},{\"destination\":\"dy\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":true},{\"destination\":\"hqmibzyhwit\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":true},{\"destination\":\"ynpcdpumnzgmwznm\",\"type\":\"Email\",\"language\":\"en-us\",\"disabled\":true}]}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ComputeScheduleManager manager = ComputeScheduleManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<ScheduledActionResource> response
            = manager.scheduledActions().listResources("ynfs", "n", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("xiy", response.iterator().next().resourceId());
        Assertions.assertEquals("i", response.iterator().next().notificationSettings().get(0).destination());
        Assertions.assertEquals(NotificationType.EMAIL,
            response.iterator().next().notificationSettings().get(0).type());
        Assertions.assertEquals(Language.EN_US, response.iterator().next().notificationSettings().get(0).language());
        Assertions.assertTrue(response.iterator().next().notificationSettings().get(0).disabled());
    }
}
