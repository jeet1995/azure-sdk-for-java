// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.generated;

import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmenEncryptionConfiguration;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmenEncryptionKeyReference;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentAccessEndpoint;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentAccessEndpointType;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentProperties;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentSku;
import com.azure.resourcemanager.logic.models.IntegrationServiceEnvironmentSkuName;
import com.azure.resourcemanager.logic.models.NetworkConfiguration;
import com.azure.resourcemanager.logic.models.ResourceReference;
import java.util.Arrays;

/**
 * Samples for IntegrationServiceEnvironments CreateOrUpdate.
 */
public final class IntegrationServiceEnvironmentsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/logic/resource-manager/Microsoft.Logic/stable/2019-05-01/examples/
     * IntegrationServiceEnvironments_Put.json
     */
    /**
     * Sample code: Create or update an integration service environment.
     * 
     * @param manager Entry point to LogicManager.
     */
    public static void
        createOrUpdateAnIntegrationServiceEnvironment(com.azure.resourcemanager.logic.LogicManager manager) {
        manager.integrationServiceEnvironments()
            .define("testIntegrationServiceEnvironment")
            .withRegion("brazilsouth")
            .withExistingResourceGroup("testResourceGroup")
            .withProperties(new IntegrationServiceEnvironmentProperties()
                .withNetworkConfiguration(new NetworkConfiguration()
                    .withAccessEndpoint(new IntegrationServiceEnvironmentAccessEndpoint()
                        .withType(IntegrationServiceEnvironmentAccessEndpointType.INTERNAL))
                    .withSubnets(Arrays.asList(new ResourceReference().withId(
                        "/subscriptions/f34b22a3-2202-4fb1-b040-1332bd928c84/resourceGroups/testResourceGroup/providers/Microsoft.Network/virtualNetworks/testVNET/subnets/s1"),
                        new ResourceReference().withId(
                            "/subscriptions/f34b22a3-2202-4fb1-b040-1332bd928c84/resourceGroups/testResourceGroup/providers/Microsoft.Network/virtualNetworks/testVNET/subnets/s2"),
                        new ResourceReference().withId(
                            "/subscriptions/f34b22a3-2202-4fb1-b040-1332bd928c84/resourceGroups/testResourceGroup/providers/Microsoft.Network/virtualNetworks/testVNET/subnets/s3"),
                        new ResourceReference().withId(
                            "/subscriptions/f34b22a3-2202-4fb1-b040-1332bd928c84/resourceGroups/testResourceGroup/providers/Microsoft.Network/virtualNetworks/testVNET/subnets/s4"))))
                .withEncryptionConfiguration(new IntegrationServiceEnvironmenEncryptionConfiguration()
                    .withEncryptionKeyReference(new IntegrationServiceEnvironmenEncryptionKeyReference()
                        .withKeyVault(new ResourceReference().withId(
                            "/subscriptions/f34b22a3-2202-4fb1-b040-1332bd928c84/resourceGroups/testResourceGroup/providers/Microsoft.KeyVault/vaults/testKeyVault"))
                        .withKeyName("fakeTokenPlaceholder")
                        .withKeyVersion("fakeTokenPlaceholder"))))
            .withSku(new IntegrationServiceEnvironmentSku().withName(IntegrationServiceEnvironmentSkuName.PREMIUM)
                .withCapacity(2))
            .create();
    }
}
