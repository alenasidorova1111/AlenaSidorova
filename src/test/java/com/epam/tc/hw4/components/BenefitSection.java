package com.epam.tc.hw4.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BenefitSection {

    @FindBy(css = ".benefit-icon")
    public List<WebElement> benefitImages;
    @FindBy(css = ".benefit-txt")
    public List<WebElement> benefitTexts;

    public BenefitSection(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public String getBenefitText(int elementNumber) {
        return benefitTexts.get(elementNumber).getText();
    }

    public boolean checkAllImagesDisplayed() {
        return benefitImages.stream().allMatch(WebElement::isDisplayed);
    }
}
