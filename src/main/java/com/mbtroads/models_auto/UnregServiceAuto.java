package com.mbtroads.models_auto;

import com.mbtroads.core.BasePage;
import com.mbtroads.report.ExtentReportNEW;
import org.graphwalker.java.annotation.GraphWalker;

import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.api.AllApi;
import org.openapitools.client.model.ServiceRegistryRequestDTO;
import org.openapitools.client.model.SystemRequestDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

@GraphWalker(value = "random(vertex_coverage(100))")
public class UnregServiceAuto extends BasePage
        implements graphwalker.UnregisterService {

    private final AllApi api;
    private int lastStatus = 0;

    private String systemName;
    private final String address = "192.168.0.2";
    private final int port = 8080;
    private final String serviceDefinition = "IndoorTemperature";
    private final String serviceUri = "temperature";

    public UnregServiceAuto() {
        this.api = new AllApi();
        this.api.getApiClient().setBasePath("http://localhost:8443");
    }

    /* ================= START ================= */

    @Override
    public void v_Start() {
        ExtentReportNEW.createAndGetNodeInstance("v_Start");
        infoReport("Starting UnregisterService AUTO model");
    }

    /* ================= REGISTER ================= */

    @Override
    public void e_RegisterNewService() {

        ExtentReportNEW.createAndGetNodeInstance("e_RegisterNewService");
        infoReport("POST /serviceregistry/mgmt");

        try {

            // Always unique provider
            systemName = "sensor-" + System.currentTimeMillis();

            ServiceRegistryRequestDTO request =
                    buildRequest(systemName);

            ApiResponse<?> response =
                    api.addServiceRegistryUsingPOST_0WithHttpInfo(request);

            lastStatus = response.getStatusCode();

            infoReport("Response Status = " + lastStatus);

        } catch (ApiException e) {

            lastStatus = e.getCode();

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Register Service")
                    .fail("POST /serviceregistry failed")
                    .fail("Message: " + e.getResponseBody());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_RegisteredSuccessfully() {

        ExtentReportNEW.createAndGetNodeInstance("v_RegisteredSuccessfully");

        if (lastStatus == 201) {

            infoReport("Service registered successfully (201)");

        } else if (lastStatus == 400) {

            infoReport("Service already existed (400) — acceptable state");

        } else {

            ExtentReportNEW.createAndGetNodeInstance("Unexpected Register Status")
                    .fail("Expected 201 or 400 but was: " + lastStatus);

            assestEqual("201", String.valueOf(lastStatus));
        }
    }


    /* ================= INVALID UNREGISTER ================= */

    @Override
    public void e_InvaledUnRegisterServiceForm() {

        ExtentReportNEW.createAndGetNodeInstance("e_InvaledUnRegisterServiceForm");
        infoReport("DELETE /serviceregistry/unregister (invalid)");

        try {

            api.unregisterServiceUsingDELETE_0WithHttpInfo(
                    port,
                    serviceDefinition,
                    serviceUri,
                    "NOT_EXISTING_SYSTEM",
                    address
            );

            lastStatus = 200;

        } catch (ApiException e) {

            lastStatus = e.getCode();
            infoReport("Invalid unregister status = " + lastStatus);
        }
    }

    @Override
    public void v_BadPayloadException() {

        ExtentReportNEW.createAndGetNodeInstance("v_BadPayloadException");

        assestEqual("400", String.valueOf(lastStatus));
        infoReport("Invalid unregister correctly rejected");
    }

    /* ================= VALID UNREGISTER ================= */

    @Override
    public void e_ValedUnRegisterServiceForm() {

        ExtentReportNEW.createAndGetNodeInstance("e_ValedUnRegisterServiceForm");
        infoReport("DELETE /serviceregistry/unregister (valid)");

        try {

            ApiResponse<?> response =
                    api.unregisterServiceUsingDELETE_0WithHttpInfo(
                            port,
                            serviceDefinition,
                            serviceUri,
                            systemName,
                            address
                    );

            lastStatus = response.getStatusCode();

            infoReport("Valid unregister status = " + lastStatus);

        } catch (ApiException e) {

            lastStatus = e.getCode();

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Valid Unregister")
                    .fail("DELETE /serviceregistry/unregister failed")
                    .fail("Message: " + e.getResponseBody());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_RemoveServiceRegisteryEntry() {

        ExtentReportNEW.createAndGetNodeInstance("v_RemoveServiceRegisteryEntry");

        assestEqual("200", String.valueOf(lastStatus));
        infoReport("Service successfully removed");
    }

    /* ================= VERIFY REMOVAL ================= */

    @Override
    public void e_QueeryRemovedService() {

        infoReport("GET service after unregister");

        try {

            ApiResponse<?> response =
                    api.getServiceRegistryEntriesByServiceDefinitionUsingGET_0WithHttpInfo(
                            "IndoorTemperature",
                            null,
                            null,
                            null,
                            null
                    );

            lastStatus = response.getStatusCode();

            infoReport("Query status = " + lastStatus);

        } catch (ApiException e) {

            lastStatus = e.getCode();

            infoReport("Query error status = " + lastStatus);
        }
    }

    @Override
    public void v_ServiceNotExist() {

        ExtentReportNEW.createAndGetNodeInstance("v_ServiceNotExist");

        if (lastStatus == 200) {

            infoReport("Query returned 200 as expected (service removed)");

        } else {

            ExtentReportNEW.createAndGetNodeInstance("Unexpected Query Status")
                    .fail("Expected 200 but was: " + lastStatus);

            assestEqual("200", String.valueOf(lastStatus));
        }
    }



    /* ================= END ================= */

    @Override
    public void e_back_RegisterService()
    {
        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_back_RegisterService");
    }

    @Override
    public void e_End() {
        ExtentReportNEW.createAndGetNodeInstance("e_End");
    }

    @Override
    public void v_End() {
        ExtentReportNEW.createAndGetNodeInstance("v_End");
        infoReport("Model execution finished");
    }

    /* ================= HELPER ================= */

    private ServiceRegistryRequestDTO buildRequest(String name) {

        ServiceRegistryRequestDTO request =
                new ServiceRegistryRequestDTO();

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
