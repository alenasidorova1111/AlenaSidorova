package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.utils.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Home page")
@Story(value = "User can login and use Home page elements")
public class HomePageTest extends BaseTest {

    @Test
    public void testHomePage() {

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);

        // 2. Assert Browser title
        soft.assertThat(homePage.getPageTitle()).isEqualTo("Home Page");

        // 3. Perform login
        homePage.login();

        // 4. Assert Username is loggined
        soft.assertThat(homePage.getUserName()).isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        soft.assertThat(homePage.getHeaderMenu().headerButtons.size()).isEqualTo(4);
        soft.assertThat(homePage.getHeaderMenu().getButtonName(0)).isEqualTo("HOME");
        soft.assertThat(homePage.getHeaderMenu().getButtonName(1)).isEqualTo("CONTACT FORM");
        soft.assertThat(homePage.getHeaderMenu().getButtonName(2)).isEqualTo("SERVICE");
        soft.assertThat(homePage.getHeaderMenu().getButtonName(3)).isEqualTo("METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        soft.assertThat(homePage.getBenefitSection().benefitImages.size()).isEqualTo(4);
        soft.assertThat(homePage.getBenefitSection().checkAllImagesDisplayed()).isTrue();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        soft.assertThat(homePage.getBenefitSection().benefitTexts.size()).isEqualTo(4);
        soft.assertThat(homePage.getBenefitSection().getBenefitText(0))
            .isEqualTo("To include good practices\n"
                + "and ideas from successful\n" + "EPAM project");
        soft.assertThat(homePage.getBenefitSection().getBenefitText(1))
            .isEqualTo("To be flexible and\n" + "customizable");
        soft.assertThat(homePage.getBenefitSection().getBenefitText(2))
            .isEqualTo("To be multiplatform");
        soft.assertThat(homePage.getBenefitSection().getBenefitText(3))
            .isEqualTo("Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exist
        soft.assertThat(homePage.getIFrame().isDisplayed()).isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.goToIFrame();
        soft.assertThat(homePage.getIFrameButton().isDisplayed()).isTrue();

        // 10. Switch to original window back
        homePage.exitIFrame();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        soft.assertThat(homePage.getLeftMenu().menuButtons.size()).isEqualTo(5);
        soft.assertThat(homePage.getLeftMenu().checkAllButtonsDisplayed()).isTrue();
        soft.assertThat(homePage.getLeftMenu().getButtonName(0)).isEqualTo("Home");
        soft.assertThat(homePage.getLeftMenu().getButtonName(1)).isEqualTo("Contact form");
        soft.assertThat(homePage.getLeftMenu().getButtonName(2)).isEqualTo("Service");
        soft.assertThat(homePage.getLeftMenu().getButtonName(3)).isEqualTo("Metals & Colors");
        soft.assertThat(homePage.getLeftMenu().getButtonName(4)).isEqualTo("Elements packs");

        soft.assertAll();
    }
}
