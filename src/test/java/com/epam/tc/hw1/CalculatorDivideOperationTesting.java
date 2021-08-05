package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorDivideOperationTesting extends CalculatorOperationsTesting {

    @Test(dataProvider = "twoPositiveValuesForDivideOperationTests", dataProviderClass = DataProviders.class,
          groups = {"multipleAndDivideOperationsTests"})
    public void testTwoPositiveValues(long a, long b, double expected) {
        double actual = (double) calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
