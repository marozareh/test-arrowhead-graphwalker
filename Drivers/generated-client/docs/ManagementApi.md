# ManagementApi

All URIs are relative to *http://localhost:8443*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addServiceDefinitionUsingPOST**](ManagementApi.md#addServiceDefinitionUsingPOST) | **POST** /serviceregistry/mgmt/services | Return created service definition |
| [**addServiceInterfaceUsingPOST**](ManagementApi.md#addServiceInterfaceUsingPOST) | **POST** /serviceregistry/mgmt/interfaces | Return created service interface |
| [**addServiceRegistryUsingPOST**](ManagementApi.md#addServiceRegistryUsingPOST) | **POST** /serviceregistry/mgmt | Registers a service |
| [**addSystemUsingPOST**](ManagementApi.md#addSystemUsingPOST) | **POST** /serviceregistry/mgmt/systems | Return created system  |
| [**getLogEntriesUsingGET**](ManagementApi.md#getLogEntriesUsingGET) | **GET** /serviceregistry/mgmt/logs | Return requested log entries by the given parameters |
| [**getServiceDefinitionByIdUsingGET**](ManagementApi.md#getServiceDefinitionByIdUsingGET) | **GET** /serviceregistry/mgmt/services/{id} | Return requested service definition |
| [**getServiceDefinitionsUsingGET**](ManagementApi.md#getServiceDefinitionsUsingGET) | **GET** /serviceregistry/mgmt/services | Return requested service definitions by the given parameters |
| [**getServiceInterfaceByIdUsingGET**](ManagementApi.md#getServiceInterfaceByIdUsingGET) | **GET** /serviceregistry/mgmt/interfaces/{id} | Return requested service interface |
| [**getServiceInterfacesUsingGET**](ManagementApi.md#getServiceInterfacesUsingGET) | **GET** /serviceregistry/mgmt/interfaces | Return requested service interfaces by the given parameters |
| [**getServiceRegistryEntriesByServiceDefinitionUsingGET**](ManagementApi.md#getServiceRegistryEntriesByServiceDefinitionUsingGET) | **GET** /serviceregistry/mgmt/servicedef/{serviceDefinition} | Return requested service registry entries by service definition based on the given parameters |
| [**getServiceRegistryEntriesUsingGET**](ManagementApi.md#getServiceRegistryEntriesUsingGET) | **GET** /serviceregistry/mgmt | Return requested service registry entries by the given parameters |
| [**getServiceRegistryEntryByIdUsingGET**](ManagementApi.md#getServiceRegistryEntryByIdUsingGET) | **GET** /serviceregistry/mgmt/{id} | Return requested service registry entry |
| [**getServiceRegistryGroupedDataUsingGET**](ManagementApi.md#getServiceRegistryGroupedDataUsingGET) | **GET** /serviceregistry/mgmt/grouped | Return all service registry entries grouped for frontend usage |
| [**getSystemByIdUsingGET**](ManagementApi.md#getSystemByIdUsingGET) | **GET** /serviceregistry/mgmt/systems/{id} | Return system by id |
| [**getSystemsUsingGET**](ManagementApi.md#getSystemsUsingGET) | **GET** /serviceregistry/mgmt/systems | Return systems by request parameters |
| [**mergeServiceRegistryUsingPATCH**](ManagementApi.md#mergeServiceRegistryUsingPATCH) | **PATCH** /serviceregistry/mgmt/{id} | Merge/Patch a service |
| [**mergeSystemUsingPATCH**](ManagementApi.md#mergeSystemUsingPATCH) | **PATCH** /serviceregistry/mgmt/systems/{id} | Return system  updated by fields |
| [**patchUpdateServiceDefinitionUsingPATCH**](ManagementApi.md#patchUpdateServiceDefinitionUsingPATCH) | **PATCH** /serviceregistry/mgmt/services/{id} | Return updated service definition |
| [**patchUpdateServiceInterfaceUsingPATCH**](ManagementApi.md#patchUpdateServiceInterfaceUsingPATCH) | **PATCH** /serviceregistry/mgmt/interfaces/{id} | Return updated service interface |
| [**putUpdateServiceDefinitionUsingPUT**](ManagementApi.md#putUpdateServiceDefinitionUsingPUT) | **PUT** /serviceregistry/mgmt/services/{id} | Return updated service definition |
| [**putUpdateServiceInterfaceUsingPUT**](ManagementApi.md#putUpdateServiceInterfaceUsingPUT) | **PUT** /serviceregistry/mgmt/interfaces/{id} | Return updated service interface |
| [**removeServiceDefinitionUsingDELETE**](ManagementApi.md#removeServiceDefinitionUsingDELETE) | **DELETE** /serviceregistry/mgmt/services/{id} | Remove service definition |
| [**removeServiceInterfaceUsingDELETE**](ManagementApi.md#removeServiceInterfaceUsingDELETE) | **DELETE** /serviceregistry/mgmt/interfaces/{id} | Remove service interface |
| [**removeServiceRegistryEntryByIdUsingDELETE**](ManagementApi.md#removeServiceRegistryEntryByIdUsingDELETE) | **DELETE** /serviceregistry/mgmt/{id} | Remove the specified service registry entry |
| [**removeSystemUsingDELETE**](ManagementApi.md#removeSystemUsingDELETE) | **DELETE** /serviceregistry/mgmt/systems/{id} | Remove system |
| [**updateServiceRegistryUsingPUT**](ManagementApi.md#updateServiceRegistryUsingPUT) | **PUT** /serviceregistry/mgmt/{id} | Update a service |
| [**updateSystemUsingPUT**](ManagementApi.md#updateSystemUsingPUT) | **PUT** /serviceregistry/mgmt/systems/{id} | Return updated system  |


<a id="addServiceDefinitionUsingPOST"></a>
# **addServiceDefinitionUsingPOST**
> ServiceDefinitionResponseDTO addServiceDefinitionUsingPOST(serviceDefinitionRequestDTO)

Return created service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    ServiceDefinitionRequestDTO serviceDefinitionRequestDTO = new ServiceDefinitionRequestDTO(); // ServiceDefinitionRequestDTO | serviceDefinitionRequestDTO
    try {
      ServiceDefinitionResponseDTO result = apiInstance.addServiceDefinitionUsingPOST(serviceDefinitionRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#addServiceDefinitionUsingPOST");
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

<a id="addServiceInterfaceUsingPOST"></a>
# **addServiceInterfaceUsingPOST**
> ServiceInterfaceResponseDTO addServiceInterfaceUsingPOST(serviceInterfaceRequestDTO)

Return created service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    ServiceInterfaceRequestDTO serviceInterfaceRequestDTO = new ServiceInterfaceRequestDTO(); // ServiceInterfaceRequestDTO | serviceInterfaceRequestDTO
    try {
      ServiceInterfaceResponseDTO result = apiInstance.addServiceInterfaceUsingPOST(serviceInterfaceRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#addServiceInterfaceUsingPOST");
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

<a id="addServiceRegistryUsingPOST"></a>
# **addServiceRegistryUsingPOST**
> ServiceRegistryResponseDTO addServiceRegistryUsingPOST(request)

Registers a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | request
    try {
      ServiceRegistryResponseDTO result = apiInstance.addServiceRegistryUsingPOST(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#addServiceRegistryUsingPOST");
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

<a id="addSystemUsingPOST"></a>
# **addSystemUsingPOST**
> SystemResponseDTO addSystemUsingPOST(request)

Return created system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.addSystemUsingPOST(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#addSystemUsingPOST");
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

<a id="getLogEntriesUsingGET"></a>
# **getLogEntriesUsingGET**
> LogEntryListResponseDTO getLogEntriesUsingGET(direction, from, itemPerPage, level, logger, page, sortField, to)

Return requested log entries by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    String direction = "ASC"; // String | direction
    String from = "from_example"; // String | from
    Integer itemPerPage = 56; // Integer | item_per_page
    String level = "level_example"; // String | level
    String logger = "logger_example"; // String | logger
    Integer page = 56; // Integer | page
    String sortField = "logId"; // String | sort_field
    String to = "to_example"; // String | to
    try {
      LogEntryListResponseDTO result = apiInstance.getLogEntriesUsingGET(direction, from, itemPerPage, level, logger, page, sortField, to);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getLogEntriesUsingGET");
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

<a id="getServiceDefinitionByIdUsingGET"></a>
# **getServiceDefinitionByIdUsingGET**
> ServiceDefinitionResponseDTO getServiceDefinitionByIdUsingGET(id)

Return requested service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceDefinitionResponseDTO result = apiInstance.getServiceDefinitionByIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceDefinitionByIdUsingGET");
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

<a id="getServiceDefinitionsUsingGET"></a>
# **getServiceDefinitionsUsingGET**
> ServiceDefinitionsListResponseDTO getServiceDefinitionsUsingGET(direction, itemPerPage, page, sortField)

Return requested service definitions by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceDefinitionsListResponseDTO result = apiInstance.getServiceDefinitionsUsingGET(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceDefinitionsUsingGET");
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

<a id="getServiceInterfaceByIdUsingGET"></a>
# **getServiceInterfaceByIdUsingGET**
> ServiceInterfaceResponseDTO getServiceInterfaceByIdUsingGET(id)

Return requested service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceInterfaceResponseDTO result = apiInstance.getServiceInterfaceByIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceInterfaceByIdUsingGET");
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

<a id="getServiceInterfacesUsingGET"></a>
# **getServiceInterfacesUsingGET**
> ServiceInterfacesListResponseDTO getServiceInterfacesUsingGET(direction, itemPerPage, page, sortField)

Return requested service interfaces by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceInterfacesListResponseDTO result = apiInstance.getServiceInterfacesUsingGET(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceInterfacesUsingGET");
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

<a id="getServiceRegistryEntriesByServiceDefinitionUsingGET"></a>
# **getServiceRegistryEntriesByServiceDefinitionUsingGET**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesByServiceDefinitionUsingGET(serviceDefinition, direction, itemPerPage, page, sortField)

Return requested service registry entries by service definition based on the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    String serviceDefinition = "serviceDefinition_example"; // String | serviceDefinition
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesByServiceDefinitionUsingGET(serviceDefinition, direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceRegistryEntriesByServiceDefinitionUsingGET");
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

<a id="getServiceRegistryEntriesUsingGET"></a>
# **getServiceRegistryEntriesUsingGET**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesUsingGET(direction, itemPerPage, page, sortField)

Return requested service registry entries by the given parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesUsingGET(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceRegistryEntriesUsingGET");
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

<a id="getServiceRegistryEntryByIdUsingGET"></a>
# **getServiceRegistryEntryByIdUsingGET**
> ServiceRegistryResponseDTO getServiceRegistryEntryByIdUsingGET(id)

Return requested service registry entry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceRegistryResponseDTO result = apiInstance.getServiceRegistryEntryByIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceRegistryEntryByIdUsingGET");
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

<a id="getServiceRegistryGroupedDataUsingGET"></a>
# **getServiceRegistryGroupedDataUsingGET**
> ServiceRegistryGroupedResponseDTO getServiceRegistryGroupedDataUsingGET()

Return all service registry entries grouped for frontend usage

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    try {
      ServiceRegistryGroupedResponseDTO result = apiInstance.getServiceRegistryGroupedDataUsingGET();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getServiceRegistryGroupedDataUsingGET");
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

<a id="getSystemByIdUsingGET"></a>
# **getSystemByIdUsingGET**
> SystemResponseDTO getSystemByIdUsingGET(id)

Return system by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      SystemResponseDTO result = apiInstance.getSystemByIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getSystemByIdUsingGET");
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

<a id="getSystemsUsingGET"></a>
# **getSystemsUsingGET**
> SystemListResponseDTO getSystemsUsingGET(direction, itemPerPage, page, sortField)

Return systems by request parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      SystemListResponseDTO result = apiInstance.getSystemsUsingGET(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#getSystemsUsingGET");
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

<a id="mergeServiceRegistryUsingPATCH"></a>
# **mergeServiceRegistryUsingPATCH**
> ServiceRegistryResponseDTO mergeServiceRegistryUsingPATCH(id, request)

Merge/Patch a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | request
    try {
      ServiceRegistryResponseDTO result = apiInstance.mergeServiceRegistryUsingPATCH(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#mergeServiceRegistryUsingPATCH");
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

<a id="mergeSystemUsingPATCH"></a>
# **mergeSystemUsingPATCH**
> SystemResponseDTO mergeSystemUsingPATCH(id, request)

Return system  updated by fields

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.mergeSystemUsingPATCH(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#mergeSystemUsingPATCH");
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

<a id="patchUpdateServiceDefinitionUsingPATCH"></a>
# **patchUpdateServiceDefinitionUsingPATCH**
> ServiceDefinitionResponseDTO patchUpdateServiceDefinitionUsingPATCH(id, serviceDefinitionRequestDTO)

Return updated service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceDefinitionRequestDTO serviceDefinitionRequestDTO = new ServiceDefinitionRequestDTO(); // ServiceDefinitionRequestDTO | serviceDefinitionRequestDTO
    try {
      ServiceDefinitionResponseDTO result = apiInstance.patchUpdateServiceDefinitionUsingPATCH(id, serviceDefinitionRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#patchUpdateServiceDefinitionUsingPATCH");
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

<a id="patchUpdateServiceInterfaceUsingPATCH"></a>
# **patchUpdateServiceInterfaceUsingPATCH**
> ServiceInterfaceResponseDTO patchUpdateServiceInterfaceUsingPATCH(id, serviceInterfaceRequestDTO)

Return updated service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceInterfaceRequestDTO serviceInterfaceRequestDTO = new ServiceInterfaceRequestDTO(); // ServiceInterfaceRequestDTO | serviceInterfaceRequestDTO
    try {
      ServiceInterfaceResponseDTO result = apiInstance.patchUpdateServiceInterfaceUsingPATCH(id, serviceInterfaceRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#patchUpdateServiceInterfaceUsingPATCH");
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

<a id="putUpdateServiceDefinitionUsingPUT"></a>
# **putUpdateServiceDefinitionUsingPUT**
> ServiceDefinitionResponseDTO putUpdateServiceDefinitionUsingPUT(id, serviceDefinitionRequestDTO)

Return updated service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceDefinitionRequestDTO serviceDefinitionRequestDTO = new ServiceDefinitionRequestDTO(); // ServiceDefinitionRequestDTO | serviceDefinitionRequestDTO
    try {
      ServiceDefinitionResponseDTO result = apiInstance.putUpdateServiceDefinitionUsingPUT(id, serviceDefinitionRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#putUpdateServiceDefinitionUsingPUT");
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

<a id="putUpdateServiceInterfaceUsingPUT"></a>
# **putUpdateServiceInterfaceUsingPUT**
> ServiceInterfaceResponseDTO putUpdateServiceInterfaceUsingPUT(id, serviceInterfaceRequestDTO)

Return updated service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceInterfaceRequestDTO serviceInterfaceRequestDTO = new ServiceInterfaceRequestDTO(); // ServiceInterfaceRequestDTO | serviceInterfaceRequestDTO
    try {
      ServiceInterfaceResponseDTO result = apiInstance.putUpdateServiceInterfaceUsingPUT(id, serviceInterfaceRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#putUpdateServiceInterfaceUsingPUT");
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

<a id="removeServiceDefinitionUsingDELETE"></a>
# **removeServiceDefinitionUsingDELETE**
> removeServiceDefinitionUsingDELETE(id)

Remove service definition

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeServiceDefinitionUsingDELETE(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#removeServiceDefinitionUsingDELETE");
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

<a id="removeServiceInterfaceUsingDELETE"></a>
# **removeServiceInterfaceUsingDELETE**
> removeServiceInterfaceUsingDELETE(id)

Remove service interface

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeServiceInterfaceUsingDELETE(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#removeServiceInterfaceUsingDELETE");
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

<a id="removeServiceRegistryEntryByIdUsingDELETE"></a>
# **removeServiceRegistryEntryByIdUsingDELETE**
> removeServiceRegistryEntryByIdUsingDELETE(id)

Remove the specified service registry entry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeServiceRegistryEntryByIdUsingDELETE(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#removeServiceRegistryEntryByIdUsingDELETE");
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

<a id="removeSystemUsingDELETE"></a>
# **removeSystemUsingDELETE**
> removeSystemUsingDELETE(id)

Remove system

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.removeSystemUsingDELETE(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#removeSystemUsingDELETE");
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

<a id="updateServiceRegistryUsingPUT"></a>
# **updateServiceRegistryUsingPUT**
> ServiceRegistryResponseDTO updateServiceRegistryUsingPUT(id, request)

Update a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | request
    try {
      ServiceRegistryResponseDTO result = apiInstance.updateServiceRegistryUsingPUT(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#updateServiceRegistryUsingPUT");
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

<a id="updateSystemUsingPUT"></a>
# **updateSystemUsingPUT**
> SystemResponseDTO updateSystemUsingPUT(id, request)

Return updated system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagementApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ManagementApi apiInstance = new ManagementApi(defaultClient);
    Long id = 56L; // Long | id
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.updateSystemUsingPUT(id, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagementApi#updateSystemUsingPUT");
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

