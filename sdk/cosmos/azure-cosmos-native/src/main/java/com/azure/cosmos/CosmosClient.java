// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

/**
 * Top-level synchronous Cosmos DB client backed by the Rust native SDK via JNI.
 *
 * <p>Usage:
 * <pre>{@code
 * try (CosmosClient client = CosmosClient.createWithKey(endpoint, key)) {
 *     CosmosContainer container = client.getDatabase("myDb").getContainer("myContainer");
 *     container.createItem("pk1", "{\"id\":\"doc1\",\"pk\":\"pk1\"}");
 *     CosmosItemResponse response = container.readItem("doc1", "pk1");
 *     System.out.println(response.getBody());
 * }
 * }</pre>
 *
 * <p>This client owns the native runtime, call context, and client handle.
 * {@link #close()} frees all native resources. Database and container objects
 * obtained from this client become invalid after close.</p>
 */
public final class CosmosClient implements AutoCloseable {

    private final long runtimeContext;
    private final long callContext;
    private final long clientHandle;
    private volatile boolean closed = false;

    private CosmosClient(long runtimeContext, long callContext, long clientHandle) {
        this.runtimeContext = runtimeContext;
        this.callContext = callContext;
        this.clientHandle = clientHandle;
    }

    /**
     * Creates a new CosmosClient authenticated with a master key.
     *
     * @param endpoint the Cosmos DB account endpoint URL
     * @param key      the Cosmos DB account master key
     * @return a new CosmosClient
     * @throws CosmosException if connection fails
     */
    public static CosmosClient createWithKey(String endpoint, String key) throws CosmosException {
        long runtime = CosmosNativeBridge.nativeRuntimeContextCreate();
        long ctx = CosmosNativeBridge.nativeCallContextCreate(runtime, true);
        long client = CosmosNativeBridge.nativeClientCreateWithKey(ctx, endpoint, key);
        return new CosmosClient(runtime, ctx, client);
    }

    /**
     * Gets a database client for the specified database.
     *
     * @param databaseId the database name
     * @return a {@link CosmosDatabase} for the given database
     * @throws CosmosException if the database client cannot be created
     */
    public CosmosDatabase getDatabase(String databaseId) throws CosmosException {
        ensureOpen();
        long db = CosmosNativeBridge.nativeDatabaseClient(callContext, clientHandle, databaseId);
        return new CosmosDatabase(callContext, db, databaseId);
    }

    @Override
    public void close() {
        if (!closed) {
            closed = true;
            CosmosNativeBridge.nativeClientFree(clientHandle);
            CosmosNativeBridge.nativeCallContextFree(callContext);
            CosmosNativeBridge.nativeRuntimeContextFree(runtimeContext);
        }
    }

    private void ensureOpen() {
        if (closed) {
            throw new IllegalStateException("CosmosClient is closed");
        }
    }
}
