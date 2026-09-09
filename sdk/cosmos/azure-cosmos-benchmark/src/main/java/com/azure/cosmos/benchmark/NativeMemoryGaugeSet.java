// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.sun.management.OperatingSystemMXBean;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.binder.MeterBinder;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocatorMetric;

import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Exposes process and Netty native-memory gauges for transport benchmark comparisons.
 */
public final class NativeMemoryGaugeSet implements MeterBinder {
    private static final Path PROC_SELF_STATUS = Paths.get("/proc/self/status");

    private final BufferPoolMXBean directBufferPool;
    private final BufferPoolMXBean mappedBufferPool;
    private final OperatingSystemMXBean operatingSystem;
    private final PooledByteBufAllocatorMetric pooledAllocator;

    public NativeMemoryGaugeSet() {
        BufferPoolMXBean direct = null;
        BufferPoolMXBean mapped = null;
        for (BufferPoolMXBean pool : ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class)) {
            if ("direct".equals(pool.getName())) {
                direct = pool;
            } else if ("mapped".equals(pool.getName())) {
                mapped = pool;
            }
        }
        this.directBufferPool = direct;
        this.mappedBufferPool = mapped;

        java.lang.management.OperatingSystemMXBean os = ManagementFactory.getOperatingSystemMXBean();
        this.operatingSystem = os instanceof OperatingSystemMXBean ? (OperatingSystemMXBean) os : null;

        ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;
        this.pooledAllocator = allocator instanceof PooledByteBufAllocator
            ? ((PooledByteBufAllocator) allocator).metric()
            : null;
    }

    @Override
    public void bindTo(MeterRegistry registry) {
        bindBufferPool(registry, directBufferPool, "direct");
        bindBufferPool(registry, mappedBufferPool, "mapped");

        Gauge.builder("benchmark.native.netty.allocator.used.direct.bytes", this, NativeMemoryGaugeSet::nettyDirectBytes)
            .description("Direct memory currently used by Netty's default pooled allocator")
            .register(registry);
        Gauge.builder("benchmark.native.netty.allocator.used.heap.bytes", this, NativeMemoryGaugeSet::nettyHeapBytes)
            .description("Heap memory currently used by Netty's default pooled allocator")
            .register(registry);
        Gauge.builder("benchmark.native.netty.allocator.direct.arenas", this, NativeMemoryGaugeSet::nettyDirectArenas)
            .description("Number of direct arenas in Netty's default pooled allocator")
            .register(registry);
        Gauge.builder("benchmark.native.netty.allocator.thread.local.caches", this,
                NativeMemoryGaugeSet::nettyThreadLocalCaches)
            .description("Number of thread-local caches in Netty's default pooled allocator")
            .register(registry);
        Gauge.builder("benchmark.native.process.committed.virtual.bytes", this,
                NativeMemoryGaugeSet::committedVirtualMemoryBytes)
            .description("Committed virtual memory size of the benchmark process")
            .register(registry);
        Gauge.builder("benchmark.native.process.rss.bytes", this, NativeMemoryGaugeSet::residentSetSizeBytes)
            .description("Resident set size of the benchmark process when available from /proc/self/status")
            .register(registry);
    }

    private void bindBufferPool(MeterRegistry registry, BufferPoolMXBean pool, String poolName) {
        if (pool == null) {
            return;
        }

        Tags tags = Tags.of("pool", poolName);
        Gauge.builder("benchmark.native.buffer.used.bytes", pool, BufferPoolMXBean::getMemoryUsed)
            .description("Memory used by a JVM buffer pool")
            .tags(tags)
            .register(registry);
        Gauge.builder("benchmark.native.buffer.capacity.bytes", pool, BufferPoolMXBean::getTotalCapacity)
            .description("Total capacity of buffers in a JVM buffer pool")
            .tags(tags)
            .register(registry);
        Gauge.builder("benchmark.native.buffer.count", pool, BufferPoolMXBean::getCount)
            .description("Number of buffers in a JVM buffer pool")
            .tags(tags)
            .register(registry);
    }

    private double nettyDirectBytes() {
        return pooledAllocator == null ? Double.NaN : pooledAllocator.usedDirectMemory();
    }

    private double nettyHeapBytes() {
        return pooledAllocator == null ? Double.NaN : pooledAllocator.usedHeapMemory();
    }

    private double nettyDirectArenas() {
        return pooledAllocator == null ? Double.NaN : pooledAllocator.numDirectArenas();
    }

    private double nettyThreadLocalCaches() {
        return pooledAllocator == null ? Double.NaN : pooledAllocator.numThreadLocalCaches();
    }

    private double committedVirtualMemoryBytes() {
        return operatingSystem == null ? Double.NaN : operatingSystem.getCommittedVirtualMemorySize();
    }

    private double residentSetSizeBytes() {
        if (!Files.isReadable(PROC_SELF_STATUS)) {
            return Double.NaN;
        }

        try {
            List<String> lines = Files.readAllLines(PROC_SELF_STATUS);
            for (String line : lines) {
                if (line.startsWith("VmRSS:")) {
                    String value = line.substring("VmRSS:".length()).trim().split("\\s+")[0];
                    return Long.parseLong(value) * 1024D;
                }
            }
        } catch (IOException | NumberFormatException ignored) {
            // Gauge consumers represent unavailable platform data as NaN.
        }

        return Double.NaN;
    }
}
