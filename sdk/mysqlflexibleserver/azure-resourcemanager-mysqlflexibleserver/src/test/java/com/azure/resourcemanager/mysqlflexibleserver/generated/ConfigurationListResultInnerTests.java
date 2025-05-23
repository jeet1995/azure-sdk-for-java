// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysqlflexibleserver.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mysqlflexibleserver.fluent.models.ConfigurationInner;
import com.azure.resourcemanager.mysqlflexibleserver.fluent.models.ConfigurationListResultInner;
import com.azure.resourcemanager.mysqlflexibleserver.models.ConfigurationSource;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ConfigurationListResultInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ConfigurationListResultInner model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"value\":\"zloc\",\"description\":\"c\",\"defaultValue\":\"ierhhbcsglummaj\",\"dataType\":\"aodxo\",\"allowedValues\":\"bdxkqpxokaj\",\"source\":\"system-default\",\"isReadOnly\":\"False\",\"isConfigPendingRestart\":\"True\",\"isDynamicConfig\":\"True\"},\"id\":\"txgcpodgmaajr\",\"name\":\"vdjwzrlovm\",\"type\":\"lwhijcoejctbzaq\"}],\"nextLink\":\"sycbkbfk\"}")
            .toObject(ConfigurationListResultInner.class);
        Assertions.assertEquals("zloc", model.value().get(0).value());
        Assertions.assertEquals(ConfigurationSource.SYSTEM_DEFAULT, model.value().get(0).source());
        Assertions.assertEquals("sycbkbfk", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ConfigurationListResultInner model = new ConfigurationListResultInner()
            .withValue(Arrays
                .asList(new ConfigurationInner().withValue("zloc").withSource(ConfigurationSource.SYSTEM_DEFAULT)))
            .withNextLink("sycbkbfk");
        model = BinaryData.fromObject(model).toObject(ConfigurationListResultInner.class);
        Assertions.assertEquals("zloc", model.value().get(0).value());
        Assertions.assertEquals(ConfigurationSource.SYSTEM_DEFAULT, model.value().get(0).source());
        Assertions.assertEquals("sycbkbfk", model.nextLink());
    }
}
