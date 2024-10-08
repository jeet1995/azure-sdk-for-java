// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.BlobTrigger;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.PipelineReference;
import com.azure.resourcemanager.datafactory.models.TriggerPipelineReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class BlobTriggerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BlobTrigger model = BinaryData.fromString(
            "{\"type\":\"BlobTrigger\",\"typeProperties\":{\"folderPath\":\"ym\",\"maxConcurrency\":1812804884,\"linkedService\":{\"referenceName\":\"ztorvwgpjxdii\",\"parameters\":{\"txzvyd\":\"datadzhkbcouavotfm\",\"bjcznx\":\"dataqmlkrxjqp\",\"yu\":\"datahiwaau\",\"onrrarznlr\":\"datajirtiubvyudk\"}}},\"pipelines\":[{\"pipelineReference\":{\"referenceName\":\"xaejbmtou\",\"name\":\"udfhclssedxiigw\"},\"parameters\":{\"vsjaaeds\":\"dataqjpudupish\"}},{\"pipelineReference\":{\"referenceName\":\"dulndywghnptfvol\",\"name\":\"romhsias\"},\"parameters\":{\"kwc\":\"datapelq\",\"xhoqfvuqimdgk\":\"datapmsyhrvifurg\",\"iipnszrrmq\":\"datafghc\"}},{\"pipelineReference\":{\"referenceName\":\"xyawtdsnvxhx\",\"name\":\"decryoffglwmkmb\"},\"parameters\":{\"qicehx\":\"datanxlqnzxsdbfb\",\"ducozdz\":\"dataztffng\",\"bj\":\"datahtfmgpioxzh\"}}],\"description\":\"u\",\"runtimeState\":\"Disabled\",\"annotations\":[\"dataohaeeuotfavmdpep\",\"dataycvwew\",\"datagnpu\",\"datapaqj\"],\"\":{\"xuxregfb\":\"datavjwlrit\",\"mjgtjckf\":\"datafkzpf\",\"xmmpuksvoimdg\":\"dataljrlrkvhgnm\"}}")
            .toObject(BlobTrigger.class);
        Assertions.assertEquals("u", model.description());
        Assertions.assertEquals("xaejbmtou", model.pipelines().get(0).pipelineReference().referenceName());
        Assertions.assertEquals("udfhclssedxiigw", model.pipelines().get(0).pipelineReference().name());
        Assertions.assertEquals("ym", model.folderPath());
        Assertions.assertEquals(1812804884, model.maxConcurrency());
        Assertions.assertEquals("ztorvwgpjxdii", model.linkedService().referenceName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BlobTrigger model = new BlobTrigger().withDescription("u")
            .withAnnotations(Arrays.asList("dataohaeeuotfavmdpep", "dataycvwew", "datagnpu", "datapaqj"))
            .withPipelines(Arrays.asList(
                new TriggerPipelineReference()
                    .withPipelineReference(
                        new PipelineReference().withReferenceName("xaejbmtou").withName("udfhclssedxiigw"))
                    .withParameters(mapOf("vsjaaeds", "dataqjpudupish")),
                new TriggerPipelineReference()
                    .withPipelineReference(
                        new PipelineReference().withReferenceName("dulndywghnptfvol").withName("romhsias"))
                    .withParameters(
                        mapOf("kwc", "datapelq", "xhoqfvuqimdgk", "datapmsyhrvifurg", "iipnszrrmq", "datafghc")),
                new TriggerPipelineReference()
                    .withPipelineReference(
                        new PipelineReference().withReferenceName("xyawtdsnvxhx").withName("decryoffglwmkmb"))
                    .withParameters(
                        mapOf("qicehx", "datanxlqnzxsdbfb", "ducozdz", "dataztffng", "bj", "datahtfmgpioxzh"))))
            .withFolderPath("ym")
            .withMaxConcurrency(1812804884)
            .withLinkedService(new LinkedServiceReference().withReferenceName("ztorvwgpjxdii")
                .withParameters(mapOf("txzvyd", "datadzhkbcouavotfm", "bjcznx", "dataqmlkrxjqp", "yu", "datahiwaau",
                    "onrrarznlr", "datajirtiubvyudk")));
        model = BinaryData.fromObject(model).toObject(BlobTrigger.class);
        Assertions.assertEquals("u", model.description());
        Assertions.assertEquals("xaejbmtou", model.pipelines().get(0).pipelineReference().referenceName());
        Assertions.assertEquals("udfhclssedxiigw", model.pipelines().get(0).pipelineReference().name());
        Assertions.assertEquals("ym", model.folderPath());
        Assertions.assertEquals(1812804884, model.maxConcurrency());
        Assertions.assertEquals("ztorvwgpjxdii", model.linkedService().referenceName());
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
