package com.epam.tc.hw6.ex2;

import com.epam.tc.hw6.pages.DifferentElementsPage;
import com.epam.tc.hw6.pages.HomePage;
import com.epam.tc.hw6.utils.AbstractTest;
import com.epam.tc.hw6.utils.DataProvidersForPageObject;
import com.epam.tc.hw6.utils.TestFailureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailureListener.class})
@Feature(value = "Different Elements page")
@Story(value = "User can login, go to Different Elements page and choose its elements")
public class DifferentElementsPageTest extends AbstractTest {

    @Test(dataProvider = "twoForcesMetalColor", dataProviderClass = DataProvidersForPageObject.class)
    public void testDifferentElementsPage(String force1, String force2, String metal, String color) {

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);
        homePage.open();

        // 2. Assert Browser title
        homePage.testPageTitle();

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is loggined
        homePage.testUserName();

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
        dep.testInfoAboutItemsAreSelected(force1, force2, metal, color);
    }
}
