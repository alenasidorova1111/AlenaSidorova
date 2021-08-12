package com.epam.tc.hw3.utils;

import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;
    protected SoftAssertions soft;

    @BeforeMethod
    public void prepareToTest() {
        DriverService driverService = new WebDriverInjector().getDriverService();
        webDriver = driverService.setupDriver();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soft = new SoftAssertions();
    }

    @AfterMethod
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
