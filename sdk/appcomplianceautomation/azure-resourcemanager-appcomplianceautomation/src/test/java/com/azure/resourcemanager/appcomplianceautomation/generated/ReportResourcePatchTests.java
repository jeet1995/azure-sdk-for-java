// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcomplianceautomation.models.ReportPatchProperties;
import com.azure.resourcemanager.appcomplianceautomation.models.ReportResourcePatch;
import com.azure.resourcemanager.appcomplianceautomation.models.ResourceMetadata;
import com.azure.resourcemanager.appcomplianceautomation.models.ResourceOrigin;
import com.azure.resourcemanager.appcomplianceautomation.models.StorageInfo;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ReportResourcePatchTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ReportResourcePatch model = BinaryData.fromString(
            "{\"properties\":{\"triggerTime\":\"2021-05-02T19:00:13Z\",\"timeZone\":\"hltrpmopjmcmatuo\",\"resources\":[{\"resourceId\":\"fu\",\"resourceType\":\"aodsfcpkv\",\"resourceKind\":\"dpuozmyz\",\"resourceOrigin\":\"GCP\",\"accountId\":\"fuaxbe\"},{\"resourceId\":\"yiuokktwh\",\"resourceType\":\"xw\",\"resourceKind\":\"wqsmbsur\",\"resourceOrigin\":\"AWS\",\"accountId\":\"o\"},{\"resourceId\":\"yocf\",\"resourceType\":\"ksymd\",\"resourceKind\":\"stkiiuxhqyud\",\"resourceOrigin\":\"GCP\",\"accountId\":\"qn\"}],\"status\":\"Failed\",\"errors\":[\"vyifqrvkdvjsl\",\"rm\",\"vdfwatkpn\"],\"tenantId\":\"lexxbczwtru\",\"offerGuid\":\"qzbqjvsov\",\"nextTriggerTime\":\"2020-12-29T19:47:48Z\",\"lastTriggerTime\":\"2021-11-07T20:31:54Z\",\"subscriptions\":[\"pkwlhz\",\"obpxjmflbvvn\",\"hrk\",\"ciwwzjuqkhr\"],\"complianceStatus\":{\"m365\":{\"passedCount\":1410521625,\"failedCount\":481973669,\"manualCount\":1163138760,\"notApplicableCount\":627324313,\"pendingCount\":1637974204}},\"storageInfo\":{\"subscriptionId\":\"auu\",\"resourceGroup\":\"jmvxie\",\"accountName\":\"ugidyjrr\",\"location\":\"y\"},\"certRecords\":[{\"offerGuid\":\"e\",\"certificationStatus\":\"sonpclhocohs\",\"ingestionStatus\":\"ev\",\"controls\":[{\"controlId\":\"zfbuhf\",\"controlStatus\":\"faxkffeii\"},{\"controlId\":\"lvmezyvshxmzsbbz\",\"controlStatus\":\"gigr\"}]},{\"offerGuid\":\"burvjxxjnspy\",\"certificationStatus\":\"tko\",\"ingestionStatus\":\"kouknvudwtiu\",\"controls\":[{\"controlId\":\"ngkpocipazy\",\"controlStatus\":\"egukgjnpiucg\"},{\"controlId\":\"evqzntypmrbp\",\"controlStatus\":\"c\"},{\"controlId\":\"qjsdpydnfyhxdeo\",\"controlStatus\":\"zi\"}]},{\"offerGuid\":\"ifsjttgzfbishcb\",\"certificationStatus\":\"ajdeyeamdphaga\",\"ingestionStatus\":\"buxwgip\",\"controls\":[{\"controlId\":\"ow\",\"controlStatus\":\"shwankixzbinje\"},{\"controlId\":\"ttmrywnuzoqf\",\"controlStatus\":\"yqzrnkcqvyxlw\"}]},{\"offerGuid\":\"lsicohoqqnwv\",\"certificationStatus\":\"yav\",\"ingestionStatus\":\"heun\",\"controls\":[{\"controlId\":\"gyxzk\",\"controlStatus\":\"ocukoklyax\"},{\"controlId\":\"onuq\",\"controlStatus\":\"fkbey\"},{\"controlId\":\"wrmjmwvvjektc\",\"controlStatus\":\"enhwlrs\"},{\"controlId\":\"rzpwvlqdqgbiq\",\"controlStatus\":\"ihkaetcktvfc\"}]}],\"provisioningState\":\"Deleting\"}}")
            .toObject(ReportResourcePatch.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-02T19:00:13Z"), model.properties().triggerTime());
        Assertions.assertEquals("hltrpmopjmcmatuo", model.properties().timeZone());
        Assertions.assertEquals("fu", model.properties().resources().get(0).resourceId());
        Assertions.assertEquals("aodsfcpkv", model.properties().resources().get(0).resourceType());
        Assertions.assertEquals("dpuozmyz", model.properties().resources().get(0).resourceKind());
        Assertions.assertEquals(ResourceOrigin.GCP, model.properties().resources().get(0).resourceOrigin());
        Assertions.assertEquals("fuaxbe", model.properties().resources().get(0).accountId());
        Assertions.assertEquals("qzbqjvsov", model.properties().offerGuid());
        Assertions.assertEquals("auu", model.properties().storageInfo().subscriptionId());
        Assertions.assertEquals("jmvxie", model.properties().storageInfo().resourceGroup());
        Assertions.assertEquals("ugidyjrr", model.properties().storageInfo().accountName());
        Assertions.assertEquals("y", model.properties().storageInfo().location());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ReportResourcePatch model = new ReportResourcePatch()
            .withProperties(new ReportPatchProperties().withTriggerTime(OffsetDateTime.parse("2021-05-02T19:00:13Z"))
                .withTimeZone("hltrpmopjmcmatuo")
                .withResources(Arrays.asList(
                    new ResourceMetadata().withResourceId("fu")
                        .withResourceType("aodsfcpkv")
                        .withResourceKind("dpuozmyz")
                        .withResourceOrigin(ResourceOrigin.GCP)
                        .withAccountId("fuaxbe"),
                    new ResourceMetadata().withResourceId("yiuokktwh")
                        .withResourceType("xw")
                        .withResourceKind("wqsmbsur")
                        .withResourceOrigin(ResourceOrigin.AWS)
                        .withAccountId("o"),
                    new ResourceMetadata().withResourceId("yocf")
                        .withResourceType("ksymd")
                        .withResourceKind("stkiiuxhqyud")
                        .withResourceOrigin(ResourceOrigin.GCP)
                        .withAccountId("qn")))
                .withOfferGuid("qzbqjvsov")
                .withStorageInfo(new StorageInfo().withSubscriptionId("auu")
                    .withResourceGroup("jmvxie")
                    .withAccountName("ugidyjrr")
                    .withLocation("y")));
        model = BinaryData.fromObject(model).toObject(ReportResourcePatch.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-02T19:00:13Z"), model.properties().triggerTime());
        Assertions.assertEquals("hltrpmopjmcmatuo", model.properties().timeZone());
        Assertions.assertEquals("fu", model.properties().resources().get(0).resourceId());
        Assertions.assertEquals("aodsfcpkv", model.properties().resources().get(0).resourceType());
        Assertions.assertEquals("dpuozmyz", model.properties().resources().get(0).resourceKind());
        Assertions.assertEquals(ResourceOrigin.GCP, model.properties().resources().get(0).resourceOrigin());
        Assertions.assertEquals("fuaxbe", model.properties().resources().get(0).accountId());
        Assertions.assertEquals("qzbqjvsov", model.properties().offerGuid());
        Assertions.assertEquals("auu", model.properties().storageInfo().subscriptionId());
        Assertions.assertEquals("jmvxie", model.properties().storageInfo().resourceGroup());
        Assertions.assertEquals("ugidyjrr", model.properties().storageInfo().accountName());
        Assertions.assertEquals("y", model.properties().storageInfo().location());
    }
}
