package com.epam.tc.hw3.bonus;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw3.pages.AbstractPage;
import com.epam.tc.hw3.utils.DataProvidersForPageObject;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FluentHomePage extends AbstractPage {

    @FindBy(id = "frame")
    private WebElement interactiveFrame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;
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

    public FluentHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public FluentHomePage open() {
        open("index.html");
        return this;
    }

    public FluentHomePage login(String name, String password) {
        wait.until(visibilityOf(signInIcon)).click();
        webDriver.switchTo().activeElement();
        wait.until(visibilityOf(loginField)).sendKeys(name);
        wait.until(visibilityOf(passwordField)).sendKeys(password);
        wait.until(visibilityOf(signInButton)).click();
        return this;
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

    public FluentDifferentElementsPage openDifferentElementsPage() {
        headerMenu.clickButton(wait.until(visibilityOfAllElements(headerButtons)), "SERVICE");
        webDriver.switchTo().activeElement();
        headerMenu.clickButton(wait.until(visibilityOfAllElements(serviceMenuButtons)), "DIFFERENT ELEMENTS");
        return new FluentDifferentElementsPage(webDriver);
    }
}
