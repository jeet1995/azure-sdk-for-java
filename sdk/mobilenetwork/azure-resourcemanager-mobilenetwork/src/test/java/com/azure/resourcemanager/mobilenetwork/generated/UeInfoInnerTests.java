// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mobilenetwork.fluent.models.UeInfoInner;
import com.azure.resourcemanager.mobilenetwork.models.DnnIpPair;
import com.azure.resourcemanager.mobilenetwork.models.RatType;
import com.azure.resourcemanager.mobilenetwork.models.UeInfoPropertiesFormat;
import com.azure.resourcemanager.mobilenetwork.models.UeIpAddress;
import com.azure.resourcemanager.mobilenetwork.models.UeState;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class UeInfoInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UeInfoInner model = BinaryData.fromString(
            "{\"properties\":{\"ratType\":\"4G\",\"ueState\":\"Detached\",\"ueIpAddresses\":[{\"dnn\":\"kmfx\",\"ueIpAddress\":{\"ipV4Addr\":\"wogqqnobpudcdab\"}}],\"lastReadAt\":\"2021-07-29T09:39:50Z\"},\"id\":\"wyawbzasqbuc\",\"name\":\"jg\",\"type\":\"yexaoguy\"}")
            .toObject(UeInfoInner.class);
        Assertions.assertEquals(RatType.FOURG, model.properties().ratType());
        Assertions.assertEquals(UeState.DETACHED, model.properties().ueState());
        Assertions.assertEquals("kmfx", model.properties().ueIpAddresses().get(0).dnn());
        Assertions.assertEquals("wogqqnobpudcdab", model.properties().ueIpAddresses().get(0).ueIpAddress().ipV4Addr());
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-29T09:39:50Z"), model.properties().lastReadAt());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UeInfoInner model = new UeInfoInner().withProperties(new UeInfoPropertiesFormat().withRatType(RatType.FOURG)
            .withUeState(UeState.DETACHED)
            .withUeIpAddresses(Arrays.asList(
                new DnnIpPair().withDnn("kmfx").withUeIpAddress(new UeIpAddress().withIpV4Addr("wogqqnobpudcdab"))))
            .withLastReadAt(OffsetDateTime.parse("2021-07-29T09:39:50Z")));
        model = BinaryData.fromObject(model).toObject(UeInfoInner.class);
        Assertions.assertEquals(RatType.FOURG, model.properties().ratType());
        Assertions.assertEquals(UeState.DETACHED, model.properties().ueState());
        Assertions.assertEquals("kmfx", model.properties().ueIpAddresses().get(0).dnn());
        Assertions.assertEquals("wogqqnobpudcdab", model.properties().ueIpAddresses().get(0).ueIpAddress().ipV4Addr());
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-29T09:39:50Z"), model.properties().lastReadAt());
    }
}
