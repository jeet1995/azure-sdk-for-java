// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Schema of the Data property of an EventGridEvent for a Microsoft.ApiManagement.UserDeleted event.
 * 
 * @deprecated This class is deprecated and may be removed in future releases. System events are now available in the
 * azure-messaging-eventgrid-systemevents package.
 */
@Fluent
@Deprecated
public final class ApiManagementUserDeletedEventData implements JsonSerializable<ApiManagementUserDeletedEventData> {

    /*
     * The fully qualified ID of the resource that the compliance state change is for, including the resource name and
     * resource type. Uses the format,
     * `/subscriptions/<SubscriptionID>/resourceGroups/<ResourceGroup>/Microsoft.ApiManagement/service/<ServiceName>/<
     * ResourceType>/<ResourceName>`
     */
    @Generated
    private String resourceUri;

    /**
     * Creates an instance of ApiManagementUserDeletedEventData class.
     */
    @Generated
    public ApiManagementUserDeletedEventData() {
    }

    /**
     * Get the resourceUri property: The fully qualified ID of the resource that the compliance state change is for,
     * including the resource name and resource type. Uses the format,
     * `/subscriptions/&lt;SubscriptionID&gt;/resourceGroups/&lt;ResourceGroup&gt;/Microsoft.ApiManagement/service/&lt;ServiceName&gt;/&lt;ResourceType&gt;/&lt;ResourceName&gt;`.
     *
     * @return the resourceUri value.
     */
    @Generated
    public String getResourceUri() {
        return this.resourceUri;
    }

    /**
     * Set the resourceUri property: The fully qualified ID of the resource that the compliance state change is for,
     * including the resource name and resource type. Uses the format,
     * `/subscriptions/&lt;SubscriptionID&gt;/resourceGroups/&lt;ResourceGroup&gt;/Microsoft.ApiManagement/service/&lt;ServiceName&gt;/&lt;ResourceType&gt;/&lt;ResourceName&gt;`.
     *
     * @param resourceUri the resourceUri value to set.
     * @return the ApiManagementUserDeletedEventData object itself.
     */
    @Generated
    public ApiManagementUserDeletedEventData setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resourceUri", this.resourceUri);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApiManagementUserDeletedEventData from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApiManagementUserDeletedEventData if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ApiManagementUserDeletedEventData.
     */
    @Generated
    public static ApiManagementUserDeletedEventData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ApiManagementUserDeletedEventData deserializedApiManagementUserDeletedEventData
                = new ApiManagementUserDeletedEventData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("resourceUri".equals(fieldName)) {
                    deserializedApiManagementUserDeletedEventData.resourceUri = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedApiManagementUserDeletedEventData;
        });
    }
}
