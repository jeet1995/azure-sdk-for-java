// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.fluent.models.FeaturesetVersionBackfillResponseInner;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class FeaturesetVersionBackfillResponseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FeaturesetVersionBackfillResponseInner model
            = BinaryData.fromString("{\"jobIds\":[\"ygvoavyunssxlgh\",\"ee\",\"jlgvvpase\",\"sgb\"]}")
                .toObject(FeaturesetVersionBackfillResponseInner.class);
        Assertions.assertEquals("ygvoavyunssxlgh", model.jobIds().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FeaturesetVersionBackfillResponseInner model = new FeaturesetVersionBackfillResponseInner()
            .withJobIds(Arrays.asList("ygvoavyunssxlgh", "ee", "jlgvvpase", "sgb"));
        model = BinaryData.fromObject(model).toObject(FeaturesetVersionBackfillResponseInner.class);
        Assertions.assertEquals("ygvoavyunssxlgh", model.jobIds().get(0));
    }
}
