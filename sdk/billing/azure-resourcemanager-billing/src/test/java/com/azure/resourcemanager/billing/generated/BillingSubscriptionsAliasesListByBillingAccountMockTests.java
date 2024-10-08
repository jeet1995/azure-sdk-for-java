// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.billing.BillingManager;
import com.azure.resourcemanager.billing.models.AutoRenew;
import com.azure.resourcemanager.billing.models.BillingSubscriptionAlias;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class BillingSubscriptionsAliasesListByBillingAccountMockTests {
    @Test
    public void testListByBillingAccount() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"billingSubscriptionId\":\"ofz\",\"autoRenew\":\"Off\",\"beneficiaryTenantId\":\"tl\",\"beneficiary\":{\"tenantId\":\"oxzuhellit\",\"objectId\":\"vpiv\"},\"billingFrequency\":\"gqbmolxeomeb\",\"billingProfileId\":\"tvxx\",\"billingPolicies\":{\"nalpcuedybkbgdw\":\"oyacgi\"},\"billingProfileDisplayName\":\"ivzikatywedbpi\",\"billingProfileName\":\"zpa\",\"consumptionCostCenter\":\"b\",\"customerId\":\"xncszdwpaveux\",\"customerDisplayName\":\"igsoeb\",\"customerName\":\"tniuiim\",\"displayName\":\"ffhgvc\",\"enrollmentAccountId\":\"ddoeilhgga\",\"enrollmentAccountDisplayName\":\"eudbobmol\",\"enrollmentAccountSubscriptionDetails\":{\"enrollmentAccountStartDate\":\"2021-10-10T01:35:15Z\",\"subscriptionEnrollmentAccountStatus\":\"Inactive\"},\"invoiceSectionId\":\"lzihv\",\"invoiceSectionDisplayName\":\"quajpo\",\"invoiceSectionName\":\"djxyotgvraxhn\",\"lastMonthCharges\":{\"currency\":\"wfszkrlkosj\",\"value\":40.694565},\"monthToDateCharges\":{\"currency\":\"s\",\"value\":54.19026},\"nextBillingCycleDetails\":{\"billingFrequency\":\"ksdiimioixv\"},\"offerId\":\"buwbngeu\",\"productCategory\":\"dqngqamhb\",\"productType\":\"gnqx\",\"productTypeId\":\"xqzaffz\",\"purchaseDate\":\"2021-06-24T06:16:46Z\",\"quantity\":7833264232321996164,\"reseller\":{\"resellerId\":\"vomdqxnoyzqipapi\",\"description\":\"cydbjghunq\"},\"renewalTermDetails\":{\"billingFrequency\":\"rwo\",\"productId\":\"zvvxdvphx\",\"productTypeId\":\"wvxcai\",\"skuId\":\"icbogsfo\",\"termDuration\":\"mamiyfgunruk\",\"quantity\":5932949525198315477,\"termEndDate\":\"2021-08-02T03:26:08Z\"},\"skuId\":\"kubzq\",\"skuDescription\":\"dlrkvitzk\",\"systemOverrides\":{\"cancellation\":\"NotAllowed\",\"cancellationAllowedEndDate\":\"2021-08-01T03:19:07Z\"},\"resourceUri\":\"nido\",\"termDuration\":\"pumzuh\",\"termStartDate\":\"2021-09-20T03:14:58Z\",\"termEndDate\":\"2021-06-04T06:26:49Z\",\"provisioningTenantId\":\"hpvarumvuwj\",\"status\":\"Expiring\",\"operationStatus\":\"LockedForUpdate\",\"provisioningState\":\"Created\",\"subscriptionId\":\"llavz\",\"suspensionReasons\":[\"gmrodb\",\"apqra\"],\"suspensionReasonDetails\":[{\"effectiveDate\":\"2021-01-28T03:41:37Z\",\"reason\":\"Transferred\"},{\"effectiveDate\":\"2021-01-30T15:45:15Z\",\"reason\":\"Other\"},{\"effectiveDate\":\"2021-04-18T05:33:20Z\",\"reason\":\"Cancelled\"},{\"effectiveDate\":\"2021-08-09T06:45:20Z\",\"reason\":\"Other\"}]},\"tags\":{\"ttgxkxt\":\"eg\"},\"id\":\"bbjbeyqohvia\",\"name\":\"pjfkr\",\"type\":\"rerdlgbvtpxowg\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        BillingManager manager = BillingManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<BillingSubscriptionAlias> response = manager.billingSubscriptionsAliases()
            .listByBillingAccount("uouoqtenq", true, "muogeq", "apaseqcppypfre", 5569397966046661840L,
                6833106247375052675L, false, "dyvt", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("eg", response.iterator().next().tags().get("ttgxkxt"));
        Assertions.assertEquals(AutoRenew.OFF, response.iterator().next().autoRenew());
        Assertions.assertEquals("tl", response.iterator().next().beneficiaryTenantId());
        Assertions.assertEquals("oxzuhellit", response.iterator().next().beneficiary().tenantId());
        Assertions.assertEquals("vpiv", response.iterator().next().beneficiary().objectId());
        Assertions.assertEquals("gqbmolxeomeb", response.iterator().next().billingFrequency());
        Assertions.assertEquals("tvxx", response.iterator().next().billingProfileId());
        Assertions.assertEquals("b", response.iterator().next().consumptionCostCenter());
        Assertions.assertEquals("xncszdwpaveux", response.iterator().next().customerId());
        Assertions.assertEquals("ffhgvc", response.iterator().next().displayName());
        Assertions.assertEquals("lzihv", response.iterator().next().invoiceSectionId());
        Assertions.assertEquals("xqzaffz", response.iterator().next().productTypeId());
        Assertions.assertEquals(7833264232321996164L, response.iterator().next().quantity());
        Assertions.assertEquals("kubzq", response.iterator().next().skuId());
        Assertions.assertEquals("pumzuh", response.iterator().next().termDuration());
        Assertions.assertEquals("hpvarumvuwj", response.iterator().next().provisioningTenantId());
    }
}
