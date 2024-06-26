// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.batch.implementation;

import com.azure.resourcemanager.batch.fluent.models.SupportedSkuInner;
import com.azure.resourcemanager.batch.models.SkuCapability;
import com.azure.resourcemanager.batch.models.SupportedSku;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

public final class SupportedSkuImpl implements SupportedSku {
    private SupportedSkuInner innerObject;

    private final com.azure.resourcemanager.batch.BatchManager serviceManager;

    SupportedSkuImpl(SupportedSkuInner innerObject, com.azure.resourcemanager.batch.BatchManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String name() {
        return this.innerModel().name();
    }

    public String familyName() {
        return this.innerModel().familyName();
    }

    public List<SkuCapability> capabilities() {
        List<SkuCapability> inner = this.innerModel().capabilities();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public OffsetDateTime batchSupportEndOfLife() {
        return this.innerModel().batchSupportEndOfLife();
    }

    public SupportedSkuInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.batch.BatchManager manager() {
        return this.serviceManager;
    }
}
