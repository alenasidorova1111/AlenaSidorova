package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractOperationTesting {
    protected Calculator calculator = new Calculator();

    @DataProvider(name = "twoPositiveValues")
    public Object[][] twoPositiveValues() {
        return new Long[][] {
            {2L, 1L},
            {10L, 3L},
            {1L, 100L},
        };
    }

    @Test(dataProvider = "twoPositiveValues", groups = {"addAndSubtractOperationsTests"})
    public void testTwoPositiveValues(Long a, Long b) {
        Long expected = a - b;
        Long actual = calculator.sub(a, b);
        assertEquals(expected, actual);
    }
}
