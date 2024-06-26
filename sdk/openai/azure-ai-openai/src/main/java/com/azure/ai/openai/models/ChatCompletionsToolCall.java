// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.openai.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * An abstract representation of a tool call that must be resolved in a subsequent request to perform the requested
 * chat completion.
 */
@Immutable
public class ChatCompletionsToolCall implements JsonSerializable<ChatCompletionsToolCall> {

    /*
     * The ID of the tool call.
     */
    @Generated
    private final String id;

    /*
     * The object type.
     */
    @Generated
    private String type = "ChatCompletionsToolCall";

    /**
     * Get the id property: The ID of the tool call.
     *
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Get the type property: The object type.
     *
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("type", this.type);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ChatCompletionsToolCall from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ChatCompletionsToolCall if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ChatCompletionsToolCall.
     */
    public static ChatCompletionsToolCall fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                // Prepare for reading
                readerToUse.nextToken();
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else if ("function".equals(fieldName)) {
                        discriminatorValue = "function";
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("function".equals(discriminatorValue)) {
                    return ChatCompletionsFunctionToolCall.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    @Generated
    static ChatCompletionsToolCall fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String id = null;
            String type = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("id".equals(fieldName)) {
                    id = reader.getString();
                } else if ("type".equals(fieldName)) {
                    type = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            ChatCompletionsToolCall deserializedChatCompletionsToolCall = new ChatCompletionsToolCall(id);
            deserializedChatCompletionsToolCall.type = type;
            return deserializedChatCompletionsToolCall;
        });
    }

    /**
     * Creates an instance of ChatCompletionsToolCall class.
     *
     * @param id the id value to set.
     */
    @Generated
    public ChatCompletionsToolCall(String id) {
        this.id = id;
    }
}
