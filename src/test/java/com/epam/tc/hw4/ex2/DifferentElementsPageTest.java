package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.utils.AbstractTest;
import com.epam.tc.hw4.utils.DataProvidersForPageObject;
import com.epam.tc.hw4.utils.TestFailureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailureListener.class})
@Feature(value = "Different Elements page")
@Story(value = "User can login, go to Different Elements page and choose its elements")
public class DifferentElementsPageTest extends AbstractTest {

    @Test(dataProvider = "twoForcesMetalColor", dataProviderClass = DataProvidersForPageObject.class)
    public void testDifferentElementsPage(String login, String password, String pageTitle, String userName,
                                          String force1, String force2, String metal, String color) {

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);
        homePage.open();

        // 2. Assert Browser title
        testPageTitle(homePage, pageTitle);

        // 3. Perform login
        homePage.login(login, password);

        // 4. Assert Username is loggined
        testUserName(homePage, userName);

        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage dep = homePage.openDifferentElementsPage();

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
        testInfoAboutItemsAreSelected(dep, force1, force2, metal, color);
    }

    @Step("Check browser title")
    public void testPageTitle(HomePage hp, String expectedPageTitle) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getTitle()).isEqualTo(expectedPageTitle);
        softly.assertAll();
    }

    @Step("Check Username")
    public void testUserName(HomePage hp, String expectedUserName) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getHeaderMenu().getUserName()).isEqualTo(expectedUserName);
        softly.assertAll();
    }

    @Step("Check info about {force1} / {force2} / {metal} / {color} items are displayed in log section")
    public void testInfoAboutItemsAreSelected(DifferentElementsPage dep, String force1, String force2,
                                              String metal, String color) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(dep.getLogBodyText()).contains(force1, force2, metal, color);
        softly.assertAll();
    }
}
