import json,sys
p=r'C:\Users\abhmohanty\.copilot\session-state\2e84be8b-5490-4048-9862-d7b3d798c9b9\files\coldstart-templates\workload-P-CG.json'
d=json.load(open(p))
def redact(o):
    if isinstance(o,dict):
        return {k:('***' if k.lower() in ('masterkey','connectionstring') else redact(v)) for k,v in o.items()}
    if isinstance(o,list): return [redact(x) for x in o]
    return o
print(json.dumps(redact(d),indent=1))
