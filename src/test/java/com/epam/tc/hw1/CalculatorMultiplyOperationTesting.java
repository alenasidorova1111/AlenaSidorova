package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorMultiplyOperationTesting extends CalculatorOperationsTesting {

    @Test(dataProvider = "twoPositiveValuesForMultiplyOperationTests", dataProviderClass = DataProviders.class,
          groups = {"multipleAndDivideOperationsTests"})
    public void testTwoPositiveValues(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
