package com.epam.tc.hw5.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserTablePage extends AbstractPage {

    private static final String URL = "user-table.html";

    @FindBy(tagName = "select")
    private List<WebElement> typeDropdowns;
    @FindBy(css = "tr>td>a")
    private List<WebElement> usernames;
    @FindBy(className = "user-descr")
    private List<WebElement> descriptionTexts;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;
    @FindBy(css = "tr")
    private List<WebElement> userTableRows;
    @FindBy(tagName = "select")
    private List<WebElement> dropdowns;
    @FindBy(id = "ivan")
    private WebElement checkboxSergeyIvan;
    @FindBy(className = "info-panel-section")
    private List<WebElement> logSection;
    @FindBy(id = "user-table")
    private WebElement userTable;
    @FindBy(css = ".panel-body-list.logs")
    private List<WebElement> logRows;

    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getTypeDropdowns() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(typeDropdowns));
    }

    public List<WebElement> getUsernames() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(usernames));
    }

    public List<WebElement> getDescriptionTexts() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(descriptionTexts));
    }

    public List<WebElement> getCheckboxes() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(checkboxes));
    }

    public String getUserTableText() {
        return wait.until(visibilityOf(userTable)).getText()
                   .replaceAll("\n", " ");
    }

    public List<String> getDropdownsValuesForUserRoman() {
        List<WebElement> allDropdowns = wait.until(ExpectedConditions.visibilityOfAllElements(dropdowns));
        List<WebElement> exactDropdown = allDropdowns.stream().findFirst().get().findElements(By.tagName("option"));
        return exactDropdown.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void chooseCheckBoxForSergeyIvan() {
        wait.until(ExpectedConditions.visibilityOf(checkboxSergeyIvan)).click();
    }

    public String getLogBodyText() {
        return wait.until(visibilityOfAllElements(logSection))
                   .stream().map(WebElement::getText).collect(Collectors.joining(""));
    }

    public List<WebElement> getLogRows() {
        return wait.until(visibilityOfAllElements(logRows));
    }
}
