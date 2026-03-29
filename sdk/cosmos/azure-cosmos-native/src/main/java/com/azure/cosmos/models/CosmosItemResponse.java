// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.models;

/**
 * Represents a response from a Cosmos DB item operation.
 *
 * <p>The body is raw JSON (as a String) because the driver is schema-agnostic.
 * Callers deserialize with Jackson, Gson, or any JSON library of their choice.</p>
 */
public final class CosmosItemResponse {

    private final String body;

    public CosmosItemResponse(String body) {
        this.body = body;
    }

    /**
     * Returns the item body as a raw JSON string.
     */
    public String getBody() {
        return body;
    }
}
