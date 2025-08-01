// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

import com.azure.resourcemanager.appservice.models.StaticSiteZipDeploymentArmResource;

/**
 * Samples for StaticSites CreateZipDeploymentForStaticSite.
 */
public final class StaticSitesCreateZipDeploymentForStaticSiteSamples {
    /*
     * x-ms-original-file:
     * specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/StaticSiteZipDeploy.json
     */
    /**
     * Sample code: Deploy a site from a zipped package.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void deployASiteFromAZippedPackage(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getStaticSites()
            .createZipDeploymentForStaticSite("rg", "testStaticSite0", new StaticSiteZipDeploymentArmResource()
                .withAppZipUrl("https://teststorageaccount.net/happy-sea-15afae3e-master-81828877/app-zipdeploy.zip")
                .withApiZipUrl("https://teststorageaccount.net/happy-sea-15afae3e-master-81828877/api-zipdeploy.zip")
                .withDeploymentTitle("Update index.html")
                .withProvider("testProvider")
                .withFunctionLanguage("testFunctionLanguage"), com.azure.core.util.Context.NONE);
    }
}
