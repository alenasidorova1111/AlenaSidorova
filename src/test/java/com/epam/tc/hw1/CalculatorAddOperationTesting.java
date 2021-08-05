package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorAddOperationTesting extends CalculatorOperationsTesting {

    @Test(dataProvider = "twoPositiveValuesForAddOperationTests", dataProviderClass = DataProviders.class,
          groups = {"addAndSubtractOperationsTests"})
    public void testTwoPositiveValues(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
