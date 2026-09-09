# Azure Cosmos DB Client Library for Java

# Benchmarking Tool

## Build the benchmarking tool

```bash
git clone https://github.com/Azure/azure-sdk-for-java.git
cd azure-sdk-for-java
cd sdk/cosmos/
mvn clean package -f pom.xml -DskipTests -Dgpg.skip -Ppackage-assembly
```

and then the package will be generated.

## Build against a production SDK version

The SDK-under-test versions are Maven properties so the same benchmark harness can be built against a released
production artifact or a locally installed release candidate.

```bash
mvn -f sdk/cosmos/azure-cosmos-benchmark/pom.xml package \
  -Dazure-cosmos.version=4.81.0 \
  -Dazure-cosmos-encryption.version=2.30.0 \
  -DskipTests -Dgpg.skip -Ppackage-assembly
```

Use matching Cosmos and encryption versions. Record the resolved dependency tree for every baseline artifact.

## Pin transport and routing behavior

Production comparisons should explicitly set transport and routing modes instead of relying on the SDK default:

```json
{
  "orchestrator": {
    "runId": "http2-baseline-001",
    "phase": "production-baseline",
    "runManifestPath": "/tmp/benchmark-output/run-manifest.json",
    "tenantDefaults": {
      "connectionMode": "Gateway",
      "http2Mode": "DISABLED",
      "thinClientMode": "DISABLED"
    }
  }
}
```

Supported values for both modes are `DEFAULT`, `ENABLED`, and `DISABLED`. All tenants in one benchmark JVM must use
the same values because Direct-mode HTTP/2 metadata routing and ThinClient selection use JVM-wide SDK configuration.
Run different transport variations in separate processes.

The benchmark writes a non-secret run manifest containing the SDK and transport dependency versions, JDK/OS details,
Netty transport and SSL provider, transport modes, workload settings, and account host names.

Enable periodic native-memory gauges with:

```json
"metrics": {
  "enableJvmStats": true,
  "enableNettyHttpMetrics": true,
  "enableNativeMemoryStats": true
}
```

This reports JVM direct/mapped buffer pools, Netty pooled allocator direct/heap usage and arena/cache counts, process
committed virtual memory, and Linux RSS when `/proc/self/status` is available. The run manifest also records whether
HotSpot Native Memory Tracking is enabled.

For detailed category-level NMT comparisons, start the benchmark with:

```bash
java -XX:NativeMemoryTracking=summary ...
```

Then capture `jcmd <pid> VM.native_memory baseline` after warmup and
`jcmd <pid> VM.native_memory summary.diff scale=MB` after the measurement window. Do not poll NMT from the request hot
path.

## Run the WriteThroughput workload

```bash
java -jar azure-cosmos-benchmark/target/azure-cosmos-benchmark-4.0.1-beta.1-jar-with-dependencies.jar \
 -serviceEndpoint $endpoint -masterKey $masterkey \
 -databaseId $dbname -collectionId $colname \
 -consistencyLevel Eventual -concurrency 10 -numberOfOperations 1000000 \
 -operation WriteThroughput -connectionMode Direct
```

## Sample Report:

```
2/13/19 9:32:39 PM =============================================================

-- Meters ----------------------------------------------------------------------
#Successful Operations
             count = 89934
         mean rate = 1798.56 events/second
     1-minute rate = 1718.45 events/second
     5-minute rate = 1630.17 events/second
    15-minute rate = 1610.01 events/second
#Unsuccessful Operations
             count = 0
         mean rate = 0.00 events/second
     1-minute rate = 0.00 events/second
     5-minute rate = 0.00 events/second
    15-minute rate = 0.00 events/second

-- Timers ----------------------------------------------------------------------
Latency
             count = 89938
         mean rate = 1798.64 calls/second
     1-minute rate = 1718.65 calls/second
     5-minute rate = 1630.37 calls/second
    15-minute rate = 1610.21 calls/second
               min = 3.97 milliseconds
               max = 22.81 milliseconds
              mean = 5.37 milliseconds
            stddev = 0.96 milliseconds
            median = 5.26 milliseconds
              75% <= 5.70 milliseconds
              95% <= 6.40 milliseconds
              98% <= 6.93 milliseconds
              99% <= 7.51 milliseconds
            99.9% <= 17.37 milliseconds
```

## Other Currently Supported Workloads

* ReadThroughput,
* WriteThroughput,
* QueryInClauseParallel
* ReadMyWrites


You can provide ``--help`` to the tool to see the list of other work loads (read, etc) and other options.

## Run transport microbenchmarks

The benchmark module contains JMH microbenchmarks for isolating Cosmos transport overhead from service and internet
latency. Enable the repository-standard JMH annotation processor with the `jmh-benchmark` property.

```bash
mvn -f sdk/cosmos/azure-cosmos-benchmark/pom.xml compile dependency:build-classpath \
  -Djmh-benchmark \
  -Dmdep.includeScope=compile \
  -Dmdep.outputFile=target/jmh-classpath.txt

java -cp "sdk/cosmos/azure-cosmos-benchmark/target/classes:$(cat sdk/cosmos/azure-cosmos-benchmark/target/jmh-classpath.txt)" \
  org.openjdk.jmh.Main HttpProtocolLoopbackBenchmark -prof gc
```

`HttpProtocolLoopbackBenchmark` compares three warm TLS scenarios against an in-process server:

- `H1_NATIVE`: H1 client configuration against an H1-only server.
- `H2_NATIVE`: H2+H1 client configuration negotiating H2 with an H2 server.
- `H1_FALLBACK`: H2+H1 client configuration negotiating/falling back to an H1-only server.

It excludes initial connection establishment from the measured operation and currently covers empty and 1-KB
responses. The fallback scenario detects cases where protocol negotiation succeeds functionally but H1 connection
reuse differs under Reactor Netty's H2-aware connection provider.

The in-process server uses configurable Reactor Netty event loops and tracks accepted parent connections, closed
parents, peak concurrent requests, and the maximum requests served by a closed parent. Use JMH threads and connection
parameters to pressure the Cosmos client while keeping enough server capacity:

```bash
java -cp "<benchmark classes and generated dependency classpath>" \
  org.openjdk.jmh.Main HttpProtocolLoopbackBenchmark \
  -t 64 \
  -p scenario=H1_NATIVE,H2_NATIVE,H1_FALLBACK \
  -p clientMaxConnections=1,4,16 \
  -p pendingAcquireMaxCount=DEFAULT,128 \
  -p serverWorkerCount=8 \
  -p serverMaxConcurrentStreams=30,100 \
  -p serverResponseDelayMicros=0,1000 \
  -prof gc
```

The server emits `MOCK_SERVER_STATS` at trial teardown. If peak server request concurrency reaches the configured
worker capacity or server CPU saturates, increase `serverWorkerCount` before interpreting the run as client-bound.

`pendingAcquireMaxCount=DEFAULT` preserves Reactor Netty's normal pending-acquire limit. Use an explicit value such as
`128` for a capacity-matched H1/H2 comparison where oversubscribed H1 requests should queue instead of being rejected.
Report both results—the default value is product behavior, while the explicit value isolates transport hot-path cost.

### Run the mock server in a separate JVM

For client-only CPU, GC, RSS, direct-memory, and NMT measurements, launch the mock server separately:

```bash
java -cp "<benchmark classes and generated dependency classpath>" \
  com.azure.cosmos.benchmark.MockHttpServerMain \
  --protocol H2 \
  --port 8443 \
  --workerCount 8 \
  --maxConcurrentStreams 100 \
  --responseBodySize 0 \
  --responseDelayMicros 0 \
  --statsIntervalSeconds 10
```

Then point the JMH client at it:

```bash
java -Dcosmos.jmh.serverEndpoint=https://127.0.0.1:8443/benchmark \
  -cp "<benchmark classes and generated dependency classpath>" \
  org.openjdk.jmh.Main HttpProtocolLoopbackBenchmark \
  -p scenario=H2_NATIVE \
  -p clientMaxConnections=1,4,16 \
  -prof gc
```

Use `H1_NATIVE` with an `HTTP11` server and `H1_FALLBACK` with an `HTTP11` server plus an H2-enabled client. The
benchmark checks the request record's negotiated protocol on every invocation and fails if it does not match the
scenario.

On Windows PowerShell, replace the classpath separator (`:`) with `;` and read the generated classpath with
`Get-Content`.
