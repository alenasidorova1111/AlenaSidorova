package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.WebdriverSettings;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class GithubPageSeleniumTestsEx2 extends WebdriverSettings {

    @Test
    public void differentElementsPageTest() {
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

        // 5. Open through the header menu Service -> Different Elements Page
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8'][1]/li[3]")))).click();
        webDriver.switchTo().activeElement();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//a[contains(text(),'Different elements')]")))).click();

        // 6. Select checkboxes
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//label[normalize-space()='Water']")))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//label[normalize-space()='Wind']")))).click();

        // 7. Select radio
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//label[normalize-space()='Selen']")))).click();

        // 8. Select in dropdown
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//select[@class='uui-form-element']")))).click();
        webDriver.switchTo().activeElement();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(
            webDriver.findElement(By.xpath("//option[normalize-space()='Yellow']")))).click();

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // - for radio button there is a log row and value is corresponded to the status of radio button
        // - for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logRows = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(
            webDriver.findElements(By.xpath("//ul[@class='panel-body-list logs']/li"))));
        soft.assertThat(logRows.get(0).getText()).contains("Yellow");
        soft.assertThat(logRows.get(1).getText()).contains("Selen");
        soft.assertThat(logRows.get(2).getText()).contains("Wind");
        soft.assertThat(logRows.get(3).getText()).contains("Water");

        // 10. Close Browser !! MADE IN src\test\java\com\epam\tc\hw2\WebdriverSettings.java

        soft.assertAll();
    }
}

