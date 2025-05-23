// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicenetworking.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicenetworking.implementation.models.AssociationListResult;
import com.azure.resourcemanager.servicenetworking.models.AssociationType;
import org.junit.jupiter.api.Assertions;

public final class AssociationListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AssociationListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"associationType\":\"subnets\",\"subnet\":{\"id\":\"j\"},\"provisioningState\":\"Accepted\"},\"location\":\"kwm\",\"tags\":{\"psqucmpoyf\":\"tsizntocipaoua\",\"knygjofjddeq\":\"kfo\",\"upewnwreitjzy\":\"rd\",\"ofcqhsm\":\"lusarh\"},\"id\":\"urkdtmlx\",\"name\":\"ekuksjtx\",\"type\":\"kc\"}],\"nextLink\":\"parcry\"}")
            .toObject(AssociationListResult.class);
        Assertions.assertEquals("kwm", model.value().get(0).location());
        Assertions.assertEquals("tsizntocipaoua", model.value().get(0).tags().get("psqucmpoyf"));
        Assertions.assertEquals(AssociationType.SUBNETS, model.value().get(0).properties().associationType());
        Assertions.assertEquals("j", model.value().get(0).properties().subnet().id());
        Assertions.assertEquals("parcry", model.nextLink());
    }
}
