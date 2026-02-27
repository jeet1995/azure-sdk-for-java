---
name: cosmos-thin-client-single-region
description: >-
  Create a single-region Cosmos DB account in an ephemeral tenant for
  thin-client proxy testing. Simpler variant of cosmos-thin-client-account
  that deploys to one region only. Useful for basic thin-client validation
  without multi-region failover or multi-write scenarios.
  USE FOR: create single-region thin client account, quick thin client
  test account, single-region Cosmos DB for thin proxy, basic thin client
  validation account.
  DO NOT USE FOR: multi-region or multi-writer setups (use
  cosmos-thin-client-account), full end-to-end setup with Kusto + KV
  (use cosmos-thin-client-setup), RBAC setup (use cosmos-rbac-setup).
---

# Cosmos DB Thin-Client Single-Region Account

Create a single-region Cosmos DB account for basic thin-client proxy testing.

## Required Inputs

| Parameter | Description | Example |
|-----------|-------------|---------|
| `ACCOUNT_NAME` | Cosmos DB account name | `tc-single-region-test` |
| `RESOURCE_GROUP` | Azure resource group | `my-test-rg` |
| `SUBSCRIPTION_ID` | Azure subscription ID | `<your-subscription-id>` |
| `TENANT_ID` | Ephemeral tenant ID | `<tenant>.onmicrosoft.com` |
| `REGION` | Deployment region (must have thin-client federation) | `East US 2` |
| `TARGET_FEDERATION` | Thin-client-enabled federation ID | `cdb-ms-prod-eastus2-fe50` |

> The region MUST have a thin-client-enabled federation. Run the Kusto query from the `cosmos-thin-client-setup` skill to identify valid regions.

> **Terminal note:** For ephemeral tenant operations, use an **external admin terminal** (Windows Terminal as Administrator). VS Code's integrated terminal has WAM and UAC limitations that cause `az login` to hang or fail silently.

## Step 0 — Pre-Flight Auth Check

```bash
az login --tenant "<TENANT_ID>" --only-show-errors 2>&1
```

If you see `AADSTS5000224`, see the troubleshooting section at the bottom.

## Step 1 — Authenticate

```bash
az login --tenant "<TENANT_ID>"
az account set --subscription "<SUBSCRIPTION_ID>"
az account show --query "{name:name, id:id, tenantId:tenantId}" --output table
```

## Step 2 — Create the Account

```bash
az cosmosdb create \
  --name "<ACCOUNT_NAME>" \
  --resource-group "<RESOURCE_GROUP>" \
  --subscription "<SUBSCRIPTION_ID>" \
  --locations regionName="<REGION>" failoverPriority=0 isZoneRedundant=false \
  --default-consistency-level "Session" \
  --capabilities EnableNoSQLVectorSearch
```

Wait 5–15 minutes for provisioning.

### Post-Creation Validation

```bash
az cosmosdb show --name "<ACCOUNT_NAME>" --resource-group "<RESOURCE_GROUP>" \
  --query "{name:name, regions:locations[].locationName, capabilities:capabilities[].name, state:provisioningState}" -o json
```

Confirm: 1 region, `EnableNoSQLVectorSearch` present, `provisioningState: Succeeded`.

> **Tip:** For long-running commands, pipe output to a file:
> ```bash
> az cosmosdb create ... -o json 2>&1 | Out-File "$env:USERPROFILE\create-output.txt"
> ```

## Step 3 — Set Production Workload Type

Verify in the Azure Portal that the account uses **Provisioned throughput** (Production), not Serverless.

> The default `az cosmosdb create` without `--capabilities EnableServerless` creates a Provisioned throughput account.

## Step 4 — ACIS Compute Federation Migration (Manual)

1. Open [ACIS Portal](https://portal.microsoftgeneva.com)
2. Run: **"Migrate SQL account to Compute and Swap Endpoints"**
3. Set target federation: `<TARGET_FEDERATION>`
4. Only **one** ACIS action needed (single region)

References:
- [SQL on Compute tenant migration SOP](https://eng.ms/docs/cloud-ai-platform/azure-data/azure-data-azure-databases/cosmos-db/azure-cosmos-db/azure-cosmos-db-team-docs/sop/compute/sqltenantmigration)
- [Migrating between Compute federations SOP](https://eng.ms/docs/cloud-ai-platform/azure-data/azure-data-azure-databases/cosmos-db/azure-cosmos-db/azure-cosmos-db-team-docs/sop/compute/tenantmigration)

### If migration fails with audience error

Contact the Thin Client team (Anya Robinson, Sumant Bhardvaj, Chukang) to add your subscription to the federation audience.

## Outputs

| Output | How to Retrieve |
|--------|-----------------|
| Account Endpoint | `az cosmosdb show --name <ACCOUNT_NAME> --resource-group <RESOURCE_GROUP> --query documentEndpoint -o tsv` |
| Primary Key | `az cosmosdb keys list --name <ACCOUNT_NAME> --resource-group <RESOURCE_GROUP> --type keys --query primaryMasterKey -o tsv` |

Endpoint format depends on tenant type:
- Ephemeral test tenants: `https://<ACCOUNT_NAME>.documents-test.windows-int.net:443/`
- Standard tenants: `https://<ACCOUNT_NAME>.documents.azure.com:443/`

## Status Check (Idempotent)

```bash
az cosmosdb show --name "<ACCOUNT_NAME>" --resource-group "<RESOURCE_GROUP>" \
  --query "{name:name, regions:locations[].locationName, caps:capabilities[].name, state:provisioningState}" -o table
```

## Troubleshooting

| Problem | Solution |
|---------|----------|
| `AADSTS5000224` on `az login` | CLI app not consented in tenant. Use Portal, or have admin visit: `https://login.microsoftonline.com/<TENANT_GUID>/adminconsent?client_id=04b07795-8ddb-461a-bbee-02f9e1bf7b46` |
| `az login` hangs in VS Code | Use an external admin terminal |
| DNS name already taken | Account names are globally unique — use a different name |
| ACIS audience error | Contact Anya Robinson / Sumant Bhardvaj / Chukang |

## Verification

- [ ] Account created in 1 region with thin-client-enabled federation
- [ ] Production workload type confirmed in Portal
- [ ] `EnableNoSQLVectorSearch` capability confirmed
- [ ] ACIS Compute migration completed
- [ ] Federation has `IsThinClientEnabled = True` (verified via Kusto)
