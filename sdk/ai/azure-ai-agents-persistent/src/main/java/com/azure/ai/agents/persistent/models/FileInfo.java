// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.agents.persistent.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Represents an agent that can call the model and use tools.
 */
@Immutable
public final class FileInfo implements JsonSerializable<FileInfo> {

    /*
     * The object type, which is always 'file'.
     */
    @Generated
    private final String object = "file";

    /*
     * The identifier, which can be referenced in API endpoints.
     */
    @Generated
    private final String id;

    /*
     * The size of the file, in bytes.
     */
    @Generated
    private final int bytes;

    /*
     * The name of the file.
     */
    @Generated
    private final String filename;

    /*
     * The Unix timestamp, in seconds, representing when this object was created.
     */
    @Generated
    private final long createdAt;

    /*
     * The intended purpose of a file.
     */
    @Generated
    private final FilePurpose purpose;

    /*
     * The state of the file. This field is available in Azure OpenAI only.
     */
    @Generated
    private FileState status;

    /*
     * The error message with details in case processing of this file failed. This field is available in Azure OpenAI
     * only.
     */
    @Generated
    private String statusDetails;

    /**
     * Creates an instance of FileInfo class.
     *
     * @param id the id value to set.
     * @param bytes the bytes value to set.
     * @param filename the filename value to set.
     * @param createdAt the createdAt value to set.
     * @param purpose the purpose value to set.
     */
    @Generated
    private FileInfo(String id, int bytes, String filename, OffsetDateTime createdAt, FilePurpose purpose) {
        this.id = id;
        this.bytes = bytes;
        this.filename = filename;
        if (createdAt == null) {
            this.createdAt = 0L;
        } else {
            this.createdAt = createdAt.toEpochSecond();
        }
        this.purpose = purpose;
    }

    /**
     * Get the object property: The object type, which is always 'file'.
     *
     * @return the object value.
     */
    @Generated
    public String getObject() {
        return this.object;
    }

    /**
     * Get the id property: The identifier, which can be referenced in API endpoints.
     *
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Get the bytes property: The size of the file, in bytes.
     *
     * @return the bytes value.
     */
    @Generated
    public int getBytes() {
        return this.bytes;
    }

    /**
     * Get the filename property: The name of the file.
     *
     * @return the filename value.
     */
    @Generated
    public String getFilename() {
        return this.filename;
    }

    /**
     * Get the createdAt property: The Unix timestamp, in seconds, representing when this object was created.
     *
     * @return the createdAt value.
     */
    @Generated
    public OffsetDateTime getCreatedAt() {
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(this.createdAt), ZoneOffset.UTC);
    }

    /**
     * Get the purpose property: The intended purpose of a file.
     *
     * @return the purpose value.
     */
    @Generated
    public FilePurpose getPurpose() {
        return this.purpose;
    }

    /**
     * Get the status property: The state of the file. This field is available in Azure OpenAI only.
     *
     * @return the status value.
     */
    @Generated
    public FileState getStatus() {
        return this.status;
    }

    /**
     * Get the statusDetails property: The error message with details in case processing of this file failed. This field
     * is available in Azure OpenAI only.
     *
     * @return the statusDetails value.
     */
    @Generated
    public String getStatusDetails() {
        return this.statusDetails;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("object", this.object);
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeIntField("bytes", this.bytes);
        jsonWriter.writeStringField("filename", this.filename);
        jsonWriter.writeLongField("created_at", this.createdAt);
        jsonWriter.writeStringField("purpose", this.purpose == null ? null : this.purpose.toString());
        jsonWriter.writeStringField("status", this.status == null ? null : this.status.toString());
        jsonWriter.writeStringField("status_details", this.statusDetails);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FileInfo from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FileInfo if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FileInfo.
     */
    @Generated
    public static FileInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String id = null;
            int bytes = 0;
            String filename = null;
            OffsetDateTime createdAt = null;
            FilePurpose purpose = null;
            FileState status = null;
            String statusDetails = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("id".equals(fieldName)) {
                    id = reader.getString();
                } else if ("bytes".equals(fieldName)) {
                    bytes = reader.getInt();
                } else if ("filename".equals(fieldName)) {
                    filename = reader.getString();
                } else if ("created_at".equals(fieldName)) {
                    createdAt = OffsetDateTime.ofInstant(Instant.ofEpochSecond(reader.getLong()), ZoneOffset.UTC);
                } else if ("purpose".equals(fieldName)) {
                    purpose = FilePurpose.fromString(reader.getString());
                } else if ("status".equals(fieldName)) {
                    status = FileState.fromString(reader.getString());
                } else if ("status_details".equals(fieldName)) {
                    statusDetails = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            FileInfo deserializedFileInfo = new FileInfo(id, bytes, filename, createdAt, purpose);
            deserializedFileInfo.status = status;
            deserializedFileInfo.statusDetails = statusDetails;
            return deserializedFileInfo;
        });
    }
}
