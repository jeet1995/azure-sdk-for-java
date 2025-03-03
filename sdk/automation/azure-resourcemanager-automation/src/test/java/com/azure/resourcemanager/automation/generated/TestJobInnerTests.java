// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.automation.fluent.models.TestJobInner;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class TestJobInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TestJobInner model = BinaryData.fromString(
            "{\"creationTime\":\"2021-04-23T02:57:06Z\",\"status\":\"uteyxeyguq\",\"statusDetails\":\"ijiitns\",\"runOn\":\"lz\",\"startTime\":\"2021-04-11T11:02:56Z\",\"endTime\":\"2021-03-13T19:19:28Z\",\"exception\":\"ijwai\",\"lastModifiedTime\":\"2021-10-31T08:28:43Z\",\"lastStatusModifiedTime\":\"2021-09-15T09:28:49Z\",\"parameters\":{\"qfrojsydgrhyd\":\"bfu\",\"skieca\":\"ygywe\",\"ixqcahyhxalybxaw\":\"ygzmxieqvdsmak\",\"jodqhykincn\":\"ijpodtblxpkkwj\"},\"logActivityTrace\":723205637}")
            .toObject(TestJobInner.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-23T02:57:06Z"), model.creationTime());
        Assertions.assertEquals("uteyxeyguq", model.status());
        Assertions.assertEquals("ijiitns", model.statusDetails());
        Assertions.assertEquals("lz", model.runOn());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-11T11:02:56Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-13T19:19:28Z"), model.endTime());
        Assertions.assertEquals("ijwai", model.exception());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-31T08:28:43Z"), model.lastModifiedTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-15T09:28:49Z"), model.lastStatusModifiedTime());
        Assertions.assertEquals("bfu", model.parameters().get("qfrojsydgrhyd"));
        Assertions.assertEquals(723205637, model.logActivityTrace());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TestJobInner model = new TestJobInner().withCreationTime(OffsetDateTime.parse("2021-04-23T02:57:06Z"))
            .withStatus("uteyxeyguq")
            .withStatusDetails("ijiitns")
            .withRunOn("lz")
            .withStartTime(OffsetDateTime.parse("2021-04-11T11:02:56Z"))
            .withEndTime(OffsetDateTime.parse("2021-03-13T19:19:28Z"))
            .withException("ijwai")
            .withLastModifiedTime(OffsetDateTime.parse("2021-10-31T08:28:43Z"))
            .withLastStatusModifiedTime(OffsetDateTime.parse("2021-09-15T09:28:49Z"))
            .withParameters(mapOf("qfrojsydgrhyd", "bfu", "skieca", "ygywe", "ixqcahyhxalybxaw", "ygzmxieqvdsmak",
                "jodqhykincn", "ijpodtblxpkkwj"))
            .withLogActivityTrace(723205637);
        model = BinaryData.fromObject(model).toObject(TestJobInner.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-23T02:57:06Z"), model.creationTime());
        Assertions.assertEquals("uteyxeyguq", model.status());
        Assertions.assertEquals("ijiitns", model.statusDetails());
        Assertions.assertEquals("lz", model.runOn());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-11T11:02:56Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-13T19:19:28Z"), model.endTime());
        Assertions.assertEquals("ijwai", model.exception());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-31T08:28:43Z"), model.lastModifiedTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-15T09:28:49Z"), model.lastStatusModifiedTime());
        Assertions.assertEquals("bfu", model.parameters().get("qfrojsydgrhyd"));
        Assertions.assertEquals(723205637, model.logActivityTrace());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
