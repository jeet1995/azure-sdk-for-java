// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.changefeed.epkversion;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.implementation.Exceptions;
import com.azure.cosmos.implementation.InternalObjectNode;
import com.azure.cosmos.implementation.changefeed.ChangeFeedContextClient;
import com.azure.cosmos.implementation.changefeed.Lease;
import com.azure.cosmos.implementation.changefeed.ServiceItemLeaseUpdater;
import com.azure.cosmos.implementation.changefeed.exceptions.LeaseConflictException;
import com.azure.cosmos.implementation.changefeed.exceptions.LeaseLostException;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.PartitionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Instant;
import java.util.function.Function;

import static com.azure.cosmos.implementation.changefeed.common.ChangeFeedHelper.HTTP_STATUS_CODE_CONFLICT;
import static com.azure.cosmos.implementation.changefeed.common.ChangeFeedHelper.HTTP_STATUS_CODE_NOT_FOUND;
import static com.azure.cosmos.implementation.changefeed.common.ChangeFeedHelper.HTTP_STATUS_CODE_PRECONDITION_FAILED;
import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkNotNull;

/**
 * Implementation for service lease updater interface.
 */
class DocumentServiceLeaseUpdaterImpl implements ServiceItemLeaseUpdater {
    private static final Logger logger = LoggerFactory.getLogger(DocumentServiceLeaseUpdaterImpl.class);
    private static final int RETRY_COUNT_ON_CONFLICT = 5;

    private final ChangeFeedContextClient client;

    public DocumentServiceLeaseUpdaterImpl(ChangeFeedContextClient client) {
        checkNotNull(client, "Argument 'client' can not be null");

        this.client = client;
    }

    @Override
    public Mono<Lease> updateLease(
            final Lease cachedLease,
            String itemId,
            PartitionKey partitionKey,
            CosmosItemRequestOptions requestOptions,
            Function<Lease, Lease> updateLease) {

        // depends on the update function being passed, I've seen the following:
        //      1. update properties and owner on the lease - around when the lease is being acquired.
        //      2. set the continuation token on the lease - around when checkpointing has to be done.
        //      3. when the lease has to be renewed
        Lease localLease = updateLease.apply(cachedLease);

        if (localLease == null) {
            return Mono.empty();
        }

        // localLease is the lease which got locally updated
        localLease.setTimestamp(Instant.now());

        // cachedLease is returned from the service
        // why are we setting these properties on the cachedLease?
        // it is as though we are playing around with the same references but two different named bindings
        // cachedLease is what is used for replacement in the backend, localLease is just a copy
        cachedLease.setServiceItemLease(localLease);

        return
            Mono.just(this)
            .flatMap( value -> this.tryReplaceLease(cachedLease, itemId, partitionKey, requestOptions))
            .map(leaseDocument -> {
                // 'leaseDocument' is the response from the service
                cachedLease.setServiceItemLease(ServiceItemLeaseV1.fromDocument(leaseDocument));
                return cachedLease;
            })
            .hasElement()
            .flatMap(hasItems -> {
                if (hasItems) {
                    return Mono.just(cachedLease);
                }
                // Partition lease update conflict. Reading the current version of lease.
                // q: is the above comment incorrect - reason being Mono returns empty if precondition failed
                return this.client.readItem(itemId, partitionKey, requestOptions, InternalObjectNode.class)
                    .onErrorResume(throwable -> {
                        if (throwable instanceof CosmosException) {
                            CosmosException ex = (CosmosException) throwable;
                            if (Exceptions.isNotFound(ex)) {
                                logger.info("Lease with token {}: Failed to update. Lease could not be found.", cachedLease.getLeaseToken());
                                throw new LeaseLostException(cachedLease);
                            }
                        }
                        return Mono.error(throwable);
                    })
                    .map(cosmosItemResponse -> {
                        InternalObjectNode document =
                            BridgeInternal.getProperties(cosmosItemResponse);
                        ServiceItemLeaseV1 serverLease = ServiceItemLeaseV1.fromDocument(document);
                        logger.info(
                            "Lease with token {}: Failed to update. Lease with concurrency token '{}' was updated by owner '{}' with concurrency token '{}'.",
                            cachedLease.getLeaseToken(),
                            cachedLease.getConcurrencyToken(),
                            serverLease.getOwner(),
                            // concurrency token could map to the etag
                            serverLease.getConcurrencyToken());

                        // Check if we still have the expected ownership on the target lease.
                        if (serverLease.getOwner() != null && !serverLease.getOwner().equalsIgnoreCase(cachedLease.getOwner())) {
                            logger.info(
                                    "Lease with token {}: Failed to update. Lease was acquired already by owner '{}'",
                                    serverLease.getLeaseToken(),
                                    serverLease.getOwner());
                            throw new LeaseLostException(serverLease);
                        }

                        cachedLease.setTimestamp(Instant.now());
                        // q: what is a concurrency token in a lease?
                        cachedLease.setConcurrencyToken(serverLease.getConcurrencyToken());

                        throw new LeaseConflictException(cachedLease, "Lease update failed");
                    });
            })
            .retryWhen(Retry.max(RETRY_COUNT_ON_CONFLICT).filter(throwable -> {
                if (throwable instanceof LeaseConflictException) {
                    logger.info(
                        "Lease with token {}: Failed to update lease with concurrency token '{}', owner '{}'; will retry",
                        cachedLease.getLeaseToken(),
                        cachedLease.getConcurrencyToken(),
                        cachedLease.getOwner());
                    return true;
                }
                return false;
            }))
            .onErrorResume(throwable -> {
                if (throwable instanceof LeaseConflictException) {
                    logger.warn(
                        "Lease with token {}: Failed to update lease with concurrency token '{}', owner '{}', continuationToken '{}'.",
                        cachedLease.getLeaseToken(),
                        cachedLease.getConcurrencyToken(),
                        cachedLease.getOwner(),
                        cachedLease.getReadableContinuationToken(), throwable);

                    return Mono.just(cachedLease);
                }
                return Mono.error(throwable);
            });
    }

    private Mono<InternalObjectNode> tryReplaceLease(
            Lease lease,
            String itemId,
            PartitionKey partitionKey,
            CosmosItemRequestOptions cosmosItemRequestOptions) throws LeaseLostException {

        // ChangeFeedContextClient is like a decorator for CosmosAsyncContainer
        //      - composes reactor calls with an additional publishOn call
        return this.client.replaceItem(
                itemId,
                partitionKey,
                lease,
                this.getCreateIfMatchOptions(cosmosItemRequestOptions, lease))
            .map(cosmosItemResponse -> BridgeInternal.getProperties(cosmosItemResponse))
            .onErrorResume(re -> {
                if (re instanceof CosmosException) {
                    CosmosException ex = (CosmosException) re;
                    switch (ex.getStatusCode()) {
                        // if-match request header mismatch with ETag
                        case HTTP_STATUS_CODE_PRECONDITION_FAILED: {
                            return Mono.empty();
                        }
                        // two replace requests on the ID + pkVal pair on two or more regions
                        // q: how is this status code returned by the service when if-match request header is set?
                        case HTTP_STATUS_CODE_CONFLICT: {
                            // q: why is a LeaseConflictException not thrown?
                            throw new LeaseLostException(lease, ex, false);
                        }
                        case HTTP_STATUS_CODE_NOT_FOUND: {
                            throw new LeaseLostException(lease, ex, true);
                        }
                        default: {
                            return Mono.error(re);
                        }
                    }
                }
                return Mono.error(re);
            });
    }

    private CosmosItemRequestOptions getCreateIfMatchOptions(CosmosItemRequestOptions createIfMatchOptions, Lease lease) {
        createIfMatchOptions.setIfMatchETag(lease.getConcurrencyToken());

        return createIfMatchOptions;
    }
}
