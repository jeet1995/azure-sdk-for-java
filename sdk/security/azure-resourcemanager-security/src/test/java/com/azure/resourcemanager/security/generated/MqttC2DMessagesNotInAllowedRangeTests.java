// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.MqttC2DMessagesNotInAllowedRange;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public final class MqttC2DMessagesNotInAllowedRangeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MqttC2DMessagesNotInAllowedRange model = BinaryData.fromString(
            "{\"ruleType\":\"MqttC2DMessagesNotInAllowedRange\",\"timeWindowSize\":\"PT23H17M16S\",\"minThreshold\":236093900,\"maxThreshold\":1021346553,\"displayName\":\"b\",\"description\":\"ckgk\",\"isEnabled\":false}")
            .toObject(MqttC2DMessagesNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(236093900, model.minThreshold());
        Assertions.assertEquals(1021346553, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT23H17M16S"), model.timeWindowSize());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MqttC2DMessagesNotInAllowedRange model = new MqttC2DMessagesNotInAllowedRange().withIsEnabled(false)
            .withMinThreshold(236093900)
            .withMaxThreshold(1021346553)
            .withTimeWindowSize(Duration.parse("PT23H17M16S"));
        model = BinaryData.fromObject(model).toObject(MqttC2DMessagesNotInAllowedRange.class);
        Assertions.assertEquals(false, model.isEnabled());
        Assertions.assertEquals(236093900, model.minThreshold());
        Assertions.assertEquals(1021346553, model.maxThreshold());
        Assertions.assertEquals(Duration.parse("PT23H17M16S"), model.timeWindowSize());
    }
}
