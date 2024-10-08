// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurestackhci.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.azurestackhci.fluent.models.OperationListResultInner;

public final class OperationListResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        OperationListResultInner model = BinaryData.fromString(
            "{\"value\":[{\"name\":\"qvgqouw\",\"isDataAction\":false,\"display\":{\"provider\":\"j\",\"resource\":\"ivqikfxcvhr\",\"operation\":\"phuagrttikteusq\",\"description\":\"kvyklxubyjaffmm\"},\"origin\":\"user\",\"actionType\":\"Internal\"},{\"name\":\"u\",\"isDataAction\":true,\"display\":{\"provider\":\"brta\",\"resource\":\"etttwgdslqxihhr\",\"operation\":\"oi\",\"description\":\"seypxiutcxapz\"},\"origin\":\"system\",\"actionType\":\"Internal\"},{\"name\":\"o\",\"isDataAction\":false,\"display\":{\"provider\":\"xslhvnhlabrqnkk\",\"resource\":\"cjbtrgaehvvib\",\"operation\":\"jj\",\"description\":\"oqbeitpkxzt\"},\"origin\":\"user\",\"actionType\":\"Internal\"}],\"nextLink\":\"ft\"}")
            .toObject(OperationListResultInner.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        OperationListResultInner model = new OperationListResultInner();
        model = BinaryData.fromObject(model).toObject(OperationListResultInner.class);
    }
}
