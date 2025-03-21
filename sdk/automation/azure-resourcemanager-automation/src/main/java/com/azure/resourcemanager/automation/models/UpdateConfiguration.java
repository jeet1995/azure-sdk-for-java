// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * Update specific properties of the software update configuration.
 */
@Fluent
public final class UpdateConfiguration implements JsonSerializable<UpdateConfiguration> {
    /*
     * operating system of target machines
     */
    private OperatingSystemType operatingSystem;

    /*
     * Windows specific update configuration.
     */
    private WindowsProperties windows;

    /*
     * Linux specific update configuration.
     */
    private LinuxProperties linux;

    /*
     * Maximum time allowed for the software update configuration run. Duration needs to be specified using the format
     * PT[n]H[n]M[n]S as per ISO8601
     */
    private Duration duration;

    /*
     * List of azure resource Ids for azure virtual machines targeted by the software update configuration.
     */
    private List<String> azureVirtualMachines;

    /*
     * List of names of non-azure machines targeted by the software update configuration.
     */
    private List<String> nonAzureComputerNames;

    /*
     * Group targets for the software update configuration.
     */
    private TargetProperties targets;

    /**
     * Creates an instance of UpdateConfiguration class.
     */
    public UpdateConfiguration() {
    }

    /**
     * Get the operatingSystem property: operating system of target machines.
     * 
     * @return the operatingSystem value.
     */
    public OperatingSystemType operatingSystem() {
        return this.operatingSystem;
    }

    /**
     * Set the operatingSystem property: operating system of target machines.
     * 
     * @param operatingSystem the operatingSystem value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withOperatingSystem(OperatingSystemType operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    /**
     * Get the windows property: Windows specific update configuration.
     * 
     * @return the windows value.
     */
    public WindowsProperties windows() {
        return this.windows;
    }

    /**
     * Set the windows property: Windows specific update configuration.
     * 
     * @param windows the windows value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withWindows(WindowsProperties windows) {
        this.windows = windows;
        return this;
    }

    /**
     * Get the linux property: Linux specific update configuration.
     * 
     * @return the linux value.
     */
    public LinuxProperties linux() {
        return this.linux;
    }

    /**
     * Set the linux property: Linux specific update configuration.
     * 
     * @param linux the linux value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withLinux(LinuxProperties linux) {
        this.linux = linux;
        return this;
    }

    /**
     * Get the duration property: Maximum time allowed for the software update configuration run. Duration needs to be
     * specified using the format PT[n]H[n]M[n]S as per ISO8601.
     * 
     * @return the duration value.
     */
    public Duration duration() {
        return this.duration;
    }

    /**
     * Set the duration property: Maximum time allowed for the software update configuration run. Duration needs to be
     * specified using the format PT[n]H[n]M[n]S as per ISO8601.
     * 
     * @param duration the duration value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withDuration(Duration duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Get the azureVirtualMachines property: List of azure resource Ids for azure virtual machines targeted by the
     * software update configuration.
     * 
     * @return the azureVirtualMachines value.
     */
    public List<String> azureVirtualMachines() {
        return this.azureVirtualMachines;
    }

    /**
     * Set the azureVirtualMachines property: List of azure resource Ids for azure virtual machines targeted by the
     * software update configuration.
     * 
     * @param azureVirtualMachines the azureVirtualMachines value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withAzureVirtualMachines(List<String> azureVirtualMachines) {
        this.azureVirtualMachines = azureVirtualMachines;
        return this;
    }

    /**
     * Get the nonAzureComputerNames property: List of names of non-azure machines targeted by the software update
     * configuration.
     * 
     * @return the nonAzureComputerNames value.
     */
    public List<String> nonAzureComputerNames() {
        return this.nonAzureComputerNames;
    }

    /**
     * Set the nonAzureComputerNames property: List of names of non-azure machines targeted by the software update
     * configuration.
     * 
     * @param nonAzureComputerNames the nonAzureComputerNames value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withNonAzureComputerNames(List<String> nonAzureComputerNames) {
        this.nonAzureComputerNames = nonAzureComputerNames;
        return this;
    }

    /**
     * Get the targets property: Group targets for the software update configuration.
     * 
     * @return the targets value.
     */
    public TargetProperties targets() {
        return this.targets;
    }

    /**
     * Set the targets property: Group targets for the software update configuration.
     * 
     * @param targets the targets value to set.
     * @return the UpdateConfiguration object itself.
     */
    public UpdateConfiguration withTargets(TargetProperties targets) {
        this.targets = targets;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (operatingSystem() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property operatingSystem in model UpdateConfiguration"));
        }
        if (windows() != null) {
            windows().validate();
        }
        if (linux() != null) {
            linux().validate();
        }
        if (targets() != null) {
            targets().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(UpdateConfiguration.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("operatingSystem",
            this.operatingSystem == null ? null : this.operatingSystem.toString());
        jsonWriter.writeJsonField("windows", this.windows);
        jsonWriter.writeJsonField("linux", this.linux);
        jsonWriter.writeStringField("duration", CoreUtils.durationToStringWithDays(this.duration));
        jsonWriter.writeArrayField("azureVirtualMachines", this.azureVirtualMachines,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("nonAzureComputerNames", this.nonAzureComputerNames,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("targets", this.targets);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of UpdateConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UpdateConfiguration if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the UpdateConfiguration.
     */
    public static UpdateConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UpdateConfiguration deserializedUpdateConfiguration = new UpdateConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("operatingSystem".equals(fieldName)) {
                    deserializedUpdateConfiguration.operatingSystem
                        = OperatingSystemType.fromString(reader.getString());
                } else if ("windows".equals(fieldName)) {
                    deserializedUpdateConfiguration.windows = WindowsProperties.fromJson(reader);
                } else if ("linux".equals(fieldName)) {
                    deserializedUpdateConfiguration.linux = LinuxProperties.fromJson(reader);
                } else if ("duration".equals(fieldName)) {
                    deserializedUpdateConfiguration.duration
                        = reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString()));
                } else if ("azureVirtualMachines".equals(fieldName)) {
                    List<String> azureVirtualMachines = reader.readArray(reader1 -> reader1.getString());
                    deserializedUpdateConfiguration.azureVirtualMachines = azureVirtualMachines;
                } else if ("nonAzureComputerNames".equals(fieldName)) {
                    List<String> nonAzureComputerNames = reader.readArray(reader1 -> reader1.getString());
                    deserializedUpdateConfiguration.nonAzureComputerNames = nonAzureComputerNames;
                } else if ("targets".equals(fieldName)) {
                    deserializedUpdateConfiguration.targets = TargetProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUpdateConfiguration;
        });
    }
}
