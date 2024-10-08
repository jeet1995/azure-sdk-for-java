// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.billing.fluent.models.PaymentMethodLinkInner;
import java.io.IOException;
import java.util.List;

/**
 * The list of payment method links.
 */
@Immutable
public final class PaymentMethodLinksListResult implements JsonSerializable<PaymentMethodLinksListResult> {
    /*
     * The link (url) to the next page of results.
     */
    private String nextLink;

    /*
     * The list of payment method links.
     */
    private List<PaymentMethodLinkInner> value;

    /**
     * Creates an instance of PaymentMethodLinksListResult class.
     */
    public PaymentMethodLinksListResult() {
    }

    /**
     * Get the nextLink property: The link (url) to the next page of results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Get the value property: The list of payment method links.
     * 
     * @return the value value.
     */
    public List<PaymentMethodLinkInner> value() {
        return this.value;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PaymentMethodLinksListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PaymentMethodLinksListResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the PaymentMethodLinksListResult.
     */
    public static PaymentMethodLinksListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PaymentMethodLinksListResult deserializedPaymentMethodLinksListResult = new PaymentMethodLinksListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("nextLink".equals(fieldName)) {
                    deserializedPaymentMethodLinksListResult.nextLink = reader.getString();
                } else if ("value".equals(fieldName)) {
                    List<PaymentMethodLinkInner> value
                        = reader.readArray(reader1 -> PaymentMethodLinkInner.fromJson(reader1));
                    deserializedPaymentMethodLinksListResult.value = value;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPaymentMethodLinksListResult;
        });
    }
}
