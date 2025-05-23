// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.carbonoptimization.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.carbonoptimization.models.CategoryTypeEnum;
import com.azure.resourcemanager.carbonoptimization.models.ResourceCarbonEmissionTopItemsSummaryData;
import org.junit.jupiter.api.Assertions;

public final class ResourceCarbonEmissionTopItemsSummaryDataTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceCarbonEmissionTopItemsSummaryData model = BinaryData.fromString(
            "{\"dataType\":\"ResourceTopItemsSummaryData\",\"itemName\":\"lwckbasyypnddhs\",\"categoryType\":\"Location\",\"subscriptionId\":\"bacphejko\",\"resourceGroup\":\"ynqgoulzndlikwyq\",\"resourceId\":\"gfgibm\",\"latestMonthEmissions\":20.09751560915065,\"previousMonthEmissions\":30.00180250560771,\"monthOverMonthEmissionsChangeRatio\":66.59647381820668,\"monthlyEmissionsChangeValue\":22.220514848143623}")
            .toObject(ResourceCarbonEmissionTopItemsSummaryData.class);
        Assertions.assertEquals(20.09751560915065, model.latestMonthEmissions());
        Assertions.assertEquals(30.00180250560771, model.previousMonthEmissions());
        Assertions.assertEquals(66.59647381820668D, model.monthOverMonthEmissionsChangeRatio());
        Assertions.assertEquals(22.220514848143623D, model.monthlyEmissionsChangeValue());
        Assertions.assertEquals("lwckbasyypnddhs", model.itemName());
        Assertions.assertEquals(CategoryTypeEnum.LOCATION, model.categoryType());
        Assertions.assertEquals("bacphejko", model.subscriptionId());
        Assertions.assertEquals("ynqgoulzndlikwyq", model.resourceGroup());
        Assertions.assertEquals("gfgibm", model.resourceId());
    }
}
