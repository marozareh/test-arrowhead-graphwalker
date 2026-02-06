package com.mbtroads.tests;

import com.mbtroads.core.BaseTest;
import com.mbtroads.graph.CreateDotFile;
import com.mbtroads.models.OrchStore;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;

public class Test_OrchestrationStore extends BaseTest {

    @Test
    public void testExecutor() throws Exception {

        TestExecutor executor = new TestExecutor(OrchStore.class);
        Result result = executor.execute(true);

        int failtest = 0;

        if (result.hasErrors()) {
            StrSplit(result.getResults().toString(2), 0);
            failtest = 1;
            CreateDotFile.ReadFile(
                    "OrchestrationStore",
                    failtest,
                    result.getResults().toString(2)
            );
        } else {
            StrSplit(result.getResults().toString(2), 1);
            CreateDotFile.ReadFile(
                    "OrchestrationStore",
                    failtest,
                    result.getResults().toString(2)
            );
        }
    }
}
