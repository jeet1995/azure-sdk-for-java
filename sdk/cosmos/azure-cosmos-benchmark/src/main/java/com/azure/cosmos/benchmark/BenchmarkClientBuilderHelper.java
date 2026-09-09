// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.azure.cosmos.ConnectionMode;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.cosmos.Http2ConnectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Applies benchmark connection settings consistently across all workload implementations.
 */
public final class BenchmarkClientBuilderHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(BenchmarkClientBuilderHelper.class);

    private BenchmarkClientBuilderHelper() {
    }

    /**
     * Applies Direct or Gateway mode and the explicit HTTP/2 configuration for a workload.
     *
     * @param builder the client builder
     * @param config the workload configuration
     * @return the configured client builder
     */
    public static CosmosClientBuilder applyConnectionMode(
        CosmosClientBuilder builder,
        TenantWorkloadConfig config) {

        if (config.getConnectionMode() == ConnectionMode.DIRECT) {
            return builder.directMode(DirectConnectionConfig.getDefaultConfig());
        }

        GatewayConnectionConfig gatewayConfig = new GatewayConnectionConfig()
            .setMaxConnectionPoolSize(config.getMaxConnectionPoolSize());
        Http2ConnectionConfig http2Config = gatewayConfig.getHttp2ConnectionConfig();

        Boolean http2Enabled = config.getHttp2Mode().toNullableBoolean();
        if (http2Enabled != null) {
            http2Config.setEnabled(http2Enabled);
        }
        if (config.getHttp2MinConnectionPoolSize() != null) {
            http2Config.setMinConnectionPoolSize(config.getHttp2MinConnectionPoolSize());
        }
        if (config.getHttp2MaxConnectionPoolSize() != null) {
            http2Config.setMaxConnectionPoolSize(config.getHttp2MaxConnectionPoolSize());
        }
        if (config.getHttp2MaxConcurrentStreams() != null) {
            http2Config.setMaxConcurrentStreams(config.getHttp2MaxConcurrentStreams());
        }

        LOGGER.info(
            "Gateway transport configured: http2Mode={}, minConnections={}, maxConnections={}, maxStreams={}",
            config.getHttp2Mode(),
            http2Config.getMinConnectionPoolSize(),
            http2Config.getMaxConnectionPoolSize(),
            http2Config.getMaxConcurrentStreams());

        return builder.gatewayMode(gatewayConfig);
    }
}
