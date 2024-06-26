// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.AmqpD2CMessagesNotInAllowedRange;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public final class AmqpD2CMessagesNotInAllowedRangeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AmqpD2CMessagesNotInAllowedRange model = BinaryData.fromString(
            "{\"ruleType\":\"AmqpD2CMessagesNotInAllowedRange\",\"timeWindowSize\":\"PT19H48M3S\",\"minThreshold\":1488182532,\"maxThreshold\":952701010,\"displayName\":\"dtfobvfi\",\"description\":\"x\",\"isEnabled\":false}")
            .toObject(AmqpD2CMessagesNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(1488182532, model.minThreshold());
        Assertions.assertEquals(952701010, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT19H48M3S"), model.timeWindowSize());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AmqpD2CMessagesNotInAllowedRange model = new AmqpD2CMessagesNotInAllowedRange().withIsEnabled(false)
            .withMinThreshold(1488182532)
            .withMaxThreshold(952701010)
            .withTimeWindowSize(Duration.parse("PT19H48M3S"));
        model = BinaryData.fromObject(model).toObject(AmqpD2CMessagesNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(1488182532, model.minThreshold());
        Assertions.assertEquals(952701010, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT19H48M3S"), model.timeWindowSize());
    }
}
