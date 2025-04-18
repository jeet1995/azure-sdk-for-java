// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.arizeaiobservabilityeval.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.MarketplaceDetails;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.OfferDetails;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.OrganizationProperties;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.PartnerProperties;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.SingleSignOnPropertiesV2;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.SingleSignOnStates;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.SingleSignOnType;
import com.azure.resourcemanager.arizeaiobservabilityeval.models.UserDetails;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class OrganizationPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OrganizationProperties model = BinaryData.fromString(
            "{\"marketplace\":{\"subscriptionId\":\"rnfygxgispem\",\"subscriptionStatus\":\"Suspended\",\"offerDetails\":{\"publisherId\":\"fkufublj\",\"offerId\":\"fxqeof\",\"planId\":\"aeqjhqjbasvms\",\"planName\":\"qulngsntnbybkzgc\",\"termUnit\":\"wclxxwrl\",\"termId\":\"ouskcqvkocrc\"}},\"user\":{\"firstName\":\"kwt\",\"lastName\":\"xbnjbiksq\",\"emailAddress\":\"lssai\",\"upn\":\"p\",\"phoneNumber\":\"nzl\"},\"provisioningState\":\"Canceled\",\"partnerProperties\":{\"description\":\"ppeebvmgxsab\"},\"singleSignOnProperties\":{\"type\":\"OpenId\",\"state\":\"Disable\",\"enterpriseAppId\":\"jitcjczdzevn\",\"url\":\"krwpdap\",\"aadDomains\":[\"bdkvwrwjf\",\"usnhutje\"]}}")
            .toObject(OrganizationProperties.class);
        Assertions.assertEquals("rnfygxgispem", model.marketplace().subscriptionId());
        Assertions.assertEquals("fkufublj", model.marketplace().offerDetails().publisherId());
        Assertions.assertEquals("fxqeof", model.marketplace().offerDetails().offerId());
        Assertions.assertEquals("aeqjhqjbasvms", model.marketplace().offerDetails().planId());
        Assertions.assertEquals("qulngsntnbybkzgc", model.marketplace().offerDetails().planName());
        Assertions.assertEquals("wclxxwrl", model.marketplace().offerDetails().termUnit());
        Assertions.assertEquals("ouskcqvkocrc", model.marketplace().offerDetails().termId());
        Assertions.assertEquals("kwt", model.user().firstName());
        Assertions.assertEquals("xbnjbiksq", model.user().lastName());
        Assertions.assertEquals("lssai", model.user().emailAddress());
        Assertions.assertEquals("p", model.user().upn());
        Assertions.assertEquals("nzl", model.user().phoneNumber());
        Assertions.assertEquals("ppeebvmgxsab", model.partnerProperties().description());
        Assertions.assertEquals(SingleSignOnType.OPEN_ID, model.singleSignOnProperties().type());
        Assertions.assertEquals(SingleSignOnStates.DISABLE, model.singleSignOnProperties().state());
        Assertions.assertEquals("jitcjczdzevn", model.singleSignOnProperties().enterpriseAppId());
        Assertions.assertEquals("krwpdap", model.singleSignOnProperties().url());
        Assertions.assertEquals("bdkvwrwjf", model.singleSignOnProperties().aadDomains().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OrganizationProperties model = new OrganizationProperties()
            .withMarketplace(new MarketplaceDetails().withSubscriptionId("rnfygxgispem")
                .withOfferDetails(new OfferDetails().withPublisherId("fkufublj")
                    .withOfferId("fxqeof")
                    .withPlanId("aeqjhqjbasvms")
                    .withPlanName("qulngsntnbybkzgc")
                    .withTermUnit("wclxxwrl")
                    .withTermId("ouskcqvkocrc")))
            .withUser(new UserDetails().withFirstName("kwt")
                .withLastName("xbnjbiksq")
                .withEmailAddress("lssai")
                .withUpn("p")
                .withPhoneNumber("nzl"))
            .withPartnerProperties(new PartnerProperties().withDescription("ppeebvmgxsab"))
            .withSingleSignOnProperties(new SingleSignOnPropertiesV2().withType(SingleSignOnType.OPEN_ID)
                .withState(SingleSignOnStates.DISABLE)
                .withEnterpriseAppId("jitcjczdzevn")
                .withUrl("krwpdap")
                .withAadDomains(Arrays.asList("bdkvwrwjf", "usnhutje")));
        model = BinaryData.fromObject(model).toObject(OrganizationProperties.class);
        Assertions.assertEquals("rnfygxgispem", model.marketplace().subscriptionId());
        Assertions.assertEquals("fkufublj", model.marketplace().offerDetails().publisherId());
        Assertions.assertEquals("fxqeof", model.marketplace().offerDetails().offerId());
        Assertions.assertEquals("aeqjhqjbasvms", model.marketplace().offerDetails().planId());
        Assertions.assertEquals("qulngsntnbybkzgc", model.marketplace().offerDetails().planName());
        Assertions.assertEquals("wclxxwrl", model.marketplace().offerDetails().termUnit());
        Assertions.assertEquals("ouskcqvkocrc", model.marketplace().offerDetails().termId());
        Assertions.assertEquals("kwt", model.user().firstName());
        Assertions.assertEquals("xbnjbiksq", model.user().lastName());
        Assertions.assertEquals("lssai", model.user().emailAddress());
        Assertions.assertEquals("p", model.user().upn());
        Assertions.assertEquals("nzl", model.user().phoneNumber());
        Assertions.assertEquals("ppeebvmgxsab", model.partnerProperties().description());
        Assertions.assertEquals(SingleSignOnType.OPEN_ID, model.singleSignOnProperties().type());
        Assertions.assertEquals(SingleSignOnStates.DISABLE, model.singleSignOnProperties().state());
        Assertions.assertEquals("jitcjczdzevn", model.singleSignOnProperties().enterpriseAppId());
        Assertions.assertEquals("krwpdap", model.singleSignOnProperties().url());
        Assertions.assertEquals("bdkvwrwjf", model.singleSignOnProperties().aadDomains().get(0));
    }
}
