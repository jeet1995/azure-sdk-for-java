cd ~/workloads
for f in workload-P-CG workload-P-TC workload-V81-CG workload-V80-CG workload-V79-CG; do
  if python3 -m json.tool < "$f.json" > /dev/null 2>&1; then
    id=$(python3 -c "import json;print(json.load(open('$f.json'))['orchestrator']['tenants'][0].get('id'))")
    echo "$f OK id=$id"
  else
    echo "$f INVALID_JSON"
  fi
done
