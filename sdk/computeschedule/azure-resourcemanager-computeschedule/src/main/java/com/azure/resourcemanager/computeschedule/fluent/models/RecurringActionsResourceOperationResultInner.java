// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computeschedule.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.computeschedule.models.ResourceStatus;
import java.io.IOException;
import java.util.List;

/**
 * The response from scheduled action resource requests, which contains the status of each resource.
 */
@Immutable
public final class RecurringActionsResourceOperationResultInner
    implements JsonSerializable<RecurringActionsResourceOperationResultInner> {
    /*
     * The total number of resources operated on
     */
    private int totalResources;

    /*
     * The resource status of for each resource
     */
    private List<ResourceStatus> resourcesStatuses;

    /**
     * Creates an instance of RecurringActionsResourceOperationResultInner class.
     */
    private RecurringActionsResourceOperationResultInner() {
    }

    /**
     * Get the totalResources property: The total number of resources operated on.
     * 
     * @return the totalResources value.
     */
    public int totalResources() {
        return this.totalResources;
    }

    /**
     * Get the resourcesStatuses property: The resource status of for each resource.
     * 
     * @return the resourcesStatuses value.
     */
    public List<ResourceStatus> resourcesStatuses() {
        return this.resourcesStatuses;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (resourcesStatuses() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property resourcesStatuses in model RecurringActionsResourceOperationResultInner"));
        } else {
            resourcesStatuses().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RecurringActionsResourceOperationResultInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("totalResources", this.totalResources);
        jsonWriter.writeArrayField("resourcesStatuses", this.resourcesStatuses,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecurringActionsResourceOperationResultInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecurringActionsResourceOperationResultInner if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RecurringActionsResourceOperationResultInner.
     */
    public static RecurringActionsResourceOperationResultInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RecurringActionsResourceOperationResultInner deserializedRecurringActionsResourceOperationResultInner
                = new RecurringActionsResourceOperationResultInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("totalResources".equals(fieldName)) {
                    deserializedRecurringActionsResourceOperationResultInner.totalResources = reader.getInt();
                } else if ("resourcesStatuses".equals(fieldName)) {
                    List<ResourceStatus> resourcesStatuses
                        = reader.readArray(reader1 -> ResourceStatus.fromJson(reader1));
                    deserializedRecurringActionsResourceOperationResultInner.resourcesStatuses = resourcesStatuses;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecurringActionsResourceOperationResultInner;
        });
    }
}
