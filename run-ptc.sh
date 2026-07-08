export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
cd ~
nohup java -jar ~/bench-probe.jar -workloadConfig ~/workloads/workload-P-TC.json > ~/probe-tc-h2.log 2>&1 &
