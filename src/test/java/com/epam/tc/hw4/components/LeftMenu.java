package com.epam.tc.hw4.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu {

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li/a")
    public List<WebElement> menuButtons;

    public LeftMenu(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public boolean checkAllButtonsDisplayed() {
        return menuButtons.stream().allMatch(WebElement::isDisplayed);
    }

    public String getButtonName(int elementNumber) {
        return menuButtons.get(elementNumber).getText();
    }
}
