// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.analytics.defender.easm.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The breakdown of billable asset counts for each asset type.
 */
@Immutable
public final class ReportBillableAssetBreakdown implements JsonSerializable<ReportBillableAssetBreakdown> {

    /*
     * The kind of billable asset.
     */
    @Generated
    private ReportBillableAssetBreakdownKind kind;

    /*
     * The number of assets of this type.
     */
    @Generated
    private Long count;

    /**
     * Creates an instance of ReportBillableAssetBreakdown class.
     */
    @Generated
    private ReportBillableAssetBreakdown() {
    }

    /**
     * Get the kind property: The kind of billable asset.
     *
     * @return the kind value.
     */
    @Generated
    public ReportBillableAssetBreakdownKind getKind() {
        return this.kind;
    }

    /**
     * Get the count property: The number of assets of this type.
     *
     * @return the count value.
     */
    @Generated
    public Long getCount() {
        return this.count;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        jsonWriter.writeNumberField("count", this.count);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ReportBillableAssetBreakdown from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ReportBillableAssetBreakdown if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ReportBillableAssetBreakdown.
     */
    @Generated
    public static ReportBillableAssetBreakdown fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ReportBillableAssetBreakdown deserializedReportBillableAssetBreakdown = new ReportBillableAssetBreakdown();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("kind".equals(fieldName)) {
                    deserializedReportBillableAssetBreakdown.kind
                        = ReportBillableAssetBreakdownKind.fromString(reader.getString());
                } else if ("count".equals(fieldName)) {
                    deserializedReportBillableAssetBreakdown.count = reader.getNullable(JsonReader::getLong);
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedReportBillableAssetBreakdown;
        });
    }
}
