package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.utils.BaseTest;
import com.epam.tc.hw4.utils.TestFailureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailureListener.class})
@Feature(value = "Home page")
@Story(value = "User can login and use Home page elements")
public class HomePageTest extends BaseTest {

    SoftAssertions soft = new SoftAssertions();

    @Test
    @Step("Check Home page title")
    public void testHomePageTitle() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        soft.assertThat(homePage.getPageTitle()).isEqualTo("Home Page");
        soft.assertAll();
    }

    @Test
    @Step("Check logging process was successful")
    public void testLoginProcess() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        homePage.login();
        soft.assertThat(homePage.getUserName()).isEqualTo("ROMAN IOVLEV");
        soft.assertAll();
    }

    @Test
    @Step ("Check header menu buttons")
    public void testHeaderMenuButtons() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        soft.assertThat(homePage.getHeaderMenu().headerButtons.size()).isEqualTo(4);
        soft.assertThat(homePage.getHeaderMenu().getButtonName(0)).isEqualTo("HOME");
        soft.assertThat(homePage.getHeaderMenu().getButtonName(1)).isEqualTo("CONTACT FORM");
        soft.assertThat(homePage.getHeaderMenu().getButtonName(2)).isEqualTo("SERVICE");
        soft.assertThat(homePage.getHeaderMenu().getButtonName(3)).isEqualTo("METALS & COLORS");
        soft.assertAll();
    }

    @Test
    @Step ("Check benefit images")
    public void testBenefitImages() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        soft.assertThat(homePage.getBenefitSection().benefitImages.size()).isEqualTo(4);
        soft.assertThat(homePage.getBenefitSection().checkAllImagesDisplayed()).isTrue();
        soft.assertAll();
    }

    @Test
    @Step ("Check benefit texts")
    public void testBenefitTexts() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
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
        soft.assertAll();
    }

    @Test
    @Step ("Check iframe exists")
    public void testIFrame() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        soft.assertThat(homePage.getIFrame().isDisplayed()).isTrue();
        soft.assertAll();
    }

    @Test
    @Step ("Check Frame button in iframe")
    public void testIFrameButton() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        homePage.goToIFrame();
        soft.assertThat(homePage.getIFrameButton().isDisplayed()).isTrue();
        homePage.exitIFrame();
        soft.assertAll();
    }

    @Test
    @Step ("Check Left menu buttons")
    public void testLeftMenuButtons() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
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
