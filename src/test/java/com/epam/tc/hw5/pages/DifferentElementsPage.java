package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractPage {

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        open("different-elements.html");
    }
}
