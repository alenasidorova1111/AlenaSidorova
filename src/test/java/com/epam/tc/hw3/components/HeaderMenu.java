package com.epam.tc.hw3.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8'][1]/li")
    public List<WebElement> headerButtons;

    public HeaderMenu(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public String getButtonName(int elementNumber) {
        return headerButtons.get(elementNumber).getText();
    }

    public WebElement button(String buttonName) {
        return headerButtons.stream().filter(i -> i.getText().equals(buttonName)).findFirst().get();
    }
}
