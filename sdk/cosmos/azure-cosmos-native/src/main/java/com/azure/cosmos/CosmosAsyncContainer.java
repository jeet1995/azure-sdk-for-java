// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos;

import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;

/**
 * Async wrapper for container item operations.
 * All blocking JNI calls run on {@code Schedulers.boundedElastic()}.
 */
public final class CosmosAsyncContainer {

    private final CosmosContainer syncContainer;

    CosmosAsyncContainer(CosmosContainer syncContainer) {
        this.syncContainer = syncContainer;
    }

    public String getId() {
        return syncContainer.getId();
    }

    public Mono<Void> createItem(String partitionKey, String jsonData) {
        return createItem(partitionKey, jsonData, null);
    }

    public Mono<Void> createItem(String partitionKey, String jsonData, CosmosItemRequestOptions options) {
        return Mono.<Void>fromCallable(() -> {
            syncContainer.createItem(partitionKey, jsonData, options);
            return null;
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public CompletableFuture<Void> createItemAsync(String partitionKey, String jsonData) {
        return createItem(partitionKey, jsonData).toFuture();
    }

    public Mono<CosmosItemResponse> readItem(String itemId, String partitionKey) {
        return readItem(itemId, partitionKey, null);
    }

    public Mono<CosmosItemResponse> readItem(String itemId, String partitionKey, CosmosItemRequestOptions options) {
        return Mono.fromCallable(() -> syncContainer.readItem(itemId, partitionKey, options))
            .subscribeOn(Schedulers.boundedElastic());
    }

    public CompletableFuture<CosmosItemResponse> readItemAsync(String itemId, String partitionKey) {
        return readItem(itemId, partitionKey).toFuture();
    }

    public Mono<Void> upsertItem(String partitionKey, String jsonData) {
        return upsertItem(partitionKey, jsonData, null);
    }

    public Mono<Void> upsertItem(String partitionKey, String jsonData, CosmosItemRequestOptions options) {
        return Mono.<Void>fromCallable(() -> {
            syncContainer.upsertItem(partitionKey, jsonData, options);
            return null;
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Void> deleteItem(String itemId, String partitionKey) {
        return deleteItem(itemId, partitionKey, null);
    }

    public Mono<Void> deleteItem(String itemId, String partitionKey, CosmosItemRequestOptions options) {
        return Mono.<Void>fromCallable(() -> {
            syncContainer.deleteItem(itemId, partitionKey, options);
            return null;
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
