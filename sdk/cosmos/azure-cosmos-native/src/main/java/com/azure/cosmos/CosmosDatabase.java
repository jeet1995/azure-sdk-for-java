// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

/**
 * Provides operations for a specific Cosmos DB database.
 * Obtained via {@link CosmosClient#getDatabase(String)}.
 */
public final class CosmosDatabase {
    private final long callContext;
    private final long databaseHandle;
    private final String id;

    CosmosDatabase(long callContext, long databaseHandle, String id) {
        this.callContext = callContext;
        this.databaseHandle = databaseHandle;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Gets a container client for the specified container.
     */
    public CosmosContainer getContainer(String containerId) throws CosmosException {
        long containerHandle = CosmosNativeBridge.nativeContainerClient(callContext, databaseHandle, containerId);
        return new CosmosContainer(callContext, containerHandle, containerId);
    }

    long getHandle() {
        return databaseHandle;
    }

    void free() {
        CosmosNativeBridge.nativeDatabaseFree(databaseHandle);
    }
}
