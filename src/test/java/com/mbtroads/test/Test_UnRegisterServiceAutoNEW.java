package com.mbtroads.test;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.BaseTest;
import com.mbtroads.graph.CreateDotFileNEW;
import com.mbtroads.models_auto.UnregServiceAuto;
import com.mbtroads.report.ExtentReportNEW;
import com.mbtroads.ai.*;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;

import static org.junit.Assert.fail;

public class Test_UnRegisterServiceAutoNEW extends BaseTest {

    @Test
    public void testExecutor() throws Exception {

        String modelName = "UnregisterService_Auto";

        // -------------------------------------------------
        // INIT EXTENT REPORT
        // -------------------------------------------------
        ExtentReportNEW.createReportInstance(
                currentDir + pathSeperator + "Reports_UnregisterService_AUTO" +
                        pathSeperator + modelName + ".html"
        );

        ExtentReportNEW.createTestInstance(
                modelName + " GraphWalker Auto Test"
        );

        // -------------------------------------------------
        // EXECUTE GRAPHWALKER
        // -------------------------------------------------
        TestExecutor executor = new TestExecutor(UnregServiceAuto.class);
        Result result = executor.execute(true);

        boolean hasFailure = result.hasErrors();

        String executionResultString = result.getResults().toString(2);

        StrSplit(executionResultString, hasFailure ? 1 : 0);

        // -------------------------------------------------
        // DOT + PNG GENERATION
        // -------------------------------------------------
        CreateDotFileNEW.ReadFile(
                "UnregisterService",
                BasePage.failedVertices,
                BasePage.failedEdges,
                "Reports_UnregisterService_AUTO"
        );

        // -------------------------------------------------
        // HARD FAIL IF MODEL FAILED
        // -------------------------------------------------
        if (hasFailure) {

            ExtentReportNEW.reportError();

            ExtentReportNEW.createAndGetNodeInstance("Execution Failure")
                    .fail("GraphWalker AUTO execution detected model errors.")
                    .fail(result.getErrors().toString());

            ExtentReportNEW.flushReport();

            fail("GraphWalker AUTO execution failed. Check report.");
        }

        // -------------------------------------------------
        // SNAPSHOT
        // -------------------------------------------------
        ModelExecutionSnapshot snapshot =
                new ModelExecutionSnapshot(
                        modelName,
                        CreateDotFileNEW.getVertexCount(),
                        CreateDotFileNEW.getEdgeCount(),
                        CreateDotFileNEW.getVertexNameSet(),
                        CreateDotFileNEW.getEdgeNameSet(),
                        false
                );

        // -------------------------------------------------
        // AI ANALYSIS
        // -------------------------------------------------
        AIResult aiResult = AIAnalyzer.analyze(snapshot);

        ExtentReportNEW.createAndGetNodeInstance("AI Heuristic Analysis")
                .info(aiResult.toString());

        // -------------------------------------------------
        // STRUCTURE ANALYSIS
        // -------------------------------------------------
        GraphStructureAnalyzer structure =
                GraphStructureAnalyzer.fromJsonFile(
                        "src/main/resources/graphwalker/UnregisterService.json"
                );

        boolean hasCycle = structure.hasCycle();
        int unreachable = structure.countUnreachableVertices("v_Start");
        int selfLoops = structure.countSelfLoops();

        double structuralRisk =
                snapshot.computeStructuralRisk(
                        hasCycle,
                        unreachable,
                        selfLoops
                );

        double qualityScore =
                snapshot.computeQualityScore(
                        hasCycle,
                        unreachable,
                        selfLoops
                );

        ExtentReportNEW.createAndGetNodeInstance("Structural Risk Engine")
                .info("Has Cycle: " + hasCycle)
                .info("Unreachable Vertices: " + unreachable)
                .info("Self Loops: " + selfLoops)
                .info("Structural Risk Score: " + structuralRisk + "/100")
                .info("Model Quality Score: " + qualityScore + "/100");

        // -------------------------------------------------
        // OPTIONAL LLM
        // -------------------------------------------------
        try {

            String llmResponse =
                    DeepModelLLM.analyze(
                            snapshot,
                            hasCycle,
                            unreachable,
                            selfLoops
                    );

           // ExtentReportNEW.createAndGetNodeInstance("LLM Deep Model Analysis")
             //       .info(llmResponse);
            displayLLMAnalysis(llmResponse);

        } catch (Exception e) {

            ExtentReportNEW.createAndGetNodeInstance("LLM Deep Model Analysis")
                    .warning("LLM analysis failed: " + e.getMessage());
        }

        ExtentReportNEW.flushReport();
    }
}
