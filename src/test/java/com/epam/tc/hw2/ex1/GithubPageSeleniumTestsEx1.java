package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class GithubPageSeleniumTestsEx1 extends BaseTest {

    @Test
    public void homePageTest() {
        SoftAssertions softly = new SoftAssertions();

        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softly.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.id("user-icon")))).click();
        webDriver.switchTo().activeElement();
        webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.id("name")))).sendKeys("Roman");
        webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.id("password")))).sendKeys("Jdi1234");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.id("login-button")))).click();

        // 4. Assert Username is loggined
        String userName = webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.id("user-name")))).getText();
        softly.assertThat(userName).isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuTabs = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector("header ul.navbar-nav.m-l8 > li"))));
        List<String> expectedMenuTabs = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        softly.assertThat(menuTabs).hasSize(4);
        softly.assertThat(menuTabs.stream().map(WebElement::getText).collect(Collectors.toList()))
            .containsExactlyElementsOf(expectedMenuTabs);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector(".benefit-icon"))));
        softly.assertThat(images).hasSize(4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> texts = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector(".benefit-txt"))));
        List<String> expectedTexts = Arrays.asList(
            "To include good practices\n" + "and ideas from successful\n" + "EPAM project",
            "To be flexible and\n" + "customizable",
            "To be multiplatform",
            "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n"
                + "wish to get more???");

        softly.assertThat(texts.stream().map(WebElement::getText).collect(Collectors.toList()))
            .containsExactlyElementsOf(expectedTexts);

        // 8. Assert that there is the iframe with ???Frame Button??? exist
        WebElement iframe = webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.id("frame"))));
        softly.assertThat((iframe).isDisplayed()).isEqualTo(true);

        // 9. Switch to the iframe and check that there is ???Frame Button??? in the iframe
        webDriver.switchTo().frame("frame");
        softly.assertThat(webDriver.findElement(By.xpath(
            "//input[@value='Frame Button']")).isDisplayed()).isEqualTo(true);

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenu = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.xpath("//ul[@class='sidebar-menu left'][1]/li/a"))));
        List<String> expectedLeftMenu = Arrays.asList("Home", "Contact form",
            "Service", "Metals & Colors", "Elements packs");

        softly.assertThat(leftMenu).hasSize(5);
        softly.assertThat(leftMenu.stream().map(WebElement::getText).collect(Collectors.toList()))
            .containsExactlyElementsOf(expectedLeftMenu);

        // 12. Close Browser !! MADE IN src\test\java\com\epam\tc\hw2\BaseTest.java

        softly.assertAll();
    }
}
