package com.epam.tc.hw5.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProviderForCucumberTests {
    protected static Properties PROPERTIES;

    public static String getProperty(String key) {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/testng/conf.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty(key);
    }
}
