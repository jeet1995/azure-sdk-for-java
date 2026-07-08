import zipfile,sys
j="/home/azureuser/bench-probe.jar"
z=zipfile.ZipFile(j)
for n in z.namelist():
    if n.endswith("azure-cosmos/pom.properties") and "encryption" not in n:
        print("azure-cosmos:", [l for l in z.read(n).decode().splitlines() if l.startswith("version")])
    if n.endswith("azure-cosmos-encryption/pom.properties"):
        print("azure-cosmos-encryption:", [l for l in z.read(n).decode().splitlines() if l.startswith("version")])