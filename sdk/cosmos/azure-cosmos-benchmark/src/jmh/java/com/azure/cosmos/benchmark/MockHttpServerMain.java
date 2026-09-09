// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import reactor.netty.http.HttpProtocol;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Launches {@link MockHttpServer} in a separate JVM for client-only CPU, GC, and native-memory measurements.
 */
public final class MockHttpServerMain {
    private MockHttpServerMain() {
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> options = parseOptions(args);
        HttpProtocol protocol = HttpProtocol.valueOf(options.getOrDefault("protocol", "H2"));
        int port = Integer.parseInt(options.getOrDefault("port", "8443"));
        int responseBodySize = Integer.parseInt(options.getOrDefault("responseBodySize", "0"));
        int workerCount = Integer.parseInt(options.getOrDefault(
            "workerCount",
            Integer.toString(Math.max(Runtime.getRuntime().availableProcessors(), 4))));
        long maxConcurrentStreams = Long.parseLong(options.getOrDefault("maxConcurrentStreams", "100"));
        long responseDelayMicros = Long.parseLong(options.getOrDefault("responseDelayMicros", "0"));
        int statsIntervalSeconds = Integer.parseInt(options.getOrDefault("statsIntervalSeconds", "10"));

        MockHttpServer server = new MockHttpServer(
            protocol,
            responseBodySize,
            workerCount,
            maxConcurrentStreams,
            responseDelayMicros,
            port);
        server.start();

        ScheduledExecutorService statsExecutor = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread thread = new Thread(r, "cosmos-jmh-server-stats");
            thread.setDaemon(true);
            return thread;
        });
        statsExecutor.scheduleAtFixedRate(
            () -> System.out.println("MOCK_SERVER_STATS " + server.snapshot()),
            statsIntervalSeconds,
            statsIntervalSeconds,
            TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            statsExecutor.shutdown();
            System.out.println("MOCK_SERVER_FINAL_STATS " + server.snapshot());
            server.close();
        }, "cosmos-jmh-server-shutdown"));

        System.out.println("MOCK_SERVER_READY"
            + " endpoint=" + server.endpoint()
            + " protocol=" + protocol
            + " pid=" + processId()
            + " workerCount=" + workerCount
            + " maxConcurrentStreams=" + maxConcurrentStreams
            + " responseBodySize=" + responseBodySize
            + " responseDelayMicros=" + responseDelayMicros);
        System.out.flush();

        server.awaitShutdown();
    }

    private static Map<String, String> parseOptions(String[] args) {
        Map<String, String> options = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            if (i + 1 >= args.length || !args[i].startsWith("--")) {
                throw new IllegalArgumentException(
                    "Arguments must be provided as --name value pairs.");
            }
            options.put(args[i].substring(2), args[i + 1]);
        }
        return options;
    }

    private static String processId() {
        String runtimeName = ManagementFactory.getRuntimeMXBean().getName();
        int separator = runtimeName.indexOf('@');
        return separator < 0 ? runtimeName : runtimeName.substring(0, separator);
    }
}
