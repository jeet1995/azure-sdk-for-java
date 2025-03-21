// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.recoveryservicessiterecovery.SiteRecoveryManager;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.PossibleOperationsDirections;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlan;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanGroupType;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanProviderSpecificFailoverInput;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanTestFailoverInput;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.RecoveryPlanTestFailoverInputProperties;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ReplicationRecoveryPlansTestFailoverMockTests {
    @Test
    public void testTestFailover() throws Exception {
        String responseStr
            = "{\"properties\":{\"friendlyName\":\"pmdmwiwevves\",\"primaryFabricId\":\"hh\",\"primaryFabricFriendlyName\":\"qhdldargkwimtcce\",\"recoveryFabricId\":\"uqu\",\"recoveryFabricFriendlyName\":\"czzc\",\"failoverDeploymentModel\":\"wxvbkirgknhfw\",\"replicationProviders\":[\"wdajyd\",\"bjgipvspe\"],\"allowedOperations\":[\"hydtkbmt\",\"sd\"],\"lastPlannedFailoverTime\":\"2021-02-01T04:36:15Z\",\"lastUnplannedFailoverTime\":\"2021-10-07T22:01:48Z\",\"lastTestFailoverTime\":\"2021-11-11T09:35:50Z\",\"currentScenario\":{\"scenarioName\":\"mawo\",\"jobId\":\"cnev\",\"startTime\":\"2021-09-22T15:27:40Z\"},\"currentScenarioStatus\":\"b\",\"currentScenarioStatusDescription\":\"sclwbjgi\",\"groups\":[{\"groupType\":\"Boot\",\"replicationProtectedItems\":[{}],\"startGroupActions\":[{\"actionName\":\"weofvsxauphzefi\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"eyydx\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"gtiivzkd\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"exccwldgfq\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"mwtacrscfcn\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]},{\"groupType\":\"Failover\",\"replicationProtectedItems\":[{},{}],\"startGroupActions\":[{\"actionName\":\"llmfwfpo\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"oszzw\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]},{\"groupType\":\"Boot\",\"replicationProtectedItems\":[{}],\"startGroupActions\":[{\"actionName\":\"xvchmubyguqh\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"nmsvj\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"grpry\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"ircbajxjrbvyr\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"atxkznlwlmbx\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"gkev\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"ay\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"x\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]},{\"groupType\":\"Failover\",\"replicationProtectedItems\":[{}],\"startGroupActions\":[{\"actionName\":\"zgrgkja\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}],\"endGroupActions\":[{\"actionName\":\"waezplybspsbomt\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"epzimfc\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"suiwexpasckpg\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}},{\"actionName\":\"mlyxbwslx\",\"failoverTypes\":[],\"failoverDirections\":[],\"customDetails\":{\"instanceType\":\"RecoveryPlanActionDetails\"}}]}],\"providerSpecificDetails\":[{\"instanceType\":\"RecoveryPlanProviderSpecificDetails\"},{\"instanceType\":\"RecoveryPlanProviderSpecificDetails\"},{\"instanceType\":\"RecoveryPlanProviderSpecificDetails\"}]},\"location\":\"toejtqv\",\"id\":\"ctm\",\"name\":\"idkxz\",\"type\":\"oluznt\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SiteRecoveryManager manager = SiteRecoveryManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        RecoveryPlan response = manager.replicationRecoveryPlans()
            .testFailover("vxerowuzvrnnbeg", "af", "onmtoj",
                new RecoveryPlanTestFailoverInput().withProperties(new RecoveryPlanTestFailoverInputProperties()
                    .withFailoverDirection(PossibleOperationsDirections.PRIMARY_TO_RECOVERY)
                    .withNetworkType("dofmazhk")
                    .withNetworkId("sjknaq")
                    .withProviderSpecificDetails(Arrays.asList(new RecoveryPlanProviderSpecificFailoverInput(),
                        new RecoveryPlanProviderSpecificFailoverInput()))),
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("pmdmwiwevves", response.properties().friendlyName());
        Assertions.assertEquals("hh", response.properties().primaryFabricId());
        Assertions.assertEquals("qhdldargkwimtcce", response.properties().primaryFabricFriendlyName());
        Assertions.assertEquals("uqu", response.properties().recoveryFabricId());
        Assertions.assertEquals("czzc", response.properties().recoveryFabricFriendlyName());
        Assertions.assertEquals("wxvbkirgknhfw", response.properties().failoverDeploymentModel());
        Assertions.assertEquals("wdajyd", response.properties().replicationProviders().get(0));
        Assertions.assertEquals("hydtkbmt", response.properties().allowedOperations().get(0));
        Assertions.assertEquals(OffsetDateTime.parse("2021-02-01T04:36:15Z"),
            response.properties().lastPlannedFailoverTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-07T22:01:48Z"),
            response.properties().lastUnplannedFailoverTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-11T09:35:50Z"),
            response.properties().lastTestFailoverTime());
        Assertions.assertEquals("mawo", response.properties().currentScenario().scenarioName());
        Assertions.assertEquals("cnev", response.properties().currentScenario().jobId());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-22T15:27:40Z"),
            response.properties().currentScenario().startTime());
        Assertions.assertEquals("b", response.properties().currentScenarioStatus());
        Assertions.assertEquals("sclwbjgi", response.properties().currentScenarioStatusDescription());
        Assertions.assertEquals(RecoveryPlanGroupType.BOOT, response.properties().groups().get(0).groupType());
        Assertions.assertEquals("weofvsxauphzefi",
            response.properties().groups().get(0).startGroupActions().get(0).actionName());
        Assertions.assertEquals("mwtacrscfcn",
            response.properties().groups().get(0).endGroupActions().get(0).actionName());
        Assertions.assertEquals("toejtqv", response.location());
    }
}
