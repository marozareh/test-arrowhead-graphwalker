package com.mbtroads.report;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.core.BaseTest;

import java.io.File;
import java.io.IOException;

public class ExtentReportNEW implements ISystemProperties {

    private static ExtentReports report;
    public static ExtentTest test;
    public static ExtentTest node;

    /* ===================== REPORT ===================== */

    public static void createReportInstance(String filePath) {

        // ALWAYS RESET (CRITICAL FIX)
        report = null;
        test = null;
        node = null;

        File reportFile = new File(filePath);
        reportFile.getParentFile().mkdirs(); // create folder automatically

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(reportFile);

        report = new ExtentReports();
        report.attachReporter(sparkReporter);

        report.setSystemInfo("Host Name", ISystemProperties.getMachineName());
        report.setSystemInfo("Operating System", OS);
    }

    public static void createTestInstance(String testName) {

        if (report == null) {
            throw new IllegalStateException(
                    "ExtentReport not initialized. Call createReportInstance first."
            );
        }

        test = report.createTest(testName);
    }

    public static ExtentTest createAndGetNodeInstance(String nodeName) {

        if (test == null) {
            throw new IllegalStateException(
                    "ExtentTest not initialized. Call createTestInstance first."
            );
        }

        node = test.createNode(nodeName);
        return node;
    }

    public static void flushReport() {

        if (report != null) {
            report.flush();
        }

        // Optional but recommended cleanup
        report = null;
        test = null;
        node = null;
    }

    /* ===================== FAIL (FATAL) ===================== */

    public static void reportError() throws IOException {

        if (node == null) {
            return;
        }

        String screenshot = BaseTest.getScreenshotAsString();

        if (screenshot == null || screenshot.isEmpty()) {

            node.fail("Test execution failed (no screenshot available)");

            if (test != null) {
                test.fail("Test execution failed");
            }

            return;
        }

        Media media = MediaEntityBuilder
                .createScreenCaptureFromBase64String(screenshot)
                .build();

        node.fail("Test execution failed", media);

        if (test != null) {
            test.fail("Test execution failed");
        }
    }

    /* ===================== WARN ===================== */

    public static void reportWarning(String message) {
        if (node != null) {
            node.warning(message);
        }
    }

    /* ===================== INFO ===================== */

    public static void reportInfo(String message) {
        if (node != null) {
            node.info(message);
        }
    }

    /* ===================== PASS ===================== */

    public static void reportPass() {
        if (node != null) {
            node.pass("Step passed");
        }
    }

    public static void reportImage() throws IOException {

        if (node == null) {
            return;
        }

        String screenshot = BaseTest.getScreenshotAsString();

        if (screenshot == null || screenshot.isEmpty()) {
            node.pass("Step passed (no screenshot available)");
            return;
        }

        Media media = MediaEntityBuilder
                .createScreenCaptureFromBase64String(screenshot)
                .build();

        node.pass(media);
    }
}
