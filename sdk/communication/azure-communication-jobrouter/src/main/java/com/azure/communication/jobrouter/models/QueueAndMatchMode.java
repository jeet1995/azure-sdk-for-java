// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.communication.jobrouter.models;

import com.azure.communication.jobrouter.implementation.JsonMergePatchHelper;
import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Describes a matching mode where matching worker to a job is automatically started after job is queued successfully.
 */
@Immutable
public final class QueueAndMatchMode extends JobMatchingMode {

    /*
     * The type discriminator describing a sub-type of JobMatchingMode.
     */
    @Generated
    private JobMatchingModeKind kind = JobMatchingModeKind.QUEUE_AND_MATCH;

    /**
     * Stores updated model property, the value is property name, not serialized name.
     */
    @Generated
    private final Set<String> updatedProperties = new HashSet<>();

    /**
     * Creates an instance of QueueAndMatchMode class.
     */
    @Generated
    public QueueAndMatchMode() {
    }

    /**
     * Get the kind property: The type discriminator describing a sub-type of JobMatchingMode.
     *
     * @return the kind value.
     */
    @Generated
    @Override
    public JobMatchingModeKind getKind() {
        return this.kind;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        if (JsonMergePatchHelper.getJobMatchingModeAccessor().isJsonMergePatch(this)) {
            return toJsonMergePatch(jsonWriter);
        } else {
            jsonWriter.writeStartObject();
            jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
            return jsonWriter.writeEndObject();
        }
    }

    @Generated
    private JsonWriter toJsonMergePatch(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("kind", this.kind.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of QueueAndMatchMode from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of QueueAndMatchMode if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the QueueAndMatchMode.
     */
    @Generated
    public static QueueAndMatchMode fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            QueueAndMatchMode deserializedQueueAndMatchMode = new QueueAndMatchMode();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("kind".equals(fieldName)) {
                    deserializedQueueAndMatchMode.kind = JobMatchingModeKind.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedQueueAndMatchMode;
        });
    }
}
