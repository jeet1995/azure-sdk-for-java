// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.Office365Source;

public final class Office365SourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Office365Source model = BinaryData.fromString(
            "{\"type\":\"Office365Source\",\"allowedGroups\":\"dataqttfqgdoowgqooip\",\"userScopeFilterUri\":\"datasvsnedhkj\",\"dateFilterColumn\":\"datafvetwfreqvfl\",\"startTime\":\"datatjuuikqzdcwqal\",\"endTime\":\"datamiytpjiscisol\",\"outputColumns\":\"dataipvlsljutawgyl\",\"sourceRetryCount\":\"datadrfclehlop\",\"sourceRetryWait\":\"datavpeaeyjl\",\"maxConcurrentConnections\":\"dataduxhopyavcb\",\"disableMetricsCollection\":\"dataembvfa\",\"\":{\"xzrycvacspzj\":\"datajoazyxmumfbk\"}}")
            .toObject(Office365Source.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Office365Source model = new Office365Source().withSourceRetryCount("datadrfclehlop")
            .withSourceRetryWait("datavpeaeyjl")
            .withMaxConcurrentConnections("dataduxhopyavcb")
            .withDisableMetricsCollection("dataembvfa")
            .withAllowedGroups("dataqttfqgdoowgqooip")
            .withUserScopeFilterUri("datasvsnedhkj")
            .withDateFilterColumn("datafvetwfreqvfl")
            .withStartTime("datatjuuikqzdcwqal")
            .withEndTime("datamiytpjiscisol")
            .withOutputColumns("dataipvlsljutawgyl");
        model = BinaryData.fromObject(model).toObject(Office365Source.class);
    }
}
