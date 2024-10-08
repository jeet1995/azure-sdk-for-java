// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.consumption.generated;

/**
 * Samples for PriceSheet GetByBillingPeriod.
 */
public final class PriceSheetGetByBillingPeriodSamples {
    /*
     * x-ms-original-file: specification/consumption/resource-manager/Microsoft.Consumption/stable/2021-10-01/examples/
     * PriceSheetForBillingPeriod.json
     */
    /**
     * Sample code: PriceSheetForBillingPeriod.
     * 
     * @param manager Entry point to ConsumptionManager.
     */
    public static void priceSheetForBillingPeriod(com.azure.resourcemanager.consumption.ConsumptionManager manager) {
        manager.priceSheets()
            .getByBillingPeriodWithResponse("201801", null, null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/consumption/resource-manager/Microsoft.Consumption/stable/2021-10-01/examples/PriceSheetExpand.json
     */
    /**
     * Sample code: PriceSheetExpand.
     * 
     * @param manager Entry point to ConsumptionManager.
     */
    public static void priceSheetExpand(com.azure.resourcemanager.consumption.ConsumptionManager manager) {
        manager.priceSheets()
            .getByBillingPeriodWithResponse("201801", "meterDetails", null, null, com.azure.core.util.Context.NONE);
    }
}
