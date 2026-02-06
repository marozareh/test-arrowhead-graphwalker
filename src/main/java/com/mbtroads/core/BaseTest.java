package com.mbtroads.core;

import com.mbtroads.report.ExtentReport;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public abstract class BaseTest extends BasePage implements ISystemProperties {

    protected static WebDriver driver;

    @BeforeClass
    public static void beforeAllTests() {

        ExtentReport.createReportInstance(
                currentDir + pathSeperator + "Reports" +
                        pathSeperator + "Report_1.html"
        );

        ExtentReport.createTestInstance("Test Environment Preparation");

        try {
            FileUtils.cleanDirectory(
                    new File(currentDir + pathSeperator + "Reports")
            );
        } catch (Exception e) {
            ExtentReport.node.fail(e);
        }
    }

    @Before
    public void beforeEachTest() {
        ExtentReport.createTestInstance(
                System.getProperty("test")
        );
    }

    @AfterClass
    public static void afterAllTests() {
        ExtentReport.flushReport();
        // driver.quit();   // intentionally preserved as commented
    }

    /* =========================================================
       SCREENSHOT SUPPORT (used by ExtentReport)
       ========================================================= */

    public static String getScreenshotAsString() throws IOException {

        if (driver == null) {
            return "";
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return Base64.getEncoder().encodeToString(fileContent);
    }

    protected static void delayInMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
