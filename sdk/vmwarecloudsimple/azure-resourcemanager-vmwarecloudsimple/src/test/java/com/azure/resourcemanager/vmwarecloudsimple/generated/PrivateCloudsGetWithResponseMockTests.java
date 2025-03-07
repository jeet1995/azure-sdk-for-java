// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.vmwarecloudsimple.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.vmwarecloudsimple.VMwareCloudSimpleManager;
import com.azure.resourcemanager.vmwarecloudsimple.models.DiskIndependenceMode;
import com.azure.resourcemanager.vmwarecloudsimple.models.NicType;
import com.azure.resourcemanager.vmwarecloudsimple.models.PrivateCloud;
import com.azure.resourcemanager.vmwarecloudsimple.models.PrivateCloudResourceType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PrivateCloudsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"id\":\"muvapc\",\"location\":\"crrvweyo\",\"name\":\"yyukphaimmo\",\"properties\":{\"availabilityZoneId\":\"qboshbra\",\"availabilityZoneName\":\"pyyrmfs\",\"clustersNumber\":1124301207,\"createdBy\":\"vbopfppdbwnu\",\"createdOn\":\"2021-04-08T07:12:52Z\",\"dnsServers\":[\"kuma\",\"jcaacfdmmcpugm\",\"hqepvufhbzehewh\"],\"expires\":\"hnl\",\"nsxType\":\"nbldxeaclgschori\",\"placementGroupId\":\"rsrrmoucsofldp\",\"placementGroupName\":\"iyfc\",\"privateCloudId\":\"f932da77-1b6e-45d6-9908-7a16c324caca\",\"resourcePools\":[{\"id\":\"olhbhlvb\",\"location\":\"uqibsxtkcu\",\"name\":\"b\",\"privateCloudId\":\"arfsi\",\"properties\":{\"fullName\":\"kjxnqpvwgfstmhq\"},\"type\":\"izmdksa\"},{\"id\":\"afclu\",\"location\":\"oxmycjimryvw\",\"name\":\"wwpbmzgwesyd\",\"privateCloudId\":\"wefohecbvo\",\"properties\":{\"fullName\":\"dy\"},\"type\":\"eallklmtkhlo\"},{\"id\":\"kxxpvbrd\",\"location\":\"mzsyzfhotl\",\"name\":\"k\",\"privateCloudId\":\"ychunsjlpjrtwszh\",\"properties\":{\"fullName\":\"icphvtrrmhw\"},\"type\":\"fdpyflubh\"}],\"state\":\"glrocuy\",\"totalCpuCores\":392377022,\"totalNodes\":939893099,\"totalRam\":1008806240,\"totalStorage\":27.548378,\"type\":\"oclu\",\"vSphereVersion\":\"pqmem\",\"vcenterFqdn\":\"jk\",\"vcenterRefid\":\"ykyujxsg\",\"virtualMachineTemplates\":[{\"id\":\"rryejylmbkzudnig\",\"location\":\"ihotjewlpxuzzjg\",\"name\":\"efqyhqotoihiqaky\",\"properties\":{\"amountOfRam\":430469096,\"controllers\":[{},{},{},{}],\"description\":\"wpzdqtvhcspo\",\"disks\":[{\"controllerId\":\"axsipietgb\",\"independenceMode\":\"independent_persistent\",\"totalSize\":180957950},{\"controllerId\":\"fulbmoichdl\",\"independenceMode\":\"persistent\",\"totalSize\":540172830},{\"controllerId\":\"pubntnbatz\",\"independenceMode\":\"independent_persistent\",\"totalSize\":331637296},{\"controllerId\":\"sowsaael\",\"independenceMode\":\"independent_nonpersistent\",\"totalSize\":1574672504}],\"exposeToGuestVM\":true,\"guestOS\":\"uhplrvkmjcwmjv\",\"guestOSType\":\"fggc\",\"nics\":[{\"network\":{\"id\":\"y\"},\"nicType\":\"VMXNET3\"},{\"network\":{\"id\":\"zrzbjpsfxs\"},\"nicType\":\"VMXNET\"}],\"numberOfCores\":524820191,\"path\":\"vtmva\",\"privateCloudId\":\"bwidql\",\"vSphereNetworks\":[\"koveof\",\"zrvjfnmjmvlwyzgi\"],\"vSphereTags\":[\"ujr\",\"lfojuidjp\",\"uyjucejikzo\"],\"vmwaretools\":\"vvtzejetjkl\"},\"type\":\"ikyju\"},{\"id\":\"dbqzolxrzvhqjw\",\"location\":\"htgv\",\"name\":\"pcrrk\",\"properties\":{\"amountOfRam\":45429072,\"controllers\":[{},{}],\"description\":\"smwr\",\"disks\":[{\"controllerId\":\"dxfzzzwyjaf\",\"independenceMode\":\"persistent\",\"totalSize\":1608821330},{\"controllerId\":\"hguynuchlgmltxdw\",\"independenceMode\":\"persistent\",\"totalSize\":1378933217},{\"controllerId\":\"zusg\",\"independenceMode\":\"independent_persistent\",\"totalSize\":404477623},{\"controllerId\":\"ns\",\"independenceMode\":\"independent_nonpersistent\",\"totalSize\":1718523407}],\"exposeToGuestVM\":true,\"guestOS\":\"afolpymwamxqzrag\",\"guestOSType\":\"dphtv\",\"nics\":[{\"network\":{\"id\":\"a\"},\"nicType\":\"VMXNET3\"}],\"numberOfCores\":254887878,\"path\":\"c\",\"privateCloudId\":\"csrlzknmzl\",\"vSphereNetworks\":[\"updwv\",\"phcnzqtpj\",\"mqrhvthl\",\"iwdcxsmlzzhzd\"],\"vSphereTags\":[\"tlgy\",\"lhqvlnnpxybafi\",\"geaar\",\"gjekglklby\"],\"vmwaretools\":\"idwcwvmzegjon\"},\"type\":\"jirwgdnqzbrfk\"},{\"id\":\"zhzmtksjci\",\"location\":\"igsxcdgljplk\",\"name\":\"acht\",\"properties\":{\"amountOfRam\":1256156886,\"controllers\":[{},{}],\"description\":\"swfpfmd\",\"disks\":[{\"controllerId\":\"xnm\",\"independenceMode\":\"independent_nonpersistent\",\"totalSize\":2063610896},{\"controllerId\":\"hqjjys\",\"independenceMode\":\"independent_nonpersistent\",\"totalSize\":2039393552},{\"controllerId\":\"lpshhkvpedwqslsr\",\"independenceMode\":\"persistent\",\"totalSize\":417828449},{\"controllerId\":\"qvwwsko\",\"independenceMode\":\"persistent\",\"totalSize\":1319536198}],\"exposeToGuestVM\":false,\"guestOS\":\"imuvqejosovyrrl\",\"guestOSType\":\"esi\",\"nics\":[{\"network\":{\"id\":\"tljqobbpih\"},\"nicType\":\"PCNET32\"},{\"network\":{\"id\":\"cecybmrqbrjbbmpx\"},\"nicType\":\"E1000E\"},{\"network\":{\"id\":\"vykfrexcrse\"},\"nicType\":\"VMXNET2\"},{\"network\":{\"id\":\"jksghudg\"},\"nicType\":\"VMXNET\"}],\"numberOfCores\":1903316554,\"path\":\"jggsvo\",\"privateCloudId\":\"jkxibda\",\"vSphereNetworks\":[\"kmdyomkxfbvfbh\",\"y\"],\"vSphereTags\":[\"pwpgddei\",\"awzovgkk\",\"muikjcjcaztbws\",\"sqowxwc\"],\"vmwaretools\":\"likytwvczcswka\"},\"type\":\"ejyfdvlvhbwrnfx\"},{\"id\":\"ddpqt\",\"location\":\"hn\",\"name\":\"aoyankcoeqswa\",\"properties\":{\"amountOfRam\":41999694,\"controllers\":[{},{},{}],\"description\":\"hdroznnh\",\"disks\":[{\"controllerId\":\"ktgj\",\"independenceMode\":\"independent_nonpersistent\",\"totalSize\":677941744},{\"controllerId\":\"guxhem\",\"independenceMode\":\"persistent\",\"totalSize\":13572541}],\"exposeToGuestVM\":false,\"guestOS\":\"eczgfb\",\"guestOSType\":\"klelssxb\",\"nics\":[{\"network\":{\"id\":\"sxz\"},\"nicType\":\"PCNET32\"}],\"numberOfCores\":1446003697,\"path\":\"lsmdesqplpvmjc\",\"privateCloudId\":\"oewbid\",\"vSphereNetworks\":[\"eowxvgpi\"],\"vSphereTags\":[\"ugfsxzecpaxwk\"],\"vmwaretools\":\"ykhv\"},\"type\":\"xepmrut\"}],\"virtualNetworks\":[{\"assignable\":false,\"id\":\"obns\",\"location\":\"jdjltymkmvgui\",\"name\":\"wartspphkixkykxd\",\"properties\":{\"privateCloudId\":\"pemmucfxhik\"},\"type\":\"lrmymyincqlhri\"},{\"assignable\":false,\"id\":\"lmiiiovg\",\"location\":\"gxuugqkctotio\",\"name\":\"xteqdptjgwdtg\",\"properties\":{\"privateCloudId\":\"anblwphqlkccu\"},\"type\":\"ygqwahoiu\"},{\"assignable\":true,\"id\":\"niiprglvaw\",\"location\":\"z\",\"name\":\"fypiv\",\"properties\":{\"privateCloudId\":\"bjpmcubk\"},\"type\":\"foxx\"},{\"assignable\":false,\"id\":\"v\",\"location\":\"avp\",\"name\":\"brbqgvgovp\",\"properties\":{\"privateCloudId\":\"tefjoknssqyzq\"},\"type\":\"ik\"}],\"vrOpsEnabled\":true},\"type\":\"Microsoft.VMwareCloudSimple/privateClouds\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        VMwareCloudSimpleManager manager = VMwareCloudSimpleManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PrivateCloud response
            = manager.privateClouds().getWithResponse("d", "ibidmhmwffp", com.azure.core.util.Context.NONE).getValue();

        Assertions.assertEquals("muvapc", response.id());
        Assertions.assertEquals("crrvweyo", response.location());
        Assertions.assertEquals("yyukphaimmo", response.name());
        Assertions.assertEquals(PrivateCloudResourceType.MICROSOFT_VMWARE_CLOUD_SIMPLE_PRIVATE_CLOUDS, response.type());
        Assertions.assertEquals("qboshbra", response.availabilityZoneId());
        Assertions.assertEquals("pyyrmfs", response.availabilityZoneName());
        Assertions.assertEquals(1124301207, response.clustersNumber());
        Assertions.assertEquals("vbopfppdbwnu", response.createdBy());
        Assertions.assertEquals(OffsetDateTime.parse("2021-04-08T07:12:52Z"), response.createdOn());
        Assertions.assertEquals("kuma", response.dnsServers().get(0));
        Assertions.assertEquals("hnl", response.expires());
        Assertions.assertEquals("nbldxeaclgschori", response.nsxType());
        Assertions.assertEquals("rsrrmoucsofldp", response.placementGroupId());
        Assertions.assertEquals("iyfc", response.placementGroupName());
        Assertions.assertEquals(UUID.fromString("f932da77-1b6e-45d6-9908-7a16c324caca"), response.privateCloudId());
        Assertions.assertEquals("olhbhlvb", response.resourcePools().get(0).id());
        Assertions.assertEquals("glrocuy", response.state());
        Assertions.assertEquals(392377022, response.totalCpuCores());
        Assertions.assertEquals(939893099, response.totalNodes());
        Assertions.assertEquals(1008806240, response.totalRam());
        Assertions.assertEquals(27.548378F, response.totalStorage());
        Assertions.assertEquals("oclu", response.typePropertiesType());
        Assertions.assertEquals("pqmem", response.vSphereVersion());
        Assertions.assertEquals("jk", response.vcenterFqdn());
        Assertions.assertEquals("ykyujxsg", response.vcenterRefid());
        Assertions.assertEquals("ihotjewlpxuzzjg", response.virtualMachineTemplates().get(0).location());
        Assertions.assertEquals(430469096, response.virtualMachineTemplates().get(0).amountOfRam());
        Assertions.assertEquals("wpzdqtvhcspo", response.virtualMachineTemplates().get(0).description());
        Assertions.assertEquals("axsipietgb", response.virtualMachineTemplates().get(0).disks().get(0).controllerId());
        Assertions.assertEquals(DiskIndependenceMode.INDEPENDENT_PERSISTENT,
            response.virtualMachineTemplates().get(0).disks().get(0).independenceMode());
        Assertions.assertEquals(180957950, response.virtualMachineTemplates().get(0).disks().get(0).totalSize());
        Assertions.assertEquals(true, response.virtualMachineTemplates().get(0).exposeToGuestVM());
        Assertions.assertEquals("y", response.virtualMachineTemplates().get(0).nics().get(0).network().id());
        Assertions.assertEquals(NicType.VMXNET3, response.virtualMachineTemplates().get(0).nics().get(0).nicType());
        Assertions.assertEquals(524820191, response.virtualMachineTemplates().get(0).numberOfCores());
        Assertions.assertEquals("vtmva", response.virtualMachineTemplates().get(0).path());
        Assertions.assertEquals("bwidql", response.virtualMachineTemplates().get(0).privateCloudId());
        Assertions.assertEquals("koveof", response.virtualMachineTemplates().get(0).vSphereNetworks().get(0));
        Assertions.assertEquals("ujr", response.virtualMachineTemplates().get(0).vSphereTags().get(0));
        Assertions.assertEquals("obns", response.virtualNetworks().get(0).id());
        Assertions.assertEquals(true, response.vrOpsEnabled());
    }
}
