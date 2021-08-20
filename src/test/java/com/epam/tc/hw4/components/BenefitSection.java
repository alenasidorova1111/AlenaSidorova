package com.epam.tc.hw4.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BenefitSection extends AbstractComponent {

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitImages;
    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTexts;

    public BenefitSection(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getBenefitImages() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitImages));
    }

    public List<WebElement> getBenefitTextElements() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts));
    }

    public List<String> getBenefitTexts() {
        return wait.until(visibilityOfAllElements(benefitTexts))
                   .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean areAllImagesDisplayed() {
        return getBenefitImages().stream().allMatch(WebElement::isDisplayed);
    }
}
