// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

/**
 * Samples for Backups Get.
 */
public final class BackupsGetSamples {
    /*
     * x-ms-original-file:
     * specification/postgresql/resource-manager/Microsoft.DBforPostgreSQL/preview/2025-01-01-preview/examples/BackupGet
     * .json
     */
    /**
     * Sample code: Get a backup for a server.
     * 
     * @param manager Entry point to PostgreSqlManager.
     */
    public static void
        getABackupForAServer(com.azure.resourcemanager.postgresqlflexibleserver.PostgreSqlManager manager) {
        manager.backups()
            .getWithResponse("TestGroup", "postgresqltestserver", "daily_20250303T160516",
                com.azure.core.util.Context.NONE);
    }
}
