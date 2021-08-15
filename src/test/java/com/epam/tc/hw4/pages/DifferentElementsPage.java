package com.epam.tc.hw4.pages;

import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.components.LeftMenu;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {
    WebDriver webDriver;
    private final HeaderMenu headerMenu;
    private final LeftMenu leftMenu;

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

    public DifferentElementsPage(WebDriver webDriver1) {
        PageFactory.initElements(webDriver1, this);
        this.webDriver = webDriver1;
        headerMenu = new HeaderMenu(webDriver1);
        leftMenu = new LeftMenu(webDriver1);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public String getUserName() {
        return userName.getText();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public void chooseCheckBox(String boxName) {
        checkBoxes.stream()
                  .filter(i -> i.getText().contains(boxName))
                  .collect(Collectors.toList()).get(0).click();
    }

    public void chooseRadio(String radioName) {
        radioButtons.stream()
                    .filter(i -> i.getText().contains(radioName))
                    .collect(Collectors.toList()).get(0).click();
    }

    public void chooseDropdown(String color) {
        dropdown.click();
        webDriver.switchTo().activeElement();
        dropdownColors.stream()
                      .filter(i -> i.getText().contains(color))
                      .collect(Collectors.toList()).get(0).click();
    }

    public boolean findInLog(String elementName) {
        return logRows.stream().anyMatch(i -> i.getText().contains(elementName));
    }
}
