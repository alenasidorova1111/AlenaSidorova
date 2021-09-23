package com.epam.tc.hw3.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends AbstractComponent {

    @FindBy(css = ".sidebar-menu.left>li")
    private List<WebElement> menuButtons;

    public LeftMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean areAllButtonsDisplayed() {
        return wait.until(visibilityOfAllElements(menuButtons)).stream().allMatch(WebElement::isDisplayed);
    }

    public List<String> getButtonsNames() {
        return wait.until(visibilityOfAllElements(menuButtons))
                   .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getMenuButtons() {
        return wait.until(visibilityOfAllElements(menuButtons));
    }
}
