package com.mbtroads.tests;

import com.mbtroads.core.BaseTest;
import com.mbtroads.graph.CreateDotFile;
import com.mbtroads.models.SomeSmallTest;
import com.mbtroads.report.ExtentReport;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;

public class Test_ServiceRegistry extends BaseTest {

    @Test
    public void testExecutor() throws Exception {

        TestExecutor executor = new TestExecutor(SomeSmallTest.class);
        Result result = executor.execute(true);

        int failtest = 0;

        if (result.hasErrors()) {
            StrSplit(result.getResults().toString(2), 0);
            failtest = 1;
            CreateDotFile.ReadFile(
                    "ServiceRegistry",
                    failtest,
                    result.getResults().toString(2)
            );
            ExtentReport.reportError();
        } else {
            StrSplit(result.getResults().toString(2), 1);
            CreateDotFile.ReadFile(
                    "ServiceRegistry",
                    failtest,
                    result.getResults().toString(2)
            );
        }
    }
}
// mvn -q clean graphwalker:generate-sources compile test -Dtest=Test_ServiceRegistry