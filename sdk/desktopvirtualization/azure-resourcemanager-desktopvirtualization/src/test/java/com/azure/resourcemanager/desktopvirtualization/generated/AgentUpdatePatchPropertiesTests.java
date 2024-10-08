// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.desktopvirtualization.models.AgentUpdatePatchProperties;
import com.azure.resourcemanager.desktopvirtualization.models.DayOfWeek;
import com.azure.resourcemanager.desktopvirtualization.models.MaintenanceWindowPatchProperties;
import com.azure.resourcemanager.desktopvirtualization.models.SessionHostComponentUpdateType;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class AgentUpdatePatchPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AgentUpdatePatchProperties model = BinaryData.fromString(
            "{\"type\":\"Scheduled\",\"useSessionHostLocalTime\":true,\"maintenanceWindowTimeZone\":\"zi\",\"maintenanceWindows\":[{\"hour\":566949412,\"dayOfWeek\":\"Tuesday\"},{\"hour\":2014142159,\"dayOfWeek\":\"Monday\"},{\"hour\":377677013,\"dayOfWeek\":\"Thursday\"},{\"hour\":140703725,\"dayOfWeek\":\"Saturday\"}]}")
            .toObject(AgentUpdatePatchProperties.class);
        Assertions.assertEquals(SessionHostComponentUpdateType.SCHEDULED, model.type());
        Assertions.assertEquals(true, model.useSessionHostLocalTime());
        Assertions.assertEquals("zi", model.maintenanceWindowTimeZone());
        Assertions.assertEquals(566949412, model.maintenanceWindows().get(0).hour());
        Assertions.assertEquals(DayOfWeek.TUESDAY, model.maintenanceWindows().get(0).dayOfWeek());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AgentUpdatePatchProperties model
            = new AgentUpdatePatchProperties().withType(SessionHostComponentUpdateType.SCHEDULED)
                .withUseSessionHostLocalTime(true)
                .withMaintenanceWindowTimeZone("zi")
                .withMaintenanceWindows(Arrays.asList(
                    new MaintenanceWindowPatchProperties().withHour(566949412).withDayOfWeek(DayOfWeek.TUESDAY),
                    new MaintenanceWindowPatchProperties().withHour(2014142159).withDayOfWeek(DayOfWeek.MONDAY),
                    new MaintenanceWindowPatchProperties().withHour(377677013).withDayOfWeek(DayOfWeek.THURSDAY),
                    new MaintenanceWindowPatchProperties().withHour(140703725).withDayOfWeek(DayOfWeek.SATURDAY)));
        model = BinaryData.fromObject(model).toObject(AgentUpdatePatchProperties.class);
        Assertions.assertEquals(SessionHostComponentUpdateType.SCHEDULED, model.type());
        Assertions.assertEquals(true, model.useSessionHostLocalTime());
        Assertions.assertEquals("zi", model.maintenanceWindowTimeZone());
        Assertions.assertEquals(566949412, model.maintenanceWindows().get(0).hour());
        Assertions.assertEquals(DayOfWeek.TUESDAY, model.maintenanceWindows().get(0).dayOfWeek());
    }
}
