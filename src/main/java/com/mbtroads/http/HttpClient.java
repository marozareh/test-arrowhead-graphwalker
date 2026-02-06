package com.mbtroads.http;

import com.mbtroads.core.ISystemProperties;
import com.mbtroads.report.ExtentReport;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

public class HttpClient implements ISystemProperties {

    public static String failCase_Test = "false";

    /* ============================
       Helper extract methods
       ============================ */

    public String Get_id(String content) {
        String id = substringBefore(content, ",\"serviceDefinition");
        id = substringAfter(id, ":");
        return id;
    }

    public String Get_name(String content) {
        String name = substringBefore(content, "\",\"address");
        name = substringAfter(name, "systemName\":\"");
        return name;
    }

    public String Get_id_p(String content, String type) {

        String after = "";
        String before = "";

        if (type.contains("provider")) {
            after = ",\"provider\":{\"id\":";
            before = ",\"systemName";
        }
        if (type.contains("serviceDefinition")) {
            after = ",\"serviceDefinition\":{\"id\":";
            before = ",\"serviceDefinition\":";
        }
        if (type.contains("interface")) {
            after = ",\"interfaces\":[{\"id\":";
            before = ",\"interfaceName";
        }
        if (type.contains("servicename")) {
            after = "\"systemName\":\"";
            before = "\",\"address";
        }
        if (type.contains("storeid")) {
            after = "data\":[{\"id\":";
            before = ",\"serviceDefinition\":{\"id";
        }

        String id = substringAfter(content, after);
        id = substringBefore(id, before);
        return id;
    }

    /* ============================
       Service availability
       ============================ */

    public HttpResponse ServiceAvailable(String serviceName) {

        HttpResponse response;

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request;

            if (serviceName.contains("serviceregistery")) {
                request = new HttpGet("http://localhost:8443/serviceregistry/echo");
            } else if (serviceName.contains("authontication")) {
                request = new HttpGet("http://localhost:8445/authorization/echo");
            } else {
                request = new HttpGet("http://localhost:8441/orchestrator/echo");
            }

            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            response = httpClient.execute(request);

        } catch (Exception e) {
            ExtentReport.node.fail("Service availability check failed");
            throw new RuntimeException(e);
        }

        return response;
    }

    /* ============================
       GET operations
       ============================ */

    public HttpResponse sendGet_All(String type) {

        HttpResponse response;

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request;

            if (type.contains("serviceregistry")) {
                request = new HttpGet(
                        "http://localhost:8443/serviceregistry/mgmt?direction=ASC&sort_field=id"
                );
            } else {
                request = new HttpGet(
                        "http://localhost:8441/orchestrator/mgmt/store/all_top_priority?direction=ASC&sort_field=id"
                );
            }

            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            response = httpClient.execute(request);

        } catch (Exception e) {
            ExtentReport.node.fail("GET ALL request failed");
            throw new RuntimeException(e);
        }

        return response;
    }

    public HttpResponse sendGet(String id, String type) {

        HttpResponse response;

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request;

            if (type.contains("serviceregistry")) {
                request = new HttpGet(
                        "http://localhost:8443/serviceregistry/mgmt/" + id
                );
            } else {
                request = new HttpGet(
                        "http://localhost:8441/orchestrator/mgmt/store/" + id
                );
            }

            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            response = httpClient.execute(request);

        } catch (Exception e) {
            ExtentReport.node.fail("GET request failed");
            throw new RuntimeException(e);
        }

        return response;
    }

    /* ============================
       POST operations
       ============================ */

    public HttpResponse sendPost_Query(String payload, String type) {

        HttpResponse response;

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request;

            if (type.contains("query")) {
                request = new HttpPost("http://localhost:8443/serviceregistry/query");
            } else if (type.contains("mgmt")) {
                request = new HttpPost("http://localhost:8443/serviceregistry/mgmt");
            } else if (type.contains("requesrauth")) {
                request = new HttpPost("http://localhost:8445/authorization/mgmt/intracloud");
            } else {
                request = new HttpPost("http://localhost:8441/orchestrator/mgmt/store");
            }

            request.setHeader("Content-type", "application/json");
            request.setEntity(new StringEntity(payload));

            response = httpClient.execute(request);

        } catch (Exception e) {
            ExtentReport.node.fail("POST request failed");
            throw new RuntimeException(e);
        }

        return response;
    }

    /* ============================
       DELETE operations
       ============================ */

    public HttpResponse DeleteServise(String payload, String type) {

        HttpResponse response;

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpDelete request;

            if (type.contains("serviceregistry")) {
                request = new HttpDelete(
                        "http://localhost:8443/serviceregistry/unregister?" + payload
                );
            } else {
                request = new HttpDelete(
                        "http://localhost:8441/orchestrator/mgmt/store/" + payload
                );
            }

            request.setHeader("Content-type", "application/json");

            response = httpClient.execute(request);

        } catch (Exception e) {
            ExtentReport.node.fail("DELETE request failed");
            throw new RuntimeException(e);
        }

        return response;
    }

    /* ============================
       Runtime flags
       ============================ */

    public static void setValues() {
        failCase_Test = System.getProperty("failcase");
    }
}
