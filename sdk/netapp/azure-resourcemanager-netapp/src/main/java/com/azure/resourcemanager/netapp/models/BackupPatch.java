// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.netapp.fluent.models.BackupPatchProperties;
import java.io.IOException;

/**
 * Backup patch.
 */
@Fluent
public final class BackupPatch implements JsonSerializable<BackupPatch> {
    /*
     * Backup Patch Properties
     */
    private BackupPatchProperties innerProperties;

    /**
     * Creates an instance of BackupPatch class.
     */
    public BackupPatch() {
    }

    /**
     * Get the innerProperties property: Backup Patch Properties.
     * 
     * @return the innerProperties value.
     */
    private BackupPatchProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the label property: Label for backup.
     * 
     * @return the label value.
     */
    public String label() {
        return this.innerProperties() == null ? null : this.innerProperties().label();
    }

    /**
     * Set the label property: Label for backup.
     * 
     * @param label the label value to set.
     * @return the BackupPatch object itself.
     */
    public BackupPatch withLabel(String label) {
        if (this.innerProperties() == null) {
            this.innerProperties = new BackupPatchProperties();
        }
        this.innerProperties().withLabel(label);
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
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BackupPatch from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BackupPatch if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the BackupPatch.
     */
    public static BackupPatch fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BackupPatch deserializedBackupPatch = new BackupPatch();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedBackupPatch.innerProperties = BackupPatchProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBackupPatch;
        });
    }
}
