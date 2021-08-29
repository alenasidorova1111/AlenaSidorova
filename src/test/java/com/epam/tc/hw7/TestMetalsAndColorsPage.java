package com.epam.tc.hw7;

import static com.epam.tc.hw7.site.Site.homePage;
import static com.epam.tc.hw7.site.Site.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.headerMenu;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.signInIcon;
import static com.epam.tc.hw7.site.pages.HomePage.userName;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static org.testng.Assert.assertEquals;

import com.epam.tc.hw7.entities.MetalsAndColorsData;
import com.epam.tc.hw7.utils.DataProviders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMetalsAndColorsPage extends AbstractTest {

    @BeforeTest
    public void login() {
        homePage.open();
        homePage.checkOpened();

        signInIcon.click();
        loginForm.loginAs(DataProviders.DEFAULT_USER);

        userName.is().text(DataProviders.DEFAULT_USER.fullName);
    }

    @Test(dataProvider = "metalsAndColorsDataSet", dataProviderClass = DataProviders.class)
    public void testMetalsAndColorsPage(MetalsAndColorsData metalsAndColors) {

        headerMenu.select("Metals & Colors");
        metalsAndColorsPage.checkOpened();

        metalsAndColorsForm.fill(metalsAndColors);
        metalsAndColorsForm.submit();

        assertEquals(metalsAndColorsPage.getResult(),
            metalsAndColorsPage.getExpectedResultFromMetalsAndColorsData(metalsAndColors));

    }
}
