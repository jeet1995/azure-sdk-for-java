// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.webpubsub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.webpubsub.WebPubSubManager;
import com.azure.resourcemanager.webpubsub.models.PrivateLinkResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class WebPubSubPrivateLinkResourcesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"groupId\":\"phtvdu\",\"requiredMembers\":[\"vl\",\"jchcsrlzknmzla\"],\"requiredZoneNames\":[\"pdwvnphcn\",\"q\"],\"shareablePrivateLinkResourceTypes\":[{\"name\":\"mqrhvthl\",\"properties\":{\"description\":\"dcxsmlz\",\"groupId\":\"zdtxetlgyd\",\"type\":\"qvlnnpxybafiqgea\"}},{\"name\":\"bgj\",\"properties\":{\"description\":\"lklbyulidw\",\"groupId\":\"vmzegj\",\"type\":\"fhjirwgdnqzbrfk\"}},{\"name\":\"zhzmtksjci\",\"properties\":{\"description\":\"gsxcdgljplkeua\",\"groupId\":\"tomflrytswfpf\",\"type\":\"gycxnmskwhqjjys\"}}]},\"id\":\"rlpshhkv\",\"name\":\"edwqslsrh\",\"type\":\"pq\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        WebPubSubManager manager = WebPubSubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<PrivateLinkResource> response
            = manager.webPubSubPrivateLinkResources().list("fpafolpymwamxq", "rag", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("phtvdu", response.iterator().next().groupId());
        Assertions.assertEquals("vl", response.iterator().next().requiredMembers().get(0));
        Assertions.assertEquals("pdwvnphcn", response.iterator().next().requiredZoneNames().get(0));
        Assertions.assertEquals("mqrhvthl",
            response.iterator().next().shareablePrivateLinkResourceTypes().get(0).name());
        Assertions.assertEquals("dcxsmlz",
            response.iterator().next().shareablePrivateLinkResourceTypes().get(0).properties().description());
        Assertions.assertEquals("zdtxetlgyd",
            response.iterator().next().shareablePrivateLinkResourceTypes().get(0).properties().groupId());
        Assertions.assertEquals("qvlnnpxybafiqgea",
            response.iterator().next().shareablePrivateLinkResourceTypes().get(0).properties().type());
    }
}
