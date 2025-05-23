// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.generated;

/**
 * Samples for SqlResources DeleteSqlRoleAssignment.
 */
public final class SqlResourcesDeleteSqlRoleAssignmentSamples {
    /*
     * x-ms-original-file: specification/cosmos-db/resource-manager/Microsoft.DocumentDB/stable/2025-04-15/examples/
     * CosmosDBSqlRoleAssignmentDelete.json
     */
    /**
     * Sample code: CosmosDBSqlRoleAssignmentDelete.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void cosmosDBSqlRoleAssignmentDelete(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.cosmosDBAccounts()
            .manager()
            .serviceClient()
            .getSqlResources()
            .deleteSqlRoleAssignment("myRoleAssignmentId", "myResourceGroupName", "myAccountName",
                com.azure.core.util.Context.NONE);
    }
}
