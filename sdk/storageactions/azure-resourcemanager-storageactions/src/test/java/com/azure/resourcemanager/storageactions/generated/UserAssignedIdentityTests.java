// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.storageactions.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.storageactions.models.UserAssignedIdentity;

public final class UserAssignedIdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UserAssignedIdentity model = BinaryData.fromString("{\"principalId\":\"k\",\"clientId\":\"yxolniwp\"}")
            .toObject(UserAssignedIdentity.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UserAssignedIdentity model = new UserAssignedIdentity();
        model = BinaryData.fromObject(model).toObject(UserAssignedIdentity.class);
    }
}
