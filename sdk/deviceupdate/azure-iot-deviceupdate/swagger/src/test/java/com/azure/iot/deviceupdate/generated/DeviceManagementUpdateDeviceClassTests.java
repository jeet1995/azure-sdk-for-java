// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.iot.deviceupdate.generated;

import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public final class DeviceManagementUpdateDeviceClassTests extends DeviceUpdateClientTestBase {
    @Test
    @Disabled
    public void testDeviceManagementUpdateDeviceClassTests() {
        BinaryData deviceClassPatch = BinaryData.fromString("{\"friendlyName\":\"GA Webcams\"}");
        RequestOptions requestOptions = new RequestOptions();
        Response<BinaryData> response
            = deviceManagementClient.updateDeviceClassWithResponse("deviceClassId", deviceClassPatch, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(BinaryData.fromString(
            "{\"bestCompatibleUpdate\":{\"friendlyName\":\"July 2022 Update\",\"updateId\":{\"name\":\"name\",\"provider\":\"provider\",\"version\":\"1.0.0.0\"}},\"deviceClassId\":\"deviceClassId\",\"deviceClassProperties\":{\"compatProperties\":{\"manufacturer\":\"manufacturer1\",\"model\":\"model1\"},\"contractModel\":{\"name\":\"Device Update Model V2\",\"id\":\"dtmi:azure:iot:deviceUpdateContractModel;2\"}},\"friendlyName\":\"GA Webcams\"}")
            .toObject(Object.class), response.getValue().toObject(Object.class));
    }
}
