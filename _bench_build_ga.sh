#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
MVN=~/apache-maven-3.9.9/bin/mvn
SPEED="-T 1C -DskipTests -Dspotbugs.skip=true -Dcheckstyle.skip=true -Drevapi.skip=true -Denforcer.skip=true -Dmaven.javadoc.skip=true -Djacoco.skip=true -Dcodesnippet.skip=true"
set -o pipefail
cd ~/azure-sdk-for-java/sdk/cosmos/azure-cosmos-benchmark || { echo "NO_MODULE"; exit 1; }
build () {
  local V=$1 E=$2 OUT=$3
  echo "=== build azure-cosmos=$V encryption=$E -> $OUT $(date -u +%H:%M:%S) ==="
  $MVN clean package -Ppackage-assembly "-Dazure-cosmos.version=$V" "-Dazure-cosmos-encryption.version=$E" $SPEED || { echo "GA_BUILD_FAIL step=$OUT rc=$?"; exit 1; }
  cp target/azure-cosmos-benchmark-4.0.1-beta.1-jar-with-dependencies.jar ~/$OUT || { echo "GA_BUILD_FAIL step=copy-$OUT rc=$?"; exit 1; }
  echo "GA_ONE_DONE $OUT $(date -u +%H:%M:%S)"
}
build 4.81.0 2.30.0 bench-v81.jar
build 4.80.0 2.29.0 bench-v80.jar
build 4.79.0 2.28.0 bench-v79.jar
echo "GA_BUILD_DONE $(date -u +%H:%M:%S)"
ls -la ~/bench-v81.jar ~/bench-v80.jar ~/bench-v79.jar
