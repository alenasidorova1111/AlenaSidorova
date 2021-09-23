package com.epam.tc.hw4.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DifferentElementsPage extends AbstractPage {

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

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Select checkbox {boxName}")
    public void chooseCheckBox(String boxName) {
        wait.until(visibilityOfAllElements(checkBoxes))
            .stream()
            .filter(i -> i.getText().contains(boxName))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow().click();
    }

    @Step("Select radio {radioName}")
    public void chooseRadio(String radioName) {
        wait.until(visibilityOfAllElements(radioButtons))
            .stream()
            .filter(i -> i.getText().contains(radioName))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow().click();
    }

    @Step("Select in dropdown {color}")
    public void chooseDropdown(String color) {
        wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
        webDriver.switchTo().activeElement();
        wait.until(visibilityOfAllElements(dropdownColors))
            .stream()
            .filter(i -> i.getText().contains(color))
            .collect(Collectors.toList()).stream().findFirst().orElseThrow().click();
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