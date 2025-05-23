// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.CreateProtectionContainerMappingInput;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.CreateProtectionContainerMappingInputProperties;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.ReplicationProviderSpecificContainerMappingInput;
import org.junit.jupiter.api.Assertions;

public final class CreateProtectionContainerMappingInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CreateProtectionContainerMappingInput model = BinaryData.fromString(
            "{\"properties\":{\"targetProtectionContainerId\":\"aimlnwiaaom\",\"policyId\":\"weazul\",\"providerSpecificInput\":{\"instanceType\":\"ReplicationProviderSpecificContainerMappingInput\"}}}")
            .toObject(CreateProtectionContainerMappingInput.class);
        Assertions.assertEquals("aimlnwiaaom", model.properties().targetProtectionContainerId());
        Assertions.assertEquals("weazul", model.properties().policyId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CreateProtectionContainerMappingInput model = new CreateProtectionContainerMappingInput().withProperties(
            new CreateProtectionContainerMappingInputProperties().withTargetProtectionContainerId("aimlnwiaaom")
                .withPolicyId("weazul")
                .withProviderSpecificInput(new ReplicationProviderSpecificContainerMappingInput()));
        model = BinaryData.fromObject(model).toObject(CreateProtectionContainerMappingInput.class);
        Assertions.assertEquals("aimlnwiaaom", model.properties().targetProtectionContainerId());
        Assertions.assertEquals("weazul", model.properties().policyId());
    }
}
