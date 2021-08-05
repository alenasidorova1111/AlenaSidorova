package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "twoPositiveValuesForAddOperationTests")
    public static Object[][] twoPositiveValuesForAddOperationTests() {
        return new Object[][] {
            {1L, 2L, 3L},
            {3L, 10L, 13L},
            {1000L, 1L, 1001L},
        };
    }

    @DataProvider(name = "twoPositiveValuesForDivideOperationTests")
    public static Object[][] twoPositiveValuesForDivideOperationTests() {
        return new Object[][] {
            {1L, 1L, 1.0},
            {1L, 2L, 0.5},
            {16L, 4L, 4.0},
        };
    }

    @DataProvider(name = "twoPositiveValuesForMultiplyOperationTests")
    public static Object[][] twoPositiveValuesForMultiplyOperationTests() {
        return new Object[][] {
            {1L, 1L, 1L},
            {1L, 2L, 2L},
            {2L, 2L, 4L},
        };
    }

    @DataProvider(name = "twoPositiveValuesForSubtractOperationTests")
    public static Object[][] twoPositiveValuesForSubtractOperationTests() {
        return new Object[][] {
            {2L, 1L, 1L},
            {10L, 3L, 7L},
            {1L, 100L, -99L},
        };
    }
}
