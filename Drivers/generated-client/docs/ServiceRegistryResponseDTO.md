

# ServiceRegistryResponseDTO


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createdAt** | **String** |  |  [optional] |
|**endOfValidity** | **String** |  |  [optional] |
|**id** | **Long** |  |  [optional] |
|**interfaces** | [**List&lt;ServiceInterfaceResponseDTO&gt;**](ServiceInterfaceResponseDTO.md) |  |  [optional] |
|**metadata** | **Map&lt;String, String&gt;** |  |  [optional] |
|**provider** | [**SystemResponseDTO**](SystemResponseDTO.md) |  |  [optional] |
|**secure** | [**SecureEnum**](#SecureEnum) |  |  [optional] |
|**serviceDefinition** | [**ServiceDefinitionResponseDTO**](ServiceDefinitionResponseDTO.md) |  |  [optional] |
|**serviceUri** | **String** |  |  [optional] |
|**updatedAt** | **String** |  |  [optional] |
|**version** | **Integer** |  |  [optional] |



## Enum: SecureEnum

| Name | Value |
|---- | -----|
| NOT_SECURE | &quot;NOT_SECURE&quot; |
| CERTIFICATE | &quot;CERTIFICATE&quot; |
| TOKEN | &quot;TOKEN&quot; |



