// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.oracledatabase.models.ConnectionStringType;
import com.azure.resourcemanager.oracledatabase.models.ConsumerGroup;
import com.azure.resourcemanager.oracledatabase.models.HostFormatType;
import com.azure.resourcemanager.oracledatabase.models.ProtocolType;
import com.azure.resourcemanager.oracledatabase.models.SessionModeType;
import com.azure.resourcemanager.oracledatabase.models.SyntaxFormatType;
import com.azure.resourcemanager.oracledatabase.models.TlsAuthenticationType;
import org.junit.jupiter.api.Assertions;

public final class ConnectionStringTypeTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ConnectionStringType model = BinaryData.fromString(
            "{\"allConnectionStrings\":{\"high\":\"gufhyaomtbg\",\"low\":\"avgrvkffovjz\",\"medium\":\"jbibg\"},\"dedicated\":\"fxumv\",\"high\":\"luyovwxnbkfezzx\",\"low\":\"yhwzdgiruj\",\"medium\":\"bomvzzbtdcqv\",\"profiles\":[{\"consumerGroup\":\"Medium\",\"displayName\":\"jviylwdshfs\",\"hostFormat\":\"Fqdn\",\"isRegional\":false,\"protocol\":\"TCP\",\"sessionMode\":\"Direct\",\"syntaxFormat\":\"Ezconnectplus\",\"tlsAuthentication\":\"Mutual\",\"value\":\"ymsgaojfmwnc\"},{\"consumerGroup\":\"Medium\",\"displayName\":\"rfh\",\"hostFormat\":\"Fqdn\",\"isRegional\":true,\"protocol\":\"TCPS\",\"sessionMode\":\"Direct\",\"syntaxFormat\":\"Long\",\"tlsAuthentication\":\"Mutual\",\"value\":\"ftpipiwyczu\"},{\"consumerGroup\":\"Low\",\"displayName\":\"cpqjlihhyu\",\"hostFormat\":\"Ip\",\"isRegional\":false,\"protocol\":\"TCP\",\"sessionMode\":\"Redirect\",\"syntaxFormat\":\"Long\",\"tlsAuthentication\":\"Server\",\"value\":\"mfwdgzxu\"},{\"consumerGroup\":\"Medium\",\"displayName\":\"vpa\",\"hostFormat\":\"Fqdn\",\"isRegional\":true,\"protocol\":\"TCP\",\"sessionMode\":\"Direct\",\"syntaxFormat\":\"Ezconnect\",\"tlsAuthentication\":\"Mutual\",\"value\":\"urisjnhnytxifqj\"}]}")
            .toObject(ConnectionStringType.class);
        Assertions.assertEquals("gufhyaomtbg", model.allConnectionStrings().high());
        Assertions.assertEquals("avgrvkffovjz", model.allConnectionStrings().low());
        Assertions.assertEquals("jbibg", model.allConnectionStrings().medium());
        Assertions.assertEquals("fxumv", model.dedicated());
        Assertions.assertEquals("luyovwxnbkfezzx", model.high());
        Assertions.assertEquals("yhwzdgiruj", model.low());
        Assertions.assertEquals("bomvzzbtdcqv", model.medium());
        Assertions.assertEquals(ConsumerGroup.MEDIUM, model.profiles().get(0).consumerGroup());
        Assertions.assertEquals("jviylwdshfs", model.profiles().get(0).displayName());
        Assertions.assertEquals(HostFormatType.FQDN, model.profiles().get(0).hostFormat());
        Assertions.assertFalse(model.profiles().get(0).isRegional());
        Assertions.assertEquals(ProtocolType.TCP, model.profiles().get(0).protocol());
        Assertions.assertEquals(SessionModeType.DIRECT, model.profiles().get(0).sessionMode());
        Assertions.assertEquals(SyntaxFormatType.EZCONNECTPLUS, model.profiles().get(0).syntaxFormat());
        Assertions.assertEquals(TlsAuthenticationType.MUTUAL, model.profiles().get(0).tlsAuthentication());
        Assertions.assertEquals("ymsgaojfmwnc", model.profiles().get(0).value());
    }
}
