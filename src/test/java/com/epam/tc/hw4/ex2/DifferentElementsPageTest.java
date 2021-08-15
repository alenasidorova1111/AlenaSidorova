package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.utils.BaseTest;
import com.epam.tc.hw4.utils.DataProvidersForPageObject;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

@Feature(value = "Different Elements page")
@Story(value = "User can login, go to Different Elements page and choose its elements")
public class DifferentElementsPageTest extends BaseTest {

    SoftAssertions soft = new SoftAssertions();

    @Test
    @Step("Check Home page title")
    public void testHomePageTitle() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        soft.assertThat(homePage.getPageTitle()).isEqualTo("Home Page");
    }

    @Test
    @Step("Check logging process was successful")
    public void testLoginProcess() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        homePage.login();
        soft.assertThat(homePage.getUserName()).isEqualTo("ROMAN IOVLEV");
    }

    @Test
    @Step("Open Different Elements page and its title")
    public void testDifferentElementsPageTitle() {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        homePage.goToDifferentElementsPage();
        DifferentElementsPage dep = new DifferentElementsPage(webDriver);
        soft.assertThat(dep.getPageTitle()).isEqualTo("Different Elements");
    }

    @Test(dataProvider = "twoForcesMetalColor", dataProviderClass = DataProvidersForPageObject.class)
    @Step("Choose different elements and check they have log rows")
    public void testDifferentElements(String force1, String force2, String metal, String color) {
        HomePage homePage = new HomePage(webDriver);
        homePage.openPage();
        homePage.login();
        homePage.goToDifferentElementsPage();
        DifferentElementsPage dep = new DifferentElementsPage(webDriver);

        dep.chooseCheckBox(force1);
        dep.chooseCheckBox(force2);
        dep.chooseRadio(metal);
        dep.chooseDropdown(color);

        soft.assertThat(dep.findInLog(force1)).isTrue();
        soft.assertThat(dep.findInLog(force2)).isTrue();
        soft.assertThat(dep.findInLog(metal)).isTrue();
        soft.assertThat(dep.findInLog(color)).isTrue();
    }
}
