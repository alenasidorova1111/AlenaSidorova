package com.epam.tc.hw4.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class DataProvidersForPageObject {

    @DataProvider(name = "twoForcesMetalColor")
    public static Object[][] twoForcesMetalColor() {
        String login = getProperty("login", "src/test/resources/conf.properties");
        String password = getProperty("password", "src/test/resources/conf.properties");
        String pageTitle = "Home Page";
        String userName = "ROMAN IOVLEV";
        return new Object[][] {
            {login, password, pageTitle, userName, "Water", "Wind", "Selen", "Yellow"},
            {login, password, pageTitle, userName, "Fire", "Earth", "Bronze", "Green"},
        };
    }

    @DataProvider(name = "dataForHomePageTest")
    public static Object[][] dataForHomePageTest() {
        String login = getProperty("login", "src/test/resources/conf.properties");
        String password = getProperty("password", "src/test/resources/conf.properties");
        String pageTitle = "Home Page";
        String userName = "ROMAN IOVLEV";
        List<String> headerMenuButtons = Arrays.asList(
            "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> leftMenuButtons = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<String> benefitTexts = Arrays.asList("To include good practices\n"
                + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
            "To be multiplatform", "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…");

        return new Object[][] {
            {login, password, pageTitle, userName, headerMenuButtons, benefitTexts, leftMenuButtons},
        };
    }

    @DataProvider(name = "dataForHomePageFailedTest")
    public static Object[][] dataForHomePageFailedTest() {
        String login = getProperty("login", "src/test/resources/conf.properties");
        String password = getProperty("password", "src/test/resources/conf.properties");
        String pageTitle = "Home Page";
        String userName = "Ramen ILove";
        List<String> headerMenuButtons = Arrays.asList(
            "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> leftMenuButtons = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<String> benefitTexts = Arrays.asList("To include good practices\n"
                + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
            "To be multiplatform", "Already have good base\n" + "(about 20 internal and\n"
                + "some external projects),\n" + "wish to get more…");

        return new Object[][] {
            {login, password, pageTitle, userName, headerMenuButtons, benefitTexts, leftMenuButtons},
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
