# Release History

## 1.2.0-beta.1 (Unreleased)

### Features Added

### Breaking Changes

### Bugs Fixed

### Other Changes

## 1.1.0 (2025-06-11)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2024-06-01. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

#### `models.ConfigurationStoreUpdateParameters` was modified

* `withDefaultKeyValueRevisionRetentionPeriodInSeconds(java.lang.Long)` was added
* `defaultKeyValueRevisionRetentionPeriodInSeconds()` was added

#### `models.ConfigurationStore$Definition` was modified

* `withDefaultKeyValueRevisionRetentionPeriodInSeconds(java.lang.Long)` was added

#### `models.ConfigurationStore$Update` was modified

* `withDefaultKeyValueRevisionRetentionPeriodInSeconds(java.lang.Long)` was added

#### `models.ConfigurationStore` was modified

* `defaultKeyValueRevisionRetentionPeriodInSeconds()` was added

## 1.0.0 (2024-11-20)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2024-05-01. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

* `models.Snapshot$DefinitionStages` was added

* `models.AuthenticationMode` was added

* `models.Snapshot$Definition` was added

* `models.DataPlaneProxyProperties` was added

* `models.Snapshots` was added

* `models.PrivateLinkDelegation` was added

* `models.KeyValueFilter` was added

* `models.Snapshot` was added

* `models.SnapshotStatus` was added

* `models.CompositionType` was added

#### `models.RegenerateKeyParameters` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.PrivateLinkServiceConnectionState` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.ConfigurationStoreUpdateParameters` was modified

* `dataPlaneProxy()` was added
* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added
* `withDataPlaneProxy(models.DataPlaneProxyProperties)` was added

#### `models.ApiKeyListResult` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.OperationDefinitionDisplay` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.PrivateLinkResourceListResult` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.ServiceSpecification` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.PrivateEndpoint` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.ConfigurationStoreListResult` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.ResourceIdentity` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.OperationDefinitionListResult` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.MetricDimension` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.ReplicaListResult` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.ConfigurationStore$Definition` was modified

* `withDataPlaneProxy(models.DataPlaneProxyProperties)` was added

#### `models.MetricSpecification` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.UserIdentity` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.CheckNameAvailabilityParameters` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.ConfigurationStore$Update` was modified

* `withDataPlaneProxy(models.DataPlaneProxyProperties)` was added

#### `models.Sku` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.EncryptionProperties` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.KeyVaultProperties` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.ConfigurationStore` was modified

* `dataPlaneProxy()` was added

#### `models.OperationProperties` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `models.PrivateEndpointConnectionReference` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.PrivateEndpointConnectionListResult` was modified

* `toJson(com.azure.json.JsonWriter)` was added
* `fromJson(com.azure.json.JsonReader)` was added

#### `models.LogSpecification` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

#### `AppConfigurationManager` was modified

* `snapshots()` was added

#### `models.DeletedConfigurationStoreListResult` was modified

* `fromJson(com.azure.json.JsonReader)` was added
* `toJson(com.azure.json.JsonWriter)` was added

## 1.0.0-beta.7 (2023-04-28)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2023-03-01. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Breaking Changes

* `models.KeyValueListResult` was removed

#### `models.KeyValues` was modified

* `listByConfigurationStore(java.lang.String,java.lang.String)` was removed
* `listByConfigurationStore(java.lang.String,java.lang.String,java.lang.String,com.azure.core.util.Context)` was removed

### Features Added

* `models.Replica$DefinitionStages` was added

* `models.ReplicaListResult` was added

* `models.Replica` was added

* `models.Replicas` was added

* `models.ReplicaProvisioningState` was added

* `models.Replica$Definition` was added

#### `AppConfigurationManager` was modified

* `replicas()` was added

## 1.0.0-beta.6 (2022-06-08)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2022-05-01. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

#### `AppConfigurationManager$Configurable` was modified

* `withRetryOptions(com.azure.core.http.policy.RetryOptions)` was added

#### `models.ConfigurationStore` was modified

* `resourceGroupName()` was added

#### `models.PrivateEndpointConnection` was modified

* `resourceGroupName()` was added

#### `AppConfigurationManager` was modified

* `authenticate(com.azure.core.http.HttpPipeline,com.azure.core.management.profile.AzureProfile)` was added

#### `models.KeyValue` was modified

* `resourceGroupName()` was added

## 1.0.0-beta.5 (2022-02-28)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2021-10-01-preview. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

#### `models.ConfigurationStore$Update` was modified

* `withEnablePurgeProtection(java.lang.Boolean)` was added

#### `models.ConfigurationStoreUpdateParameters` was modified

* `enablePurgeProtection()` was added
* `withEnablePurgeProtection(java.lang.Boolean)` was added

## 1.0.0-beta.4 (2022-02-17)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2021-10-01-preview. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

* `models.CreateMode` was added

* `models.DeletedConfigurationStore` was added

* `models.DeletedConfigurationStoreListResult` was added

#### `models.Operations` was modified

* `regionalCheckNameAvailabilityWithResponse(java.lang.String,models.CheckNameAvailabilityParameters,com.azure.core.util.Context)` was added
* `regionalCheckNameAvailability(java.lang.String,models.CheckNameAvailabilityParameters)` was added

#### `models.ConfigurationStore` was modified

* `createMode()` was added
* `enablePurgeProtection()` was added
* `softDeleteRetentionInDays()` was added

#### `models.ConfigurationStores` was modified

* `getDeletedWithResponse(java.lang.String,java.lang.String,com.azure.core.util.Context)` was added
* `purgeDeleted(java.lang.String,java.lang.String)` was added
* `listDeleted()` was added
* `listDeleted(com.azure.core.util.Context)` was added
* `purgeDeleted(java.lang.String,java.lang.String,com.azure.core.util.Context)` was added
* `getDeleted(java.lang.String,java.lang.String)` was added

#### `models.ConfigurationStore$Definition` was modified

* `withCreateMode(models.CreateMode)` was added
* `withEnablePurgeProtection(java.lang.Boolean)` was added
* `withSoftDeleteRetentionInDays(java.lang.Integer)` was added

## 1.0.0-beta.3 (2021-07-09)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2021-03-01-preview. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Features Added

#### `models.ConfigurationStore$Update` was modified

* `withPublicNetworkAccess(models.PublicNetworkAccess)` was added

#### `models.ConfigurationStoreUpdateParameters` was modified

* `publicNetworkAccess()` was added
* `withPublicNetworkAccess(models.PublicNetworkAccess)` was added

#### `AppConfigurationManager$Configurable` was modified

* `withScope(java.lang.String)` was added

## 1.0.0-beta.2 (2021-05-14)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2021-03-01-preview. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).

### Breaking Change

* `models.ListKeyValueParameters` was removed

#### `models.ConfigurationStore$Update` was modified

* `withPublicNetworkAccess(models.PublicNetworkAccess)` was removed

#### `models.ConfigurationStoreUpdateParameters` was modified

* `publicNetworkAccess()` was removed
* `withPublicNetworkAccess(models.PublicNetworkAccess)` was removed

#### `models.ConfigurationStore` was modified

* `listKeyValue(models.ListKeyValueParameters)` was removed
* `listKeyValueWithResponse(models.ListKeyValueParameters,com.azure.core.util.Context)` was removed

#### `models.ConfigurationStores` was modified

* `listKeyValue(java.lang.String,java.lang.String,models.ListKeyValueParameters)` was removed
* `listKeyValueWithResponse(java.lang.String,java.lang.String,models.ListKeyValueParameters,com.azure.core.util.Context)` was removed

### New Feature

* `models.KeyValue$Definition` was added

* `models.KeyValue$UpdateStages` was added

* `models.ServiceSpecification` was added

* `models.OperationProperties` was added

* `models.KeyValues` was added

* `models.LogSpecification` was added

* `models.MetricDimension` was added

* `models.KeyValueListResult` was added

* `models.KeyValue$Update` was added

* `models.KeyValue$DefinitionStages` was added

* `models.MetricSpecification` was added

#### `models.ConfigurationStore$Update` was modified

* `withDisableLocalAuth(java.lang.Boolean)` was added

#### `models.ConfigurationStoreUpdateParameters` was modified

* `withDisableLocalAuth(java.lang.Boolean)` was added
* `disableLocalAuth()` was added

#### `models.OperationDefinition` was modified

* `properties()` was added
* `isDataAction()` was added
* `origin()` was added

#### `models.ConfigurationStore` was modified

* `systemData()` was added
* `disableLocalAuth()` was added

#### `AppConfigurationManager` was modified

* `keyValues()` was added

#### `models.ConfigurationStore$Definition` was modified

* `withDisableLocalAuth(java.lang.Boolean)` was added

#### `models.KeyValue` was modified

* `refresh(com.azure.core.util.Context)` was added
* `type()` was added
* `refresh()` was added
* `name()` was added
* `id()` was added
* `update()` was added

## 1.0.0-beta.1 (2021-04-12)

- Azure Resource Manager AppConfiguration client library for Java. This package contains Microsoft Azure SDK for AppConfiguration Management SDK.  Package tag package-2020-06-01. For documentation on how to use this package, please see [Azure Management Libraries for Java](https://aka.ms/azsdk/java/mgmt).
