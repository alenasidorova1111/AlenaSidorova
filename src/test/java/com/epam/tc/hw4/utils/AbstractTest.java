package com.epam.tc.hw4.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected WebDriver webDriver;

    @BeforeMethod
    public void prepareToTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        context.setAttribute("webDriver", webDriver);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownDriver() {
        webDriver.quit();
    }
}
