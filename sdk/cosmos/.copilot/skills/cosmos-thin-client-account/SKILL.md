---
name: cosmos-thin-client-account
description: >-
  Create a single Cosmos DB account in an ephemeral tenant for thin-client
  proxy testing. Generates az CLI commands for account creation, vector
  search enablement, and documents the manual ACIS Compute federation
  migration step. Handles both single-writer (multi-region reads) and
  multi-writer configurations.
  USE FOR: create Cosmos DB thin client account, provision thin client
  test account, cosmosdb create for thin proxy, thin client account in
  ephemeral tenant, create multi-region Cosmos account, create multi-writer
  Cosmos account.
  DO NOT USE FOR: full end-to-end thin client setup with region selection
  and Key Vault updates (use cosmos-thin-client-setup), RBAC setup (use
  cosmos-rbac-setup), network fault testing (use docker-network-fault-testing),
  standard Cosmos account creation without thin client requirements.
---

# Cosmos DB Thin-Client Account Creation

Create a single Cosmos DB account configured for thin-client proxy testing in an ephemeral tenant.

## Required Inputs

| Parameter | Description | Example |
|-----------|-------------|---------|
| `ACCOUNT_NAME` | Cosmos DB account name | `tc-multi-region-ci` |
| `RESOURCE_GROUP` | Azure resource group | `my-test-rg` |
| `SUBSCRIPTION_ID` | Azure subscription ID | `<your-subscription-id>` |
| `TENANT_ID` | Ephemeral tenant ID | `<tenant>.onmicrosoft.com` |
| `REGION_PRIMARY` | Primary region (failoverPriority=0) | `East US 2` |
| `REGION_SECONDARY` | Secondary region (failoverPriority=1) | `South Central US` |
| `ENABLE_MULTI_WRITER` | Enable multi-region writes | `true` or `false` |
| `TARGET_FEDERATION` | Thin-client-enabled federation ID | `cdb-ms-prod-eastus2-fe50` |

> All regions MUST have thin-client-enabled federations. Use the `cosmos-thin-client-setup` orchestrator skill or run the Kusto query manually to identify valid regions before invoking this skill.

> **CRITICAL — Regions are immutable on ephemeral subscriptions.** Many Cosmos DB ephemeral test subscriptions have "AZ migration capability disabled", which prevents adding, removing, or changing regions after account creation. **Always specify both regions at creation time.** If you need to change regions, you must delete and recreate the account.

> **Terminal note:** For ephemeral tenant operations, use an **external admin terminal** (Windows Terminal as Administrator). VS Code's integrated terminal has WAM and UAC limitations that cause `az login` to hang or fail silently.

## Step 0 — Pre-Flight Auth Check

Before running any CLI commands, verify you can authenticate to the ephemeral tenant:

```bash
az login --tenant "<TENANT_ID>" --only-show-errors 2>&1
```

If you see `AADSTS5000224` ("this resource is not available"), the Azure CLI first-party app is **not consented** in this tenant. You have three options:

1. **Admin consent URL** — Have a tenant admin visit:
   ```
   https://login.microsoftonline.com/<TENANT_GUID>/adminconsent?client_id=04b07795-8ddb-461a-bbee-02f9e1bf7b46
   ```
2. **Azure Portal** — Do all operations via [portal.azure.com](https://portal.azure.com) (switch directory to the target tenant). The Portal uses a different app ID that is almost universally consented.
3. **Service Principal** — If an app registration exists in the tenant:
   ```bash
   az login --service-principal -u "<app-id>" -p "<secret>" --tenant "<TENANT_ID>"
   ```

> **Alternative: Cosmos MCP tool.** If the subscription is accessible from any authenticated tenant, the Azure Cosmos DB MCP tool (`mcp_azure_mcp_cosmos`) can query accounts using a `tenant` parameter, bypassing CLI auth issues entirely.

## Step 1 — Authenticate to Ephemeral Tenant

```bash
az login --tenant "<TENANT_ID>"
az account set --subscription "<SUBSCRIPTION_ID>"
```

Verify:
```bash
az account show --query "{name:name, id:id, tenantId:tenantId}" --output table
```

> If the subscription is not visible, ensure you are using `--tenant` to target the ephemeral tenant explicitly.
> If `az login` hangs with no output in VS Code terminal, try an external admin terminal instead.

## Step 2 — Create the Cosmos DB Account

### For single-writer, multi-region reads (`ENABLE_MULTI_WRITER=false`):

```bash
az cosmosdb create \
  --name "<ACCOUNT_NAME>" \
  --resource-group "<RESOURCE_GROUP>" \
  --subscription "<SUBSCRIPTION_ID>" \
  --locations regionName="<REGION_PRIMARY>" failoverPriority=0 isZoneRedundant=false \
  --locations regionName="<REGION_SECONDARY>" failoverPriority=1 isZoneRedundant=false \
  --default-consistency-level "Session" \
  --capabilities EnableNoSQLVectorSearch
```

### For multi-writer (`ENABLE_MULTI_WRITER=true`):

```bash
az cosmosdb create \
  --name "<ACCOUNT_NAME>" \
  --resource-group "<RESOURCE_GROUP>" \
  --subscription "<SUBSCRIPTION_ID>" \
  --locations regionName="<REGION_PRIMARY>" failoverPriority=0 isZoneRedundant=false \
  --locations regionName="<REGION_SECONDARY>" failoverPriority=1 isZoneRedundant=false \
  --default-consistency-level "Session" \
  --enable-multiple-write-locations true \
  --capabilities EnableNoSQLVectorSearch
```

> **Note:** `isZoneRedundant=false` is explicit to avoid triggering AZ migration errors on restricted subscriptions. `--capabilities EnableNoSQLVectorSearch` is included at creation time to avoid a separate update step.

Wait for provisioning to complete (typically 5–15 minutes).

### Post-Creation Validation (required)

Immediately verify the account has the correct regions, multi-write setting, and capabilities:

```bash
az cosmosdb show --name "<ACCOUNT_NAME>" --resource-group "<RESOURCE_GROUP>" \
  --query "{name:name, regions:locations[].locationName, multiWrite:enableMultipleWriteLocations, capabilities:capabilities[].name, state:provisioningState}" -o json
```

If regions are wrong, you **must delete and recreate** — region changes are blocked on ephemeral subscriptions.

> **Tip for long-running commands:** Pipe output to a file to avoid terminal issues:
> ```bash
> az cosmosdb create ... -o json 2>&1 | Out-File "$env:USERPROFILE\create-output.txt"
> ```

## Step 3 — Set Production Workload Type

The `capacityMode` property (Production vs Dev/Test) is **not available via the Azure CLI** as of API version `2023-11-15`.

**Manual step — Azure Portal:**
1. Go to [Azure Portal](https://portal.azure.com) → Cosmos DB → `<ACCOUNT_NAME>`
2. Navigate to **Settings** → **Capacity** (or look for **Scale** settings)
3. Ensure the capacity mode is set to **Provisioned throughput** (Production)
4. If the account was created as Serverless, it cannot be changed — delete and recreate with the correct mode

> The default `az cosmosdb create` with `--locations` and no `--capabilities EnableServerless` creates a **Provisioned throughput** account, which is the Production mode. Verify in the portal after creation.

## Step 4 — Verify Vector Search

If you included `--capabilities EnableNoSQLVectorSearch` at creation time (recommended), vector search is already enabled. Verify:

```bash
az cosmosdb show \
  --resource-group "<RESOURCE_GROUP>" \
  --name "<ACCOUNT_NAME>" \
  --subscription "<SUBSCRIPTION_ID>" \
  --query "capabilities" \
  --output table
```

Expected output should include `EnableNoSQLVectorSearch`.

### If vector search was NOT enabled at creation time

```bash
az cosmosdb update \
  --ids "/subscriptions/<SUBSCRIPTION_ID>/resourceGroups/<RESOURCE_GROUP>/providers/Microsoft.DocumentDB/databaseAccounts/<ACCOUNT_NAME>" \
  --capabilities EnableNoSQLVectorSearch
```

Wait **5–10 minutes** for capability propagation, then verify with the show command above.

## Step 6 — ACIS Compute Federation Migration (Manual)

This step migrates the account to the Compute platform on a thin-client-enabled federation. It **must be done via the ACIS portal** — there is no CLI/API automation.

1. Open [ACIS Portal](https://portal.microsoftgeneva.com)
2. Run the action: **"Migrate SQL account to Compute and Swap Endpoints"**
3. Set the target federation to: `<TARGET_FEDERATION>` (e.g., `cdb-ms-prod-eastus2-fe50`)
4. **Repeat for EACH region** where the account is deployed (e.g., both `<REGION_PRIMARY>` and `<REGION_SECONDARY>`)

References:
- [SQL on Compute tenant migration SOP](https://eng.ms/docs/cloud-ai-platform/azure-data/azure-data-azure-databases/cosmos-db/azure-cosmos-db/azure-cosmos-db-team-docs/sop/compute/sqltenantmigration)
- [Migrating between Compute federations SOP](https://eng.ms/docs/cloud-ai-platform/azure-data/azure-data-azure-databases/cosmos-db/azure-cosmos-db/azure-cosmos-db-team-docs/sop/compute/tenantmigration)

### If migration fails with audience/capabilities error

Error message:
```
"The account has capabilities EnableSql. Please check the audiences,
 policies, and capabilities of the destination federation."
```

**Action:** Contact the Thin Client team to add your subscription to the destination federation's audience. This must be done for **each region**.

Contacts: Anya Robinson, Sumant Bhardvaj, Chukang

## Outputs

After successful creation, migration, and vector search enablement:

| Output | How to Retrieve |
|--------|-----------------|
| Account Endpoint | `az cosmosdb show --name <ACCOUNT_NAME> --resource-group <RESOURCE_GROUP> --query documentEndpoint -o tsv` |
| Primary Key | `az cosmosdb keys list --name <ACCOUNT_NAME> --resource-group <RESOURCE_GROUP> --type keys --query primaryMasterKey -o tsv` |

The endpoint format depends on the tenant type:
- Ephemeral test tenants: `https://<ACCOUNT_NAME>.documents-test.windows-int.net:443/`
- Standard tenants: `https://<ACCOUNT_NAME>.documents.azure.com:443/`

> **Alternative:** Use the Cosmos MCP tool to query accounts without CLI:
> ```
> cosmos_database_list with account=<ACCOUNT_NAME>, subscription=<SUBSCRIPTION_ID>, tenant=<TENANT_GUID>
> ```

## Status Check (Idempotent)

Run at any time to verify account state:

```bash
az cosmosdb list --subscription "<SUBSCRIPTION_ID>" \
  --query "[?contains(name,'thin-client')].{name:name, regions:locations[].locationName, multiWrite:enableMultipleWriteLocations, caps:capabilities[].name, state:provisioningState}" -o table
```

## Verification

The account is ready for thin-client testing when ALL of these are true:
- [ ] Account created in 2 regions with correct multi-writer setting
- [ ] Post-creation validation confirms correct regions (cannot change later)
- [ ] Production workload type confirmed in Portal
- [ ] `EnableNoSQLVectorSearch` capability visible in `az cosmosdb show`
- [ ] ACIS Compute migration completed for **both regions**
- [ ] Federation has `IsThinClientEnabled = True` (verified via Kusto)
