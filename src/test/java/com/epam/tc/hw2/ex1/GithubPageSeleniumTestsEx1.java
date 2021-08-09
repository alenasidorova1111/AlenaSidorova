package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.WebdriverSettings;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class GithubPageSeleniumTestsEx1 extends WebdriverSettings {

    @Test
    public void homePageTest() {
        // 1. Open test site by URL
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        soft.assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        // 3. Perform login
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//*[@class='profile-photo'][1]")))).click();
        webDriver.switchTo().activeElement();
        webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath("//input[@id='name'][1]")))).sendKeys("Roman");
        webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath("//input[@id='password'][1]")))).sendKeys("Jdi1234");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//button[@id='login-button'][1]")))).click();

        // 4. Assert Username is loggined
        String userName = webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath("//span[@id='user-name']")))).getText();
        soft.assertThat(userName).isEqualTo("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
                webDriver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8'][1]/li"))));
        List<WebElement> menuTabs = webDriver.findElements(
            By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8'][1]/li"));
        soft.assertThat(menuTabs.size()).isEqualTo(4);
        soft.assertThat(menuTabs.get(0).getText()).isEqualTo("HOME");
        soft.assertThat(menuTabs.get(1).getText()).isEqualTo("CONTACT FORM");
        soft.assertThat(menuTabs.get(2).getText()).isEqualTo("SERVICE");
        soft.assertThat(menuTabs.get(3).getText()).isEqualTo("METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector(".benefit-icon"))));
        List<WebElement> images = webDriver.findElements(By.cssSelector(".benefit-icon"));
        soft.assertThat(images.size()).isEqualTo(4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.cssSelector(".benefit-txt"))));
        List<WebElement> texts = webDriver.findElements(By.cssSelector(".benefit-txt"));
        soft.assertThat(texts.get(0).getText()).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        soft.assertThat(texts.get(1).getText()).isEqualTo("To be flexible and\n"
            + "customizable");
        soft.assertThat(texts.get(2).getText()).isEqualTo("To be multiplatform");
        soft.assertThat(texts.get(3).getText()).isEqualTo("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = webDriverWait.until(ExpectedConditions.visibilityOf(
            webDriver.findElement(By.xpath("//iframe[@id='frame']"))));
        soft.assertThat((iframe).isDisplayed()).isEqualTo(true);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        soft.assertThat(webDriver.findElement(By.xpath(
            "//input[@value='Frame Button']")).isDisplayed()).isEqualTo(true);

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenu = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.xpath("//ul[@class='sidebar-menu left']/li/a"))));
        soft.assertThat(leftMenu.size()).isEqualTo(5);
        soft.assertThat(leftMenu.get(0).getText()).isEqualTo("Home");
        soft.assertThat(leftMenu.get(1).getText()).isEqualTo("Contact form");
        soft.assertThat(leftMenu.get(2).getText()).isEqualTo("Service");
        soft.assertThat(leftMenu.get(3).getText()).isEqualTo("Metals & Colors");
        soft.assertThat(leftMenu.get(4).getText()).isEqualTo("Elements packs");

        // 12. Close Browser !! MADE IN src\test\java\com\epam\tc\hw2\WebdriverSettings.java

        soft.assertAll();
    }
}
