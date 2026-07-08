#!/bin/bash
cd ~/workloads || exit 1
for f in workload-P-CG workload-P-TC workload-V81-CG workload-V80-CG workload-V79-CG; do
  python3 - "$f" <<'PY'
import json,sys
f=sys.argv[1]
d=json.load(open(f+'.json'))
SECRET=('key','masterkey','connectionstring','password','secret','instrumentationkey')
def walk(o,path=''):
    hits={}
    if isinstance(o,dict):
        for k,v in o.items():
            kl=str(k).lower()
            if any(s in kl for s in SECRET):
                continue
            if kl in ('runid','endpointflavor','sdkversion','operation','connectionmode','http2enabled','cycles','settletimems','maxrunningtimeduration','concurrency','thinclientenabled','gcbetweencycles','suppresscleanup','databaseid','database','containerid','container') or k.startswith('//'):
                hits[path+'/'+str(k)]=v
            hits.update(walk(v,path+'/'+str(k)))
    elif isinstance(o,list):
        for i,v in enumerate(o):
            hits.update(walk(v,path+f'[{i}]'))
    return hits
h=walk(d)
print("=== %s ==="%f)
for k in sorted(h): print("  %s = %r"%(k,h[k]))
PY
done
