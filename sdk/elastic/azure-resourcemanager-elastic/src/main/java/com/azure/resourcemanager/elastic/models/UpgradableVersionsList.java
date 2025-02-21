// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elastic.models;

import com.azure.resourcemanager.elastic.fluent.models.UpgradableVersionsListInner;
import java.util.List;

/**
 * An immutable client-side representation of UpgradableVersionsList.
 */
public interface UpgradableVersionsList {
    /**
     * Gets the currentVersion property: Current version of the elastic monitor.
     * 
     * @return the currentVersion value.
     */
    String currentVersion();

    /**
     * Gets the upgradableVersions property: Stack Versions that this version can upgrade to.
     * 
     * @return the upgradableVersions value.
     */
    List<String> upgradableVersions();

    /**
     * Gets the inner com.azure.resourcemanager.elastic.fluent.models.UpgradableVersionsListInner object.
     * 
     * @return the inner object.
     */
    UpgradableVersionsListInner innerModel();
}
