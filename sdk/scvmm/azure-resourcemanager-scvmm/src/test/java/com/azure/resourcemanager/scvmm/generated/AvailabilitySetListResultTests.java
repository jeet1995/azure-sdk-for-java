// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.scvmm.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.scvmm.models.AvailabilitySetListResult;
import org.junit.jupiter.api.Assertions;

public final class AvailabilitySetListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AvailabilitySetListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"availabilitySetName\":\"hrbnlankxmyskpbh\",\"vmmServerId\":\"btkcxywnytnrsyn\",\"provisioningState\":\"Updating\"},\"extendedLocation\":{\"type\":\"ybyxc\",\"name\":\"clha\"},\"location\":\"dbabp\",\"tags\":{\"yazttbtwwrqpue\":\"rqlfktsthsucocmn\",\"xibxujwbhqwalm\":\"ckzywbiexzfeyue\",\"ux\":\"zyoxaepdkzjan\",\"zt\":\"hdwbavxbniwdjs\"},\"id\":\"dbpgnxytxhp\",\"name\":\"xbzpfzab\",\"type\":\"lcuhxwtctyqiklb\"},{\"properties\":{\"availabilitySetName\":\"plwzbhvgyugu\",\"vmmServerId\":\"vmkfssxqu\",\"provisioningState\":\"Failed\"},\"extendedLocation\":{\"type\":\"l\",\"name\":\"gsxnkjzkdeslpv\"},\"location\":\"pwiyig\",\"tags\":{\"upedeojnabckhs\":\"kdwzbaiuebbaumny\",\"ie\":\"txp\"},\"id\":\"tfhvpesapskrdqmh\",\"name\":\"jdhtldwkyzxu\",\"type\":\"tkncwsc\"},{\"properties\":{\"availabilitySetName\":\"lxotogtwrupq\",\"vmmServerId\":\"vnm\",\"provisioningState\":\"Updating\"},\"extendedLocation\":{\"type\":\"vce\",\"name\":\"eil\"},\"location\":\"notyfjfcnjbkcn\",\"tags\":{\"h\":\"bttk\",\"jtoqne\":\"wpn\",\"abgy\":\"mclfplphoxuscr\"},\"id\":\"psbjta\",\"name\":\"qugxywpmueefjzwf\",\"type\":\"kqujidsuyono\"}],\"nextLink\":\"laocqxtccmg\"}")
            .toObject(AvailabilitySetListResult.class);
        Assertions.assertEquals("dbabp", model.value().get(0).location());
        Assertions.assertEquals("rqlfktsthsucocmn", model.value().get(0).tags().get("yazttbtwwrqpue"));
        Assertions.assertEquals("hrbnlankxmyskpbh", model.value().get(0).properties().availabilitySetName());
        Assertions.assertEquals("btkcxywnytnrsyn", model.value().get(0).properties().vmmServerId());
        Assertions.assertEquals("ybyxc", model.value().get(0).extendedLocation().type());
        Assertions.assertEquals("clha", model.value().get(0).extendedLocation().name());
    }
}
