package com.epam.tc.hw4.pages;

import com.epam.tc.hw3.utils.ConfProperties;
import com.epam.tc.hw4.components.BenefitSection;
import com.epam.tc.hw4.components.HeaderMenu;
import com.epam.tc.hw4.components.LeftMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver webDriver;
    protected HeaderMenu headerMenu;
    protected LeftMenu leftMenu;
    protected BenefitSection benefitSection;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        headerMenu = new HeaderMenu(webDriver);
        benefitSection = new BenefitSection(webDriver);
        leftMenu = new LeftMenu(webDriver);
        PageFactory.initElements(webDriver, this);
    }

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

    public void openPage() {
        webDriver.navigate().to(URL);
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

    public void login() {
        signInIcon.click();
        webDriver.switchTo().activeElement();
        loginField.sendKeys(ConfProperties.getProperty("login"));
        passwordField.sendKeys(ConfProperties.getProperty("password"));
        signInButton.click();
    }

    public void goToDifferentElementsPage() {
        headerMenu.button("SERVICE").click();
        webDriver.switchTo().activeElement();
        differentElementsButton.click();
    }
}
