package com.mbtroads.core;

import com.mbtroads.report.ExtentReportNEW;
import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public abstract class BasePage extends ExecutionContext {

    // GLOBAL FAILED STORAGE
    public static Set<String> failedVertices = new HashSet<>();
    public static Set<String> failedEdges = new HashSet<>();

    public void StrSplit(String strMain, int result) {

        failedVertices.clear();
        failedEdges.clear();

        String[] arrSplit = strMain.split(",");
        int i = 1;
        int firstVertex = 0;
        int firstEdge = 0;

        ExtentReportNEW.createAndGetNodeInstance("GraphWalker Result Summary");

        if (result == 0) {
            safePass("Model executed successfully");
        } else {
            safeFail("Error in the Model");
        }

        while (i < arrSplit.length) {

            if (result == 0) {
                safePass(arrSplit[i]);
            }

            else if (arrSplit[i].contains("vertexName")) {

                if (firstVertex == 0) {
                    safeFail("=============> Failed Vertices <=============");
                    firstVertex = 1;
                }

                String temp = arrSplit[i]
                        .replace("\"vertexName\":\"", "")
                        .replace("\"", "")
                        .replace("}", "")
                        .replace("]", "")
                        .trim();

                if (temp.contains(":")) {
                    temp = temp.substring(temp.indexOf(":") + 1).trim();
                }

                safeFail(temp);
                failedVertices.add(temp);
                i++;
            }

            else if (arrSplit[i].contains("edgeId")) {

                if (firstEdge == 0) {
                    safeFail("=============> Failed Edges <=============");
                    firstEdge = 1;
                }

                String temp = arrSplit[i + 1]
                        .replace("\"edgeName\":\"", "")
                        .replace("\"", "")
                        .replace("}", "")
                        .replace("]", "")
                        .trim();

                if (temp.contains(":")) {
                    temp = temp.substring(temp.indexOf(":") + 1).trim();
                }

                safeFail(temp);
                failedEdges.add(temp);
                i++;
            }

            i++;
        }
    }

    // SAFE LOGGING

    private void safePass(String msg) {
        if (ExtentReportNEW.node != null) {
            ExtentReportNEW.node.pass(msg);
        }
    }

    private void safeFail(String msg) {
        if (ExtentReportNEW.node != null) {
            ExtentReportNEW.node.fail(msg);
        }
    }

    public void assestEqual(String expectedValue, String actualValue) {
        try {
            assertEquals(expectedValue, actualValue);
            safePass("Assertion Equal OK: " + expectedValue);
        } catch (AssertionError e) {
            safeFail("Assertion Equal FAILED: " + expectedValue);
            throw e;
        }
    }

    public void assestContains(String expectedValue, String actualValue) {
        try {
            Assert.assertTrue(actualValue.contains(expectedValue));
            safePass("Assertion Contains OK: " + expectedValue);
        } catch (AssertionError e) {
            safeFail("Assertion Contains FAILED: " + expectedValue);
            throw e;
        }
    }

    public void assestdonotContains(String expectedValue, String actualValue) {
        try {
            Assert.assertFalse(actualValue.contains(expectedValue));
            safePass("Assertion Not-Contains OK: " + expectedValue);
        } catch (AssertionError e) {
            safeFail("Assertion Not-Contains FAILED: " + expectedValue);
            throw e;
        }
    }

    public void infoReport(String info) {
        if (ExtentReportNEW.node != null) {
            ExtentReportNEW.node.info(info);
        }
    }

    public void extendReport(String info) {
        ExtentReportNEW.createAndGetNodeInstance(info);
    }



    public void displayLLMAnalysis(String llmText) {

        if (llmText == null || llmText.trim().isEmpty()) {
            return;
        }

        ExtentReportNEW.createAndGetNodeInstance("AI Model Structural Analysis");

        String[] lines = llmText.split("\n");

        for (String line : lines) {

            line = line.trim();

            if (line.isEmpty()) {
                continue;
            }

            // SECTION HEADERS
            if (line.contains("Structural Risk Assessment")) {
                infoReport("=============> Structural Risk Assessment <=============");
                continue;
            }

            if (line.contains("Identified Risks")) {
                infoReport("=============> Identified Risks <=============");
                continue;
            }

            if (line.contains("Improvement Suggestions")) {
                infoReport("=============> Improvement Suggestions <=============");
                continue;
            }

            if (line.contains("Testing Recommendations")) {
                infoReport("=============> Testing Recommendations <=============");
                continue;
            }

            // BULLETS
            if (line.startsWith("-")) {

                String cleaned = line.replaceFirst("-", "").trim();

                if (cleaned.toLowerCase().contains("risk")) {
                    infoReport(cleaned);
                } else {
                    infoReport(cleaned);
                }
            }

            else {
                infoReport(line);
            }
        }
    }




}
