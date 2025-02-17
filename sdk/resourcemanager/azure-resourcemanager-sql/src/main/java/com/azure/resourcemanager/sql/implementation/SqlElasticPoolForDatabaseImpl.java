// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.sql.implementation;

import com.azure.resourcemanager.sql.models.ElasticPoolSku;
import com.azure.resourcemanager.sql.models.Sku;
import com.azure.resourcemanager.sql.models.SqlDatabaseOperations;
import com.azure.resourcemanager.sql.models.SqlElasticPool;
import com.azure.resourcemanager.sql.models.SqlElasticPoolBasicEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolBasicMaxEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolBasicMinEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolPremiumEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolPremiumMaxEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolPremiumMinEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolPremiumSorage;
import com.azure.resourcemanager.sql.models.SqlElasticPoolStandardEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolStandardMaxEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolStandardMinEDTUs;
import com.azure.resourcemanager.sql.models.SqlElasticPoolStandardStorage;

/** Implementation for SqlElasticPool as inline definition inside a SqlDatabase definition. */
public class SqlElasticPoolForDatabaseImpl implements
    SqlElasticPool.SqlElasticPoolDefinition<SqlDatabaseOperations.DefinitionStages.WithExistingDatabaseAfterElasticPool> {

    private SqlElasticPoolImpl sqlElasticPool;
    private SqlDatabaseImpl sqlDatabase;

    SqlElasticPoolForDatabaseImpl(SqlDatabaseImpl sqlDatabase, SqlElasticPoolImpl sqlElasticPool) {
        this.sqlDatabase = sqlDatabase;
        this.sqlElasticPool = sqlElasticPool;
    }

    @Override
    public SqlDatabaseImpl attach() {
        this.sqlDatabase.addParentDependency(this.sqlElasticPool);
        return this.sqlDatabase;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withSku(ElasticPoolSku sku) {
        this.sqlElasticPool.withSku(sku);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withSku(Sku sku) {
        this.sqlElasticPool.withSku(sku);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withBasicPool() {
        this.sqlElasticPool.withBasicPool();
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withStandardPool() {
        this.sqlElasticPool.withStandardPool();
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withPremiumPool() {
        this.sqlElasticPool.withPremiumPool();
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withReservedDtu(SqlElasticPoolBasicEDTUs eDTU) {
        this.sqlElasticPool.withReservedDtu(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseDtuMax(SqlElasticPoolBasicMaxEDTUs eDTU) {
        this.sqlElasticPool.withDatabaseDtuMax(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseDtuMin(SqlElasticPoolBasicMinEDTUs eDTU) {
        this.sqlElasticPool.withDatabaseDtuMin(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withReservedDtu(SqlElasticPoolStandardEDTUs eDTU) {
        this.sqlElasticPool.withReservedDtu(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseDtuMax(SqlElasticPoolStandardMaxEDTUs eDTU) {
        this.sqlElasticPool.withDatabaseDtuMax(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseDtuMin(SqlElasticPoolStandardMinEDTUs eDTU) {
        this.sqlElasticPool.withDatabaseDtuMin(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withStorageCapacity(SqlElasticPoolStandardStorage storageCapacity) {
        this.sqlElasticPool.withStorageCapacity(storageCapacity);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withReservedDtu(SqlElasticPoolPremiumEDTUs eDTU) {
        this.sqlElasticPool.withReservedDtu(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseDtuMax(SqlElasticPoolPremiumMaxEDTUs eDTU) {
        this.sqlElasticPool.withDatabaseDtuMax(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseDtuMin(SqlElasticPoolPremiumMinEDTUs eDTU) {
        this.sqlElasticPool.withDatabaseDtuMin(eDTU);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withStorageCapacity(SqlElasticPoolPremiumSorage storageCapacity) {
        this.sqlElasticPool.withStorageCapacity(storageCapacity);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseMinCapacity(double minCapacity) {
        this.sqlElasticPool.withDatabaseMinCapacity(minCapacity);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withDatabaseMaxCapacity(double maxCapacity) {
        this.sqlElasticPool.withDatabaseMaxCapacity(maxCapacity);
        return this;
    }

    @Override
    public SqlElasticPoolForDatabaseImpl withStorageCapacity(Long storageCapacity) {
        this.sqlElasticPool.withStorageCapacity(storageCapacity);
        return this;
    }
}
