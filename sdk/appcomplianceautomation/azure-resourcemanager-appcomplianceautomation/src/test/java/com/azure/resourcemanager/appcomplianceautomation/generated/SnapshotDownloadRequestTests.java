// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcomplianceautomation.models.DownloadType;
import com.azure.resourcemanager.appcomplianceautomation.models.SnapshotDownloadRequest;
import org.junit.jupiter.api.Assertions;

public final class SnapshotDownloadRequestTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SnapshotDownloadRequest model = BinaryData.fromString(
            "{\"reportCreatorTenantId\":\"gwfqatmt\",\"downloadType\":\"CompliancePdfReport\",\"offerGuid\":\"mdvy\"}")
            .toObject(SnapshotDownloadRequest.class);
        Assertions.assertEquals("gwfqatmt", model.reportCreatorTenantId());
        Assertions.assertEquals(DownloadType.COMPLIANCE_PDF_REPORT, model.downloadType());
        Assertions.assertEquals("mdvy", model.offerGuid());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SnapshotDownloadRequest model = new SnapshotDownloadRequest().withReportCreatorTenantId("gwfqatmt")
            .withDownloadType(DownloadType.COMPLIANCE_PDF_REPORT)
            .withOfferGuid("mdvy");
        model = BinaryData.fromObject(model).toObject(SnapshotDownloadRequest.class);
        Assertions.assertEquals("gwfqatmt", model.reportCreatorTenantId());
        Assertions.assertEquals(DownloadType.COMPLIANCE_PDF_REPORT, model.downloadType());
        Assertions.assertEquals("mdvy", model.offerGuid());
    }
}
