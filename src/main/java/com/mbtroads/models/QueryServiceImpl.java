package com.mbtroads.models;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.data.TestData;
import com.mbtroads.http.HttpClient;
import com.mbtroads.report.ExtentReport;
import graphwalker.SericeQuery;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.graphwalker.java.annotation.GraphWalker;

import java.io.IOException;

@GraphWalker(value = "random(vertex_coverage(100))")
public class QueryServiceImpl extends BasePage
        implements SericeQuery, TestData, ISystemProperties {


        HttpClient httpClient = new HttpClient();
    HttpResponse response;
    String content = null;
    String id = null;
    boolean flag = true;

    /* =========================================================
       START
       ========================================================= */

    @Override
    public void v_Start() {
        extendReport("v_Start");
        infoReport("Start Service Query test case");
    }

    /* =========================================================
       SERVICE AVAILABLE
       ========================================================= */

    @Override
    public void e_start() {
        extendReport("e_start");
        infoReport("Moving Through: e_start");
        infoReport("Running Service Available /serviceregistry/echo");

        response = httpClient.ServiceAvailable("serviceregistery");
        HttpEntity entity = response.getEntity();

        try {
            content = EntityUtils.toString(entity);
        } catch (IOException e) {
            ExtentReport.node.fail("Service has a problem");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_QueryService() {
        extendReport("v_QueryService");
        infoReport("Validating in: v_QueryService");

        if (flag) {
            assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
            assestContains("Got it!", content);
        }
    }

    /* =========================================================
       INVALID QUERY
       ========================================================= */

    @Override
    public void e_InvaledServiceQuerForm() {
        extendReport("e_InvaledServiceQuerForm");
        infoReport("Moving Through: e_InvaledServiceQuerForm");
        infoReport("Running : /serviceregistry/query with invalid payload");

        response = httpClient.sendPost_Query(InvaledServiceQuery, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_BadPayloadException() {
        extendReport("v_BadPayloadException");
        infoReport("Validating in: v_BadPayloadException");

        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("BAD_PAYLOAD", content);
    }

    @Override
    public void e_back_QueryService() {
        extendReport("e_back_QueryService");
        infoReport("Moving Through: e_back_QueryService");
        flag = false;
    }

    /* =========================================================
       VALID QUERY
       ========================================================= */

    @Override
    public void e_validServiceQueryForm() {
        extendReport("e_validServiceQueryForm");
        infoReport("Running : /serviceregistry/query with valid payload");

        response = httpClient.sendPost_Query(ValidServiceQuery_Payload, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ValidPayload() {
        extendReport("v_ValidPayload");
        infoReport("Validating in: v_ValidPayload");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestdonotContains("BAD_PAYLOAD", content);
    }

    /* =========================================================
       INTERFACE FILTER
       ========================================================= */

    @Override
    public void e_back_ValidPayload() {
        extendReport("e_back_ValidPayload");
    }

    @Override
    public void e_QueryInterfaceNotDefined() {
        extendReport("e_QueryInterfaceNotDefined");
        infoReport("Running query with undefined interface");

        response = httpClient.sendPost_Query(InterfaceNotDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ServiceQueryInterfaceNotDefined() {
        extendReport("v_ServiceQueryInterfaceNotDefined");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestContains("[]", content);
        assestdonotContains("indoortemperature", content);
    }

    @Override
    public void e_QueryInterfaceDefined() {
        extendReport("e_QueryInterfaceDefined");
        infoReport("Running query with defined interface");

        response = httpClient.sendPost_Query(InterfaceDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_FilterOnInterface() {
        extendReport("v_FilterOnInterface");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestdonotContains("[]", content);
        assestContains("indoortemperature", content);
    }

    /* =========================================================
       SECURITY FILTER
       ========================================================= */

    @Override
    public void e_QuerySecurityTypeNotDefined() {
        extendReport("e_QuerySecurityTypeNotDefined");

        response = httpClient.sendPost_Query(SecureNotDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ServiceQuerySecurityTypeNotDefined() {
        extendReport("v_ServiceQuerySecurityTypeNotDefined");
        assestEqual("400", String.valueOf(response.getStatusLine().getStatusCode()));
    }

    @Override
    public void e_QuerySecurtyDefined() {
        extendReport("e_QuerySecurtyDefined");

        response = httpClient.sendPost_Query(SecureDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_FilterOnSecurity() {
        extendReport("v_FilterOnSecurity");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestdonotContains("[]", content);
        assestContains("indoortemperature", content);
    }

    /* =========================================================
       VERSION FILTER
       ========================================================= */

    @Override
    public void e_QueryVersionNotDefined() {
        extendReport("e_QueryVersionNotDefined");

        response = httpClient.sendPost_Query(VersionNotDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ServiceQueryVersionNotDefined() {
        extendReport("v_ServiceQueryVersionNotDefined");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestContains("[]", content);
        assestdonotContains("indoortemperature", content);
    }

    @Override
    public void e_QueryVersionDefined() {
        extendReport("e_QueryVersionDefined");

        response = httpClient.sendPost_Query(VersionDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_FilterOnVersion() {
        extendReport("v_FilterOnVersion");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestdonotContains("[]", content);
        assestContains("indoortemperature", content);
    }

    /* =========================================================
       METADATA FILTER
       ========================================================= */

    @Override
    public void e_QueryMetadatNotDefined() {
        extendReport("e_QueryMetadatNotDefined");

        response = httpClient.sendPost_Query(MetaDataNotDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_ServiceQueryMetadataNotDefined() {
        extendReport("v_ServiceQueryMetadataNotDefined");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestContains("[]", content);
        assestdonotContains("indoortemperature", content);
    }

    @Override
    public void e_QueryMetadataDefined() {
        extendReport("e_QueryMetadataDefined");

        response = httpClient.sendPost_Query(MetaDataDefined, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_FilterOnMetadata() {
        extendReport("v_FilterOnMetadata");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestdonotContains("[]", content);
        assestContains("indoortemperature", content);
    }

    /* =========================================================
       PING PROVIDERS
       ========================================================= */

    @Override
    public void e_PingProvider() {
        extendReport("e_PingProvider");

        response = httpClient.sendPost_Query(PingProviders, "query");

        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void v_QueryResponce() {
        extendReport("v_QueryResponce");

        assestEqual("200", String.valueOf(response.getStatusLine().getStatusCode()));
        assestContains("serviceQueryData", content);
        assestContains("[]", content);
        assestdonotContains("indoortemperature", content);
    }
}
