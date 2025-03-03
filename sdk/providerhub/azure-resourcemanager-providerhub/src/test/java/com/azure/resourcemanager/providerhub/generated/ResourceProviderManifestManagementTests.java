// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.ResourceAccessPolicy;
import com.azure.resourcemanager.providerhub.models.ResourceProviderManifestManagement;
import com.azure.resourcemanager.providerhub.models.ServiceTreeInfo;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ResourceProviderManifestManagementTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceProviderManifestManagement model = BinaryData.fromString(
            "{\"schemaOwners\":[\"hlmctlpdngitvgb\",\"hrixkwmy\",\"jejveg\"],\"manifestOwners\":[\"pna\",\"xexccbdreaxhcexd\",\"rvqahqkghtpwi\",\"nhyjsv\"],\"incidentRoutingService\":\"cxzbfvoowvr\",\"incidentRoutingTeam\":\"t\",\"incidentContactEmail\":\"qp\",\"serviceTreeInfos\":[{\"serviceId\":\"tronzmyhgfi\",\"componentId\":\"sxkm\"},{\"serviceId\":\"a\",\"componentId\":\"rrjreafxtsgu\"}],\"resourceAccessPolicy\":\"AcisActionAllowed\",\"resourceAccessRoles\":[\"dataikkx\"]}")
            .toObject(ResourceProviderManifestManagement.class);
        Assertions.assertEquals("hlmctlpdngitvgb", model.schemaOwners().get(0));
        Assertions.assertEquals("pna", model.manifestOwners().get(0));
        Assertions.assertEquals("cxzbfvoowvr", model.incidentRoutingService());
        Assertions.assertEquals("t", model.incidentRoutingTeam());
        Assertions.assertEquals("qp", model.incidentContactEmail());
        Assertions.assertEquals("tronzmyhgfi", model.serviceTreeInfos().get(0).serviceId());
        Assertions.assertEquals("sxkm", model.serviceTreeInfos().get(0).componentId());
        Assertions.assertEquals(ResourceAccessPolicy.ACIS_ACTION_ALLOWED, model.resourceAccessPolicy());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ResourceProviderManifestManagement model = new ResourceProviderManifestManagement()
            .withSchemaOwners(Arrays.asList("hlmctlpdngitvgb", "hrixkwmy", "jejveg"))
            .withManifestOwners(Arrays.asList("pna", "xexccbdreaxhcexd", "rvqahqkghtpwi", "nhyjsv"))
            .withIncidentRoutingService("cxzbfvoowvr")
            .withIncidentRoutingTeam("t")
            .withIncidentContactEmail("qp")
            .withServiceTreeInfos(
                Arrays.asList(new ServiceTreeInfo().withServiceId("tronzmyhgfi").withComponentId("sxkm"),
                    new ServiceTreeInfo().withServiceId("a").withComponentId("rrjreafxtsgu")))
            .withResourceAccessPolicy(ResourceAccessPolicy.ACIS_ACTION_ALLOWED)
            .withResourceAccessRoles(Arrays.asList("dataikkx"));
        model = BinaryData.fromObject(model).toObject(ResourceProviderManifestManagement.class);
        Assertions.assertEquals("hlmctlpdngitvgb", model.schemaOwners().get(0));
        Assertions.assertEquals("pna", model.manifestOwners().get(0));
        Assertions.assertEquals("cxzbfvoowvr", model.incidentRoutingService());
        Assertions.assertEquals("t", model.incidentRoutingTeam());
        Assertions.assertEquals("qp", model.incidentContactEmail());
        Assertions.assertEquals("tronzmyhgfi", model.serviceTreeInfos().get(0).serviceId());
        Assertions.assertEquals("sxkm", model.serviceTreeInfos().get(0).componentId());
        Assertions.assertEquals(ResourceAccessPolicy.ACIS_ACTION_ALLOWED, model.resourceAccessPolicy());
    }
}
