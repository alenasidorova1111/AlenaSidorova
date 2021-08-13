package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.utils.BaseTest;
import com.epam.tc.hw3.utils.DataProvidersForPageObject;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends BaseTest {

    @Test(dataProvider = "twoForcesMetalColor", dataProviderClass = DataProvidersForPageObject.class)
    public void testDifferentElementsPage(String force1, String force2, String metal, String color) {

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);

        // 2. Assert Browser title
        soft.assertThat(homePage.getPageTitle()).isEqualTo("Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is loggined
        soft.assertThat(homePage.getUserName()).isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.goToDifferentElementsPage();
        DifferentElementsPage dep = new DifferentElementsPage(webDriver);

        // 6. Select checkboxes
        dep.chooseCheckBox(force1);
        dep.chooseCheckBox(force2);

        // 7. Select radio
        dep.chooseRadio(metal);

        // 8. Select in dropdown
        dep.chooseDropdown(color);

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // - for radio button there is a log row and value is corresponded to the status of radio button
        // - for dropdown there is a log row and value is corresponded to the selected value.
        dep.findInLog(force1);
        dep.findInLog(force2);
        dep.findInLog(metal);
        dep.findInLog(color);

        soft.assertAll();
    }
}
