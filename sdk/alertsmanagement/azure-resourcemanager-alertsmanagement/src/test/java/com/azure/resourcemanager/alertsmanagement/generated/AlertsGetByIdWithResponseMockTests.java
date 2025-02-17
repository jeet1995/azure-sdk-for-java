// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.alertsmanagement.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.alertsmanagement.AlertsManagementManager;
import com.azure.resourcemanager.alertsmanagement.models.Alert;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class AlertsGetByIdWithResponseMockTests {
    @Test
    public void testGetByIdWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"essentials\":{\"severity\":\"Sev3\",\"signalType\":\"Unknown\",\"alertState\":\"New\",\"monitorCondition\":\"Fired\",\"targetResource\":\"eofvfkakpoldt\",\"targetResourceName\":\"vboclzhzjk\",\"targetResourceGroup\":\"uxgvttxpnr\",\"targetResourceType\":\"zaamrdixtrekid\",\"monitorService\":\"ActivityLog Security\",\"alertRule\":\"kbr\",\"sourceCreatedId\":\"fgllukkutvlx\",\"smartGroupId\":\"pqhvmblcouqehbhb\",\"smartGroupingReason\":\"sziryrandoyp\",\"startDateTime\":\"2021-11-06T16:20:01Z\",\"lastModifiedDateTime\":\"2021-02-08T17:37:53Z\",\"monitorConditionResolvedDateTime\":\"2021-03-07T20:41:50Z\",\"lastModifiedUserName\":\"kfqlwx\",\"actionStatus\":{\"isSuppressed\":true},\"description\":\"lsygaol\"},\"context\":\"datapnnbm\",\"egressConfig\":\"datasibjgs\"},\"id\":\"jxxahmrnad\",\"name\":\"yqegx\",\"type\":\"iv\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AlertsManagementManager manager = AlertsManagementManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        Alert response = manager.alerts().getByIdWithResponse("jogjonmc", com.azure.core.util.Context.NONE).getValue();

        Assertions.assertEquals("eofvfkakpoldt", response.properties().essentials().targetResource());
        Assertions.assertEquals("vboclzhzjk", response.properties().essentials().targetResourceName());
        Assertions.assertEquals("uxgvttxpnr", response.properties().essentials().targetResourceGroup());
        Assertions.assertEquals("zaamrdixtrekid", response.properties().essentials().targetResourceType());
        Assertions.assertEquals(true, response.properties().essentials().actionStatus().isSuppressed());
        Assertions.assertEquals("lsygaol", response.properties().essentials().description());
    }
}
