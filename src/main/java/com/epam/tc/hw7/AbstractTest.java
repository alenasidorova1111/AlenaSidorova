package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.site.Site.homePage;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.signInIcon;

import com.epam.tc.hw7.site.Site;
import com.epam.tc.hw7.utils.DataProviders;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        initSite(Site.class);

        homePage.open();
        homePage.checkOpened();
        signInIcon.click();
        loginForm.loginAs(DataProviders.DEFAULT_USER);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
