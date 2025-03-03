// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.ConnectToSourceNonSqlTaskOutput;

public final class ConnectToSourceNonSqlTaskOutputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ConnectToSourceNonSqlTaskOutput model = BinaryData.fromString(
            "{\"id\":\"w\",\"sourceServerBrandVersion\":\"sjttgzfbish\",\"serverProperties\":{\"serverPlatform\":\"hajdeyeamdpha\",\"serverName\":\"lpbuxwgipwhonowk\",\"serverVersion\":\"hwankixzbinjepu\",\"serverEdition\":\"mryw\",\"serverOperatingSystemVersion\":\"zoqftiyqzrnkcqvy\",\"serverDatabaseCount\":798441434},\"databases\":[\"lsicohoqqnwv\",\"ryavwhheunmmqh\"],\"validationErrors\":[{\"message\":\"konocu\",\"actionableMessage\":\"klyaxuconu\",\"filePath\":\"zf\",\"lineNumber\":\"eyp\",\"hResult\":1039817033,\"stackTrace\":\"jmwvvj\"}]}")
            .toObject(ConnectToSourceNonSqlTaskOutput.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ConnectToSourceNonSqlTaskOutput model = new ConnectToSourceNonSqlTaskOutput();
        model = BinaryData.fromObject(model).toObject(ConnectToSourceNonSqlTaskOutput.class);
    }
}
