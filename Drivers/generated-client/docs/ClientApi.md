# ClientApi

All URIs are relative to *http://localhost:8443*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**echoServiceUsingGET**](ClientApi.md#echoServiceUsingGET) | **GET** /serviceregistry/echo | Return an echo message with the purpose of testing the core service availability |
| [**multiQueryRegistryUsingPOST**](ClientApi.md#multiQueryRegistryUsingPOST) | **POST** /serviceregistry/query/multi | Return Service Registry data that fits the specification |
| [**queryRegistryUsingPOST**](ClientApi.md#queryRegistryUsingPOST) | **POST** /serviceregistry/query | Return Service Registry data that fits the specification |
| [**registerServiceUsingPOST**](ClientApi.md#registerServiceUsingPOST) | **POST** /serviceregistry/register | Registers a service |
| [**registerSystemUsingPOST**](ClientApi.md#registerSystemUsingPOST) | **POST** /serviceregistry/register-system | Return created application system  |
| [**unregisterServiceUsingDELETE**](ClientApi.md#unregisterServiceUsingDELETE) | **DELETE** /serviceregistry/unregister | Remove a registered service |
| [**unregisterSystemUsingDELETE**](ClientApi.md#unregisterSystemUsingDELETE) | **DELETE** /serviceregistry/unregister-system | Unregister the given system |


<a id="echoServiceUsingGET"></a>
# **echoServiceUsingGET**
> String echoServiceUsingGET()

Return an echo message with the purpose of testing the core service availability

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    try {
      String result = apiInstance.echoServiceUsingGET();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#echoServiceUsingGET");
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

<a id="multiQueryRegistryUsingPOST"></a>
# **multiQueryRegistryUsingPOST**
> ServiceQueryResultDTO multiQueryRegistryUsingPOST(forms)

Return Service Registry data that fits the specification

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    ServiceQueryFormListDTO forms = new ServiceQueryFormListDTO(); // ServiceQueryFormListDTO | forms
    try {
      ServiceQueryResultDTO result = apiInstance.multiQueryRegistryUsingPOST(forms);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#multiQueryRegistryUsingPOST");
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

<a id="queryRegistryUsingPOST"></a>
# **queryRegistryUsingPOST**
> ServiceQueryResultDTO queryRegistryUsingPOST(form)

Return Service Registry data that fits the specification

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    ServiceQueryFormDTO form = new ServiceQueryFormDTO(); // ServiceQueryFormDTO | form
    try {
      ServiceQueryResultDTO result = apiInstance.queryRegistryUsingPOST(form);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#queryRegistryUsingPOST");
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

<a id="registerServiceUsingPOST"></a>
# **registerServiceUsingPOST**
> ServiceRegistryResponseDTO registerServiceUsingPOST(dto)

Registers a service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    ServiceRegistryRequestDTO dto = new ServiceRegistryRequestDTO(); // ServiceRegistryRequestDTO | dto
    try {
      ServiceRegistryResponseDTO result = apiInstance.registerServiceUsingPOST(dto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#registerServiceUsingPOST");
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

<a id="registerSystemUsingPOST"></a>
# **registerSystemUsingPOST**
> SystemResponseDTO registerSystemUsingPOST(dto)

Return created application system 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    SystemRequestDTO dto = new SystemRequestDTO(); // SystemRequestDTO | dto
    try {
      SystemResponseDTO result = apiInstance.registerSystemUsingPOST(dto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#registerSystemUsingPOST");
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

<a id="unregisterServiceUsingDELETE"></a>
# **unregisterServiceUsingDELETE**
> unregisterServiceUsingDELETE(port, serviceDefinition, serviceUri, systemName, address)

Remove a registered service

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    Integer port = 56; // Integer | port
    String serviceDefinition = "serviceDefinition_example"; // String | service_definition
    String serviceUri = "serviceUri_example"; // String | service_uri
    String systemName = "systemName_example"; // String | system_name
    String address = "address_example"; // String | address
    try {
      apiInstance.unregisterServiceUsingDELETE(port, serviceDefinition, serviceUri, systemName, address);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#unregisterServiceUsingDELETE");
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

<a id="unregisterSystemUsingDELETE"></a>
# **unregisterSystemUsingDELETE**
> unregisterSystemUsingDELETE(port, systemName, address)

Unregister the given system

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClientApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8443");

    ClientApi apiInstance = new ClientApi(defaultClient);
    Integer port = 56; // Integer | port
    String systemName = "systemName_example"; // String | system_name
    String address = "address_example"; // String | address
    try {
      apiInstance.unregisterSystemUsingDELETE(port, systemName, address);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClientApi#unregisterSystemUsingDELETE");
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

