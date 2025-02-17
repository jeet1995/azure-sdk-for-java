// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dashboard.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dashboard.fluent.models.EnterpriseDetailsInner;
import com.azure.resourcemanager.dashboard.models.AvailablePromotion;
import com.azure.resourcemanager.dashboard.models.MarketplaceTrialQuota;
import com.azure.resourcemanager.dashboard.models.SaasSubscriptionDetails;
import com.azure.resourcemanager.dashboard.models.SubscriptionTerm;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class EnterpriseDetailsInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        EnterpriseDetailsInner model = BinaryData.fromString(
            "{\"saasSubscriptionDetails\":{\"planId\":\"sycbkbfk\",\"offerId\":\"kdkexxp\",\"publisherId\":\"fmxa\",\"term\":{\"termUnit\":\"jpgd\",\"startDate\":\"2021-10-14T19:32:33Z\",\"endDate\":\"2021-05-05T12:18:06Z\"}},\"marketplaceTrialQuota\":{\"availablePromotion\":\"None\",\"grafanaResourceId\":\"pmouexhdz\",\"trialStartAt\":\"2020-12-20T15:16:48Z\",\"trialEndAt\":\"2021-01-24T12:51:28Z\"}}")
            .toObject(EnterpriseDetailsInner.class);
        Assertions.assertEquals("sycbkbfk", model.saasSubscriptionDetails().planId());
        Assertions.assertEquals("kdkexxp", model.saasSubscriptionDetails().offerId());
        Assertions.assertEquals("fmxa", model.saasSubscriptionDetails().publisherId());
        Assertions.assertEquals("jpgd", model.saasSubscriptionDetails().term().termUnit());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-14T19:32:33Z"),
            model.saasSubscriptionDetails().term().startDate());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-05T12:18:06Z"),
            model.saasSubscriptionDetails().term().endDate());
        Assertions.assertEquals(AvailablePromotion.NONE, model.marketplaceTrialQuota().availablePromotion());
        Assertions.assertEquals("pmouexhdz", model.marketplaceTrialQuota().grafanaResourceId());
        Assertions.assertEquals(OffsetDateTime.parse("2020-12-20T15:16:48Z"),
            model.marketplaceTrialQuota().trialStartAt());
        Assertions.assertEquals(OffsetDateTime.parse("2021-01-24T12:51:28Z"),
            model.marketplaceTrialQuota().trialEndAt());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        EnterpriseDetailsInner model = new EnterpriseDetailsInner()
            .withSaasSubscriptionDetails(new SaasSubscriptionDetails().withPlanId("sycbkbfk")
                .withOfferId("kdkexxp")
                .withPublisherId("fmxa")
                .withTerm(new SubscriptionTerm().withTermUnit("jpgd")
                    .withStartDate(OffsetDateTime.parse("2021-10-14T19:32:33Z"))
                    .withEndDate(OffsetDateTime.parse("2021-05-05T12:18:06Z"))))
            .withMarketplaceTrialQuota(new MarketplaceTrialQuota().withAvailablePromotion(AvailablePromotion.NONE)
                .withGrafanaResourceId("pmouexhdz")
                .withTrialStartAt(OffsetDateTime.parse("2020-12-20T15:16:48Z"))
                .withTrialEndAt(OffsetDateTime.parse("2021-01-24T12:51:28Z")));
        model = BinaryData.fromObject(model).toObject(EnterpriseDetailsInner.class);
        Assertions.assertEquals("sycbkbfk", model.saasSubscriptionDetails().planId());
        Assertions.assertEquals("kdkexxp", model.saasSubscriptionDetails().offerId());
        Assertions.assertEquals("fmxa", model.saasSubscriptionDetails().publisherId());
        Assertions.assertEquals("jpgd", model.saasSubscriptionDetails().term().termUnit());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-14T19:32:33Z"),
            model.saasSubscriptionDetails().term().startDate());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-05T12:18:06Z"),
            model.saasSubscriptionDetails().term().endDate());
        Assertions.assertEquals(AvailablePromotion.NONE, model.marketplaceTrialQuota().availablePromotion());
        Assertions.assertEquals("pmouexhdz", model.marketplaceTrialQuota().grafanaResourceId());
        Assertions.assertEquals(OffsetDateTime.parse("2020-12-20T15:16:48Z"),
            model.marketplaceTrialQuota().trialStartAt());
        Assertions.assertEquals(OffsetDateTime.parse("2021-01-24T12:51:28Z"),
            model.marketplaceTrialQuota().trialEndAt());
    }
}
