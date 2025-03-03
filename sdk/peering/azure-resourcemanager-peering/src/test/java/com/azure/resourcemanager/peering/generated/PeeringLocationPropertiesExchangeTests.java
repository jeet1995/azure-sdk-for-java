// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.peering.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.peering.models.ExchangePeeringFacility;
import com.azure.resourcemanager.peering.models.PeeringLocationPropertiesExchange;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PeeringLocationPropertiesExchangeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PeeringLocationPropertiesExchange model = BinaryData.fromString(
            "{\"peeringFacilities\":[{\"exchangeName\":\"hjjdhtldwkyzxuut\",\"bandwidthInMbps\":38172527,\"microsoftIPv4Address\":\"scwsv\",\"microsoftIPv6Address\":\"otogtwrupqs\",\"facilityIPv4Prefix\":\"nmic\",\"facilityIPv6Prefix\":\"vce\",\"peeringDBFacilityId\":579723655,\"peeringDBFacilityLink\":\"lo\"},{\"exchangeName\":\"oty\",\"bandwidthInMbps\":914615331,\"microsoftIPv4Address\":\"njbkcnxdhbttkph\",\"microsoftIPv6Address\":\"pnvjtoqnermclf\",\"facilityIPv4Prefix\":\"phoxus\",\"facilityIPv6Prefix\":\"pabgyeps\",\"peeringDBFacilityId\":1974668378,\"peeringDBFacilityLink\":\"zq\"},{\"exchangeName\":\"xywpmueefjzwfqkq\",\"bandwidthInMbps\":640895390,\"microsoftIPv4Address\":\"suyonobglaocq\",\"microsoftIPv6Address\":\"ccm\",\"facilityIPv4Prefix\":\"udxytlmoyrx\",\"facilityIPv6Prefix\":\"fudwpznt\",\"peeringDBFacilityId\":1417270726,\"peeringDBFacilityLink\":\"hl\"}]}")
            .toObject(PeeringLocationPropertiesExchange.class);
        Assertions.assertEquals("hjjdhtldwkyzxuut", model.peeringFacilities().get(0).exchangeName());
        Assertions.assertEquals(38172527, model.peeringFacilities().get(0).bandwidthInMbps());
        Assertions.assertEquals("scwsv", model.peeringFacilities().get(0).microsoftIPv4Address());
        Assertions.assertEquals("otogtwrupqs", model.peeringFacilities().get(0).microsoftIPv6Address());
        Assertions.assertEquals("nmic", model.peeringFacilities().get(0).facilityIPv4Prefix());
        Assertions.assertEquals("vce", model.peeringFacilities().get(0).facilityIPv6Prefix());
        Assertions.assertEquals(579723655, model.peeringFacilities().get(0).peeringDBFacilityId());
        Assertions.assertEquals("lo", model.peeringFacilities().get(0).peeringDBFacilityLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PeeringLocationPropertiesExchange model
            = new PeeringLocationPropertiesExchange().withPeeringFacilities(Arrays.asList(
                new ExchangePeeringFacility().withExchangeName("hjjdhtldwkyzxuut")
                    .withBandwidthInMbps(38172527)
                    .withMicrosoftIPv4Address("scwsv")
                    .withMicrosoftIPv6Address("otogtwrupqs")
                    .withFacilityIPv4Prefix("nmic")
                    .withFacilityIPv6Prefix("vce")
                    .withPeeringDBFacilityId(579723655)
                    .withPeeringDBFacilityLink("lo"),
                new ExchangePeeringFacility().withExchangeName("oty")
                    .withBandwidthInMbps(914615331)
                    .withMicrosoftIPv4Address("njbkcnxdhbttkph")
                    .withMicrosoftIPv6Address("pnvjtoqnermclf")
                    .withFacilityIPv4Prefix("phoxus")
                    .withFacilityIPv6Prefix("pabgyeps")
                    .withPeeringDBFacilityId(1974668378)
                    .withPeeringDBFacilityLink("zq"),
                new ExchangePeeringFacility().withExchangeName("xywpmueefjzwfqkq")
                    .withBandwidthInMbps(640895390)
                    .withMicrosoftIPv4Address("suyonobglaocq")
                    .withMicrosoftIPv6Address("ccm")
                    .withFacilityIPv4Prefix("udxytlmoyrx")
                    .withFacilityIPv6Prefix("fudwpznt")
                    .withPeeringDBFacilityId(1417270726)
                    .withPeeringDBFacilityLink("hl")));
        model = BinaryData.fromObject(model).toObject(PeeringLocationPropertiesExchange.class);
        Assertions.assertEquals("hjjdhtldwkyzxuut", model.peeringFacilities().get(0).exchangeName());
        Assertions.assertEquals(38172527, model.peeringFacilities().get(0).bandwidthInMbps());
        Assertions.assertEquals("scwsv", model.peeringFacilities().get(0).microsoftIPv4Address());
        Assertions.assertEquals("otogtwrupqs", model.peeringFacilities().get(0).microsoftIPv6Address());
        Assertions.assertEquals("nmic", model.peeringFacilities().get(0).facilityIPv4Prefix());
        Assertions.assertEquals("vce", model.peeringFacilities().get(0).facilityIPv6Prefix());
        Assertions.assertEquals(579723655, model.peeringFacilities().get(0).peeringDBFacilityId());
        Assertions.assertEquals("lo", model.peeringFacilities().get(0).peeringDBFacilityLink());
    }
}
