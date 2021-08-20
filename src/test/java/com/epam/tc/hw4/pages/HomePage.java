package com.epam.tc.hw4.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.epam.tc.hw4.components.BenefitSection;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    protected BenefitSection benefitSection;

    @FindBy(id = "frame")
    private WebElement interactiveFrame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        benefitSection = new BenefitSection(webDriver);
    }

    public BenefitSection getBenefitSection() {
        return benefitSection;
    }

    public WebElement getIFrame() {
        return wait.until(visibilityOf(interactiveFrame));
    }

    public WebElement getIFrameButton() {
        return wait.until(visibilityOf(frameButton));
    }

    public void goToIFrame() {
        webDriver.switchTo().frame("frame");
    }

    public void exitIFrame() {
        webDriver.switchTo().defaultContent();
    }

    @Step("Open Home page")
    public void open() {
        open("index.html");
    }

    @Step("Check browser title")
    public void testPageTitle() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softly.assertAll();
    }

    @Step("Perform login")
    public void login() {
        headerMenu.login();
    }

    @Step("Check Username")
    public void testUserName() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(headerMenu.getUserName()).isEqualTo("ROMAN IOVLEV");
        softly.assertAll();
    }

    @Step("Check Header Menu buttons")
    public void testMenuButtonsNames() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(headerMenu.getHeaderButtons()).hasSize(4);
        List<String> expectedButtonNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softly.assertThat(headerMenu.getButtonsNames()).isEqualTo(expectedButtonNames);
        softly.assertAll();
    }

    @Step("Check benefit section images are displayed")
    public void testBenefitImages() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(this.getBenefitSection().getBenefitImages()).hasSize(4);
        softly.assertThat(this.getBenefitSection().areAllImagesDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Check benefit section images have proper text under")
    public void testBenefitITexts() {
        SoftAssertions softly = new SoftAssertions();
        List<String> expectedBenefitTexts = Arrays.asList("To include good practices\n"
                + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
            "To be multiplatform", "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…");

        softly.assertThat(this.getBenefitSection().getBenefitTextElements()).hasSize(4);
        softly.assertThat(this.getBenefitSection().getBenefitTexts()).isEqualTo(expectedBenefitTexts);
        softly.assertAll();
    }

    @Step("Check iFrame existence")
    public void testIframeExist() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(this.getIFrame().isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Check iFrame button existence")
    public void testLeftMenuButtonsNames() {
        SoftAssertions softly = new SoftAssertions();

        List<String> expectedLeftMenuButtonNames = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        softly.assertThat(leftMenu.getMenuButtons()).hasSize(5);
        softly.assertThat(leftMenu.areAllButtonsDisplayed()).isTrue();
        softly.assertThat(leftMenu.getButtonsNames()).isEqualTo(expectedLeftMenuButtonNames);

        softly.assertAll();
    }

    @Step("Check Left Menu buttons")
    public void testIframeButtonExists() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(this.getIFrameButton().isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Step("Open through the header menu Different Elements Page")
    public DifferentElementsPage openDifferentElementsPage() {
        return headerMenu.openDifferentElementsPage();
    }

    @Step("Check Username to fail")
    public void testUserNameFailed() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(headerMenu.getUserName()).isEqualTo("Ramen ILove");
        softly.assertAll();
    }
}
