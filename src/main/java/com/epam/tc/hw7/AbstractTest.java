package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import com.epam.tc.hw7.site.Site;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {
    @BeforeTest(alwaysRun = true)
    public void setUp() {
        initSite(Site.class);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
