// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.appservice;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpPipeline;
import com.azure.resourcemanager.appservice.fluent.WebSiteManagementClient;
import com.azure.resourcemanager.appservice.implementation.WebSiteManagementClientBuilder;
import com.azure.resourcemanager.appservice.implementation.AppServiceCertificateOrdersImpl;
import com.azure.resourcemanager.appservice.implementation.AppServiceCertificatesImpl;
import com.azure.resourcemanager.appservice.implementation.AppServiceDomainsImpl;
import com.azure.resourcemanager.appservice.implementation.AppServicePlansImpl;
import com.azure.resourcemanager.appservice.implementation.FunctionAppsImpl;
import com.azure.resourcemanager.appservice.implementation.WebAppsImpl;
import com.azure.resourcemanager.appservice.models.AppServiceCertificateOrders;
import com.azure.resourcemanager.appservice.models.AppServiceCertificates;
import com.azure.resourcemanager.appservice.models.AppServiceDomains;
import com.azure.resourcemanager.appservice.models.AppServicePlans;
import com.azure.resourcemanager.appservice.models.FunctionApps;
import com.azure.resourcemanager.appservice.models.WebApps;
import com.azure.resourcemanager.authorization.AuthorizationManager;
import com.azure.resourcemanager.dns.DnsZoneManager;
import com.azure.resourcemanager.keyvault.KeyVaultManager;
import com.azure.resourcemanager.resources.fluentcore.arm.AzureConfigurable;
import com.azure.resourcemanager.resources.fluentcore.arm.Manager;
import com.azure.core.management.profile.AzureProfile;
import com.azure.resourcemanager.resources.fluentcore.arm.implementation.AzureConfigurableImpl;
import com.azure.resourcemanager.resources.fluentcore.utils.HttpPipelineProvider;
import com.azure.resourcemanager.storage.StorageManager;

import java.util.Objects;

/** Entry point to Azure storage resource management. */
public final class AppServiceManager extends Manager<WebSiteManagementClient> {
    // Managers
    private final AuthorizationManager authorizationManager;
    private final KeyVaultManager keyVaultManager;
    private final StorageManager storageManager;
    private final DnsZoneManager dnsZoneManager;
    // Collections
    private WebApps webApps;
    private AppServicePlans appServicePlans;
    private AppServiceCertificateOrders appServiceCertificateOrders;
    private AppServiceCertificates appServiceCertificates;
    private AppServiceDomains appServiceDomains;
    private FunctionApps functionApps;

    /**
     * Get a Configurable instance that can be used to create StorageManager with optional configuration.
     *
     * @return the instance allowing configurations
     */
    public static Configurable configure() {
        return new AppServiceManager.ConfigurableImpl();
    }

    /**
     * Creates an instance of StorageManager that exposes storage resource management API entry points.
     *
     * @param credential the credential to use
     * @param profile the profile to use
     * @return the StorageManager
     */
    public static AppServiceManager authenticate(TokenCredential credential, AzureProfile profile) {
        Objects.requireNonNull(credential, "'credential' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        return authenticate(HttpPipelineProvider.buildHttpPipeline(credential, profile), profile);
    }

    /**
     * Creates an instance of StorageManager that exposes storage resource management API entry points.
     *
     * @param httpPipeline the {@link HttpPipeline} configured with Azure authentication credential.
     * @param profile the profile to use
     * @return the StorageManager
     */
    public static AppServiceManager authenticate(HttpPipeline httpPipeline, AzureProfile profile) {
        Objects.requireNonNull(httpPipeline, "'httpPipeline' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        return new AppServiceManager(httpPipeline, profile);
    }

    /** The interface allowing configurations to be set. */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
         * Creates an instance of StorageManager that exposes storage management API entry points.
         *
         * @param credential the credential to use
         * @param profile the profile to use
         * @return the interface exposing AppService management API entry points that work across subscriptions
         */
        AppServiceManager authenticate(TokenCredential credential, AzureProfile profile);
    }

    /** The implementation for Configurable interface. */
    private static final class ConfigurableImpl extends AzureConfigurableImpl<Configurable> implements Configurable {
        public AppServiceManager authenticate(TokenCredential credential, AzureProfile profile) {
            return AppServiceManager.authenticate(buildHttpPipeline(credential, profile), profile);
        }
    }

    private AppServiceManager(HttpPipeline httpPipeline, AzureProfile profile) {
        super(httpPipeline, profile,
            new WebSiteManagementClientBuilder().pipeline(httpPipeline)
                .endpoint(profile.getEnvironment().getResourceManagerEndpoint())
                .subscriptionId(profile.getSubscriptionId())
                .buildClient());
        keyVaultManager = KeyVaultManager.authenticate(httpPipeline, profile);
        storageManager = StorageManager.authenticate(httpPipeline, profile);
        authorizationManager = AuthorizationManager.authenticate(httpPipeline, profile);
        dnsZoneManager = DnsZoneManager.authenticate(httpPipeline, profile);
    }

    /**
     * Gets the authorization manager instance.
     *
     * @return the authorization manager instance.
     */
    public AuthorizationManager authorizationManager() {
        return authorizationManager;
    }

    /**
     * Gets the key vault manager instance.
     *
     * @return the key vault manager instance.
     */
    public KeyVaultManager keyVaultManager() {
        return keyVaultManager;
    }

    /**
     * Gets the storage manager instance.
     *
     * @return the storage manager instance.
     */
    public StorageManager storageManager() {
        return storageManager;
    }

    /**
     * Gets the DNS zone manager instance.
     *
     * @return the DNS zone manager instance.
     */
    public DnsZoneManager dnsZoneManager() {
        return dnsZoneManager;
    }

    /**
     * Gets the web app management API entry point.
     *
     * @return the web app management API entry point
     */
    public WebApps webApps() {
        if (webApps == null) {
            webApps = new WebAppsImpl(this);
        }
        return webApps;
    }

    /**
     * Gets the app service plan management API entry point.
     *
     * @return the app service plan management API entry point
     */
    public AppServicePlans appServicePlans() {
        if (appServicePlans == null) {
            appServicePlans = new AppServicePlansImpl(this);
        }
        return appServicePlans;
    }

    /**
     * Gets the certificate order management API entry point.
     *
     * @return the certificate order management API entry point
     */
    public AppServiceCertificateOrders certificateOrders() {
        if (appServiceCertificateOrders == null) {
            appServiceCertificateOrders = new AppServiceCertificateOrdersImpl(this);
        }
        return appServiceCertificateOrders;
    }

    /**
     * Gets the certificate management API entry point.
     *
     * @return the certificate management API entry point
     */
    public AppServiceCertificates certificates() {
        if (appServiceCertificates == null) {
            appServiceCertificates = new AppServiceCertificatesImpl(this);
        }
        return appServiceCertificates;
    }

    /**
     * Gets the app service plan management API entry point.
     *
     * @return the app service plan management API entry point
     */
    public AppServiceDomains domains() {
        if (appServiceDomains == null) {
            appServiceDomains = new AppServiceDomainsImpl(this);
        }
        return appServiceDomains;
    }

    /**
     * Gets the web app management API entry point.
     *
     * @return the web app management API entry point
     */
    public FunctionApps functionApps() {
        if (functionApps == null) {
            functionApps = new FunctionAppsImpl(this);
        }
        return functionApps;
    }
}
