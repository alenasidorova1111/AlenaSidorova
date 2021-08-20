package com.epam.tc.hw6.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected AbstractComponent(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10L);
        PageFactory.initElements(webDriver, this);
        actions = new Actions(webDriver);
    }
}
