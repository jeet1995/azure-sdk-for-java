// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DayOfWeek;
import com.azure.resourcemanager.datafactory.models.DaysOfWeek;
import com.azure.resourcemanager.datafactory.models.PipelineReference;
import com.azure.resourcemanager.datafactory.models.RecurrenceFrequency;
import com.azure.resourcemanager.datafactory.models.RecurrenceSchedule;
import com.azure.resourcemanager.datafactory.models.RecurrenceScheduleOccurrence;
import com.azure.resourcemanager.datafactory.models.ScheduleTrigger;
import com.azure.resourcemanager.datafactory.models.ScheduleTriggerRecurrence;
import com.azure.resourcemanager.datafactory.models.TriggerPipelineReference;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ScheduleTriggerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ScheduleTrigger model = BinaryData.fromString(
            "{\"type\":\"ScheduleTrigger\",\"typeProperties\":{\"recurrence\":{\"frequency\":\"Day\",\"interval\":908629847,\"startTime\":\"2021-10-10T09:03:58Z\",\"endTime\":\"2021-04-07T08:57:02Z\",\"timeZone\":\"rwzepnlwuhtfa\",\"schedule\":{\"minutes\":[716679257,672428534],\"hours\":[1803788733,2048345821,178936990],\"weekDays\":[\"Monday\",\"Tuesday\",\"Wednesday\",\"Sunday\"],\"monthDays\":[1415296042,968780656,1960354924],\"monthlyOccurrences\":[{\"day\":\"Thursday\",\"occurrence\":1355959866,\"\":{\"nzskokaqbjncnbn\":\"datauipixpztfdujuoii\",\"pnobcqnym\":\"datappuzbipfazsayrkd\",\"xcno\":\"dataswrtifxbhuzv\"}},{\"day\":\"Friday\",\"occurrence\":1783575266,\"\":{\"zyfjmorehpjaktsz\":\"dataaixxigesbeivpuu\",\"nxrwgddg\":\"datacirrphtjljfmhg\",\"rizqein\":\"dataqfflswqeht\"}},{\"day\":\"Wednesday\",\"occurrence\":233335385,\"\":{\"xosszqu\":\"datayk\"}}],\"\":{\"wpgwpulrtjweuoro\":\"dataklsthjvyk\",\"dzvlitntdidhhac\":\"datarnkxswohshnc\",\"tgiontv\":\"datawdl\",\"oshkqthuijvi\":\"datar\"}},\"\":{\"sfuzqpigirnm\":\"dataswpwbgoetuxos\",\"gmwyfxeui\":\"dataeim\",\"ertgq\":\"datavtkllbfnn\"}}},\"pipelines\":[{\"pipelineReference\":{\"referenceName\":\"hvyr\",\"name\":\"euvu\"},\"parameters\":{\"wunwactjpg\":\"dataldkjayiexpcxylqu\",\"umkzdtjngkfi\":\"dataseulfzxghaylrvp\",\"lmbpjna\":\"dataxolpu\",\"enth\":\"datasbxvouxc\"}},{\"pipelineReference\":{\"referenceName\":\"wrme\",\"name\":\"ckocex\"},\"parameters\":{\"zwsjqrmxp\":\"datafniryhlarohwqxj\",\"bamnkgmosayfyvod\":\"dataz\",\"gwsrr\":\"datatpczzqusf\"}},{\"pipelineReference\":{\"referenceName\":\"ijolys\",\"name\":\"yswyaejffvfkk\"},\"parameters\":{\"wcuhqfxferfza\":\"datasjecccfyc\"}},{\"pipelineReference\":{\"referenceName\":\"ermnyphcoobs\",\"name\":\"obzrnvubszjytt\"},\"parameters\":{\"blalmgezkbh\":\"datascmtccz\",\"omeczd\":\"datarft\"}}],\"description\":\"bgp\",\"runtimeState\":\"Stopped\",\"annotations\":[\"databefavbsbhdtiaqa\",\"dataalbkemodlvdhvdvd\",\"datarrkvxmeihrzi\"],\"\":{\"dsu\":\"datanpojmgkeoqrx\",\"kbvaxehiegk\":\"dataonjuwgvse\",\"i\":\"dataukvalcvlbqht\"}}")
            .toObject(ScheduleTrigger.class);
        Assertions.assertEquals("bgp", model.description());
        Assertions.assertEquals("hvyr", model.pipelines().get(0).pipelineReference().referenceName());
        Assertions.assertEquals("euvu", model.pipelines().get(0).pipelineReference().name());
        Assertions.assertEquals(RecurrenceFrequency.DAY, model.recurrence().frequency());
        Assertions.assertEquals(908629847, model.recurrence().interval());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-10T09:03:58Z"), model.recurrence().startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-07T08:57:02Z"), model.recurrence().endTime());
        Assertions.assertEquals("rwzepnlwuhtfa", model.recurrence().timeZone());
        Assertions.assertEquals(716679257, model.recurrence().schedule().minutes().get(0));
        Assertions.assertEquals(1803788733, model.recurrence().schedule().hours().get(0));
        Assertions.assertEquals(DaysOfWeek.MONDAY, model.recurrence().schedule().weekDays().get(0));
        Assertions.assertEquals(1415296042, model.recurrence().schedule().monthDays().get(0));
        Assertions.assertEquals(DayOfWeek.THURSDAY, model.recurrence().schedule().monthlyOccurrences().get(0).day());
        Assertions.assertEquals(1355959866, model.recurrence().schedule().monthlyOccurrences().get(0).occurrence());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ScheduleTrigger model = new ScheduleTrigger().withDescription("bgp")
            .withAnnotations(Arrays.asList("databefavbsbhdtiaqa", "dataalbkemodlvdhvdvd", "datarrkvxmeihrzi"))
            .withPipelines(Arrays.asList(
                new TriggerPipelineReference()
                    .withPipelineReference(new PipelineReference().withReferenceName("hvyr").withName("euvu"))
                    .withParameters(mapOf("wunwactjpg", "dataldkjayiexpcxylqu", "umkzdtjngkfi", "dataseulfzxghaylrvp",
                        "lmbpjna", "dataxolpu", "enth", "datasbxvouxc")),
                new TriggerPipelineReference()
                    .withPipelineReference(new PipelineReference().withReferenceName("wrme").withName("ckocex"))
                    .withParameters(mapOf("zwsjqrmxp", "datafniryhlarohwqxj", "bamnkgmosayfyvod", "dataz", "gwsrr",
                        "datatpczzqusf")),
                new TriggerPipelineReference()
                    .withPipelineReference(
                        new PipelineReference().withReferenceName("ijolys").withName("yswyaejffvfkk"))
                    .withParameters(mapOf("wcuhqfxferfza", "datasjecccfyc")),
                new TriggerPipelineReference()
                    .withPipelineReference(
                        new PipelineReference().withReferenceName("ermnyphcoobs").withName("obzrnvubszjytt"))
                    .withParameters(mapOf("blalmgezkbh", "datascmtccz", "omeczd", "datarft"))))
            .withRecurrence(new ScheduleTriggerRecurrence().withFrequency(RecurrenceFrequency.DAY)
                .withInterval(908629847)
                .withStartTime(OffsetDateTime.parse("2021-10-10T09:03:58Z"))
                .withEndTime(OffsetDateTime.parse("2021-04-07T08:57:02Z"))
                .withTimeZone("rwzepnlwuhtfa")
                .withSchedule(new RecurrenceSchedule().withMinutes(Arrays.asList(716679257, 672428534))
                    .withHours(Arrays.asList(1803788733, 2048345821, 178936990))
                    .withWeekDays(
                        Arrays.asList(DaysOfWeek.MONDAY, DaysOfWeek.TUESDAY, DaysOfWeek.WEDNESDAY, DaysOfWeek.SUNDAY))
                    .withMonthDays(Arrays.asList(1415296042, 968780656, 1960354924))
                    .withMonthlyOccurrences(Arrays.asList(
                        new RecurrenceScheduleOccurrence().withDay(DayOfWeek.THURSDAY)
                            .withOccurrence(1355959866)
                            .withAdditionalProperties(mapOf()),
                        new RecurrenceScheduleOccurrence().withDay(DayOfWeek.FRIDAY)
                            .withOccurrence(1783575266)
                            .withAdditionalProperties(mapOf()),
                        new RecurrenceScheduleOccurrence().withDay(DayOfWeek.WEDNESDAY)
                            .withOccurrence(233335385)
                            .withAdditionalProperties(mapOf())))
                    .withAdditionalProperties(mapOf()))
                .withAdditionalProperties(mapOf()));
        model = BinaryData.fromObject(model).toObject(ScheduleTrigger.class);
        Assertions.assertEquals("bgp", model.description());
        Assertions.assertEquals("hvyr", model.pipelines().get(0).pipelineReference().referenceName());
        Assertions.assertEquals("euvu", model.pipelines().get(0).pipelineReference().name());
        Assertions.assertEquals(RecurrenceFrequency.DAY, model.recurrence().frequency());
        Assertions.assertEquals(908629847, model.recurrence().interval());
        Assertions.assertEquals(OffsetDateTime.parse("2021-10-10T09:03:58Z"), model.recurrence().startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-07T08:57:02Z"), model.recurrence().endTime());
        Assertions.assertEquals("rwzepnlwuhtfa", model.recurrence().timeZone());
        Assertions.assertEquals(716679257, model.recurrence().schedule().minutes().get(0));
        Assertions.assertEquals(1803788733, model.recurrence().schedule().hours().get(0));
        Assertions.assertEquals(DaysOfWeek.MONDAY, model.recurrence().schedule().weekDays().get(0));
        Assertions.assertEquals(1415296042, model.recurrence().schedule().monthDays().get(0));
        Assertions.assertEquals(DayOfWeek.THURSDAY, model.recurrence().schedule().monthlyOccurrences().get(0).day());
        Assertions.assertEquals(1355959866, model.recurrence().schedule().monthlyOccurrences().get(0).occurrence());
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
