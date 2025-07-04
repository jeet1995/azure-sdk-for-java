// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Schema of the Data property of an EventGridEvent for a Microsoft.Maps.GeofenceEntered event.
 * 
 * @deprecated This class is deprecated and may be removed in future releases. System events are now available in the
 * azure-messaging-eventgrid-systemevents package.
 */
@Fluent
@Deprecated
public final class MapsGeofenceEnteredEventData extends MapsGeofenceEventProperties {

    /**
     * Creates an instance of MapsGeofenceEnteredEventData class.
     */
    @Generated
    public MapsGeofenceEnteredEventData() {
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MapsGeofenceEnteredEventData setExpiredGeofenceGeometryId(List<String> expiredGeofenceGeometryId) {
        super.setExpiredGeofenceGeometryId(expiredGeofenceGeometryId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MapsGeofenceEnteredEventData setGeometries(List<MapsGeofenceGeometry> geometries) {
        super.setGeometries(geometries);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MapsGeofenceEnteredEventData
        setInvalidPeriodGeofenceGeometryId(List<String> invalidPeriodGeofenceGeometryId) {
        super.setInvalidPeriodGeofenceGeometryId(invalidPeriodGeofenceGeometryId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public MapsGeofenceEnteredEventData setIsEventPublished(Boolean isEventPublished) {
        super.setIsEventPublished(isEventPublished);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("expiredGeofenceGeometryId", getExpiredGeofenceGeometryId(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("geometries", getGeometries(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("invalidPeriodGeofenceGeometryId", getInvalidPeriodGeofenceGeometryId(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeBooleanField("isEventPublished", isEventPublished());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MapsGeofenceEnteredEventData from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MapsGeofenceEnteredEventData if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MapsGeofenceEnteredEventData.
     */
    @Generated
    public static MapsGeofenceEnteredEventData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MapsGeofenceEnteredEventData deserializedMapsGeofenceEnteredEventData = new MapsGeofenceEnteredEventData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("expiredGeofenceGeometryId".equals(fieldName)) {
                    List<String> expiredGeofenceGeometryId = reader.readArray(reader1 -> reader1.getString());
                    deserializedMapsGeofenceEnteredEventData.setExpiredGeofenceGeometryId(expiredGeofenceGeometryId);
                } else if ("geometries".equals(fieldName)) {
                    List<MapsGeofenceGeometry> geometries
                        = reader.readArray(reader1 -> MapsGeofenceGeometry.fromJson(reader1));
                    deserializedMapsGeofenceEnteredEventData.setGeometries(geometries);
                } else if ("invalidPeriodGeofenceGeometryId".equals(fieldName)) {
                    List<String> invalidPeriodGeofenceGeometryId = reader.readArray(reader1 -> reader1.getString());
                    deserializedMapsGeofenceEnteredEventData
                        .setInvalidPeriodGeofenceGeometryId(invalidPeriodGeofenceGeometryId);
                } else if ("isEventPublished".equals(fieldName)) {
                    deserializedMapsGeofenceEnteredEventData
                        .setIsEventPublished(reader.getNullable(JsonReader::getBoolean));
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedMapsGeofenceEnteredEventData;
        });
    }
}
