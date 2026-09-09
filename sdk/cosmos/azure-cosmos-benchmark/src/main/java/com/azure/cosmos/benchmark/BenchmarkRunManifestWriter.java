// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.azure.cosmos.implementation.HttpConstants;
import com.sun.management.HotSpotDiagnosticMXBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.kqueue.KQueue;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslContext;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URI;
import java.time.Instant;

/**
 * Writes non-secret run provenance for benchmark result correlation.
 */
public final class BenchmarkRunManifestWriter {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private BenchmarkRunManifestWriter() {
    }

    /**
     * Writes the benchmark run manifest.
     *
     * @param config benchmark configuration
     * @param runId run identifier
     * @throws IOException if the manifest cannot be written
     */
    public static void write(BenchmarkConfig config, String runId) throws IOException {
        File manifestFile = resolveManifestFile(config, runId);
        File parent = manifestFile.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw new IOException("Unable to create run manifest directory: " + parent);
        }

        ObjectNode manifest = OBJECT_MAPPER.createObjectNode();
        manifest.put("runId", runId);
        manifest.put("createdAt", Instant.now().toString());
        manifest.put("phase", valueOrEmpty(config.getPhase()));
        manifest.put("sdkVersion", HttpConstants.Versions.getSdkVersion());
        manifest.put("azureCoreHttpNettyVersion",
            implementationVersion("com.azure.core.http.netty.NettyAsyncHttpClient"));
        manifest.put("reactorNettyVersion",
            implementationVersion("reactor.netty.http.client.HttpClient"));
        manifest.put("nettyVersion", implementationVersion("io.netty.util.Version"));
        manifest.put("javaVersion", System.getProperty("java.version", "unknown"));
        manifest.put("javaVendor", System.getProperty("java.vendor", "unknown"));
        manifest.put("osName", System.getProperty("os.name", "unknown"));
        manifest.put("osVersion", System.getProperty("os.version", "unknown"));
        manifest.put("osArch", System.getProperty("os.arch", "unknown"));
        manifest.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        manifest.put("nettyTransport", selectedNettyTransport());
        manifest.put("defaultSslProvider", SslContext.defaultClientProvider().name());
        manifest.put("openSslAvailable", OpenSsl.isAvailable());
        manifest.put("openSslVersion", OpenSsl.isAvailable() ? valueOrEmpty(OpenSsl.versionString()) : "");
        manifest.put("nativeMemoryStatsEnabled", config.isEnableNativeMemoryStats());
        manifest.put("nativeMemoryTracking", nativeMemoryTrackingMode());
        manifest.put("http2Mode", config.getHttp2Mode().name());
        manifest.put("thinClientMode", config.getThinClientMode().name());
        manifest.put("concurrency", config.getConcurrency());
        manifest.put("numberOfOperations", config.getNumberOfOperations());
        manifest.put("maxRunningTimeDuration",
            config.getMaxRunningTimeDuration() == null ? "" : config.getMaxRunningTimeDuration().toString());
        manifest.put("cycles", config.getCycles());

        ArrayNode tenants = manifest.putArray("tenants");
        for (TenantWorkloadConfig tenant : config.getTenantWorkloads()) {
            ObjectNode tenantNode = tenants.addObject();
            tenantNode.put("id", valueOrEmpty(tenant.getId()));
            tenantNode.put("serviceHost", serviceHost(tenant.getServiceEndpoint()));
            tenantNode.put("databaseId", valueOrEmpty(tenant.getDatabaseId()));
            tenantNode.put("containerId", valueOrEmpty(tenant.getContainerId()));
            tenantNode.put("operation", tenant.getOperationType().name());
            tenantNode.put("connectionMode", tenant.getConnectionMode().name());
            tenantNode.put("applicationName", valueOrEmpty(tenant.getApplicationName()));
            tenantNode.put("http2MinConnectionPoolSize",
                tenant.getHttp2MinConnectionPoolSize() == null ? -1 : tenant.getHttp2MinConnectionPoolSize());
            tenantNode.put("http2MaxConnectionPoolSize",
                tenant.getHttp2MaxConnectionPoolSize() == null ? -1 : tenant.getHttp2MaxConnectionPoolSize());
            tenantNode.put("http2MaxConcurrentStreams",
                tenant.getHttp2MaxConcurrentStreams() == null ? -1 : tenant.getHttp2MaxConcurrentStreams());
        }

        OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(manifestFile, manifest);
    }

    private static File resolveManifestFile(BenchmarkConfig config, String runId) {
        if (config.getRunManifestPath() != null && !config.getRunManifestPath().isEmpty()) {
            return new File(config.getRunManifestPath());
        }

        CsvReporterConfig csvConfig = config.getCsvReporterConfig();
        if (csvConfig != null) {
            return new File(csvConfig.getReportingDirectory(), "run-manifest-" + runId + ".json");
        }

        return new File("benchmark-output", "run-manifest-" + runId + ".json");
    }

    private static String implementationVersion(String className) {
        try {
            Package packageInfo = Class.forName(className).getPackage();
            return packageInfo == null ? "" : valueOrEmpty(packageInfo.getImplementationVersion());
        } catch (ClassNotFoundException e) {
            return "";
        }
    }

    private static String selectedNettyTransport() {
        if (Epoll.isAvailable()) {
            return "EPOLL";
        }
        if (KQueue.isAvailable()) {
            return "KQUEUE";
        }
        return "NIO";
    }

    private static String nativeMemoryTrackingMode() {
        try {
            HotSpotDiagnosticMXBean diagnostic =
                ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
            return diagnostic == null
                ? "unavailable"
                : valueOrEmpty(diagnostic.getVMOption("NativeMemoryTracking").getValue());
        } catch (RuntimeException e) {
            return "unavailable";
        }
    }

    private static String serviceHost(String endpoint) {
        if (endpoint == null || endpoint.isEmpty()) {
            return "";
        }
        try {
            return valueOrEmpty(URI.create(endpoint).getHost());
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    private static String valueOrEmpty(String value) {
        return value == null ? "" : value;
    }
}
