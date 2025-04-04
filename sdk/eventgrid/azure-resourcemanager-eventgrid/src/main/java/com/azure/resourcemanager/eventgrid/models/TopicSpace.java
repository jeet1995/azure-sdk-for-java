// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicSpaceInner;
import java.util.List;

/**
 * An immutable client-side representation of TopicSpace.
 */
public interface TopicSpace {
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
     * Gets the systemData property: The system metadata relating to the Event Grid resource.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the description property: Description for the Topic Space resource.
     * 
     * @return the description value.
     */
    String description();

    /**
     * Gets the topicTemplates property: The topic filters in the topic space.
     * Example: "topicTemplates": [
     * "devices/foo/bar",
     * "devices/topic1/+",
     * "devices/${principal.name}/${principal.attributes.keyName}" ].
     * 
     * @return the topicTemplates value.
     */
    List<String> topicTemplates();

    /**
     * Gets the provisioningState property: Provisioning state of the TopicSpace resource.
     * 
     * @return the provisioningState value.
     */
    TopicSpaceProvisioningState provisioningState();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.eventgrid.fluent.models.TopicSpaceInner object.
     * 
     * @return the inner object.
     */
    TopicSpaceInner innerModel();

    /**
     * The entirety of the TopicSpace definition.
     */
    interface Definition
        extends DefinitionStages.Blank, DefinitionStages.WithParentResource, DefinitionStages.WithCreate {
    }

    /**
     * The TopicSpace definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the TopicSpace definition.
         */
        interface Blank extends WithParentResource {
        }

        /**
         * The stage of the TopicSpace definition allowing to specify parent resource.
         */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, namespaceName.
             * 
             * @param resourceGroupName The name of the resource group within the user's subscription.
             * @param namespaceName Name of the namespace.
             * @return the next definition stage.
             */
            WithCreate withExistingNamespace(String resourceGroupName, String namespaceName);
        }

        /**
         * The stage of the TopicSpace definition which contains all the minimum required properties for the resource to
         * be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithDescription, DefinitionStages.WithTopicTemplates {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            TopicSpace create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            TopicSpace create(Context context);
        }

        /**
         * The stage of the TopicSpace definition allowing to specify description.
         */
        interface WithDescription {
            /**
             * Specifies the description property: Description for the Topic Space resource..
             * 
             * @param description Description for the Topic Space resource.
             * @return the next definition stage.
             */
            WithCreate withDescription(String description);
        }

        /**
         * The stage of the TopicSpace definition allowing to specify topicTemplates.
         */
        interface WithTopicTemplates {
            /**
             * Specifies the topicTemplates property: The topic filters in the topic space.
             * Example: "topicTemplates": [
             * "devices/foo/bar",
             * "devices/topic1/+",
             * "devices/${principal.name}/${principal.attributes.keyName}" ]..
             * 
             * @param topicTemplates The topic filters in the topic space.
             * Example: "topicTemplates": [
             * "devices/foo/bar",
             * "devices/topic1/+",
             * "devices/${principal.name}/${principal.attributes.keyName}" ].
             * @return the next definition stage.
             */
            WithCreate withTopicTemplates(List<String> topicTemplates);
        }
    }

    /**
     * Begins update for the TopicSpace resource.
     * 
     * @return the stage of resource update.
     */
    TopicSpace.Update update();

    /**
     * The template for TopicSpace update.
     */
    interface Update extends UpdateStages.WithDescription, UpdateStages.WithTopicTemplates {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        TopicSpace apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        TopicSpace apply(Context context);
    }

    /**
     * The TopicSpace update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the TopicSpace update allowing to specify description.
         */
        interface WithDescription {
            /**
             * Specifies the description property: Description for the Topic Space resource..
             * 
             * @param description Description for the Topic Space resource.
             * @return the next definition stage.
             */
            Update withDescription(String description);
        }

        /**
         * The stage of the TopicSpace update allowing to specify topicTemplates.
         */
        interface WithTopicTemplates {
            /**
             * Specifies the topicTemplates property: The topic filters in the topic space.
             * Example: "topicTemplates": [
             * "devices/foo/bar",
             * "devices/topic1/+",
             * "devices/${principal.name}/${principal.attributes.keyName}" ]..
             * 
             * @param topicTemplates The topic filters in the topic space.
             * Example: "topicTemplates": [
             * "devices/foo/bar",
             * "devices/topic1/+",
             * "devices/${principal.name}/${principal.attributes.keyName}" ].
             * @return the next definition stage.
             */
            Update withTopicTemplates(List<String> topicTemplates);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    TopicSpace refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    TopicSpace refresh(Context context);
}
