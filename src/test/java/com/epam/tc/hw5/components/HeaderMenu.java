package com.epam.tc.hw5.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.epam.tc.hw5.pages.DifferentElementsPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractComponent {

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8'][1]/li")
    public List<WebElement> headerButtons;
    @FindBy(xpath = "//ul[@role='menu']/li")
    public List<WebElement> serviceMenuButtons;

    public HeaderMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public String getButtonName(int elementNumber) {
        return headerButtons.get(elementNumber).getText();
    }

    public void clickButton(List<WebElement> buttonsType, String buttonName) {
        wait.until(visibilityOfAllElements(buttonsType))
            .stream().filter(i -> i.getText().equals(buttonName))
            .findFirst().orElse(null).click();
    }

    public DifferentElementsPage openDifferentElementsPage() {
        clickButton(headerButtons, "SERVICE");
        clickButton(serviceMenuButtons, "DIFFERENT ELEMENTS");
        return new DifferentElementsPage(webDriver);
    }
}
