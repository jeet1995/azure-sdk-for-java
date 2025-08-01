// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.models.PartnerClientAuthentication;
import com.azure.resourcemanager.eventgrid.models.WebhookUpdatePartnerDestinationInfo;
import org.junit.jupiter.api.Assertions;

public final class WebhookUpdatePartnerDestinationInfoTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WebhookUpdatePartnerDestinationInfo model = BinaryData.fromString(
            "{\"endpointType\":\"WebHook\",\"properties\":{\"endpointUrl\":\"bxrqrkijp\",\"endpointBaseUrl\":\"qlsdxeqztvxwmw\",\"clientAuthentication\":{\"clientAuthenticationType\":\"PartnerClientAuthentication\"}}}")
            .toObject(WebhookUpdatePartnerDestinationInfo.class);
        Assertions.assertEquals("bxrqrkijp", model.endpointUrl());
        Assertions.assertEquals("qlsdxeqztvxwmw", model.endpointBaseUrl());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WebhookUpdatePartnerDestinationInfo model
            = new WebhookUpdatePartnerDestinationInfo().withEndpointUrl("bxrqrkijp")
                .withEndpointBaseUrl("qlsdxeqztvxwmw")
                .withClientAuthentication(new PartnerClientAuthentication());
        model = BinaryData.fromObject(model).toObject(WebhookUpdatePartnerDestinationInfo.class);
        Assertions.assertEquals("bxrqrkijp", model.endpointUrl());
        Assertions.assertEquals("qlsdxeqztvxwmw", model.endpointBaseUrl());
    }
}
