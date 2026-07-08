import sys, zipfile
jar = sys.argv[1] if len(sys.argv) > 1 else "/home/azureuser/bench-probe.jar"
want = ("azure-cosmos", "azure-cosmos-encryption")
z = zipfile.ZipFile(jar)
found = {}
for n in z.namelist():
    if n.startswith("META-INF/maven/com.azure/") and n.endswith("pom.properties"):
        d = {}
        for line in z.read(n).decode().splitlines():
            if "=" in line and not line.startswith("#"):
                k, v = line.split("=", 1)
                d[k.strip()] = v.strip()
        aid = d.get("artifactId", "")
        if aid in want:
            found[aid] = d.get("version", "?")
print(jar)
for a in want:
    print("  " + a + " = " + found.get(a, "NOT FOUND"))