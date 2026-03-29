// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.models;

import java.util.List;

/**
 * Request options for item operations (create, read, upsert, replace, delete).
 *
 * <p>Matches the existing {@code CosmosItemRequestOptions} in azure-cosmos Java SDK.
 * A single type is used for all item operations — the SHIM maps to the appropriate
 * C-ABI options struct internally based on the operation being performed.</p>
 *
 * <p>Today the C-ABI layer ignores options (stubs). When the Rust SDK implements
 * the HierarchicalConfigModel, the SHIM will marshal these fields to the correct
 * C-ABI read/write option structs transparently — no public API change needed.</p>
 */
public final class CosmosItemRequestOptions {

    private String consistencyLevel;
    private String sessionToken;
    private String ifMatchETag;
    private Boolean contentResponseOnWriteEnabled;
    private List<String> excludedRegions;
    private String indexingDirective;
    private List<String> preTriggers;
    private List<String> postTriggers;

    public CosmosItemRequestOptions() {
    }

    public String getConsistencyLevel() {
        return consistencyLevel;
    }

    public CosmosItemRequestOptions setConsistencyLevel(String consistencyLevel) {
        this.consistencyLevel = consistencyLevel;
        return this;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public CosmosItemRequestOptions setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
        return this;
    }

    public String getIfMatchETag() {
        return ifMatchETag;
    }

    public CosmosItemRequestOptions setIfMatchETag(String ifMatchETag) {
        this.ifMatchETag = ifMatchETag;
        return this;
    }

    public Boolean isContentResponseOnWriteEnabled() {
        return contentResponseOnWriteEnabled;
    }

    public CosmosItemRequestOptions setContentResponseOnWriteEnabled(Boolean contentResponseOnWriteEnabled) {
        this.contentResponseOnWriteEnabled = contentResponseOnWriteEnabled;
        return this;
    }

    public List<String> getExcludedRegions() {
        return excludedRegions;
    }

    public CosmosItemRequestOptions setExcludedRegions(List<String> excludedRegions) {
        this.excludedRegions = excludedRegions;
        return this;
    }

    public String getIndexingDirective() {
        return indexingDirective;
    }

    public CosmosItemRequestOptions setIndexingDirective(String indexingDirective) {
        this.indexingDirective = indexingDirective;
        return this;
    }

    public List<String> getPreTriggers() {
        return preTriggers;
    }

    public CosmosItemRequestOptions setPreTriggers(List<String> preTriggers) {
        this.preTriggers = preTriggers;
        return this;
    }

    public List<String> getPostTriggers() {
        return postTriggers;
    }

    public CosmosItemRequestOptions setPostTriggers(List<String> postTriggers) {
        this.postTriggers = postTriggers;
        return this;
    }
}
