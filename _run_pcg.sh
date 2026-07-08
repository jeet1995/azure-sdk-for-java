export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
cd ~
nohup java -jar ~/bench-probe.jar -workloadConfig ~/workloads/workload-P-CG.json > ~/probe-cg-h2.log 2>&1 &
echo "PID_LAUNCHED"
sleep 3
pgrep -af 'bench-probe.jar' | head -5