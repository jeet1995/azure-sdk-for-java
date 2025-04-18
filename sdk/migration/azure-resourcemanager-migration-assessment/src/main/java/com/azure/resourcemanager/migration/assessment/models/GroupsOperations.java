// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of GroupsOperations.
 */
public interface GroupsOperations {
    /**
     * List Group resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a Group list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Group> listByAssessmentProject(String resourceGroupName, String projectName);

    /**
     * List Group resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a Group list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Group> listByAssessmentProject(String resourceGroupName, String projectName, Context context);

    /**
     * Get a Group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param groupName Group ARM name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Group along with {@link Response}.
     */
    Response<Group> getWithResponse(String resourceGroupName, String projectName, String groupName, Context context);

    /**
     * Get a Group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param groupName Group ARM name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Group.
     */
    Group get(String resourceGroupName, String projectName, String groupName);

    /**
     * Delete a Group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param groupName Group ARM name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String resourceGroupName, String projectName, String groupName, Context context);

    /**
     * Delete a Group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param groupName Group ARM name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String projectName, String groupName);

    /**
     * Update machines in group.
     * 
     * Update machines in group by adding or removing machines.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param groupName Group ARM name.
     * @param body The content of the action request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return group resource.
     */
    Group updateMachines(String resourceGroupName, String projectName, String groupName, UpdateGroupBody body);

    /**
     * Update machines in group.
     * 
     * Update machines in group by adding or removing machines.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param groupName Group ARM name.
     * @param body The content of the action request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return group resource.
     */
    Group updateMachines(String resourceGroupName, String projectName, String groupName, UpdateGroupBody body,
        Context context);

    /**
     * Get a Group.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Group along with {@link Response}.
     */
    Group getById(String id);

    /**
     * Get a Group.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Group along with {@link Response}.
     */
    Response<Group> getByIdWithResponse(String id, Context context);

    /**
     * Delete a Group.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Delete a Group.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new Group resource.
     * 
     * @param name resource name.
     * @return the first stage of the new Group definition.
     */
    Group.DefinitionStages.Blank define(String name);
}
