// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.health.insights.radiologyinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * A measured or measurable amount
 * Based on [FHIR Quantity](https://www.hl7.org/fhir/R4/datatypes.html#Quantity).
 */
@Fluent
public final class FhirR4Quantity extends FhirR4Element {

    /*
     * Numerical value (with implicit precision)
     */
    @Generated
    private Double value;

    /*
     * < | <= | >= | > - how to understand the value
     */
    @Generated
    private String comparator;

    /*
     * Unit representation
     */
    @Generated
    private String unit;

    /*
     * System that defines coded unit form
     */
    @Generated
    private String system;

    /*
     * Coded form of the unit
     */
    @Generated
    private String code;

    /**
     * Creates an instance of FhirR4Quantity class.
     */
    @Generated
    public FhirR4Quantity() {
    }

    /**
     * Get the value property: Numerical value (with implicit precision).
     *
     * @return the value value.
     */
    @Generated
    public Double getValue() {
        return this.value;
    }

    /**
     * Set the value property: Numerical value (with implicit precision).
     *
     * @param value the value value to set.
     * @return the FhirR4Quantity object itself.
     */
    @Generated
    public FhirR4Quantity setValue(Double value) {
        this.value = value;
        return this;
    }

    /**
     * Get the comparator property: &lt; | &lt;= | &gt;= | &gt; - how to understand the value.
     *
     * @return the comparator value.
     */
    @Generated
    public String getComparator() {
        return this.comparator;
    }

    /**
     * Set the comparator property: &lt; | &lt;= | &gt;= | &gt; - how to understand the value.
     *
     * @param comparator the comparator value to set.
     * @return the FhirR4Quantity object itself.
     */
    @Generated
    public FhirR4Quantity setComparator(String comparator) {
        this.comparator = comparator;
        return this;
    }

    /**
     * Get the unit property: Unit representation.
     *
     * @return the unit value.
     */
    @Generated
    public String getUnit() {
        return this.unit;
    }

    /**
     * Set the unit property: Unit representation.
     *
     * @param unit the unit value to set.
     * @return the FhirR4Quantity object itself.
     */
    @Generated
    public FhirR4Quantity setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get the system property: System that defines coded unit form.
     *
     * @return the system value.
     */
    @Generated
    public String getSystem() {
        return this.system;
    }

    /**
     * Set the system property: System that defines coded unit form.
     *
     * @param system the system value to set.
     * @return the FhirR4Quantity object itself.
     */
    @Generated
    public FhirR4Quantity setSystem(String system) {
        this.system = system;
        return this;
    }

    /**
     * Get the code property: Coded form of the unit.
     *
     * @return the code value.
     */
    @Generated
    public String getCode() {
        return this.code;
    }

    /**
     * Set the code property: Coded form of the unit.
     *
     * @param code the code value to set.
     * @return the FhirR4Quantity object itself.
     */
    @Generated
    public FhirR4Quantity setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public FhirR4Quantity setId(String id) {
        super.setId(id);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public FhirR4Quantity setExtension(List<FhirR4Extension> extension) {
        super.setExtension(extension);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", getId());
        jsonWriter.writeArrayField("extension", getExtension(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeNumberField("value", this.value);
        jsonWriter.writeStringField("comparator", this.comparator);
        jsonWriter.writeStringField("unit", this.unit);
        jsonWriter.writeStringField("system", this.system);
        jsonWriter.writeStringField("code", this.code);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FhirR4Quantity from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FhirR4Quantity if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the FhirR4Quantity.
     */
    @Generated
    public static FhirR4Quantity fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FhirR4Quantity deserializedFhirR4Quantity = new FhirR4Quantity();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("id".equals(fieldName)) {
                    deserializedFhirR4Quantity.setId(reader.getString());
                } else if ("extension".equals(fieldName)) {
                    List<FhirR4Extension> extension = reader.readArray(reader1 -> FhirR4Extension.fromJson(reader1));
                    deserializedFhirR4Quantity.setExtension(extension);
                } else if ("value".equals(fieldName)) {
                    deserializedFhirR4Quantity.value = reader.getNullable(JsonReader::getDouble);
                } else if ("comparator".equals(fieldName)) {
                    deserializedFhirR4Quantity.comparator = reader.getString();
                } else if ("unit".equals(fieldName)) {
                    deserializedFhirR4Quantity.unit = reader.getString();
                } else if ("system".equals(fieldName)) {
                    deserializedFhirR4Quantity.system = reader.getString();
                } else if ("code".equals(fieldName)) {
                    deserializedFhirR4Quantity.code = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedFhirR4Quantity;
        });
    }
}
