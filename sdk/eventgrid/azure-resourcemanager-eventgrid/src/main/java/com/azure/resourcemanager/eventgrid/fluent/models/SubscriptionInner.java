// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.eventgrid.models.DeliveryConfiguration;
import com.azure.resourcemanager.eventgrid.models.DeliverySchema;
import com.azure.resourcemanager.eventgrid.models.FiltersConfiguration;
import com.azure.resourcemanager.eventgrid.models.SubscriptionProvisioningState;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * Event Subscription.
 */
@Fluent
public final class SubscriptionInner extends ProxyResource {
    /*
     * Properties of the event subscription.
     */
    private SubscriptionProperties innerProperties;

    /*
     * The system metadata relating to the Event Grid resource.
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
     * Creates an instance of SubscriptionInner class.
     */
    public SubscriptionInner() {
    }

    /**
     * Get the innerProperties property: Properties of the event subscription.
     * 
     * @return the innerProperties value.
     */
    private SubscriptionProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: The system metadata relating to the Event Grid resource.
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
     * Get the provisioningState property: Provisioning state of the event subscription.
     * 
     * @return the provisioningState value.
     */
    public SubscriptionProvisioningState provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the deliveryConfiguration property: Information about the delivery configuration of the event subscription.
     * 
     * @return the deliveryConfiguration value.
     */
    public DeliveryConfiguration deliveryConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().deliveryConfiguration();
    }

    /**
     * Set the deliveryConfiguration property: Information about the delivery configuration of the event subscription.
     * 
     * @param deliveryConfiguration the deliveryConfiguration value to set.
     * @return the SubscriptionInner object itself.
     */
    public SubscriptionInner withDeliveryConfiguration(DeliveryConfiguration deliveryConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SubscriptionProperties();
        }
        this.innerProperties().withDeliveryConfiguration(deliveryConfiguration);
        return this;
    }

    /**
     * Get the eventDeliverySchema property: The event delivery schema for the event subscription.
     * 
     * @return the eventDeliverySchema value.
     */
    public DeliverySchema eventDeliverySchema() {
        return this.innerProperties() == null ? null : this.innerProperties().eventDeliverySchema();
    }

    /**
     * Set the eventDeliverySchema property: The event delivery schema for the event subscription.
     * 
     * @param eventDeliverySchema the eventDeliverySchema value to set.
     * @return the SubscriptionInner object itself.
     */
    public SubscriptionInner withEventDeliverySchema(DeliverySchema eventDeliverySchema) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SubscriptionProperties();
        }
        this.innerProperties().withEventDeliverySchema(eventDeliverySchema);
        return this;
    }

    /**
     * Get the filtersConfiguration property: Information about the filter for the event subscription.
     * 
     * @return the filtersConfiguration value.
     */
    public FiltersConfiguration filtersConfiguration() {
        return this.innerProperties() == null ? null : this.innerProperties().filtersConfiguration();
    }

    /**
     * Set the filtersConfiguration property: Information about the filter for the event subscription.
     * 
     * @param filtersConfiguration the filtersConfiguration value to set.
     * @return the SubscriptionInner object itself.
     */
    public SubscriptionInner withFiltersConfiguration(FiltersConfiguration filtersConfiguration) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SubscriptionProperties();
        }
        this.innerProperties().withFiltersConfiguration(filtersConfiguration);
        return this;
    }

    /**
     * Get the expirationTimeUtc property: Expiration time of the event subscription.
     * 
     * @return the expirationTimeUtc value.
     */
    public OffsetDateTime expirationTimeUtc() {
        return this.innerProperties() == null ? null : this.innerProperties().expirationTimeUtc();
    }

    /**
     * Set the expirationTimeUtc property: Expiration time of the event subscription.
     * 
     * @param expirationTimeUtc the expirationTimeUtc value to set.
     * @return the SubscriptionInner object itself.
     */
    public SubscriptionInner withExpirationTimeUtc(OffsetDateTime expirationTimeUtc) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SubscriptionProperties();
        }
        this.innerProperties().withExpirationTimeUtc(expirationTimeUtc);
        return this;
    }

    /**
     * Get the tags property: Tags relating to Event Subscription resource.
     * 
     * @return the tags value.
     */
    public Map<String, String> tags() {
        return this.innerProperties() == null ? null : this.innerProperties().tags();
    }

    /**
     * Set the tags property: Tags relating to Event Subscription resource.
     * 
     * @param tags the tags value to set.
     * @return the SubscriptionInner object itself.
     */
    public SubscriptionInner withTags(Map<String, String> tags) {
        if (this.innerProperties() == null) {
            this.innerProperties = new SubscriptionProperties();
        }
        this.innerProperties().withTags(tags);
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
     * Reads an instance of SubscriptionInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SubscriptionInner if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SubscriptionInner.
     */
    public static SubscriptionInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SubscriptionInner deserializedSubscriptionInner = new SubscriptionInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedSubscriptionInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedSubscriptionInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedSubscriptionInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedSubscriptionInner.innerProperties = SubscriptionProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedSubscriptionInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSubscriptionInner;
        });
    }
}
