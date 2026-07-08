#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
cd ~/azure-sdk-for-java || { echo "NO_REPO"; exit 1; }
MVN=~/apache-maven-3.9.9/bin/mvn
SPEED="-T 1C -DskipTests -Dspotbugs.skip=true -Dcheckstyle.skip=true -Drevapi.skip=true -Denforcer.skip=true -Dmaven.javadoc.skip=true -Djacoco.skip=true -Dcodesnippet.skip=true"
set -o pipefail
echo "=== [1/3] install azure-cosmos (probe 4.82.0-beta.1) $(date -u +%H:%M:%S) ==="
cd ~/azure-sdk-for-java/sdk/cosmos/azure-cosmos || exit 1
$MVN install $SPEED || { echo "PROBE_BUILD_FAIL step=azure-cosmos rc=$?"; exit 1; }
echo "=== [2/3] install azure-cosmos-encryption (probe 2.31.0-beta.1) $(date -u +%H:%M:%S) ==="
cd ~/azure-sdk-for-java/sdk/cosmos/azure-cosmos-encryption || exit 1
$MVN install $SPEED || { echo "PROBE_BUILD_FAIL step=azure-cosmos-encryption rc=$?"; exit 1; }
echo "=== [3/3] package benchmark (probe defaults) $(date -u +%H:%M:%S) ==="
cd ~/azure-sdk-for-java/sdk/cosmos/azure-cosmos-benchmark || exit 1
$MVN clean package -Ppackage-assembly $SPEED || { echo "PROBE_BUILD_FAIL step=benchmark rc=$?"; exit 1; }
cp target/azure-cosmos-benchmark-4.0.1-beta.1-jar-with-dependencies.jar ~/bench-probe.jar || { echo "PROBE_BUILD_FAIL step=copy rc=$?"; exit 1; }
echo "PROBE_BUILD_DONE $(date -u +%H:%M:%S)"
ls -la ~/bench-probe.jar
