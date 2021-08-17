package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    private final HeaderMenu headerMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.headerMenu = new HeaderMenu(webDriver);
    }

    public void open() {
        open("index.html");
    }
}
