// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.oracledatabase.implementation.models.SystemVersionListResult;
import org.junit.jupiter.api.Assertions;

public final class SystemVersionListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SystemVersionListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"systemVersion\":\"mond\"},\"id\":\"quxvypomgkop\",\"name\":\"whojvp\",\"type\":\"jqg\"},{\"properties\":{\"systemVersion\":\"smocmbq\"},\"id\":\"vmkcx\",\"name\":\"zapvhelx\",\"type\":\"rgly\"}],\"nextLink\":\"dd\"}")
            .toObject(SystemVersionListResult.class);
        Assertions.assertEquals("mond", model.value().get(0).properties().systemVersion());
        Assertions.assertEquals("dd", model.nextLink());
    }
}
