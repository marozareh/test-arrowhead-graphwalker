package com.mbtroads.models;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.data.TestData;
import com.mbtroads.http.HttpClient;
import com.mbtroads.report.ExtentReport;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.graphwalker.java.annotation.GraphWalker;
import graphwalker.UnregisterService;
import java.io.IOException;

@GraphWalker(value = "random(vertex_coverage(100))")
public class UnregService extends BasePage
        implements UnregisterService, TestData, ISystemProperties {

    HttpClient httpClient = new HttpClient();
    HttpResponse response;

    String content;
    String id;
    String ServiceName;

    boolean flag = true;

    /* =========================================================
       START
       ========================================================= */

    @Override
    public void v_Start() {
        ExtentReport.createAndGetNodeInstance("in Running: v_Start");
    }

    /* =========================================================
       REGISTER SERVICE
       ========================================================= */

    @Override
    public void e_RegisterNewService() {

        ExtentReport.createAndGetNodeInstance("Moving Through: e_RegisterNewService");
        infoReport("POST /serviceregistry/mgmt (register)");

        response = httpClient.sendPost_Query(NewService, "mgmt");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ServiceName = httpClient.Get_name(content);
        id = httpClient.Get_id(content);

        infoReport("ServiceName = " + ServiceName);
        infoReport("ServiceId = " + id);
    }

    @Override
    public void v_RegisteredSuccessfully() {
        ExtentReport.createAndGetNodeInstance("v_RegisteredSuccessfully");
        if (flag) {
            assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
        }
    }

    /* =========================================================
       INVALID UNREGISTER
       ========================================================= */

    @Override
    public void e_InvaledUnRegisterServiceForm() {

        ExtentReport.createAndGetNodeInstance("e_InvaledUnRegisterServiceForm");
        infoReport("DELETE /serviceregistry/unregister (invalid)");

        response = httpClient.DeleteServise(UnregisterService, "serviceregistry");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_BadPayloadException() {
        infoReport("Validating v_BadPayloadException");

        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("INVALID_PARAMETER", content);
    }

    @Override
    public void e_back_RegisterService() {
        flag = false;
    }

    /* =========================================================
       VALID UNREGISTER
       ========================================================= */

    @Override
    public void e_ValedUnRegisterServiceForm() {

        ExtentReport.createAndGetNodeInstance("e_ValedUnRegisterServiceForm");
        infoReport("DELETE /serviceregistry/unregister (valid)");

        response = httpClient.DeleteServise(registerService + ServiceName, "serviceregistry");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_RemoveServiceRegisteryEntry() {

        ExtentReport.createAndGetNodeInstance("v_RemoveServiceRegisteryEntry");
        infoReport("failCase flag = " + HttpClient.failCase_Test);

        if (HttpClient.failCase_Test.equals("false")) {
            assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        } else {
            assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
        }
    }

    /* =========================================================
       VERIFY REMOVAL
       ========================================================= */

    @Override
    public void e_QueeryRemovedService() {

        ExtentReport.createAndGetNodeInstance("e_QueeryRemovedService");
        infoReport("GET /serviceregistry/mgmt/" + id);

        response = httpClient.sendGet(id, "serviceregistry");

        try {
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ServiceNotExist() {

        ExtentReport.createAndGetNodeInstance("v_ServiceNotExist");
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("does not exist", content);
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
