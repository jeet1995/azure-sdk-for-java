// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.DataTypeState;
import com.azure.resourcemanager.securityinsights.models.TIDataConnector;
import com.azure.resourcemanager.securityinsights.models.TIDataConnectorDataTypes;
import com.azure.resourcemanager.securityinsights.models.TIDataConnectorDataTypesIndicators;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class TIDataConnectorTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TIDataConnector model = BinaryData.fromString(
            "{\"kind\":\"ThreatIntelligence\",\"properties\":{\"tenantId\":\"znuciqdsm\",\"tipLookbackPeriod\":\"2021-05-19T04:46:27Z\",\"dataTypes\":{\"indicators\":{\"state\":\"Disabled\"}}},\"etag\":\"xtyasiibmiyb\",\"id\":\"ustgnljhnmgixhc\",\"name\":\"avmqfoudor\",\"type\":\"cgyypro\"}")
            .toObject(TIDataConnector.class);
        Assertions.assertEquals("xtyasiibmiyb", model.etag());
        Assertions.assertEquals("znuciqdsm", model.tenantId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-19T04:46:27Z"), model.tipLookbackPeriod());
        Assertions.assertEquals(DataTypeState.DISABLED, model.dataTypes().indicators().state());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TIDataConnector model = new TIDataConnector().withEtag("xtyasiibmiyb")
            .withTenantId("znuciqdsm")
            .withTipLookbackPeriod(OffsetDateTime.parse("2021-05-19T04:46:27Z"))
            .withDataTypes(new TIDataConnectorDataTypes()
                .withIndicators(new TIDataConnectorDataTypesIndicators().withState(DataTypeState.DISABLED)));
        model = BinaryData.fromObject(model).toObject(TIDataConnector.class);
        Assertions.assertEquals("xtyasiibmiyb", model.etag());
        Assertions.assertEquals("znuciqdsm", model.tenantId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-19T04:46:27Z"), model.tipLookbackPeriod());
        Assertions.assertEquals(DataTypeState.DISABLED, model.dataTypes().indicators().state());
    }
}
