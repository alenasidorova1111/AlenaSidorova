package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePage homePage;

    public AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getTestObject("web_driver");

        homePage = new HomePage(webDriver);
    }
}
