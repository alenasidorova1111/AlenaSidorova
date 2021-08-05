package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorSubtractOperationTesting extends CalculatorOperationsTesting {

    @Test(dataProvider = "twoPositiveValuesForSubtractOperationTests", dataProviderClass = DataProviders.class,
          groups = {"addAndSubtractOperationsTests"})
    public void testTwoPositiveValues(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
