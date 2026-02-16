package com.mbtroads.test;

import com.mbtroads.core.BasePage;
import com.mbtroads.core.BaseTest;
import com.mbtroads.graph.CreateDotFileNEW;
import com.mbtroads.models.OrchStore;
import com.mbtroads.report.ExtentReportNEW;
import com.mbtroads.ai.*;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.junit.Test;

public class Test_OrchestrationStoreNEW extends BaseTest {

    @Test
    public void testExecutor() throws Exception {

        String modelName = "OrchestrationStore";

        // -------------------------------------------------
        // INIT EXTENT REPORT
        // -------------------------------------------------
        ExtentReportNEW.createReportInstance(
                currentDir + pathSeperator + "Reports_OrchestrationStore" +
                        pathSeperator + modelName + ".html"
        );

        ExtentReportNEW.createTestInstance(
                modelName + " GraphWalker Test"
        );

        try {

            // -------------------------------------------------
            // EXECUTE GRAPHWALKER
            // -------------------------------------------------
            TestExecutor executor = new TestExecutor(OrchStore.class);
            Result result = executor.execute(true);

            boolean hasFailure = result.hasErrors();

            String executionResultString = result.getResults().toString(2);

            // 🔥 This fills BasePage.failedVertices & failedEdges
            StrSplit(executionResultString, hasFailure ? 1 : 0);

            // -------------------------------------------------
            // GENERATE DOT + PNG (CORRECT COLORING)
            // -------------------------------------------------
            CreateDotFileNEW.ReadFile(
                    modelName,
                    BasePage.failedVertices,
                    BasePage.failedEdges,
                    "Reports_OrchestrationStore"
            );

            // -------------------------------------------------
            // FAIL IF MODEL FAILED
            // -------------------------------------------------
            if (hasFailure) {

                ExtentReportNEW.createAndGetNodeInstance("Execution Failure")
                        .fail("GraphWalker execution detected model errors.")
                        .fail(result.getErrors().toString());

                throw new AssertionError("GraphWalker execution failed.");
            }

            // -------------------------------------------------
            // EXECUTION SNAPSHOT
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
            // HEURISTIC AI ANALYSIS
            // -------------------------------------------------
            AIResult aiResult = AIAnalyzer.analyze(snapshot);

            ExtentReportNEW.createAndGetNodeInstance("AI Heuristic Analysis")
                    .info(aiResult.toString());

            // -------------------------------------------------
            // STRUCTURAL ANALYSIS
            // -------------------------------------------------
            GraphStructureAnalyzer structure =
                    GraphStructureAnalyzer.fromJsonFile(
                            "src/main/resources/graphwalker/" + modelName + ".json"
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
            // OPTIONAL LLM ANALYSIS
            // -------------------------------------------------
            try {

                String llmResponse =
                        DeepModelLLM.analyze(
                                snapshot,
                                hasCycle,
                                unreachable,
                                selfLoops
                        );

                ExtentReportNEW.createAndGetNodeInstance("LLM Deep Model Analysis")
                        .info(llmResponse);

            } catch (Exception e) {

                ExtentReportNEW.createAndGetNodeInstance("LLM Deep Model Analysis")
                        .warning("LLM analysis failed: " + e.getMessage());
            }

        } catch (Throwable t) {

            ExtentReportNEW.createAndGetNodeInstance("Fatal Execution Error")
                    .fail("Unexpected error: " + t.getMessage());

            throw t;

        } finally {

            ExtentReportNEW.flushReport();
        }
    }
}
