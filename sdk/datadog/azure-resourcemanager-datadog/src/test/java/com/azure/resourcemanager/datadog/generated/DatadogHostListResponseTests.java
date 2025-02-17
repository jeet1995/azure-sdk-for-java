// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datadog.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datadog.fluent.models.DatadogHostInner;
import com.azure.resourcemanager.datadog.models.DatadogHostListResponse;
import com.azure.resourcemanager.datadog.models.DatadogHostMetadata;
import com.azure.resourcemanager.datadog.models.DatadogInstallMethod;
import com.azure.resourcemanager.datadog.models.DatadogLogsAgent;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class DatadogHostListResponseTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DatadogHostListResponse model = BinaryData.fromString(
            "{\"value\":[{\"name\":\"qpsoacctazak\",\"aliases\":[\"ahbc\",\"yffdfdos\",\"gexpaojakhmsbz\"],\"apps\":[\"rzevdphlxaol\",\"hqtrgqjbpf\",\"fsinzgvfcjrwzoxx\"],\"meta\":{\"agentVersion\":\"elluwfziton\",\"installMethod\":{\"tool\":\"fpjkjlxofp\",\"toolVersion\":\"hpf\",\"installerVersion\":\"ypininm\"},\"logsAgent\":{\"transport\":\"uybbkpodep\"}}},{\"name\":\"ginuvamih\",\"aliases\":[\"narxzxtheotus\",\"vyevcciqi\",\"nhungbw\"],\"apps\":[\"nfygxgispemvtz\",\"kufubljo\",\"xqeofjaeqjhqjba\"],\"meta\":{\"agentVersion\":\"smjqulngsntnbyb\",\"installMethod\":{\"tool\":\"cwrwclxxwrljdous\",\"toolVersion\":\"qvkoc\",\"installerVersion\":\"jdkwtnhxbnjb\"},\"logsAgent\":{\"transport\":\"qrglssainqpjwn\"}}},{\"name\":\"ljfmppee\",\"aliases\":[\"gxsabkyq\",\"uujitcjc\"],\"apps\":[\"evndh\",\"rwpdappdsbdkvwrw\",\"feusnhut\",\"eltmrldhugjzzdat\"],\"meta\":{\"agentVersion\":\"oc\",\"installMethod\":{\"tool\":\"ablgphuticndvk\",\"toolVersion\":\"zwyiftyhxhur\",\"installerVersion\":\"ftyxolniw\"},\"logsAgent\":{\"transport\":\"ukjfkgiawxklr\"}}}],\"nextLink\":\"lwckbasyypnddhs\"}")
            .toObject(DatadogHostListResponse.class);
        Assertions.assertEquals("qpsoacctazak", model.value().get(0).name());
        Assertions.assertEquals("ahbc", model.value().get(0).aliases().get(0));
        Assertions.assertEquals("rzevdphlxaol", model.value().get(0).apps().get(0));
        Assertions.assertEquals("elluwfziton", model.value().get(0).meta().agentVersion());
        Assertions.assertEquals("fpjkjlxofp", model.value().get(0).meta().installMethod().tool());
        Assertions.assertEquals("hpf", model.value().get(0).meta().installMethod().toolVersion());
        Assertions.assertEquals("ypininm", model.value().get(0).meta().installMethod().installerVersion());
        Assertions.assertEquals("uybbkpodep", model.value().get(0).meta().logsAgent().transport());
        Assertions.assertEquals("lwckbasyypnddhs", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DatadogHostListResponse model = new DatadogHostListResponse()
            .withValue(Arrays.asList(
                new DatadogHostInner().withName("qpsoacctazak")
                    .withAliases(Arrays.asList("ahbc", "yffdfdos", "gexpaojakhmsbz"))
                    .withApps(Arrays.asList("rzevdphlxaol", "hqtrgqjbpf", "fsinzgvfcjrwzoxx"))
                    .withMeta(new DatadogHostMetadata().withAgentVersion("elluwfziton")
                        .withInstallMethod(new DatadogInstallMethod().withTool("fpjkjlxofp")
                            .withToolVersion("hpf")
                            .withInstallerVersion("ypininm"))
                        .withLogsAgent(new DatadogLogsAgent().withTransport("uybbkpodep"))),
                new DatadogHostInner().withName("ginuvamih")
                    .withAliases(Arrays.asList("narxzxtheotus", "vyevcciqi", "nhungbw"))
                    .withApps(Arrays.asList("nfygxgispemvtz", "kufubljo", "xqeofjaeqjhqjba"))
                    .withMeta(new DatadogHostMetadata().withAgentVersion("smjqulngsntnbyb")
                        .withInstallMethod(new DatadogInstallMethod().withTool("cwrwclxxwrljdous")
                            .withToolVersion("qvkoc")
                            .withInstallerVersion("jdkwtnhxbnjb"))
                        .withLogsAgent(new DatadogLogsAgent().withTransport("qrglssainqpjwn"))),
                new DatadogHostInner().withName("ljfmppee")
                    .withAliases(Arrays.asList("gxsabkyq", "uujitcjc"))
                    .withApps(Arrays.asList("evndh", "rwpdappdsbdkvwrw", "feusnhut", "eltmrldhugjzzdat"))
                    .withMeta(new DatadogHostMetadata().withAgentVersion("oc")
                        .withInstallMethod(new DatadogInstallMethod().withTool("ablgphuticndvk")
                            .withToolVersion("zwyiftyhxhur")
                            .withInstallerVersion("ftyxolniw"))
                        .withLogsAgent(new DatadogLogsAgent().withTransport("ukjfkgiawxklr")))))
            .withNextLink("lwckbasyypnddhs");
        model = BinaryData.fromObject(model).toObject(DatadogHostListResponse.class);
        Assertions.assertEquals("qpsoacctazak", model.value().get(0).name());
        Assertions.assertEquals("ahbc", model.value().get(0).aliases().get(0));
        Assertions.assertEquals("rzevdphlxaol", model.value().get(0).apps().get(0));
        Assertions.assertEquals("elluwfziton", model.value().get(0).meta().agentVersion());
        Assertions.assertEquals("fpjkjlxofp", model.value().get(0).meta().installMethod().tool());
        Assertions.assertEquals("hpf", model.value().get(0).meta().installMethod().toolVersion());
        Assertions.assertEquals("ypininm", model.value().get(0).meta().installMethod().installerVersion());
        Assertions.assertEquals("uybbkpodep", model.value().get(0).meta().logsAgent().transport());
        Assertions.assertEquals("lwckbasyypnddhs", model.nextLink());
    }
}
