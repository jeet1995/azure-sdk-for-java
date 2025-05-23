// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.fluent.models.GoogleCloudStorageLinkedServiceTypeProperties;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Linked service for Google Cloud Storage.
 */
@Fluent
public final class GoogleCloudStorageLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    private String type = "GoogleCloudStorage";

    /*
     * Google Cloud Storage linked service properties.
     */
    private GoogleCloudStorageLinkedServiceTypeProperties innerTypeProperties
        = new GoogleCloudStorageLinkedServiceTypeProperties();

    /**
     * Creates an instance of GoogleCloudStorageLinkedService class.
     */
    public GoogleCloudStorageLinkedService() {
    }

    /**
     * Get the type property: Type of linked service.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the innerTypeProperties property: Google Cloud Storage linked service properties.
     * 
     * @return the innerTypeProperties value.
     */
    GoogleCloudStorageLinkedServiceTypeProperties innerTypeProperties() {
        return this.innerTypeProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLinkedService withVersion(String version) {
        super.withVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLinkedService withConnectVia(IntegrationRuntimeReference connectVia) {
        super.withConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLinkedService withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLinkedService withParameters(Map<String, ParameterSpecification> parameters) {
        super.withParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLinkedService withAnnotations(List<Object> annotations) {
        super.withAnnotations(annotations);
        return this;
    }

    /**
     * Get the accessKeyId property: The access key identifier of the Google Cloud Storage Identity and Access
     * Management (IAM) user. Type: string (or Expression with resultType string).
     * 
     * @return the accessKeyId value.
     */
    public Object accessKeyId() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().accessKeyId();
    }

    /**
     * Set the accessKeyId property: The access key identifier of the Google Cloud Storage Identity and Access
     * Management (IAM) user. Type: string (or Expression with resultType string).
     * 
     * @param accessKeyId the accessKeyId value to set.
     * @return the GoogleCloudStorageLinkedService object itself.
     */
    public GoogleCloudStorageLinkedService withAccessKeyId(Object accessKeyId) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleCloudStorageLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAccessKeyId(accessKeyId);
        return this;
    }

    /**
     * Get the secretAccessKey property: The secret access key of the Google Cloud Storage Identity and Access
     * Management (IAM) user.
     * 
     * @return the secretAccessKey value.
     */
    public SecretBase secretAccessKey() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().secretAccessKey();
    }

    /**
     * Set the secretAccessKey property: The secret access key of the Google Cloud Storage Identity and Access
     * Management (IAM) user.
     * 
     * @param secretAccessKey the secretAccessKey value to set.
     * @return the GoogleCloudStorageLinkedService object itself.
     */
    public GoogleCloudStorageLinkedService withSecretAccessKey(SecretBase secretAccessKey) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleCloudStorageLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withSecretAccessKey(secretAccessKey);
        return this;
    }

    /**
     * Get the serviceUrl property: This value specifies the endpoint to access with the Google Cloud Storage Connector.
     * This is an optional property; change it only if you want to try a different service endpoint or want to switch
     * between https and http. Type: string (or Expression with resultType string).
     * 
     * @return the serviceUrl value.
     */
    public Object serviceUrl() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().serviceUrl();
    }

    /**
     * Set the serviceUrl property: This value specifies the endpoint to access with the Google Cloud Storage Connector.
     * This is an optional property; change it only if you want to try a different service endpoint or want to switch
     * between https and http. Type: string (or Expression with resultType string).
     * 
     * @param serviceUrl the serviceUrl value to set.
     * @return the GoogleCloudStorageLinkedService object itself.
     */
    public GoogleCloudStorageLinkedService withServiceUrl(Object serviceUrl) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleCloudStorageLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withServiceUrl(serviceUrl);
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @return the encryptedCredential value.
     */
    public String encryptedCredential() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().encryptedCredential();
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the GoogleCloudStorageLinkedService object itself.
     */
    public GoogleCloudStorageLinkedService withEncryptedCredential(String encryptedCredential) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleCloudStorageLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withEncryptedCredential(encryptedCredential);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerTypeProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerTypeProperties in model GoogleCloudStorageLinkedService"));
        } else {
            innerTypeProperties().validate();
        }
        if (connectVia() != null) {
            connectVia().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(GoogleCloudStorageLinkedService.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", version());
        jsonWriter.writeJsonField("connectVia", connectVia());
        jsonWriter.writeStringField("description", description());
        jsonWriter.writeMapField("parameters", parameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", annotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("typeProperties", this.innerTypeProperties);
        jsonWriter.writeStringField("type", this.type);
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GoogleCloudStorageLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GoogleCloudStorageLinkedService if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GoogleCloudStorageLinkedService.
     */
    public static GoogleCloudStorageLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GoogleCloudStorageLinkedService deserializedGoogleCloudStorageLinkedService
                = new GoogleCloudStorageLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedGoogleCloudStorageLinkedService.withVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedGoogleCloudStorageLinkedService
                        .withConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedGoogleCloudStorageLinkedService.withDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedGoogleCloudStorageLinkedService.withParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedGoogleCloudStorageLinkedService.withAnnotations(annotations);
                } else if ("typeProperties".equals(fieldName)) {
                    deserializedGoogleCloudStorageLinkedService.innerTypeProperties
                        = GoogleCloudStorageLinkedServiceTypeProperties.fromJson(reader);
                } else if ("type".equals(fieldName)) {
                    deserializedGoogleCloudStorageLinkedService.type = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedGoogleCloudStorageLinkedService.withAdditionalProperties(additionalProperties);

            return deserializedGoogleCloudStorageLinkedService;
        });
    }
}
