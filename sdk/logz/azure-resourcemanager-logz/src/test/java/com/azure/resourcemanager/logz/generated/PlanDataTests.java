// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logz.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.logz.models.PlanData;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class PlanDataTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PlanData model = BinaryData.fromString(
            "{\"usageType\":\"zao\",\"billingCycle\":\"uhrhcffcyddgl\",\"planDetails\":\"t\",\"effectiveDate\":\"2021-10-12T12:36:35Z\"}")
            .toObject(PlanData.class);
        Assertions.assertEquals("zao", model.usageType());
        Assertions.assertEquals("uhrhcffcyddgl", model.billingCycle());
        Assertions.assertEquals("t", model.planDetails());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-12T12:36:35Z"), model.effectiveDate());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PlanData model = new PlanData().withUsageType("zao")
            .withBillingCycle("uhrhcffcyddgl")
            .withPlanDetails("t")
            .withEffectiveDate(OffsetDateTime.parse("2021-10-12T12:36:35Z"));
        model = BinaryData.fromObject(model).toObject(PlanData.class);
        Assertions.assertEquals("zao", model.usageType());
        Assertions.assertEquals("uhrhcffcyddgl", model.billingCycle());
        Assertions.assertEquals("t", model.planDetails());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-12T12:36:35Z"), model.effectiveDate());
    }
}
