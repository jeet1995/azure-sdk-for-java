# Release History

## 4.0.1-beta.1 (Unreleased)

### Features Added

- Made fault injection `operationType` optional, leaving the SDK condition unfiltered by operation type when omitted.

- Added `ReadWriteThroughput` for alternating independent creates and point reads in async and sync workloads.

- Added `orchestrator.metrics.sampleRate` to configure operation-level SDK diagnostics and metrics sampling for tenant workloads.

