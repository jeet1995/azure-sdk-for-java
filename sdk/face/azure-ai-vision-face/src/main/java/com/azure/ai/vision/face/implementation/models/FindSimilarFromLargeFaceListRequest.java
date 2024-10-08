// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.vision.face.implementation.models;

import com.azure.ai.vision.face.models.FindSimilarMatchMode;
import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The FindSimilarFromLargeFaceListRequest model.
 */
@Fluent
public final class FindSimilarFromLargeFaceListRequest
    implements JsonSerializable<FindSimilarFromLargeFaceListRequest> {

    /*
     * faceId of the query face. User needs to call "Detect" first to get a valid faceId. Note that this faceId is not
     * persisted and will expire 24 hours after the detection call.
     */
    @Generated
    private final String faceId;

    /*
     * The number of top similar faces returned. The valid range is [1, 1000]. Default value is 20.
     */
    @Generated
    private Integer maxNumOfCandidatesReturned;

    /*
     * Similar face searching mode. It can be 'matchPerson' or 'matchFace'. Default value is 'matchPerson'.
     */
    @Generated
    private FindSimilarMatchMode mode;

    /*
     * An existing user-specified unique candidate Large Face List, created in "Create Large Face List". Large Face List
     * contains a set of persistedFaceIds which are persisted and will never expire.
     */
    @Generated
    private final String largeFaceListId;

    /**
     * Creates an instance of FindSimilarFromLargeFaceListRequest class.
     *
     * @param faceId the faceId value to set.
     * @param largeFaceListId the largeFaceListId value to set.
     */
    @Generated
    public FindSimilarFromLargeFaceListRequest(String faceId, String largeFaceListId) {
        this.faceId = faceId;
        this.largeFaceListId = largeFaceListId;
    }

    /**
     * Get the faceId property: faceId of the query face. User needs to call "Detect" first to get a valid faceId. Note
     * that this faceId is not persisted and will expire 24 hours after the detection call.
     *
     * @return the faceId value.
     */
    @Generated
    public String getFaceId() {
        return this.faceId;
    }

    /**
     * Get the maxNumOfCandidatesReturned property: The number of top similar faces returned. The valid range is [1,
     * 1000]. Default value is 20.
     *
     * @return the maxNumOfCandidatesReturned value.
     */
    @Generated
    public Integer getMaxNumOfCandidatesReturned() {
        return this.maxNumOfCandidatesReturned;
    }

    /**
     * Set the maxNumOfCandidatesReturned property: The number of top similar faces returned. The valid range is [1,
     * 1000]. Default value is 20.
     *
     * @param maxNumOfCandidatesReturned the maxNumOfCandidatesReturned value to set.
     * @return the FindSimilarFromLargeFaceListRequest object itself.
     */
    @Generated
    public FindSimilarFromLargeFaceListRequest setMaxNumOfCandidatesReturned(Integer maxNumOfCandidatesReturned) {
        this.maxNumOfCandidatesReturned = maxNumOfCandidatesReturned;
        return this;
    }

    /**
     * Get the mode property: Similar face searching mode. It can be 'matchPerson' or 'matchFace'. Default value is
     * 'matchPerson'.
     *
     * @return the mode value.
     */
    @Generated
    public FindSimilarMatchMode getMode() {
        return this.mode;
    }

    /**
     * Set the mode property: Similar face searching mode. It can be 'matchPerson' or 'matchFace'. Default value is
     * 'matchPerson'.
     *
     * @param mode the mode value to set.
     * @return the FindSimilarFromLargeFaceListRequest object itself.
     */
    @Generated
    public FindSimilarFromLargeFaceListRequest setMode(FindSimilarMatchMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Get the largeFaceListId property: An existing user-specified unique candidate Large Face List, created in "Create
     * Large Face List". Large Face List contains a set of persistedFaceIds which are persisted and will never expire.
     *
     * @return the largeFaceListId value.
     */
    @Generated
    public String getLargeFaceListId() {
        return this.largeFaceListId;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("faceId", this.faceId);
        jsonWriter.writeStringField("largeFaceListId", this.largeFaceListId);
        jsonWriter.writeNumberField("maxNumOfCandidatesReturned", this.maxNumOfCandidatesReturned);
        jsonWriter.writeStringField("mode", this.mode == null ? null : this.mode.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FindSimilarFromLargeFaceListRequest from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FindSimilarFromLargeFaceListRequest if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FindSimilarFromLargeFaceListRequest.
     */
    @Generated
    public static FindSimilarFromLargeFaceListRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String faceId = null;
            String largeFaceListId = null;
            Integer maxNumOfCandidatesReturned = null;
            FindSimilarMatchMode mode = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("faceId".equals(fieldName)) {
                    faceId = reader.getString();
                } else if ("largeFaceListId".equals(fieldName)) {
                    largeFaceListId = reader.getString();
                } else if ("maxNumOfCandidatesReturned".equals(fieldName)) {
                    maxNumOfCandidatesReturned = reader.getNullable(JsonReader::getInt);
                } else if ("mode".equals(fieldName)) {
                    mode = FindSimilarMatchMode.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }
            FindSimilarFromLargeFaceListRequest deserializedFindSimilarFromLargeFaceListRequest
                = new FindSimilarFromLargeFaceListRequest(faceId, largeFaceListId);
            deserializedFindSimilarFromLargeFaceListRequest.maxNumOfCandidatesReturned = maxNumOfCandidatesReturned;
            deserializedFindSimilarFromLargeFaceListRequest.mode = mode;
            return deserializedFindSimilarFromLargeFaceListRequest;
        });
    }
}
