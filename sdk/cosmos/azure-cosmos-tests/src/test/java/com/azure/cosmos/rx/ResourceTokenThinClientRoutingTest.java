// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.rx;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncDatabase;
import com.azure.cosmos.CosmosAsyncUser;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.cosmos.Http2ConnectionConfig;
import com.azure.cosmos.implementation.RxDocumentClientImpl;
import com.azure.cosmos.implementation.TestConfigurations;
import com.azure.cosmos.implementation.directconnectivity.ReflectionUtils;
import com.azure.cosmos.implementation.throughputControl.TestItem;
import com.azure.cosmos.models.CosmosPermissionProperties;
import com.azure.cosmos.models.CosmosUserProperties;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.PermissionMode;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Validates that a {@code CosmosClient} authenticating with resource tokens is never routed through
 * the thin-client (Gateway V2) proxy - the proxy only supports master key / AAD authentication - and
 * that such a client still works end-to-end against a thin-client enabled account.
 */
public class ResourceTokenThinClientRoutingTest extends TestSuiteBase {

    private CosmosAsyncClient masterKeyClient;
    private CosmosAsyncDatabase sharedDatabase;
    private CosmosAsyncContainer sharedContainer;
    private TestItem createdItem;
    private CosmosPermissionProperties containerPermission;

    @Factory(dataProvider = "clientBuildersWithGatewayAndHttp2")
    public ResourceTokenThinClientRoutingTest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
        this.subscriberValidationTimeout = TIMEOUT;
    }

    @BeforeClass(groups = {"fi-thinclient-multi-region"}, timeOut = SETUP_TIMEOUT)
    public void before_ResourceTokenThinClientRoutingTest() {
        this.masterKeyClient = getClientBuilder().buildAsyncClient();
        this.sharedDatabase = getSharedCosmosDatabase(this.masterKeyClient);
        this.sharedContainer = getSharedMultiPartitionCosmosContainer(this.masterKeyClient);

        this.createdItem = TestItem.createNewItem();
        this.sharedContainer.createItem(this.createdItem).block();

        CosmosUserProperties userProperties = new CosmosUserProperties();
        userProperties.setId("ResourceTokenThinClientUser" + UUID.randomUUID());
        CosmosAsyncUser user = safeCreateUser(this.masterKeyClient, this.sharedDatabase.getId(), userProperties);

        this.containerPermission = user
            .createPermission(
                new CosmosPermissionProperties()
                    .setId("PermissionForContainer" + UUID.randomUUID())
                    .setPermissionMode(PermissionMode.ALL)
                    .setContainerName(this.sharedContainer.getId()),
                null)
            .block()
            .getProperties();
    }

    @AfterClass(groups = {"fi-thinclient-multi-region"}, timeOut = SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        safeClose(this.masterKeyClient);
    }

    @Test(groups = {"fi-thinclient-multi-region"}, timeOut = TIMEOUT)
    public void clientWithResourceToken_isNotThinClientEligible() {
        CosmosAsyncClient resourceTokenClient = null;
        try {
            resourceTokenClient = thinClientCapableBuilder()
                .resourceToken(this.containerPermission.getToken())
                .buildAsyncClient();

            assertThinClientNotUsed(resourceTokenClient);
            assertItemIsReadable(resourceTokenClient);
        } finally {
            safeClose(resourceTokenClient);
        }
    }

    @Test(groups = {"fi-thinclient-multi-region"}, timeOut = TIMEOUT)
    public void clientWithPermissionFeed_isNotThinClientEligible() {
        CosmosAsyncClient resourceTokenClient = null;
        try {
            List<CosmosPermissionProperties> permissionFeed = new ArrayList<>();
            permissionFeed.add(this.containerPermission);

            resourceTokenClient = thinClientCapableBuilder()
                .permissions(permissionFeed)
                .buildAsyncClient();

            assertThinClientNotUsed(resourceTokenClient);
            assertItemIsReadable(resourceTokenClient);
        } finally {
            safeClose(resourceTokenClient);
        }
    }

    private static CosmosClientBuilder thinClientCapableBuilder() {
        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
        gatewayConnectionConfig.setHttp2ConnectionConfig(new Http2ConnectionConfig().setEnabled(true));

        return new CosmosClientBuilder()
            .endpoint(TestConfigurations.HOST)
            .gatewayMode(gatewayConnectionConfig)
            .consistencyLevel(ConsistencyLevel.SESSION);
    }

    private static void assertThinClientNotUsed(CosmosAsyncClient client) {
        RxDocumentClientImpl documentClient =
            (RxDocumentClientImpl) ReflectionUtils.getAsyncDocumentClient(client);

        // Even though the client is in GATEWAY mode with HTTP/2 enabled against a thin-client enabled
        // account, resource token authentication makes the client thin-client ineligible.
        assertThat(documentClient.useThinClient()).isFalse();
    }

    private void assertItemIsReadable(CosmosAsyncClient client) {
        TestItem readItem = client
            .getDatabase(this.sharedDatabase.getId())
            .getContainer(this.sharedContainer.getId())
            .readItem(this.createdItem.getId(), new PartitionKey(this.createdItem.getMypk()), TestItem.class)
            .block()
            .getItem();

        assertThat(readItem.getId()).isEqualTo(this.createdItem.getId());
    }
}
