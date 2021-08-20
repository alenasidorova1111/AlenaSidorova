package com.epam.tc.hw4.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestFailureListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object webDriver = result.getTestContext().getAttribute("webDriver");

        if (webDriver != null) {
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            AttachmentsUtil.screenshotAttachment("Screenshot on failure", screenshot);
        }
    }
}
