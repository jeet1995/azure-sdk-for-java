// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.models;

import com.azure.core.management.SystemData;
import com.azure.resourcemanager.postgresqlflexibleserver.fluent.models.LogFileInner;
import java.time.OffsetDateTime;

/** An immutable client-side representation of LogFile. */
public interface LogFile {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     *
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the createdTime property: Creation timestamp of the log file.
     *
     * @return the createdTime value.
     */
    OffsetDateTime createdTime();

    /**
     * Gets the lastModifiedTime property: Last modified timestamp of the log file.
     *
     * @return the lastModifiedTime value.
     */
    OffsetDateTime lastModifiedTime();

    /**
     * Gets the sizeInKb property: The size in kb of the logFile.
     *
     * @return the sizeInKb value.
     */
    Long sizeInKb();

    /**
     * Gets the typePropertiesType property: Type of the log file.
     *
     * @return the typePropertiesType value.
     */
    String typePropertiesType();

    /**
     * Gets the url property: The url to download the log file from.
     *
     * @return the url value.
     */
    String url();

    /**
     * Gets the inner com.azure.resourcemanager.postgresqlflexibleserver.fluent.models.LogFileInner object.
     *
     * @return the inner object.
     */
    LogFileInner innerModel();
}