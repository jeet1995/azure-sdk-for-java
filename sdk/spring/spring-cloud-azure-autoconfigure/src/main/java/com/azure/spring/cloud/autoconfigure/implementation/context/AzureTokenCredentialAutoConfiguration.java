// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.implementation.context;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientCertificateCredentialBuilder;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.azure.spring.cloud.autoconfigure.implementation.AzureServiceConfigurationBase;
import com.azure.spring.cloud.autoconfigure.implementation.context.properties.AzureGlobalProperties;
import com.azure.spring.cloud.autoconfigure.implementation.properties.core.AbstractAzureHttpConfigurationProperties;
import com.azure.spring.cloud.core.customizer.AzureServiceClientBuilderCustomizer;
import com.azure.spring.cloud.core.implementation.credential.resolver.AzureTokenCredentialResolver;
import com.azure.spring.cloud.core.implementation.factory.credential.ClientCertificateCredentialBuilderFactory;
import com.azure.spring.cloud.core.implementation.factory.credential.ClientSecretCredentialBuilderFactory;
import com.azure.spring.cloud.core.implementation.factory.credential.DefaultAzureCredentialBuilderFactory;
import com.azure.spring.cloud.core.implementation.factory.credential.ManagedIdentityCredentialBuilderFactory;
import com.azure.spring.cloud.core.implementation.factory.credential.UsernamePasswordCredentialBuilderFactory;
import com.azure.spring.cloud.core.provider.authentication.TokenCredentialOptionsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;

import static com.azure.spring.cloud.autoconfigure.implementation.context.AzureContextUtils.DEFAULT_CREDENTIAL_TASK_EXECUTOR_BEAN_NAME;
import static com.azure.spring.cloud.autoconfigure.implementation.context.AzureContextUtils.DEFAULT_CREDENTIAL_THREAD_NAME_PREFIX;
import static com.azure.spring.cloud.autoconfigure.implementation.context.AzureContextUtils.DEFAULT_TOKEN_CREDENTIAL_BEAN_NAME;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for Spring Cloud Azure default {@link TokenCredential}.
 *
 * @since 4.0.0
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(TaskExecutionAutoConfiguration.class)
@Import(AzureServiceClientBuilderFactoryConfiguration.class)
@SuppressWarnings("deprecation")
public class AzureTokenCredentialAutoConfiguration extends AzureServiceConfigurationBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AzureTokenCredentialAutoConfiguration.class);

    private final GenericApplicationContext applicationContext;
    private final IdentityClientProperties identityClientProperties;

    AzureTokenCredentialAutoConfiguration(GenericApplicationContext applicationContext, AzureGlobalProperties azureGlobalProperties) {
        super(azureGlobalProperties);
        this.applicationContext = applicationContext;
        this.identityClientProperties = loadProperties(azureGlobalProperties, new IdentityClientProperties());
    }

    @ConditionalOnMissingBean(name = DEFAULT_TOKEN_CREDENTIAL_BEAN_NAME)
    @Bean(name = DEFAULT_TOKEN_CREDENTIAL_BEAN_NAME)
    @Order
    TokenCredential tokenCredential(DefaultAzureCredentialBuilderFactory factory,
                                    AzureTokenCredentialResolver resolver) {
        TokenCredential globalTokenCredential = resolver.resolve(this.identityClientProperties);
        if (globalTokenCredential != null) {
            return globalTokenCredential;
        } else {
            LOGGER.debug("No global token credential found, constructing default credential.");
            return factory.build().build();
        }
    }

    @Bean
    @ConditionalOnMissingBean
    DefaultAzureCredentialBuilderFactory azureCredentialBuilderFactory(
        ObjectProvider<AzureServiceClientBuilderCustomizer<DefaultAzureCredentialBuilder>> customizers,
        @Qualifier(DEFAULT_CREDENTIAL_TASK_EXECUTOR_BEAN_NAME) ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        DefaultAzureCredentialBuilderFactory factory = new DefaultAzureCredentialBuilderFactory(identityClientProperties);
        factory.setExecutorService(threadPoolTaskExecutor.getThreadPoolExecutor());
        customizers.orderedStream().forEach(factory::addBuilderCustomizer);
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean
    AzureTokenCredentialResolver azureTokenCredentialResolver(
        ClientSecretCredentialBuilderFactory clientSecretCredentialBuilderFactory,
        ClientCertificateCredentialBuilderFactory clientCertificateCredentialBuilderFactory,
        UsernamePasswordCredentialBuilderFactory usernamePasswordCredentialBuilderFactory,
        ManagedIdentityCredentialBuilderFactory managedIdentityCredentialBuilderFactory) {

        return new AzureTokenCredentialResolver(azureProperties -> {

            if (azureProperties.getCredential() == null) {
                return null;
            }

            String tokenCredentialBeanName = azureProperties.getCredential().getTokenCredentialBeanName();
            if (StringUtils.hasText(tokenCredentialBeanName)) {
                return this.applicationContext.getBean(tokenCredentialBeanName, TokenCredential.class);
            }

            final TokenCredentialOptionsProvider.TokenCredentialOptions properties = azureProperties.getCredential();
            final String tenantId = azureProperties.getProfile().getTenantId();
            final String clientId = properties.getClientId();
            final boolean isClientIdSet = StringUtils.hasText(clientId);
            final String authorityHost = azureProperties.getProfile().getEnvironment().getActiveDirectoryEndpoint();

            if (StringUtils.hasText(tenantId)) {

                if (isClientIdSet && StringUtils.hasText(properties.getClientSecret())) {
                    return clientSecretCredentialBuilderFactory.build()
                                                               .authorityHost(authorityHost)
                                                               .clientId(clientId)
                                                               .clientSecret(properties.getClientSecret())
                                                               .tenantId(tenantId)
                                                               .build();
                }

                String clientCertificatePath = properties.getClientCertificatePath();
                if (StringUtils.hasText(clientCertificatePath)) {
                    ClientCertificateCredentialBuilder builder = clientCertificateCredentialBuilderFactory
                        .build()
                        .authorityHost(authorityHost)
                        .tenantId(tenantId)
                        .clientId(clientId);

                    if (StringUtils.hasText(properties.getClientCertificatePassword())) {
                        builder.pfxCertificate(clientCertificatePath)
                               .clientCertificatePassword(properties.getClientCertificatePassword());
                    } else {
                        builder.pemCertificate(clientCertificatePath);
                    }

                    return builder.build();
                }
            }

            if (isClientIdSet && StringUtils.hasText(properties.getUsername())
                && StringUtils.hasText(properties.getPassword())) {
                return usernamePasswordCredentialBuilderFactory.build()
                                                               .authorityHost(authorityHost)
                                                               .username(properties.getUsername())
                                                               .password(properties.getPassword())
                                                               .clientId(clientId)
                                                               .tenantId(tenantId)
                                                               .build();
            }

            if (properties.isManagedIdentityEnabled()) {
                ManagedIdentityCredentialBuilder builder = managedIdentityCredentialBuilderFactory.build();
                if (isClientIdSet) {
                    builder.clientId(clientId);
                }
                return builder.build();
            }
            return null;
        });
    }

    @Bean
    @ConditionalOnMissingBean
    ClientSecretCredentialBuilderFactory clientSecretCredentialBuilderFactory(
        @Qualifier(DEFAULT_CREDENTIAL_TASK_EXECUTOR_BEAN_NAME) ThreadPoolTaskExecutor threadPoolTaskExecutor,
        ObjectProvider<AzureServiceClientBuilderCustomizer<ClientSecretCredentialBuilder>> customizers) {
        ClientSecretCredentialBuilderFactory factory = new ClientSecretCredentialBuilderFactory(identityClientProperties);
        factory.setExecutorService(threadPoolTaskExecutor.getThreadPoolExecutor());
        customizers.orderedStream().forEach(factory::addBuilderCustomizer);
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean
    ClientCertificateCredentialBuilderFactory clientCertificateCredentialBuilderFactory(
        @Qualifier(DEFAULT_CREDENTIAL_TASK_EXECUTOR_BEAN_NAME) ThreadPoolTaskExecutor threadPoolTaskExecutor,
        ObjectProvider<AzureServiceClientBuilderCustomizer<ClientCertificateCredentialBuilder>> customizers) {
        ClientCertificateCredentialBuilderFactory factory = new ClientCertificateCredentialBuilderFactory(identityClientProperties);
        factory.setExecutorService(threadPoolTaskExecutor.getThreadPoolExecutor());
        customizers.orderedStream().forEach(factory::addBuilderCustomizer);
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean
    ManagedIdentityCredentialBuilderFactory managedIdentityCredentialBuilderFactory(
        ObjectProvider<AzureServiceClientBuilderCustomizer<ManagedIdentityCredentialBuilder>> customizers) {

        ManagedIdentityCredentialBuilderFactory factory = new ManagedIdentityCredentialBuilderFactory(identityClientProperties);

        customizers.orderedStream().forEach(factory::addBuilderCustomizer);

        return factory;
    }

    @Bean
    @ConditionalOnMissingBean
    UsernamePasswordCredentialBuilderFactory usernamePasswordCredentialBuilderFactory(
        ObjectProvider<AzureServiceClientBuilderCustomizer<UsernamePasswordCredentialBuilder>> customizers) {

        UsernamePasswordCredentialBuilderFactory factory = new UsernamePasswordCredentialBuilderFactory(identityClientProperties);

        customizers.orderedStream().forEach(factory::addBuilderCustomizer);

        return factory;
    }

    @Bean(name = DEFAULT_CREDENTIAL_TASK_EXECUTOR_BEAN_NAME)
    @ConditionalOnMissingBean(name = DEFAULT_CREDENTIAL_TASK_EXECUTOR_BEAN_NAME)
    ThreadPoolTaskExecutor credentialTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setThreadNamePrefix(DEFAULT_CREDENTIAL_THREAD_NAME_PREFIX);
        return executor;
    }

    static class IdentityClientProperties extends AbstractAzureHttpConfigurationProperties {

    }

    IdentityClientProperties getIdentityClientProperties() {
        return identityClientProperties;
    }
}
