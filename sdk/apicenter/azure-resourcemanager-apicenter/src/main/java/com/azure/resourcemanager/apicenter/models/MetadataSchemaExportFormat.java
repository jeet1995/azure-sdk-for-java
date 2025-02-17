// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apicenter.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The format for schema export.
 */
public final class MetadataSchemaExportFormat extends ExpandableStringEnum<MetadataSchemaExportFormat> {
    /**
     * Static value inline for MetadataSchemaExportFormat.
     */
    public static final MetadataSchemaExportFormat INLINE = fromString("inline");

    /**
     * Static value link for MetadataSchemaExportFormat.
     */
    public static final MetadataSchemaExportFormat LINK = fromString("link");

    /**
     * Creates a new instance of MetadataSchemaExportFormat value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MetadataSchemaExportFormat() {
    }

    /**
     * Creates or finds a MetadataSchemaExportFormat from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MetadataSchemaExportFormat.
     */
    public static MetadataSchemaExportFormat fromString(String name) {
        return fromString(name, MetadataSchemaExportFormat.class);
    }

    /**
     * Gets known MetadataSchemaExportFormat values.
     * 
     * @return known MetadataSchemaExportFormat values.
     */
    public static Collection<MetadataSchemaExportFormat> values() {
        return values(MetadataSchemaExportFormat.class);
    }
}
