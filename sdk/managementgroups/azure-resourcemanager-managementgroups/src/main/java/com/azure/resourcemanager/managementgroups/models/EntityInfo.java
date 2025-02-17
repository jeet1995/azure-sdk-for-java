// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managementgroups.models;

import com.azure.resourcemanager.managementgroups.fluent.models.EntityInfoInner;
import java.util.List;

/**
 * An immutable client-side representation of EntityInfo.
 */
public interface EntityInfo {
    /**
     * Gets the id property: The fully qualified ID for the entity. For example,
     * /providers/Microsoft.Management/managementGroups/0000000-0000-0000-0000-000000000000.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the type property: The type of the resource. For example, Microsoft.Management/managementGroups.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the name property: The name of the entity. For example, 00000000-0000-0000-0000-000000000000.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the tenantId property: The AAD Tenant ID associated with the entity. For example,
     * 00000000-0000-0000-0000-000000000000.
     * 
     * @return the tenantId value.
     */
    String tenantId();

    /**
     * Gets the displayName property: The friendly name of the management group.
     * 
     * @return the displayName value.
     */
    String displayName();

    /**
     * Gets the parent property: (Optional) The ID of the parent management group.
     * 
     * @return the parent value.
     */
    EntityParentGroupInfo parent();

    /**
     * Gets the permissions property: The users specific permissions to this item.
     * 
     * @return the permissions value.
     */
    Permissions permissions();

    /**
     * Gets the inheritedPermissions property: The users specific permissions to this item.
     * 
     * @return the inheritedPermissions value.
     */
    Permissions inheritedPermissions();

    /**
     * Gets the numberOfDescendants property: Number of Descendants.
     * 
     * @return the numberOfDescendants value.
     */
    Integer numberOfDescendants();

    /**
     * Gets the numberOfChildren property: Number of children is the number of Groups and Subscriptions that are exactly
     * one level underneath the current Group.
     * 
     * @return the numberOfChildren value.
     */
    Integer numberOfChildren();

    /**
     * Gets the numberOfChildGroups property: Number of children is the number of Groups that are exactly one level
     * underneath the current Group.
     * 
     * @return the numberOfChildGroups value.
     */
    Integer numberOfChildGroups();

    /**
     * Gets the parentDisplayNameChain property: The parent display name chain from the root group to the immediate
     * parent.
     * 
     * @return the parentDisplayNameChain value.
     */
    List<String> parentDisplayNameChain();

    /**
     * Gets the parentNameChain property: The parent name chain from the root group to the immediate parent.
     * 
     * @return the parentNameChain value.
     */
    List<String> parentNameChain();

    /**
     * Gets the inner com.azure.resourcemanager.managementgroups.fluent.models.EntityInfoInner object.
     * 
     * @return the inner object.
     */
    EntityInfoInner innerModel();
}
