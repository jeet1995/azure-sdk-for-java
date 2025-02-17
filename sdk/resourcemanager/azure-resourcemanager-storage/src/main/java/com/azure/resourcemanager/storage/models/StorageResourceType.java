// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.storage.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/** Storage resource types. */
public class StorageResourceType extends ExpandableStringEnum<StorageResourceType> {
    /** Static value storageAccounts for StorageResourceType. */
    public static final StorageResourceType STORAGE_ACCOUNTS = fromString("storageAccounts");

    /**
     * Creates a new instance of StorageResourceType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public StorageResourceType() {
    }

    /**
     * Finds or creates storage resource type based on the specified string.
     *
     * @param str the storage resource type in string format
     * @return an instance of StorageResourceType
     */
    public static StorageResourceType fromString(String str) {
        return fromString(str, StorageResourceType.class);
    }

    /**
     * Gets known storage resource types.
     *
     * @return known storage resource types
     */
    public static Collection<StorageResourceType> values() {
        return values(StorageResourceType.class);
    }
}
