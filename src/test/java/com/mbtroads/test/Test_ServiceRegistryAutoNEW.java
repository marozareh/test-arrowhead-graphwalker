package com.mbtroads.test;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.BaseTest;
import com.mbtroads.graph.CreateDotFileNEW;
import com.mbtroads.models_auto.ServiceRegistryAuto;
import com.mbtroads.report.ExtentReportNEW;
import com.mbtroads.ai.*;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;

import static org.junit.Assert.fail;

public class Test_ServiceRegistryAutoNEW extends BaseTest {

    @Test
    public void testExecutor() throws Exception {

        String modelName = "ServiceRegistry_Auto";

        /* -------------------------------------------------
           INIT EXTENT REPORT
           ------------------------------------------------- */
        ExtentReportNEW.createReportInstance(
                currentDir + pathSeperator +
                        "Reports_ServiceRegistry_AUTO" +
                        pathSeperator +
                        modelName + ".html"
        );

        ExtentReportNEW.createTestInstance(
                modelName + " GraphWalker Auto Test"
        );

        /* -------------------------------------------------
           EXECUTE GRAPHWALKER
           ------------------------------------------------- */
        CoverageTracker.clear();
        TestExecutor executor =
                new TestExecutor(ServiceRegistryAuto.class);

        Result result = executor.execute(true);

        boolean hasFailure = result.hasErrors();
        String executionResultString =
                result.getResults().toString(2);

        StrSplit(executionResultString, hasFailure ? 1 : 0);

        /* -------------------------------------------------
           DOT + PNG GENERATION
           ------------------------------------------------- */
        CreateDotFileNEW.ReadFile(
                "ServiceRegistry",
                BasePage.failedVertices,
                BasePage.failedEdges,
                "Reports_ServiceRegistry_AUTO"
        );

        /* -------------------------------------------------
           HARD FAIL IF MODEL FAILED
           ------------------------------------------------- */
        if (hasFailure) {

            ExtentReportNEW.reportError();

            ExtentReportNEW.createAndGetNodeInstance("Execution Failure")
                    .fail("GraphWalker AUTO execution detected model errors.")
                    .fail(result.getErrors().toString());

            ExtentReportNEW.flushReport();

            fail("GraphWalker AUTO execution failed. Check report.");
        }

        /* -------------------------------------------------
           SNAPSHOT
           ------------------------------------------------- */
        ModelExecutionSnapshot snapshot =
                new ModelExecutionSnapshot(
                        modelName,
                        CreateDotFileNEW.getVertexCount(),
                        CreateDotFileNEW.getEdgeCount(),
                        CreateDotFileNEW.getVertexNameSet(),
                        CreateDotFileNEW.getEdgeNameSet(),
                        false
                );

        /* -------------------------------------------------
           AI HEURISTIC ANALYSIS
           ------------------------------------------------- */
        AIResult aiResult = AIAnalyzer.analyze(snapshot);

        ExtentReportNEW.createAndGetNodeInstance("AI Heuristic Analysis")
                .info(aiResult.toString());

        /* -------------------------------------------------
           STRUCTURAL ANALYSIS (Required for LLM)
           ------------------------------------------------- */
        GraphStructureAnalyzer structure =
                GraphStructureAnalyzer.fromJsonFile(
                        "src/main/resources/graphwalker/ServiceRegistry.json"
                );

        boolean hasCycle = structure.hasCycle();
        int unreachable = structure.countUnreachableVertices("v_Start");
        int selfLoops = structure.countSelfLoops();

        ExtentReportNEW.createAndGetNodeInstance("Structural Metrics")
                .info("Has Cycle: " + hasCycle)
                .info("Unreachable Vertices: " + unreachable)
                .info("Self Loops: " + selfLoops);

        /* -------------------------------------------------
           OPTIONAL LLM – SPEC/MODEL GAP DETECTION
           ------------------------------------------------- */
        try {

            String apiSummary =
                    OpenApiSummaryExtractor.generateSummary(
                            "http://localhost:8443/v2/api-docs"
                    );



            String modeledSummary = CoverageTracker.generateSummary();

            String combinedInput =
                    "OpenAPI Specification:\n" +
                            apiSummary +
                            "\n\nModeled Coverage:\n" +
                            modeledSummary;

            String llmResponse =
                    DeepModelLLMNEW.analyze(
                            snapshot,
                            hasCycle,
                            unreachable,
                            selfLoops,
                            DeepModelLLMNEW.Mode.GAP_DETECTION,
                            combinedInput
                    );

           // ExtentReportNEW.createAndGetNodeInstance("AI Spec–Model Gap Detection")
             //       .info(llmResponse);
            displayLLMAnalysis(llmResponse);


        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("LLM Analysis Warning")
                    .warning("LLM analysis failed: " + e.getMessage());
        }

        ExtentReportNEW.flushReport();
    }
}