package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    // Exercise 1
    @Given("I open Home page")
    public void openHomePage() {
        homePage.open();
    }

    @Given("I perform login")
    public void login() {
        homePage.getHeaderMenu().login();
    }

    @Given("I navigate to Different Elements page through header menu")
    public void navigateToDifferentElementsPage() {
        homePage.getHeaderMenu().openDifferentElementsPage();
    }

    // Exercise 2
    @Given("I open JDI GitHub site")
    public void openGitHubSite() {
        homePage.open();
    }

    @And("I login as user \"Roman Iovlev\"")
    public void loginAsUser() {
        homePage.getHeaderMenu().login();
    }

}
