// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.powerbidedicated.models;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.powerbidedicated.fluent.models.DedicatedCapacityInner;
import java.util.Map;

/**
 * An immutable client-side representation of DedicatedCapacity.
 */
public interface DedicatedCapacity {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the sku property: The SKU of the PowerBI Dedicated capacity resource.
     * 
     * @return the sku value.
     */
    CapacitySku sku();

    /**
     * Gets the systemData property: Metadata pertaining to creation and last modification of the resource.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the state property: The current state of PowerBI Dedicated resource. The state is to indicate more states
     * outside of resource provisioning.
     * 
     * @return the state value.
     */
    State state();

    /**
     * Gets the provisioningState property: The current deployment state of PowerBI Dedicated resource. The
     * provisioningState is to indicate states for resource provisioning.
     * 
     * @return the provisioningState value.
     */
    CapacityProvisioningState provisioningState();

    /**
     * Gets the administration property: A collection of Dedicated capacity administrators.
     * 
     * @return the administration value.
     */
    DedicatedCapacityAdministrators administration();

    /**
     * Gets the mode property: Specifies the generation of the Power BI Embedded capacity. If no value is specified, the
     * default value 'Gen2' is used. [Learn
     * More](https://docs.microsoft.com/power-bi/developer/embedded/power-bi-embedded-generation-2).
     * 
     * @return the mode value.
     */
    Mode mode();

    /**
     * Gets the tenantId property: Tenant ID for the capacity. Used for creating Pro Plus capacity.
     * 
     * @return the tenantId value.
     */
    String tenantId();

    /**
     * Gets the friendlyName property: Capacity name.
     * 
     * @return the friendlyName value.
     */
    String friendlyName();

    /**
     * Gets the region of the resource.
     * 
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     * 
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.powerbidedicated.fluent.models.DedicatedCapacityInner object.
     * 
     * @return the inner object.
     */
    DedicatedCapacityInner innerModel();

    /**
     * The entirety of the DedicatedCapacity definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithSku, DefinitionStages.WithCreate {
    }

    /**
     * The DedicatedCapacity definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the DedicatedCapacity definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify location.
         */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             * 
             * @param resourceGroupName The name of the Azure Resource group of which a given PowerBIDedicated capacity
             * is part. This name must be at least 1 character in length, and no more than 90.
             * @return the next definition stage.
             */
            WithSku withExistingResourceGroup(String resourceGroupName);
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify sku.
         */
        interface WithSku {
            /**
             * Specifies the sku property: The SKU of the PowerBI Dedicated capacity resource..
             * 
             * @param sku The SKU of the PowerBI Dedicated capacity resource.
             * @return the next definition stage.
             */
            WithCreate withSku(CapacitySku sku);
        }

        /**
         * The stage of the DedicatedCapacity definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithTags, DefinitionStages.WithSystemData,
            DefinitionStages.WithAdministration, DefinitionStages.WithMode {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            DedicatedCapacity create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            DedicatedCapacity create(Context context);
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify systemData.
         */
        interface WithSystemData {
            /**
             * Specifies the systemData property: Metadata pertaining to creation and last modification of the
             * resource..
             * 
             * @param systemData Metadata pertaining to creation and last modification of the resource.
             * @return the next definition stage.
             */
            WithCreate withSystemData(SystemData systemData);
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify administration.
         */
        interface WithAdministration {
            /**
             * Specifies the administration property: A collection of Dedicated capacity administrators.
             * 
             * @param administration A collection of Dedicated capacity administrators.
             * @return the next definition stage.
             */
            WithCreate withAdministration(DedicatedCapacityAdministrators administration);
        }

        /**
         * The stage of the DedicatedCapacity definition allowing to specify mode.
         */
        interface WithMode {
            /**
             * Specifies the mode property: Specifies the generation of the Power BI Embedded capacity. If no value is
             * specified, the default value 'Gen2' is used. [Learn
             * More](https://docs.microsoft.com/power-bi/developer/embedded/power-bi-embedded-generation-2).
             * 
             * @param mode Specifies the generation of the Power BI Embedded capacity. If no value is specified, the
             * default value 'Gen2' is used. [Learn
             * More](https://docs.microsoft.com/power-bi/developer/embedded/power-bi-embedded-generation-2).
             * @return the next definition stage.
             */
            WithCreate withMode(Mode mode);
        }
    }

    /**
     * Begins update for the DedicatedCapacity resource.
     * 
     * @return the stage of resource update.
     */
    DedicatedCapacity.Update update();

    /**
     * The template for DedicatedCapacity update.
     */
    interface Update
        extends UpdateStages.WithTags, UpdateStages.WithSku, UpdateStages.WithAdministration, UpdateStages.WithMode {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        DedicatedCapacity apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        DedicatedCapacity apply(Context context);
    }

    /**
     * The DedicatedCapacity update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the DedicatedCapacity update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Key-value pairs of additional provisioning properties..
             * 
             * @param tags Key-value pairs of additional provisioning properties.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the DedicatedCapacity update allowing to specify sku.
         */
        interface WithSku {
            /**
             * Specifies the sku property: The SKU of the Dedicated capacity resource..
             * 
             * @param sku The SKU of the Dedicated capacity resource.
             * @return the next definition stage.
             */
            Update withSku(CapacitySku sku);
        }

        /**
         * The stage of the DedicatedCapacity update allowing to specify administration.
         */
        interface WithAdministration {
            /**
             * Specifies the administration property: A collection of Dedicated capacity administrators.
             * 
             * @param administration A collection of Dedicated capacity administrators.
             * @return the next definition stage.
             */
            Update withAdministration(DedicatedCapacityAdministrators administration);
        }

        /**
         * The stage of the DedicatedCapacity update allowing to specify mode.
         */
        interface WithMode {
            /**
             * Specifies the mode property: Specifies the generation of the Power BI Embedded capacity. If no value is
             * specified, the default value 'Gen2' is used. [Learn
             * More](https://docs.microsoft.com/power-bi/developer/embedded/power-bi-embedded-generation-2).
             * 
             * @param mode Specifies the generation of the Power BI Embedded capacity. If no value is specified, the
             * default value 'Gen2' is used. [Learn
             * More](https://docs.microsoft.com/power-bi/developer/embedded/power-bi-embedded-generation-2).
             * @return the next definition stage.
             */
            Update withMode(Mode mode);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    DedicatedCapacity refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    DedicatedCapacity refresh(Context context);

    /**
     * Suspends operation of the specified dedicated capacity instance.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void suspend();

    /**
     * Suspends operation of the specified dedicated capacity instance.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void suspend(Context context);

    /**
     * Resumes operation of the specified Dedicated capacity instance.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void resume();

    /**
     * Resumes operation of the specified Dedicated capacity instance.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void resume(Context context);
}
