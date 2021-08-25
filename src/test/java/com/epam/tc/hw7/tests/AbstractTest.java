package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import com.epam.tc.hw7.site.Site;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractTest {
    @BeforeSuite
    public void setUp() {
        initElements(Site.class);
    }

    @AfterSuite
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
