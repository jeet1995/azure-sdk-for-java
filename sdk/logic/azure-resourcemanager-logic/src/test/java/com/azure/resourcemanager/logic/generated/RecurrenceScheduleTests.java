// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.logic.models.DayOfWeek;
import com.azure.resourcemanager.logic.models.DaysOfWeek;
import com.azure.resourcemanager.logic.models.RecurrenceSchedule;
import com.azure.resourcemanager.logic.models.RecurrenceScheduleOccurrence;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RecurrenceScheduleTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RecurrenceSchedule model =
            BinaryData
                .fromString(
                    "{\"minutes\":[1133665771,2035107412,384139525],\"hours\":[1358628547,113016072,185974467],\"weekDays\":[\"Thursday\"],\"monthDays\":[2142840160,818210611,1096564755],\"monthlyOccurrences\":[{\"day\":\"Wednesday\",\"occurrence\":864051381},{\"day\":\"Saturday\",\"occurrence\":1792209333}]}")
                .toObject(RecurrenceSchedule.class);
        Assertions.assertEquals(1133665771, model.minutes().get(0));
        Assertions.assertEquals(1358628547, model.hours().get(0));
        Assertions.assertEquals(DaysOfWeek.THURSDAY, model.weekDays().get(0));
        Assertions.assertEquals(2142840160, model.monthDays().get(0));
        Assertions.assertEquals(DayOfWeek.WEDNESDAY, model.monthlyOccurrences().get(0).day());
        Assertions.assertEquals(864051381, model.monthlyOccurrences().get(0).occurrence());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RecurrenceSchedule model =
            new RecurrenceSchedule()
                .withMinutes(Arrays.asList(1133665771, 2035107412, 384139525))
                .withHours(Arrays.asList(1358628547, 113016072, 185974467))
                .withWeekDays(Arrays.asList(DaysOfWeek.THURSDAY))
                .withMonthDays(Arrays.asList(2142840160, 818210611, 1096564755))
                .withMonthlyOccurrences(
                    Arrays
                        .asList(
                            new RecurrenceScheduleOccurrence().withDay(DayOfWeek.WEDNESDAY).withOccurrence(864051381),
                            new RecurrenceScheduleOccurrence().withDay(DayOfWeek.SATURDAY).withOccurrence(1792209333)));
        model = BinaryData.fromObject(model).toObject(RecurrenceSchedule.class);
        Assertions.assertEquals(1133665771, model.minutes().get(0));
        Assertions.assertEquals(1358628547, model.hours().get(0));
        Assertions.assertEquals(DaysOfWeek.THURSDAY, model.weekDays().get(0));
        Assertions.assertEquals(2142840160, model.monthDays().get(0));
        Assertions.assertEquals(DayOfWeek.WEDNESDAY, model.monthlyOccurrences().get(0).day());
        Assertions.assertEquals(864051381, model.monthlyOccurrences().get(0).occurrence());
    }
}
