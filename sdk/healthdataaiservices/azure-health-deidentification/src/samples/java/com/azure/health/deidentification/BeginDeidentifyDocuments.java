// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.health.deidentification;

import com.azure.core.util.Configuration;
import com.azure.health.deidentification.models.DeidentificationJob;
import com.azure.health.deidentification.models.DeidentificationOperationType;
import com.azure.health.deidentification.models.SourceStorageLocation;
import com.azure.health.deidentification.models.TargetStorageLocation;
import com.azure.identity.DefaultAzureCredentialBuilder;

import java.time.Instant;

public class BeginDeidentifyDocuments {
    public static void main(String[] args) {
        DeidentificationClient deidentificationClient = new DeidentificationClientBuilder()
            .endpoint(Configuration.getGlobalConfiguration().get("DEID_SERVICE_ENDPOINT", "endpoint"))
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        // BEGIN:com.azure.health.deidentification.samples.begin_deidentify_documents
        String storageLocation = "https://" + Configuration.getGlobalConfiguration().get("STORAGE_ACCOUNT_NAME") + ".blob.core.windows.net/" + Configuration.getGlobalConfiguration().get("STORAGE_CONTAINER_NAME");
        DeidentificationJob job = new DeidentificationJob(
            new SourceStorageLocation(storageLocation, "data/example_patient_1"),
            new TargetStorageLocation(storageLocation, "_output")
                .setOverwrite(true)
        );

        job.setOperationType(DeidentificationOperationType.REDACT);

        String jobName = Configuration.getGlobalConfiguration().get("DEID_JOB_NAME", "MyJob-" + Instant.now().toEpochMilli());
        DeidentificationJob result = deidentificationClient.beginDeidentifyDocuments(jobName, job)
            .waitForCompletion()
            .getValue();
        System.out.println(jobName + " - " + result.getStatus());
        // END:com.azure.health.deidentification.samples.begin_deidentify_documents
    }
}
