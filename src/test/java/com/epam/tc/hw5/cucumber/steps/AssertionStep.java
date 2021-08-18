package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    SoftAssertions softly = new SoftAssertions();

    @Then("For every chosen item there is a log row")
    public void allChosenForcesAreSelected() {
        List<String> chosenForces = TestContext.getInstance().getTestObject("chosen_forces");
        String chosenMetal = TestContext.getInstance().getTestObject("chosen_metal");
        String chosenColor = TestContext.getInstance().getTestObject("chosen_color");

        softly.assertThat(dep.getLogRows().stream().map(WebElement::getText).collect(Collectors.toList()))
              .asString().contains(chosenForces);

        softly.assertThat(dep.getLogRows().stream().map(WebElement::getText).collect(Collectors.joining("")))
              .contains(chosenMetal);

        softly.assertThat(dep.getLogRows().stream().map(WebElement::getText).collect(Collectors.joining("")))
              .contains(chosenColor);

        softly.assertAll();
    }
}
