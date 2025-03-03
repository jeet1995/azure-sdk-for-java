// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azurearcdata.generated;

import com.azure.resourcemanager.azurearcdata.models.ArcSqlManagedInstanceLicenseType;
import com.azure.resourcemanager.azurearcdata.models.BasicLoginInformation;
import com.azure.resourcemanager.azurearcdata.models.ExtendedLocation;
import com.azure.resourcemanager.azurearcdata.models.ExtendedLocationTypes;
import com.azure.resourcemanager.azurearcdata.models.K8SResourceRequirements;
import com.azure.resourcemanager.azurearcdata.models.K8SScheduling;
import com.azure.resourcemanager.azurearcdata.models.K8SSchedulingOptions;
import com.azure.resourcemanager.azurearcdata.models.SqlManagedInstanceK8SRaw;
import com.azure.resourcemanager.azurearcdata.models.SqlManagedInstanceK8SSpec;
import com.azure.resourcemanager.azurearcdata.models.SqlManagedInstanceProperties;
import com.azure.resourcemanager.azurearcdata.models.SqlManagedInstanceSku;
import com.azure.resourcemanager.azurearcdata.models.SqlManagedInstanceSkuTier;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for SqlManagedInstances Create.
 */
public final class SqlManagedInstancesCreateSamples {
    /*
     * x-ms-original-file:
     * specification/azurearcdata/resource-manager/Microsoft.AzureArcData/stable/2021-08-01/examples/
     * CreateOrUpdateSqlManagedInstance.json
     */
    /**
     * Sample code: Create or update a SQL Managed Instance.
     * 
     * @param manager Entry point to AzureArcDataManager.
     */
    public static void
        createOrUpdateASQLManagedInstance(com.azure.resourcemanager.azurearcdata.AzureArcDataManager manager) {
        manager.sqlManagedInstances()
            .define("testsqlManagedInstance")
            .withRegion("northeurope")
            .withExistingResourceGroup("testrg")
            .withProperties(
                new SqlManagedInstanceProperties().withAdmin("Admin user")
                    .withStartTime("Instance start time")
                    .withEndTime("Instance end time")
                    .withK8SRaw(
                        new SqlManagedInstanceK8SRaw()
                            .withSpec(new SqlManagedInstanceK8SSpec()
                                .withScheduling(
                                    new K8SScheduling()
                                        .withDefaultProperty(
                                            new K8SSchedulingOptions()
                                                .withResources(new K8SResourceRequirements()
                                                    .withRequests(mapOf("additionalProperty", "additionalValue", "cpu",
                                                        "1", "memory", "8Gi"))
                                                    .withLimits(mapOf("additionalProperty", "additionalValue", "cpu",
                                                        "1", "memory", "8Gi"))
                                                    .withAdditionalProperties(mapOf()))
                                                .withAdditionalProperties(mapOf()))
                                        .withAdditionalProperties(mapOf()))
                                .withReplicas(1)
                                .withAdditionalProperties(mapOf()))
                            .withAdditionalProperties(mapOf("additionalProperty", 1234)))
                    .withBasicLoginInformation(
                        new BasicLoginInformation().withUsername("username").withPassword("fakeTokenPlaceholder"))
                    .withLicenseType(ArcSqlManagedInstanceLicenseType.LICENSE_INCLUDED)
                    .withClusterId(
                        "/subscriptions/00000000-1111-2222-3333-444444444444/resourceGroups/testrg/providers/Microsoft.Kubernetes/connectedClusters/connectedk8s")
                    .withExtensionId(
                        "/subscriptions/00000000-1111-2222-3333-444444444444/resourceGroups/testrg/providers/Microsoft.Kubernetes/connectedClusters/connectedk8s/providers/Microsoft.KubernetesConfiguration/extensions/extension"))
            .withTags(mapOf("mytag", "myval"))
            .withExtendedLocation(new ExtendedLocation().withName(
                "/subscriptions/00000000-1111-2222-3333-444444444444/resourceGroups/testrg/providers/Microsoft.ExtendedLocation/customLocations/arclocation")
                .withType(ExtendedLocationTypes.CUSTOM_LOCATION))
            .withSku(new SqlManagedInstanceSku().withTier(SqlManagedInstanceSkuTier.GENERAL_PURPOSE).withDev(true))
            .create();
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
