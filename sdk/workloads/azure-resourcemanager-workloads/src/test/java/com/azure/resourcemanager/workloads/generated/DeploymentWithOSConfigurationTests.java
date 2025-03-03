// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.workloads.models.DeployerVmPackages;
import com.azure.resourcemanager.workloads.models.DeploymentWithOSConfiguration;
import com.azure.resourcemanager.workloads.models.InfrastructureConfiguration;
import com.azure.resourcemanager.workloads.models.OsSapConfiguration;
import com.azure.resourcemanager.workloads.models.SoftwareConfiguration;
import org.junit.jupiter.api.Assertions;

public final class DeploymentWithOSConfigurationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DeploymentWithOSConfiguration model = BinaryData.fromString(
            "{\"configurationType\":\"DeploymentWithOSConfig\",\"appLocation\":\"aibrebqaaysjkixq\",\"infrastructureConfiguration\":{\"deploymentType\":\"InfrastructureConfiguration\",\"appResourceGroup\":\"qttezlwfffiakpjp\"},\"softwareConfiguration\":{\"softwareInstallationType\":\"SoftwareConfiguration\"},\"osSapConfiguration\":{\"deployerVmPackages\":{\"url\":\"d\",\"storageAccountId\":\"mmji\"},\"sapFqdn\":\"eozphv\"}}")
            .toObject(DeploymentWithOSConfiguration.class);
        Assertions.assertEquals("aibrebqaaysjkixq", model.appLocation());
        Assertions.assertEquals("qttezlwfffiakpjp", model.infrastructureConfiguration().appResourceGroup());
        Assertions.assertEquals("d", model.osSapConfiguration().deployerVmPackages().url());
        Assertions.assertEquals("mmji", model.osSapConfiguration().deployerVmPackages().storageAccountId());
        Assertions.assertEquals("eozphv", model.osSapConfiguration().sapFqdn());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DeploymentWithOSConfiguration model = new DeploymentWithOSConfiguration().withAppLocation("aibrebqaaysjkixq")
            .withInfrastructureConfiguration(new InfrastructureConfiguration().withAppResourceGroup("qttezlwfffiakpjp"))
            .withSoftwareConfiguration(new SoftwareConfiguration())
            .withOsSapConfiguration(new OsSapConfiguration()
                .withDeployerVmPackages(new DeployerVmPackages().withUrl("d").withStorageAccountId("mmji"))
                .withSapFqdn("eozphv"));
        model = BinaryData.fromObject(model).toObject(DeploymentWithOSConfiguration.class);
        Assertions.assertEquals("aibrebqaaysjkixq", model.appLocation());
        Assertions.assertEquals("qttezlwfffiakpjp", model.infrastructureConfiguration().appResourceGroup());
        Assertions.assertEquals("d", model.osSapConfiguration().deployerVmPackages().url());
        Assertions.assertEquals("mmji", model.osSapConfiguration().deployerVmPackages().storageAccountId());
        Assertions.assertEquals("eozphv", model.osSapConfiguration().sapFqdn());
    }
}
