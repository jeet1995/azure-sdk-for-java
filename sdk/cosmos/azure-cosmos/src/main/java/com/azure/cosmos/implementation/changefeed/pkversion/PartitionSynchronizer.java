// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.changefeed.pkversion;

import com.azure.cosmos.implementation.changefeed.Lease;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * READ DocDB partitions and create leases if they do not exist.
 */
public interface PartitionSynchronizer {
    /**
     * Creates missing leases during startup.
     *
     * @return a deferred computation of this operation.
     */
    Mono<Void> createMissingLeases();

    /**
     * Handles partition slip.
     *
     * @param lease the lease.
     * @return the split partition documents.
     */
    Flux<Lease> splitPartition(Lease lease);
}
