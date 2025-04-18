// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.DependencyReference;
import com.azure.resourcemanager.datafactory.models.PipelineReference;
import com.azure.resourcemanager.datafactory.models.RetryPolicy;
import com.azure.resourcemanager.datafactory.models.TriggerPipelineReference;
import com.azure.resourcemanager.datafactory.models.TumblingWindowFrequency;
import com.azure.resourcemanager.datafactory.models.TumblingWindowTrigger;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class TumblingWindowTriggerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TumblingWindowTrigger model = BinaryData.fromString(
            "{\"type\":\"TumblingWindowTrigger\",\"pipeline\":{\"pipelineReference\":{\"referenceName\":\"plolcalyvcxv\",\"name\":\"xdeqntblt\"},\"parameters\":{\"rmwdofgfspzwa\":\"dataqbyubswzaf\",\"wvjcdjvlwczw\":\"datacu\",\"fckrmrbaoidt\":\"datakkscooqnvht\",\"cbvkoughjsxp\":\"datam\"}},\"typeProperties\":{\"frequency\":\"Month\",\"interval\":189437887,\"startTime\":\"2021-11-09T02:05:30Z\",\"endTime\":\"2021-04-24T18:13:15Z\",\"delay\":\"datadnihx\",\"maxConcurrency\":1902437036,\"retryPolicy\":{\"count\":\"datatsbpvyvsc\",\"intervalInSeconds\":2016822910},\"dependsOn\":[{\"type\":\"DependencyReference\"},{\"type\":\"DependencyReference\"},{\"type\":\"DependencyReference\"},{\"type\":\"DependencyReference\"}]},\"description\":\"daqqklvyibrohfvb\",\"runtimeState\":\"Started\",\"annotations\":[\"datadlsanglwnkkzt\"],\"\":{\"hj\":\"dataj\",\"tyozwnpuyh\":\"dataqajyrhrywucpdzb\",\"rhabbdqnefofuj\":\"dataaylsmehlzplz\",\"rqkvufnphb\":\"datawqpkhgrdgyilo\"}}")
            .toObject(TumblingWindowTrigger.class);
        Assertions.assertEquals("daqqklvyibrohfvb", model.description());
        Assertions.assertEquals("plolcalyvcxv", model.pipeline().pipelineReference().referenceName());
        Assertions.assertEquals("xdeqntblt", model.pipeline().pipelineReference().name());
        Assertions.assertEquals(TumblingWindowFrequency.MONTH, model.frequency());
        Assertions.assertEquals(189437887, model.interval());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-09T02:05:30Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-24T18:13:15Z"), model.endTime());
        Assertions.assertEquals(1902437036, model.maxConcurrency());
        Assertions.assertEquals(2016822910, model.retryPolicy().intervalInSeconds());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TumblingWindowTrigger model = new TumblingWindowTrigger().withDescription("daqqklvyibrohfvb")
            .withAnnotations(Arrays.asList("datadlsanglwnkkzt"))
            .withPipeline(new TriggerPipelineReference()
                .withPipelineReference(new PipelineReference().withReferenceName("plolcalyvcxv").withName("xdeqntblt"))
                .withParameters(mapOf("rmwdofgfspzwa", "dataqbyubswzaf", "wvjcdjvlwczw", "datacu", "fckrmrbaoidt",
                    "datakkscooqnvht", "cbvkoughjsxp", "datam")))
            .withFrequency(TumblingWindowFrequency.MONTH)
            .withInterval(189437887)
            .withStartTime(OffsetDateTime.parse("2021-11-09T02:05:30Z"))
            .withEndTime(OffsetDateTime.parse("2021-04-24T18:13:15Z"))
            .withDelay("datadnihx")
            .withMaxConcurrency(1902437036)
            .withRetryPolicy(new RetryPolicy().withCount("datatsbpvyvsc").withIntervalInSeconds(2016822910))
            .withDependsOn(Arrays.asList(new DependencyReference(), new DependencyReference(),
                new DependencyReference(), new DependencyReference()));
        model = BinaryData.fromObject(model).toObject(TumblingWindowTrigger.class);
        Assertions.assertEquals("daqqklvyibrohfvb", model.description());
        Assertions.assertEquals("plolcalyvcxv", model.pipeline().pipelineReference().referenceName());
        Assertions.assertEquals("xdeqntblt", model.pipeline().pipelineReference().name());
        Assertions.assertEquals(TumblingWindowFrequency.MONTH, model.frequency());
        Assertions.assertEquals(189437887, model.interval());
        Assertions.assertEquals(OffsetDateTime.parse("2021-11-09T02:05:30Z"), model.startTime());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-24T18:13:15Z"), model.endTime());
        Assertions.assertEquals(1902437036, model.maxConcurrency());
        Assertions.assertEquals(2016822910, model.retryPolicy().intervalInSeconds());
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
