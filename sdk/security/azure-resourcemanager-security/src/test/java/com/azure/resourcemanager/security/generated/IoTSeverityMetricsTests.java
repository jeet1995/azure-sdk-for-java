// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.IoTSeverityMetrics;
import org.junit.jupiter.api.Assertions;

public final class IoTSeverityMetricsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IoTSeverityMetrics model = BinaryData
            .fromString("{\"high\":6549908751821876892,\"medium\":914612677751220292,\"low\":1656220423281189334}")
            .toObject(IoTSeverityMetrics.class);
        Assertions.assertEquals(6549908751821876892L, model.high());
        Assertions.assertEquals(914612677751220292L, model.medium());
        Assertions.assertEquals(1656220423281189334L, model.low());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IoTSeverityMetrics model = new IoTSeverityMetrics().withHigh(6549908751821876892L)
            .withMedium(914612677751220292L)
            .withLow(1656220423281189334L);
        model = BinaryData.fromObject(model).toObject(IoTSeverityMetrics.class);
        Assertions.assertEquals(6549908751821876892L, model.high());
        Assertions.assertEquals(914612677751220292L, model.medium());
        Assertions.assertEquals(1656220423281189334L, model.low());
    }
}
