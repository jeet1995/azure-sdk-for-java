# Azure Communication Identity library for Java

> see https://aka.ms/autorest

This is the AutoRest configuration file for Communication Identity
---
## Getting Started

To build the SDK for Communication Identity library, simply [Install AutoRest](https://aka.ms/autorest) and in this folder, run:
> `autorest --java`

To see additional help and options, run:
> `autorest --help`

### Setup
```ps
npm install -g autorest
```

### Generation
```ps
cd <swagger-folder>
autorest --java
```

### Code generation settings
``` yaml
java: true
output-folder: ..\
use: '@autorest/java@4.1.52'
tag: package-2023-10
require: https://raw.githubusercontent.com/Azure/azure-rest-api-specs/5797d78f04cd8ca773be82d2c99a3294009b3f0a/specification/communication/data-plane/Identity/readme.md
add-context-parameter: true
license-header: MICROSOFT_MIT_SMALL
namespace: com.azure.communication.identity
custom-types: CommunicationTokenScope,GetTokenForTeamsUserOptions
custom-types-subpackage: models
models-subpackage: implementation.models
customization-class: src/main/java/TeamsUserExchangeTokenRequestCustomization.java
custom-strongly-typed-header-deserialization: true
generic-response-type: true
sync-methods: all
disable-client-builder: true
generate-client-as-impl: true
service-interface-as-public: true
context-client-method-parameter: true
enable-sync-stack: true
stream-style-serialization: true
directive:
- rename-model:
    from: TeamsUserExchangeTokenRequest
    to: GetTokenForTeamsUserOptions
```

### Rename CommunicationIdentityTokenScope to CommunicationTokenScope
```yaml
directive:
  - from: swagger-document
    where: $.definitions.CommunicationIdentityTokenScope
    transform: >
      $["x-ms-enum"].name = "CommunicationTokenScope";
```

### Directive changing GetTokenForTeamsUserOptions to required properties and use x-ms-client-name
```yaml
directive:
  - from: swagger-document
    where: $.definitions.GetTokenForTeamsUserOptions
    transform: >
      $.required = [ "token", "appId", "userId" ];
        
      $.properties.token["x-ms-client-name"] = "teamsUserAadToken";
      $.properties.token.description = "Azure AD access token of a Teams User.";
      
      $.properties.appId["x-ms-client-name"] = "clientId";
      $.properties.appId.description = "Client ID of an Azure AD application.";
        
      $.properties.userId["x-ms-client-name"] = "userObjectId";
      $.properties.userId.description = "Object ID of an Azure AD user (Teams User).";
```
