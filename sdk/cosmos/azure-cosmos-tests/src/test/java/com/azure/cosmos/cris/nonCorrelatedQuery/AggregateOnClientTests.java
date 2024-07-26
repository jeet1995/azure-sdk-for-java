package com.azure.cosmos.cris.nonCorrelatedQuery;

import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.TestObject;
import com.azure.cosmos.implementation.TestConfigurations;
import com.azure.cosmos.implementation.TestSuiteBase;
import com.azure.cosmos.models.FeedResponse;
import com.azure.cosmos.models.ThroughputProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

public class AggregateOnClientTests extends TestSuiteBase {

    private static final Logger logger = LoggerFactory.getLogger(AggregateOnClientTests.class);

    @Test(groups = {"fast"})
    public void dCount() {

        CosmosClientBuilder clientBuilder = new CosmosClientBuilder()
            .key(TestConfigurations.MASTER_KEY)
            .endpoint(TestConfigurations.HOST);

        String databaseName = "queryTestDb";
        String containerName = "queryTestContainer";
        String queryString = "SELECT DISTINCT c.userId, c.tenantDomain, c.userstoreDomain FROM c WHERE (c.loginTimestamp BETWEEN \"2024-06-15 00:00:00Z\" AND \"2024-07-01 23:59:59Z\") AND c.tenantDomain = \"carbon.super\""; // modify sub-query here

        try (CosmosAsyncClient asyncClient = clientBuilder.buildAsyncClient()) {
            asyncClient.createDatabaseIfNotExists(databaseName).block();
            asyncClient.getDatabase(databaseName).createContainerIfNotExists(containerName, "/id", ThroughputProperties.createManualThroughput(400)).block();

            CosmosAsyncContainer asyncContainer
                = asyncClient.getDatabase(databaseName).getContainer(containerName);

            addDocumentsToContainerIfNoDocumentsPresent(asyncContainer, 10);

            String continuationToken = null;
            int resultCount = 0;

            // plug the continuation token back into the query execution until
            // all pages have been drained
            do {

                Iterable<FeedResponse<Object>> feedResponseIterable = asyncContainer
                    .queryItems(queryString, Object.class)
                    .byPage(continuationToken, 1)
                    .toIterable();

                for (FeedResponse<Object> feedResponse : feedResponseIterable) {

                    continuationToken = feedResponse.getContinuationToken();

                    // count can be aggregated across pages
                    resultCount += (feedResponse.getResults() != null ? feedResponse.getResults().size() : 0);

                    assert feedResponse.getCosmosDiagnostics() != null;

                    // the diagnostic string will have the activityId embedded in it
                    logger.info("Printing diagnostics : {}", feedResponse.getCosmosDiagnostics().toString());
                }
            }
            while (continuationToken != null);

            logger.info("Result count : {}", resultCount);
        }
    }

    private static void addDocumentsToContainerIfNoDocumentsPresent(CosmosAsyncContainer asyncContainer, int itemCount) {

        List<TestObject> insertedTestObjects = asyncContainer
            .queryItems("SELECT * FROM C OFFSET 0 LIMIT 1", TestObject.class)
            .collectList()
            .block();

        if (insertedTestObjects == null || insertedTestObjects.isEmpty()) {
            for (int i = 1; i <= itemCount; i++) {
                TestObject testObject = TestObject.create();

                asyncContainer
                    .createItem(testObject)
                    .block();
            }
        }
    }

}
