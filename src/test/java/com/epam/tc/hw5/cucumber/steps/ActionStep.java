package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.When;
import java.util.Arrays;

public class ActionStep extends AbstractStep {

    @When("I choose {string} force1 and {string} force2")
    public void chooseForces(String force1, String force2) {
        dep.chooseCheckBox(force1);
        dep.chooseCheckBox(force2);

        TestContext.getInstance().addTestObject("chosen_forces", Arrays.asList(force1, force2));
    }

    @When("I choose {string} metal")
    public void chooseMetal(String metal) {
        dep.chooseRadio(metal);

        TestContext.getInstance().addTestObject("chosen_metal", metal);
    }

    @When("I choose {string} color")
    public void chooseColor(String color) {
        dep.chooseDropdown(color);

        TestContext.getInstance().addTestObject("chosen_color", color);
    }
}
