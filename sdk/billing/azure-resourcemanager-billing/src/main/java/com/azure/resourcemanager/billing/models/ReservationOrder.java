// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.models;

import com.azure.core.management.SystemData;
import com.azure.resourcemanager.billing.fluent.models.ReservationOrderInner;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of ReservationOrder.
 */
public interface ReservationOrder {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the etag property: The etag property.
     * 
     * @return the etag value.
     */
    Integer etag();

    /**
     * Gets the tags property: Tags for this reservation.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the displayName property: Friendly name for user to easily identified the reservation order.
     * 
     * @return the displayName value.
     */
    String displayName();

    /**
     * Gets the enrollmentId property: Enrollment id of the reservation order.
     * 
     * @return the enrollmentId value.
     */
    String enrollmentId();

    /**
     * Gets the customerId property: Fully-qualified identifier of the customerId where the benefit is applied. Present
     * only for Enterprise Agreement PartnerLed customers.
     * 
     * @return the customerId value.
     */
    String customerId();

    /**
     * Gets the billingProfileId property: Billing profile Id associated to this reservation order.
     * 
     * @return the billingProfileId value.
     */
    String billingProfileId();

    /**
     * Gets the billingAccountId property: Billing account Id associated to this reservation order.
     * 
     * @return the billingAccountId value.
     */
    String billingAccountId();

    /**
     * Gets the requestDateTime property: This is the DateTime when the reservation order was initially requested for
     * purchase.
     * 
     * @return the requestDateTime value.
     */
    OffsetDateTime requestDateTime();

    /**
     * Gets the createdDateTime property: This is the DateTime when the reservation order was created.
     * 
     * @return the createdDateTime value.
     */
    OffsetDateTime createdDateTime();

    /**
     * Gets the expiryDate property: This is the date when the reservation order will expire.
     * 
     * @return the expiryDate value.
     */
    LocalDate expiryDate();

    /**
     * Gets the expiryDateTime property: This is the date-time when the reservation order will expire.
     * 
     * @return the expiryDateTime value.
     */
    OffsetDateTime expiryDateTime();

    /**
     * Gets the benefitStartTime property: This is the DateTime when the reservation benefit started.
     * 
     * @return the benefitStartTime value.
     */
    OffsetDateTime benefitStartTime();

    /**
     * Gets the originalQuantity property: Total original quantity of the skus purchased in the reservation order.
     * 
     * @return the originalQuantity value.
     */
    Integer originalQuantity();

    /**
     * Gets the term property: The term of the reservation, e.g. P1Y.
     * 
     * @return the term value.
     */
    String term();

    /**
     * Gets the provisioningState property: The provisioning state of the reservation, e.g. Succeeded.
     * 
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * Gets the billingPlan property: Represent the billing plans.
     * 
     * @return the billingPlan value.
     */
    ReservationBillingPlan billingPlan();

    /**
     * Gets the planInformation property: Information describing the type of billing plan for this reservation order.
     * 
     * @return the planInformation value.
     */
    ReservationOrderBillingPlanInformation planInformation();

    /**
     * Gets the reservations property: The reservations property.
     * 
     * @return the reservations value.
     */
    List<Reservation> reservations();

    /**
     * Gets the reviewDateTime property: This is the date-time when the Azure Hybrid Benefit needs to be reviewed.
     * 
     * @return the reviewDateTime value.
     */
    OffsetDateTime reviewDateTime();

    /**
     * Gets the extendedStatusInfo property: Extended status information for the reservation.
     * 
     * @return the extendedStatusInfo value.
     */
    ReservationExtendedStatusInfo extendedStatusInfo();

    /**
     * Gets the productCode property: Represents UPN.
     * 
     * @return the productCode value.
     */
    String productCode();

    /**
     * Gets the inner com.azure.resourcemanager.billing.fluent.models.ReservationOrderInner object.
     * 
     * @return the inner object.
     */
    ReservationOrderInner innerModel();
}
