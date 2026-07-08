import json,glob,os
d=r'C:\Users\abhmohanty\.copilot\session-state\2e84be8b-5490-4048-9862-d7b3d798c9b9\files\coldstart-templates'
for p in sorted(glob.glob(os.path.join(d,'workload-*.json'))):
    j=json.load(open(p,encoding='utf-8'))
    ai=j['orchestrator']['metrics']['destination']['applicationInsights']
    rid=ai['runId']
    t=j['orchestrator']['tenants'][0]
    before=t.get('id')
    if not before:
        t['id']=rid
    json.dump(j,open(p,'w',encoding='utf-8'),indent=1)
    print(os.path.basename(p),'runId=',rid,'id(before)=',before,'id(after)=',t['id'])
