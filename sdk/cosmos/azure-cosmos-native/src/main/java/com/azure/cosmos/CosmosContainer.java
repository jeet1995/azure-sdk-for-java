// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;

/**
 * Provides item operations for a specific Cosmos DB container.
 * Obtained via {@link CosmosDatabase#getContainer(String)}.
 *
 * <p>Usage:
 * <pre>{@code
 * try (CosmosClient client = CosmosClient.createWithKey(endpoint, key)) {
 *     CosmosContainer container = client.getDatabase("myDb").getContainer("myContainer");
 *
 *     // Without options
 *     container.createItem("pk1", jsonDoc);
 *
 *     // With options
 *     CosmosItemRequestOptions opts = new CosmosItemRequestOptions()
 *         .setConsistencyLevel("Session")
 *         .setIfMatchETag(etag);
 *     container.createItem("pk1", jsonDoc, opts);
 *     CosmosItemResponse response = container.readItem("doc1", "pk1", opts);
 * }
 * }</pre>
 */
public final class CosmosContainer {
    private final long callContext;
    private final long containerHandle;
    private final String id;

    CosmosContainer(long callContext, long containerHandle, String id) {
        this.callContext = callContext;
        this.containerHandle = containerHandle;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Creates a new item in this container.
     *
     * @param partitionKey the partition key value
     * @param jsonData     the item as a raw JSON string (must include "id" field)
     * @throws CosmosException if the create fails (e.g., 409 Conflict)
     */
    public void createItem(String partitionKey, String jsonData) throws CosmosException {
        createItem(partitionKey, jsonData, null);
    }

    /**
     * Creates a new item in this container with request options.
     *
     * @param partitionKey the partition key value
     * @param jsonData     the item as a raw JSON string (must include "id" field)
     * @param options      request options (consistency, triggers, etc.), or null for defaults
     * @throws CosmosException if the create fails (e.g., 409 Conflict)
     */
    public void createItem(String partitionKey, String jsonData, CosmosItemRequestOptions options)
        throws CosmosException {
        // Today: options are passed as null to C-ABI (stubs).
        // Future: marshal options fields to C-ABI ItemOptions struct.
        CosmosNativeBridge.nativeCreateItem(callContext, containerHandle, partitionKey, jsonData);
    }

    /**
     * Reads an item from this container.
     *
     * @param itemId       the item ID
     * @param partitionKey the partition key value
     * @return the item response containing the raw JSON body
     * @throws CosmosException if the read fails (e.g., 404 NotFound)
     */
    public CosmosItemResponse readItem(String itemId, String partitionKey) throws CosmosException {
        return readItem(itemId, partitionKey, null);
    }

    /**
     * Reads an item from this container with request options.
     *
     * @param itemId       the item ID
     * @param partitionKey the partition key value
     * @param options      request options (consistency, session token, etc.), or null for defaults
     * @return the item response containing the raw JSON body
     * @throws CosmosException if the read fails (e.g., 404 NotFound)
     */
    public CosmosItemResponse readItem(String itemId, String partitionKey, CosmosItemRequestOptions options)
        throws CosmosException {
        // Today: options are passed as null to C-ABI (stubs).
        // Future: marshal options fields to C-ABI ItemReadOptions struct.
        String json = CosmosNativeBridge.nativeReadItem(callContext, containerHandle, partitionKey, itemId);
        return new CosmosItemResponse(json);
    }

    /**
     * Upserts an item in this container.
     */
    public void upsertItem(String partitionKey, String jsonData) throws CosmosException {
        upsertItem(partitionKey, jsonData, null);
    }

    /**
     * Upserts an item in this container with request options.
     */
    public void upsertItem(String partitionKey, String jsonData, CosmosItemRequestOptions options)
        throws CosmosException {
        CosmosNativeBridge.nativeUpsertItem(callContext, containerHandle, partitionKey, jsonData);
    }

    /**
     * Deletes an item from this container.
     */
    public void deleteItem(String itemId, String partitionKey) throws CosmosException {
        deleteItem(itemId, partitionKey, null);
    }

    /**
     * Deletes an item from this container with request options.
     */
    public void deleteItem(String itemId, String partitionKey, CosmosItemRequestOptions options)
        throws CosmosException {
        CosmosNativeBridge.nativeDeleteItem(callContext, containerHandle, partitionKey, itemId);
    }

    long getHandle() {
        return containerHandle;
    }

    void free() {
        CosmosNativeBridge.nativeContainerFree(containerHandle);
    }
}
