// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.devopsinfrastructure.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.devopsinfrastructure.implementation.models.PoolListResult;
import com.azure.resourcemanager.devopsinfrastructure.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.devopsinfrastructure.models.ProvisioningState;
import org.junit.jupiter.api.Assertions;

public final class PoolListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PoolListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"provisioningState\":\"Deleting\",\"maximumConcurrency\":1519639894,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"jthjqkwpyei\"},\"identity\":{\"principalId\":\"qciwqvhkhixuigdt\",\"tenantId\":\"bob\",\"type\":\"None\",\"userAssignedIdentities\":{\"a\":{\"principalId\":\"e\",\"clientId\":\"a\"}}},\"location\":\"rzayv\",\"tags\":{\"ln\":\"gvdfgiotkftutq\",\"qmi\":\"xlefgugnxkrx\"},\"id\":\"tthzrvqd\",\"name\":\"abhjybi\",\"type\":\"ehoqfbowskan\"},{\"properties\":{\"provisioningState\":\"Deleting\",\"maximumConcurrency\":1440760803,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"iywgqywgndrvynh\"},\"identity\":{\"principalId\":\"phrcgyncoc\",\"tenantId\":\"cfvmmco\",\"type\":\"SystemAssigned,UserAssigned\",\"userAssignedIdentities\":{\"c\":{\"principalId\":\"zevgb\",\"clientId\":\"jqabcypmivkwlzuv\"},\"bqqwxrj\":{\"principalId\":\"nfnbacfionlebxe\",\"clientId\":\"gtzxdpn\"},\"pmng\":{\"principalId\":\"al\",\"clientId\":\"wsubisnja\"},\"xnj\":{\"principalId\":\"scxaq\",\"clientId\":\"ochcbonqvpkvl\"}}},\"location\":\"seiphe\",\"tags\":{\"dlwtgrhpdj\":\"okeyyienj\",\"zj\":\"jumasx\"},\"id\":\"qyeg\",\"name\":\"alhbx\",\"type\":\"hejjz\"},{\"properties\":{\"provisioningState\":\"Accepted\",\"maximumConcurrency\":303390013,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"dslfhotwmcy\"},\"identity\":{\"principalId\":\"lbjnpgacftadehx\",\"tenantId\":\"tyfsoppusuesn\",\"type\":\"None\",\"userAssignedIdentities\":{\"wxdndnvowgujjug\":{\"principalId\":\"bavo\",\"clientId\":\"zdmohctbqvu\"}}},\"location\":\"kcglhslaz\",\"tags\":{\"jixhbk\":\"ggd\",\"fwhybcibvy\":\"ofqweykhmenevfye\",\"ynnaam\":\"dcsi\"},\"id\":\"ectehf\",\"name\":\"qsc\",\"type\":\"eypvhezrkg\"},{\"properties\":{\"provisioningState\":\"Deleting\",\"maximumConcurrency\":1889311419,\"organizationProfile\":{\"kind\":\"OrganizationProfile\"},\"agentProfile\":{\"kind\":\"AgentProfile\",\"resourcePredictions\":{},\"resourcePredictionsProfile\":{\"kind\":\"ResourcePredictionsProfile\"}},\"fabricProfile\":{\"kind\":\"FabricProfile\"},\"devCenterProjectResourceId\":\"o\"},\"identity\":{\"principalId\":\"kqsleyyvxy\",\"tenantId\":\"pkc\",\"type\":\"None\",\"userAssignedIdentities\":{\"a\":{\"principalId\":\"gjcrcczsqpjhvm\",\"clientId\":\"jvnysounqe\"},\"u\":{\"principalId\":\"ae\",\"clientId\":\"fhyhltrpmopjmcma\"},\"uaxbezyiuokkt\":{\"principalId\":\"thfuiuaodsfcpkvx\",\"clientId\":\"puozmyzydag\"},\"ksymd\":{\"principalId\":\"rdxwzywqsm\",\"clientId\":\"ureximoryocfs\"}}},\"location\":\"stkiiuxhqyud\",\"tags\":{\"b\":\"rq\",\"fqrvkdvjsllrmvvd\":\"oczvy\",\"zwtruwiqzbqjvsov\":\"watkpnpulexxb\",\"hzdobpxjmflbvvnc\":\"yokacspkw\"},\"id\":\"rkcciwwzjuqk\",\"name\":\"rsa\",\"type\":\"iwkuofos\"}],\"nextLink\":\"hsauuimjmvxied\"}")
            .toObject(PoolListResult.class);
        Assertions.assertEquals("rzayv", model.value().get(0).location());
        Assertions.assertEquals("gvdfgiotkftutq", model.value().get(0).tags().get("ln"));
        Assertions.assertEquals(ProvisioningState.DELETING, model.value().get(0).properties().provisioningState());
        Assertions.assertEquals(1519639894, model.value().get(0).properties().maximumConcurrency());
        Assertions.assertEquals("jthjqkwpyei", model.value().get(0).properties().devCenterProjectResourceId());
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.value().get(0).identity().type());
        Assertions.assertEquals("hsauuimjmvxied", model.nextLink());
    }
}
