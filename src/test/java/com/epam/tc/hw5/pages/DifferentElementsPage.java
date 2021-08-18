package com.epam.tc.hw5.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw5.components.HeaderMenu;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='profile-photo'][1]")
    private WebElement signInIcon;
    @FindBy(xpath = "//span[@id='user-name']")
    private WebElement userName;
    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkBoxes;
    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtons;
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropdown;
    @FindBy(tagName = "option")
    private List<WebElement> dropdownColors;
    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logRows;

    private final HeaderMenu headerMenu;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        this.headerMenu = new HeaderMenu(webDriver);
    }

    public List<WebElement> getLogRows() {
        return logRows;
    }

    public void open() {
        open("different-elements.html");
    }

    public void chooseCheckBox(String boxName) {
        wait.until(visibilityOfAllElements(checkBoxes))
            .stream()
            .filter(i -> i.getText().contains(boxName))
            .collect(Collectors.toList()).stream().findFirst().get().click();
    }

    public void chooseRadio(String radioName) {
        wait.until(visibilityOfAllElements(radioButtons))
            .stream()
            .filter(i -> i.getText().contains(radioName))
            .collect(Collectors.toList()).stream().findFirst().get().click();
    }

    public void chooseDropdown(String color) {
        wait.until(ExpectedConditions.visibilityOf(dropdown)).click();
        webDriver.switchTo().activeElement();
        wait.until(visibilityOfAllElements(dropdownColors))
            .stream()
            .filter(i -> i.getText().contains(color))
            .collect(Collectors.toList()).stream().findFirst().get().click();
    }

    public boolean findInLog(String elementName) {
        return logRows.stream().anyMatch(i -> i.getText().contains(elementName));
    }

}
