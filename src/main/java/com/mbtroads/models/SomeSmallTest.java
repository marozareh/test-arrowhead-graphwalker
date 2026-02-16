package com.mbtroads.models;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.data.TestData;
import com.mbtroads.http.HttpClient;
import com.mbtroads.report.ExtentReportNEW;
import graphwalker.SericeRegistry1;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.annotation.Vertex;

@GraphWalker(value = "random(vertex_coverage(100))")
public class SomeSmallTest extends BasePage
        implements SericeRegistry1, TestData, ISystemProperties {

    HttpClient httpClient = new HttpClient();
    HttpResponse response;

    String content;
    String id;
    boolean flag = true;

    String ExistService;
    String ExistName;

    /* =========================================================
       START
       ========================================================= */

    @Override
    public void v_Start() {
        ExtentReportNEW.createAndGetNodeInstance("in Running: v_Start");
        infoReport("Start Service Registry test case");
    }

    /* =========================================================
       SERVICE AVAILABLE
       ========================================================= */

    @Override
    public void e_start() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_start");
        infoReport("Running ServiceAvailable API /serviceregistry/echo");

        response = httpClient.ServiceAvailable("serviceregistery");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Service Available")
                    .fail("GET /serviceregistry/echo failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_RegisterService() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_RegisterService");

        if (flag) {
            assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
            assestContains("Got it!", content);
        } else {
            infoReport("Moving through v_RegisterService");
        }
    }

    /* =========================================================
       INVALID REGISTER
       ========================================================= */

    @Override
    public void e_InvaledServiceRegisteryForm() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_InvaledServiceRegisteryForm");
        infoReport("POST /serviceregistry/mgmt (invalid payload)");

        response = httpClient.sendPost_Query(InvaledServiceRegistery, "mgmt");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Invalid Register")
                    .fail("POST /serviceregistry/mgmt failed (invalid payload)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_BadPayloadException() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_BadPayloadException");
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("BAD_PAYLOAD", content);
    }

    @Override
    public void e_back_RegisterService() {
        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_back_RegisterService");
        flag = false;
    }

    /* =========================================================
       VALID REGISTER
       ========================================================= */

    @Override
    public void e_validServiceRegisteryForm() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_validServiceRegisteryForm");
        infoReport("POST /serviceregistry/mgmt (valid payload)");

        response = httpClient.sendPost_Query(ValidServiceRegistery_Payload, "mgmt");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Valid Register")
                    .fail("POST /serviceregistry/mgmt failed (valid payload)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ValidPayload() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_ValidPayload");

        if (content.contains("already exists")) {
            infoReport("Service already exists");
            assestContains("already exists", content);
        } else {
            assestdonotContains("BAD_PAYLOAD", content);
        }
    }

    /* =========================================================
       NEW SERVICE NOT EXIST
       ========================================================= */

    @Override
    public void e_SerrviceDefinationNotExist() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_SerrviceDefinationNotExist");
        infoReport("POST /serviceregistry/mgmt (new service)");

        response = httpClient.sendPost_Query(NewService, "mgmt");

        ExistService = NewService;
        ExistName = "insecuretemperaturesensor-" + strDate;

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Register New Service")
                    .fail("POST /serviceregistry/mgmt failed (new service)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        id = httpClient.Get_id(content);
    }

    @Override
    public void v_RegisteredService() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_RegisteredService");
        assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    /* =========================================================
       QUERY ALL SERVICES
       ========================================================= */

    @Override
    public void e_SaveService() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_SaveService");
        infoReport("GET /serviceregistry/mgmt");

        response = httpClient.sendGet_All("serviceregistry");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Query All Services")
                    .fail("GET /serviceregistry/mgmt failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_QueryService() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_QueryService");
        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("\"id\":" + id + ",", content);
    }

    /* =========================================================
       QUERY BY ID
       ========================================================= */

    @Override
    public void e_NewServiceExist() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_NewServiceExist");
        infoReport("GET /serviceregistry/mgmt/" + id);

        response = httpClient.sendGet(id, "serviceregistry");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Query By Id")
                    .fail("GET /serviceregistry/mgmt/{id} failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Vertex
    public void v_SucessMesssage() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_SucessMesssage");
        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    @Override
    public void e_back_ValidPayload() {
        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_back_ValidPayload");
    }

    /* =========================================================
       SERVICE EXISTS
       ========================================================= */

    @Override
    public void e_SerrviceDefinationtExist() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_SerrviceDefinationtExist");
        infoReport("POST /serviceregistry/mgmt (service already exists)");

        response = httpClient.sendPost_Query(ExistService, "mgmt");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response Content = " + content);
        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Register Existing Service")
                    .fail("POST /serviceregistry/mgmt failed (already exists)")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        id = httpClient.Get_id(content);
    }

    @Override
    public void v_end() {

        ExtentReportNEW.createAndGetNodeInstance("in Running: v_end");
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));

        infoReport("ExistService = " + ExistService);
        infoReport("content = " + content);

        assestContains(ExistName, content);
    }
}
