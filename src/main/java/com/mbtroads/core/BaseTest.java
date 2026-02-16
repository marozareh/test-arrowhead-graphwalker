package com.mbtroads.core;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public abstract class BaseTest extends BasePage implements ISystemProperties {

    protected static WebDriver driver;

    /* =========================================================
       NO AUTOMATIC REPORT CREATION HERE
       Each test class creates its own report
       ========================================================= */

    @Before
    public void beforeEachTest() {
        // Nothing here anymore
        // Report initialization is handled inside each test class
    }

    @AfterClass
    public static void afterAllTests() {
        // Nothing here
        // Report flushing is handled inside each test class
    }

    /* =========================================================
       SCREENSHOT SUPPORT
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
