package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        open("index.html");
    }

}
