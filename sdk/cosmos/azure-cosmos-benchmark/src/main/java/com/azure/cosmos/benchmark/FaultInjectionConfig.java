// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.azure.cosmos.ConnectionMode;
import com.azure.cosmos.test.faultinjection.FaultInjectionConditionBuilder;
import com.azure.cosmos.test.faultinjection.FaultInjectionConnectionType;
import com.azure.cosmos.test.faultinjection.FaultInjectionOperationType;
import com.azure.cosmos.test.faultinjection.FaultInjectionResultBuilders;
import com.azure.cosmos.test.faultinjection.FaultInjectionRule;
import com.azure.cosmos.test.faultinjection.FaultInjectionRuleBuilder;
import com.azure.cosmos.test.faultinjection.FaultInjectionServerErrorResultBuilder;
import com.azure.cosmos.test.faultinjection.FaultInjectionServerErrorType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class FaultInjectionConfig {
    @JsonProperty("rules")
    private List<Rule> rules;

    List<FaultInjectionRule> buildRules(ConnectionMode mode) {
        require(rules != null && !rules.isEmpty(), "rules must contain at least one entry");
        Set<String> ids = new HashSet<>();
        List<FaultInjectionRule> result = new ArrayList<>();
        for (Rule rule : rules) {
            require(rule != null, "rule must not be null");
            require(rule.id != null && !rule.id.trim().isEmpty(), "rule id must not be blank");
            require(ids.add(rule.id), "duplicate rule id: " + rule.id);
            try {
                result.add(rule.build(mode));
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("rule '" + rule.id + "': " + ex.getMessage(), ex);
            }
        }
        return result;
    }

    private static void require(boolean valid, String message) {
        if (!valid) {
            throw new IllegalArgumentException(message);
        }
    }

    private static final class Rule {
        @JsonProperty("id")
        private String id;
        @JsonProperty("operationType")
        private FaultInjectionOperationType operationType;
        @JsonProperty("connectionType")
        private FaultInjectionConnectionType connectionType;
        @JsonProperty("region")
        private String region;
        @JsonProperty("errorType")
        private FaultInjectionServerErrorType errorType;
        @JsonProperty("injectionRate")
        private double injectionRate = 1.0;
        @JsonProperty("delay")
        private Duration delay;
        @JsonProperty("startDelay")
        private Duration startDelay;
        @JsonProperty("duration")
        private Duration duration;
        @JsonProperty("hitLimit")
        private Integer hitLimit;

        FaultInjectionRule build(ConnectionMode mode) {
            require(operationType == FaultInjectionOperationType.READ_ITEM
                    || operationType == FaultInjectionOperationType.CREATE_ITEM
                    || operationType == FaultInjectionOperationType.QUERY_ITEM,
                "operationType must be READ_ITEM, CREATE_ITEM, or QUERY_ITEM");
            require(errorType != null, "errorType is required");
            switch (errorType) {
                case INTERNAL_SERVER_ERROR:
                case TOO_MANY_REQUEST:
                case SERVICE_UNAVAILABLE:
                case TIMEOUT:
                    require(delay == null, "delay is only valid for delay faults");
                    break;
                case RESPONSE_DELAY:
                case CONNECTION_DELAY:
                    require(delay != null && delay.compareTo(Duration.ofMillis(1)) >= 0,
                        "delay must be at least one millisecond");
                    break;
                default:
                    throw new IllegalArgumentException("unsupported errorType: " + errorType);
            }
            require(startDelay == null || !startDelay.isNegative(), "startDelay must not be negative");
            require(duration == null || duration.compareTo(Duration.ofMillis(1)) >= 0,
                "duration must be at least one millisecond");

            FaultInjectionConnectionType expected = mode == ConnectionMode.DIRECT
                ? FaultInjectionConnectionType.DIRECT : FaultInjectionConnectionType.GATEWAY;
            require(connectionType == null || connectionType == expected,
                "connectionType must match tenant connectionMode (" + expected + ")");
            FaultInjectionConditionBuilder condition = new FaultInjectionConditionBuilder()
                .operationType(operationType)
                .connectionType(expected);
            if (region != null) {
                require(!region.trim().isEmpty(), "region must not be blank");
                condition.region(region.trim());
            }

            FaultInjectionServerErrorResultBuilder result = FaultInjectionResultBuilders
                .getResultBuilder(errorType)
                .injectionRate(injectionRate);
            if (delay != null) {
                result.delay(delay);
            }
            FaultInjectionRuleBuilder rule = new FaultInjectionRuleBuilder(id)
                .condition(condition.build())
                .result(result.build());
            if (startDelay != null) {
                rule.startDelay(startDelay);
            }
            if (duration != null) {
                rule.duration(duration);
            }
            if (hitLimit != null) {
                rule.hitLimit(hitLimit);
            }
            return rule.build();
        }
    }
}
