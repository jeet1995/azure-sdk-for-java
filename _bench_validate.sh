#!/bin/bash
cd ~/workloads || exit 1
for f in workload-P-CG workload-P-TC workload-V81-CG workload-V80-CG workload-V79-CG; do
  python3 - "$f" <<'PY'
import json,sys
f=sys.argv[1]
try:
    d=json.load(open(f+'.json'))
except Exception as e:
    print(f, "INVALID", e); sys.exit(0)
keys=['runId','endpointFlavor','sdkVersion','operation','connectionMode','http2Enabled','cycles','numberOfCyclesForColdStart','settleTimeMs','maxRunningTimeDuration','concurrency']
present={k:d.get(k) for k in keys if k in d}
# also detect nested keys
print(f, "OK", present)
print("   top-level keys:", sorted(d.keys()))
PY
done
