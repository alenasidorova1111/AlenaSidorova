package com.epam.tc.hw3.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class DataProvidersForPageObject {

    @DataProvider(name = "twoForcesMetalColor")
    public static Object[][] twoForcesMetalColor() {
        String login = getProperty("login", "src/test/resources/conf.properties");
        String password = getProperty("password", "src/test/resources/conf.properties");
        return new Object[][] {
            {"Water", "Wind", "Selen", "Yellow", login, password},
            {"Fire", "Earth", "Bronze", "Green", login, password},
        };
    }

    @DataProvider(name = "loginPassword")
    public static Object[][] loginPassword() {
        String login = getProperty("login", "src/test/resources/conf.properties");
        String password = getProperty("password", "src/test/resources/conf.properties");
        return new Object[][] {
            {login, password},
            {login, password},
        };
    }

    protected static Properties PROPERTIES;

    public static String getProperty(String key, String path) {

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty(key);
    }


}
