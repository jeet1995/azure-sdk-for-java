// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Configuration for Application Insights metrics reporting destination.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInsightsReporterConfig {

    @JsonProperty("connectionString")
    private String connectionString;

    @JsonProperty("stepSeconds")
    private int stepSeconds = 10;

    @JsonProperty("testCategory")
    private String testCategory;

    /**
     * Optional run identifier. Emitted as the {@code RunId} common tag on every metric so that
     * runs across different SDK versions / endpoint flavors can be distinguished in Grafana.
     * When null/empty, the orchestrator falls back to a generated {@code bench-<Instant>} id.
     */
    @JsonProperty("runId")
    private String runId;

    /**
     * Optional free-form benchmark phase label (e.g. {@code coldstart}). Emitted as the
     * {@code Phase} common tag when present.
     */
    @JsonProperty("phase")
    private String phase;

    /** Jackson deserialization constructor. */
    public AppInsightsReporterConfig() {}

    public AppInsightsReporterConfig(String connectionString, int stepSeconds, String testCategory) {
        this.connectionString = connectionString;
        this.stepSeconds = stepSeconds > 0 ? stepSeconds : 10;
        this.testCategory = testCategory;
    }

    public String getConnectionString() { return connectionString; }
    public int getStepSeconds() { return stepSeconds; }
    public String getTestCategory() { return testCategory; }
    public String getRunId() { return runId; }
    public String getPhase() { return phase; }
}
