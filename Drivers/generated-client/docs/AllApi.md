# AllApi

All URIs are relative to *http://localhost:8443*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addServiceDefinitionUsingPOST_0**](AllApi.md#addServiceDefinitionUsingPOST_0) | **POST** /serviceregistry/mgmt/services | Return created service definition |
| [**addServiceInterfaceUsingPOST_0**](AllApi.md#addServiceInterfaceUsingPOST_0) | **POST** /serviceregistry/mgmt/interfaces | Return created service interface |
| [**addServiceRegistryUsingPOST_0**](AllApi.md#addServiceRegistryUsingPOST_0) | **POST** /serviceregistry/mgmt | Registers a service |
| [**addSystemUsingPOST_0**](AllApi.md#addSystemUsingPOST_0) | **POST** /serviceregistry/mgmt/systems | Return created system  |
| [**echoServiceUsingGET_0**](AllApi.md#echoServiceUsingGET_0) | **GET** /serviceregistry/echo | Return an echo message with the purpose of testing the core service availability |
| [**getLogEntriesUsingGET_0**](AllApi.md#getLogEntriesUsingGET_0) | **GET** /serviceregistry/mgmt/logs | Return requested log entries by the given parameters |
| [**getServiceDefinitionByIdUsingGET_0**](AllApi.md#getServiceDefinitionByIdUsingGET_0) | **GET** /serviceregistry/mgmt/services/{id} | Return requested service definition |
| [**getServiceDefinitionsUsingGET_0**](AllApi.md#getServiceDefinitionsUsingGET_0) | **GET** /serviceregistry/mgmt/services | Return requested service definitions by the given parameters |
| [**getServiceInterfaceByIdUsingGET_0**](AllApi.md#getServiceInterfaceByIdUsingGET_0) | **GET** /serviceregistry/mgmt/interfaces/{id} | Return requested service interface |
| [**getServiceInterfacesUsingGET_0**](AllApi.md#getServiceInterfacesUsingGET_0) | **GET** /serviceregistry/mgmt/interfaces | Return requested service interfaces by the given parameters |
| [**getServiceRegistryEntriesByServiceDefinitionUsingGET_0**](AllApi.md#getServiceRegistryEntriesByServiceDefinitionUsingGET_0) | **GET** /serviceregistry/mgmt/servicedef/{serviceDefinition} | Return requested service registry entries by service definition based on the given parameters |
| [**getServiceRegistryEntriesBySystemIdUsingGET_0**](AllApi.md#getServiceRegistryEntriesBySystemIdUsingGET_0) | **GET** /serviceregistry/query/provider/{id} | Return service registry entries by system id |
| [**getServiceRegistryEntriesUsingGET1_0**](AllApi.md#getServiceRegistryEntriesUsingGET1_0) | **GET** /serviceregistry/query/all | Return all service registry entries |
| [**getServiceRegistryEntriesUsingGET_0**](AllApi.md#getServiceRegistryEntriesUsingGET_0) | **GET** /serviceregistry/mgmt | Return requested service registry entries by the given parameters |
| [**getServiceRegistryEntryByIdUsingGET_0**](AllApi.md#getServiceRegistryEntryByIdUsingGET_0) | **GET** /serviceregistry/mgmt/{id} | Return requested service registry entry |
| [**getServiceRegistryGroupedDataUsingGET_0**](AllApi.md#getServiceRegistryGroupedDataUsingGET_0) | **GET** /serviceregistry/mgmt/grouped | Return all service registry entries grouped for frontend usage |
| [**getSystemByIdUsingGET_0**](AllApi.md#getSystemByIdUsingGET_0) | **GET** /serviceregistry/mgmt/systems/{id} | Return system by id |
| [**getSystemsUsingGET_0**](AllApi.md#getSystemsUsingGET_0) | **GET** /serviceregistry/mgmt/systems | Return systems by request parameters |
| [**mergeServiceRegistryUsingPATCH_0**](AllApi.md#mergeServiceRegistryUsingPATCH_0) | **PATCH** /serviceregistry/mgmt/{id} | Merge/Patch a service |
| [**mergeSystemUsingPATCH_0**](AllApi.md#mergeSystemUsingPATCH_0) | **PATCH** /serviceregistry/mgmt/systems/{id} | Return system  updated by fields |
| [**multiQueryRegistryUsingPOST_0**](AllApi.md#multiQueryRegistryUsingPOST_0) | **POST** /serviceregistry/query/multi | Return Service Registry data that fits the specification |
| [**patchUpdateServiceDefinitionUsingPATCH_0**](AllApi.md#patchUpdateServiceDefinitionUsingPATCH_0) | **PATCH** /serviceregistry/mgmt/services/{id} | Return updated service definition |
| [**patchUpdateServiceInterfaceUsingPATCH_0**](AllApi.md#patchUpdateServiceInterfaceUsingPATCH_0) | **PATCH** /serviceregistry/mgmt/interfaces/{id} | Return updated service interface |
| [**pullConfigUsingGET_0**](AllApi.md#pullConfigUsingGET_0) | **GET** /serviceregistry/pull-config | Return some configuration of ServiceRegistry |
| [**pullSystemsUsingGET_0**](AllApi.md#pullSystemsUsingGET_0) | **GET** /serviceregistry/pull-systems | Return systems by request parameters |
| [**putUpdateServiceDefinitionUsingPUT_0**](AllApi.md#putUpdateServiceDefinitionUsingPUT_0) | **PUT** /serviceregistry/mgmt/services/{id} | Return updated service definition |
| [**putUpdateServiceInterfaceUsingPUT_0**](AllApi.md#putUpdateServiceInterfaceUsingPUT_0) | **PUT** /serviceregistry/mgmt/interfaces/{id} | Return updated service interface |
| [**queryRegistryBySystemDTOUsingPOST_0**](AllApi.md#queryRegistryBySystemDTOUsingPOST_0) | **POST** /serviceregistry/query/system | Return System by requested dto |
| [**queryRegistryBySystemIdUsingGET_0**](AllApi.md#queryRegistryBySystemIdUsingGET_0) | **GET** /serviceregistry/query/system/{id} | Return system by requested id |
| [**queryRegistryUsingPOST_0**](AllApi.md#queryRegistryUsingPOST_0) | **POST** /serviceregistry/query | Return Service Registry data that fits the specification |
| [**queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0**](AllApi.md#queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0) | **POST** /serviceregistry/query/definition | Return service registry entries by service definition list |
| [**registerServiceUsingPOST_0**](AllApi.md#registerServiceUsingPOST_0) | **POST** /serviceregistry/register | Registers a service |
| [**registerSystemUsingPOST_0**](AllApi.md#registerSystemUsingPOST_0) | **POST** /serviceregistry/register-system | Return created application system  |
| [**removeServiceDefinitionUsingDELETE_0**](AllApi.md#removeServiceDefinitionUsingDELETE_0) | **DELETE** /serviceregistry/mgmt/services/{id} | Remove service definition |
| [**removeServiceInterfaceUsingDELETE_0**](AllApi.md#removeServiceInterfaceUsingDELETE_0) | **DELETE** /serviceregistry/mgmt/interfaces/{id} | Remove service interface |
| [**removeServiceRegistryEntryByIdUsingDELETE_0**](AllApi.md#removeServiceRegistryEntryByIdUsingDELETE_0) | **DELETE** /serviceregistry/mgmt/{id} | Remove the specified service registry entry |
| [**removeSystemUsingDELETE_0**](AllApi.md#removeSystemUsingDELETE_0) | **DELETE** /serviceregistry/mgmt/systems/{id} | Remove system |
| [**unregisterServiceUsingDELETE_0**](AllApi.md#unregisterServiceUsingDELETE_0) | **DELETE** /serviceregistry/unregister | Remove a registered service |
| [**unregisterSystemUsingDELETE_0**](AllApi.md#unregisterSystemUsingDELETE_0) | **DELETE** /serviceregistry/unregister-system | Unregister the given system |
| [**updateServiceRegistryUsingPUT_0**](AllApi.md#updateServiceRegistryUsingPUT_0) | **PUT** /serviceregistry/mgmt/{id} | Update a service |
| [**updateSystemUsingPUT_0**](AllApi.md#updateSystemUsingPUT_0) | **PUT** /serviceregistry/mgmt/systems/{id} | Return updated system  |


<a id="addServiceDefinitionUsingPOST_0"></a>
# **addServiceDefinitionUsingPOST_0**
> ServiceDefinitionResponseDTO addServiceDefinitionUsingPOST_0(serviceDefinitionRequestDTO)

Return created service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    ServiceDefinitionRequestDTO serviceDefinitionRequestDTO = new ServiceDefinitionRequestDTO(); // ServiceDefinitionRequestDTO | serviceDefinitionRequestDTO
    try {
      ServiceDefinitionResponseDTO result = apiInstance.addServiceDefinitionUsingPOST_0(serviceDefinitionRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#addServiceDefinitionUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **serviceDefinitionRequestDTO** | [**ServiceDefinitionRequestDTO**](ServiceDefinitionRequestDTO.md)| serviceDefinitionRequestDTO | |

### Return type

[**ServiceDefinitionResponseDTO**](ServiceDefinitionResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Service definition created |  -  |
| **400** | Could not create service definition |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="addServiceInterfaceUsingPOST_0"></a>
# **addServiceInterfaceUsingPOST_0**
> ServiceInterfaceResponseDTO addServiceInterfaceUsingPOST_0(serviceInterfaceRequestDTO)

Return created service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    ServiceInterfaceRequestDTO serviceInterfaceRequestDTO = new ServiceInterfaceRequestDTO(); // ServiceInterfaceRequestDTO | serviceInterfaceRequestDTO
    try {
      ServiceInterfaceResponseDTO result = apiInstance.addServiceInterfaceUsingPOST_0(serviceInterfaceRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#addServiceInterfaceUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **serviceInterfaceRequestDTO** | [**ServiceInterfaceRequestDTO**](ServiceInterfaceRequestDTO.md)| serviceInterfaceRequestDTO | |

### Return type

[**ServiceInterfaceResponseDTO**](ServiceInterfaceResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Service interface created |  -  |
| **400** | Could not create service interface |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="addServiceRegistryUsingPOST_0"></a>
# **addServiceRegistryUsingPOST_0**
> ServiceRegistryResponseDTO addServiceRegistryUsingPOST_0(request)

Registers a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | request
    try {
      ServiceRegistryResponseDTO result = apiInstance.addServiceRegistryUsingPOST_0(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#addServiceRegistryUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **request** | [**ServiceRegistryRequestDTO**](ServiceRegistryRequestDTO.md)| request | |

### Return type

[**ServiceRegistryResponseDTO**](ServiceRegistryResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Service registered |  -  |
| **400** | Could not register service |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="addSystemUsingPOST_0"></a>
# **addSystemUsingPOST_0**
> SystemResponseDTO addSystemUsingPOST_0(request)

Return created system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.addSystemUsingPOST_0(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#addSystemUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **request** | [**SystemRequestDTO**](SystemRequestDTO.md)| request | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | System created |  -  |
| **400** | Could not create system |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="echoServiceUsingGET_0"></a>
# **echoServiceUsingGET_0**
> String echoServiceUsingGET_0()

Return an echo message with the purpose of testing the core service availability

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    try {
      String result = apiInstance.echoServiceUsingGET_0();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#echoServiceUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Core service is available |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getLogEntriesUsingGET_0"></a>
# **getLogEntriesUsingGET_0**
> LogEntryListResponseDTO getLogEntriesUsingGET_0(direction, from, itemPerPage, level, logger, page, sortField, to)

Return requested log entries by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String direction = "ASC"; // String | direction
    String from = "from_example"; // String | from
    Integer itemPerPage = 56; // Integer | item_per_page
    String level = "level_example"; // String | level
    String logger = "logger_example"; // String | logger
    Integer page = 56; // Integer | page
    String sortField = "logId"; // String | sort_field
    String to = "to_example"; // String | to
    try {
      LogEntryListResponseDTO result = apiInstance.getLogEntriesUsingGET_0(direction, from, itemPerPage, level, logger, page, sortField, to);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getLogEntriesUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **direction** | **String**| direction | [optional] [default to ASC] |
| **from** | **String**| from | [optional] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **level** | **String**| level | [optional] |
| **logger** | **String**| logger | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to logId] |
| **to** | **String**| to | [optional] |

### Return type

[**LogEntryListResponseDTO**](LogEntryListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Log entries returned. |  -  |
| **400** | Invalid parameters. |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceDefinitionByIdUsingGET_0"></a>
# **getServiceDefinitionByIdUsingGET_0**
> ServiceDefinitionResponseDTO getServiceDefinitionByIdUsingGET_0(id)

Return requested service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceDefinitionResponseDTO result = apiInstance.getServiceDefinitionByIdUsingGET_0(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceDefinitionByIdUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

[**ServiceDefinitionResponseDTO**](ServiceDefinitionResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Services returned |  -  |
| **400** | Could not retrieve service definition |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceDefinitionsUsingGET_0"></a>
# **getServiceDefinitionsUsingGET_0**
> ServiceDefinitionsListResponseDTO getServiceDefinitionsUsingGET_0(direction, itemPerPage, page, sortField)

Return requested service definitions by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceDefinitionsListResponseDTO result = apiInstance.getServiceDefinitionsUsingGET_0(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceDefinitionsUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **direction** | **String**| direction | [optional] [default to ASC] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to id] |

### Return type

[**ServiceDefinitionsListResponseDTO**](ServiceDefinitionsListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Services returned |  -  |
| **400** | Could not retrieve service definition |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceInterfaceByIdUsingGET_0"></a>
# **getServiceInterfaceByIdUsingGET_0**
> ServiceInterfaceResponseDTO getServiceInterfaceByIdUsingGET_0(id)

Return requested service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceInterfaceResponseDTO result = apiInstance.getServiceInterfaceByIdUsingGET_0(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceInterfaceByIdUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

[**ServiceInterfaceResponseDTO**](ServiceInterfaceResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Interfaces returned |  -  |
| **400** | Could not retrieve service interface |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceInterfacesUsingGET_0"></a>
# **getServiceInterfacesUsingGET_0**
> ServiceInterfacesListResponseDTO getServiceInterfacesUsingGET_0(direction, itemPerPage, page, sortField)

Return requested service interfaces by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceInterfacesListResponseDTO result = apiInstance.getServiceInterfacesUsingGET_0(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceInterfacesUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **direction** | **String**| direction | [optional] [default to ASC] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to id] |

### Return type

[**ServiceInterfacesListResponseDTO**](ServiceInterfacesListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Interfaces returned |  -  |
| **400** | Could not retrieve service interface |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceRegistryEntriesByServiceDefinitionUsingGET_0"></a>
# **getServiceRegistryEntriesByServiceDefinitionUsingGET_0**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesByServiceDefinitionUsingGET_0(serviceDefinition, direction, itemPerPage, page, sortField)

Return requested service registry entries by service definition based on the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String serviceDefinition = "serviceDefinition_example"; // String | serviceDefinition
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesByServiceDefinitionUsingGET_0(serviceDefinition, direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceRegistryEntriesByServiceDefinitionUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **serviceDefinition** | **String**| serviceDefinition | |
| **direction** | **String**| direction | [optional] [default to ASC] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to id] |

### Return type

[**ServiceRegistryListResponseDTO**](ServiceRegistryListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceRegistryEntriesBySystemIdUsingGET_0"></a>
# **getServiceRegistryEntriesBySystemIdUsingGET_0**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesBySystemIdUsingGET_0(id)

Return service registry entries by system id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesBySystemIdUsingGET_0(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceRegistryEntriesBySystemIdUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

[**ServiceRegistryListResponseDTO**](ServiceRegistryListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceRegistryEntriesUsingGET1_0"></a>
# **getServiceRegistryEntriesUsingGET1_0**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesUsingGET1_0()

Return all service registry entries

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesUsingGET1_0();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceRegistryEntriesUsingGET1_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ServiceRegistryListResponseDTO**](ServiceRegistryListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceRegistryEntriesUsingGET_0"></a>
# **getServiceRegistryEntriesUsingGET_0**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesUsingGET_0(direction, itemPerPage, page, sortField)

Return requested service registry entries by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesUsingGET_0(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceRegistryEntriesUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **direction** | **String**| direction | [optional] [default to ASC] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to id] |

### Return type

[**ServiceRegistryListResponseDTO**](ServiceRegistryListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceRegistryEntryByIdUsingGET_0"></a>
# **getServiceRegistryEntryByIdUsingGET_0**
> ServiceRegistryResponseDTO getServiceRegistryEntryByIdUsingGET_0(id)

Return requested service registry entry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceRegistryResponseDTO result = apiInstance.getServiceRegistryEntryByIdUsingGET_0(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceRegistryEntryByIdUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

[**ServiceRegistryResponseDTO**](ServiceRegistryResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getServiceRegistryGroupedDataUsingGET_0"></a>
# **getServiceRegistryGroupedDataUsingGET_0**
> ServiceRegistryGroupedResponseDTO getServiceRegistryGroupedDataUsingGET_0()

Return all service registry entries grouped for frontend usage

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    try {
      ServiceRegistryGroupedResponseDTO result = apiInstance.getServiceRegistryGroupedDataUsingGET_0();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getServiceRegistryGroupedDataUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ServiceRegistryGroupedResponseDTO**](ServiceRegistryGroupedResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getSystemByIdUsingGET_0"></a>
# **getSystemByIdUsingGET_0**
> SystemResponseDTO getSystemByIdUsingGET_0(id)

Return system by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      SystemResponseDTO result = apiInstance.getSystemByIdUsingGET_0(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getSystemByIdUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | System by requested id returned |  -  |
| **400** | No Such System by requested id |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="getSystemsUsingGET_0"></a>
# **getSystemsUsingGET_0**
> SystemListResponseDTO getSystemsUsingGET_0(direction, itemPerPage, page, sortField)

Return systems by request parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      SystemListResponseDTO result = apiInstance.getSystemsUsingGET_0(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#getSystemsUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **direction** | **String**| direction | [optional] [default to ASC] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to id] |

### Return type

[**SystemListResponseDTO**](SystemListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Systems returned |  -  |
| **400** |  Invalid parameters |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="mergeServiceRegistryUsingPATCH_0"></a>
# **mergeServiceRegistryUsingPATCH_0**
> ServiceRegistryResponseDTO mergeServiceRegistryUsingPATCH_0(id, request)

Merge/Patch a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | request
    try {
      ServiceRegistryResponseDTO result = apiInstance.mergeServiceRegistryUsingPATCH_0(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#mergeServiceRegistryUsingPATCH_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **request** | [**ServiceRegistryRequestDTO**](ServiceRegistryRequestDTO.md)| request | |

### Return type

[**ServiceRegistryResponseDTO**](ServiceRegistryResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service merged |  -  |
| **400** | Could not merge service |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="mergeSystemUsingPATCH_0"></a>
# **mergeSystemUsingPATCH_0**
> SystemResponseDTO mergeSystemUsingPATCH_0(id, request)

Return system  updated by fields

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.mergeSystemUsingPATCH_0(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#mergeSystemUsingPATCH_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **request** | [**SystemRequestDTO**](SystemRequestDTO.md)| request | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | System updated |  -  |
| **400** | Could not update system |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="multiQueryRegistryUsingPOST_0"></a>
# **multiQueryRegistryUsingPOST_0**
> ServiceQueryResultDTO multiQueryRegistryUsingPOST_0(forms)

Return Service Registry data that fits the specification

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    ServiceQueryFormListDTO forms = new ServiceQueryFormListDTO(); // ServiceQueryFormListDTO | forms
    try {
      ServiceQueryResultDTO result = apiInstance.multiQueryRegistryUsingPOST_0(forms);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#multiQueryRegistryUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **forms** | [**ServiceQueryFormListDTO**](ServiceQueryFormListDTO.md)| forms | |

### Return type

[**ServiceQueryResultDTO**](ServiceQueryResultDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry data returned |  -  |
| **400** | Could not query Service Registry |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="patchUpdateServiceDefinitionUsingPATCH_0"></a>
# **patchUpdateServiceDefinitionUsingPATCH_0**
> ServiceDefinitionResponseDTO patchUpdateServiceDefinitionUsingPATCH_0(id, serviceDefinitionRequestDTO)

Return updated service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceDefinitionRequestDTO serviceDefinitionRequestDTO = new ServiceDefinitionRequestDTO(); // ServiceDefinitionRequestDTO | serviceDefinitionRequestDTO
    try {
      ServiceDefinitionResponseDTO result = apiInstance.patchUpdateServiceDefinitionUsingPATCH_0(id, serviceDefinitionRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#patchUpdateServiceDefinitionUsingPATCH_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **serviceDefinitionRequestDTO** | [**ServiceDefinitionRequestDTO**](ServiceDefinitionRequestDTO.md)| serviceDefinitionRequestDTO | |

### Return type

[**ServiceDefinitionResponseDTO**](ServiceDefinitionResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service definition updated |  -  |
| **400** | Could not update service definition |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="patchUpdateServiceInterfaceUsingPATCH_0"></a>
# **patchUpdateServiceInterfaceUsingPATCH_0**
> ServiceInterfaceResponseDTO patchUpdateServiceInterfaceUsingPATCH_0(id, serviceInterfaceRequestDTO)

Return updated service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceInterfaceRequestDTO serviceInterfaceRequestDTO = new ServiceInterfaceRequestDTO(); // ServiceInterfaceRequestDTO | serviceInterfaceRequestDTO
    try {
      ServiceInterfaceResponseDTO result = apiInstance.patchUpdateServiceInterfaceUsingPATCH_0(id, serviceInterfaceRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#patchUpdateServiceInterfaceUsingPATCH_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **serviceInterfaceRequestDTO** | [**ServiceInterfaceRequestDTO**](ServiceInterfaceRequestDTO.md)| serviceInterfaceRequestDTO | |

### Return type

[**ServiceInterfaceResponseDTO**](ServiceInterfaceResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service interface updated |  -  |
| **400** | Could not update service interface |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="pullConfigUsingGET_0"></a>
# **pullConfigUsingGET_0**
> KeyValuesDTO pullConfigUsingGET_0()

Return some configuration of ServiceRegistry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    try {
      KeyValuesDTO result = apiInstance.pullConfigUsingGET_0();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#pullConfigUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**KeyValuesDTO**](KeyValuesDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Configuration returned |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="pullSystemsUsingGET_0"></a>
# **pullSystemsUsingGET_0**
> SystemListResponseDTO pullSystemsUsingGET_0(direction, itemPerPage, page, sortField)

Return systems by request parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      SystemListResponseDTO result = apiInstance.pullSystemsUsingGET_0(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#pullSystemsUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **direction** | **String**| direction | [optional] [default to ASC] |
| **itemPerPage** | **Integer**| item_per_page | [optional] |
| **page** | **Integer**| page | [optional] |
| **sortField** | **String**| sort_field | [optional] [default to id] |

### Return type

[**SystemListResponseDTO**](SystemListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Systems returned |  -  |
| **400** |  Invalid parameters |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="putUpdateServiceDefinitionUsingPUT_0"></a>
# **putUpdateServiceDefinitionUsingPUT_0**
> ServiceDefinitionResponseDTO putUpdateServiceDefinitionUsingPUT_0(id, serviceDefinitionRequestDTO)

Return updated service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceDefinitionRequestDTO serviceDefinitionRequestDTO = new ServiceDefinitionRequestDTO(); // ServiceDefinitionRequestDTO | serviceDefinitionRequestDTO
    try {
      ServiceDefinitionResponseDTO result = apiInstance.putUpdateServiceDefinitionUsingPUT_0(id, serviceDefinitionRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#putUpdateServiceDefinitionUsingPUT_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **serviceDefinitionRequestDTO** | [**ServiceDefinitionRequestDTO**](ServiceDefinitionRequestDTO.md)| serviceDefinitionRequestDTO | |

### Return type

[**ServiceDefinitionResponseDTO**](ServiceDefinitionResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service definition updated |  -  |
| **400** | Could not update service definition |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="putUpdateServiceInterfaceUsingPUT_0"></a>
# **putUpdateServiceInterfaceUsingPUT_0**
> ServiceInterfaceResponseDTO putUpdateServiceInterfaceUsingPUT_0(id, serviceInterfaceRequestDTO)

Return updated service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceInterfaceRequestDTO serviceInterfaceRequestDTO = new ServiceInterfaceRequestDTO(); // ServiceInterfaceRequestDTO | serviceInterfaceRequestDTO
    try {
      ServiceInterfaceResponseDTO result = apiInstance.putUpdateServiceInterfaceUsingPUT_0(id, serviceInterfaceRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#putUpdateServiceInterfaceUsingPUT_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **serviceInterfaceRequestDTO** | [**ServiceInterfaceRequestDTO**](ServiceInterfaceRequestDTO.md)| serviceInterfaceRequestDTO | |

### Return type

[**ServiceInterfaceResponseDTO**](ServiceInterfaceResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service interface updated |  -  |
| **400** | Could not update service interface |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="queryRegistryBySystemDTOUsingPOST_0"></a>
# **queryRegistryBySystemDTOUsingPOST_0**
> SystemResponseDTO queryRegistryBySystemDTOUsingPOST_0(request)

Return System by requested dto

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.queryRegistryBySystemDTOUsingPOST_0(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#queryRegistryBySystemDTOUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **request** | [**SystemRequestDTO**](SystemRequestDTO.md)| request | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Consumer System data by requestDTO returned |  -  |
| **400** | Could not query Service Registry by Consumer system requestDTO |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="queryRegistryBySystemIdUsingGET_0"></a>
# **queryRegistryBySystemIdUsingGET_0**
> SystemResponseDTO queryRegistryBySystemIdUsingGET_0(id)

Return system by requested id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      SystemResponseDTO result = apiInstance.queryRegistryBySystemIdUsingGET_0(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#queryRegistryBySystemIdUsingGET_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | System data by id returned |  -  |
| **400** | Could not query Service Registry by Consumer system id |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="queryRegistryUsingPOST_0"></a>
# **queryRegistryUsingPOST_0**
> ServiceQueryResultDTO queryRegistryUsingPOST_0(form)

Return Service Registry data that fits the specification

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    ServiceQueryFormDTO form = new ServiceQueryFormDTO(); // ServiceQueryFormDTO | form
    try {
      ServiceQueryResultDTO result = apiInstance.queryRegistryUsingPOST_0(form);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#queryRegistryUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **form** | [**ServiceQueryFormDTO**](ServiceQueryFormDTO.md)| form | |

### Return type

[**ServiceQueryResultDTO**](ServiceQueryResultDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry data returned |  -  |
| **400** | Could not query Service Registry |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0"></a>
# **queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0**
> ServiceRegistryListResponseDTO queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0(request)

Return service registry entries by service definition list

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    List<String> request = Arrays.asList(); // List<String> | request
    try {
      ServiceRegistryListResponseDTO result = apiInstance.queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#queryServiceRegistryEntriesByServiceDefinitionListUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **request** | [**List&lt;String&gt;**](String.md)| request | |

### Return type

[**ServiceRegistryListResponseDTO**](ServiceRegistryListResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entries returned |  -  |
| **400** | Could not retrieve service registry entries |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="registerServiceUsingPOST_0"></a>
# **registerServiceUsingPOST_0**
> ServiceRegistryResponseDTO registerServiceUsingPOST_0(dto)

Registers a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    ServiceRegistryRequestDTO dto = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | dto
    try {
      ServiceRegistryResponseDTO result = apiInstance.registerServiceUsingPOST_0(dto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#registerServiceUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dto** | [**ServiceRegistryRequestDTO**](ServiceRegistryRequestDTO.md)| dto | |

### Return type

[**ServiceRegistryResponseDTO**](ServiceRegistryResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Service registered |  -  |
| **400** | Could not register service |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="registerSystemUsingPOST_0"></a>
# **registerSystemUsingPOST_0**
> SystemResponseDTO registerSystemUsingPOST_0(dto)

Return created application system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    SystemRequestDTO dto = new SystemRequestDTO(); // SystemRequestDTO | dto
    try {
      SystemResponseDTO result = apiInstance.registerSystemUsingPOST_0(dto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#registerSystemUsingPOST_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dto** | [**SystemRequestDTO**](SystemRequestDTO.md)| dto | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | System created |  -  |
| **400** | Could not create system |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="removeServiceDefinitionUsingDELETE_0"></a>
# **removeServiceDefinitionUsingDELETE_0**
> removeServiceDefinitionUsingDELETE_0(id)

Remove service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeServiceDefinitionUsingDELETE_0(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#removeServiceDefinitionUsingDELETE_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service definition removed |  -  |
| **400** | Could not remove service definition |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="removeServiceInterfaceUsingDELETE_0"></a>
# **removeServiceInterfaceUsingDELETE_0**
> removeServiceInterfaceUsingDELETE_0(id)

Remove service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeServiceInterfaceUsingDELETE_0(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#removeServiceInterfaceUsingDELETE_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service interface removed |  -  |
| **400** | Could not remove service interface |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="removeServiceRegistryEntryByIdUsingDELETE_0"></a>
# **removeServiceRegistryEntryByIdUsingDELETE_0**
> removeServiceRegistryEntryByIdUsingDELETE_0(id)

Remove the specified service registry entry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeServiceRegistryEntryByIdUsingDELETE_0(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#removeServiceRegistryEntryByIdUsingDELETE_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service Registry entry removed |  -  |
| **400** | Could not remove service registry entry |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="removeSystemUsingDELETE_0"></a>
# **removeSystemUsingDELETE_0**
> removeSystemUsingDELETE_0(id)

Remove system

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeSystemUsingDELETE_0(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#removeSystemUsingDELETE_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | System deleted |  -  |
| **400** | Could not delete system |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="unregisterServiceUsingDELETE_0"></a>
# **unregisterServiceUsingDELETE_0**
> unregisterServiceUsingDELETE_0(port, serviceDefinition, serviceUri, systemName, address)

Remove a registered service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Integer port = 56; // Integer | port
    String serviceDefinition = "serviceDefinition_example"; // String | service_definition
    String serviceUri = "serviceUri_example"; // String | service_uri
    String systemName = "systemName_example"; // String | system_name
    String address = "address_example"; // String | address
    try {
      apiInstance.unregisterServiceUsingDELETE_0(port, serviceDefinition, serviceUri, systemName, address);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#unregisterServiceUsingDELETE_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **port** | **Integer**| port | |
| **serviceDefinition** | **String**| service_definition | |
| **serviceUri** | **String**| service_uri | |
| **systemName** | **String**| system_name | |
| **address** | **String**| address | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Registered service removed |  -  |
| **400** | Could not remove service |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="unregisterSystemUsingDELETE_0"></a>
# **unregisterSystemUsingDELETE_0**
> unregisterSystemUsingDELETE_0(port, systemName, address)

Unregister the given system

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Integer port = 56; // Integer | port
    String systemName = "systemName_example"; // String | system_name
    String address = "address_example"; // String | address
    try {
      apiInstance.unregisterSystemUsingDELETE_0(port, systemName, address);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#unregisterSystemUsingDELETE_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **port** | **Integer**| port | |
| **systemName** | **String**| system_name | |
| **address** | **String**| address | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | System deleted |  -  |
| **400** | Could not delete system |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="updateServiceRegistryUsingPUT_0"></a>
# **updateServiceRegistryUsingPUT_0**
> ServiceRegistryResponseDTO updateServiceRegistryUsingPUT_0(id, request)

Update a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | request
    try {
      ServiceRegistryResponseDTO result = apiInstance.updateServiceRegistryUsingPUT_0(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#updateServiceRegistryUsingPUT_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **request** | [**ServiceRegistryRequestDTO**](ServiceRegistryRequestDTO.md)| request | |

### Return type

[**ServiceRegistryResponseDTO**](ServiceRegistryResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Service updated |  -  |
| **400** | Could not update service |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

<a id="updateSystemUsingPUT_0"></a>
# **updateSystemUsingPUT_0**
> SystemResponseDTO updateSystemUsingPUT_0(id, request)

Return updated system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AllApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    AllApi apiInstance = new AllApi(defaultClient);
    Long id = 56L; // Long | id
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.updateSystemUsingPUT_0(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AllApi#updateSystemUsingPUT_0");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| id | |
| **request** | [**SystemRequestDTO**](SystemRequestDTO.md)| request | |

### Return type

[**SystemResponseDTO**](SystemResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **201** | System updated |  -  |
| **400** | Could not update system |  -  |
| **401** | You are not authorized |  -  |
| **500** | Core service is not available |  -  |

