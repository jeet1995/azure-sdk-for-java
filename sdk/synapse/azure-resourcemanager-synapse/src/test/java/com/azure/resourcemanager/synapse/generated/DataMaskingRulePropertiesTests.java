// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.fluent.models.DataMaskingRuleProperties;
import com.azure.resourcemanager.synapse.models.DataMaskingFunction;
import com.azure.resourcemanager.synapse.models.DataMaskingRuleState;
import org.junit.jupiter.api.Assertions;

public final class DataMaskingRulePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DataMaskingRuleProperties model = BinaryData.fromString(
            "{\"id\":\"zuawxtzxpuamwa\",\"aliasName\":\"xrvxcushsphai\",\"ruleState\":\"Enabled\",\"schemaName\":\"yasflvgsgzwy\",\"tableName\":\"akoi\",\"columnName\":\"knsmjblmljhlnymz\",\"maskingFunction\":\"Default\",\"numberFrom\":\"yryuzcb\",\"numberTo\":\"qvx\",\"prefixSize\":\"wfgtayxonsup\",\"suffixSize\":\"jlzqnhc\",\"replacementString\":\"ql\"}")
            .toObject(DataMaskingRuleProperties.class);
        Assertions.assertEquals("xrvxcushsphai", model.aliasName());
        Assertions.assertEquals(DataMaskingRuleState.ENABLED, model.ruleState());
        Assertions.assertEquals("yasflvgsgzwy", model.schemaName());
        Assertions.assertEquals("akoi", model.tableName());
        Assertions.assertEquals("knsmjblmljhlnymz", model.columnName());
        Assertions.assertEquals(DataMaskingFunction.DEFAULT, model.maskingFunction());
        Assertions.assertEquals("yryuzcb", model.numberFrom());
        Assertions.assertEquals("qvx", model.numberTo());
        Assertions.assertEquals("wfgtayxonsup", model.prefixSize());
        Assertions.assertEquals("jlzqnhc", model.suffixSize());
        Assertions.assertEquals("ql", model.replacementString());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DataMaskingRuleProperties model = new DataMaskingRuleProperties().withAliasName("xrvxcushsphai")
            .withRuleState(DataMaskingRuleState.ENABLED)
            .withSchemaName("yasflvgsgzwy")
            .withTableName("akoi")
            .withColumnName("knsmjblmljhlnymz")
            .withMaskingFunction(DataMaskingFunction.DEFAULT)
            .withNumberFrom("yryuzcb")
            .withNumberTo("qvx")
            .withPrefixSize("wfgtayxonsup")
            .withSuffixSize("jlzqnhc")
            .withReplacementString("ql");
        model = BinaryData.fromObject(model).toObject(DataMaskingRuleProperties.class);
        Assertions.assertEquals("xrvxcushsphai", model.aliasName());
        Assertions.assertEquals(DataMaskingRuleState.ENABLED, model.ruleState());
        Assertions.assertEquals("yasflvgsgzwy", model.schemaName());
        Assertions.assertEquals("akoi", model.tableName());
        Assertions.assertEquals("knsmjblmljhlnymz", model.columnName());
        Assertions.assertEquals(DataMaskingFunction.DEFAULT, model.maskingFunction());
        Assertions.assertEquals("yryuzcb", model.numberFrom());
        Assertions.assertEquals("qvx", model.numberTo());
        Assertions.assertEquals("wfgtayxonsup", model.prefixSize());
        Assertions.assertEquals("jlzqnhc", model.suffixSize());
        Assertions.assertEquals("ql", model.replacementString());
    }
}
