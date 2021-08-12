package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.BenefitSection;
import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.components.LeftMenu;
import com.epam.tc.hw3.utils.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;
    private final HeaderMenu headerMenu;
    private final LeftMenu leftMenu;
    private final BenefitSection benefitSection;

    @FindBy(xpath = "//iframe[@id='frame']")
    private WebElement interactiveFrame;
    @FindBy(xpath = "//input[@value='Frame Button']")
    private WebElement frameButton;
    @FindBy(xpath = "//*[@class='profile-photo'][1]")
    private WebElement signInIcon;
    @FindBy(xpath = "//input[@id='name'][1]")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='password'][1]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='login-button'][1]")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@id='user-name']")
    private WebElement userName;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;

    public HomePage(WebDriver webDriver1) {
        PageFactory.initElements(webDriver1, this);
        this.webDriver = webDriver1;
        headerMenu = new HeaderMenu(webDriver1);
        benefitSection = new BenefitSection(webDriver1);
        leftMenu = new LeftMenu(webDriver1);
    }

    public void login() {
        signInIcon.click();
        webDriver.switchTo().activeElement();
        loginField.sendKeys(ConfProperties.getProperty("login"));
        passwordField.sendKeys(ConfProperties.getProperty("password"));
        signInButton.click();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public String getUserName() {
        return this.userName.getText();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public BenefitSection getBenefitSection() {
        return benefitSection;
    }

    public WebElement getIFrame() {
        return interactiveFrame;
    }

    public WebElement getIFrameButton() {
        return frameButton;
    }

    public void goToIFrame() {
        webDriver.switchTo().frame("frame");
    }

    public void exitIFrame() {
        webDriver.switchTo().defaultContent();
    }

    public void goToDifferentElementsPage() {
        headerMenu.button("SERVICE").click();
        webDriver.switchTo().activeElement();
        differentElementsButton.click();
    }
}