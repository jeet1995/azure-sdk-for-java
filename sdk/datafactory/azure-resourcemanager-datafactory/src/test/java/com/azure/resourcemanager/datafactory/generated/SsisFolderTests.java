// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.SsisFolder;
import org.junit.jupiter.api.Assertions;

public final class SsisFolderTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SsisFolder model = BinaryData
            .fromString(
                "{\"type\":\"Folder\",\"id\":675766868795663943,\"name\":\"mkqbylbbnjldicq\",\"description\":\"a\"}")
            .toObject(SsisFolder.class);
        Assertions.assertEquals(675766868795663943L, model.id());
        Assertions.assertEquals("mkqbylbbnjldicq", model.name());
        Assertions.assertEquals("a", model.description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SsisFolder model
            = new SsisFolder().withId(675766868795663943L).withName("mkqbylbbnjldicq").withDescription("a");
        model = BinaryData.fromObject(model).toObject(SsisFolder.class);
        Assertions.assertEquals(675766868795663943L, model.id());
        Assertions.assertEquals("mkqbylbbnjldicq", model.name());
        Assertions.assertEquals("a", model.description());
    }
}
