// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dashboard.implementation.models.PrivateEndpointConnectionListResult;
import com.azure.resourcemanager.dashboard.models.PrivateEndpointServiceConnectionStatus;
import org.junit.jupiter.api.Assertions;

public final class PrivateEndpointConnectionListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrivateEndpointConnectionListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"privateEndpoint\":{\"id\":\"sprozvcput\"},\"privateLinkServiceConnectionState\":{\"status\":\"Rejected\",\"description\":\"wmfdatscmdvpjhul\",\"actionsRequired\":\"uvm\"},\"groupIds\":[\"zkrwfn\",\"iodjp\",\"lwejdpv\",\"ryo\"],\"provisioningState\":\"Deleting\"},\"id\":\"acctazakljla\",\"name\":\"bcryffdfd\",\"type\":\"sy\"},{\"properties\":{\"privateEndpoint\":{\"id\":\"aojakhmsbzjhcrz\"},\"privateLinkServiceConnectionState\":{\"status\":\"Rejected\",\"description\":\"hlxaolthqtr\",\"actionsRequired\":\"jbp\"},\"groupIds\":[\"s\",\"n\",\"gvfcj\",\"wzo\"],\"provisioningState\":\"Succeeded\"},\"id\":\"felluwfzitonpe\",\"name\":\"fpjkjlxofp\",\"type\":\"vhpfxxypininmay\"},{\"properties\":{\"privateEndpoint\":{\"id\":\"bkpodepooginuv\"},\"privateLinkServiceConnectionState\":{\"status\":\"Approved\",\"description\":\"eognarxzxtheotu\",\"actionsRequired\":\"vyevcciqi\"},\"groupIds\":[\"un\",\"bwjzr\",\"fygxgispemvtzfk\"],\"provisioningState\":\"Deleting\"},\"id\":\"ljofxqeofjaeqjh\",\"name\":\"jbasvmsmjqulngs\",\"type\":\"tnb\"}],\"nextLink\":\"kzgcwrwcl\"}")
            .toObject(PrivateEndpointConnectionListResult.class);
        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.REJECTED,
            model.value().get(0).privateLinkServiceConnectionState().status());
        Assertions.assertEquals("wmfdatscmdvpjhul",
            model.value().get(0).privateLinkServiceConnectionState().description());
        Assertions.assertEquals("uvm", model.value().get(0).privateLinkServiceConnectionState().actionsRequired());
        Assertions.assertEquals("zkrwfn", model.value().get(0).groupIds().get(0));
        Assertions.assertEquals("kzgcwrwcl", model.nextLink());
    }
}
