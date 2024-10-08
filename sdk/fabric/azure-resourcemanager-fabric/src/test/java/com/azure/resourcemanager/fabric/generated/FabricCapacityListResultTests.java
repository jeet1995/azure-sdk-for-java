// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.fabric.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.fabric.implementation.models.FabricCapacityListResult;
import com.azure.resourcemanager.fabric.models.RpSkuTier;
import org.junit.jupiter.api.Assertions;

public final class FabricCapacityListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FabricCapacityListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"provisioningState\":\"Succeeded\",\"state\":\"Suspending\",\"administration\":{\"members\":[\"ukcdmparcryuanzw\",\"xzdxtayrlhmwh\",\"pmrqobm\"]}},\"sku\":{\"name\":\"u\",\"tier\":\"Fabric\"},\"location\":\"ryrtihfxtijbpzv\",\"tags\":{\"ihanuf\":\"zsymglzufcyzkohd\",\"ifpikxwczby\":\"fcbjysagithxqha\",\"rkxvdum\":\"cnpqxuhivyqniwby\"},\"id\":\"grtfwvu\",\"name\":\"xgaudccs\",\"type\":\"h\"},{\"properties\":{\"provisioningState\":\"Updating\",\"state\":\"Updating\",\"administration\":{\"members\":[\"j\",\"kryhtnapczwlokj\"]}},\"sku\":{\"name\":\"emkkvnipjox\",\"tier\":\"Fabric\"},\"location\":\"chgejspodm\",\"tags\":{\"o\":\"zyde\",\"wixjsprozvcp\":\"wyahuxinpmqnja\",\"atscmd\":\"tegjvwmf\",\"zkrwfn\":\"pjhulsuuvmkj\"},\"id\":\"iodjp\",\"name\":\"lwejdpv\",\"type\":\"ryo\"},{\"properties\":{\"provisioningState\":\"Updating\",\"state\":\"Scaling\",\"administration\":{\"members\":[\"ctazakljlahbcryf\",\"dfdosygexp\",\"ojakhmsbzjhcrze\",\"dphlxaolt\"]}},\"sku\":{\"name\":\"qtrgqjbpfzfsinzg\",\"tier\":\"Fabric\"},\"location\":\"jrwzox\",\"tags\":{\"fpjkjlxofp\":\"felluwfzitonpe\",\"uybbkpodep\":\"vhpfxxypininmay\"},\"id\":\"oginuvamiheognar\",\"name\":\"zxtheotusivyevcc\",\"type\":\"qi\"}],\"nextLink\":\"hungbwjzrnf\"}")
            .toObject(FabricCapacityListResult.class);
        Assertions.assertEquals("ryrtihfxtijbpzv", model.value().get(0).location());
        Assertions.assertEquals("zsymglzufcyzkohd", model.value().get(0).tags().get("ihanuf"));
        Assertions.assertEquals("ukcdmparcryuanzw",
            model.value().get(0).properties().administration().members().get(0));
        Assertions.assertEquals("u", model.value().get(0).sku().name());
        Assertions.assertEquals(RpSkuTier.FABRIC, model.value().get(0).sku().tier());
        Assertions.assertEquals("hungbwjzrnf", model.nextLink());
    }
}
