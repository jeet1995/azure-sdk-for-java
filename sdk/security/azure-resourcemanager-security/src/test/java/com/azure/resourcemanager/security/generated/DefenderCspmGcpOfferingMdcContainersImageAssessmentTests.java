// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.DefenderCspmGcpOfferingMdcContainersImageAssessment;
import org.junit.jupiter.api.Assertions;

public final class DefenderCspmGcpOfferingMdcContainersImageAssessmentTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DefenderCspmGcpOfferingMdcContainersImageAssessment model = BinaryData.fromString(
            "{\"enabled\":false,\"workloadIdentityProviderId\":\"gchzpgfqumj\",\"serviceAccountEmailAddress\":\"xhzghgodkynr\"}")
            .toObject(DefenderCspmGcpOfferingMdcContainersImageAssessment.class);
        Assertions.assertEquals(false, model.enabled());
        Assertions.assertEquals("gchzpgfqumj", model.workloadIdentityProviderId());
        Assertions.assertEquals("xhzghgodkynr", model.serviceAccountEmailAddress());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DefenderCspmGcpOfferingMdcContainersImageAssessment model
            = new DefenderCspmGcpOfferingMdcContainersImageAssessment().withEnabled(false)
                .withWorkloadIdentityProviderId("gchzpgfqumj")
                .withServiceAccountEmailAddress("xhzghgodkynr");
        model = BinaryData.fromObject(model).toObject(DefenderCspmGcpOfferingMdcContainersImageAssessment.class);
        Assertions.assertEquals(false, model.enabled());
        Assertions.assertEquals("gchzpgfqumj", model.workloadIdentityProviderId());
        Assertions.assertEquals("xhzghgodkynr", model.serviceAccountEmailAddress());
    }
}
