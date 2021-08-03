package com.epam.tc.hw1;

import static org.testng.AssertJUnit.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyOperationTesting {
    protected Calculator calculator = new Calculator();

    @DataProvider(name = "twoPositiveValues")
    public Object[][] twoPositiveValues() {
        return new Long[][] {
            {1L, 1L},
            {1L, 2L},
            {2L, 2L},
        };
    }

    @Test(dataProvider = "twoPositiveValues", groups = {"multipleAndDivideOperationsTests"})
    public void testTwoPositiveValues(Long a, Long b) {
        Long expected = a * b;
        Long actual = calculator.mult(a, b);
        assertEquals(expected, actual);
    }
}
