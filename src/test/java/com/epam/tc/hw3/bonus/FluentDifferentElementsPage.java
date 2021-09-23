package com.epam.tc.hw3.bonus;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw3.pages.AbstractPage;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FluentDifferentElementsPage extends AbstractPage {

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkBoxes;
    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtons;
    @FindBy(tagName = "select")
    private WebElement dropdown;
    @FindBy(tagName = "option")
    private List<WebElement> dropdownColors;
    @FindBy(className = "info-panel-section")
    private List<WebElement> logSection;
    @FindBy(css = ".panel-body-list.logs")
    private List<WebElement> logRows;

    public FluentDifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public FluentDifferentElementsPage chooseCheckBox(String boxName) {
        wait.until(visibilityOfAllElements(checkBoxes))
            .stream()
            .filter(i -> i.getText().contains(boxName))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow().click();
        return this;
    }

    public FluentDifferentElementsPage chooseRadio(String radioName) {
        wait.until(visibilityOfAllElements(radioButtons))
            .stream()
            .filter(i -> i.getText().contains(radioName))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow().click();
        return this;
    }

    public FluentDifferentElementsPage chooseDropdown(String color) {
        wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
        webDriver.switchTo().activeElement();
        wait.until(visibilityOfAllElements(dropdownColors))
            .stream()
            .filter(i -> i.getText().contains(color))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow().click();
        return this;
    }

    public boolean findInLog(String elementName) {
        return wait.until(visibilityOfAllElements(logRows))
                   .stream().anyMatch(i -> i.getText().contains(elementName));
    }

    public String getLogBodyText() {
        return wait.until(visibilityOfAllElements(logSection))
                   .stream().map(WebElement::getText).collect(Collectors.joining(""));
    }
}
