package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.utils.AbstractTest;
import com.epam.tc.hw4.utils.DataProvidersForPageObject;
import com.epam.tc.hw4.utils.TestFailureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailureListener.class})
@Feature(value = "Home page with failure")
@Story(value = "User can not login and use Home page elements")
public class FailedPageTest extends AbstractTest {

    @Test(dataProvider = "loginPassword", dataProviderClass = DataProvidersForPageObject.class)
    public void testHomePage(String login, String password) {

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);
        homePage.open();

        // 2. Assert Browser title
        homePage.testPageTitle();

        // 3. Perform login
        homePage.login(login, password);

        // 4. Assert Username is loggined
        homePage.testUserNameFailed();

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.testMenuButtonsNames();

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePage.testBenefitImages();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.testBenefitITexts();

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePage.testIframeExist();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.goToIFrame();
        homePage.testIframeButtonExists();

        // 10. Switch to original window back
        homePage.exitIFrame();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePage.testLeftMenuButtonsNames();
    }
}
