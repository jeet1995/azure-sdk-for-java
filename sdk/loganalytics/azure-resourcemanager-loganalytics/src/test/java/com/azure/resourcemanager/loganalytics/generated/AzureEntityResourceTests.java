// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.loganalytics.models.AzureEntityResource;

public final class AzureEntityResourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AzureEntityResource model = BinaryData
            .fromString("{\"etag\":\"slbi\",\"id\":\"kojgcyzts\",\"name\":\"mznbaeqphch\",\"type\":\"nrnrp\"}")
            .toObject(AzureEntityResource.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AzureEntityResource model = new AzureEntityResource();
        model = BinaryData.fromObject(model).toObject(AzureEntityResource.class);
    }
}
