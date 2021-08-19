package com.epam.tc.hw5.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.UserTablePage;
import com.epam.tc.hw5.utils.DataProviderForCucumberTests;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(css = "header ul.navbar-nav.m-l8 > li")
    private List<WebElement> headerButtons;
    @FindBy(css = ".dropdown-menu li")
    private List<WebElement> serviceMenuButtons;
    @FindBy(id = "user-icon")
    private WebElement signInIcon;
    @FindBy(id = "name")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement signInButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(linkText = "different-elements.html")
    private WebElement differentElementsButton;
    @FindBy(linkText = "user-table.html")
    private WebElement userTableButton;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public String getButtonName(int elementNumber) {
        return wait.until(visibilityOfAllElements(headerButtons)).get(elementNumber).getText();
    }

    public void clickButton(List<WebElement> buttonsType, String buttonName) {
        wait.until(visibilityOfAllElements(buttonsType))
            .stream().filter(i -> i.getText().equals(buttonName))
            .findFirst().get().click();
    }

    public DifferentElementsPage openDifferentElementsPage() {
        clickButton(wait.until(visibilityOfAllElements(headerButtons)), "SERVICE");
        webDriver.switchTo().activeElement();
        clickButton(wait.until(visibilityOfAllElements(serviceMenuButtons)), "DIFFERENT ELEMENTS");
        return new DifferentElementsPage(webDriver);
    }

    public void login() {
        wait.until(visibilityOf(signInIcon)).click();
        webDriver.switchTo().activeElement();
        wait.until(visibilityOf(loginField)).sendKeys(DataProviderForCucumberTests.getProperty("login"));
        wait.until(visibilityOf(passwordField)).sendKeys(DataProviderForCucumberTests.getProperty("password"));
        wait.until(visibilityOf(signInButton)).click();
    }

    public UserTablePage openUserTablePage() {
        clickButton(wait.until(visibilityOfAllElements(headerButtons)), "SERVICE");
        clickButton(wait.until(visibilityOfAllElements(serviceMenuButtons)), "USER TABLE");
        return new UserTablePage(webDriver);
    }

    public List<WebElement> getHeaderButtons() {
        return wait.until(visibilityOfAllElements(headerButtons));
    }

    public List<WebElement> getServiceMenuButtons() {
        return wait.until(visibilityOfAllElements(serviceMenuButtons));
    }
}
