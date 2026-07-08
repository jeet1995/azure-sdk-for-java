export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
cd ~
nohup java -jar ~/bench-v81.jar -workloadConfig ~/workloads/workload-V81-CG.json > ~/v4.81.0-cg-h2.log 2>&1 &
