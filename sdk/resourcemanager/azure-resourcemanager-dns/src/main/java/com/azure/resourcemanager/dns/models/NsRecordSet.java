// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.resourcemanager.dns.models;

import com.azure.core.annotation.Fluent;
import java.util.List;

/** An immutable client-side representation of an NS (name server) record set in Azure DNS Zone. */
@Fluent
public interface NsRecordSet extends DnsRecordSet {
    /**
     * Gets the name server names of NS (name server) records in this record set.
     *
     * @return the name server names of NS (name server) records in this record set
     */
    List<String> nameServers();
}
