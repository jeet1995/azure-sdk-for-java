// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.DefaultMode;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.GlobalRulestackResource;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ManagedIdentityType;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ScopeType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class GlobalRulestacksListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"panEtag\":\"yfu\",\"panLocation\":\"zsvtuikzhajqgl\",\"scope\":\"LOCAL\",\"associatedSubscriptions\":[\"rqryxynqn\"],\"description\":\"dpsovwxznptgo\",\"defaultMode\":\"NONE\",\"minAppIdVersion\":\"b\",\"provisioningState\":\"Deleting\",\"securityServices\":{\"vulnerabilityProfile\":\"vf\",\"antiSpywareProfile\":\"kvntjlrigjkskyri\",\"antiVirusProfile\":\"vzidsxwaab\",\"urlFilteringProfile\":\"ifrygzn\",\"fileBlockingProfile\":\"axri\",\"dnsSubscription\":\"zob\",\"outboundUnTrustCertificate\":\"pxl\",\"outboundTrustCertificate\":\"lnelxieixynl\"}},\"location\":\"xecwcro\",\"identity\":{\"tenantId\":\"slhcawjutifd\",\"principalId\":\"mvi\",\"type\":\"None\",\"userAssignedIdentities\":{\"zvcpopm\":{\"clientId\":\"bttzhraglkafhonq\",\"principalId\":\"jeick\"}}},\"id\":\"lnwcltyjed\",\"name\":\"xxmlfmkqscazua\",\"type\":\"xtzx\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PaloAltoNetworksNgfwManager manager = PaloAltoNetworksNgfwManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<GlobalRulestackResource> response
            = manager.globalRulestacks().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("xecwcro", response.iterator().next().location());
        Assertions.assertEquals(ManagedIdentityType.NONE, response.iterator().next().identity().type());
        Assertions.assertEquals("bttzhraglkafhonq",
            response.iterator().next().identity().userAssignedIdentities().get("zvcpopm").clientId());
        Assertions.assertEquals("jeick",
            response.iterator().next().identity().userAssignedIdentities().get("zvcpopm").principalId());
        Assertions.assertEquals("yfu", response.iterator().next().panEtag());
        Assertions.assertEquals("zsvtuikzhajqgl", response.iterator().next().panLocation());
        Assertions.assertEquals(ScopeType.LOCAL, response.iterator().next().scope());
        Assertions.assertEquals("rqryxynqn", response.iterator().next().associatedSubscriptions().get(0));
        Assertions.assertEquals("dpsovwxznptgo", response.iterator().next().description());
        Assertions.assertEquals(DefaultMode.NONE, response.iterator().next().defaultMode());
        Assertions.assertEquals("b", response.iterator().next().minAppIdVersion());
        Assertions.assertEquals("vf", response.iterator().next().securityServices().vulnerabilityProfile());
        Assertions.assertEquals("kvntjlrigjkskyri", response.iterator().next().securityServices().antiSpywareProfile());
        Assertions.assertEquals("vzidsxwaab", response.iterator().next().securityServices().antiVirusProfile());
        Assertions.assertEquals("ifrygzn", response.iterator().next().securityServices().urlFilteringProfile());
        Assertions.assertEquals("axri", response.iterator().next().securityServices().fileBlockingProfile());
        Assertions.assertEquals("zob", response.iterator().next().securityServices().dnsSubscription());
        Assertions.assertEquals("pxl", response.iterator().next().securityServices().outboundUnTrustCertificate());
        Assertions.assertEquals("lnelxieixynl",
            response.iterator().next().securityServices().outboundTrustCertificate());
    }
}
