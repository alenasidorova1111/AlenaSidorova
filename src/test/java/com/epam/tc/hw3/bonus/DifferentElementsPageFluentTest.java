package com.epam.tc.hw3.bonus;

import com.epam.tc.hw3.utils.AbstractTest;
import com.epam.tc.hw3.utils.DataProvidersForPageObject;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class DifferentElementsPageFluentTest extends AbstractTest {

    @Test(dataProvider = "twoForcesMetalColor", dataProviderClass = DataProvidersForPageObject.class)
    public void testDifferentElementsPage(String force1, String force2, String metal, String color,
                                          String login, String password) {

        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL // 3. Perform login
        FluentHomePage fluentPage = new FluentHomePage(webDriver);
        fluentPage.open().login(login, password);

        // 2. Assert Browser title
        softly.assertThat(fluentPage.getTitle()).isEqualTo("Home Page");
        // 4. Assert Username is loggined
        softly.assertThat(fluentPage.getHeaderMenu().getUserName()).isEqualTo("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        // 6. Select checkboxes
        // 7. Select radio
        // 8. Select in dropdown

        FluentDifferentElementsPage fdp = fluentPage.openDifferentElementsPage();
        fdp.chooseCheckBox(force1)
            .chooseCheckBox(force2)
            .chooseRadio(metal)
            .chooseDropdown(color);

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // - for radio button there is a log row and value is corresponded to the status of radio button
        // - for dropdown there is a log row and value is corresponded to the selected value.
        softly.assertThat(fdp.getLogBodyText()).contains(force1, force2, metal, color);

        softly.assertAll();
    }
}
