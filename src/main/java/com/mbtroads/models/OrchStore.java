package com.mbtroads.models;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.data.TestData;
import com.mbtroads.http.HttpClient;
import com.mbtroads.report.ExtentReportNEW;
import graphwalker.OrchestrationStore;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.graphwalker.java.annotation.GraphWalker;

import java.io.IOException;

@GraphWalker(value = "random(vertex_coverage(100))")
public class OrchStore extends BasePage
        implements OrchestrationStore, TestData, ISystemProperties {

    HttpClient httpClient = new HttpClient();
    HttpResponse response;

    String content_p;
    String content_c;
    String content;

    String provider_name;
    String id_p;
    String id_c;
    String id_ser;
    String id_store;
    String id_interface;
    String service_name;

    String consumer_request;
    String store_request;

    boolean flag = true;

    /* =========================================================
       START
       ========================================================= */

    @Override
    public void v_Start() {
        ExtentReportNEW.createAndGetNodeInstance("in Running: v_Start");
    }

    /* =========================================================
       REGISTER PROVIDER
       ========================================================= */

    @Override
    public void e_RegisterNewService_provider() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_RegisterNewService_provider");
        infoReport("Running /serviceregistry/mgmt (provider)");

        response = httpClient.sendPost_Query(NewService, "mgmt");

        try {
            content_p = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content_p);
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Register Provider")
                    .fail("POST /serviceregistry/mgmt failed (provider)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        id_p = httpClient.Get_id_p(content_p, "provider");
        provider_name = httpClient.Get_id_p(content_p, "servicename");

        infoReport("provider id = " + id_p);
        infoReport("provider name = " + provider_name);
    }

    @Override
    public void v_ServiceRegisteredProvider() {
        ExtentReportNEW.createAndGetNodeInstance("v_ServiceRegisteredProvider");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       REGISTER CONSUMER
       ========================================================= */

    @Override
    public void e_RegisterNewService_Consumer() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_RegisterNewService_Consumer");
        infoReport("Running /serviceregistry/mgmt (consumer)");

        response = httpClient.sendPost_Query(NewServiceConsumer, "mgmt");

        try {
            content_c = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content_c);
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Register Consumer")
                    .fail("POST /serviceregistry/mgmt failed (consumer)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        id_c = httpClient.Get_id_p(content_c, "provider");
        id_ser = httpClient.Get_id_p(content_c, "serviceDefinition");
        id_interface = httpClient.Get_id_p(content_c, "interface");
        service_name = httpClient.Get_id_p(content_c, "servicename");

        infoReport("consumer id = " + id_c);
        infoReport("service id = " + id_ser);
        infoReport("interface id = " + id_interface);
        infoReport("service name = " + service_name);
    }

    @Override
    public void v_ServiceRegisteredConsumer() {
        ExtentReportNEW.createAndGetNodeInstance("v_ServiceRegisteredConsumer");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       AUTHORIZATION SERVICE AVAILABLE
       ========================================================= */

    @Override
    public void e_AuthoneticationSystemAvailabilty() {

        ExtentReportNEW.createAndGetNodeInstance("e_AuthoneticationSystemAvailabilty");
        response = httpClient.ServiceAvailable("authontication");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Authentication Availability")
                    .fail("GET /authontication failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_AuthoenticationServiceAvailable() {
        ExtentReportNEW.createAndGetNodeInstance("v_AuthoenticationServiceAvailable");
        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("Got it!", content);
    }

    /* =========================================================
       REQUEST AUTHORIZATION
       ========================================================= */

    @Override
    public void e_RequestAuthroizationCliud() {

        ExtentReportNEW.createAndGetNodeInstance("e_RequestAuthroizationCliud");

        consumer_request =
                "{ \"consumerId\": " + id_c +
                        ", \"interfaceIds\": [ " + id_interface +
                        " ], \"providerIds\": [ " + id_p +
                        " ], \"serviceDefinitionIds\": [ " + id_ser + " ]}";

        infoReport("Authorization payload = " + consumer_request);

        response = httpClient.sendPost_Query(consumer_request, "requesrauth");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Request Authorization")
                    .fail("POST /requesrauth failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_AuthorizationInterCloudReturned() {
        ExtentReportNEW.createAndGetNodeInstance("v_AuthorizationInterCloudReturned");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("consumer", content);
        assestContains(id_c, content);
    }

    /* =========================================================
       ORCHESTRATOR AVAILABLE
       ========================================================= */

    @Override
    public void e_OrchestrationCoreSystemAvailabilty() {

        ExtentReportNEW.createAndGetNodeInstance("e_OrchestrationCoreSystemAvailabilty");
        response = httpClient.ServiceAvailable("orchestration");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Orchestration Availability")
                    .fail("GET /orchestration failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_CoreServiceAvailable() {
        ExtentReportNEW.createAndGetNodeInstance("v_CoreServiceAvailable");
        if (flag) {
            assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
            assestContains("Got it!", content);
        }
    }

    /* =========================================================
       CREATE STORE (BAD PAYLOAD)
       ========================================================= */

    @Override
    public void e_CreateStoreWithBadPayload() {

        ExtentReportNEW.createAndGetNodeInstance("e_CreateStoreWithBadPayload");

        store_request =
                "[ { \"cloud\": { \"authenticationInfo\": null, \"gatekeeperRelayIds\": [ 0 ], " +
                        "\"gatewayRelayIds\": [ 0 ], \"name\": \"default_insecure_cloud\", \"neighbor\": true, " +
                        "\"operator\": \"default_operator\", \"secure\": true }, \"consumerSystemId\": , " +
                        "\"priority\": 10, \"providerSystem\": { \"address\": \"192.168.0.2\", " +
                        "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\", \"port\": 8080, " +
                        "\"systemName\": \"insecuretemperaturesensor\" }, \"serviceDefinitionName\": " +
                        "\"indoortemperature\", \"serviceInterfaceName\": \"HTTP-INSECURE-JSON\" }]";

        response = httpClient.sendPost_Query(store_request, "createstore");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Create Store Bad Payload")
                    .fail("POST /createstore failed (bad payload)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_BadPayloadException() {
        ExtentReportNEW.createAndGetNodeInstance("v_BadPayloadException");
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    @Override
    public void e_BackAuthorizationInterCloud() {
        flag = false;
    }

    /* =========================================================
       CREATE STORE (VALID)
       ========================================================= */

    @Override
    public void e_CreateStore() {

        ExtentReportNEW.createAndGetNodeInstance("e_CreateStore");

        store_request =
                "[ { \"cloud\": { \"authenticationInfo\": \"default-insecure-cloud\", " +
                        "\"gatekeeperRelayIds\": [ 0 ], \"gatewayRelayIds\": [ 0 ], " +
                        "\"name\": \"default-insecure-cloud\", \"neighbor\": false, " +
                        "\"operator\": \"default-operator\", \"secure\": false }, " +
                        "\"consumerSystemId\": " + id_c + ", \"priority\": 10, " +
                        "\"providerSystem\": { \"address\": \"192.168.0.2\", " +
                        "\"authenticationInfo\": \"eyJhbGciOiJIUzI1Ni...\", \"metadata\": { \"unit\": \"celsius\" }, " +
                        "\"port\": 8080, \"systemName\": \"" + provider_name + "\" }, " +
                        "\"serviceDefinitionName\": \"indoortemperature\", " +
                        "\"serviceInterfaceName\": \"HTTP-INSECURE-JSON\" }]";

        response = httpClient.sendPost_Query(store_request, "createstore");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Create Store")
                    .fail("POST /createstore failed (valid payload)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        id_store = httpClient.Get_id_p(content, "storeid");
        flag = true;
    }

    @Override
    public void v_OrchestratorStoresRequestedParametersCreated() {
        ExtentReportNEW.createAndGetNodeInstance("v_OrchestratorStoresRequestedParametersCreated");
        if (flag) {
            assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        }
    }

    /* =========================================================
       QUERY STORE
       ========================================================= */

    @Override
    public void e_QueryOrchestratorStoreById_NotExists() {

        response = httpClient.sendGet(id_store + "1", "store");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Query Store Not Exists")
                    .fail("GET /store/{id} failed (not exists)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_NoSuchOrchestratorStore() {
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("not found", content);
    }

    @Override
    public void e_BackOrchestratorStores() {
        flag = false;
    }

    @Override
    public void e_QueryOrchestratorStoreById() {

        response = httpClient.sendGet(id_store, "store");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Query Store By Id")
                    .fail("GET /store/{id} failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_RequestedIdReturned() {
        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       QUERY ALL / DELETE
       ========================================================= */

    @Override
    public void e_Query_AllTopPriority() {

        response = httpClient.sendGet_All("storepriority");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Query All Top Priority")
                    .fail("GET /storepriority failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        flag = true;
    }

    @Override
    public void v_ReturnAllTopPriorityOrchestration() {
        if (flag) {
            assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        }
    }

    @Override
    public void e_RemoveOrchestrationIdNotExist() {

        response = httpClient.DeleteServise(id_store + "1", "store");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Delete Store Not Exists")
                    .fail("DELETE /store/{id} failed (not exists)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_CouldNotRemoveOrchestratorStore() {
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    @Override
    public void e_BackPriority() {
        flag = false;
    }

    @Override
    public void e_RemoveOrchestrationIdExist() {

        response = httpClient.DeleteServise(id_store, "store");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Delete Store")
                    .fail("DELETE /store/{id} failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_OrchestratorStoreRemoved() {
        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       END
       ========================================================= */

    @Override
    public void e_End() {
        ExtentReportNEW.createAndGetNodeInstance("e_End");
    }

    @Override
    public void v_End() {
        ExtentReportNEW.createAndGetNodeInstance("v_End");
    }
}
