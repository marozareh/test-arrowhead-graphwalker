# PrivateApi

All URIs are relative to *http://localhost:8443*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getServiceRegistryEntriesBySystemIdUsingGET**](PrivateApi.md#getServiceRegistryEntriesBySystemIdUsingGET) | **GET** /serviceregistry/query/provider/{id} | Return service registry entries by system id |
| [**getServiceRegistryEntriesUsingGET1**](PrivateApi.md#getServiceRegistryEntriesUsingGET1) | **GET** /serviceregistry/query/all | Return all service registry entries |
| [**pullConfigUsingGET**](PrivateApi.md#pullConfigUsingGET) | **GET** /serviceregistry/pull-config | Return some configuration of ServiceRegistry |
| [**pullSystemsUsingGET**](PrivateApi.md#pullSystemsUsingGET) | **GET** /serviceregistry/pull-systems | Return systems by request parameters |
| [**queryRegistryBySystemDTOUsingPOST**](PrivateApi.md#queryRegistryBySystemDTOUsingPOST) | **POST** /serviceregistry/query/system | Return System by requested dto |
| [**queryRegistryBySystemIdUsingGET**](PrivateApi.md#queryRegistryBySystemIdUsingGET) | **GET** /serviceregistry/query/system/{id} | Return system by requested id |
| [**queryServiceRegistryEntriesByServiceDefinitionListUsingPOST**](PrivateApi.md#queryServiceRegistryEntriesByServiceDefinitionListUsingPOST) | **POST** /serviceregistry/query/definition | Return service registry entries by service definition list |


<a id="getServiceRegistryEntriesBySystemIdUsingGET"></a>
# **getServiceRegistryEntriesBySystemIdUsingGET**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesBySystemIdUsingGET(id)

Return service registry entries by system id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesBySystemIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#getServiceRegistryEntriesBySystemIdUsingGET");
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

<a id="getServiceRegistryEntriesUsingGET1"></a>
# **getServiceRegistryEntriesUsingGET1**
> ServiceRegistryListResponseDTO getServiceRegistryEntriesUsingGET1()

Return all service registry entries

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    try {
      ServiceRegistryListResponseDTO result = apiInstance.getServiceRegistryEntriesUsingGET1();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#getServiceRegistryEntriesUsingGET1");
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

<a id="pullConfigUsingGET"></a>
# **pullConfigUsingGET**
> KeyValuesDTO pullConfigUsingGET()

Return some configuration of ServiceRegistry

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    try {
      KeyValuesDTO result = apiInstance.pullConfigUsingGET();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#pullConfigUsingGET");
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

<a id="pullSystemsUsingGET"></a>
# **pullSystemsUsingGET**
> SystemListResponseDTO pullSystemsUsingGET(direction, itemPerPage, page, sortField)

Return systems by request parameters

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    String direction = "ASC"; // String | direction
    Integer itemPerPage = 56; // Integer | item_per_page
    Integer page = 56; // Integer | page
    String sortField = "id"; // String | sort_field
    try {
      SystemListResponseDTO result = apiInstance.pullSystemsUsingGET(direction, itemPerPage, page, sortField);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#pullSystemsUsingGET");
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

<a id="queryRegistryBySystemDTOUsingPOST"></a>
# **queryRegistryBySystemDTOUsingPOST**
> SystemResponseDTO queryRegistryBySystemDTOUsingPOST(request)

Return System by requested dto

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    SystemRequestDTO request = new SystemRequestDTO(); // SystemRequestDTO | request
    try {
      SystemResponseDTO result = apiInstance.queryRegistryBySystemDTOUsingPOST(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#queryRegistryBySystemDTOUsingPOST");
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

<a id="queryRegistryBySystemIdUsingGET"></a>
# **queryRegistryBySystemIdUsingGET**
> SystemResponseDTO queryRegistryBySystemIdUsingGET(id)

Return system by requested id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      SystemResponseDTO result = apiInstance.queryRegistryBySystemIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#queryRegistryBySystemIdUsingGET");
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

<a id="queryServiceRegistryEntriesByServiceDefinitionListUsingPOST"></a>
# **queryServiceRegistryEntriesByServiceDefinitionListUsingPOST**
> ServiceRegistryListResponseDTO queryServiceRegistryEntriesByServiceDefinitionListUsingPOST(request)

Return service registry entries by service definition list

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    PrivateApi apiInstance = new PrivateApi(defaultClient);
    List<String> request = Arrays.asList(); // List<String> | request
    try {
      ServiceRegistryListResponseDTO result = apiInstance.queryServiceRegistryEntriesByServiceDefinitionListUsingPOST(request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateApi#queryServiceRegistryEntriesByServiceDefinitionListUsingPOST");
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

