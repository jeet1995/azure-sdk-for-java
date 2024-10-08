// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.azurestackhci.models.RawCertificateData;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RawCertificateDataTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RawCertificateData model = BinaryData.fromString("{\"certificates\":[\"qhakauhashsf\",\"xosow\",\"xcug\"]}")
            .toObject(RawCertificateData.class);
        Assertions.assertEquals("qhakauhashsf", model.certificates().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RawCertificateData model
            = new RawCertificateData().withCertificates(Arrays.asList("qhakauhashsf", "xosow", "xcug"));
        model = BinaryData.fromObject(model).toObject(RawCertificateData.class);
        Assertions.assertEquals("qhakauhashsf", model.certificates().get(0));
    }
}
