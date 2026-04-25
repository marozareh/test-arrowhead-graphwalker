

# ServiceQueryFormDTO


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**interfaceRequirements** | **List&lt;String&gt;** |  |  [optional] |
|**maxVersionRequirement** | **Integer** |  |  [optional] |
|**metadataRequirements** | **Map&lt;String, String&gt;** |  |  [optional] |
|**minVersionRequirement** | **Integer** |  |  [optional] |
|**pingProviders** | **Boolean** |  |  [optional] |
|**providerAddressTypeRequirements** | [**List&lt;ProviderAddressTypeRequirementsEnum&gt;**](#List&lt;ProviderAddressTypeRequirementsEnum&gt;) |  |  [optional] |
|**securityRequirements** | [**List&lt;SecurityRequirementsEnum&gt;**](#List&lt;SecurityRequirementsEnum&gt;) |  |  [optional] |
|**serviceDefinitionRequirement** | **String** |  |  [optional] |
|**versionRequirement** | **Integer** |  |  [optional] |



## Enum: List&lt;ProviderAddressTypeRequirementsEnum&gt;

| Name | Value |
|---- | -----|
| HOSTNAME | &quot;HOSTNAME&quot; |
| IPV4 | &quot;IPV4&quot; |
| IPV6 | &quot;IPV6&quot; |



## Enum: List&lt;SecurityRequirementsEnum&gt;

| Name | Value |
|---- | -----|
| NOT_SECURE | &quot;NOT_SECURE&quot; |
| CERTIFICATE | &quot;CERTIFICATE&quot; |
| TOKEN | &quot;TOKEN&quot; |



