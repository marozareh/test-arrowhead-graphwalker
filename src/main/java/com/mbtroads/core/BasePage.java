package com.mbtroads.core;

import com.mbtroads.report.ExtentReport;
import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public abstract class BasePage extends ExecutionContext {

    public void StrSplit(String strMain, int result) {

        String[] arrSplit = strMain.split(",");
        int i = 1;
        int firstVertex = 0;
        int firstEdge = 0;

        String[] summaryReport = new String[30];
        String[] summaryTest = new String[]{
                "totalNumberOfModels",
                "totalFailedNumberOfModels",
                "totalIncompleteNumberOfModels",
                "totalCompletedNumberOfModels",
                "totalNotExecutedNumberOfModels",
                "totalNumberOfEdges",
                "totalNumberOfVisitedEdges",
                "totalNumberOfUnvisitedEdges",
                "edgeCoverage",
                "totalNumberOfVertices",
                "totalNumberOfVisitedVertices",
                "totalNumberOfUnvisitedVertices",
                "vertexCoverage",
        };

        int summaryCount = 0;

        if (result == 1) {
            ExtentReport.createAndGetNodeInstance("GraphWalker Result PASS");
        } else {
            ExtentReport.createAndGetNodeInstance("GraphWalker Result Summary");
            ExtentReport.node.fail("Error in the Model");
        }

        while (i < arrSplit.length) {

            if (result == 1) {
                ExtentReport.node.pass(arrSplit[i]);
            } else if (arrSplit[i].contains("vertexName")) {

                if (firstVertex == 0) {
                    ExtentReport.node.fail("=============> Failed Vertices <=============");
                    firstVertex = 1;
                }

                String temp = arrSplit[i]
                        .replace("}", "")
                        .replace("]", "");
                ExtentReport.node.fail(temp);
                i++;

            } else if (arrSplit[i].contains("edgeId")) {

                if (firstEdge == 0) {
                    ExtentReport.node.fail("=============> Failed Edges <=============");
                    firstEdge = 1;
                }

                String temp = arrSplit[i + 1]
                        .replace("}", "")
                        .replace("]", "");
                ExtentReport.node.fail(temp);
                i++;

            } else if (!arrSplit[i].contains("modelName")) {
                summaryReport[summaryCount++] = arrSplit[i];
            }

            i++;
        }

        if (result == 0) {
            ExtentReport.node.fail("=============> Failed Summary <=============");

            for (int j = 0; j < summaryCount; j++) {
                summaryReport[j] = summaryReport[j]
                        .replace("\"", "")
                        .replace("}", "");
            }

            for (String key : summaryTest) {
                for (int j = 0; j < summaryCount; j++) {
                    if (summaryReport[j].trim().contains(key)) {
                        ExtentReport.node.fail(summaryReport[j]);
                        break;
                    }
                }
            }
        }
    }

    public void assestEqual(String expectedValue, String actualValue) {
        try {
            assertEquals(expectedValue, actualValue);
            ExtentReport.node.pass("Assertion Equal OK: " + expectedValue);
        } catch (AssertionError e) {
            ExtentReport.node.fail("Assertion Equal FAILED: " + expectedValue);
            throw new CustomException(e);
        }
    }

    public void assestContains(String expectedValue, String actualValue) {
        try {
            Assert.assertTrue(actualValue.contains(expectedValue));
            ExtentReport.node.pass("Assertion Contains OK: " + expectedValue);
        } catch (AssertionError e) {
            ExtentReport.node.fail("Assertion Contains FAILED: " + expectedValue);
            throw new CustomException(e);
        }
    }

    public void assestdonotContains(String expectedValue, String actualValue) {
        try {
            Assert.assertFalse(actualValue.contains(expectedValue));
            ExtentReport.node.pass("Assertion Not-Contains OK: " + expectedValue);
        } catch (AssertionError e) {
            ExtentReport.node.fail("Assertion Not-Contains FAILED: " + expectedValue);
            throw new CustomException(e);
        }
    }

    public void infoReport(String info) {
        ExtentReport.node.info(info);
    }

    public void extendReport(String info) {
        ExtentReport.createAndGetNodeInstance(info);
    }
}
