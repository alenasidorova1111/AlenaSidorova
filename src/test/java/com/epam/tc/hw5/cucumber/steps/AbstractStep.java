package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage dep;
    protected UserTablePage utp;

    public AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getTestObject("web_driver");

        homePage = new HomePage(webDriver);
        dep = new DifferentElementsPage(webDriver);
        utp = new UserTablePage(webDriver);
    }
}
