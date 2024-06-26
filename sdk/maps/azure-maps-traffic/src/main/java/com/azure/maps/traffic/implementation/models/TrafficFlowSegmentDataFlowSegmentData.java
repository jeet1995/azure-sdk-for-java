// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.traffic.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.maps.traffic.models.TrafficFlowSegmentDataPropertiesCoordinates;
import java.io.IOException;

/**
 * Flow Segment Data property.
 */
@Fluent
public final class TrafficFlowSegmentDataFlowSegmentData
    implements JsonSerializable<TrafficFlowSegmentDataFlowSegmentData> {
    /*
     * Functional Road Class. This indicates the road type:
     *   0: Motorway, freeway or other major road.
     *   1: Major road, less important than a motorway.
     *   2: Other major road.
     *   3: Secondary road.
     *   4: Local connecting road.
     *   5: Local road of high importance.
     *   6: Local road.
     */
    private String functionalRoadClass;

    /*
     * The current average speed at the selected point, in the units requested. This is calculated from the currentTravelTime and the length of the selected segment.
     */
    private Integer currentSpeed;

    /*
     * The free flow speed expected under ideal conditions, expressed in the units requested. This is related to the freeFlowTravelTime.
     */
    private Integer freeFlowSpeed;

    /*
     * Current travel time in seconds, across this traffic segment, based on fused real-time measurements between the defined locations in the specified direction.
     */
    private Integer currentTravelTime;

    /*
     * The travel time in seconds, across this traffic segment, which would be expected under ideal free flow conditions.
     */
    private Integer freeFlowTravelTime;

    /*
     * The confidence is a measure of the quality of the provided travel time and speed. A value of 1 means full confidence, that the response contains the highest quality data. Lower values indicate the degree that the response may vary from the actual conditions on the road. Any value greater than 0.6 means the information was based on real-time probe input. A value of 0.5 means the reported speed is based on historical info. A value between 0.5 and 0.6 has a calculated weighted average between historical and live speeds.
     */
    private Float confidence;

    /*
     * Includes the coordinates describing the shape of the segment. Coordinates are shifted from the road depending on the zoom level to support high quality visualization in every scale.
     */
    private TrafficFlowSegmentDataPropertiesCoordinates coordinates;

    /*
     * This indicates the software version that generated the response.
     */
    private String version;

    /*
     * OpenLR code for segment. See [OpenLR](https://en.wikipedia.org/wiki/OpenLR) for more information on the use of Open LR codes.
     */
    private String openLrCode;

    /**
     * Creates an instance of TrafficFlowSegmentDataFlowSegmentData class.
     */
    public TrafficFlowSegmentDataFlowSegmentData() {
    }

    /**
     * Get the functionalRoadClass property: Functional Road Class. This indicates the road type:
     * 0: Motorway, freeway or other major road.
     * 1: Major road, less important than a motorway.
     * 2: Other major road.
     * 3: Secondary road.
     * 4: Local connecting road.
     * 5: Local road of high importance.
     * 6: Local road.
     * 
     * @return the functionalRoadClass value.
     */
    public String getFunctionalRoadClass() {
        return this.functionalRoadClass;
    }

    /**
     * Get the currentSpeed property: The current average speed at the selected point, in the units requested. This is
     * calculated from the currentTravelTime and the length of the selected segment.
     * 
     * @return the currentSpeed value.
     */
    public Integer getCurrentSpeed() {
        return this.currentSpeed;
    }

    /**
     * Get the freeFlowSpeed property: The free flow speed expected under ideal conditions, expressed in the units
     * requested. This is related to the freeFlowTravelTime.
     * 
     * @return the freeFlowSpeed value.
     */
    public Integer getFreeFlowSpeed() {
        return this.freeFlowSpeed;
    }

    /**
     * Get the currentTravelTime property: Current travel time in seconds, across this traffic segment, based on fused
     * real-time measurements between the defined locations in the specified direction.
     * 
     * @return the currentTravelTime value.
     */
    public Integer getCurrentTravelTime() {
        return this.currentTravelTime;
    }

    /**
     * Get the freeFlowTravelTime property: The travel time in seconds, across this traffic segment, which would be
     * expected under ideal free flow conditions.
     * 
     * @return the freeFlowTravelTime value.
     */
    public Integer getFreeFlowTravelTime() {
        return this.freeFlowTravelTime;
    }

    /**
     * Get the confidence property: The confidence is a measure of the quality of the provided travel time and speed. A
     * value of 1 means full confidence, that the response contains the highest quality data. Lower values indicate the
     * degree that the response may vary from the actual conditions on the road. Any value greater than 0.6 means the
     * information was based on real-time probe input. A value of 0.5 means the reported speed is based on historical
     * info. A value between 0.5 and 0.6 has a calculated weighted average between historical and live speeds.
     * 
     * @return the confidence value.
     */
    public Float getConfidence() {
        return this.confidence;
    }

    /**
     * Get the coordinates property: Includes the coordinates describing the shape of the segment. Coordinates are
     * shifted from the road depending on the zoom level to support high quality visualization in every scale.
     * 
     * @return the coordinates value.
     */
    public TrafficFlowSegmentDataPropertiesCoordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Set the coordinates property: Includes the coordinates describing the shape of the segment. Coordinates are
     * shifted from the road depending on the zoom level to support high quality visualization in every scale.
     * 
     * @param coordinates the coordinates value to set.
     * @return the TrafficFlowSegmentDataFlowSegmentData object itself.
     */
    public TrafficFlowSegmentDataFlowSegmentData
        setCoordinates(TrafficFlowSegmentDataPropertiesCoordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    /**
     * Get the version property: This indicates the software version that generated the response.
     * 
     * @return the version value.
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * Get the openLrCode property: OpenLR code for segment. See [OpenLR](https://en.wikipedia.org/wiki/OpenLR) for more
     * information on the use of Open LR codes.
     * 
     * @return the openLrCode value.
     */
    public String getOpenLrCode() {
        return this.openLrCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("coordinates", this.coordinates);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TrafficFlowSegmentDataFlowSegmentData from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TrafficFlowSegmentDataFlowSegmentData if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the TrafficFlowSegmentDataFlowSegmentData.
     */
    public static TrafficFlowSegmentDataFlowSegmentData fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TrafficFlowSegmentDataFlowSegmentData deserializedTrafficFlowSegmentDataFlowSegmentData
                = new TrafficFlowSegmentDataFlowSegmentData();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("frc".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.functionalRoadClass = reader.getString();
                } else if ("currentSpeed".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.currentSpeed
                        = reader.getNullable(JsonReader::getInt);
                } else if ("freeFlowSpeed".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.freeFlowSpeed
                        = reader.getNullable(JsonReader::getInt);
                } else if ("currentTravelTime".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.currentTravelTime
                        = reader.getNullable(JsonReader::getInt);
                } else if ("freeFlowTravelTime".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.freeFlowTravelTime
                        = reader.getNullable(JsonReader::getInt);
                } else if ("confidence".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.confidence
                        = reader.getNullable(JsonReader::getFloat);
                } else if ("coordinates".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.coordinates
                        = TrafficFlowSegmentDataPropertiesCoordinates.fromJson(reader);
                } else if ("@version".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.version = reader.getString();
                } else if ("openlr".equals(fieldName)) {
                    deserializedTrafficFlowSegmentDataFlowSegmentData.openLrCode = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTrafficFlowSegmentDataFlowSegmentData;
        });
    }
}
