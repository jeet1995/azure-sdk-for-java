// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.botservice.generated;

/**
 * Samples for BotConnection ListWithSecrets.
 */
public final class BotConnectionListWithSecretsSamples {
    /*
     * x-ms-original-file:
     * specification/botservice/resource-manager/Microsoft.BotService/stable/2021-03-01/examples/GetConnection.json
     */
    /**
     * Sample code: List Connection Setting With Secrets.
     * 
     * @param manager Entry point to BotServiceManager.
     */
    public static void
        listConnectionSettingWithSecrets(com.azure.resourcemanager.botservice.BotServiceManager manager) {
        manager.botConnections()
            .listWithSecretsWithResponse("OneResourceGroupName", "samplebotname", "sampleConnection",
                com.azure.core.util.Context.NONE);
    }
}
