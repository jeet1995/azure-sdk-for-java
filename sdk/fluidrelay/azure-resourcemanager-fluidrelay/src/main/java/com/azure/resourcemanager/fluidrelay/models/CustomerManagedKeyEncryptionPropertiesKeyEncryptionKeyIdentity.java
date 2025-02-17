// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.fluidrelay.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * All identity configuration for Customer-managed key settings defining which identity should be used to auth to Key
 * Vault.
 */
@Fluent
public final class CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity
    implements JsonSerializable<CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity> {
    /*
     * Values can be SystemAssigned or UserAssigned
     */
    private CmkIdentityType identityType;

    /*
     * user assigned identity to use for accessing key encryption key Url. Ex:
     * /subscriptions/fa5fc227-a624-475e-b696-cdd604c735bc/resourceGroups/<resource
     * group>/providers/Microsoft.ManagedIdentity/userAssignedIdentities/myId. Mutually exclusive with identityType
     * systemAssignedIdentity.
     */
    private String userAssignedIdentityResourceId;

    /**
     * Creates an instance of CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity class.
     */
    public CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity() {
    }

    /**
     * Get the identityType property: Values can be SystemAssigned or UserAssigned.
     * 
     * @return the identityType value.
     */
    public CmkIdentityType identityType() {
        return this.identityType;
    }

    /**
     * Set the identityType property: Values can be SystemAssigned or UserAssigned.
     * 
     * @param identityType the identityType value to set.
     * @return the CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity object itself.
     */
    public CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity
        withIdentityType(CmkIdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

    /**
     * Get the userAssignedIdentityResourceId property: user assigned identity to use for accessing key encryption key
     * Url. Ex: /subscriptions/fa5fc227-a624-475e-b696-cdd604c735bc/resourceGroups/&lt;resource
     * group&gt;/providers/Microsoft.ManagedIdentity/userAssignedIdentities/myId. Mutually exclusive with identityType
     * systemAssignedIdentity.
     * 
     * @return the userAssignedIdentityResourceId value.
     */
    public String userAssignedIdentityResourceId() {
        return this.userAssignedIdentityResourceId;
    }

    /**
     * Set the userAssignedIdentityResourceId property: user assigned identity to use for accessing key encryption key
     * Url. Ex: /subscriptions/fa5fc227-a624-475e-b696-cdd604c735bc/resourceGroups/&lt;resource
     * group&gt;/providers/Microsoft.ManagedIdentity/userAssignedIdentities/myId. Mutually exclusive with identityType
     * systemAssignedIdentity.
     * 
     * @param userAssignedIdentityResourceId the userAssignedIdentityResourceId value to set.
     * @return the CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity object itself.
     */
    public CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity
        withUserAssignedIdentityResourceId(String userAssignedIdentityResourceId) {
        this.userAssignedIdentityResourceId = userAssignedIdentityResourceId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("identityType", this.identityType == null ? null : this.identityType.toString());
        jsonWriter.writeStringField("userAssignedIdentityResourceId", this.userAssignedIdentityResourceId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity if the JsonReader was
     * pointing to an instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the
     * CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity.
     */
    public static CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity deserializedCustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity
                = new CustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("identityType".equals(fieldName)) {
                    deserializedCustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity.identityType
                        = CmkIdentityType.fromString(reader.getString());
                } else if ("userAssignedIdentityResourceId".equals(fieldName)) {
                    deserializedCustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity.userAssignedIdentityResourceId
                        = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCustomerManagedKeyEncryptionPropertiesKeyEncryptionKeyIdentity;
        });
    }
}
