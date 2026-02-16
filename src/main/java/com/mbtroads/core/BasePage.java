package com.mbtroads.core;

import com.mbtroads.report.ExtentReportNEW;
import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public abstract class BasePage extends ExecutionContext {

    // 🔥 GLOBAL FAILED STORAGE
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
            ExtentReportNEW.node.pass("Model executed successfully");
        } else {
            ExtentReportNEW.node.fail("Error in the Model");
        }

        while (i < arrSplit.length) {

            if (result == 0) {

                ExtentReportNEW.node.pass(arrSplit[i]);

            }
            else if (arrSplit[i].contains("vertexName")) {

                if (firstVertex == 0) {
                    ExtentReportNEW.node.fail("=============> Failed Vertices <=============");
                    firstVertex = 1;
                }

                String temp = arrSplit[i]
                        .replace("\"vertexName\":\"", "")
                        .replace("\"", "")
                        .replace("}", "")
                        .replace("]", "")
                        .trim();

                // 🔥 REMOVE "vertexName: " PREFIX IF EXISTS
                if (temp.contains(":")) {
                    temp = temp.substring(temp.indexOf(":") + 1).trim();
                }

                ExtentReportNEW.node.fail(temp);

                failedVertices.add(temp);

                i++;
            }
            else if (arrSplit[i].contains("edgeId")) {

                if (firstEdge == 0) {
                    ExtentReportNEW.node.fail("=============> Failed Edges <=============");
                    firstEdge = 1;
                }

                String temp = arrSplit[i + 1]
                        .replace("\"edgeName\":\"", "")
                        .replace("\"", "")
                        .replace("}", "")
                        .replace("]", "")
                        .trim();

                // 🔥 REMOVE "edgeName: " PREFIX IF EXISTS
                if (temp.contains(":")) {
                    temp = temp.substring(temp.indexOf(":") + 1).trim();
                }

                ExtentReportNEW.node.fail(temp);

                failedEdges.add(temp);

                i++;
            }

            i++;
        }
    }

    public void assestEqual(String expectedValue, String actualValue) {
        try {
            assertEquals(expectedValue, actualValue);
            ExtentReportNEW.node.pass("Assertion Equal OK: " + expectedValue);
        } catch (AssertionError e) {
            ExtentReportNEW.node.fail("Assertion Equal FAILED: " + expectedValue);
            throw e;
        }
    }

    public void assestContains(String expectedValue, String actualValue) {
        try {
            Assert.assertTrue(actualValue.contains(expectedValue));
            ExtentReportNEW.node.pass("Assertion Contains OK: " + expectedValue);
        } catch (AssertionError e) {
            ExtentReportNEW.node.fail("Assertion Contains FAILED: " + expectedValue);
            throw e;
        }
    }

    public void assestdonotContains(String expectedValue, String actualValue) {
        try {
            Assert.assertFalse(actualValue.contains(expectedValue));
            ExtentReportNEW.node.pass("Assertion Not-Contains OK: " + expectedValue);
        } catch (AssertionError e) {
            ExtentReportNEW.node.fail("Assertion Not-Contains FAILED: " + expectedValue);
            throw e;
        }
    }

    public void infoReport(String info) {
        ExtentReportNEW.node.info(info);
    }

    public void extendReport(String info) {
        ExtentReportNEW.createAndGetNodeInstance(info);
    }
}
