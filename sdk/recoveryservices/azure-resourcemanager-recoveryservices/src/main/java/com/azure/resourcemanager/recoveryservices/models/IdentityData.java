// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Identity for the resource.
 */
@Fluent
public final class IdentityData implements JsonSerializable<IdentityData> {
    /*
     * The principal ID of resource identity.
     */
    private String principalId;

    /*
     * The tenant ID of resource.
     */
    private String tenantId;

    /*
     * The type of managed identity used. The type 'SystemAssigned, UserAssigned' includes both an implicitly created
     * identity and a set of user-assigned identities. The type 'None' will remove any identities.
     */
    private ResourceIdentityType type;

    /*
     * The list of user-assigned identities associated with the resource. The user-assigned identity dictionary keys
     * will be ARM resource ids in the form:
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ManagedIdentity/
     * userAssignedIdentities/{identityName}'.
     */
    private Map<String, UserIdentity> userAssignedIdentities;

    /**
     * Creates an instance of IdentityData class.
     */
    public IdentityData() {
    }

    /**
     * Get the principalId property: The principal ID of resource identity.
     * 
     * @return the principalId value.
     */
    public String principalId() {
        return this.principalId;
    }

    /**
     * Get the tenantId property: The tenant ID of resource.
     * 
     * @return the tenantId value.
     */
    public String tenantId() {
        return this.tenantId;
    }

    /**
     * Get the type property: The type of managed identity used. The type 'SystemAssigned, UserAssigned' includes both
     * an implicitly created identity and a set of user-assigned identities. The type 'None' will remove any identities.
     * 
     * @return the type value.
     */
    public ResourceIdentityType type() {
        return this.type;
    }

    /**
     * Set the type property: The type of managed identity used. The type 'SystemAssigned, UserAssigned' includes both
     * an implicitly created identity and a set of user-assigned identities. The type 'None' will remove any identities.
     * 
     * @param type the type value to set.
     * @return the IdentityData object itself.
     */
    public IdentityData withType(ResourceIdentityType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the userAssignedIdentities property: The list of user-assigned identities associated with the resource. The
     * user-assigned identity dictionary keys will be ARM resource ids in the form:
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{identityName}'.
     * 
     * @return the userAssignedIdentities value.
     */
    public Map<String, UserIdentity> userAssignedIdentities() {
        return this.userAssignedIdentities;
    }

    /**
     * Set the userAssignedIdentities property: The list of user-assigned identities associated with the resource. The
     * user-assigned identity dictionary keys will be ARM resource ids in the form:
     * '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ManagedIdentity/userAssignedIdentities/{identityName}'.
     * 
     * @param userAssignedIdentities the userAssignedIdentities value to set.
     * @return the IdentityData object itself.
     */
    public IdentityData withUserAssignedIdentities(Map<String, UserIdentity> userAssignedIdentities) {
        this.userAssignedIdentities = userAssignedIdentities;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (type() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property type in model IdentityData"));
        }
        if (userAssignedIdentities() != null) {
            userAssignedIdentities().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IdentityData.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        jsonWriter.writeMapField("userAssignedIdentities", this.userAssignedIdentities,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IdentityData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IdentityData if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IdentityData.
     */
    public static IdentityData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IdentityData deserializedIdentityData = new IdentityData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedIdentityData.type = ResourceIdentityType.fromString(reader.getString());
                } else if ("principalId".equals(fieldName)) {
                    deserializedIdentityData.principalId = reader.getString();
                } else if ("tenantId".equals(fieldName)) {
                    deserializedIdentityData.tenantId = reader.getString();
                } else if ("userAssignedIdentities".equals(fieldName)) {
                    Map<String, UserIdentity> userAssignedIdentities
                        = reader.readMap(reader1 -> UserIdentity.fromJson(reader1));
                    deserializedIdentityData.userAssignedIdentities = userAssignedIdentities;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIdentityData;
        });
    }
}
