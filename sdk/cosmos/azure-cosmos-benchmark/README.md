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

## SDK metrics sampling

Set `sampleRate` under `orchestrator.metrics` in the workload configuration:

```json
{
  "orchestrator": {
    "metrics": {
      "sampleRate": 0.1
    }
  }
}
```

Merge this fragment into a complete configuration with tenant definitions and the desired
metrics destination. The rate applies to all tenant workload clients and must be between
`0` and `1`, inclusive: `0.1` captures diagnostics for approximately 10% of SDK operations,
`0` disables operation diagnostics, and `1` captures all operations. This uses
`CosmosClientTelemetryConfig.sampleDiagnostics`, so it samples operation diagnostics
(logs, tracing, and eligible SDK metrics) together, not just exported metrics.
Omitting the setting preserves the SDK default, including any `COSMOS.METRICS_CONFIG`
sampling configuration; an explicit JSON value overrides that sampling rate.

Sampling does not enable a metrics destination, change the reporter interval, or sample
benchmark-owned operation counters and latency timers. SDK metrics can therefore represent
a different population from benchmark metrics; they are not automatically scaled to estimate
the full workload. Existing meter/category and diagnostic-threshold filters still apply.
In particular, standard async workloads currently enable transport-level diagnostic-threshold
filtering, so `sampleRate: 1` alone does not ensure every transport-level metric is recorded.

## SDK fault injection

Run the benchmark with `-workloadConfig workload-config.json`. To enable fault injection,
add this property to the desired entry in `orchestrator.tenants`:

```json
{
  "faultInjection": {
    "rules": [
      {
        "id": "read-500",
        "operationType": "READ_ITEM",
        "errorType": "INTERNAL_SERVER_ERROR",
        "injectionRate": 0.05,
        "startDelay": "PT10S",
        "duration": "PT30S",
        "hitLimit": 100
      }
    ]
  }
}
```

- `id` must be unique within the tenant. `operationType` matches SDK requests, not benchmark workload names:
  use `READ_ITEM`, `CREATE_ITEM`, or `QUERY_ITEM`.
- `errorType` accepts `INTERNAL_SERVER_ERROR` (500), `TOO_MANY_REQUEST` (429),
  `SERVICE_UNAVAILABLE` (503), `TIMEOUT` (408), `RESPONSE_DELAY`, or `CONNECTION_DELAY`.
  Both delay types require `delay` (e.g. `"PT0.2S"`).
- Optional `connectionType` must match the tenant's `DIRECT` or `GATEWAY` mode; it is inferred if omitted.
  Optional `region` limits the rule to that region. `injectionRate` is in `(0, 1]` and defaults to `1`.
- Rules are installed after setup and cooldown, just before dispatch. `startDelay` is measured from SDK rule
  installation, and `duration` limits the active window after that delay. Omit both to inject immediately
  through the end of dispatch, subject to any `hitLimit`. Durations use ISO 8601.

Each cycle logs `[FAULT_INJECTION]` hit counts per tenant and rule, including zero hits. Counts represent SDK
injections, not failed benchmark operations: retries can recover from an injected error.
This feature is opt-in for standard async and sync workloads. CTL and encryption workloads are excluded,
as are async configurations using shared connections, proactive connection management, or unwarmed containers.
SDK delay faults do not reproduce packet loss or kernel TCP timeouts.




