# Azure Monitor Logs Query client library for Java

The Azure Monitor Logs Query client library is used to execute read-only queries against [Azure Monitor][azure_monitor_overview]'s logs data platform:

- [Logs](https://learn.microsoft.com/azure/azure-monitor/logs/data-platform-logs) - Collects and organizes log and performance data from monitored resources. Data from different sources such as platform logs from Azure services, log and performance data from virtual machines agents, and usage and performance data from apps can be consolidated into a single [Azure Log Analytics workspace](https://learn.microsoft.com/azure/azure-monitor/logs/data-platform-logs#log-analytics-and-workspaces). The various data types can be analyzed together using the [Kusto Query Language][kusto_query_language].

**Resources:**

- [Source code][source]
- [Package (Maven)][package]
- [API reference documentation][msdocs_apiref]
- [Service documentation][azure_monitor_overview]
- [Samples][samples]
- [Change log][changelog]

## Getting started

### Prerequisites

- A [Java Development Kit (JDK)][jdk_link], version 8 or later
    - Here are details about [Java 8 client compatibility with Azure Certificate Authority](https://learn.microsoft.com/azure/security/fundamentals/azure-ca-details?tabs=root-and-subordinate-cas-list#client-compatibility-for-public-pkis).
- An [Azure subscription][azure_subscription]
- A [TokenCredential](https://learn.microsoft.com/java/api/com.azure.core.credential.tokencredential?view=azure-java-stable) implementation, such as an [Azure Identity library credential type](https://learn.microsoft.com/java/api/overview/azure/identity-readme?view=azure-java-stable#credential-classes).
- To query Logs, you need an [Azure Log Analytics workspace][azure_monitor_create_using_portal] or an Azure resource of any kind (Storage Account, Key Vault, Cosmos DB, etc.).

### Include the package

#### Include the BOM file

Include the `azure-sdk-bom` to your project to take a dependency on the stable version of the library. In the following snippet, replace the `{bom_version_to_target}` placeholder with the version number. To learn more about the BOM, see the [AZURE SDK BOM README](https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/boms/azure-sdk-bom/README.md).

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.azure</groupId>
            <artifactId>azure-sdk-bom</artifactId>
            <version>{bom_version_to_target}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

Then include the direct dependency in the `dependencies` section without the version tag:

```xml
<dependencies>
  <dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-monitor-query-logs</artifactId>
  </dependency>
</dependencies>
```

#### Include direct dependency

If you want to take dependency on a particular version of the library that isn't present in the BOM, add the direct dependency to your project as follows.

[//]: # ({x-version-update-start;com.azure:azure-monitor-query;current})

```xml
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-monitor-query-logs</artifactId>
    <version>2.0.0</version>
</dependency>
```

[//]: # ({x-version-update-end})

### Create the client

An authenticated client is required to query Logs. The library includes both synchronous and asynchronous forms of the clients. To authenticate, the following examples use `DefaultAzureCredentialBuilder` from the [azure-identity](https://central.sonatype.com/artifact/com.azure/azure-identity/1.8.1) package.

### Authenticate using Microsoft Entra ID

You can authenticate with Microsoft Entra ID using the [Azure Identity library][azure_identity]. Regional endpoints don't support Microsoft Entra authentication. Create a [custom subdomain][custom_subdomain] for your resource to use this type of authentication.

To use the [DefaultAzureCredential][DefaultAzureCredential] provider shown below, or other credential providers provided with the Azure Identity library, include the `azure-identity` package:

[//]: # ({x-version-update-start;com.azure:azure-identity;dependency})
```xml
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-identity</artifactId>
    <version>1.15.3</version>
</dependency>
```
[//]: # ({x-version-update-end})

Set the values of the client ID, tenant ID, and client secret of the Microsoft Entra application as environment variables: `AZURE_CLIENT_ID`, `AZURE_TENANT_ID`, `AZURE_CLIENT_SECRET`.

#### Synchronous clients

```java readme-sample-createLogsQueryClient
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();
```

#### Asynchronous clients

```java readme-sample-createLogsQueryAsyncClient
LogsQueryAsyncClient logsQueryAsyncClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildAsyncClient();
```

#### Configure client for Azure sovereign cloud

By default, `LogsQueryClient` is configured to connect to the Azure Public Cloud. To use a sovereign cloud instead, set the correct endpoint in the client builders.  

- Creating a `LogsQueryClient` for Azure China Cloud:

    ```java readme-sample-createLogsQueryClientWithSovereignCloud
    LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
        .credential(new DefaultAzureCredentialBuilder().build())
        .endpoint("https://api.loganalytics.azure.cn/v1")
        .buildClient();
    ```

### Execute the query

For examples of Logs queries, see the [Examples](#examples) section.

## Key concepts

### Logs query rate limits and throttling

The Log Analytics service applies throttling when the request rate is too high. Limits, such as the maximum number of rows returned, are also applied on the Kusto queries. For more information, see [Query API](https://learn.microsoft.com/azure/azure-monitor/service-limits#la-query-api).

## Examples

- [Logs query](#logs-query)
    - [Map logs query results to a model](#map-logs-query-results-to-a-model)
    - [Handle logs query response](#handle-logs-query-response)
    - [Query logs by resource ID](#query-logs-by-resource-id)
- [Batch logs query](#batch-logs-query)
- [Advanced logs query scenarios](#advanced-logs-query-scenarios)
    - [Set logs query timeout](#set-logs-query-timeout)
    - [Query multiple workspaces](#query-multiple-workspaces)
    - [Include statistics](#include-statistics)
    - [Include visualization](#include-visualization)
    - [Overcome Log Analytics query size limitations](#overcome-log-analytics-query-size-limitations)

### Logs query

```java readme-sample-logsquery
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

LogsQueryResult queryResults = logsQueryClient.queryWorkspace("{workspace-id}", "{kusto-query}",
    new LogsQueryTimeInterval(Duration.ofDays(2)));

for (LogsTableRow row : queryResults.getTable().getRows()) {
    System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
}
```

#### Map logs query results to a model

```java readme-sample-custommodel
public class CustomLogModel {
    private String resourceGroup;
    private String operationName;

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getOperationName() {
        return operationName;
    }
}
```

```java readme-sample-logsquerycustommodel
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

List<CustomLogModel> customLogModels = logsQueryClient.queryWorkspace("{workspace-id}", "{kusto-query}",
    new LogsQueryTimeInterval(Duration.ofDays(2)), CustomLogModel.class);

for (CustomLogModel customLogModel : customLogModels) {
    System.out.println(customLogModel.getOperationName() + " " + customLogModel.getResourceGroup());
}
```

#### Handle logs query response

The `query` API returns the `LogsQueryResult`, while the `queryBatch` API returns the `LogsBatchQueryResult`. Here's a hierarchy of the response:

```
LogsQueryResult / LogsBatchQueryResult
|---id (this exists in `LogsBatchQueryResult` object only)
|---status (this exists in `LogsBatchQueryResult` object only)
|---statistics
|---visualization
|---error
|---tables (list of `LogsTable` objects)
    |---name
    |---rows (list of `LogsTableRow` objects)
        |--- rowIndex
        |--- rowCells (list of `LogsTableCell` objects)
    |---columns (list of `LogsTableColumn` objects)
        |---name
        |---type
```

#### Query logs by resource ID

The `LogsQueryClient` supports querying logs using a workspace ID (`queryWorkspace` methods) or a resource ID (`queryResource` methods).
See the following example of querying logs using a resource ID. Similar changes can be applied to all other samples.

```java readme-sample-logsquerybyresourceid
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

LogsQueryResult queryResults = logsQueryClient.queryResource("{resource-id}", "{kusto-query}",
    new LogsQueryTimeInterval(Duration.ofDays(2)));

for (LogsTableRow row : queryResults.getTable().getRows()) {
    System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
}
```

### Batch logs query

```java readme-sample-batchlogsquery
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

LogsBatchQuery logsBatchQuery = new LogsBatchQuery();
String query1 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-1}", new LogsQueryTimeInterval(Duration.ofDays(2)));
String query2 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-2}", new LogsQueryTimeInterval(Duration.ofDays(30)));
String query3 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-3}", new LogsQueryTimeInterval(Duration.ofDays(10)));

LogsBatchQueryResultCollection batchResults = logsQueryClient
    .queryBatchWithResponse(logsBatchQuery, Context.NONE).getValue();

LogsBatchQueryResult query1Result = batchResults.getResult(query1);
for (LogsTableRow row : query1Result.getTable().getRows()) {
    System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
}

List<CustomLogModel> customLogModels = batchResults.getResult(query2, CustomLogModel.class);
for (CustomLogModel customLogModel : customLogModels) {
    System.out.println(customLogModel.getOperationName() + " " + customLogModel.getResourceGroup());
}

LogsBatchQueryResult query3Result = batchResults.getResult(query3);
if (query3Result.getQueryResultStatus() == LogsQueryResultStatus.FAILURE) {
    System.out.println(query3Result.getError().getMessage());
}
```

### Advanced logs query scenarios

#### Set logs query timeout

```java readme-sample-logsquerytimeout
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

// set request options: server timeout
LogsQueryOptions options = new LogsQueryOptions()
    .setServerTimeout(Duration.ofMinutes(10));

Response<LogsQueryResult> response = logsQueryClient.queryWorkspaceWithResponse("{workspace-id}",
    "{kusto-query}", new LogsQueryTimeInterval(Duration.ofDays(2)), options, Context.NONE);
```

#### Query multiple workspaces

To run the same query against multiple Log Analytics workspaces, use the `LogsQueryOptions.setAdditionalWorkspaces` method.

When multiple workspaces are included in the query, the logs in the result table aren't grouped according to the
workspace from which it was retrieved. To identify the workspace of a row in the result table, you can inspect the
"TenantId" column in the result table. If this column isn't in the table, then you may have to update your query string
to include this column.

```java readme-sample-logsquerymultipleworkspaces
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

Response<LogsQueryResult> response = logsQueryClient.queryWorkspaceWithResponse("{workspace-id}", "{kusto-query}",
    new LogsQueryTimeInterval(Duration.ofDays(2)), new LogsQueryOptions()
        .setAdditionalWorkspaces(Arrays.asList("{additional-workspace-identifiers}")),
    Context.NONE);
LogsQueryResult result = response.getValue();
```

#### Include statistics

To get logs query execution statistics, such as CPU and memory consumption:

1. Use `LogsQueryOptions` to request for statistics in the response by setting `setIncludeStatistics()` to `true`.
2. Invoke the `getStatistics` method on the `LogsQueryResult` object.

The following example prints the query execution time:
```java readme-sample-includestatistics
LogsQueryClient client = new LogsQueryClientBuilder()
    .credential(credential)
    .buildClient();

LogsQueryOptions options = new LogsQueryOptions()
    .setIncludeStatistics(true);
Response<LogsQueryResult> response = client.queryWorkspaceWithResponse("{workspace-id}",
    "AzureActivity | top 10 by TimeGenerated", LogsQueryTimeInterval.LAST_1_HOUR, options, Context.NONE);
LogsQueryResult result = response.getValue();
BinaryData statistics = result.getStatistics();

ObjectMapper objectMapper = new ObjectMapper();
JsonNode statisticsJson = objectMapper.readTree(statistics.toBytes());
JsonNode queryStatistics = statisticsJson.get("query");
System.out.println("Query execution time = " + queryStatistics.get("executionTime").asDouble());
```

Because the structure of the statistics payload varies by query, a `BinaryData` return type is used. It contains the
raw JSON response. The statistics are found within the `query` property of the JSON. For example:

```json
{
  "query": {
    "executionTime": 0.0156478,
    "resourceUsage": {...},
    "inputDatasetStatistics": {...},
    "datasetStatistics": [{...}]
  }
}
```

#### Include visualization

To get visualization data for logs queries using the [render operator](https://learn.microsoft.com/azure/data-explorer/kusto/query/renderoperator?pivots=azuremonitor):

1. Use `LogsQueryOptions` to request for visualization data in the response by setting `setIncludeVisualization()` to `true`.
2. Invoke the `getVisualization` method on the `LogsQueryResult` object.

For example:
```java readme-sample-includevisualization
LogsQueryClient client = new LogsQueryClientBuilder()
    .credential(credential)
    .buildClient();

String visualizationQuery = "StormEvents"
    + "| summarize event_count = count() by State"
    + "| where event_count > 10"
    + "| project State, event_count"
    + "| render columnchart";
LogsQueryOptions options = new LogsQueryOptions()
    .setIncludeVisualization(true);
Response<LogsQueryResult> response = client.queryWorkspaceWithResponse("{workspace-id}", visualizationQuery,
    LogsQueryTimeInterval.LAST_7_DAYS, options, Context.NONE);
LogsQueryResult result = response.getValue();
BinaryData visualization = result.getVisualization();

ObjectMapper objectMapper = new ObjectMapper();
JsonNode visualizationJson = objectMapper.readTree(visualization.toBytes());
System.out.println("Visualization graph type = " + visualizationJson.get("visualization").asText());
```

Because the structure of the visualization payload varies by query, a `BinaryData` return type is used. It contains the
raw JSON response. For example:

```json
{
  "visualization": "columnchart",
  "title": null,
  "accumulate": false,
  "isQuerySorted": false,
  "kind": null,
  "legend": null,
  "series": null,
  "yMin": "",
  "yMax": "",
  "xAxis": null,
  "xColumn": null,
  "xTitle": null,
  "yAxis": null,
  "yColumns": null,
  "ySplit": null,
  "yTitle": null,
  "anomalyColumns": null
}
```

#### Overcome Log Analytics query size limitations

If your query exceeds the [service limits][service_limits], see the large log query documentation to learn how to overcome them.

## Troubleshooting

See our [troubleshooting guide](https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/monitor/azure-monitor-query/TROUBLESHOOTING.md)
for details on how to diagnose various failure scenarios.

## Next steps

To learn more about Azure Monitor, see the [Azure Monitor service documentation][azure_monitor_overview].

## Contributing

This project welcomes contributions and suggestions. Most contributions require you to agree to a [Contributor License Agreement (CLA)][cla] declaring that you have the right to, and actually do, grant us the rights to use your contribution.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate
the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to
do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][coc]. For more information, see
the [Code of Conduct FAQ][coc_faq] or contact [opencode@microsoft.com][coc_contact] with any additional questions or
comments.

<!-- LINKS -->

[azure_identity]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/identity/azure-identity/README.md
[azure_monitor_create_using_portal]: https://learn.microsoft.com/azure/azure-monitor/logs/quick-create-workspace
[azure_monitor_overview]: https://learn.microsoft.com/azure/azure-monitor/overview
[azure_subscription]: https://azure.microsoft.com/free/java
[changelog]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/monitor/azure-monitor-query/CHANGELOG.md
[custom_subdomain]: https://learn.microsoft.com/azure/cognitive-services/authentication?tabs=powershell#create-a-resource-with-a-custom-subdomain
[DefaultAzureCredential]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/identity/azure-identity/README.md#defaultazurecredential
[jdk_link]: https://learn.microsoft.com/java/azure/jdk/?view=azure-java-stable
[kusto_query_language]: https://learn.microsoft.com/azure/data-explorer/kusto/query/
[log_levels]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/core/azure-core/src/main/java/com/azure/core/util/logging/ClientLogger.java
[msdocs_apiref]: https://learn.microsoft.com/java/api/com.azure.monitor.query?view=azure-java-stable
[package]: https://central.sonatype.com/artifact/com.azure/azure-monitor-query-logs
[samples]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/monitor/azure-monitor-query-logs/src/samples/README.md
[source]: https://github.com/Azure/azure-sdk-for-java/tree/main/sdk/monitor/azure-monitor-query-logs/src
[performance_tuning]: https://github.com/Azure/azure-sdk-for-java/wiki/Performance-Tuning
[service_limits]: https://learn.microsoft.com/azure/azure-monitor/service-limits#log-queries-and-language

[cla]: https://cla.microsoft.com
[coc]: https://opensource.microsoft.com/codeofconduct/
[coc_faq]: https://opensource.microsoft.com/codeofconduct/faq/
[coc_contact]: mailto:opencode@microsoft.com


