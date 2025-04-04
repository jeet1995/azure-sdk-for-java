// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.providerhub.fluent.models.ProviderRegistrationInner;
import java.io.IOException;

/**
 * The DefaultRolloutSpecificationProviderRegistration model.
 */
@Fluent
public final class DefaultRolloutSpecificationProviderRegistration extends ProviderRegistrationInner {
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
     * Creates an instance of DefaultRolloutSpecificationProviderRegistration class.
     */
    public DefaultRolloutSpecificationProviderRegistration() {
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
    public DefaultRolloutSpecificationProviderRegistration withProperties(ProviderRegistrationProperties properties) {
        super.withProperties(properties);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", properties());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DefaultRolloutSpecificationProviderRegistration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DefaultRolloutSpecificationProviderRegistration if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DefaultRolloutSpecificationProviderRegistration.
     */
    public static DefaultRolloutSpecificationProviderRegistration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DefaultRolloutSpecificationProviderRegistration deserializedDefaultRolloutSpecificationProviderRegistration
                = new DefaultRolloutSpecificationProviderRegistration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedDefaultRolloutSpecificationProviderRegistration.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedDefaultRolloutSpecificationProviderRegistration.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedDefaultRolloutSpecificationProviderRegistration.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedDefaultRolloutSpecificationProviderRegistration
                        .withProperties(ProviderRegistrationProperties.fromJson(reader));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDefaultRolloutSpecificationProviderRegistration;
        });
    }
}
