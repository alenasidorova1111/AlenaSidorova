package com.epam.tc.hw6.utils;

import com.epam.tc.hw6.utils.webdriver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected WebDriver webDriver;

    @BeforeMethod
    public void prepareToTest(ITestContext context) {
        webDriver = WebDriverSingleton.getDriver();
        webDriver.manage().window().maximize();

        context.setAttribute("webDriver", webDriver);
    }

    @AfterMethod
    public void tearDownDriver() {
        WebDriverSingleton.closeDriver();
    }
}
