// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

/**
 * Reactor-first async Cosmos DB client.
 *
 * <p>Usage:
 * <pre>{@code
 * try (CosmosAsyncClient client = CosmosAsyncClient.createWithKey(endpoint, key)) {
 *     client.getDatabase("myDb").getContainer("myContainer")
 *           .readItem("doc1", "pk1")
 *           .map(CosmosItemResponse::getBody)
 *           .subscribe(System.out::println);
 * }
 * }</pre>
 */
public final class CosmosAsyncClient implements AutoCloseable {

    private final CosmosClient syncClient;

    private CosmosAsyncClient(CosmosClient syncClient) {
        this.syncClient = syncClient;
    }

    /**
     * Creates a new reactive CosmosClient authenticated with a master key.
     */
    public static CosmosAsyncClient createWithKey(String endpoint, String key) throws CosmosException {
        return new CosmosAsyncClient(CosmosClient.createWithKey(endpoint, key));
    }

    /**
     * Gets a reactive database client.
     */
    public CosmosAsyncDatabase getDatabase(String databaseId) throws CosmosException {
        CosmosDatabase syncDb = syncClient.getDatabase(databaseId);
        return new CosmosAsyncDatabase(syncDb);
    }

    @Override
    public void close() {
        syncClient.close();
    }
}
