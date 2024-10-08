// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.billing.models.AppliedScopeType;
import com.azure.resourcemanager.billing.models.InstanceFlexibility;
import com.azure.resourcemanager.billing.models.PatchModel;
import com.azure.resourcemanager.billing.models.ReservationAppliedScopeProperties;
import com.azure.resourcemanager.billing.models.ReservationBillingPlan;
import com.azure.resourcemanager.billing.models.ReservationPurchaseRequest;
import com.azure.resourcemanager.billing.models.ReservationSkuProperty;
import com.azure.resourcemanager.billing.models.SkuName;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class PatchModelTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PatchModel model = BinaryData.fromString(
            "{\"properties\":{\"appliedScopeType\":\"ManagementGroup\",\"appliedScopeProperties\":{\"tenantId\":\"tesubzpvp\",\"managementGroupId\":\"ylytcovqseusr\",\"subscriptionId\":\"bdxzfxnxmlbmu\",\"resourceGroupId\":\"wkjmdihd\",\"displayName\":\"yyzlwhbwzjnu\"},\"instanceFlexibility\":\"Off\",\"displayName\":\"gmdq\",\"renew\":false,\"renewProperties\":{\"purchaseProperties\":{\"sku\":{\"name\":\"ftedzuubjtvgjsx\"},\"location\":\"yj\",\"properties\":{\"reservedResourceType\":\"vdpwwobtdphti\",\"billingScopeId\":\"ffofwan\",\"term\":\"k\",\"billingPlan\":\"Monthly\",\"quantity\":187296293,\"displayName\":\"zcgwdfriw\",\"appliedScopeType\":\"Single\",\"appliedScopes\":[\"ozokscvglli\"],\"appliedScopeProperties\":{\"tenantId\":\"byfg\",\"managementGroupId\":\"wqkjvx\",\"subscriptionId\":\"wpxsoo\",\"resourceGroupId\":\"txlcsk\",\"displayName\":\"e\"},\"renew\":true,\"reservedResourceProperties\":{\"instanceFlexibility\":\"On\"},\"instanceFlexibility\":\"On\",\"reviewDateTime\":\"2021-09-19T08:34:05Z\"}}},\"reviewDateTime\":\"2021-10-03T18:15:14Z\"},\"sku\":{\"name\":\"gubsrtmdylpe\"},\"tags\":{\"cmfpfbodet\":\"lttjzgcz\",\"muqkevzgjypanhx\":\"esrgvtshuvftwai\",\"wot\":\"pdxxzetwwz\",\"fhglhrfo\":\"xl\"}}")
            .toObject(PatchModel.class);
        Assertions.assertEquals("lttjzgcz", model.tags().get("cmfpfbodet"));
        Assertions.assertEquals(AppliedScopeType.MANAGEMENT_GROUP, model.appliedScopeType());
        Assertions.assertEquals("tesubzpvp", model.appliedScopeProperties().tenantId());
        Assertions.assertEquals("ylytcovqseusr", model.appliedScopeProperties().managementGroupId());
        Assertions.assertEquals("bdxzfxnxmlbmu", model.appliedScopeProperties().subscriptionId());
        Assertions.assertEquals("wkjmdihd", model.appliedScopeProperties().resourceGroupId());
        Assertions.assertEquals("yyzlwhbwzjnu", model.appliedScopeProperties().displayName());
        Assertions.assertEquals(InstanceFlexibility.OFF, model.instanceFlexibility());
        Assertions.assertEquals("gmdq", model.displayName());
        Assertions.assertEquals(false, model.renew());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-03T18:15:14Z"), model.reviewDateTime());
        Assertions.assertEquals("ftedzuubjtvgjsx", model.purchaseProperties().sku().name());
        Assertions.assertEquals("yj", model.purchaseProperties().location());
        Assertions.assertEquals(ReservationBillingPlan.MONTHLY, model.purchaseProperties().billingPlan());
        Assertions.assertEquals(187296293, model.purchaseProperties().quantity());
        Assertions.assertEquals("zcgwdfriw", model.purchaseProperties().displayName());
        Assertions.assertEquals(AppliedScopeType.SINGLE, model.purchaseProperties().appliedScopeType());
        Assertions.assertEquals("ozokscvglli", model.purchaseProperties().appliedScopes().get(0));
        Assertions.assertEquals("byfg", model.purchaseProperties().appliedScopeProperties().tenantId());
        Assertions.assertEquals("wqkjvx", model.purchaseProperties().appliedScopeProperties().managementGroupId());
        Assertions.assertEquals("wpxsoo", model.purchaseProperties().appliedScopeProperties().subscriptionId());
        Assertions.assertEquals("txlcsk", model.purchaseProperties().appliedScopeProperties().resourceGroupId());
        Assertions.assertEquals("e", model.purchaseProperties().appliedScopeProperties().displayName());
        Assertions.assertEquals(true, model.purchaseProperties().renew());
        Assertions.assertEquals(InstanceFlexibility.ON, model.purchaseProperties().instanceFlexibility());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-19T08:34:05Z"),
            model.purchaseProperties().reviewDateTime());
        Assertions.assertEquals(InstanceFlexibility.ON,
            model.purchaseProperties().instanceFlexibilityReservedResourcePropertiesInstanceFlexibility());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PatchModel model = new PatchModel().withSku(new ReservationSkuProperty())
            .withTags(mapOf("cmfpfbodet", "lttjzgcz", "muqkevzgjypanhx", "esrgvtshuvftwai", "wot", "pdxxzetwwz",
                "fhglhrfo", "xl"))
            .withAppliedScopeType(AppliedScopeType.MANAGEMENT_GROUP)
            .withAppliedScopeProperties(new ReservationAppliedScopeProperties().withTenantId("tesubzpvp")
                .withManagementGroupId("ylytcovqseusr")
                .withSubscriptionId("bdxzfxnxmlbmu")
                .withResourceGroupId("wkjmdihd")
                .withDisplayName("yyzlwhbwzjnu"))
            .withInstanceFlexibility(InstanceFlexibility.OFF)
            .withDisplayName("gmdq")
            .withRenew(false)
            .withReviewDateTime(OffsetDateTime.parse("2021-10-03T18:15:14Z"))
            .withPurchaseProperties(new ReservationPurchaseRequest().withSku(new SkuName().withName("ftedzuubjtvgjsx"))
                .withLocation("yj")
                .withBillingPlan(ReservationBillingPlan.MONTHLY)
                .withQuantity(187296293)
                .withDisplayName("zcgwdfriw")
                .withAppliedScopeType(AppliedScopeType.SINGLE)
                .withAppliedScopes(Arrays.asList("ozokscvglli"))
                .withAppliedScopeProperties(new ReservationAppliedScopeProperties().withTenantId("byfg")
                    .withManagementGroupId("wqkjvx")
                    .withSubscriptionId("wpxsoo")
                    .withResourceGroupId("txlcsk")
                    .withDisplayName("e"))
                .withRenew(true)
                .withInstanceFlexibility(InstanceFlexibility.ON)
                .withReviewDateTime(OffsetDateTime.parse("2021-09-19T08:34:05Z"))
                .withInstanceFlexibilityReservedResourcePropertiesInstanceFlexibility(InstanceFlexibility.ON));
        model = BinaryData.fromObject(model).toObject(PatchModel.class);
        Assertions.assertEquals("lttjzgcz", model.tags().get("cmfpfbodet"));
        Assertions.assertEquals(AppliedScopeType.MANAGEMENT_GROUP, model.appliedScopeType());
        Assertions.assertEquals("tesubzpvp", model.appliedScopeProperties().tenantId());
        Assertions.assertEquals("ylytcovqseusr", model.appliedScopeProperties().managementGroupId());
        Assertions.assertEquals("bdxzfxnxmlbmu", model.appliedScopeProperties().subscriptionId());
        Assertions.assertEquals("wkjmdihd", model.appliedScopeProperties().resourceGroupId());
        Assertions.assertEquals("yyzlwhbwzjnu", model.appliedScopeProperties().displayName());
        Assertions.assertEquals(InstanceFlexibility.OFF, model.instanceFlexibility());
        Assertions.assertEquals("gmdq", model.displayName());
        Assertions.assertEquals(false, model.renew());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-03T18:15:14Z"), model.reviewDateTime());
        Assertions.assertEquals("ftedzuubjtvgjsx", model.purchaseProperties().sku().name());
        Assertions.assertEquals("yj", model.purchaseProperties().location());
        Assertions.assertEquals(ReservationBillingPlan.MONTHLY, model.purchaseProperties().billingPlan());
        Assertions.assertEquals(187296293, model.purchaseProperties().quantity());
        Assertions.assertEquals("zcgwdfriw", model.purchaseProperties().displayName());
        Assertions.assertEquals(AppliedScopeType.SINGLE, model.purchaseProperties().appliedScopeType());
        Assertions.assertEquals("ozokscvglli", model.purchaseProperties().appliedScopes().get(0));
        Assertions.assertEquals("byfg", model.purchaseProperties().appliedScopeProperties().tenantId());
        Assertions.assertEquals("wqkjvx", model.purchaseProperties().appliedScopeProperties().managementGroupId());
        Assertions.assertEquals("wpxsoo", model.purchaseProperties().appliedScopeProperties().subscriptionId());
        Assertions.assertEquals("txlcsk", model.purchaseProperties().appliedScopeProperties().resourceGroupId());
        Assertions.assertEquals("e", model.purchaseProperties().appliedScopeProperties().displayName());
        Assertions.assertEquals(true, model.purchaseProperties().renew());
        Assertions.assertEquals(InstanceFlexibility.ON, model.purchaseProperties().instanceFlexibility());
        Assertions.assertEquals(OffsetDateTime.parse("2021-09-19T08:34:05Z"),
            model.purchaseProperties().reviewDateTime());
        Assertions.assertEquals(InstanceFlexibility.ON,
            model.purchaseProperties().instanceFlexibilityReservedResourcePropertiesInstanceFlexibility());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
