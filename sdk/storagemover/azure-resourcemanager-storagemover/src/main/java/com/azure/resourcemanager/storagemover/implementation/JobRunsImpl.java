// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagemover.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.storagemover.fluent.JobRunsClient;
import com.azure.resourcemanager.storagemover.fluent.models.JobRunInner;
import com.azure.resourcemanager.storagemover.models.JobRun;
import com.azure.resourcemanager.storagemover.models.JobRuns;

public final class JobRunsImpl implements JobRuns {
    private static final ClientLogger LOGGER = new ClientLogger(JobRunsImpl.class);

    private final JobRunsClient innerClient;

    private final com.azure.resourcemanager.storagemover.StorageMoverManager serviceManager;

    public JobRunsImpl(JobRunsClient innerClient,
        com.azure.resourcemanager.storagemover.StorageMoverManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<JobRun> list(String resourceGroupName, String storageMoverName, String projectName,
        String jobDefinitionName) {
        PagedIterable<JobRunInner> inner
            = this.serviceClient().list(resourceGroupName, storageMoverName, projectName, jobDefinitionName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new JobRunImpl(inner1, this.manager()));
    }

    public PagedIterable<JobRun> list(String resourceGroupName, String storageMoverName, String projectName,
        String jobDefinitionName, Context context) {
        PagedIterable<JobRunInner> inner
            = this.serviceClient().list(resourceGroupName, storageMoverName, projectName, jobDefinitionName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new JobRunImpl(inner1, this.manager()));
    }

    public Response<JobRun> getWithResponse(String resourceGroupName, String storageMoverName, String projectName,
        String jobDefinitionName, String jobRunName, Context context) {
        Response<JobRunInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, storageMoverName, projectName, jobDefinitionName, jobRunName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new JobRunImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public JobRun get(String resourceGroupName, String storageMoverName, String projectName, String jobDefinitionName,
        String jobRunName) {
        JobRunInner inner
            = this.serviceClient().get(resourceGroupName, storageMoverName, projectName, jobDefinitionName, jobRunName);
        if (inner != null) {
            return new JobRunImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private JobRunsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.storagemover.StorageMoverManager manager() {
        return this.serviceManager;
    }
}
