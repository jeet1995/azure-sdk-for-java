// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sqlvirtualmachine.implementation;

import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.sqlvirtualmachine.fluent.SqlVirtualMachineTroubleshootsClient;
import com.azure.resourcemanager.sqlvirtualmachine.fluent.models.SqlVmTroubleshootingInner;
import com.azure.resourcemanager.sqlvirtualmachine.models.SqlVirtualMachineTroubleshoots;
import com.azure.resourcemanager.sqlvirtualmachine.models.SqlVmTroubleshooting;

public final class SqlVirtualMachineTroubleshootsImpl implements SqlVirtualMachineTroubleshoots {
    private static final ClientLogger LOGGER = new ClientLogger(SqlVirtualMachineTroubleshootsImpl.class);

    private final SqlVirtualMachineTroubleshootsClient innerClient;

    private final com.azure.resourcemanager.sqlvirtualmachine.SqlVirtualMachineManager serviceManager;

    public SqlVirtualMachineTroubleshootsImpl(
        SqlVirtualMachineTroubleshootsClient innerClient,
        com.azure.resourcemanager.sqlvirtualmachine.SqlVirtualMachineManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public SqlVmTroubleshooting troubleshoot(
        String resourceGroupName, String sqlVirtualMachineName, SqlVmTroubleshootingInner parameters) {
        SqlVmTroubleshootingInner inner =
            this.serviceClient().troubleshoot(resourceGroupName, sqlVirtualMachineName, parameters);
        if (inner != null) {
            return new SqlVmTroubleshootingImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public SqlVmTroubleshooting troubleshoot(
        String resourceGroupName, String sqlVirtualMachineName, SqlVmTroubleshootingInner parameters, Context context) {
        SqlVmTroubleshootingInner inner =
            this.serviceClient().troubleshoot(resourceGroupName, sqlVirtualMachineName, parameters, context);
        if (inner != null) {
            return new SqlVmTroubleshootingImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private SqlVirtualMachineTroubleshootsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.sqlvirtualmachine.SqlVirtualMachineManager manager() {
        return this.serviceManager;
    }
}