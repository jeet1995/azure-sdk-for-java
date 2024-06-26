// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

/** Samples for BillingRoleAssignments DeleteByBillingProfile. */
public final class BillingRoleAssignmentsDeleteByBillingProfileSamples {
    /*
     * x-ms-original-file: specification/billing/resource-manager/Microsoft.Billing/stable/2020-05-01/examples/BillingProfileRoleAssignmentDelete.json
     */
    /**
     * Sample code: BillingProfileRoleAssignmentDelete.
     *
     * @param manager Entry point to BillingManager.
     */
    public static void billingProfileRoleAssignmentDelete(com.azure.resourcemanager.billing.BillingManager manager) {
        manager
            .billingRoleAssignments()
            .deleteByBillingProfileWithResponse(
                "{billingAccountName}",
                "{billingProfileName}",
                "{billingRoleAssignmentName}",
                com.azure.core.util.Context.NONE);
    }
}
