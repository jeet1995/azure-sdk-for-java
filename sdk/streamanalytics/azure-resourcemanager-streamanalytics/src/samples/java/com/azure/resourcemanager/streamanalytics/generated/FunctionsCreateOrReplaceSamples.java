// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.streamanalytics.generated;

import com.azure.resourcemanager.streamanalytics.models.AzureMachineLearningWebServiceFunctionBinding;
import com.azure.resourcemanager.streamanalytics.models.AzureMachineLearningWebServiceInputColumn;
import com.azure.resourcemanager.streamanalytics.models.AzureMachineLearningWebServiceInputs;
import com.azure.resourcemanager.streamanalytics.models.AzureMachineLearningWebServiceOutputColumn;
import com.azure.resourcemanager.streamanalytics.models.FunctionInput;
import com.azure.resourcemanager.streamanalytics.models.FunctionOutput;
import com.azure.resourcemanager.streamanalytics.models.JavaScriptFunctionBinding;
import com.azure.resourcemanager.streamanalytics.models.ScalarFunctionProperties;
import java.util.Arrays;

/**
 * Samples for Functions CreateOrReplace.
 */
public final class FunctionsCreateOrReplaceSamples {
    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Function_Create_JavaScript.json
     */
    /**
     * Sample code: Create a JavaScript function.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void
        createAJavaScriptFunction(com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.functions()
            .define("function8197")
            .withExistingStreamingjob("sjrg1637", "sj8653")
            .withProperties(
                new ScalarFunctionProperties().withInputs(Arrays.asList(new FunctionInput().withDataType("Any")))
                    .withOutput(new FunctionOutput().withDataType("Any"))
                    .withBinding(new JavaScriptFunctionBinding().withScript("function (x, y) { return x + y; }")))
            .create();
    }

    /*
     * x-ms-original-file:
     * specification/streamanalytics/resource-manager/Microsoft.StreamAnalytics/stable/2020-03-01/examples/
     * Function_Create_AzureML.json
     */
    /**
     * Sample code: Create an Azure ML function.
     * 
     * @param manager Entry point to StreamAnalyticsManager.
     */
    public static void
        createAnAzureMLFunction(com.azure.resourcemanager.streamanalytics.StreamAnalyticsManager manager) {
        manager.functions()
            .define("function588")
            .withExistingStreamingjob("sjrg7", "sj9093")
            .withProperties(new ScalarFunctionProperties()
                .withInputs(Arrays.asList(new FunctionInput().withDataType("nvarchar(max)")))
                .withOutput(new FunctionOutput().withDataType("nvarchar(max)"))
                .withBinding(new AzureMachineLearningWebServiceFunctionBinding().withEndpoint("someAzureMLEndpointURL")
                    .withApiKey("fakeTokenPlaceholder")
                    .withInputs(new AzureMachineLearningWebServiceInputs().withName("input1")
                        .withColumnNames(Arrays.asList(new AzureMachineLearningWebServiceInputColumn().withName("tweet")
                            .withDataType("string")
                            .withMapTo(0))))
                    .withOutputs(Arrays.asList(
                        new AzureMachineLearningWebServiceOutputColumn().withName("Sentiment").withDataType("string")))
                    .withBatchSize(1000)))
            .create();
    }
}
