package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.HeaderMenu;
import com.epam.tc.hw5.utils.DataProviderForCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

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

    private final HeaderMenu headerMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.headerMenu = new HeaderMenu(webDriver);
    }

    public void open() {
        open("index.html");
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
