// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.models.LocalRulestackResourceInner;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.AzureResourceManagerManagedIdentityProperties;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.Changelog;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.CountriesResponse;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.DefaultMode;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ListAppIdResponse;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ListFirewallsResponse;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.LocalRulestackResource;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.LocalRulestackResourceUpdate;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.LocalRulestackResourceUpdateProperties;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.PredefinedUrlCategoriesResponse;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ProvisioningState;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.ScopeType;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.SecurityServices;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.SupportInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class LocalRulestackResourceImpl
    implements LocalRulestackResource, LocalRulestackResource.Definition, LocalRulestackResource.Update {
    private LocalRulestackResourceInner innerObject;

    private final com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public AzureResourceManagerManagedIdentityProperties identity() {
        return this.innerModel().identity();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public String panEtag() {
        return this.innerModel().panEtag();
    }

    public String panLocation() {
        return this.innerModel().panLocation();
    }

    public ScopeType scope() {
        return this.innerModel().scope();
    }

    public List<String> associatedSubscriptions() {
        List<String> inner = this.innerModel().associatedSubscriptions();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String description() {
        return this.innerModel().description();
    }

    public DefaultMode defaultMode() {
        return this.innerModel().defaultMode();
    }

    public String minAppIdVersion() {
        return this.innerModel().minAppIdVersion();
    }

    public ProvisioningState provisioningState() {
        return this.innerModel().provisioningState();
    }

    public SecurityServices securityServices() {
        return this.innerModel().securityServices();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public LocalRulestackResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String localRulestackName;

    private LocalRulestackResourceUpdate updateProperties;

    public LocalRulestackResourceImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public LocalRulestackResource create() {
        this.innerObject = serviceManager.serviceClient()
            .getLocalRulestacks()
            .createOrUpdate(resourceGroupName, localRulestackName, this.innerModel(), Context.NONE);
        return this;
    }

    public LocalRulestackResource create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getLocalRulestacks()
            .createOrUpdate(resourceGroupName, localRulestackName, this.innerModel(), context);
        return this;
    }

    LocalRulestackResourceImpl(String name,
        com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager serviceManager) {
        this.innerObject = new LocalRulestackResourceInner();
        this.serviceManager = serviceManager;
        this.localRulestackName = name;
    }

    public LocalRulestackResourceImpl update() {
        this.updateProperties = new LocalRulestackResourceUpdate();
        return this;
    }

    public LocalRulestackResource apply() {
        this.innerObject = serviceManager.serviceClient()
            .getLocalRulestacks()
            .updateWithResponse(resourceGroupName, localRulestackName, updateProperties, Context.NONE)
            .getValue();
        return this;
    }

    public LocalRulestackResource apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getLocalRulestacks()
            .updateWithResponse(resourceGroupName, localRulestackName, updateProperties, context)
            .getValue();
        return this;
    }

    LocalRulestackResourceImpl(LocalRulestackResourceInner innerObject,
        com.azure.resourcemanager.paloaltonetworks.ngfw.PaloAltoNetworksNgfwManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.localRulestackName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "localRulestacks");
    }

    public LocalRulestackResource refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getLocalRulestacks()
            .getByResourceGroupWithResponse(resourceGroupName, localRulestackName, Context.NONE)
            .getValue();
        return this;
    }

    public LocalRulestackResource refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getLocalRulestacks()
            .getByResourceGroupWithResponse(resourceGroupName, localRulestackName, context)
            .getValue();
        return this;
    }

    public void commit() {
        serviceManager.localRulestacks().commit(resourceGroupName, localRulestackName);
    }

    public void commit(Context context) {
        serviceManager.localRulestacks().commit(resourceGroupName, localRulestackName, context);
    }

    public Response<Changelog> getChangeLogWithResponse(Context context) {
        return serviceManager.localRulestacks()
            .getChangeLogWithResponse(resourceGroupName, localRulestackName, context);
    }

    public Changelog getChangeLog() {
        return serviceManager.localRulestacks().getChangeLog(resourceGroupName, localRulestackName);
    }

    public Response<SupportInfo> getSupportInfoWithResponse(String email, Context context) {
        return serviceManager.localRulestacks()
            .getSupportInfoWithResponse(resourceGroupName, localRulestackName, email, context);
    }

    public SupportInfo getSupportInfo() {
        return serviceManager.localRulestacks().getSupportInfo(resourceGroupName, localRulestackName);
    }

    public Response<ListAppIdResponse> listAppIdsWithResponse(String appIdVersion, String appPrefix, String skip,
        Integer top, Context context) {
        return serviceManager.localRulestacks()
            .listAppIdsWithResponse(resourceGroupName, localRulestackName, appIdVersion, appPrefix, skip, top, context);
    }

    public ListAppIdResponse listAppIds() {
        return serviceManager.localRulestacks().listAppIds(resourceGroupName, localRulestackName);
    }

    public Response<CountriesResponse> listCountriesWithResponse(String skip, Integer top, Context context) {
        return serviceManager.localRulestacks()
            .listCountriesWithResponse(resourceGroupName, localRulestackName, skip, top, context);
    }

    public CountriesResponse listCountries() {
        return serviceManager.localRulestacks().listCountries(resourceGroupName, localRulestackName);
    }

    public Response<ListFirewallsResponse> listFirewallsWithResponse(Context context) {
        return serviceManager.localRulestacks()
            .listFirewallsWithResponse(resourceGroupName, localRulestackName, context);
    }

    public ListFirewallsResponse listFirewalls() {
        return serviceManager.localRulestacks().listFirewalls(resourceGroupName, localRulestackName);
    }

    public Response<PredefinedUrlCategoriesResponse> listPredefinedUrlCategoriesWithResponse(String skip, Integer top,
        Context context) {
        return serviceManager.localRulestacks()
            .listPredefinedUrlCategoriesWithResponse(resourceGroupName, localRulestackName, skip, top, context);
    }

    public PredefinedUrlCategoriesResponse listPredefinedUrlCategories() {
        return serviceManager.localRulestacks().listPredefinedUrlCategories(resourceGroupName, localRulestackName);
    }

    public Response<Void> revertWithResponse(Context context) {
        return serviceManager.localRulestacks().revertWithResponse(resourceGroupName, localRulestackName, context);
    }

    public void revert() {
        serviceManager.localRulestacks().revert(resourceGroupName, localRulestackName);
    }

    public LocalRulestackResourceImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public LocalRulestackResourceImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public LocalRulestackResourceImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public LocalRulestackResourceImpl withIdentity(AzureResourceManagerManagedIdentityProperties identity) {
        if (isInCreateMode()) {
            this.innerModel().withIdentity(identity);
            return this;
        } else {
            this.updateProperties.withIdentity(identity);
            return this;
        }
    }

    public LocalRulestackResourceImpl withPanEtag(String panEtag) {
        this.innerModel().withPanEtag(panEtag);
        return this;
    }

    public LocalRulestackResourceImpl withPanLocation(String panLocation) {
        this.innerModel().withPanLocation(panLocation);
        return this;
    }

    public LocalRulestackResourceImpl withScope(ScopeType scope) {
        this.innerModel().withScope(scope);
        return this;
    }

    public LocalRulestackResourceImpl withAssociatedSubscriptions(List<String> associatedSubscriptions) {
        this.innerModel().withAssociatedSubscriptions(associatedSubscriptions);
        return this;
    }

    public LocalRulestackResourceImpl withDescription(String description) {
        this.innerModel().withDescription(description);
        return this;
    }

    public LocalRulestackResourceImpl withDefaultMode(DefaultMode defaultMode) {
        this.innerModel().withDefaultMode(defaultMode);
        return this;
    }

    public LocalRulestackResourceImpl withMinAppIdVersion(String minAppIdVersion) {
        this.innerModel().withMinAppIdVersion(minAppIdVersion);
        return this;
    }

    public LocalRulestackResourceImpl withSecurityServices(SecurityServices securityServices) {
        this.innerModel().withSecurityServices(securityServices);
        return this;
    }

    public LocalRulestackResourceImpl withProperties(LocalRulestackResourceUpdateProperties properties) {
        this.updateProperties.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
