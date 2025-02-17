// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.Resource;
import com.azure.core.management.SystemData;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.edgeorder.models.AddressValidationStatus;
import com.azure.resourcemanager.edgeorder.models.ContactDetails;
import com.azure.resourcemanager.edgeorder.models.ShippingAddress;
import java.io.IOException;
import java.util.Map;

/**
 * Address Resource.
 */
@Fluent
public final class AddressResourceInner extends Resource {
    /*
     * Properties of an address.
     */
    private AddressProperties innerProperties = new AddressProperties();

    /*
     * Represents resource creation and update time
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
     * Creates an instance of AddressResourceInner class.
     */
    public AddressResourceInner() {
    }

    /**
     * Get the innerProperties property: Properties of an address.
     * 
     * @return the innerProperties value.
     */
    private AddressProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Represents resource creation and update time.
     * 
     * @return the systemData value.
     */
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
    public AddressResourceInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AddressResourceInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * Get the shippingAddress property: Shipping details for the address.
     * 
     * @return the shippingAddress value.
     */
    public ShippingAddress shippingAddress() {
        return this.innerProperties() == null ? null : this.innerProperties().shippingAddress();
    }

    /**
     * Set the shippingAddress property: Shipping details for the address.
     * 
     * @param shippingAddress the shippingAddress value to set.
     * @return the AddressResourceInner object itself.
     */
    public AddressResourceInner withShippingAddress(ShippingAddress shippingAddress) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AddressProperties();
        }
        this.innerProperties().withShippingAddress(shippingAddress);
        return this;
    }

    /**
     * Get the contactDetails property: Contact details for the address.
     * 
     * @return the contactDetails value.
     */
    public ContactDetails contactDetails() {
        return this.innerProperties() == null ? null : this.innerProperties().contactDetails();
    }

    /**
     * Set the contactDetails property: Contact details for the address.
     * 
     * @param contactDetails the contactDetails value to set.
     * @return the AddressResourceInner object itself.
     */
    public AddressResourceInner withContactDetails(ContactDetails contactDetails) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AddressProperties();
        }
        this.innerProperties().withContactDetails(contactDetails);
        return this;
    }

    /**
     * Get the addressValidationStatus property: Status of address validation.
     * 
     * @return the addressValidationStatus value.
     */
    public AddressValidationStatus addressValidationStatus() {
        return this.innerProperties() == null ? null : this.innerProperties().addressValidationStatus();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerProperties in model AddressResourceInner"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(AddressResourceInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AddressResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AddressResourceInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AddressResourceInner.
     */
    public static AddressResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AddressResourceInner deserializedAddressResourceInner = new AddressResourceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedAddressResourceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedAddressResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedAddressResourceInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedAddressResourceInner.withLocation(reader.getString());
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedAddressResourceInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedAddressResourceInner.innerProperties = AddressProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedAddressResourceInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAddressResourceInner;
        });
    }
}
