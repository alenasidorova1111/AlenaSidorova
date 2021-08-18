package com.epam.tc.hw5.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.utils.DataProviderForCucumberTests;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8'][1]/li")
    public List<WebElement> headerButtons;
    @FindBy(xpath = "//ul[@role='menu']/li")
    public List<WebElement> serviceMenuButtons;
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

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public String getButtonName(int elementNumber) {
        return headerButtons.get(elementNumber).getText();
    }

    public void clickButton(List<WebElement> buttonsType, String buttonName) {
        wait.until(visibilityOfAllElements(buttonsType))
            .stream().filter(i -> i.getText().equals(buttonName))
            .findFirst().orElse(null).click();
    }

    public DifferentElementsPage openDifferentElementsPage() {
        clickButton(headerButtons, "SERVICE");
        clickButton(serviceMenuButtons, "DIFFERENT ELEMENTS");
        return new DifferentElementsPage(webDriver);
    }

    public void login() {
        signInIcon.click();
        webDriver.switchTo().activeElement();
        loginField.sendKeys(DataProviderForCucumberTests.getProperty("login"));
        passwordField.sendKeys(DataProviderForCucumberTests.getProperty("password"));
        signInButton.click();
    }
}
