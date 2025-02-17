// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.monitor.opentelemetry.autoconfigure.implementation.statsbeat;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class AzureMetadataServiceTest {

    @Test
    public void testParseJsonResponseLinux() throws IOException {
        Path path
            = new File(getClass().getClassLoader().getResource("metadata_instance_linux.json").getPath()).toPath();
        byte[] fileContent = Files.readAllBytes(path);
        String result = new String(fileContent, StandardCharsets.UTF_8);

        AttachStatsbeat attachStatsbeat = new AttachStatsbeat(new CustomDimensions());
        AzureMetadataService azureMetadataService
            = new AzureMetadataService(attachStatsbeat, new CustomDimensions(), response -> {
            });
        azureMetadataService.updateMetadata(result);

        MetadataInstanceResponse response = attachStatsbeat.getMetadataInstanceResponse();
        assertThat(response.getVmId()).isEqualTo("2a1216c3-a2a0-4fc5-a941-b1f5acde7051");
        assertThat(response.getOsType()).isEqualTo("Linux");
        assertThat(response.getResourceGroupName()).isEqualTo("heya-java-ipa");
        assertThat(response.getSubscriptionId()).isEqualTo("65b2f83e-7bf1-4be3-bafc-3a4163265a52");
    }

    @Test
    public void testParseJsonResponseWindows() throws IOException {
        Path path
            = new File(getClass().getClassLoader().getResource("metadata_instance_windows.json").getPath()).toPath();
        byte[] fileContent = Files.readAllBytes(path);
        String result = new String(fileContent, StandardCharsets.UTF_8);

        AttachStatsbeat attachStatsbeat = new AttachStatsbeat(new CustomDimensions());
        AzureMetadataService azureMetadataService
            = new AzureMetadataService(attachStatsbeat, new CustomDimensions(), (response) -> {
            });
        azureMetadataService.updateMetadata(result);

        MetadataInstanceResponse response = attachStatsbeat.getMetadataInstanceResponse();
        assertThat(response.getVmId()).isEqualTo("2955a129-2323-4c1f-8918-994a7a83eefd");
        assertThat(response.getOsType()).isEqualTo("Windows");
        assertThat(response.getResourceGroupName()).isEqualTo("heya-java-ipa");
        assertThat(response.getSubscriptionId()).isEqualTo("65b2f83e-7bf1-4be3-bafc-3a4163265a52");
    }
}
