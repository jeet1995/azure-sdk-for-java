// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.securityinsights.models.AnomalySecurityMLAnalyticsSettings;
import com.azure.resourcemanager.securityinsights.models.ResourceWithEtag;
import com.azure.resourcemanager.securityinsights.models.SecurityMLAnalyticsSettingsKind;
import java.io.IOException;

/**
 * Security ML Analytics Setting.
 */
@Fluent
public class SecurityMLAnalyticsSettingInner extends ResourceWithEtag {
    /*
     * The kind of security ML Analytics Settings
     */
    private SecurityMLAnalyticsSettingsKind kind
        = SecurityMLAnalyticsSettingsKind.fromString("SecurityMLAnalyticsSetting");

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

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
     * Creates an instance of SecurityMLAnalyticsSettingInner class.
     */
    public SecurityMLAnalyticsSettingInner() {
    }

    /**
     * Get the kind property: The kind of security ML Analytics Settings.
     * 
     * @return the kind value.
     */
    public SecurityMLAnalyticsSettingsKind kind() {
        return this.kind;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    @Override
    public SystemData systemData() {
        return this.systemData;
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
     * {@inheritDoc}
     */
    @Override
    public SecurityMLAnalyticsSettingInner withEtag(String etag) {
        super.withEtag(etag);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("etag", etag());
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecurityMLAnalyticsSettingInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecurityMLAnalyticsSettingInner if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SecurityMLAnalyticsSettingInner.
     */
    public static SecurityMLAnalyticsSettingInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("kind".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("Anomaly".equals(discriminatorValue)) {
                    return AnomalySecurityMLAnalyticsSettings.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static SecurityMLAnalyticsSettingInner fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecurityMLAnalyticsSettingInner deserializedSecurityMLAnalyticsSettingInner
                = new SecurityMLAnalyticsSettingInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedSecurityMLAnalyticsSettingInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedSecurityMLAnalyticsSettingInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedSecurityMLAnalyticsSettingInner.type = reader.getString();
                } else if ("etag".equals(fieldName)) {
                    deserializedSecurityMLAnalyticsSettingInner.withEtag(reader.getString());
                } else if ("systemData".equals(fieldName)) {
                    deserializedSecurityMLAnalyticsSettingInner.systemData = SystemData.fromJson(reader);
                } else if ("kind".equals(fieldName)) {
                    deserializedSecurityMLAnalyticsSettingInner.kind
                        = SecurityMLAnalyticsSettingsKind.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecurityMLAnalyticsSettingInner;
        });
    }
}
