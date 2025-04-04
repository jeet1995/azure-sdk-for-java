// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.neonpostgres.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.neonpostgres.NeonPostgresManager;
import com.azure.resourcemanager.neonpostgres.models.MarketplaceSubscriptionStatus;
import com.azure.resourcemanager.neonpostgres.models.OrganizationResource;
import com.azure.resourcemanager.neonpostgres.models.SingleSignOnStates;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class OrganizationsListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"marketplaceDetails\":{\"subscriptionId\":\"ivfsnk\",\"subscriptionStatus\":\"Suspended\",\"offerDetails\":{\"publisherId\":\"ctq\",\"offerId\":\"jf\",\"planId\":\"ebrjcxe\",\"planName\":\"uwutttxfvjrbi\",\"termUnit\":\"hxepcyvahfnlj\",\"termId\":\"qxj\"}},\"userDetails\":{\"firstName\":\"ujqgidok\",\"lastName\":\"ljyoxgvcltb\",\"emailAddress\":\"ncghkje\",\"upn\":\"zhbijhtxfv\",\"phoneNumber\":\"bfs\"},\"companyDetails\":{\"companyName\":\"nehmpvecx\",\"country\":\"debfqkkrbmpukgri\",\"officeAddress\":\"lzlfbxzpuz\",\"businessPhone\":\"ispnqzahmgkbrp\",\"domain\":\"dhibnuq\",\"numberOfEmployees\":4819636343851970527},\"provisioningState\":\"Canceled\",\"partnerOrganizationProperties\":{\"organizationId\":\"gvtqagnbuynh\",\"organizationName\":\"jggmebfsiarbu\",\"singleSignOnProperties\":{\"singleSignOnState\":\"Initial\",\"enterpriseAppId\":\"na\",\"singleSignOnUrl\":\"mhjrunmpxttdbhr\",\"aadDomains\":[\"ankxmyskpbhenb\"]}}},\"location\":\"cxy\",\"tags\":{\"qidybyx\":\"tnrsyn\"},\"id\":\"zfcl\",\"name\":\"aaxdbabphlwrq\",\"type\":\"fkts\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NeonPostgresManager manager = NeonPostgresManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<OrganizationResource> response = manager.organizations().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("cxy", response.iterator().next().location());
        Assertions.assertEquals("tnrsyn", response.iterator().next().tags().get("qidybyx"));
        Assertions.assertEquals("ivfsnk",
            response.iterator().next().properties().marketplaceDetails().subscriptionId());
        Assertions.assertEquals(MarketplaceSubscriptionStatus.SUSPENDED,
            response.iterator().next().properties().marketplaceDetails().subscriptionStatus());
        Assertions.assertEquals("ctq",
            response.iterator().next().properties().marketplaceDetails().offerDetails().publisherId());
        Assertions.assertEquals("jf",
            response.iterator().next().properties().marketplaceDetails().offerDetails().offerId());
        Assertions.assertEquals("ebrjcxe",
            response.iterator().next().properties().marketplaceDetails().offerDetails().planId());
        Assertions.assertEquals("uwutttxfvjrbi",
            response.iterator().next().properties().marketplaceDetails().offerDetails().planName());
        Assertions.assertEquals("hxepcyvahfnlj",
            response.iterator().next().properties().marketplaceDetails().offerDetails().termUnit());
        Assertions.assertEquals("qxj",
            response.iterator().next().properties().marketplaceDetails().offerDetails().termId());
        Assertions.assertEquals("ujqgidok", response.iterator().next().properties().userDetails().firstName());
        Assertions.assertEquals("ljyoxgvcltb", response.iterator().next().properties().userDetails().lastName());
        Assertions.assertEquals("ncghkje", response.iterator().next().properties().userDetails().emailAddress());
        Assertions.assertEquals("zhbijhtxfv", response.iterator().next().properties().userDetails().upn());
        Assertions.assertEquals("bfs", response.iterator().next().properties().userDetails().phoneNumber());
        Assertions.assertEquals("nehmpvecx", response.iterator().next().properties().companyDetails().companyName());
        Assertions.assertEquals("debfqkkrbmpukgri", response.iterator().next().properties().companyDetails().country());
        Assertions.assertEquals("lzlfbxzpuz", response.iterator().next().properties().companyDetails().officeAddress());
        Assertions.assertEquals("ispnqzahmgkbrp",
            response.iterator().next().properties().companyDetails().businessPhone());
        Assertions.assertEquals("dhibnuq", response.iterator().next().properties().companyDetails().domain());
        Assertions.assertEquals(4819636343851970527L,
            response.iterator().next().properties().companyDetails().numberOfEmployees());
        Assertions.assertEquals("gvtqagnbuynh",
            response.iterator().next().properties().partnerOrganizationProperties().organizationId());
        Assertions.assertEquals("jggmebfsiarbu",
            response.iterator().next().properties().partnerOrganizationProperties().organizationName());
        Assertions.assertEquals(SingleSignOnStates.INITIAL,
            response.iterator()
                .next()
                .properties()
                .partnerOrganizationProperties()
                .singleSignOnProperties()
                .singleSignOnState());
        Assertions.assertEquals("na",
            response.iterator()
                .next()
                .properties()
                .partnerOrganizationProperties()
                .singleSignOnProperties()
                .enterpriseAppId());
        Assertions.assertEquals("mhjrunmpxttdbhr",
            response.iterator()
                .next()
                .properties()
                .partnerOrganizationProperties()
                .singleSignOnProperties()
                .singleSignOnUrl());
        Assertions.assertEquals("ankxmyskpbhenb",
            response.iterator()
                .next()
                .properties()
                .partnerOrganizationProperties()
                .singleSignOnProperties()
                .aadDomains()
                .get(0));
    }
}
