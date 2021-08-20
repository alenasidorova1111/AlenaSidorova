package com.epam.tc.hw4.pages;

import com.epam.tc.hw4.components.AbstractComponent;
import com.epam.tc.hw4.components.HeaderMenu;
import com.epam.tc.hw4.components.LeftMenu;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends AbstractComponent {

    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/";

    protected HeaderMenu headerMenu;
    protected LeftMenu leftMenu;

    protected AbstractPage(WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftMenu = new LeftMenu(webDriver);
    }

    public void open(String url) {
        webDriver.navigate().to(BASE_URL + url);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

}
