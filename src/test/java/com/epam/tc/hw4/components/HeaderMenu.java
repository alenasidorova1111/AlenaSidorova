package com.epam.tc.hw4.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.utils.DataProvidersForPageObject;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<String> getButtonsNames() {
        return wait.until(visibilityOfAllElements(headerButtons))
                   .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickButton(List<WebElement> buttonsType, String buttonName) {
        wait.until(visibilityOfAllElements(buttonsType))
            .stream().filter(i -> i.getText().equals(buttonName))
            .findFirst().orElseThrow().click();
    }

    public DifferentElementsPage openDifferentElementsPage() {
        clickButton(wait.until(visibilityOfAllElements(headerButtons)), "SERVICE");
        webDriver.switchTo().activeElement();
        clickButton(wait.until(visibilityOfAllElements(serviceMenuButtons)), "DIFFERENT ELEMENTS");
        return new DifferentElementsPage(webDriver);
    }

    public void login(String name, String password) {
        wait.until(visibilityOf(signInIcon)).click();
        webDriver.switchTo().activeElement();
        wait.until(visibilityOf(loginField)).sendKeys(name);
        wait.until(visibilityOf(passwordField)).sendKeys(password);
        wait.until(visibilityOf(signInButton)).click();
    }

    public String getUserName() {
        return wait.until(visibilityOf(userName)).getText();
    }

    public List<WebElement> getHeaderButtons() {
        return wait.until(visibilityOfAllElements(headerButtons));
    }

    public List<WebElement> getServiceMenuButtons() {
        return wait.until(visibilityOfAllElements(serviceMenuButtons));
    }
}
