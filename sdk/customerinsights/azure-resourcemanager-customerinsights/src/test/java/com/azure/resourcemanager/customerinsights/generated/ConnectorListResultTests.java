// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.customerinsights.fluent.models.ConnectorResourceFormatInner;
import com.azure.resourcemanager.customerinsights.models.ConnectorListResult;
import com.azure.resourcemanager.customerinsights.models.ConnectorTypes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ConnectorListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ConnectorListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"connectorId\":1153037194,\"connectorName\":\"du\",\"connectorType\":\"ExchangeOnline\",\"displayName\":\"irdsvuwcob\",\"description\":\"gstmninwjizciln\",\"connectorProperties\":{\"xqzv\":\"datagshejjtbxqmulux\",\"ycucrwnamikzeb\":\"dataers\"},\"created\":\"2021-10-04T09:07:46Z\",\"lastModified\":\"2021-08-14T09:18:40Z\",\"state\":\"Ready\",\"tenantId\":\"iqg\",\"isInternal\":false},\"id\":\"okzrus\",\"name\":\"hvhcz\",\"type\":\"n\"},{\"properties\":{\"connectorId\":1235050131,\"connectorName\":\"jsxjwwix\",\"connectorType\":\"CRM\",\"displayName\":\"mwmxqhndvnoamld\",\"description\":\"haohdjhhflzokxc\",\"connectorProperties\":{\"tsxoatftgz\":\"datapelnjetag\",\"vefloccsrmozihmi\":\"datanpbs\",\"wtxxpkyjcx\":\"datag\",\"ycilrmcaykggnox\":\"datajxgrytfmp\"},\"created\":\"2021-09-05T21:02:51Z\",\"lastModified\":\"2021-11-28T11:57:07Z\",\"state\":\"Ready\",\"tenantId\":\"pndfcpfnznt\",\"isInternal\":false},\"id\":\"wkjaos\",\"name\":\"xuzvoamktcqi\",\"type\":\"smgbzahgxqdl\"},{\"properties\":{\"connectorId\":1765998535,\"connectorName\":\"laprlt\",\"connectorType\":\"Salesforce\",\"displayName\":\"tbhjmznnbsoqe\",\"description\":\"larvlagunbtg\",\"connectorProperties\":{\"mhyreeudz\":\"databwln\",\"pdqmjxlyyzglgouw\":\"dataav\",\"qtobaxkjeyt\":\"datalmjjyuo\",\"jkwrusnkq\":\"datanlb\"},\"created\":\"2021-10-27T03:00:47Z\",\"lastModified\":\"2021-11-28T23:19:16Z\",\"state\":\"Creating\",\"tenantId\":\"jqhden\",\"isInternal\":false},\"id\":\"l\",\"name\":\"pakdkifmjnnawt\",\"type\":\"abpxuc\"}],\"nextLink\":\"ggqowey\"}")
            .toObject(ConnectorListResult.class);
        Assertions.assertEquals("du", model.value().get(0).connectorName());
        Assertions.assertEquals(ConnectorTypes.EXCHANGE_ONLINE, model.value().get(0).connectorType());
        Assertions.assertEquals("irdsvuwcob", model.value().get(0).displayName());
        Assertions.assertEquals("gstmninwjizciln", model.value().get(0).description());
        Assertions.assertEquals(false, model.value().get(0).isInternal());
        Assertions.assertEquals("ggqowey", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ConnectorListResult model
            = new ConnectorListResult()
                .withValue(
                    Arrays
                        .asList(
                            new ConnectorResourceFormatInner().withConnectorName("du")
                                .withConnectorType(ConnectorTypes.EXCHANGE_ONLINE)
                                .withDisplayName("irdsvuwcob")
                                .withDescription("gstmninwjizciln")
                                .withConnectorProperties(
                                    mapOf("xqzv", "datagshejjtbxqmulux", "ycucrwnamikzeb", "dataers"))
                                .withIsInternal(false),
                            new ConnectorResourceFormatInner().withConnectorName("jsxjwwix")
                                .withConnectorType(ConnectorTypes.CRM)
                                .withDisplayName("mwmxqhndvnoamld")
                                .withDescription("haohdjhhflzokxc")
                                .withConnectorProperties(mapOf("tsxoatftgz", "datapelnjetag", "vefloccsrmozihmi",
                                    "datanpbs", "wtxxpkyjcx", "datag", "ycilrmcaykggnox", "datajxgrytfmp"))
                                .withIsInternal(false),
                            new ConnectorResourceFormatInner().withConnectorName("laprlt")
                                .withConnectorType(ConnectorTypes.SALESFORCE)
                                .withDisplayName("tbhjmznnbsoqe")
                                .withDescription("larvlagunbtg")
                                .withConnectorProperties(mapOf("mhyreeudz", "databwln", "pdqmjxlyyzglgouw", "dataav",
                                    "qtobaxkjeyt", "datalmjjyuo", "jkwrusnkq", "datanlb"))
                                .withIsInternal(false)))
                .withNextLink("ggqowey");
        model = BinaryData.fromObject(model).toObject(ConnectorListResult.class);
        Assertions.assertEquals("du", model.value().get(0).connectorName());
        Assertions.assertEquals(ConnectorTypes.EXCHANGE_ONLINE, model.value().get(0).connectorType());
        Assertions.assertEquals("irdsvuwcob", model.value().get(0).displayName());
        Assertions.assertEquals("gstmninwjizciln", model.value().get(0).description());
        Assertions.assertEquals(false, model.value().get(0).isInternal());
        Assertions.assertEquals("ggqowey", model.nextLink());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
