package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerImpl implements DriverService {

    public DriverManagerImpl() {

    }

    private void setupChromeDriver() {
        WebDriverManager.chromedriver().driverVersion("92.0.4515.107").setup();
    }

    @Override
    public WebDriver setupDriver() {
        setupChromeDriver();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }

}
