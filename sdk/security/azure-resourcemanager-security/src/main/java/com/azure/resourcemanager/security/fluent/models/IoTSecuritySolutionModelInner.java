// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.models.AdditionalWorkspacesProperties;
import com.azure.resourcemanager.security.models.DataSource;
import com.azure.resourcemanager.security.models.ExportData;
import com.azure.resourcemanager.security.models.RecommendationConfigurationProperties;
import com.azure.resourcemanager.security.models.SecuritySolutionStatus;
import com.azure.resourcemanager.security.models.UnmaskedIpLoggingStatus;
import com.azure.resourcemanager.security.models.UserDefinedResourcesProperties;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * IoT Security solution configuration and resource information.
 */
@Fluent
public final class IoTSecuritySolutionModelInner extends ProxyResource {
    /*
     * The resource location.
     */
    private String location;

    /*
     * Security Solution data
     */
    private IoTSecuritySolutionProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

    /*
     * Resource tags
     */
    private Map<String, String> tags;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of IoTSecuritySolutionModelInner class.
     */
    public IoTSecuritySolutionModelInner() {
    }

    /**
     * Get the location property: The resource location.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location property: The resource location.
     * 
     * @param location the location value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the innerProperties property: Security Solution data.
     * 
     * @return the innerProperties value.
     */
    private IoTSecuritySolutionProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags property: Resource tags.
     * 
     * @param tags the tags value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * Get the workspace property: Workspace resource ID.
     * 
     * @return the workspace value.
     */
    public String workspace() {
        return this.innerProperties() == null ? null : this.innerProperties().workspace();
    }

    /**
     * Set the workspace property: Workspace resource ID.
     * 
     * @param workspace the workspace value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withWorkspace(String workspace) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withWorkspace(workspace);
        return this;
    }

    /**
     * Get the displayName property: Resource display name.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.innerProperties() == null ? null : this.innerProperties().displayName();
    }

    /**
     * Set the displayName property: Resource display name.
     * 
     * @param displayName the displayName value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withDisplayName(String displayName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withDisplayName(displayName);
        return this;
    }

    /**
     * Get the status property: Status of the IoT Security solution.
     * 
     * @return the status value.
     */
    public SecuritySolutionStatus status() {
        return this.innerProperties() == null ? null : this.innerProperties().status();
    }

    /**
     * Set the status property: Status of the IoT Security solution.
     * 
     * @param status the status value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withStatus(SecuritySolutionStatus status) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withStatus(status);
        return this;
    }

    /**
     * Get the export property: List of additional options for exporting to workspace data.
     * 
     * @return the export value.
     */
    public List<ExportData> export() {
        return this.innerProperties() == null ? null : this.innerProperties().export();
    }

    /**
     * Set the export property: List of additional options for exporting to workspace data.
     * 
     * @param export the export value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withExport(List<ExportData> export) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withExport(export);
        return this;
    }

    /**
     * Get the disabledDataSources property: Disabled data sources. Disabling these data sources compromises the system.
     * 
     * @return the disabledDataSources value.
     */
    public List<DataSource> disabledDataSources() {
        return this.innerProperties() == null ? null : this.innerProperties().disabledDataSources();
    }

    /**
     * Set the disabledDataSources property: Disabled data sources. Disabling these data sources compromises the system.
     * 
     * @param disabledDataSources the disabledDataSources value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withDisabledDataSources(List<DataSource> disabledDataSources) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withDisabledDataSources(disabledDataSources);
        return this;
    }

    /**
     * Get the iotHubs property: IoT Hub resource IDs.
     * 
     * @return the iotHubs value.
     */
    public List<String> iotHubs() {
        return this.innerProperties() == null ? null : this.innerProperties().iotHubs();
    }

    /**
     * Set the iotHubs property: IoT Hub resource IDs.
     * 
     * @param iotHubs the iotHubs value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withIotHubs(List<String> iotHubs) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withIotHubs(iotHubs);
        return this;
    }

    /**
     * Get the userDefinedResources property: Properties of the IoT Security solution's user defined resources.
     * 
     * @return the userDefinedResources value.
     */
    public UserDefinedResourcesProperties userDefinedResources() {
        return this.innerProperties() == null ? null : this.innerProperties().userDefinedResources();
    }

    /**
     * Set the userDefinedResources property: Properties of the IoT Security solution's user defined resources.
     * 
     * @param userDefinedResources the userDefinedResources value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withUserDefinedResources(UserDefinedResourcesProperties userDefinedResources) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withUserDefinedResources(userDefinedResources);
        return this;
    }

    /**
     * Get the autoDiscoveredResources property: List of resources that were automatically discovered as relevant to the
     * security solution.
     * 
     * @return the autoDiscoveredResources value.
     */
    public List<String> autoDiscoveredResources() {
        return this.innerProperties() == null ? null : this.innerProperties().autoDiscoveredResources();
    }

    /**
     * Get the recommendationsConfiguration property: List of the configuration status for each recommendation type.
     * 
     * @return the recommendationsConfiguration value.
     */
    public List<RecommendationConfigurationProperties> recommendationsConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().recommendationsConfiguration();
    }

    /**
     * Set the recommendationsConfiguration property: List of the configuration status for each recommendation type.
     * 
     * @param recommendationsConfiguration the recommendationsConfiguration value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner
        withRecommendationsConfiguration(List<RecommendationConfigurationProperties> recommendationsConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withRecommendationsConfiguration(recommendationsConfiguration);
        return this;
    }

    /**
     * Get the unmaskedIpLoggingStatus property: Unmasked IP address logging status.
     * 
     * @return the unmaskedIpLoggingStatus value.
     */
    public UnmaskedIpLoggingStatus unmaskedIpLoggingStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().unmaskedIpLoggingStatus();
    }

    /**
     * Set the unmaskedIpLoggingStatus property: Unmasked IP address logging status.
     * 
     * @param unmaskedIpLoggingStatus the unmaskedIpLoggingStatus value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner withUnmaskedIpLoggingStatus(UnmaskedIpLoggingStatus unmaskedIpLoggingStatus) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withUnmaskedIpLoggingStatus(unmaskedIpLoggingStatus);
        return this;
    }

    /**
     * Get the additionalWorkspaces property: List of additional workspaces.
     * 
     * @return the additionalWorkspaces value.
     */
    public List<AdditionalWorkspacesProperties> additionalWorkspaces() {
        return this.innerProperties() == null ? null : this.innerProperties().additionalWorkspaces();
    }

    /**
     * Set the additionalWorkspaces property: List of additional workspaces.
     * 
     * @param additionalWorkspaces the additionalWorkspaces value to set.
     * @return the IoTSecuritySolutionModelInner object itself.
     */
    public IoTSecuritySolutionModelInner
        withAdditionalWorkspaces(List<AdditionalWorkspacesProperties> additionalWorkspaces) {
        if (this.innerProperties() == null) {
            this.innerProperties = new IoTSecuritySolutionProperties();
        }
        this.innerProperties().withAdditionalWorkspaces(additionalWorkspaces);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", this.location);
        jsonWriter.writeJsonField("properties", this.innerProperties);
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IoTSecuritySolutionModelInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IoTSecuritySolutionModelInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IoTSecuritySolutionModelInner.
     */
    public static IoTSecuritySolutionModelInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IoTSecuritySolutionModelInner deserializedIoTSecuritySolutionModelInner
                = new IoTSecuritySolutionModelInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedIoTSecuritySolutionModelInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedIoTSecuritySolutionModelInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedIoTSecuritySolutionModelInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedIoTSecuritySolutionModelInner.location = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedIoTSecuritySolutionModelInner.innerProperties
                        = IoTSecuritySolutionProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedIoTSecuritySolutionModelInner.systemData = SystemData.fromJson(reader);
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedIoTSecuritySolutionModelInner.tags = tags;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIoTSecuritySolutionModelInner;
        });
    }
}
