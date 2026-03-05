---
name: cosmos-thin-client-setup
description: >-
  End-to-end orchestration for setting up Cosmos DB thin-client test accounts
  in an ephemeral tenant. Queries Kusto to find thin-client-enabled federations,
  selects US regions, creates both a multi-region and a multi-writer account
  (via the cosmos-thin-client-account skill), and documents Key Vault secret
  mapping and local config updates for CI pipeline integration.
  USE FOR: set up thin client test accounts end-to-end, create multi-region
  and multi-writer Cosmos DB accounts for thin client testing, thin client
  account provisioning workflow, replace thin client test accounts,
  rotate thin client test accounts, new thin client accounts in ephemeral tenant.
  DO NOT USE FOR: creating a single account (use cosmos-thin-client-account),
  RBAC setup (use cosmos-rbac-setup), network fault testing (use
  docker-network-fault-testing), standard Cosmos test account provisioning.
---

# Cosmos DB Thin-Client Test Account Setup (Orchestrator)

End-to-end workflow to provision two Cosmos DB accounts for thin-client proxy testing:
- **Multi-region account** — single-writer, multi-region reads
- **Multi-writer account** — multi-region writes enabled

Both accounts must be in regions with thin-client-enabled federations, have vector search enabled, and be migrated to Compute via ACIS.

## Required Inputs

| Parameter | Description | Example |
|-----------|-------------|---------|
| `TENANT_ID` | Ephemeral tenant ID | `<tenant>.onmicrosoft.com` |
| `SUBSCRIPTION_ID` | Azure subscription ID | `<your-subscription-id>` |
| `RESOURCE_GROUP` | Azure resource group | `my-test-rg` |
| `ACCOUNT_NAME_MULTI_REGION` | Multi-region account name | `tc-multi-region-ci` |
| `ACCOUNT_NAME_MULTI_WRITER` | Multi-writer account name | `tc-multi-writer-ci` |

> **Terminal note:** For ephemeral tenant operations, use an **external admin terminal** (Windows Terminal as Administrator). VS Code's integrated terminal has WAM and UAC limitations that cause `az login` to hang or fail silently.

> **Cosmos MCP alternative:** If CLI auth is blocked for a tenant, the Azure Cosmos DB MCP tool (`mcp_azure_mcp_cosmos`) can query/verify accounts using a `tenant` parameter. The Azure Kusto MCP tool (`mcp_azure_mcp_kusto`) can run federation queries. These bypass CLI auth issues.

## Step 1 — Query Thin-Client-Enabled Federations

Use the **azure-kusto** agent skill to run a KQL query against the Cosmos DB support cluster.

### Via azure-kusto skill (preferred)

Invoke the `kusto_query` MCP tool with:

| Parameter | Value |
|-----------|-------|
| cluster | `cdbsupport.kusto.windows.net` |
| database | `Support` |
| query | See KQL below |

```kql
ConfigurationTrace
| where Key contains "IsThinClientEnabled"
| where TIMESTAMP > ago(1d)
| where Value == "True"
| distinct FederationId
```

### Manual fallback (if MCP tools are unavailable)

1. Open [Kusto Explorer](https://cdbsupport.kusto.windows.net/Support) or [Azure Data Explorer Web UI](https://dataexplorer.azure.com/)
2. Connect to cluster: `cdbsupport.kusto.windows.net`, database: `Support`
3. Run the KQL query above
4. Copy the federation IDs from the results

### To check a specific region

```kql
ConfigurationTrace
| where Key contains "IsThinClientEnabled"
| where TIMESTAMP > ago(1d)
| where FederationId contains "eastus2"
| distinct FederationId, Key, Value, TIMESTAMP
| take 10
```

## Step 2 — Select Two US Regions

Parse the federation IDs from the Kusto query results. Federation IDs follow this pattern:

```
cdb-ms-prod-<region>-<federation-suffix>
```

### Region selection logic

1. **Filter to US regions only** — look for federation IDs containing: `eastus`, `eastus2`, `westus`, `westus2`, `westus3`, `centralus`, `northcentralus`, `southcentralus`, `westcentralus`
2. **Prefer early deployment batches** — federations with lower batch numbers (e.g., `fe01`–`fe50`) get the latest builds and fixes first
3. **Select 2 distinct regions** — e.g., `East US 2` and `Central US`
4. **Present to the user for confirmation** before proceeding

### Federation ID → Region mapping

| Federation pattern | Azure Region |
|-------------------|--------------|
| `*-eastus-*` | East US |
| `*-eastus2-*` | East US 2 |
| `*-centralus-*` | Central US |
| `*-westus-*` | West US |
| `*-westus2-*` | West US 2 |
| `*-westus3-*` | West US 3 |
| `*-northcentralus-*` | North Central US |
| `*-southcentralus-*` | South Central US |
| `*-westcentralus-*` | West Central US |

### Record the selected values

Note the **region names** and **federation IDs** — both are needed:
- Region names → passed to `az cosmosdb create --locations regionName=`
- Federation IDs → passed to ACIS Compute migration target

## Step 3 — Create Multi-Region Account

> **CRITICAL:** Specify both regions at creation time. Ephemeral test subscriptions block region changes after creation ("AZ migration capability is disabled"). If you get the regions wrong, you must delete and recreate.

Invoke the **cosmos-thin-client-account** skill with:

| Parameter | Value |
|-----------|-------|
| `ACCOUNT_NAME` | `<ACCOUNT_NAME_MULTI_REGION>` |
| `RESOURCE_GROUP` | `<RESOURCE_GROUP>` |
| `SUBSCRIPTION_ID` | `<SUBSCRIPTION_ID>` |
| `TENANT_ID` | `<TENANT_ID>` |
| `REGION_PRIMARY` | First selected region (e.g., `East US 2`) |
| `REGION_SECONDARY` | Second selected region (e.g., `Central US`) |
| `ENABLE_MULTI_WRITER` | `false` |
| `TARGET_FEDERATION` | Federation ID for primary region (e.g., `cdb-ms-prod-eastus2-fe50`) |

Follow all 6 steps in the atomic skill (create → portal capacity check → vector search → ACIS migration).

## Step 4 — Create Multi-Writer Account

Invoke the **cosmos-thin-client-account** skill with:

| Parameter | Value |
|-----------|-------|
| `ACCOUNT_NAME` | `<ACCOUNT_NAME_MULTI_WRITER>` |
| `RESOURCE_GROUP` | `<RESOURCE_GROUP>` |
| `SUBSCRIPTION_ID` | `<SUBSCRIPTION_ID>` |
| `TENANT_ID` | `<TENANT_ID>` |
| `REGION_PRIMARY` | Same first selected region |
| `REGION_SECONDARY` | Same second selected region |
| `ENABLE_MULTI_WRITER` | `true` |
| `TARGET_FEDERATION` | Same federation ID |

Follow all 6 steps in the atomic skill.

## Step 5 — Key Vault Secret Mapping (CI Pipelines)

The CI pipelines in `sdk/cosmos/tests.yml` pull credentials from Azure Key Vault via ADO variable groups. When creating or replacing test accounts, update the **secret values** in Key Vault.

### Secret mapping table

| Account | Pipeline Stage | KV Secret (Endpoint) | KV Secret (Key) |
|---------|---------------|---------------------|-----------------|
| `<ACCOUNT_NAME_MULTI_REGION>` | `Cosmos_Live_Test_ThinClient_MultiRegion` | `thin-client-canary-multi-region-session-endpoint` | `thin-client-canary-multi-region-session-key` |
| `<ACCOUNT_NAME_MULTI_WRITER>` | `Cosmos_Live_Test_ThinClient_MultiMaster` | `thin-client-canary-multi-writer-session-endpoint` | `thin-client-canary-multi-writer-session-key` |
| Reuse one of above | `Cosmos_Live_Test_ThinClient` | `thinclient-test-endpoint` | `thinclient-test-key` |

### How to update

1. Retrieve the endpoint and primary key for each account:
   ```bash
   az cosmosdb show --name <ACCOUNT_NAME> --resource-group <RESOURCE_GROUP> --query documentEndpoint -o tsv
   az cosmosdb keys list --name <ACCOUNT_NAME> --resource-group <RESOURCE_GROUP> --type keys --query primaryMasterKey -o tsv
   ```
2. Go to the Azure Key Vault that backs the pipeline variable group
3. Update **only the secret values** for the names listed above
4. No YAML or pipeline changes needed — the variable group reads from KV automatically
5. Pipeline will pick up new values on the next run

> **Important:** Pipelines will fail until Parts 0–2 of account setup (create → ACIS migration → vector search) are fully complete.

Variable group library: [Azure DevOps Variable Groups](https://dev.azure.com/azure-sdk/internal/_library?itemType=VariableGroups)

### If you need NEW secret names

Contact **Wes** to update the Key Vault → pipeline variable group mapping. Prefer reusing existing secret names ("secret hijacking") to avoid this.

## Step 6 — Local Test Configuration

Update `cosmos-v4.properties` (located at `sdk/cosmos/cosmos-v4.properties` or `~/cosmos-v4.properties`):

```properties
ACCOUNT_HOST=https://<ACCOUNT_NAME>.documents-test.windows-int.net:443/
ACCOUNT_KEY=<primary-key>
```

This file is not checked into source control. It's used for local test runs only.

## Completion Checklist

For EACH account (`<ACCOUNT_NAME_MULTI_REGION>` and `<ACCOUNT_NAME_MULTI_WRITER>`):

- [ ] Account created in 2 US regions with thin-client-enabled federations
- [ ] Production workload type verified in Azure Portal
- [ ] `EnableNoSQLVectorSearch` capability confirmed
- [ ] ACIS Compute migration completed for **both regions**
- [ ] KV secrets updated with new endpoint + key
- [ ] Local `cosmos-v4.properties` updated (if running tests locally)
- [ ] CI pipeline run passes with new accounts

## Troubleshooting

| Problem | Solution |
|---------|----------|
| `az login` fails with `AADSTS5000224` | The Azure CLI app is not consented in this tenant. Use the Portal, or have a tenant admin visit: `https://login.microsoftonline.com/<TENANT_GUID>/adminconsent?client_id=04b07795-8ddb-461a-bbee-02f9e1bf7b46` |
| `az login` hangs with no popup in VS Code | Use an **external admin terminal** (Windows Terminal as Admin). VS Code's terminal cannot surface WAM dialogs or UAC prompts |
| `az login` shows account picker then fails | Disable WAM: `az config set core.allow_broker=false`, clear cache: `az account clear`, then retry |
| Region change fails with "AZ migration capability disabled" | Cannot modify regions after creation on ephemeral subscriptions. Delete and recreate with correct regions |
| ACIS migration fails with audience error | Contact Anya Robinson / Sumant Bhardvaj / Chukang to add subscription to federation audience (do this per region) |
| Subscription not found in `az login` | Use `az login --tenant "<TENANT_ID>"` explicitly |
| Vector search errors after enabling capability | Wait 10+ minutes for propagation, then re-run tests |
| Thin client not working after ACIS migration | Verify federation has `IsThinClientEnabled = True` via Kusto query |
| Need thin client in a new region | Run the Kusto query to check for enabled federations in that region first |
| Account created in region without thin proxy | Create a new account in a supported region (see Step 2) or migrate |
| Pipeline fails with auth errors after account swap | Verify Key Vault secrets updated (Step 5); ensure Steps 1–4 are complete |
| Need new Key Vault → pipeline variable mapping | Contact Wes; prefer reusing existing secret names |
| DNS name already taken for account | The name is globally unique. Use a different name (e.g., add `-ci` suffix) or check if the account exists in another subscription |

## Status Check (Idempotent)

Run at any time to verify both accounts:

```bash
az cosmosdb list --subscription "<SUBSCRIPTION_ID>" \
  --query "[?contains(name,'thin-client')].{name:name, regions:locations[].locationName, multiWrite:enableMultipleWriteLocations, caps:capabilities[].name, state:provisioningState}" -o table
```

## Contacts

| Area | Contacts |
|------|----------|
| Thin Client / Federation migrations | Gary Fang, Anya Robinson, Sumant Bhardvaj |
| Federation audience changes | Anya Robinson, Chukang |
| Key Vault → pipeline variable mapping | Wes |
