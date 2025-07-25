// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.models.CustomWebhookAuthenticationManagedIdentity;
import com.azure.resourcemanager.eventgrid.models.CustomWebhookAuthenticationManagedIdentityType;
import org.junit.jupiter.api.Assertions;

public final class CustomWebhookAuthenticationManagedIdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CustomWebhookAuthenticationManagedIdentity model
            = BinaryData.fromString("{\"type\":\"UserAssigned\",\"userAssignedIdentity\":\"ithtywu\"}")
                .toObject(CustomWebhookAuthenticationManagedIdentity.class);
        Assertions.assertEquals(CustomWebhookAuthenticationManagedIdentityType.USER_ASSIGNED, model.type());
        Assertions.assertEquals("ithtywu", model.userAssignedIdentity());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CustomWebhookAuthenticationManagedIdentity model = new CustomWebhookAuthenticationManagedIdentity()
            .withType(CustomWebhookAuthenticationManagedIdentityType.USER_ASSIGNED)
            .withUserAssignedIdentity("ithtywu");
        model = BinaryData.fromObject(model).toObject(CustomWebhookAuthenticationManagedIdentity.class);
        Assertions.assertEquals(CustomWebhookAuthenticationManagedIdentityType.USER_ASSIGNED, model.type());
        Assertions.assertEquals("ithtywu", model.userAssignedIdentity());
    }
}
