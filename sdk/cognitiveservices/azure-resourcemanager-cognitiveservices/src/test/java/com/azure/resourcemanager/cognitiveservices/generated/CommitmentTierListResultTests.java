// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.models.CommitmentTierListResult;
import org.junit.jupiter.api.Assertions;

public final class CommitmentTierListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CommitmentTierListResult model = BinaryData.fromString(
            "{\"nextLink\":\"ugicjooxdjebw\",\"value\":[{\"kind\":\"wfvovbv\",\"skuName\":\"uecivyhz\",\"hostingModel\":\"ConnectedContainer\",\"planType\":\"jgjrwjueiotwm\",\"tier\":\"ytdxwit\",\"maxCount\":1070997174,\"quota\":{\"quantity\":8610191053119914796,\"unit\":\"wgxhn\"},\"cost\":{\"commitmentMeterId\":\"x\",\"overageMeterId\":\"kpycgklwndnhjd\"}},{\"kind\":\"whvylw\",\"skuName\":\"tdhxujznbmpowuwp\",\"hostingModel\":\"ProvisionedWeb\",\"planType\":\"veual\",\"tier\":\"j\",\"maxCount\":1318602789,\"quota\":{\"quantity\":4407430111323762488,\"unit\":\"cswsrtjri\"},\"cost\":{\"commitmentMeterId\":\"bpbewtghfgb\",\"overageMeterId\":\"gw\"}},{\"kind\":\"vlvqhjkbegi\",\"skuName\":\"nmxiebwwaloayqc\",\"hostingModel\":\"ConnectedContainer\",\"planType\":\"zjuzgwyz\",\"tier\":\"txon\",\"maxCount\":351214213,\"quota\":{\"quantity\":5974631066556953199,\"unit\":\"bp\"},\"cost\":{\"commitmentMeterId\":\"p\",\"overageMeterId\":\"knftguvriuh\"}}]}")
            .toObject(CommitmentTierListResult.class);
        Assertions.assertEquals("ugicjooxdjebw", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CommitmentTierListResult model = new CommitmentTierListResult().withNextLink("ugicjooxdjebw");
        model = BinaryData.fromObject(model).toObject(CommitmentTierListResult.class);
        Assertions.assertEquals("ugicjooxdjebw", model.nextLink());
    }
}
