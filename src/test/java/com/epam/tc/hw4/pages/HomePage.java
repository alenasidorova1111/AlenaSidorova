package com.epam.tc.hw4.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.epam.tc.hw4.components.BenefitSection;
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
        webDriver.switchTo().frame(interactiveFrame);
    }

    public void exitIFrame() {
        webDriver.switchTo().defaultContent();
    }

    public void open() {
        open("index.html");
    }

    public void login(String name, String password) {
        headerMenu.login(name, password);
    }

    public DifferentElementsPage openDifferentElementsPage() {
        return headerMenu.openDifferentElementsPage();
    }

}
