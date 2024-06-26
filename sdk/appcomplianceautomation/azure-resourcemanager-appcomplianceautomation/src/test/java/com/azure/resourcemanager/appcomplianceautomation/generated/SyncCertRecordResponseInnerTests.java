// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcomplianceautomation.fluent.models.SyncCertRecordResponseInner;
import org.junit.jupiter.api.Assertions;

public final class SyncCertRecordResponseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SyncCertRecordResponseInner model = BinaryData.fromString(
            "{\"certRecord\":{\"offerGuid\":\"f\",\"certificationStatus\":\"esgogc\",\"ingestionStatus\":\"onnxkrlgnyhm\",\"controls\":[{\"controlId\":\"kkgthr\",\"controlStatus\":\"hxjbdhqxvc\"},{\"controlId\":\"frpdsofbshrns\",\"controlStatus\":\"uswdv\"}]}}")
            .toObject(SyncCertRecordResponseInner.class);
        Assertions.assertEquals("f", model.certRecord().offerGuid());
        Assertions.assertEquals("esgogc", model.certRecord().certificationStatus());
        Assertions.assertEquals("onnxkrlgnyhm", model.certRecord().ingestionStatus());
        Assertions.assertEquals("kkgthr", model.certRecord().controls().get(0).controlId());
        Assertions.assertEquals("hxjbdhqxvc", model.certRecord().controls().get(0).controlStatus());
    }
}
