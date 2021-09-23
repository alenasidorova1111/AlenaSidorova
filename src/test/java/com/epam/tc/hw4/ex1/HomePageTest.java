package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.utils.AbstractTest;
import com.epam.tc.hw4.utils.DataProvidersForPageObject;
import com.epam.tc.hw4.utils.TestFailureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailureListener.class})
@Feature(value = "Home page")
@Story(value = "User can login and use Home page elements")
public class HomePageTest extends AbstractTest {

    @Test(dataProvider = "dataForHomePageTest", dataProviderClass = DataProvidersForPageObject.class)
    public void testHomePage(String login, String password, String pageTitle, String userName,
                             List<String> headerMenuButtons, List<String> benefitTexts,
                             List<String> leftMenuButtons) {

        // 1. Open test site by URL
        HomePage homePage = new HomePage(webDriver);
        homePage.open();

        // 2. Assert Browser title
        testPageTitle(homePage, pageTitle);

        // 3. Perform login
        homePage.login(login, password);

        // 4. Assert Username is loggined
        testUserName(homePage, userName);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        testHeaderMenuButtonsNames(homePage, headerMenuButtons);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        testBenefitImages(homePage);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        testBenefitITexts(homePage, benefitTexts);

        // 8. Assert that there is the iframe with “Frame Button” exist
        testIframeExist(homePage);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.goToIFrame();
        testIframeButtonExists(homePage);

        // 10. Switch to original window back
        homePage.exitIFrame();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        testLeftMenuButtonsNames(homePage, leftMenuButtons);
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

    @Step("Check Header Menu buttons")
    public void testHeaderMenuButtonsNames(HomePage hp, List<String> expectedHeaderMenuButtons) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getHeaderMenu().getHeaderButtons()).hasSize(expectedHeaderMenuButtons.size());
        softly.assertThat(hp.getHeaderMenu().getButtonsNames()).isEqualTo(expectedHeaderMenuButtons);
        softly.assertAll();
    }

    @Step("Check benefit section images are displayed")
    public void testBenefitImages(HomePage hp) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getBenefitSection().getBenefitImages()).hasSize(4);
        softly.assertThat(hp.getBenefitSection().areAllImagesDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Check benefit section images have proper text under")
    public void testBenefitITexts(HomePage hp, List<String> expectedBenefitTexts) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getBenefitSection().getBenefitTextElements()).hasSize(expectedBenefitTexts.size());
        softly.assertThat(hp.getBenefitSection().getBenefitTexts()).isEqualTo(expectedBenefitTexts);
        softly.assertAll();
    }

    @Step("Check iFrame existence")
    public void testIframeExist(HomePage hp) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getIFrame().isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Check iFrame button existence")
    public void testIframeButtonExists(HomePage hp) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getIFrameButton().isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Check iFrame button existence")
    public void testLeftMenuButtonsNames(HomePage hp, List<String> expectedLeftMenuButtonNames) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(hp.getLeftMenu().getMenuButtons()).hasSize(expectedLeftMenuButtonNames.size());
        softly.assertThat(hp.getLeftMenu().areAllButtonsDisplayed()).isTrue();
        softly.assertThat(hp.getLeftMenu().getButtonsNames()).isEqualTo(expectedLeftMenuButtonNames);
        softly.assertAll();
    }

}
