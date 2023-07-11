// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.managednetworkfabric.fluent.models.IpExtendedCommunityProperties;
import com.azure.resourcemanager.managednetworkfabric.models.CommunityActionTypes;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class IpExtendedCommunityPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IpExtendedCommunityProperties model =
            BinaryData
                .fromString(
                    "{\"action\":\"Permit\",\"routeTargets\":[\"qwxrjfeallnw\"],\"provisioningState\":\"Updating\",\"annotation\":\"snjampmng\"}")
                .toObject(IpExtendedCommunityProperties.class);
        Assertions.assertEquals("snjampmng", model.annotation());
        Assertions.assertEquals(CommunityActionTypes.PERMIT, model.action());
        Assertions.assertEquals("qwxrjfeallnw", model.routeTargets().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IpExtendedCommunityProperties model =
            new IpExtendedCommunityProperties()
                .withAnnotation("snjampmng")
                .withAction(CommunityActionTypes.PERMIT)
                .withRouteTargets(Arrays.asList("qwxrjfeallnw"));
        model = BinaryData.fromObject(model).toObject(IpExtendedCommunityProperties.class);
        Assertions.assertEquals("snjampmng", model.annotation());
        Assertions.assertEquals(CommunityActionTypes.PERMIT, model.action());
        Assertions.assertEquals("qwxrjfeallnw", model.routeTargets().get(0));
    }
}