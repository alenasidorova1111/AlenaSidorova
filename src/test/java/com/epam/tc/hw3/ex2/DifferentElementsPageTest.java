package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.utils.AbstractTest;
import com.epam.tc.hw3.utils.DataProvidersForPageObject;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class DifferentElementsPageTest extends AbstractTest {

    @Test(dataProvider = "twoForcesMetalColor", dataProviderClass = DataProvidersForPageObject.class)
    public void testDifferentElementsPage(String force1, String force2, String metal, String color) {

        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);
        homePage.open();

        // 2. Assert Browser title
        softly.assertThat(homePage.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        homePage.getHeaderMenu().login();

        // 4. Assert Username is loggined
        softly.assertThat(homePage.getHeaderMenu().getUserName()).isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        homePage.getHeaderMenu().openDifferentElementsPage();
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
        softly.assertThat(dep.getLogBodyText()).contains(force1, force2, metal, color);

        softly.assertAll();
    }
}
