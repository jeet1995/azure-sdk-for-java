// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.azure.cosmos.test.faultinjection.FaultInjectionConnectionType;
import com.azure.cosmos.test.faultinjection.FaultInjectionRule;
import com.azure.cosmos.test.faultinjection.FaultInjectionServerErrorResult;
import com.azure.cosmos.test.faultinjection.FaultInjectionServerErrorType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FaultInjectionConfigTest {
    private static final String READ_500 =
        "{\"id\":\"read-500\",\"operationType\":\"READ_ITEM\",\"errorType\":\"INTERNAL_SERVER_ERROR\"";

    @Test(groups = "unit")
    public void buildsFresh500RulesUsingResolvedTenantMode() throws Exception {
        TenantWorkloadConfig tenant = load("", READ_500
            + ",\"injectionRate\":0.05,\"startDelay\":\"PT10S\",\"duration\":\"PT30S\",\"hitLimit\":100} ");
        FaultInjectionRule first = tenant.getFaultInjection().buildRules(tenant.getConnectionMode()).get(0);
        assertThat(first.getCondition().getConnectionType()).isEqualTo(FaultInjectionConnectionType.GATEWAY);
        assertThat(((FaultInjectionServerErrorResult) first.getResult()).getServerErrorType())
            .isEqualTo(FaultInjectionServerErrorType.INTERNAL_SERVER_ERROR);
        assertThat(first.getStartDelay()).isEqualTo(Duration.ofSeconds(10));
        assertThat(first.getDuration()).isEqualTo(Duration.ofSeconds(30));
        assertThat(first.getHitLimit()).isEqualTo(100);
        first.disable();
        assertThat(tenant.getFaultInjection().buildRules(tenant.getConnectionMode()).get(0).isEnabled()).isTrue();
    }

    @DataProvider
    public Object[][] invalidRules() {
        return new Object[][] {
            {"", READ_500 + "}," + READ_500 + "}", "duplicate rule id"},
            {"", READ_500 + ",\"connectionType\":\"DIRECT\"}", "must match tenant connectionMode"},
            {"", READ_500 + ",\"injectionRate\":0}", "injectionRate"},
            {"", "{\"id\":\"delay\",\"operationType\":\"READ_ITEM\",\"errorType\":\"RESPONSE_DELAY\"}", "delay must"},
            {",\"operation\":\"CtlWorkload\"", READ_500 + "}", "not supported for CTL or encryption"}
        };
    }

    @Test(groups = "unit", dataProvider = "invalidRules")
    public void rejectsInvalidRulesBeforeWorkloadSetup(String tenantOptions, String rules, String message) {
        assertThatThrownBy(() -> load(tenantOptions, rules))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Tenant 'test-tenant' faultInjection")
            .hasMessageContaining(message);
    }

    @Test(groups = "unit")
    public void faultInjectionIsOptIn() throws Exception {
        assertThat(load("", null).getFaultInjection()).isNull();
    }

    private static TenantWorkloadConfig load(String tenantOptions, String rules) throws Exception {
        String json = "{\"orchestrator\":{\"tenantDefaults\":{\"connectionMode\":\"Gateway\"},\"tenants\":[{"
            + "\"id\":\"test-tenant\",\"serviceEndpoint\":\"https://example.com\","
            + "\"databaseId\":\"test-db\",\"containerId\":\"test-container\",\"isManagedIdentityRequired\":true"
            + tenantOptions + (rules == null ? "" : ",\"faultInjection\":{\"rules\":[" + rules + "]}")
            + "}]}}";
        Path config = Files.createTempFile("benchmark-fault-injection", ".json");
        try {
            Files.write(config, json.getBytes(StandardCharsets.UTF_8));
            return BenchmarkConfig.fromFile(config.toFile()).getTenantWorkloads().get(0);
        } finally {
            Files.deleteIfExists(config);
        }
    }
}
