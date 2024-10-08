// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.healthdataaiservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.healthdataaiservices.fluent.models.PrivateEndpointConnectionResourceInner;
import com.azure.resourcemanager.healthdataaiservices.models.PrivateEndpoint;
import com.azure.resourcemanager.healthdataaiservices.models.PrivateEndpointConnectionProperties;
import com.azure.resourcemanager.healthdataaiservices.models.PrivateEndpointServiceConnectionStatus;
import com.azure.resourcemanager.healthdataaiservices.models.PrivateLinkServiceConnectionState;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointConnectionResourceInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointConnectionResourceInner model = BinaryData.fromString(
            "{\"properties\":{\"groupIds\":[\"vvtpgvdfgio\",\"kftutqxlngxlefg\",\"gnxkrxdqmidtth\"],\"privateEndpoint\":{\"id\":\"qdrabhjybigehoqf\"},\"privateLinkServiceConnectionState\":{\"status\":\"Approved\",\"description\":\"kanyktzlcuiywg\",\"actionsRequired\":\"wgndrvynhzgpp\"},\"provisioningState\":\"Deleting\"},\"id\":\"yncocpecfvmmcoo\",\"name\":\"sxlzevgbmqj\",\"type\":\"abcypmivk\"}")
            .toObject(PrivateEndpointConnectionResourceInner.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.APPROVED,
            model.properties().privateLinkServiceConnectionState().status());
        Assertions.assertEquals("kanyktzlcuiywg", model.properties().privateLinkServiceConnectionState().description());
        Assertions.assertEquals("wgndrvynhzgpp",
            model.properties().privateLinkServiceConnectionState().actionsRequired());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrivateEndpointConnectionResourceInner model
            = new PrivateEndpointConnectionResourceInner()
                .withProperties(new PrivateEndpointConnectionProperties().withPrivateEndpoint(new PrivateEndpoint())
                    .withPrivateLinkServiceConnectionState(new PrivateLinkServiceConnectionState()
                        .withStatus(PrivateEndpointServiceConnectionStatus.APPROVED)
                        .withDescription("kanyktzlcuiywg")
                        .withActionsRequired("wgndrvynhzgpp")));
        model = BinaryData.fromObject(model).toObject(PrivateEndpointConnectionResourceInner.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.APPROVED,
            model.properties().privateLinkServiceConnectionState().status());
        Assertions.assertEquals("kanyktzlcuiywg", model.properties().privateLinkServiceConnectionState().description());
        Assertions.assertEquals("wgndrvynhzgpp",
            model.properties().privateLinkServiceConnectionState().actionsRequired());
    }
}
