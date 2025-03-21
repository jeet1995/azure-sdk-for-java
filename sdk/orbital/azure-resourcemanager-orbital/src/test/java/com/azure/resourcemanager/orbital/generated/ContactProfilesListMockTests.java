// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.orbital.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.orbital.OrbitalManager;
import com.azure.resourcemanager.orbital.models.AutoTrackingConfiguration;
import com.azure.resourcemanager.orbital.models.ContactProfile;
import com.azure.resourcemanager.orbital.models.ContactProfilesPropertiesProvisioningState;
import com.azure.resourcemanager.orbital.models.Direction;
import com.azure.resourcemanager.orbital.models.Polarization;
import com.azure.resourcemanager.orbital.models.Protocol;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ContactProfilesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"creating\",\"minimumViableContactDuration\":\"wxnb\",\"minimumElevationDegrees\":97.90466,\"autoTrackingConfiguration\":\"xBand\",\"eventHubUri\":\"scyhwz\",\"networkConfiguration\":{\"subnetId\":\"g\"},\"thirdPartyConfigurations\":[{\"providerName\":\"jbzbomvzzbtdcq\",\"missionConfiguration\":\"pniyujviyl\"}],\"links\":[{\"name\":\"shfssnrbgyef\",\"polarization\":\"linearVertical\",\"direction\":\"Uplink\",\"gainOverTemperature\":28.691996,\"eirpdBW\":47.278046,\"channels\":[{\"name\":\"fmwncotmrfh\",\"centerFrequencyMHz\":26.720215,\"bandwidthMHz\":60.592484,\"endPoint\":{\"ipAddress\":\"tymoxoftp\",\"endPointName\":\"piwyczuhxacpqjl\",\"port\":\"h\",\"protocol\":\"TCP\"}}]}]},\"location\":\"spskasdvlmfwdgz\",\"tags\":{\"euzvx\":\"ucvpamrs\",\"xmrhu\":\"risjnhnytxifqjz\"},\"id\":\"lw\",\"name\":\"cesutrgjupauut\",\"type\":\"woqhihe\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        OrbitalManager manager = OrbitalManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<ContactProfile> response
            = manager.contactProfiles().list("gjmfxumvfcl", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("spskasdvlmfwdgz", response.iterator().next().location());
        Assertions.assertEquals("ucvpamrs", response.iterator().next().tags().get("euzvx"));
        Assertions.assertEquals(ContactProfilesPropertiesProvisioningState.CREATING,
            response.iterator().next().provisioningState());
        Assertions.assertEquals("wxnb", response.iterator().next().minimumViableContactDuration());
        Assertions.assertEquals(97.90466F, response.iterator().next().minimumElevationDegrees());
        Assertions.assertEquals(AutoTrackingConfiguration.X_BAND,
            response.iterator().next().autoTrackingConfiguration());
        Assertions.assertEquals("scyhwz", response.iterator().next().eventHubUri());
        Assertions.assertEquals("g", response.iterator().next().networkConfiguration().subnetId());
        Assertions.assertEquals("jbzbomvzzbtdcq",
            response.iterator().next().thirdPartyConfigurations().get(0).providerName());
        Assertions.assertEquals("pniyujviyl",
            response.iterator().next().thirdPartyConfigurations().get(0).missionConfiguration());
        Assertions.assertEquals("shfssnrbgyef", response.iterator().next().links().get(0).name());
        Assertions.assertEquals(Polarization.LINEAR_VERTICAL, response.iterator().next().links().get(0).polarization());
        Assertions.assertEquals(Direction.UPLINK, response.iterator().next().links().get(0).direction());
        Assertions.assertEquals(28.691996F, response.iterator().next().links().get(0).gainOverTemperature());
        Assertions.assertEquals(47.278046F, response.iterator().next().links().get(0).eirpdBW());
        Assertions.assertEquals("fmwncotmrfh", response.iterator().next().links().get(0).channels().get(0).name());
        Assertions.assertEquals(26.720215f,
            response.iterator().next().links().get(0).channels().get(0).centerFrequencyMHz());
        Assertions.assertEquals(60.592484f, response.iterator().next().links().get(0).channels().get(0).bandwidthMHz());
        Assertions.assertEquals("tymoxoftp",
            response.iterator().next().links().get(0).channels().get(0).endPoint().ipAddress());
        Assertions.assertEquals("piwyczuhxacpqjl",
            response.iterator().next().links().get(0).channels().get(0).endPoint().endPointName());
        Assertions.assertEquals("h", response.iterator().next().links().get(0).channels().get(0).endPoint().port());
        Assertions.assertEquals(Protocol.TCP,
            response.iterator().next().links().get(0).channels().get(0).endPoint().protocol());
    }
}
