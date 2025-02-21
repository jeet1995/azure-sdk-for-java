// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.core.implementation.utils;

import io.clientcore.core.utils.configuration.Configuration;
import io.clientcore.core.utils.configuration.ConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Contains environment (system properties and environment variables) configuration information that is
 * used during construction of client libraries.
 */
public class EnvironmentConfiguration {
    /*
     * Configurations that are loaded into the global configuration store when the application starts.
     */
    private static final Set<String> DEFAULT_CONFIGURATIONS
        = new HashSet<>(Arrays.asList(Configuration.HTTP_PROXY, Configuration.HTTPS_PROXY, Configuration.LOG_LEVEL,
            Configuration.HTTP_LOG_LEVEL, Configuration.MAX_RETRY_ATTEMPTS, Configuration.REQUEST_CONNECT_TIMEOUT_IN_MS,
            Configuration.REQUEST_WRITE_TIMEOUT_IN_MS, Configuration.REQUEST_RESPONSE_TIMEOUT_IN_MS,
            Configuration.REQUEST_READ_TIMEOUT_IN_MS));

    private static final EnvironmentConfiguration GLOBAL_CONFIGURATION = new EnvironmentConfiguration();

    private final ConcurrentMap<String, String> explicitConfigurations;
    private final ConcurrentMap<String, Optional<String>> envConfigurations;
    private final ConcurrentMap<String, Optional<String>> sysPropertiesConfigurations;

    /**
     * Constructs a configuration containing the known SDK properties constants.
     */
    private EnvironmentConfiguration() {
        this(EnvironmentVariablesConfigurationSource.GLOBAL_SOURCE, path -> Collections.emptyMap());
    }

    /**
     * Clones original configuration.
     *
     * @param original The original configuration to clone.
     */
    public EnvironmentConfiguration(EnvironmentConfiguration original) {
        this.explicitConfigurations = new ConcurrentHashMap<>(original.explicitConfigurations);
        this.envConfigurations = new ConcurrentHashMap<>(original.envConfigurations);
        this.sysPropertiesConfigurations = new ConcurrentHashMap<>(original.sysPropertiesConfigurations);
    }

    /**
     * Constructs a configuration containing mocked environment. Use this constructor for testing.
     *
     * @param environmentConfigurationSource The mocked environment configuration source.
     * @param systemPropertiesConfigurationSource The mocked system properties configuration source.
     */
    public EnvironmentConfiguration(ConfigurationSource systemPropertiesConfigurationSource,
        ConfigurationSource environmentConfigurationSource) {
        this.explicitConfigurations = new ConcurrentHashMap<>();

        if (environmentConfigurationSource == null) {
            environmentConfigurationSource = EnvironmentVariablesConfigurationSource.GLOBAL_SOURCE;
        }

        Map<String, String> fromEnvironment = environmentConfigurationSource.getProperties(null);
        Objects.requireNonNull(fromEnvironment, "'environmentConfigurationSource.getProperties(null)' can't be null");

        this.envConfigurations = new ConcurrentHashMap<>(fromEnvironment.size());
        for (Map.Entry<String, String> config : fromEnvironment.entrySet()) {
            this.envConfigurations.put(config.getKey(), Optional.ofNullable(config.getValue()));
        }

        if (systemPropertiesConfigurationSource == null) {
            this.sysPropertiesConfigurations = new ConcurrentHashMap<>();
        } else {
            Map<String, String> fromSystemProperties = systemPropertiesConfigurationSource.getProperties(null);
            Objects.requireNonNull(fromSystemProperties,
                "'systemPropertiesConfigurationSource.getProperties(null)' can't be null");
            this.sysPropertiesConfigurations = new ConcurrentHashMap<>(fromSystemProperties.size());
            for (Map.Entry<String, String> config : fromSystemProperties.entrySet()) {
                this.sysPropertiesConfigurations.put(config.getKey(), Optional.ofNullable(config.getValue()));
            }
        }
    }

    /**
     * Gets the global environment configuration.
     *
     * @return The global environment configuration.
     */
    public static EnvironmentConfiguration getGlobalConfiguration() {
        return GLOBAL_CONFIGURATION;
    }

    /**
     * Gets the value of the environment variable.
     * <p>
     * This method first checks the values previously loaded from the environment, if the configuration is found there
     * it will be returned. Otherwise, this will attempt to load the value from the environment.
     *
     * @param name Name of the configuration.
     * @return Value of the configuration if found, otherwise null.
     */
    public String getEnvironmentVariable(String name) {
        return getOrLoad(name, envConfigurations, false);
    }

    /**
     * Gets the value of the system property.
     * <p>
     * This method first checks the values previously loaded from the environment, if the configuration is found there
     * it will be returned. Otherwise, this will attempt to load the value from the environment.
     *
     * @param name Name of the configuration.
     * @return Value of the configuration if found, otherwise null.
     */
    public String getSystemProperty(String name) {
        return getOrLoad(name, sysPropertiesConfigurations, true);
    }

    /**
     * Gets the value of the configuration.
     * <p>
     * This method first checks the values previously loaded from the environment, if the configuration is found there
     * it will be returned. Otherwise, this will attempt to load the value from the environment.
     *
     * @param name Name of the configuration.
     * @return Value of the configuration if found, otherwise null.
     */
    public String get(String name) {
        String value = explicitConfigurations.get(name);
        if (value != null) {
            return value;
        }

        value = getSystemProperty(name);
        if (value != null) {
            return value;
        }

        return getEnvironmentVariable(name);
    }

    /*
     * Attempts to get the value of the configuration from the configuration store, if the value isn't found then it
     * attempts to load it from the runtime parameters then the environment variables.
     *
     * If no configuration is found null is returned.
     *
     * @param name Configuration property name.
     * @return The configuration value from either the configuration store, runtime parameters, or environment
     * variable, in that order, if found, otherwise null.
     */
    private String getOrLoad(String name, ConcurrentMap<String, Optional<String>> configurations,
        boolean loadFromSystemProperties) {
        Optional<String> value = configurations.get(name);
        if (value != null) {
            return value.orElse(null);
        }

        String envValue = loadFromSystemProperties ? loadFromProperties(name) : loadFromEnvironment(name);
        configurations.put(name, Optional.ofNullable(envValue));
        return envValue;
    }

    /**
     * Adds a configuration with the given value.
     * <p>
     * This will overwrite the previous configuration value if it existed.
     *
     * @param name Name of the configuration.
     * @param value Value of the configuration.
     * @return The updated Configuration object.
     */
    public EnvironmentConfiguration put(String name, String value) {
        explicitConfigurations.put(name, value);
        return this;
    }

    /**
     * Removes the configuration.
     * <p>
     * This returns the value of the configuration if it previously existed.
     *
     * @param name Name of the configuration.
     * @return The configuration if it previously existed, otherwise null.
     */
    public String remove(String name) {
        return explicitConfigurations.remove(name);
    }

    private String loadFromEnvironment(String name) {
        return System.getenv(name);
    }

    private String loadFromProperties(String name) {
        return System.getProperty(name);
    }

    public static final class EnvironmentVariablesConfigurationSource implements ConfigurationSource {
        public static final ConfigurationSource GLOBAL_SOURCE = new EnvironmentVariablesConfigurationSource();
        Map<String, String> configurations;

        private EnvironmentVariablesConfigurationSource() {
            configurations = new HashMap<>();
            for (String config : DEFAULT_CONFIGURATIONS) {
                String value = System.getenv(config);
                if (value != null) {
                    configurations.put(config, value);
                }
            }
        }

        @Override
        public Map<String, String> getProperties(String ignored) {
            return configurations;
        }
    }
}
