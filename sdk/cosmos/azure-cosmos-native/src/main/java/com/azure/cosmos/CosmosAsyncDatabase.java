// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

/**
 * Reactive wrapper for database operations.
 */
public final class CosmosAsyncDatabase {

    private final CosmosDatabase syncDatabase;

    CosmosAsyncDatabase(CosmosDatabase syncDatabase) {
        this.syncDatabase = syncDatabase;
    }

    public String getId() {
        return syncDatabase.getId();
    }

    public CosmosAsyncContainer getContainer(String containerId) throws CosmosException {
        CosmosContainer syncContainer = syncDatabase.getContainer(containerId);
        return new CosmosAsyncContainer(syncContainer);
    }
}
