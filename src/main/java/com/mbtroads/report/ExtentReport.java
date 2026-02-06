package com.mbtroads.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mbtroads.core.ISystemProperties;
import com.mbtroads.core.BaseTest;

import java.io.IOException;

public class ExtentReport implements ISystemProperties {

    private static ExtentReports report;
    public static ExtentTest test;
    public static ExtentTest node;

    public static void createReportInstance(String filePath) {
        report = new ExtentReports();
        report.attachReporter(new ExtentSparkReporter(filePath));
        report.setSystemInfo("Host Name", ISystemProperties.getMachineName());
        report.setSystemInfo("Operating System", OS);
    }

    public static void createTestInstance(String testName) {
        test = report.createTest(testName);
    }

    public static ExtentTest createAndGetNodeInstance(String nodeName) {
        node = test.createNode(nodeName);
        return node;
    }

    public static void removeTestFromReport(ExtentTest testName) {
        report.removeTest(testName);
    }

    public static void flushReport() {
        report.flush();
    }

    public static void reportError() {
        try {
            Media media = MediaEntityBuilder
                    .createScreenCaptureFromBase64String(BaseTest.getScreenshotAsString())
                    .build();
            node.fail("Error occurred", media);
        } catch (IOException e) {
            node.fail("Error occurred (screenshot failed)");
        }
    }

    public static void reportImage() {
        try {
            Media media = MediaEntityBuilder
                    .createScreenCaptureFromBase64String(BaseTest.getScreenshotAsString())
                    .build();
            node.pass(media);
        } catch (IOException e) {
            node.pass("Screenshot capture failed");
        }
    }
}
