// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.eventgrid.EventGridManager;
import com.azure.resourcemanager.eventgrid.models.DataResidencyBoundary;
import com.azure.resourcemanager.eventgrid.models.Domain;
import com.azure.resourcemanager.eventgrid.models.EventDefinitionKind;
import com.azure.resourcemanager.eventgrid.models.IdentityType;
import com.azure.resourcemanager.eventgrid.models.InputSchema;
import com.azure.resourcemanager.eventgrid.models.IpActionType;
import com.azure.resourcemanager.eventgrid.models.PublicNetworkAccess;
import com.azure.resourcemanager.eventgrid.models.Sku;
import com.azure.resourcemanager.eventgrid.models.TlsVersion;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DomainsGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"privateEndpointConnections\":[{\"properties\":{\"privateEndpoint\":{},\"groupIds\":[\"qady\"],\"privateLinkServiceConnectionState\":{},\"provisioningState\":\"Succeeded\"},\"id\":\"hwriuo\",\"name\":\"zczfkiceevs\",\"type\":\"axwspcaxikhfjqeb\"}],\"provisioningState\":\"Failed\",\"minimumTlsVersionAllowed\":\"1.1\",\"endpoint\":\"gzzromv\",\"inputSchema\":\"CloudEventSchemaV1_0\",\"eventTypeInfo\":{\"kind\":\"Inline\",\"inlineEventTypes\":{\"lyt\":{\"description\":\"srfsvpinkzpatqt\",\"displayName\":\"swxspvckojaz\",\"documentationUrl\":\"gspftesu\",\"dataSchemaUrl\":\"pvpvd\"},\"kjmdihdcyy\":{\"description\":\"vqseus\",\"displayName\":\"j\",\"documentationUrl\":\"xzfxn\",\"dataSchemaUrl\":\"lbmuos\"},\"wobtdphti\":{\"description\":\"lwhbwzjnu\",\"displayName\":\"rfgmdqgnnbzrtfte\",\"documentationUrl\":\"uubjtvgjsxmty\",\"dataSchemaUrl\":\"vavdp\"}}},\"inputSchemaMapping\":{\"inputSchemaMappingType\":\"InputSchemaMapping\"},\"metricResourceId\":\"fofwan\",\"publicNetworkAccess\":\"Enabled\",\"inboundIpRules\":[{\"ipMask\":\"uwazcgwdfriwg\",\"action\":\"Allow\"},{\"ipMask\":\"ozokscvglli\",\"action\":\"Allow\"},{\"ipMask\":\"yfgwewqkj\",\"action\":\"Allow\"},{\"ipMask\":\"wpxsoo\",\"action\":\"Allow\"}],\"disableLocalAuth\":false,\"autoCreateTopicWithFirstSubscription\":false,\"autoDeleteTopicWithLastSubscription\":false,\"dataResidencyBoundary\":\"WithinGeopair\"},\"sku\":{\"name\":\"Premium\"},\"identity\":{\"type\":\"None\",\"principalId\":\"lfb\",\"tenantId\":\"dc\",\"userAssignedIdentities\":{\"fcm\":{\"principalId\":\"rtmdylperpil\",\"clientId\":\"jzgc\"}}},\"location\":\"fbodetresrgvts\",\"tags\":{\"ai\":\"ft\",\"pdxxzetwwz\":\"muqkevzgjypanhx\"},\"id\":\"wot\",\"name\":\"xl\",\"type\":\"fhglhrfo\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EventGridManager manager = EventGridManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Domain response = manager.domains()
            .getByResourceGroupWithResponse("clrvtzqnrbctbh", "jhxpcvrd", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("fbodetresrgvts", response.location());
        Assertions.assertEquals("ft", response.tags().get("ai"));
        Assertions.assertEquals(Sku.PREMIUM, response.sku().name());
        Assertions.assertEquals(IdentityType.NONE, response.identity().type());
        Assertions.assertEquals("lfb", response.identity().principalId());
        Assertions.assertEquals("dc", response.identity().tenantId());
        Assertions.assertEquals("rtmdylperpil", response.identity().userAssignedIdentities().get("fcm").principalId());
        Assertions.assertEquals("jzgc", response.identity().userAssignedIdentities().get("fcm").clientId());
        Assertions.assertEquals(TlsVersion.ONE_ONE, response.minimumTlsVersionAllowed());
        Assertions.assertEquals(InputSchema.CLOUD_EVENT_SCHEMA_V1_0, response.inputSchema());
        Assertions.assertEquals(EventDefinitionKind.INLINE, response.eventTypeInfo().kind());
        Assertions.assertEquals("srfsvpinkzpatqt",
            response.eventTypeInfo().inlineEventTypes().get("lyt").description());
        Assertions.assertEquals("swxspvckojaz", response.eventTypeInfo().inlineEventTypes().get("lyt").displayName());
        Assertions.assertEquals("gspftesu", response.eventTypeInfo().inlineEventTypes().get("lyt").documentationUrl());
        Assertions.assertEquals("pvpvd", response.eventTypeInfo().inlineEventTypes().get("lyt").dataSchemaUrl());
        Assertions.assertEquals(PublicNetworkAccess.ENABLED, response.publicNetworkAccess());
        Assertions.assertEquals("uwazcgwdfriwg", response.inboundIpRules().get(0).ipMask());
        Assertions.assertEquals(IpActionType.ALLOW, response.inboundIpRules().get(0).action());
        Assertions.assertFalse(response.disableLocalAuth());
        Assertions.assertFalse(response.autoCreateTopicWithFirstSubscription());
        Assertions.assertFalse(response.autoDeleteTopicWithLastSubscription());
        Assertions.assertEquals(DataResidencyBoundary.WITHIN_GEOPAIR, response.dataResidencyBoundary());
    }
}
