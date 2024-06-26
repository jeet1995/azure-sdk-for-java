// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.hybridcompute.HybridComputeManager;
import com.azure.resourcemanager.hybridcompute.models.NetworkSecurityPerimeterConfiguration;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class NetworkSecurityPerimeterConfigurationsListByPrivateLinkScopeMockTests {
    @Test
    public void testListByPrivateLinkScope() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"tmgxuupbezqcc\",\"provisioningIssues\":[{\"name\":\"ceukdqkkyihztg\",\"properties\":{\"issueType\":\"Other\",\"severity\":\"Error\",\"description\":\"wldoychi\",\"suggestedResourceIds\":[\"ecfehuwa\",\"a\",\"uhicqllizstacsjv\",\"rweft\"],\"suggestedAccessRules\":[{},{},{},{}]}},{\"name\":\"jp\",\"properties\":{\"issueType\":\"MissingPerimeterConfiguration\",\"severity\":\"Warning\",\"description\":\"epwamcxtcz\",\"suggestedResourceIds\":[\"euknijduyyes\",\"ydjfb\"],\"suggestedAccessRules\":[{}]}},{\"name\":\"hhulrtywikdm\",\"properties\":{\"issueType\":\"MissingIdentityConfiguration\",\"severity\":\"Warning\",\"description\":\"gbhgau\",\"suggestedResourceIds\":[\"ixmxufrsryjqgdkf\",\"ozo\",\"oqbvjhvefgwbmqj\",\"hntasfaymx\"],\"suggestedAccessRules\":[{},{},{},{}]}},{\"name\":\"zealbmqkyo\",\"properties\":{\"issueType\":\"MissingPerimeterConfiguration\",\"severity\":\"Error\",\"description\":\"btsuahxs\",\"suggestedResourceIds\":[\"cmmzrrs\",\"ubiwsdrnpxq\",\"odiffjxcjrmmua\"],\"suggestedAccessRules\":[{},{},{}]}}],\"networkSecurityPerimeter\":{\"id\":\"jogjonmc\",\"perimeterGuid\":\"foyzbamwineof\",\"location\":\"kak\"},\"resourceAssociation\":{\"name\":\"dt\",\"accessMode\":\"learning\"},\"profile\":{\"name\":\"cl\",\"accessRulesVersion\":2006840695,\"accessRules\":[{\"name\":\"yuxgvttxpnrupz\",\"properties\":{}},{\"name\":\"rdixt\",\"properties\":{}},{\"name\":\"ids\",\"properties\":{}}],\"diagnosticSettingsVersion\":757162832,\"enabledLogCategories\":[\"uffgllukkutvlx\",\"rpq\",\"vmblcouqe\"]}},\"id\":\"bhbcdszir\",\"name\":\"randoypmb\",\"type\":\"t\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HybridComputeManager manager = HybridComputeManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<NetworkSecurityPerimeterConfiguration> response = manager.networkSecurityPerimeterConfigurations()
            .listByPrivateLinkScope("jxl", "bsjuscvsfx", com.azure.core.util.Context.NONE);

    }
}
