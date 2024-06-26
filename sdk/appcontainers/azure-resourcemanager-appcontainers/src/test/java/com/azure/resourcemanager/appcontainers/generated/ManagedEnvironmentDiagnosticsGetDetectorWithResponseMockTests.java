// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.appcontainers.ContainerAppsApiManager;
import com.azure.resourcemanager.appcontainers.models.Diagnostics;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public final class ManagedEnvironmentDiagnosticsGetDetectorWithResponseMockTests {
    @Test
    public void testGetDetectorWithResponse() throws Exception {
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        ArgumentCaptor<HttpRequest> httpRequest = ArgumentCaptor.forClass(HttpRequest.class);

        String responseStr
            = "{\"properties\":{\"metadata\":{\"id\":\"nazku\",\"name\":\"drey\",\"description\":\"whsetwwjwzzqs\",\"author\":\"zuukykcyqhyqq\",\"category\":\"dcykeyst\",\"supportTopicList\":[{\"id\":\"pazdazgbsqgp\",\"pesId\":\"q\"}],\"analysisTypes\":[\"tmdpvozglqjbknlz\",\"lctzeyowmndcovd\",\"zqauxzan\"],\"type\":\"kvfruwkudr\",\"score\":66.552605},\"dataset\":[{\"table\":{\"tableName\":\"dqyemebunaucm\",\"columns\":[{},{},{}],\"rows\":[\"dataeemmjauwcgx\"]},\"renderingProperties\":{\"type\":1976462334,\"title\":\"aitranizerw\",\"description\":\"dasmxu\",\"isVisible\":true}},{\"table\":{\"tableName\":\"gfcoc\",\"columns\":[{},{}],\"rows\":[\"dataiylfmpztrau\",\"datasvhl\",\"datadculregp\"]},\"renderingProperties\":{\"type\":1371553792,\"title\":\"hvrztnvg\",\"description\":\"hqrdgrtwmewjzlpy\",\"isVisible\":false}},{\"table\":{\"tableName\":\"zwjcaye\",\"columns\":[{},{}],\"rows\":[\"datansyby\",\"datapolwzrghsrlei\"]},\"renderingProperties\":{\"type\":1125068139,\"title\":\"jfncjwvuagfqw\",\"description\":\"tngvmreuptrklz\",\"isVisible\":true}}],\"status\":{\"message\":\"wo\",\"statusId\":1419456371},\"dataProviderMetadata\":{\"providerName\":\"aghm\",\"propertyBag\":[{\"name\":\"lslrcigtzjc\",\"value\":\"xqlaps\"},{\"name\":\"sovyxpavidnievw\",\"value\":\"cvvy\"},{\"name\":\"slpuxgcbdsva\",\"value\":\"nptw\"},{\"name\":\"kx\",\"value\":\"azwu\"}]}},\"id\":\"yqvnjobfe\",\"name\":\"hldiuhzzgqlm\",\"type\":\"aewzgiudjp\"}";

        Mockito.when(httpResponse.getStatusCode()).thenReturn(200);
        Mockito.when(httpResponse.getHeaders()).thenReturn(new HttpHeaders());
        Mockito.when(httpResponse.getBody())
            .thenReturn(Flux.just(ByteBuffer.wrap(responseStr.getBytes(StandardCharsets.UTF_8))));
        Mockito.when(httpResponse.getBodyAsByteArray())
            .thenReturn(Mono.just(responseStr.getBytes(StandardCharsets.UTF_8)));
        Mockito.when(httpClient.send(httpRequest.capture(), Mockito.any())).thenReturn(Mono.defer(() -> {
            Mockito.when(httpResponse.getRequest()).thenReturn(httpRequest.getValue());
            return Mono.just(httpResponse);
        }));

        ContainerAppsApiManager manager = ContainerAppsApiManager.configure().withHttpClient(httpClient).authenticate(
            tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
            new AzureProfile("", "", AzureEnvironment.AZURE));

        Diagnostics response = manager.managedEnvironmentDiagnostics()
            .getDetectorWithResponse("ygnxcgjtfrnqukt", "fnslnlrxsmy", "trwntfmtbgw", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("tmdpvozglqjbknlz", response.properties().metadata().analysisTypes().get(0));
        Assertions.assertEquals("dqyemebunaucm", response.properties().dataset().get(0).table().tableName());
        Assertions.assertEquals(1976462334, response.properties().dataset().get(0).renderingProperties().type());
        Assertions.assertEquals("aitranizerw", response.properties().dataset().get(0).renderingProperties().title());
        Assertions.assertEquals("dasmxu", response.properties().dataset().get(0).renderingProperties().description());
        Assertions.assertEquals(true, response.properties().dataset().get(0).renderingProperties().isVisible());
        Assertions.assertEquals("wo", response.properties().status().message());
        Assertions.assertEquals(1419456371, response.properties().status().statusId());
        Assertions.assertEquals("aghm", response.properties().dataProviderMetadata().providerName());
        Assertions.assertEquals("lslrcigtzjc",
            response.properties().dataProviderMetadata().propertyBag().get(0).name());
        Assertions.assertEquals("xqlaps", response.properties().dataProviderMetadata().propertyBag().get(0).value());
    }
}
