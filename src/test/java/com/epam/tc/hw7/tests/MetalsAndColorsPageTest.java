package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.site.Site.homePage;
import static com.epam.tc.hw7.site.Site.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.headerMenu;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.signInIcon;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.tc.hw7.tests.DataProviders.DEFAULT_USER;
import static org.testng.Assert.assertEquals;

import com.epam.tc.hw7.entities.MetalsAndColorsData;
import org.testng.annotations.Test;

public class MetalsAndColorsPageTest extends AbstractTest {

    @Test(dataProvider = "metalsAndColorsDataSet", dataProviderClass = DataProviders.class)
    public void testMetalsAndColorsPage(MetalsAndColorsData metalsAndColors) {

        homePage.open();
        homePage.checkOpened();

        signInIcon.click();
        loginForm.loginAs(DEFAULT_USER);

        headerMenu.select("Metals & Colors");
        metalsAndColorsPage.checkOpened();

        metalsAndColorsForm.fill(metalsAndColors);
        metalsAndColorsForm.submit();

        assertEquals(metalsAndColorsPage.getResult(),
            metalsAndColorsPage.getExpectedResultFromMetalsAndColorsData(metalsAndColors));

        homePage.logout();
    }
}
