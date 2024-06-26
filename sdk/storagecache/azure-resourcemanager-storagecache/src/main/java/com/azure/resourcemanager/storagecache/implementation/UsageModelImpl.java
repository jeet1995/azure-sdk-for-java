// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.implementation;

import com.azure.resourcemanager.storagecache.fluent.models.UsageModelInner;
import com.azure.resourcemanager.storagecache.models.UsageModel;
import com.azure.resourcemanager.storagecache.models.UsageModelDisplay;

public final class UsageModelImpl implements UsageModel {
    private UsageModelInner innerObject;

    private final com.azure.resourcemanager.storagecache.StorageCacheManager serviceManager;

    UsageModelImpl(UsageModelInner innerObject,
        com.azure.resourcemanager.storagecache.StorageCacheManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public UsageModelDisplay display() {
        return this.innerModel().display();
    }

    public String modelName() {
        return this.innerModel().modelName();
    }

    public String targetType() {
        return this.innerModel().targetType();
    }

    public UsageModelInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.storagecache.StorageCacheManager manager() {
        return this.serviceManager;
    }
}
