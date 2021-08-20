package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.utils.AbstractTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {

    @Test
    public void testHomePage() {

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

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softly.assertThat(homePage.getHeaderMenu().getHeaderButtons()).hasSize(4);
        List<String> expectedButtonNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softly.assertThat(homePage.getHeaderMenu().getButtonsNames()).isEqualTo(expectedButtonNames);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softly.assertThat(homePage.getBenefitSection().getBenefitImages()).hasSize(4);
        softly.assertThat(homePage.getBenefitSection().areAllImagesDisplayed()).isTrue();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedBenefitTexts = Arrays.asList("To include good practices\n"
            + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
            "To be multiplatform", "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…");

        softly.assertThat(homePage.getBenefitSection().getBenefitTextElements()).hasSize(4);
        softly.assertThat(homePage.getBenefitSection().getBenefitTexts()).isEqualTo(expectedBenefitTexts);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(homePage.getIFrame().isDisplayed()).isTrue();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.goToIFrame();
        softly.assertThat(homePage.getIFrameButton().isDisplayed()).isTrue();

        // 10. Switch to original window back
        homePage.exitIFrame();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> expectedLeftMenuButtonNames = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softly.assertThat(homePage.getLeftMenu().getMenuButtons()).hasSize(5);
        softly.assertThat(homePage.getLeftMenu().areAllButtonsDisplayed()).isTrue();
        softly.assertThat(homePage.getLeftMenu().getButtonsNames()).isEqualTo(expectedLeftMenuButtonNames);

        softly.assertAll();
    }
}
