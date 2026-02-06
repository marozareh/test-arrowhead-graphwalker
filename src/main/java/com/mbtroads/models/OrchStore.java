package com.mbtroads.models;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.data.TestData;
import com.mbtroads.http.HttpClient;
import com.mbtroads.report.ExtentReport;
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
        ExtentReport.createAndGetNodeInstance("in Running: v_Start");
    }

    /* =========================================================
       REGISTER PROVIDER
       ========================================================= */

    @Override
    public void e_RegisterNewService_provider() {

        ExtentReport.createAndGetNodeInstance("Moving Through: e_RegisterNewService_provider");
        infoReport("Running /serviceregistry/mgmt (provider)");

        response = httpClient.sendPost_Query(NewService, "mgmt");

        try {
            content_p = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content_p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        id_p = httpClient.Get_id_p(content_p, "provider");
        provider_name = httpClient.Get_id_p(content_p, "servicename");

        infoReport("provider id = " + id_p);
        infoReport("provider name = " + provider_name);
    }

    @Override
    public void v_ServiceRegisteredProvider() {
        ExtentReport.createAndGetNodeInstance("v_ServiceRegisteredProvider");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       REGISTER CONSUMER
       ========================================================= */

    @Override
    public void e_RegisterNewService_Consumer() {

        ExtentReport.createAndGetNodeInstance("Moving Through: e_RegisterNewService_Consumer");
        infoReport("Running /serviceregistry/mgmt (consumer)");

        response = httpClient.sendPost_Query(NewServiceConsumer, "mgmt");

        try {
            content_c = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content_c);
        } catch (IOException e) {
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
        ExtentReport.createAndGetNodeInstance("v_ServiceRegisteredConsumer");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       AUTHORIZATION SERVICE AVAILABLE
       ========================================================= */

    @Override
    public void e_AuthoneticationSystemAvailabilty() {

        ExtentReport.createAndGetNodeInstance("e_AuthoneticationSystemAvailabilty");
        response = httpClient.ServiceAvailable("authontication");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_AuthoenticationServiceAvailable() {
        ExtentReport.createAndGetNodeInstance("v_AuthoenticationServiceAvailable");
        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("Got it!", content);
    }

    /* =========================================================
       REQUEST AUTHORIZATION
       ========================================================= */

    @Override
    public void e_RequestAuthroizationCliud() {

        ExtentReport.createAndGetNodeInstance("e_RequestAuthroizationCliud");

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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_AuthorizationInterCloudReturned() {
        ExtentReport.createAndGetNodeInstance("v_AuthorizationInterCloudReturned");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("consumer", content);
        assestContains(id_c, content);
    }

    /* =========================================================
       ORCHESTRATOR AVAILABLE
       ========================================================= */

    @Override
    public void e_OrchestrationCoreSystemAvailabilty() {

        ExtentReport.createAndGetNodeInstance("e_OrchestrationCoreSystemAvailabilty");
        response = httpClient.ServiceAvailable("orchestration");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_CoreServiceAvailable() {
        ExtentReport.createAndGetNodeInstance("v_CoreServiceAvailable");
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

        ExtentReport.createAndGetNodeInstance("e_CreateStoreWithBadPayload");

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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_BadPayloadException() {
        ExtentReport.createAndGetNodeInstance("v_BadPayloadException");
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

        ExtentReport.createAndGetNodeInstance("e_CreateStore");

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
            throw new RuntimeException(e);
        }

        id_store = httpClient.Get_id_p(content, "storeid");
        flag = true;
    }

    @Override
    public void v_OrchestratorStoresRequestedParametersCreated() {
        ExtentReport.createAndGetNodeInstance("v_OrchestratorStoresRequestedParametersCreated");
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
        ExtentReport.createAndGetNodeInstance("e_End");
    }

    @Override
    public void v_End() {
        ExtentReport.createAndGetNodeInstance("v_End");
    }
}
