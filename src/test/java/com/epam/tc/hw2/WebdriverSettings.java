package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebdriverSettings {
    protected WebDriver webDriver;
    protected SoftAssertions soft;
    protected WebDriverWait webDriverWait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().driverVersion("92.0.4515.107").setup();
        soft = new SoftAssertions();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    // Close Browser
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}
