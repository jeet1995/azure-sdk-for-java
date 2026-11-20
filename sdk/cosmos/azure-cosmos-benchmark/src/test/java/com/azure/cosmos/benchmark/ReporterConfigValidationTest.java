// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.benchmark;

import com.azure.cosmos.implementation.ImplementationBridgeHelpers;
import com.azure.cosmos.models.CosmosClientTelemetryConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReporterConfigValidationTest {

    @DataProvider
    public Object[][] sampleRates() {
        return new Object[][] {{0.0}, {0.1}, {1.0}};
    }

    @Test(groups = "unit", dataProvider = "sampleRates")
    public void samplingIsAppliedToEveryTenant(double rate) throws IOException {
        BenchmarkConfig config = loadSamplingConfig("\"sampleRate\":" + rate);
        for (TenantWorkloadConfig tenant : config.getTenantWorkloads()) {
            CosmosClientTelemetryConfig telemetry = new CosmosClientTelemetryConfig().sampleDiagnostics(0.7);
            tenant.configureDiagnosticsSampling(telemetry);
            assertThat(ImplementationBridgeHelpers.CosmosClientTelemetryConfigHelper
                .getCosmosClientTelemetryConfigAccessor().getSamplingRate(telemetry)).isEqualTo(rate);
        }
    }

    @Test(groups = "unit")
    public void omittedSamplingPreservesExistingTelemetryRate() throws IOException {
        for (TenantWorkloadConfig tenant : loadSamplingConfig("").getTenantWorkloads()) {
            CosmosClientTelemetryConfig telemetry = new CosmosClientTelemetryConfig().sampleDiagnostics(0.7);
            tenant.configureDiagnosticsSampling(telemetry);
            assertThat(tenant.getMetricsSampleRate()).isNull();
            assertThat(ImplementationBridgeHelpers.CosmosClientTelemetryConfigHelper
                .getCosmosClientTelemetryConfigAccessor().getSamplingRate(telemetry)).isEqualTo(0.7);
        }
    }

    @DataProvider
    public Object[][] invalidSampleRates() {
        return new Object[][] {{"-0.1"}, {"1.1"}, {"\"NaN\""}, {"\"Infinity\""}};
    }

    @Test(groups = "unit", dataProvider = "invalidSampleRates")
    public void invalidSamplingFailsBeforeClientSetup(String rate) {
        assertThatThrownBy(() -> loadSamplingConfig("\"sampleRate\":" + rate))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("orchestrator.metrics.sampleRate");
    }

    private static BenchmarkConfig loadSamplingConfig(String metrics) throws IOException {
        String tenant = "{\"serviceEndpoint\":\"https://example.com\",\"masterKey\":\"test-key\","
            + "\"databaseId\":\"db\",\"containerId\":\"container\"}";
        Path path = Files.createTempFile("benchmark-metrics-sampling", ".json");
        try {
            Files.write(path, ("{\"orchestrator\":{\"metrics\":{" + metrics + "},\"tenants\":["
                + tenant + "," + tenant + "]}}").getBytes(StandardCharsets.UTF_8));
            return BenchmarkConfig.fromFile(path.toFile());
        } finally {
            Files.deleteIfExists(path);
        }
    }

    // ---- CsvReporterConfig ----

    @Test(groups = {"unit"})
    public void csvReporterConfig_validDirectory() {
        CsvReporterConfig config = new CsvReporterConfig("/tmp/output");
        assertThat(config.getReportingDirectory()).isEqualTo("/tmp/output");
    }

    @Test(groups = {"unit"})
    public void csvReporterConfig_nullDirectory_throws() {
        assertThatThrownBy(() -> new CsvReporterConfig(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("reportingDirectory");
    }

    @Test(groups = {"unit"})
    public void csvReporterConfig_emptyDirectory_throws() {
        assertThatThrownBy(() -> new CsvReporterConfig(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("reportingDirectory");
    }

    // ---- CosmosReporterConfig ----

    @Test(groups = {"unit"})
    public void cosmosReporterConfig_validFields() {
        CosmosReporterConfig config = new CosmosReporterConfig(
            "https://acct.documents.azure.com:443/", "key",
            "db", "container", "variation", "main", "abc123");
        assertThat(config.getServiceEndpoint()).isEqualTo("https://acct.documents.azure.com:443/");
        assertThat(config.getDatabase()).isEqualTo("db");
        assertThat(config.getContainer()).isEqualTo("container");
    }

    @Test(groups = {"unit"})
    public void cosmosReporterConfig_optionalFieldsCanBeNull() {
        CosmosReporterConfig config = new CosmosReporterConfig(
            "https://acct.documents.azure.com:443/", "key",
            "db", "container", null, null, null);
        assertThat(config.getTestVariationName()).isEmpty();
        assertThat(config.getBranchName()).isEmpty();
        assertThat(config.getCommitId()).isEmpty();
    }

    @Test(groups = {"unit"})
    public void cosmosReporterConfig_nullEndpoint_throws() {
        assertThatThrownBy(() -> new CosmosReporterConfig(
            null, "key", "db", "container", null, null, null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("serviceEndpoint");
    }

    @Test(groups = {"unit"})
    public void cosmosReporterConfig_nullMasterKey_throws() {
        assertThatThrownBy(() -> new CosmosReporterConfig(
            "https://acct.documents.azure.com:443/", null, "db", "container", null, null, null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("masterKey");
    }

    @Test(groups = {"unit"})
    public void cosmosReporterConfig_nullDatabase_throws() {
        assertThatThrownBy(() -> new CosmosReporterConfig(
            "https://acct.documents.azure.com:443/", "key", null, "container", null, null, null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("database");
    }

    @Test(groups = {"unit"})
    public void cosmosReporterConfig_nullContainer_throws() {
        assertThatThrownBy(() -> new CosmosReporterConfig(
            "https://acct.documents.azure.com:443/", "key", "db", null, null, null, null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("container");
    }
}
