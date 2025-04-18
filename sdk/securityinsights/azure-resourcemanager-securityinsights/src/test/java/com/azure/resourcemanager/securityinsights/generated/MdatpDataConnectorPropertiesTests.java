// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.fluent.models.MdatpDataConnectorProperties;
import com.azure.resourcemanager.securityinsights.models.AlertsDataTypeOfDataConnector;
import com.azure.resourcemanager.securityinsights.models.DataConnectorDataTypeCommon;
import com.azure.resourcemanager.securityinsights.models.DataTypeState;
import org.junit.jupiter.api.Assertions;

public final class MdatpDataConnectorPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MdatpDataConnectorProperties model
            = BinaryData.fromString("{\"tenantId\":\"h\",\"dataTypes\":{\"alerts\":{\"state\":\"Disabled\"}}}")
                .toObject(MdatpDataConnectorProperties.class);
        Assertions.assertEquals("h", model.tenantId());
        Assertions.assertEquals(DataTypeState.DISABLED, model.dataTypes().alerts().state());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MdatpDataConnectorProperties model = new MdatpDataConnectorProperties().withTenantId("h")
            .withDataTypes(new AlertsDataTypeOfDataConnector()
                .withAlerts(new DataConnectorDataTypeCommon().withState(DataTypeState.DISABLED)));
        model = BinaryData.fromObject(model).toObject(MdatpDataConnectorProperties.class);
        Assertions.assertEquals("h", model.tenantId());
        Assertions.assertEquals(DataTypeState.DISABLED, model.dataTypes().alerts().state());
    }
}
