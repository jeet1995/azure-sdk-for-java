// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DelimitedTextWriteSettings;

public final class DelimitedTextWriteSettingsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DelimitedTextWriteSettings model = BinaryData.fromString(
            "{\"type\":\"DelimitedTextWriteSettings\",\"quoteAllText\":\"datasrje\",\"fileExtension\":\"datavmbh\",\"maxRowsPerFile\":\"datar\",\"fileNamePrefix\":\"datazetsspww\",\"\":{\"rlieeocyarvsfz\":\"dataotbrepe\",\"xzpz\":\"datacscootfsgilwis\",\"trfvogknocshmp\":\"datatust\"}}")
            .toObject(DelimitedTextWriteSettings.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DelimitedTextWriteSettings model = new DelimitedTextWriteSettings().withQuoteAllText("datasrje")
            .withFileExtension("datavmbh")
            .withMaxRowsPerFile("datar")
            .withFileNamePrefix("datazetsspww");
        model = BinaryData.fromObject(model).toObject(DelimitedTextWriteSettings.class);
    }
}
