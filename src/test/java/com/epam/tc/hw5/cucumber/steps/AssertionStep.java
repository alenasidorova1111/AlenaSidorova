package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;

public class AssertionStep extends AbstractStep {

    // Exercise 1
    @Then("For every chosen item there is a log row")
    public void allChosenForcesAreSelected() {
        SoftAssertions softly = new SoftAssertions();

        List<String> chosenForces = TestContext.getInstance().getTestObject("chosen_forces");
        String chosenMetal = TestContext.getInstance().getTestObject("chosen_metal");
        String chosenColor = TestContext.getInstance().getTestObject("chosen_color");

        softly.assertThat(dep.getLogBodyText()).contains(chosenForces);
        softly.assertThat(dep.getLogBodyText()).contains(chosenMetal);
        softly.assertThat(dep.getLogBodyText()).contains(chosenColor);
        softly.assertAll();
    }

    // Exercise 2
    @Then("\"User Table\" page should be opened")
    public void testUserPageOpened() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getTitle()).isEqualTo("User Table");
        softly.assertAll();
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void testSixNumberDropdownsAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getTypeDropdowns()).hasSize(6);
        softly.assertAll();
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void testSixUsernamesAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getUsernames()).hasSize(6);
        softly.assertAll();
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void testSixDescriptionTextsAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getDescriptionTexts()).hasSize(6);
        softly.assertAll();
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void testSixCheckboxesAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getCheckboxes()).hasSize(6);
        softly.assertAll();
    }

    @And("User table should contain following {string} number, {string} user, {string} description")
    public void testUserTableContainsValues(String number, String user, String description) {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getUserTableText()).contains(Arrays.asList(number, user, description));
        softly.assertAll();
    }

    @And("droplist should contain {string} values in column Type for user Roman")
    public void testDroplistContainsValuesInColumnTypeForUserRoman(String value) {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getDropdownsValuesForUserRoman()).contains(value);
        softly.assertAll();
    }

    // Exercise 3
    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void testLogRowHasTextInLogSection() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(utp.getLogRows()).hasSize(1);
        softly.assertThat(utp.getLogBodyText()).contains("Vip: condition changed to true");
        softly.assertAll();
    }
}
