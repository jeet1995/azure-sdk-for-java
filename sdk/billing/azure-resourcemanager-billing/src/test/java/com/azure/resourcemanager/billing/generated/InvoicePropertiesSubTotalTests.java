// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.billing.models.InvoicePropertiesSubTotal;

public final class InvoicePropertiesSubTotalTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        InvoicePropertiesSubTotal model = BinaryData.fromString("{\"currency\":\"ebgvo\",\"value\":0.98296404}")
            .toObject(InvoicePropertiesSubTotal.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        InvoicePropertiesSubTotal model = new InvoicePropertiesSubTotal();
        model = BinaryData.fromObject(model).toObject(InvoicePropertiesSubTotal.class);
    }
}
