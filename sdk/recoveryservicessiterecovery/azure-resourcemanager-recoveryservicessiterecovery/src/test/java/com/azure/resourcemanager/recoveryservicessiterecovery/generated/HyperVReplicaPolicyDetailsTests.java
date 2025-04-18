// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.HyperVReplicaPolicyDetails;
import org.junit.jupiter.api.Assertions;

public final class HyperVReplicaPolicyDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        HyperVReplicaPolicyDetails model = BinaryData.fromString(
            "{\"instanceType\":\"HyperVReplica2012\",\"recoveryPoints\":1458640473,\"applicationConsistentSnapshotFrequencyInHours\":1422455142,\"compression\":\"gnzuzpbgkzcsc\",\"initialReplicationMethod\":\"uzvkunhdimjuk\",\"onlineReplicationStartTime\":\"r\",\"offlineReplicationImportPath\":\"a\",\"offlineReplicationExportPath\":\"pucdocf\",\"replicationPort\":1596172374,\"allowedAuthenticationType\":657887640,\"replicaDeletionOption\":\"f\"}")
            .toObject(HyperVReplicaPolicyDetails.class);
        Assertions.assertEquals(1458640473, model.recoveryPoints());
        Assertions.assertEquals(1422455142, model.applicationConsistentSnapshotFrequencyInHours());
        Assertions.assertEquals("gnzuzpbgkzcsc", model.compression());
        Assertions.assertEquals("uzvkunhdimjuk", model.initialReplicationMethod());
        Assertions.assertEquals("r", model.onlineReplicationStartTime());
        Assertions.assertEquals("a", model.offlineReplicationImportPath());
        Assertions.assertEquals("pucdocf", model.offlineReplicationExportPath());
        Assertions.assertEquals(1596172374, model.replicationPort());
        Assertions.assertEquals(657887640, model.allowedAuthenticationType());
        Assertions.assertEquals("f", model.replicaDeletionOption());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        HyperVReplicaPolicyDetails model = new HyperVReplicaPolicyDetails().withRecoveryPoints(1458640473)
            .withApplicationConsistentSnapshotFrequencyInHours(1422455142)
            .withCompression("gnzuzpbgkzcsc")
            .withInitialReplicationMethod("uzvkunhdimjuk")
            .withOnlineReplicationStartTime("r")
            .withOfflineReplicationImportPath("a")
            .withOfflineReplicationExportPath("pucdocf")
            .withReplicationPort(1596172374)
            .withAllowedAuthenticationType(657887640)
            .withReplicaDeletionOption("f");
        model = BinaryData.fromObject(model).toObject(HyperVReplicaPolicyDetails.class);
        Assertions.assertEquals(1458640473, model.recoveryPoints());
        Assertions.assertEquals(1422455142, model.applicationConsistentSnapshotFrequencyInHours());
        Assertions.assertEquals("gnzuzpbgkzcsc", model.compression());
        Assertions.assertEquals("uzvkunhdimjuk", model.initialReplicationMethod());
        Assertions.assertEquals("r", model.onlineReplicationStartTime());
        Assertions.assertEquals("a", model.offlineReplicationImportPath());
        Assertions.assertEquals("pucdocf", model.offlineReplicationExportPath());
        Assertions.assertEquals(1596172374, model.replicationPort());
        Assertions.assertEquals(657887640, model.allowedAuthenticationType());
        Assertions.assertEquals("f", model.replicaDeletionOption());
    }
}
