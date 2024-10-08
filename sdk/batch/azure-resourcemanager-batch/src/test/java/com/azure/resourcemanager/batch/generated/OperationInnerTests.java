// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.batch.fluent.models.OperationInner;
import com.azure.resourcemanager.batch.models.OperationDisplay;
import org.junit.jupiter.api.Assertions;

public final class OperationInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OperationInner model = BinaryData.fromString(
            "{\"name\":\"pusuesn\",\"isDataAction\":false,\"display\":{\"provider\":\"bavo\",\"operation\":\"zdmohctbqvu\",\"resource\":\"xdn\",\"description\":\"vo\"},\"origin\":\"ujjugwdkcglh\",\"properties\":\"dataazjdyggd\"}")
            .toObject(OperationInner.class);
        Assertions.assertEquals("pusuesn", model.name());
        Assertions.assertEquals(false, model.isDataAction());
        Assertions.assertEquals("bavo", model.display().provider());
        Assertions.assertEquals("zdmohctbqvu", model.display().operation());
        Assertions.assertEquals("xdn", model.display().resource());
        Assertions.assertEquals("vo", model.display().description());
        Assertions.assertEquals("ujjugwdkcglh", model.origin());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OperationInner model = new OperationInner().withName("pusuesn")
            .withIsDataAction(false)
            .withDisplay(new OperationDisplay().withProvider("bavo")
                .withOperation("zdmohctbqvu")
                .withResource("xdn")
                .withDescription("vo"))
            .withOrigin("ujjugwdkcglh")
            .withProperties("dataazjdyggd");
        model = BinaryData.fromObject(model).toObject(OperationInner.class);
        Assertions.assertEquals("pusuesn", model.name());
        Assertions.assertEquals(false, model.isDataAction());
        Assertions.assertEquals("bavo", model.display().provider());
        Assertions.assertEquals("zdmohctbqvu", model.display().operation());
        Assertions.assertEquals("xdn", model.display().resource());
        Assertions.assertEquals("vo", model.display().description());
        Assertions.assertEquals("ujjugwdkcglh", model.origin());
    }
}
