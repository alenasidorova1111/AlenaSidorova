package com.epam.tc.hw3.utils;

import org.testng.annotations.DataProvider;

public class DataProvidersForPageObject {

    @DataProvider(name = "twoForcesMetalColor")
    public static Object[][] twoForcesMetalColor() {
        return new Object[][] {
            {"Water", "Wind", "Selen", "Yellow"},
            {"Fire", "Earth", "Bronze", "Red"},
        };
    }
}
