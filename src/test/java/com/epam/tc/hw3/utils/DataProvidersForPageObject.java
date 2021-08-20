package com.epam.tc.hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class DataProvidersForPageObject {

    @DataProvider(name = "twoForcesMetalColor")
    public static Object[][] twoForcesMetalColor() {
        return new Object[][] {
            {"Water", "Wind", "Selen", "Yellow"},
            {"Fire", "Earth", "Bronze", "Green"},
        };
    }

    protected static Properties PROPERTIES;

    public static String getProperty(String key) {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/conf.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty(key);
    }
}
