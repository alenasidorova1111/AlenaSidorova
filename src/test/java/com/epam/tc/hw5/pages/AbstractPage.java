package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.AbstractComponent;
import com.epam.tc.hw5.components.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends AbstractComponent {

    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/";

    protected HeaderMenu headerMenu;

    protected AbstractPage(WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenu(webDriver);
    }

    public CatalogComponent openCatalog() {
        return header.openCatalog();
    }

    public void sendKeysToSearchInputField(String searchText) {
        header.sendKeysToSearchInputField(searchText);
    }

    public void clickToSearchButton() {
        header.clickToSearchButton();
    }

    protected void open(String url) {
        webDriver.navigate().to(BASE_URL + url);
    }
}
