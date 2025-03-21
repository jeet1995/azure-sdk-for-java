// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.quota.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.quota.models.GroupQuotaSubscriptionRequestStatusProperties;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class GroupQuotaSubscriptionRequestStatusPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        GroupQuotaSubscriptionRequestStatusProperties model = BinaryData.fromString(
            "{\"subscriptionId\":\"ahbc\",\"requestSubmitTime\":\"2021-05-25T21:39:12Z\",\"provisioningState\":\"Created\"}")
            .toObject(GroupQuotaSubscriptionRequestStatusProperties.class);
        Assertions.assertEquals("ahbc", model.subscriptionId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-25T21:39:12Z"), model.requestSubmitTime());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        GroupQuotaSubscriptionRequestStatusProperties model
            = new GroupQuotaSubscriptionRequestStatusProperties().withSubscriptionId("ahbc")
                .withRequestSubmitTime(OffsetDateTime.parse("2021-05-25T21:39:12Z"));
        model = BinaryData.fromObject(model).toObject(GroupQuotaSubscriptionRequestStatusProperties.class);
        Assertions.assertEquals("ahbc", model.subscriptionId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-25T21:39:12Z"), model.requestSubmitTime());
    }
}
