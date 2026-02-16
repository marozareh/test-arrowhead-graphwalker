package com.mbtroads.models;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.data.TestData;
import com.mbtroads.http.HttpClient;
import com.mbtroads.report.ExtentReportNEW;
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
        ExtentReportNEW.createAndGetNodeInstance("in Running: v_Start");
    }

    /* =========================================================
       REGISTER SERVICE
       ========================================================= */

    @Override
    public void e_RegisterNewService() {

        ExtentReportNEW.createAndGetNodeInstance("Moving Through: e_RegisterNewService");
        infoReport("POST /serviceregistry/mgmt (register)");

        try {
            response = httpClient.sendPost_Query(NewService, "mgmt");

            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);

        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Register Service")
                    .fail("POST /serviceregistry/mgmt failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }

        ServiceName = httpClient.Get_name(content);
        id = httpClient.Get_id(content);

        infoReport("ServiceName = " + ServiceName);
        infoReport("ServiceId = " + id);
    }

    @Override
    public void v_RegisteredSuccessfully() {
        ExtentReportNEW.createAndGetNodeInstance("v_RegisteredSuccessfully");

        if (flag) {
            assestEqual("201", String.valueOf(response.getStatusLine().getStatusCode()));
        }
    }

    /* =========================================================
       INVALID UNREGISTER
       ========================================================= */

    @Override
    public void e_InvaledUnRegisterServiceForm() {

        ExtentReportNEW.createAndGetNodeInstance("e_InvaledUnRegisterServiceForm");
        infoReport("DELETE /serviceregistry/unregister (invalid)");

        try {

            response = httpClient.DeleteServise(UnregisterService, "serviceregistry");
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);

        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Invalid Unregister")
                    .fail("DELETE /serviceregistry/unregister failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_BadPayloadException() {

        ExtentReportNEW.createAndGetNodeInstance("v_BadPayloadException");

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

        ExtentReportNEW.createAndGetNodeInstance("e_ValedUnRegisterServiceForm");
        infoReport("DELETE /serviceregistry/unregister (valid)");

        try {

            response = httpClient.DeleteServise(registerService + ServiceName, "serviceregistry");
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);

        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Valid Unregister")
                    .fail("DELETE /serviceregistry/unregister failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_RemoveServiceRegisteryEntry() {

        ExtentReportNEW.createAndGetNodeInstance("v_RemoveServiceRegisteryEntry");
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

        ExtentReportNEW.createAndGetNodeInstance("e_QueeryRemovedService");
        infoReport("GET /serviceregistry/mgmt/" + id);

        try {

            response = httpClient.sendGet(id, "serviceregistry");
            content = EntityUtils.toString(response.getEntity());
            infoReport("Response = " + content);

        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("HTTP FAILURE - Query Removed Service")
                    .fail("GET /serviceregistry/mgmt failed")
                    .fail(e.getMessage());

            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ServiceNotExist() {

        ExtentReportNEW.createAndGetNodeInstance("v_ServiceNotExist");

        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("does not exist", content);
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
