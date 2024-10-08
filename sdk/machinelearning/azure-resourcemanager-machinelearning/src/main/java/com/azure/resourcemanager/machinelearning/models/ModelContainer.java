// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.models;

import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.machinelearning.fluent.models.ModelContainerInner;

/**
 * An immutable client-side representation of ModelContainer.
 */
public interface ModelContainer {
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
     * Gets the properties property: [Required] Additional attributes of the entity.
     * 
     * @return the properties value.
     */
    ModelContainerProperties properties();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.machinelearning.fluent.models.ModelContainerInner object.
     * 
     * @return the inner object.
     */
    ModelContainerInner innerModel();

    /**
     * The entirety of the ModelContainer definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithParentResource,
        DefinitionStages.WithProperties, DefinitionStages.WithCreate {
    }

    /**
     * The ModelContainer definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the ModelContainer definition.
         */
        interface Blank extends WithParentResource {
        }

        /**
         * The stage of the ModelContainer definition allowing to specify parent resource.
         */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, workspaceName.
             * 
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @param workspaceName Name of Azure Machine Learning workspace.
             * @return the next definition stage.
             */
            WithProperties withExistingWorkspace(String resourceGroupName, String workspaceName);
        }

        /**
         * The stage of the ModelContainer definition allowing to specify properties.
         */
        interface WithProperties {
            /**
             * Specifies the properties property: [Required] Additional attributes of the entity..
             * 
             * @param properties [Required] Additional attributes of the entity.
             * @return the next definition stage.
             */
            WithCreate withProperties(ModelContainerProperties properties);
        }

        /**
         * The stage of the ModelContainer definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            ModelContainer create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            ModelContainer create(Context context);
        }
    }

    /**
     * Begins update for the ModelContainer resource.
     * 
     * @return the stage of resource update.
     */
    ModelContainer.Update update();

    /**
     * The template for ModelContainer update.
     */
    interface Update extends UpdateStages.WithProperties {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        ModelContainer apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        ModelContainer apply(Context context);
    }

    /**
     * The ModelContainer update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the ModelContainer update allowing to specify properties.
         */
        interface WithProperties {
            /**
             * Specifies the properties property: [Required] Additional attributes of the entity..
             * 
             * @param properties [Required] Additional attributes of the entity.
             * @return the next definition stage.
             */
            Update withProperties(ModelContainerProperties properties);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    ModelContainer refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    ModelContainer refresh(Context context);
}
