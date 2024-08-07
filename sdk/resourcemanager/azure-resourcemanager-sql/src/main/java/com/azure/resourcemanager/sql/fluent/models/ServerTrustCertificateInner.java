// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Server trust certificate imported from box to enable connection between box and Sql Managed Instance.
 */
@Fluent
public final class ServerTrustCertificateInner extends ProxyResource {
    /*
     * Resource properties.
     */
    private ServerTrustCertificateProperties innerProperties;

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
     * Creates an instance of ServerTrustCertificateInner class.
     */
    public ServerTrustCertificateInner() {
    }

    /**
     * Get the innerProperties property: Resource properties.
     * 
     * @return the innerProperties value.
     */
    private ServerTrustCertificateProperties innerProperties() {
        return this.innerProperties;
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
     * Get the publicBlob property: The certificate public blob.
     * 
     * @return the publicBlob value.
     */
    public String publicBlob() {
        return this.innerProperties() == null ? null : this.innerProperties().publicBlob();
    }

    /**
     * Set the publicBlob property: The certificate public blob.
     * 
     * @param publicBlob the publicBlob value to set.
     * @return the ServerTrustCertificateInner object itself.
     */
    public ServerTrustCertificateInner withPublicBlob(String publicBlob) {
        if (this.innerProperties() == null) {
            this.innerProperties = new ServerTrustCertificateProperties();
        }
        this.innerProperties().withPublicBlob(publicBlob);
        return this;
    }

    /**
     * Get the thumbprint property: The certificate thumbprint.
     * 
     * @return the thumbprint value.
     */
    public String thumbprint() {
        return this.innerProperties() == null ? null : this.innerProperties().thumbprint();
    }

    /**
     * Get the certificateName property: The certificate name.
     * 
     * @return the certificateName value.
     */
    public String certificateName() {
        return this.innerProperties() == null ? null : this.innerProperties().certificateName();
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
     * Reads an instance of ServerTrustCertificateInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ServerTrustCertificateInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ServerTrustCertificateInner.
     */
    public static ServerTrustCertificateInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ServerTrustCertificateInner deserializedServerTrustCertificateInner = new ServerTrustCertificateInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedServerTrustCertificateInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedServerTrustCertificateInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedServerTrustCertificateInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedServerTrustCertificateInner.innerProperties
                        = ServerTrustCertificateProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedServerTrustCertificateInner;
        });
    }
}
