// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresql.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.postgresql.models.PrivateLinkServiceConnectionStateStatus;
import com.azure.resourcemanager.postgresql.models.ServerPrivateLinkServiceConnectionStateProperty;
import org.junit.jupiter.api.Assertions;

public final class ServerPrivateLinkServiceConnectionStatePropertyTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ServerPrivateLinkServiceConnectionStateProperty model = BinaryData
            .fromString(
                "{\"status\":\"Disconnected\",\"description\":\"lxofpdvhpfxxypin\",\"actionsRequired\":\"None\"}")
            .toObject(ServerPrivateLinkServiceConnectionStateProperty.class);
        Assertions.assertEquals(PrivateLinkServiceConnectionStateStatus.DISCONNECTED, model.status());
        Assertions.assertEquals("lxofpdvhpfxxypin", model.description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ServerPrivateLinkServiceConnectionStateProperty model = new ServerPrivateLinkServiceConnectionStateProperty()
            .withStatus(PrivateLinkServiceConnectionStateStatus.DISCONNECTED)
            .withDescription("lxofpdvhpfxxypin");
        model = BinaryData.fromObject(model).toObject(ServerPrivateLinkServiceConnectionStateProperty.class);
        Assertions.assertEquals(PrivateLinkServiceConnectionStateStatus.DISCONNECTED, model.status());
        Assertions.assertEquals("lxofpdvhpfxxypin", model.description());
    }
}
