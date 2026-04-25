package com.mbtroads.models_auto;

import com.mbtroads.core.BasePage;
import com.mbtroads.report.ExtentReportNEW;
import graphwalker.SericeRegistry1;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.Vertex;

import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.api.AllApi;
import org.openapitools.client.model.ServiceRegistryRequestDTO;
import org.openapitools.client.model.ServiceRegistryResponseDTO;
import org.openapitools.client.model.SystemRequestDTO;

import com.mbtroads.ai.CoverageTracker;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@GraphWalker(value = "random(vertex_coverage(100))")
public class ServiceRegistryAuto extends BasePage
        implements SericeRegistry1 {

    private final AllApi api;
    private int lastStatus = 0;

    private String systemName;
    private Long serviceId;

    private final String address = "192.168.0.2";
    private final int port = 8080;
    private final String serviceDefinition = "IndoorTemperature";
    private final String serviceUri = "temperature";

    public ServiceRegistryAuto() {
        this.api = new AllApi();
        this.api.getApiClient().setBasePath("http://localhost:8443");
    }

    /* =========================================================
       START
       ========================================================= */

    @Override
    public void v_Start() {
        ExtentReportNEW.createAndGetNodeInstance("v_Start");
        infoReport("Start Service Registry AUTO test");
    }

    /* =========================================================
       SERVICE AVAILABLE (ECHO)
       ========================================================= */

    @Override
    public void e_start() {

        ExtentReportNEW.createAndGetNodeInstance("e_start");

        try {
            ApiResponse<String> response =
                    api.echoServiceUsingGET_0WithHttpInfo();

            lastStatus = response.getStatusCode();
            CoverageTracker.record("GET", "/serviceregistry/echo", lastStatus);

        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Override
    public void v_RegisterService() {

        ExtentReportNEW.createAndGetNodeInstance("v_RegisterService");

        if (lastStatus == 200) {

            infoReport("Service registered successfully (201)");

        } else if (lastStatus == 400) {

            infoReport("Service already existed (400) — acceptable state");

        } else {

            ExtentReportNEW.createAndGetNodeInstance("Unexpected Register Status")
                    .fail("Expected 201 or 400 but was: " + lastStatus);

            assestEqual("201", String.valueOf(lastStatus));
        }
    }

    /* =========================================================
       INVALID REGISTER
       ========================================================= */

    @Override
    public void e_InvaledServiceRegisteryForm() {

        ExtentReportNEW.createAndGetNodeInstance("e_InvaledServiceRegisteryForm");

        try {
            ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO();
            api.addServiceRegistryUsingPOST_0WithHttpInfo(request);
            lastStatus = 200;
            CoverageTracker.record("POST", "/serviceregistry/mgmt", lastStatus);
        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Override
    public void v_BadPayloadException() {
        ExtentReportNEW.createAndGetNodeInstance("v_BadPayloadException");
        assestEqual("400", String.valueOf(lastStatus));
    }

    @Override
    public void e_back_RegisterService() {
        ExtentReportNEW.createAndGetNodeInstance("e_back_RegisterService");
    }

    /* =========================================================
       VALID REGISTER
       ========================================================= */

    @Override
    public void e_validServiceRegisteryForm() {

        ExtentReportNEW.createAndGetNodeInstance("e_validServiceRegisteryForm");

        try {

            systemName = "sensor-" + System.currentTimeMillis();

            ServiceRegistryRequestDTO request =
                    buildRequest(systemName);

            ApiResponse<ServiceRegistryResponseDTO> response =
                    api.addServiceRegistryUsingPOST_0WithHttpInfo(request);

            lastStatus = response.getStatusCode();
            CoverageTracker.record("POST", "/serviceregistry/mgmt", lastStatus);
            if (response.getData() != null) {
                serviceId = response.getData().getId();
            }

        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Override
    public void v_ValidPayload() {

        ExtentReportNEW.createAndGetNodeInstance("v_ValidPayload"+ lastStatus);

        if (lastStatus == 200) {
            infoReport("Service created");
        } else if (lastStatus == 400) {
            infoReport("Service already exists");
        } else {
            assestEqual("201", String.valueOf(lastStatus));
        }
    }

    /* =========================================================
       NEW SERVICE NOT EXIST
       ========================================================= */

    @Override
    public void e_SerrviceDefinationNotExist() {

        ExtentReportNEW.createAndGetNodeInstance("e_SerrviceDefinationNotExist");

        try {

            systemName = "sensor-" + System.currentTimeMillis();

            ServiceRegistryRequestDTO request =
                    buildRequest(systemName);

            ApiResponse<ServiceRegistryResponseDTO> response =
                    api.addServiceRegistryUsingPOST_0WithHttpInfo(request);

            lastStatus = response.getStatusCode();
            CoverageTracker.record("POST", "/serviceregistry/mgmt", lastStatus);

            if (response.getData() != null) {
                serviceId = response.getData().getId();
            }

        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Override
    public void v_RegisteredService() {
        ExtentReportNEW.createAndGetNodeInstance("v_RegisteredService");
        assestEqual("201", String.valueOf(lastStatus));
    }

    /* =========================================================
       QUERY ALL SERVICES
       ========================================================= */

    @Override
    public void e_SaveService() {

        ExtentReportNEW.createAndGetNodeInstance("e_SaveService");

        try {
            ApiResponse<?> response =
                    api.getServiceRegistryEntriesUsingGET_0WithHttpInfo(
                            null, null, null, null);

            lastStatus = response.getStatusCode();
            CoverageTracker.record("GET", "/serviceregistry/mgmt", lastStatus);

        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Override
    public void v_QueryService() {
        ExtentReportNEW.createAndGetNodeInstance("v_QueryService");
        assestEqual("200", String.valueOf(lastStatus));
    }

    /* =========================================================
       QUERY BY ID
       ========================================================= */

    @Override
    public void e_NewServiceExist() {

        ExtentReportNEW.createAndGetNodeInstance("e_NewServiceExist");

        try {
            ApiResponse<ServiceRegistryResponseDTO> response =
                    api.getServiceRegistryEntryByIdUsingGET_0WithHttpInfo(serviceId);

            lastStatus = response.getStatusCode();
            CoverageTracker.record("GET", "/serviceregistry/mgmt/{id}", lastStatus);

        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Vertex
    public void v_SucessMesssage() {
        ExtentReportNEW.createAndGetNodeInstance("v_SucessMesssage");
        assestEqual("200", String.valueOf(lastStatus));
    }

    @Override
    public void e_back_ValidPayload() {
        ExtentReportNEW.createAndGetNodeInstance("e_back_ValidPayload");
    }

    /* =========================================================
       SERVICE EXISTS
       ========================================================= */

    @Override
    public void e_SerrviceDefinationtExist() {

        ExtentReportNEW.createAndGetNodeInstance("e_SerrviceDefinationtExist");

        try {

            ServiceRegistryRequestDTO request =
                    buildRequest(systemName);

            ApiResponse<ServiceRegistryResponseDTO> response =
                    api.addServiceRegistryUsingPOST_0WithHttpInfo(request);

            lastStatus = response.getStatusCode();
            CoverageTracker.record("POST", "/serviceregistry/mgmt", lastStatus);

        } catch (ApiException e) {
            lastStatus = e.getCode();
        }
    }

    @Override
    public void v_end() {
        ExtentReportNEW.createAndGetNodeInstance("v_end");
        assestEqual("400", String.valueOf(lastStatus));
    }

    /* =========================================================
       HELPER
       ========================================================= */

    private ServiceRegistryRequestDTO buildRequest(String name) {

        ServiceRegistryRequestDTO request = new ServiceRegistryRequestDTO();

        request.setServiceDefinition(serviceDefinition);
        request.setServiceUri(serviceUri);
        request.setSecure("NOT_SECURE");
        request.setVersion(1);

        SystemRequestDTO provider = new SystemRequestDTO();
        provider.setSystemName(name);
        provider.setAddress(address);
        provider.setPort(port);
        provider.setAuthenticationInfo("test-auth");

        request.setProviderSystem(provider);

        Map<String, String> metadata = new HashMap<>();
        metadata.put("unit", "celsius");
        request.setMetadata(metadata);

        request.setInterfaces(
                Collections.singletonList("HTTP-INSECURE-JSON")
        );

        request.setEndOfValidity("2026-12-31T23:59:59Z");

        return request;
    }
}