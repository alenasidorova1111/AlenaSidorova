package com.epam.tc.hw7;

import static com.epam.tc.hw7.site.Site.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.headerMenu;
import static com.epam.tc.hw7.site.pages.HomePage.userName;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalsAndColorsForm;

import com.epam.tc.hw7.entities.MetalsAndColorsData;
import com.epam.tc.hw7.utils.DataProviders;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestMetalsAndColorsPage extends AbstractTest {

    @Test
    public void testLogin() {
        Assertions.assertThat(userName.getText()).as("User name is wrong or empty")
                      .isEqualTo(DataProviders.DEFAULT_USER.fullName);
    }

    @Test(dataProvider = "metalsAndColorsDataSet", dataProviderClass = DataProviders.class)
    public void testMetalsAndColorsPage(MetalsAndColorsData metalsAndColors) {

        headerMenu.select("Metals & Colors");
        metalsAndColorsPage.checkOpened();

        metalsAndColorsForm.fill(metalsAndColors);
        metalsAndColorsForm.submit();

        MetalsAndColorsData metalsAndColorsData = new MetalsAndColorsData();

        Assertions.assertThat(metalsAndColorsPage.getResult()).as("Actual metalsAndColorsData is not equal to expected")
                      .isEqualTo(metalsAndColorsData.getExpectedResultFromMetalsAndColorsData(metalsAndColors));

    }
}
