package com.epam.tc.hw4.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod
    public void prepareToTest(ITestContext context) {
        DriverService driverService = new WebDriverInjector().getDriverService();
        webDriver = driverService.setupDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("webDriver", webDriver);
    }

    @AfterMethod
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
